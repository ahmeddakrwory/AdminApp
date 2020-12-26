/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.citypa.democtyjoa.beans;

import com.example.citypa.democtyjoa.entitys.Branch;
import com.example.citypa.democtyjoa.entitys.Provider;

/**
 *
 * @author ADMIN
 */
public class ProviderUserBean {
    
    private Integer id;
	private BranchBean branch;
	private ProviderBean provider;
	private String username;
	private String password;
	private byte active;

    public ProviderUserBean(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public ProviderUserBean(String username, String password, byte active) {
        this.username = username;
        this.password = password;
        this.active = active;
    }

    public ProviderUserBean() {
    }

    public ProviderUserBean(BranchBean branch, ProviderBean provider, String username, String password) {
        this.branch = branch;
        this.provider = provider;
        this.username = username;
        this.password = password;
    }

    public ProviderUserBean(Integer id, BranchBean branch, ProviderBean provider, String username, String password, byte active) {
        this.id = id;
        this.branch = branch;
        this.provider = provider;
        this.username = username;
        this.password = password;
        this.active = active;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BranchBean getBranch() {
        return branch;
    }

    public void setBranch(BranchBean branch) {
        this.branch = branch;
    }

    public ProviderBean getProvider() {
        return provider;
    }

    public void setProvider(ProviderBean provider) {
        this.provider = provider;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public byte getActive() {
        return active;
    }

    public void setActive(byte active) {
        this.active = active;
    }

   

}
