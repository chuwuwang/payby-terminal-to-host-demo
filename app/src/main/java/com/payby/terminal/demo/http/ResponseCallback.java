package com.payby.terminal.demo.http;

public interface ResponseCallback<T> {
    void onSuccess(T response);

    void onError(String error);

    void onFailure(Throwable throwable);
}
