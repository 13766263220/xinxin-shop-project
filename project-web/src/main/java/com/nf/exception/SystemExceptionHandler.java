package com.nf.exception;

import com.nf.vo.ResponseVO;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class SystemExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public ResponseVO handlerRuntimeException(RuntimeException runtimeException){
        System.out.println(runtimeException.getMessage());

        return ResponseVO.builder().code("500").msg("服务器异常").build();
    }
}
