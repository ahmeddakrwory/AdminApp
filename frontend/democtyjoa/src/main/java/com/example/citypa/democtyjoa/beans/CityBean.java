/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.citypa.democtyjoa.beans;

import com.example.citypa.democtyjoa.entitys.Area;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author ADMIN
 */
public class CityBean {
    private Integer id;
	private String nameAr;
	private String nameEn;
	private HashSet<AreaBean> areas = new HashSet<AreaBean>(0);

    public CityBean() {
    }
      

    public CityBean(Integer id, String nameEn,String nameAr) {
        this.id = id;
        this.nameEn = nameEn;
        this.nameAr=nameAr;
    }

    public CityBean(String nameAr, String nameEn) {
        this.nameAr = nameAr;
        this.nameEn = nameEn;
    }
    
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public HashSet<AreaBean> getAreas() {
        return areas;
    }

    public void setAreas(HashSet<AreaBean> areas) {
        this.areas = areas;
    }

   
        
        
    
}
