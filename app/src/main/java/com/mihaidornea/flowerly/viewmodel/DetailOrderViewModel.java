package com.mihaidornea.flowerly.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.mihaidornea.flowerly.service.model.OrderEntry;

public class DetailOrderViewModel extends ViewModel {

    private MutableLiveData<OrderEntry> mOrder;

    public DetailOrderViewModel() {
        this.mOrder = new MutableLiveData<>();
    }

    public MutableLiveData<OrderEntry> getmOrderEntry() {
        return mOrder;
    }

    public void setOrder(OrderEntry orderEntry){
        mOrder.postValue(orderEntry);
    }

}
