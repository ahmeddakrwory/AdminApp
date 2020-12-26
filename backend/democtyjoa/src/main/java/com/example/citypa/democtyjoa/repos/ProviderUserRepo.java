/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.citypa.democtyjoa.repos;

import com.example.citypa.democtyjoa.entitys.ProviderUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ADMIN
 */
@Repository
public interface ProviderUserRepo extends CrudRepository<ProviderUser, Integer>{
    public  ProviderUser findById(int id);
    public ProviderUser findByUsername(String username);
    
}
