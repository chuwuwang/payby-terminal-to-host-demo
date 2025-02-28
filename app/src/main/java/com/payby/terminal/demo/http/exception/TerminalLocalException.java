package com.payby.terminal.demo.http.exception;

public class TerminalLocalException extends  Exception{
    private final String code;
    private final String msg;

    public TerminalLocalException(String code, String msg) {
        super(code + " - " + msg);
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
