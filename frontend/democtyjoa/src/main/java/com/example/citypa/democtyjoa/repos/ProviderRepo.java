/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.citypa.democtyjoa.repos;

import com.example.citypa.democtyjoa.entitys.Provider;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ADMIN
 */
@Repository
public interface ProviderRepo extends CrudRepository<Provider, Integer>{
    public Provider findById(int id);
    
}
