/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.citypa.democtyjoa.beans;

import com.example.citypa.democtyjoa.entitys.Order;
import com.example.citypa.democtyjoa.entitys.Product;

/**
 *
 * @author ADMIN
 */
public class OrderItemBean {
    private Integer id;
	private OrderBean order;
	private ProductBbean product;
	private int quantity;
	private float price;

    public OrderItemBean(OrderBean order, ProductBbean product, int quantity, float price) {
        this.order = order;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
    }
        

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public OrderBean getOrder() {
        return order;
    }

    public void setOrder(OrderBean order) {
        this.order = order;
    }

    public ProductBbean getProduct() {
        return product;
    }

    public void setProduct(ProductBbean product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
        
}
