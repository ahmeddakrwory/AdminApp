/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.citypa.democtyjoa.repos;

import com.example.citypa.democtyjoa.entitys.DeliveryArea;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author ADMIN
 */
public interface DeliveryAreaRepo  extends CrudRepository<DeliveryArea, Integer>{
    public DeliveryArea findById(int id);
    
}
