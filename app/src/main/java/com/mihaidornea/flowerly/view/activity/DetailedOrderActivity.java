package com.mihaidornea.flowerly.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.mihaidornea.flowerly.R;
import com.mihaidornea.flowerly.service.model.OrderEntry;

import org.w3c.dom.Text;

public class DetailedOrderActivity extends AppCompatActivity {

    private TextView orderIdView;
    private TextView sentByView;
    private TextView deliverToView;
    private TextView descriptionView;
    private TextView priceView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_orders);
        loadUiElements();

        OrderEntry orderEntry = (OrderEntry) getIntent().getSerializableExtra(OrdersActivity.ORDER_ENTRY_EXTRA);
        showOrderDetails(orderEntry);
    }

    private void showOrderDetails(OrderEntry orderEntry) {
        this.orderIdView.setText(String.valueOf(orderEntry.getId()));
        this.sentByView.setText(orderEntry.getSentBy());
        this.deliverToView.setText(orderEntry.getDeliverTo());
        this.descriptionView.setText(orderEntry.getDescription());
        this.priceView.setText(String.valueOf(orderEntry.getPrice()));
    }

    private void loadUiElements() {
        orderIdView = findViewById(R.id.text_view_detail_order_id);
        sentByView = findViewById(R.id.text_view_detail_order_sent_by);
        deliverToView = findViewById(R.id.text_view_detail_order_deliver_to);
        descriptionView = findViewById(R.id.text_view_detail_order_description);
        priceView = findViewById(R.id.text_view_detail_order_price);
    }
}
