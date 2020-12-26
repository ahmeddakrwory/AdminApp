/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.citypa.democtyjoa;

import com.example.citypa.democtyjoa.beans.ConsumerAddressBean;
import com.example.citypa.democtyjoa.beans.ConsumerBean;
import com.example.citypa.democtyjoa.entitys.Area;
import com.example.citypa.democtyjoa.entitys.Consumer;
import com.example.citypa.democtyjoa.entitys.ConsumerAddress;
import com.example.citypa.democtyjoa.repos.AreaRepo;
import com.example.citypa.democtyjoa.repos.ConsumerAddressRepo;
import com.example.citypa.democtyjoa.repos.ConsumerRepo;
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
public class ConsumerAdreesRest {
    @Autowired
    private ConsumerAddressRepo consumerAddressRepo;
    @Autowired
           private ConsumerRepo consRepo;
    @Autowired
    private AreaRepo arearepo;
@GetMapping("/addcAdrees")
public ConsumerAddressBean AddConsumerAddres(@RequestParam(value = "consumerid")String consumerId,@RequestParam (value = "Aid")String aid,@RequestBody ConsumerAddressBean consAdreesbAddressBean){
    int cid=Integer.parseInt(consumerId);
    int areaid=Integer.parseInt(aid);
    
  Consumer consu   =consRepo.findById(cid);
  Area area=arearepo.findById(areaid);
    ConsumerBean consBean=new ConsumerBean(consu.getPhone(), consu.getEmail(), consu.getPassword(), consu.getFullname(), consu.getGender());
 ConsumerAddress consadrees=new ConsumerAddress(area, consu, consAdreesbAddressBean.getStreet(), consAdreesbAddressBean.getBuilding(), consAdreesbAddressBean.getFloor(), consAdreesbAddressBean.getFlat(), consAdreesbAddressBean.getActive());

 consumerAddressRepo.save(consadrees);

return consAdreesbAddressBean;
         }
@PostMapping("/deleteconsadrees")
public void deleteAdrees(@RequestParam(value = "adresid") String addresid){
    int id=Integer.parseInt(addresid);
  ConsumerAddress consad=   consumerAddressRepo.findById(id);
  consumerAddressRepo.delete(consad);
}
}
