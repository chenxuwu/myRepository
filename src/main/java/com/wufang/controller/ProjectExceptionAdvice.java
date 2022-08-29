package com.wufang.controller;

import com.wufang.controller.utils.Code;
import com.wufang.controller.utils.R;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice //springMvc异常处理器
public class ProjectExceptionAdvice {

    @ExceptionHandler
    public R doException(Exception ex){
        ex.printStackTrace();
        return new R(Code.SYSTEM_UNKNOW,null,"服务器繁忙，请稍后再试！");
    }
}
