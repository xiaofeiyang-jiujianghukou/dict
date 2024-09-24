package com.xiaofeiyang.dict.common.processor;


import com.xiaofeiyang.dict.common.Result;
import com.xiaofeiyang.dict.common.exception.BizException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BizException.class)
    Result<?> handleBizException(BizException e) {
        return Result.fail(e.getResultEnum().getCode(), e.getMessage());
    }

}
