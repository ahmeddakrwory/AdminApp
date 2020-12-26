/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.citypa.democtyjoa;

import com.example.citypa.democtyjoa.beans.AreaBean;
import com.example.citypa.democtyjoa.beans.BranchBean;
import com.example.citypa.democtyjoa.beans.CityBean;
import com.example.citypa.democtyjoa.beans.ProviderBean;
import com.example.citypa.democtyjoa.entitys.Branch;
import com.example.citypa.democtyjoa.entitys.Provider;
import com.example.citypa.democtyjoa.repos.ProviderRepo;
import java.util.HashSet;
import java.util.Set;
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
public class ProviderRest {
    @Autowired
    private ProviderRepo prepo;
    @GetMapping("/addP")
    public ProviderBean  addProvider(@RequestBody ProviderBean providerBean){
        Provider p=new Provider(providerBean.getNameAr(), providerBean.getNameEn(), providerBean.getHotline());
    Provider provider= prepo.save(p);
    providerBean.setId(provider.getId());
    return providerBean;
    }
    @PostMapping("/deletep")
    public void deleteProvider(@RequestParam int id){
        Provider p=prepo.findById(id);
        prepo.delete(p);
  
        
    }
    @GetMapping("/updateprov")
    public Provider updateProvider(@RequestParam int id,@RequestBody ProviderBean provb){
        Provider prov=prepo.findById(id);
        prov.setNameAr(provb.getNameAr());
        prov.setNameEn(provb.getNameEn());
        prov.setHotline(provb.getHotline());
        return prepo.save(prov);
        
    }
    @GetMapping("/findprovider")
    public ProviderBean getprovider(@RequestParam(value = "id") String id ){
       int pid=Integer.parseInt(id);
         Provider prov=prepo.findById(pid);
         ProviderBean provBean=new ProviderBean(prov.getNameAr(), prov.getLogoPathEn(), prov.getHotline());
         Set<BranchBean> branches = new HashSet<BranchBean>();
         for(Branch b:prov.getBranches()){
             CityBean cbean=new CityBean(b.getArea().getCity().getId(), b.getArea().getCity().getNameAr(), b.getArea().getCity().getNameEn());
             AreaBean areab=new AreaBean(cbean, b.getArea().getNameAr(), b.getArea().getNameEn());
             BranchBean branchben =new BranchBean(areab, provBean, b.getNameAr(), b.getNameEn(), b.getPhone()) ;
           branches.add(branchben);
             
         }
        provBean.setBranches(branches);
     return provBean;
    }
}
