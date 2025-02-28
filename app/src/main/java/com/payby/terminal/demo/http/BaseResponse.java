package com.payby.terminal.demo.http;

public class BaseResponse<T> {
    private T body;
    private ResponseHeader header;

    public BaseResponse(ResponseHeader header, T data) {
        this.header = header;
        this.body = data;
    }

    public ResponseHeader getHeader() {
        return header;
    }
    public void setHeader(ResponseHeader responseHeader) {
        this.header = responseHeader;
    }

    public T getBody() {
        return body;
    }
    public void setBody(T data) {
        this.body = data;
    }
}
