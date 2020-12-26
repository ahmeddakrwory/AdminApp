/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.citypa.democtyjoa;

import com.example.citypa.democtyjoa.beans.AreaBean;
import com.example.citypa.democtyjoa.beans.BranchBean;
import com.example.citypa.democtyjoa.beans.DeliveryAreaBean;
import com.example.citypa.democtyjoa.entitys.Area;
import com.example.citypa.democtyjoa.entitys.Branch;
import com.example.citypa.democtyjoa.entitys.DeliveryArea;
import com.example.citypa.democtyjoa.repos.BranchRepo;
import com.example.citypa.democtyjoa.repos.DeliveryAreaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ADMIN
 */
@RestController
public class DelevreyAreaRest {
    @Autowired
    private DeliveryAreaRepo deliveryAreaRepo;
    @Autowired
    private BranchRepo branchRepo;
    @GetMapping("/addDliveryArea")
    public DeliveryAreaBean addDeliveryArea(@RequestParam(value = "bid")String branchid,@RequestBody DeliveryAreaBean delArea){
int bid=Integer.parseInt(branchid);
        Branch b=branchRepo.findById(bid);
        Area ara=b.getArea();
        ara.setId(b.getArea().getId());
        AreaBean aben=new AreaBean(ara.getNameAr(), ara.getNameEn());
        BranchBean branchbean=new BranchBean(aben, b.getNameAr(), b.getNameEn());
        DeliveryArea deliveryArea=new DeliveryArea(ara, b,delArea.getDeliveryFees(), delArea.getDeliverInMinutes());
        deliveryAreaRepo.save(deliveryArea);
    delArea.setArea(aben);
    delArea.setBranch(branchbean);
    return delArea;
    }
    @PostMapping("/deletDliveryarea")
    public void deleteDelevierArea(@RequestParam(value = "id")String deleteid){
        int id=Integer.parseInt(deleteid);
        DeliveryArea delaera=deliveryAreaRepo.findById(id);
        deliveryAreaRepo.delete(delaera);
    } 
    @GetMapping("/findDeliveryarea")
    public DeliveryAreaBean GetdeliveryArea(@RequestParam(value = "id")String id){
        int ids=Integer.parseInt(id);
        DeliveryArea dela=deliveryAreaRepo.findById(ids);
        AreaBean a=new AreaBean(dela.getArea().getNameAr(), dela.getArea().getNameEn());
    a.setId(dela.getArea().getId());
    BranchBean b=new BranchBean(a, dela.getBranch().getNameAr(), dela.getBranch().getNameEn());
    DeliveryAreaBean dbean=new DeliveryAreaBean(dela.getId(), a, b,dela.getDeliveryFees(), dela.getDeliverInMinutes());
    return dbean;
    }
}
