/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.citypa.democtyjoa.beans;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author ADMIN
 */
public class AreaBean {
    private CityBean city;
	private String nameAr;
	private String nameEn;
	private Set<ConsumerAddressBean> consumerAddresses = new HashSet<ConsumerAddressBean>(0);
	private Set<DeliveryAreaBean> deliveryAreas = new HashSet<DeliveryAreaBean>(0);
	private Set<OrderBean> orders = new HashSet<OrderBean>(0);
	private Set<BranchBean> branches = new HashSet<BranchBean>(0);
        private int id;

    public AreaBean() {
    }

    public AreaBean(CityBean city, String nameAr, String nameEn) {
        this.city = city;
        this.nameAr = nameAr;
        this.nameEn = nameEn;
    }

    public AreaBean(String nameAr, String nameEn) {
         //To change body of generated methods, choose Tools | Templates.
    
    this.nameAr=nameAr;
    this.nameEn=nameEn;
    }
        

    public CityBean getCity() {
        return city;
    }

    public void setCity(CityBean city) {
        this.city = city;
    }

    public String getNameAr() {
        return nameAr;
    }

    public void setNameAr(String nameAr) {
        this.nameAr = nameAr;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public Set<ConsumerAddressBean> getConsumerAddresses() {
        return consumerAddresses;
    }

    public void setConsumerAddresses(Set<ConsumerAddressBean> consumerAddresses) {
        this.consumerAddresses = consumerAddresses;
    }

    public Set<DeliveryAreaBean> getDeliveryAreas() {
        return deliveryAreas;
    }

    public void setDeliveryAreas(Set<DeliveryAreaBean> deliveryAreas) {
        this.deliveryAreas = deliveryAreas;
    }

    public Set<OrderBean> getOrders() {
        return orders;
    }

    public void setOrders(Set<OrderBean> orders) {
        this.orders = orders;
    }

    public Set<BranchBean> getBranches() {
        return branches;
    }

    public void setBranches(Set<BranchBean> branches) {
        this.branches = branches;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
  
}
