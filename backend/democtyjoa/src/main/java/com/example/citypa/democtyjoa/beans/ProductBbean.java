/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.citypa.democtyjoa.beans;

import com.example.citypa.democtyjoa.entitys.Category;
import com.example.citypa.democtyjoa.entitys.OrderItem;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author ADMIN
 */
public class ProductBbean {
    private Integer id;
	private CategryBean category;
	private String nameAr;
	private String nameEn;
	private float price;
	private String descriptionAr;
	private String descriptionEn;
	private String imagePath;
	private byte active;
	private Set<OrderItemBean> orderItems = new HashSet<OrderItemBean>(0);

    public ProductBbean(String nameAr, String nameEn, float price, String descriptionAr, String descriptionEn, String imagePath, byte active) {
        this.nameAr = nameAr;
        this.nameEn = nameEn;
        this.price = price;
        this.descriptionAr = descriptionAr;
        this.descriptionEn = descriptionEn;
        this.imagePath = imagePath;
        this.active = active;
    }

    public ProductBbean(Integer id, CategryBean category, String nameAr, String nameEn, float price, String descriptionAr, String descriptionEn, String imagePath, byte active) {
        this.id = id;
        this.category = category;
        this.nameAr = nameAr;
        this.nameEn = nameEn;
        this.price = price;
        this.descriptionAr = descriptionAr;
        this.descriptionEn = descriptionEn;
        this.imagePath = imagePath;
        this.active = active;
    }

    public ProductBbean(CategryBean category, String nameAr, String nameEn, float price, String descriptionAr, String descriptionEn, String imagePath) {
        this.category = category;
        this.nameAr = nameAr;
        this.nameEn = nameEn;
        this.price = price;
        this.descriptionAr = descriptionAr;
        this.descriptionEn = descriptionEn;
        this.imagePath = imagePath;
    }
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CategryBean getCategory() {
        return category;
    }

    public void setCategory(CategryBean category) {
        this.category = category;
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescriptionAr() {
        return descriptionAr;
    }

    public void setDescriptionAr(String descriptionAr) {
        this.descriptionAr = descriptionAr;
    }

    public String getDescriptionEn() {
        return descriptionEn;
    }

    public void setDescriptionEn(String descriptionEn) {
        this.descriptionEn = descriptionEn;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public byte getActive() {
        return active;
    }

    public void setActive(byte active) {
        this.active = active;
    }

    public Set<OrderItemBean> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Set<OrderItemBean> orderItems) {
        this.orderItems = orderItems;
    }
        


        
    
}
