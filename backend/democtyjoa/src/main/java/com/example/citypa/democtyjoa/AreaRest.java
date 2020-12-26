/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.citypa.democtyjoa;

import com.example.citypa.democtyjoa.beans.AreaBean;
import com.example.citypa.democtyjoa.beans.BranchBean;
import com.example.citypa.democtyjoa.entitys.Area;
import com.example.citypa.democtyjoa.repos.AreaRepo;
import com.example.citypa.democtyjoa.entitys.City;
import com.example.citypa.democtyjoa.repos.CityRepo;
import com.example.citypa.democtyjoa.beans.CityBean;
import com.example.citypa.democtyjoa.entitys.Branch;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ADMIN
 */
@RestController
@RequestMapping(value = "/api/Area")
@CrossOrigin
public class AreaRest
{
    @Autowired
   private  AreaRepo areaRepo;
    @Autowired
    private CityRepo cityRepo;
    @PostMapping("/addar/{id}")
    public  AreaBean addArea( @RequestBody AreaBean a,@PathVariable(value = "id") String cityId ){
        
        int cityid=Integer.parseInt(cityId);
        City city=cityRepo.findById(cityid);
        
//       AreaBean arb=new AreaBean(a.getNameAr(), a.getNameEn(), 1);
  
    // Area ar=new Area(c, a.getNameAr(), a.getNameEn());
    Area area=new Area(a.getNameAr(), a.getNameEn());
   
   area.setCity(city);
  Area areaentity= areaRepo.save(area);
   
   
        return a ;
    }
    @GetMapping("/getarea/{id}")
    @ResponseBody
    public AreaBean findArea(@PathVariable (value = "id")String id){
        int Aid=Integer.parseInt(id);
        Area a=areaRepo.findById(Aid);
        City c=a.getCity();
        CityBean cbean=new CityBean(c.getId(),c.getNameEn(), c.getNameAr());
        AreaBean areaBean=new AreaBean( cbean,a.getNameEn(), a.getNameAr());
       areaBean.setId(Aid);
        Set<Branch> branches=a.getBranches();
        Set<BranchBean>allb= new HashSet<BranchBean>();
        for(Branch branch:branches){
            BranchBean bbean=new BranchBean(areaBean, branch.getNameAr(),branch.getNameEn()  );
            allb.add(bbean);
        }
        areaBean.setBranches(allb);
        return areaBean;
    }
    @PostMapping("/removearea/{id}")
    public void removeArea(@PathVariable (value = "id")String Aid){
        int id=Integer.parseInt(Aid);
        Area area=areaRepo.findById(id);
        areaRepo.delete(area);
    }
    @PostMapping("/editArea/{id}")
    @ResponseBody
    public AreaBean update(@PathVariable(value = "id")String id,@RequestBody AreaBean abean){
int aid=Integer.parseInt(id);
    Area area=areaRepo.findById(aid);
    area.setNameAr(abean.getNameAr());
    area.setNameEn(abean.getNameEn());
    areaRepo.save(area);
    return abean;
    }


}