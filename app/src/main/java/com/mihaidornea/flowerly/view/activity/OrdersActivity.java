package com.mihaidornea.flowerly.view.activity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.mihaidornea.flowerly.R;
import com.mihaidornea.flowerly.service.model.OrderEntry;
import com.mihaidornea.flowerly.view.adapter.OrdersAdapter;
import com.mihaidornea.flowerly.viewmodel.OrderListViewModel;

import java.util.ArrayList;
import java.util.List;

public class OrdersActivity extends AppCompatActivity implements OrdersAdapter.OrderAdapterOnItemClickHandler {

    public static final String ORDER_ENTRY_EXTRA = "ORDER_ENTRY_EXTRA";

    private RecyclerView recyclerView;
    private OrdersAdapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders);

        recyclerView = findViewById(R.id.recycler_view_orders);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new OrdersAdapter(this, this);
        recyclerView.setAdapter(mAdapter);

        final OrderListViewModel orderListViewModel = ViewModelProviders.of(this).get(OrderListViewModel.class);
        observeViewModel(orderListViewModel);

    }

    private void observeViewModel(OrderListViewModel orderListViewModel) {
        orderListViewModel.getOrderListObservable().observe(this, new Observer<List<OrderEntry>>() {
            @Override
            public void onChanged(@Nullable List<OrderEntry> orderEntries) {
                if (orderEntries != null){
                    mAdapter.setOrders(orderEntries);
                    mAdapter.notifyDataSetChanged();
                }
            }
        });
    }

    @Override
    public void onItemClick(OrderEntry orderEntry) {
        Intent intent = new Intent(this, DetailedOrderActivity.class);
        intent.putExtra(OrdersActivity.ORDER_ENTRY_EXTRA, orderEntry);
        startActivity(intent);
    }
}
