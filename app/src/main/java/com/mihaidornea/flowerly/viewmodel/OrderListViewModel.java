package com.mihaidornea.flowerly.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.mihaidornea.flowerly.service.model.OrderEntry;
import com.mihaidornea.flowerly.service.repository.OrderRepository;

import java.util.List;

public class OrderListViewModel extends ViewModel {

    private final LiveData<List<OrderEntry>> orderListObservable;

    public OrderListViewModel() {
        orderListObservable = OrderRepository.getInstance().getOrders();
    }

    public LiveData<List<OrderEntry>> getOrderListObservable() {
        return orderListObservable;
    }
}
