/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.citypa.democtyjoa;

import com.example.citypa.democtyjoa.beans.AreaBean;
import com.example.citypa.democtyjoa.beans.BranchBean;
import com.example.citypa.democtyjoa.beans.ProviderBean;
import com.example.citypa.democtyjoa.entitys.Area;
import com.example.citypa.democtyjoa.repos.AreaRepo;
import com.example.citypa.democtyjoa.entitys.Branch;
import com.example.citypa.democtyjoa.repos.BranchRepo;
import com.example.citypa.democtyjoa.entitys.Provider;
import com.example.citypa.democtyjoa.repos.ProviderRepo;
import javax.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ADMIN
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/branch")
public class BranchRest {
    @Autowired
    private AreaRepo areaRepo;
    @Autowired
    private  ProviderRepo providerRepo;
    @Autowired
    private  BranchRepo branchRepo;
    @GetMapping("/addbranch/{aid}/{pid}")
    public BranchBean adbranch(@PathVariable(value = "aid")  int areaid,@PathParam(value = "pid") int providerid,@RequestBody BranchBean branchBean){
        Provider p=providerRepo.findById(providerid);
        ProviderBean pb=new ProviderBean(p.getNameAr(), p.getNameEn(), p.getHotline());
        Area area=areaRepo.findById(areaid);
        AreaBean areab=new AreaBean(area.getNameAr(), area.getNameEn());
        Branch branch=new Branch(area, p, branchBean.getNameAr(), branchBean.getNameEn(), branchBean.getOpenAt(), branchBean.getCloseAt());
        
        branchRepo.save(branch);
        return branchBean;
       
    }
    @PostMapping("/deletebranch/{bid}")
    public void deletebranch(@PathVariable(value="bid") String brachId){
        int id=Integer.parseInt(brachId);
        Branch branch=branchRepo.findById(id);
        branchRepo.delete(branch);
        
    }
}
