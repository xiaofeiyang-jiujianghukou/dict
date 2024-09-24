package com.xiaofeiyang.dict.common.exception;

import com.xiaofeiyang.dict.common.enums.ResultEnum;

public class BizException extends RuntimeException {
    private final ResultEnum resultEnum;

    public ResultEnum getResultEnum() {
        return this.resultEnum;
    }

    public BizException(ResultEnum result) {
        super(result.getMessage());
        this.resultEnum = result;
    }

    public BizException(String message) {
        super(message);
        this.resultEnum = ResultEnum.BIZ_EXCEPTION;
    }

    public BizException(ResultEnum result, String message) {
        super(message);
        this.resultEnum = result;
    }
}
