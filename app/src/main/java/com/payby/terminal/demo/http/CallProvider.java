package com.payby.terminal.demo.http;

import retrofit2.Call;

public interface CallProvider {
    Call<Object> provide();
}
