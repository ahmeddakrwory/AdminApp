/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.citypa.democtyjoa;

import com.example.citypa.democtyjoa.beans.AreaBean;
import com.example.citypa.democtyjoa.beans.BranchBean;
import com.example.citypa.democtyjoa.beans.CityBean;
import com.example.citypa.democtyjoa.beans.ConsumerBean;
import com.example.citypa.democtyjoa.beans.OrderBean;
import com.example.citypa.democtyjoa.beans.ProviderBean;
import com.example.citypa.democtyjoa.entitys.Area;
import com.example.citypa.democtyjoa.entitys.Branch;
import com.example.citypa.democtyjoa.entitys.Consumer;
import com.example.citypa.democtyjoa.entitys.Order;
import com.example.citypa.democtyjoa.repos.BranchRepo;
import com.example.citypa.democtyjoa.repos.ConsumerRepo;
import com.example.citypa.democtyjoa.repos.OrderRepo;
import java.util.Date;
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
public class OrderRest {
@Autowired
private OrderRepo orderRepo;
@Autowired
private BranchRepo branchrepo;
@Autowired
private ConsumerRepo consRepo;
@GetMapping("/addOrder")
public  OrderBean addorder(@RequestParam (value = "id")String id,@RequestParam(value = "conid")String conid,@RequestBody OrderBean orderbean){
    int bid=Integer.parseInt(id);
    int cid=Integer.parseInt(conid);
    Branch brnch=branchrepo.findById(bid);
    Consumer consm=consRepo.findById(cid);
    CityBean cbean=new CityBean(brnch.getArea().getCity().getId(), brnch.getArea().getCity().getNameAr(), brnch.getArea().getCity().getNameEn());
    AreaBean areaBean=new AreaBean(cbean, brnch.getArea().getNameAr(),brnch.getArea().getNameEn());
Area area=new Area(areaBean.getNameAr(), areaBean.getNameEn());
area.setId(brnch.getArea().getId());
    Date orderAt=new Date();
Order o =new Order(area, brnch, consm, orderAt,orderbean.getDeliveryFees() , orderbean.getStatus());
orderRepo.save(o);
//    ConsumerBean consb= new ConsumerBean(brnch.get, id, id, id, id)
return orderbean;
}
@PostMapping("/cancelorder")
public void cancelorder(@RequestParam(value = "oid")String orderstring){
    int id =Integer.parseInt(orderstring);
    Order order=orderRepo.findById(id);
    orderRepo.delete(order);
}
@GetMapping("/getorder")

public OrderBean findOrder(@RequestParam (value = "orderid") String orderid){
    
int id =Integer.parseInt(orderid);
 Order order= orderRepo.findById(id);
 AreaBean aeabean=new AreaBean(order.getArea().getNameAr(), order.getArea().getNameEn());
    ProviderBean pbean=new ProviderBean(order.getBranch().getProvider().getNameAr(), order.getBranch().getProvider().getNameEn(), order.getBranch().getProvider().getHotline());
  BranchBean bbean=new BranchBean(aeabean, pbean, order.getBranch().getNameAr(), order.getBranch().getNameEn(), order.getBranch().getPhone());
  
  ConsumerBean consben=new ConsumerBean(order.getConsumer().getPhone(), order.getConsumer().getEmail(), order.getConsumer().getPassword(), order.getConsumer().getFullname(),order.getConsumer().getGender());
 
  OrderBean obean =new OrderBean(order.getDeliveryFees(), order.getStatus());
  obean.setArea(aeabean);
  obean.setBranch(bbean);
  
return obean;
}

}
