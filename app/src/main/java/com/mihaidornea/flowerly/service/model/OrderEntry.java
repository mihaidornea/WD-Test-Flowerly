package com.mihaidornea.flowerly.service.model;

import java.io.Serializable;

public class OrderEntry implements Serializable {

    private int id;
    private String description;
    private String deliver_to;
    private String sent_by;
    private int price;

    public OrderEntry(int id, String description, String deliverTo, int price, String sentBy) {
        this.id = id;
        this.description = description;
        this.deliver_to = deliverTo;
        this.price = price;
        this.sent_by = sentBy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDeliverTo() {
        return deliver_to;
    }

    public void setDeliverTo(String deliverTo) {
        this.deliver_to = deliverTo;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getSentBy() {
        return sent_by;
    }

    public void setSentBy(String sentBy) {
        this.sent_by = sentBy;
    }
}
