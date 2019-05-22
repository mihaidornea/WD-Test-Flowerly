package com.mihaidornea.flowerly.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mihaidornea.flowerly.R;
import com.mihaidornea.flowerly.service.model.OrderEntry;

import java.util.ArrayList;
import java.util.List;

public class OrdersAdapter extends RecyclerView.Adapter<OrdersAdapter.OrderViewHolder> {

    private final Context mContext;

    private List<OrderEntry> orders;


    public OrdersAdapter(Context context, OrderAdapterOnItemClickHandler mItemClickHandler) {
        orders = new ArrayList<>();
        this.mContext = context;
        this.mItemClickHandler = mItemClickHandler;
    }

    private final OrderAdapterOnItemClickHandler mItemClickHandler;

    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.list_item_order, viewGroup, false);
        view.setFocusable(true);
        return new OrderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderViewHolder orderViewHolder, int i) {
        OrderEntry orderEntry = orders.get(i);
        orderViewHolder.deliverToView.setText(orderEntry.getDeliverTo());
        orderViewHolder.descriptionView.setText(orderEntry.getDescription());
        orderViewHolder.priceView.setText(Integer.toString(orderEntry.getPrice()));
    }

    @Override
    public int getItemCount() {
        if (orders == null) return 0;
        return orders.size();
    }

    public void setOrders(List<OrderEntry> orders) {
        this.orders = orders;
    }

    public interface OrderAdapterOnItemClickHandler{
        void onItemClick(OrderEntry orderEntry);
    }


    public class OrderViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView descriptionView;
        private TextView priceView;
        private TextView deliverToView;

        public OrderViewHolder(@NonNull View itemView) {
            super(itemView);

            descriptionView = itemView.findViewById(R.id.text_view_order_description);
            priceView = itemView.findViewById(R.id.text_view_order_price);
            deliverToView = itemView.findViewById(R.id.text_view_order_deliver_to);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int adapterPosition = getAdapterPosition();
            mItemClickHandler.onItemClick(orders.get(adapterPosition));
        }
    }
}
