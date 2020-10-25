package com.shuihu.boss.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResponse<T> implements Serializable {
    private Integer code;
    private String msg;
    private T date;
}
