/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.citypa.democtyjoa;

import com.example.citypa.democtyjoa.entitys.Area;
import com.example.citypa.democtyjoa.entitys.Category;
import com.example.citypa.democtyjoa.entitys.City;
import com.example.citypa.democtyjoa.repos.CityRepo;
import com.example.citypa.democtyjoa.beans.AreaBean;
import com.example.citypa.democtyjoa.beans.CityBean;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
 * 
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/api/city")
public class CityRest {
@Autowired
private CityRepo cityrepo;

@GetMapping("/cities")
    public List<CityBean>Allcity(){
       ArrayList <City>all=(ArrayList <City>) cityrepo.findAll();
       ArrayList<CityBean>allbeans=new ArrayList<CityBean>();
       for(City city:all){
           CityBean cben=new CityBean(city.getId(), city.getNameEn(), city.getNameAr());
           allbeans.add(cben);
           AreaBean abean;
           HashSet<AreaBean> aresb=new HashSet<AreaBean>();
         for(Area a:city.getAreas()){
             abean=new AreaBean(a.getNameAr(), a.getNameEn());
aresb.add(abean);

             cben.setAreas(aresb);
         }
       }
       
            
       return allbeans;
    }
    @PostMapping("/addcitys")
//    @ResponseBody
    public City addc(@RequestBody City city){
   
      city=  cityrepo.save(city);
     
        return city;
    }
    @GetMapping("/cid/{id}")
    @ResponseBody
    public  CityBean getbyid(@PathVariable(value = "id")String cid){
        Integer id=Integer.parseInt(cid);
       int sid=id;
            City c= cityrepo.findById(sid);
            CityBean cbean = new CityBean(c.getId(), c.getNameEn(),c.getNameAr());
            AreaBean abean;
            HashSet<AreaBean>areas=new HashSet<AreaBean>();
            for(Area a:c.getAreas()){
                CityBean cityBean=new CityBean(a.getCity().getId(), a.getCity().getNameEn(), a.getCity().getNameEn());
   AreaBean areabean=new AreaBean(cityBean, a.getNameAr(), a.getNameEn());
   
              areabean.setId(a.getId());
                areas.add(areabean);
            }
            cbean.setAreas(areas);
            return cbean;
    }
  @DeleteMapping("/deletecity/{id}")
  
  public void deletecity(@PathVariable(value = "id") String cid){
      int id=Integer.parseInt(cid);
      City c=cityrepo.findById(id);
      cityrepo.delete(c);
  }
  @PostMapping("/updatecity/{id}")
  @ResponseBody
  public CityBean updatecity(@PathVariable(value = "id")String id,@RequestBody CityBean cbean){
      int cid=Integer.parseInt(id);
      City c=cityrepo.findById(cid);
      
      c.setNameAr(cbean.getNameAr());
      c.setNameEn(cbean.getNameEn());
      cbean.setId(cid);
      cityrepo.save(c);
      return cbean;
  }
}
