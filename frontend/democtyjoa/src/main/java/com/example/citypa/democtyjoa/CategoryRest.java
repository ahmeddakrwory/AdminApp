/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.citypa.democtyjoa;

import com.example.citypa.democtyjoa.beans.CategryBean;
import com.example.citypa.democtyjoa.entitys.Category;
import com.example.citypa.democtyjoa.repos.CategoryRepo;
import com.example.citypa.democtyjoa.entitys.Provider;
import com.example.citypa.democtyjoa.repos.ProviderRepo;
import javax.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
@RequestMapping("/category")
public class CategoryRest {
   
    @Autowired
    private ProviderRepo provRepo;
    @Autowired
    private  CategoryRepo catrepo;
    @GetMapping("/addc/{id}")
    public CategryBean addCategory(@PathParam(value = "id") int id,@RequestBody CategryBean catbean){
        Provider p=provRepo.findById(id);
        Category catg=new Category(p, catbean.getNameAr(), catbean.getNameEn());
    Category cat=catrepo.save(catg);
    catbean.setId(cat.getId());
    return catbean;
    }
     @DeleteMapping("/deletcateg/{id}")
    public void deleteCat( @PathParam(value = "id") int id){
       Category cat=  catrepo.findById(id);
       catrepo.delete(cat);
    }
    @GetMapping("/updatecateg")
    public Category updateCategory(@RequestParam int id,@RequestBody CategryBean catbean){
       Category cat=catrepo.findById(id);
      
      cat.setNameAr(catbean.getNameAr());
      cat.setNameEn(catbean.getNameEn());
      cat.setDescriptionAr(catbean.getDescriptionAr());
      cat.setDescriptionEn(catbean.getDescriptionEn());
      
      return catrepo.save(cat);
}
    @GetMapping("/getcat/{id}")
    public  CategryBean getcat(@PathVariable(value = "id") String catgid){
     int  id=Integer.parseInt(catgid);
     Category cat=catrepo.findById(id);
   CategryBean catgbean=new CategryBean(cat.getNameAr(), cat.getNameEn());
   catgbean.setId(id);
    return catgbean;
    }
    
}