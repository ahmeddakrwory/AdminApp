/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.citypa.democtyjoa.beans;

import com.example.citypa.democtyjoa.entitys.Area;
import com.example.citypa.democtyjoa.entitys.Consumer;
import com.example.citypa.democtyjoa.entitys.Order;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author ADMIN
 */
public class ConsumerAddressBean {
    private Integer id;
	private AreaBean area;
	private ConsumerBean consumer;
	private String street;
	private String building;
	private String floor;
	private String flat;
	private String landmark;
	private BigDecimal lat;
	private BigDecimal lng;
	private String label;
	private byte active;
	private Set<OrderBean> orders = new HashSet<OrderBean>(0);

    public ConsumerAddressBean(String street, String building, String floor, String flat, String landmark, BigDecimal lat, BigDecimal lng, String label, byte active) {
        this.street = street;
        this.building = building;
        this.floor = floor;
        this.flat = flat;
        this.landmark = landmark;
        this.lat = lat;
        this.lng = lng;
        this.label = label;
        this.active = active;
    }
        

    public ConsumerAddressBean(String street, String building, String floor, String flat, byte active) {
        this.street = street;
        this.building = building;
        this.floor = floor;
        this.flat = flat;
        this.active = active;
    }

    public ConsumerAddressBean() {
    }

        
    public ConsumerAddressBean(AreaBean area, ConsumerBean consumer, String street, String building, String floor, String flat, String landmark) {
        this.area = area;
        this.consumer = consumer;
        this.street = street;
        this.building = building;
        this.floor = floor;
        this.flat = flat;
        this.landmark = landmark;
    }

    public ConsumerAddressBean(AreaBean area, ConsumerBean consumer, String street, String building, String floor, String flat, String landmark, BigDecimal lat, BigDecimal lng, String label, byte active) {
        this.area = area;
        this.consumer = consumer;
        this.street = street;
        this.building = building;
        this.floor = floor;
        this.flat = flat;
        this.landmark = landmark;
        this.lat = lat;
        this.lng = lng;
        this.label = label;
        this.active = active;
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

    public ConsumerBean getConsumer() {
        return consumer;
    }

    public void setConsumer(ConsumerBean consumer) {
        this.consumer = consumer;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getFlat() {
        return flat;
    }

    public void setFlat(String flat) {
        this.flat = flat;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    public BigDecimal getLat() {
        return lat;
    }

    public void setLat(BigDecimal lat) {
        this.lat = lat;
    }

    public BigDecimal getLng() {
        return lng;
    }

    public void setLng(BigDecimal lng) {
        this.lng = lng;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public byte getActive() {
        return active;
    }

    public void setActive(byte active) {
        this.active = active;
    }

    public Set<OrderBean> getOrders() {
        return orders;
    }

    public void setOrders(Set<OrderBean> orders) {
        this.orders = orders;
    }


        
    
}
