/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.citypa.democtyjoa.beans;

import com.example.citypa.democtyjoa.entitys.Product;
import com.example.citypa.democtyjoa.entitys.Provider;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

/**
 *
 * @author ADMIN
 */

public class CategryBean {
    private Integer id;
	private ProviderBean provider;
	private String nameAr;
	private String nameEn;
	private String descriptionAr;
	private String descriptionEn;
	private Set<ProductBbean> products = new HashSet<ProductBbean>(0);

    public CategryBean(ProviderBean provider, String nameAr, String nameEn) {
        this.provider = provider;
        this.nameAr = nameAr;
        this.nameEn = nameEn;
    }

    public CategryBean() {
    }

    public CategryBean( String nameAr, String nameEn, String descriptionAr, String descriptionEn) {
    
        this.nameAr = nameAr;
        this.nameEn = nameEn;
        this.descriptionAr = descriptionAr;
        this.descriptionEn = descriptionEn;
    }

    public CategryBean(String nameAr, String nameEn) {
        this.nameAr = nameAr;
        this.nameEn = nameEn;
    }
    

    public CategryBean(Integer id, ProviderBean provider, String nameAr, String nameEn, String descriptionAr, String descriptionEn) {
        this.id = id;
        this.provider = provider;
        this.nameAr = nameAr;
        this.nameEn = nameEn;
        this.descriptionAr = descriptionAr;
        this.descriptionEn = descriptionEn;
    }

    public Integer getId() {
        return id;
    }

    public ProviderBean getProvider() {
        return provider;
    }

    public String getNameAr() {
        return nameAr;
    }

    public String getNameEn() {
        return nameEn;
    }

    public String getDescriptionAr() {
        return descriptionAr;
    }

    public String getDescriptionEn() {
        return descriptionEn;
    }

    public Set<ProductBbean> getProducts() {
        return products;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setProvider(ProviderBean provider) {
        this.provider = provider;
    }

    public void setNameAr(String nameAr) {
        this.nameAr = nameAr;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public void setDescriptionAr(String descriptionAr) {
        this.descriptionAr = descriptionAr;
    }

    public void setDescriptionEn(String descriptionEn) {
        this.descriptionEn = descriptionEn;
    }

    public void setProducts(Set<ProductBbean> products) {
        this.products = products;
    }
    

   
}
