package com.mihaidornea.flowerly.service.repository;

import com.mihaidornea.flowerly.service.model.OrderEntry;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface OrderService {

    String HTTP_ORDER_GET_URL = "http://demo2957259.mockable.io/flowerly/";

    @GET("getOrders")
    Call<List<OrderEntry>> getOrderList();

}
