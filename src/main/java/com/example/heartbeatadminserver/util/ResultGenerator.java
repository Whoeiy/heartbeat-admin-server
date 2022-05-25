package com.example.heartbeatadminserver.util;

public class ResultGenerator {
    private static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";
    private static final String DEFAULT_FAIL_MESSAGE = "FAIL";
    private static final int RESULT_CODE_SUCCESS = 200;
    private static final int RESULT_CODE_SERVER_ERROR = 500;

    public static Result genSuccessResult(){
        Result result = new Result();
        result.setCode(RESULT_CODE_SERVER_ERROR);
        result.setMessage(DEFAULT_SUCCESS_MESSAGE);
        return result;
    }
}


