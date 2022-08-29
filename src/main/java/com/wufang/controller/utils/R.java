package com.wufang.controller.utils;

import lombok.Data;

@Data
public class R {
    private Integer code;
    private Object data;
    private String msg;

    public R(Integer code, Object data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }
}
