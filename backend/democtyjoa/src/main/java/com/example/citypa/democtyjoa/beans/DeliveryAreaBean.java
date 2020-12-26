/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.citypa.democtyjoa.beans;

import com.example.citypa.democtyjoa.entitys.Area;
import com.example.citypa.democtyjoa.entitys.Branch;

/**
 *
 * @author ADMIN
 */
public class DeliveryAreaBean {
    private Integer id;
	private AreaBean area;
	private BranchBean branch;
	private float deliveryFees;
	private int deliverInMinutes;

    public DeliveryAreaBean(Integer id, AreaBean area, BranchBean branch, float deliveryFees, int deliverInMinutes) {
        this.id = id;
        this.area = area;
        this.branch = branch;
        this.deliveryFees = deliveryFees;
        this.deliverInMinutes = deliverInMinutes;
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

    public float getDeliveryFees() {
        return deliveryFees;
    }

    public void setDeliveryFees(float deliveryFees) {
        this.deliveryFees = deliveryFees;
    }

    public int getDeliverInMinutes() {
        return deliverInMinutes;
    }

    public void setDeliverInMinutes(int deliverInMinutes) {
        this.deliverInMinutes = deliverInMinutes;
    }

    
}
