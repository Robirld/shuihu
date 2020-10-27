package com.shuihu.boss.config;

import com.shuihu.boss.entity.Page;
import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.Map;

/**
 * @Author user
 * @Date 2020/10/27 4:11 下午
 * @Version 1.0
 */
@Intercepts({
        @Signature(method = "prepare", type = StatementHandler.class, args = {Connection.class, Integer.class})
})
public class MySqlIntercepor implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        StatementHandler handler = (StatementHandler) invocation.getTarget();
        MetaObject metaStatementObject = SystemMetaObject.forObject(handler);
        Map<String, Object> paramsMap = (Map<String, Object>) handler.getParameterHandler().getParameterObject();
        if (paramsMap.containsKey("page")) {
            Page<?> page = (Page<?>) paramsMap.get("page");
            if (page == null) {
                page = new Page<>();
            }
            BoundSql boundSql = handler.getBoundSql();
            String sql = boundSql.getSql();

            Connection connection = (Connection) invocation.getArgs()[0];
            String countSql = generateCountSql(sql);
            int totalCount = getTotalCount(connection, countSql);
            page.setTotalRecord(totalCount);
            int n = totalCount / page.getPageSize();
            page.setTotalPage(totalCount % page.getPageSize() == 0 ? n : n + 1);

            String pageSql = generatePageSql(sql, page);
            metaStatementObject.setValue("delegate.boundSql.sql", pageSql);
        }
        return invocation.proceed();
    }

    private int getTotalCount(Connection connection, String countSql) throws SQLException {
        PreparedStatement statement = null;
        ResultSet rs = null;
        int count = 0;
        try {
            statement = connection.prepareStatement(countSql);
            rs = statement.executeQuery();
            if (rs.next()){
                count = rs.getInt(1);
            }
        } finally {
            if (statement != null){
                try {
                    statement.close();
                } catch (Exception e){
                    e.printStackTrace();
                }

            }
            if (rs != null){
                try {
                    rs.close();
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
        return count;
    }

    private String generateCountSql(String sql) {
        StringBuilder sb = new StringBuilder("select count(*) ");
        int from = sql.indexOf("from");
        int end = sql.lastIndexOf("order by");
        if (from > 0) {
            if (end > 0){
                sb.append(sql.substring(from, end));
            }else {
                sb.append(sql.substring(from));
            }
        }
        return sb.toString();
    }

    private String generatePageSql(String sql, Page<?> page) {
        StringBuilder sb = new StringBuilder(sql);
        sb.append(" limit ").append((page.getPageNo()-1) * page.getPageSize()).append(", ").append(page.getPageSize());
        return sb.toString();
    }

    @Override
    public Object plugin(Object target) {
        if (target instanceof StatementHandler){
            return Plugin.wrap(target, this);
        }else {
            return target;
        }
    }
}
