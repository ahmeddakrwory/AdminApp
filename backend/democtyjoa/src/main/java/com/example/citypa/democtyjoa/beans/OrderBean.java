/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.citypa.democtyjoa.beans;

import com.example.citypa.democtyjoa.entitys.Area;
import com.example.citypa.democtyjoa.entitys.Branch;
import com.example.citypa.democtyjoa.entitys.Consumer;
import com.example.citypa.democtyjoa.entitys.ConsumerAddress;
import com.example.citypa.democtyjoa.entitys.OrderItem;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author ADMIN
 */
public class OrderBean {
    private Integer id;
	private AreaBean area;
	private BranchBean branch;
	private ConsumerBean consumer;
	private ConsumerAddressBean consumerAddress;
	private Date orderedAt;
	private float deliveryFees;
	private String status;
	private Set<OrderItemBean> orderItems = new HashSet<OrderItemBean>(0);

    public OrderBean() {
    }

    public OrderBean(Integer id, AreaBean area, BranchBean branch, ConsumerBean consumer, ConsumerAddressBean consumerAddress, Date orderedAt, float deliveryFees, String status) {
        this.id = id;
        this.area = area;
        this.branch = branch;
        this.consumer = consumer;
        this.consumerAddress = consumerAddress;
        this.orderedAt = orderedAt;
        this.deliveryFees = deliveryFees;
        this.status = status;
    }

    public OrderBean(float deliveryFees, String status) {
        this.deliveryFees = deliveryFees;
        this.status = status;
    }

    public OrderBean(AreaBean area, BranchBean branch, ConsumerBean consumer, ConsumerAddressBean consumerAddress, float deliveryFees, String status) {
        this.area = area;
        this.branch = branch;
        this.consumer = consumer;
        this.consumerAddress = consumerAddress;
        this.deliveryFees = deliveryFees;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AreaBean getArea() {
        return area;
    }

    public void setArea(AreaBean area) {
        this.area = area;
    }

    public BranchBean getBranch() {
        return branch;
    }

    public void setBranch(BranchBean branch) {
        this.branch = branch;
    }

    public ConsumerBean getConsumer() {
        return consumer;
    }

    public void setConsumer(ConsumerBean consumer) {
        this.consumer = consumer;
    }

    public ConsumerAddressBean getConsumerAddress() {
        return consumerAddress;
    }

    public void setConsumerAddress(ConsumerAddressBean consumerAddress) {
        this.consumerAddress = consumerAddress;
    }

    public Date getOrderedAt() {
        return orderedAt;
    }

    public void setOrderedAt(Date orderedAt) {
        this.orderedAt = orderedAt;
    }

    public float getDeliveryFees() {
        return deliveryFees;
    }

    public void setDeliveryFees(float deliveryFees) {
        this.deliveryFees = deliveryFees;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Set<OrderItemBean> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Set<OrderItemBean> orderItems) {
        this.orderItems = orderItems;
    }

}
