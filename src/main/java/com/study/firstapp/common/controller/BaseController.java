package com.study.firstapp.common.controller;

public class BaseController {
    protected static final String PAGE_TITLE = "pageTitle";
    protected static final String MAP_FOR_RESULT = "result";
    protected static final String MAP_FOR_MESSAGE = "message";
    protected static final String MAP_FOR_EXCEPTION = "exception";
    protected static final String MAP_FOR_DETAIL = "detail";
    protected static final String MAP_FOR_STATUS = "status";
    protected static final String MAP_FOR_DATAS = "datas";
    protected static final String STR_DETAIL = "detail";
    protected static final String STR_ERROR = "Error";
    protected static final String STR_SUCCESS = "Success";
    protected static final String STR_FAILED = "Failed";
    protected static final String STR_AUTHNOTVALID = "Forbidden Access";
    protected static final String STR_DUCAPIL_EMPTY = "Data Ducapil Tidak Ditemukan";
    protected static final String STR_MATCH = "Data match";
    protected static final String STR_FAILED_MATCH = "Data Didn't match";
    protected static final String STR_UPDATE_PASSWORD = "Please Update Your Password First";
    protected static final String STR_DATA_KTP_NULL = "KTP must't be null";
    protected static final String STR_DATA_MOTHER_NAME_NULL = "Mother Name must't be null";
    protected static final String STR_AN_ERROR_OCCURED = "An Error Occurred";
    protected static final String ERROR_CODE = "errorCode";
    protected static final String ERROR_DESC = "errorDescription";
    protected static final int CODE_ALREADY_LOGGED_IN = 512;
    protected static final int CODE_ACCOUNT_IS_INACTIVE = 513;

    @Override
    public String toString() {
        return "BaseController{}";
    }
}