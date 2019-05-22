package com.mihaidornea.flowerly.service.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.mihaidornea.flowerly.service.model.OrderEntry;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class OrderRepository {

    private static final String TAG = OrderRepository.class.getName();

    private OrderService orderService;
    private static OrderRepository orderRepository;
    private final static Object LOCK = new Object();

    private OrderRepository() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(OrderService.HTTP_ORDER_GET_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        orderService = retrofit.create(OrderService.class);
    }

    public synchronized static OrderRepository getInstance() {
        if (orderRepository == null){
            synchronized (LOCK){
                orderRepository = new OrderRepository();
            }
        }
        return orderRepository;
    }

    public LiveData<List<OrderEntry>> getOrders(){
        final MutableLiveData<List<OrderEntry>> orders = new MutableLiveData<>();

        orderService.getOrderList().enqueue(new Callback<List<OrderEntry>>() {
            @Override
            public void onResponse(Call<List<OrderEntry>> call, Response<List<OrderEntry>> response) {
                orders.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<OrderEntry>> call, Throwable t) {
                Log.e(TAG, "onFailure: Something went wrong", t);

            }
        });
        return orders;
    }

}
