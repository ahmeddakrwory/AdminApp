/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.citypa.democtyjoa;

import com.example.citypa.democtyjoa.beans.CategryBean;
import com.example.citypa.democtyjoa.beans.ProductBbean;
import com.example.citypa.democtyjoa.entitys.Category;
import com.example.citypa.democtyjoa.entitys.Product;
import com.example.citypa.democtyjoa.repos.CategoryRepo;
import com.example.citypa.democtyjoa.repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ADMIN
 */
@RestController 
public class ProductRest {
    @Autowired
    private ProductRepo prepo;
    @Autowired
    private  CategoryRepo catgoryRepo;
    public  ProductBbean addProduct(@RequestParam(value = "catid")String cid,@RequestBody ProductBbean poduBbean){
   int catid=Integer.parseInt(cid);
   Category catg=catgoryRepo.findById(catid);
   Product prod= new Product(catg, poduBbean.getNameEn(), poduBbean.getNameEn(), poduBbean.getPrice(), poduBbean.getActive());
   prod.setImagePath(poduBbean.getImagePath());
   prod.setDescriptionAr(poduBbean.getDescriptionAr());
   prod.setDescriptionEn(poduBbean.getDescriptionEn());
   prepo.save(prod);
return poduBbean;
        
    }
    
}
