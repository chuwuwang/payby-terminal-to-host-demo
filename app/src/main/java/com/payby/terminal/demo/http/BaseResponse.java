package com.payby.terminal.demo.http;

public class BaseResponse<T> {
    private T body;
    private ResponseHeader header;

    public BaseResponse() {
        this.header = null;
        this.body = null;
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

    @Override
    public String toString() {
        return "BaseResponse{" +
                "body=" + body +
                ", header=" + header +
                '}';
    }
}
