package com.payby.terminal.demo.http;

import android.net.http.BidirectionalStream;

public class Result<T> {
    private final T data;
    private final Throwable error;
    private final boolean isSuccess;

    private Result(T data, Throwable error, boolean isSuccess) {
        this.data = data;
        this.error = error;
        this.isSuccess = isSuccess;
    }

    public static <T> Result<T> onSuccess(T data) {
        return new Result<>(data, null, true);
    }

    public static <T> Result<T> onFailure(Throwable error) {
        return new Result<>(null, error, false);
    }

    public T getData() {
        return data;
    }

    public Throwable getError() {
        return error;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

}
