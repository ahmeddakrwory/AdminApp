/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.citypa.democtyjoa;

import com.example.citypa.democtyjoa.beans.AreaBean;
import com.example.citypa.democtyjoa.beans.BranchBean;
import com.example.citypa.democtyjoa.beans.CityBean;
import com.example.citypa.democtyjoa.beans.ConsumerAddressBean;
import com.example.citypa.democtyjoa.beans.ConsumerBean;
import com.example.citypa.democtyjoa.beans.OrderBean;
import com.example.citypa.democtyjoa.beans.ProviderBean;
import com.example.citypa.democtyjoa.entitys.Consumer;
import com.example.citypa.democtyjoa.entitys.Order;
import com.example.citypa.democtyjoa.repos.ConsumerRepo;
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

public class ConsumerRest {
@Autowired
private ConsumerRepo consrepo;
@GetMapping("/addconsumer")
    public ConsumerBean addConsumear(@RequestBody ConsumerBean consBean){
        Consumer cons=new Consumer(consBean.getPassword(), consBean.getEmail(), consBean.getGender(), consBean.getFullname());
         consrepo.save(cons);
       
        return consBean;
    }
    @PostMapping("/deleteConsumer")
public void deleteconsumer(@RequestParam(value = "id")String consid){
    int id=Integer.parseInt(consid);
    Consumer consumer=consrepo.findById(id);
    consrepo.delete(consumer);
}
@PostMapping("/updateconsumer")
public ConsumerBean updateconsumer(@RequestParam (value = "id") String cId,@RequestBody ConsumerBean consb){
 int id=Integer.parseInt(cId);
    Consumer cons=consrepo.findById(id);
    cons.setEmail(consb.getEmail());
    cons.setFullname(consb.getFullname());
    cons.setGender(consb.getGender());
    cons.setPassword(consb.getPassword());
    return consb;
}
@GetMapping("/findConsumer")
public ConsumerBean getConsumer(@RequestParam(value = "id") String cid){
   
    int id=Integer.parseInt(cid);
    Consumer consum=consrepo.findById(id);
    ConsumerBean consumerbean=new ConsumerBean(consum.getPhone(), consum.getEmail(), consum.getFullname(), consum.getFullname(), consum.getGender());
 Set<OrderBean> orders = new HashSet<OrderBean>();
for(Order order:consum.getOrders()){
    CityBean cbean=new CityBean(order.getArea().getCity().getId(), order.getArea().getCity().getNameAr(), order.getArea().getNameEn());
    AreaBean areabean=new AreaBean(cbean, order.getArea().getNameAr(), order.getArea().getNameEn());
    ProviderBean prvbean=new ProviderBean(order.getBranch().getProvider().getHotline(), order.getBranch().getProvider().getNameAr(), order.getBranch().getProvider().getNameEn());
    BranchBean branchBean=new BranchBean(areabean, prvbean,  order.getBranch().getNameEn(), order.getBranch().getNameAr(), order.getBranch().getPhone());
    ConsumerAddressBean consaba=new ConsumerAddressBean(areabean, consumerbean, order.getConsumerAddress().getStreet(), order.getConsumerAddress().getBuilding(),order.getConsumerAddress().getFloor(), order.getConsumerAddress().getFlat(), order.getConsumerAddress().getLandmark());
    OrderBean orderbean =new OrderBean(areabean, branchBean, consumerbean, consaba, order.getDeliveryFees(),order.getStatus());
    orders.add(orderbean);
}
return consumerbean;
}

}    
  
