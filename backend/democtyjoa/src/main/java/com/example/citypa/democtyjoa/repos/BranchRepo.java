/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.citypa.democtyjoa.repos;

import com.example.citypa.democtyjoa.entitys.Branch;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ADMIN
 */
@Repository
public interface BranchRepo extends CrudRepository<Branch, Integer>{
    public Branch findById(int id);
    
}
