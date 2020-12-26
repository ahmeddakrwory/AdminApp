/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.citypa.democtyjoa.beans;

import com.example.citypa.democtyjoa.entitys.Branch;
import com.example.citypa.democtyjoa.entitys.Category;
import com.example.citypa.democtyjoa.entitys.ProviderUser;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author ADMIN
 */
public class ProviderBean {
    private Integer id;
	private String nameAr;
	private String nameEn;
	private String hotline;
	private String logoPathAr;
	private String logoPathEn;
	private Set<CategryBean> categories = new HashSet<CategryBean>(0);
	private Set<BranchBean> branches = new HashSet<BranchBean>(0);
	private Set<ProviderUserBean> providerUsers = new HashSet<ProviderUserBean>(0);

    public ProviderBean() {
    }

    public ProviderBean(String nameAr, String nameEn, String hotline) {
        this.nameAr = nameAr;
        this.nameEn = nameEn;
        this.hotline = hotline;
    }

    public ProviderBean(Integer id, String nameAr, String nameEn, String hotline, String logoPathAr, String logoPathEn) {
        this.id = id;
        this.nameAr = nameAr;
        this.nameEn = nameEn;
        this.hotline = hotline;
        this.logoPathAr = logoPathAr;
        this.logoPathEn = logoPathEn;
    }

    public ProviderBean(String nameAr, String nameEn, String hotline, String logoPathAr, String logoPathEn) {
        this.nameAr = nameAr;
        this.nameEn = nameEn;
        this.hotline = hotline;
        this.logoPathAr = logoPathAr;
        this.logoPathEn = logoPathEn;
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

    public String getHotline() {
        return hotline;
    }

    public void setHotline(String hotline) {
        this.hotline = hotline;
    }

    public String getLogoPathAr() {
        return logoPathAr;
    }

    public void setLogoPathAr(String logoPathAr) {
        this.logoPathAr = logoPathAr;
    }

    public String getLogoPathEn() {
        return logoPathEn;
    }

    public void setLogoPathEn(String logoPathEn) {
        this.logoPathEn = logoPathEn;
    }

    public Set<CategryBean> getCategories() {
        return categories;
    }

    public void setCategories(Set<CategryBean> categories) {
        this.categories = categories;
    }

    public Set<BranchBean> getBranches() {
        return branches;
    }

    public void setBranches(Set<BranchBean> branches) {
        this.branches = branches;
    }

    public Set<ProviderUserBean> getProviderUsers() {
        return providerUsers;
    }

    public void setProviderUsers(Set<ProviderUserBean> providerUsers) {
        this.providerUsers = providerUsers;
    }
    



    
}
