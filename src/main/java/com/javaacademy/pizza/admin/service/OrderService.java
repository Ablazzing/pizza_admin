package com.javaacademy.pizza.admin.service;

import lombok.SneakyThrows;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class OrderService {

    @SneakyThrows
    public void getAllOrders(OkHttpClient client) {
        Request request = new Request.Builder().get().url("http://localhost:8089/order").build();
        String responseBody = client.newCall(request).execute().body().string();
        System.out.println(responseBody);
    }
}
