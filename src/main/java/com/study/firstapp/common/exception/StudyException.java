package com.study.firstapp.common.exception;

public class StudyException extends Exception {
    private static final long serialVersionUID = 6270116931011412328L;

    private final ErrorCode errorCode;

    public StudyException(ErrorCode errorCode) {
        super();
        this.errorCode = errorCode;
    }

    public StudyException(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public StudyException(String message, Throwable cause, ErrorCode errorCode) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public StudyException(Throwable cause, ErrorCode errorCode) {
        super(cause);
        this.errorCode = errorCode;
    }

    public StudyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, ErrorCode errorCode) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.errorCode = errorCode;
    }
}
