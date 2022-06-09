package com.sw.exceptions;

public class DBConnectionException extends Exception {

    private String message;

    public DBConnectionException(String msg) {
        this.message = msg;
    }


}
