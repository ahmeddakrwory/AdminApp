/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.citypa.democtyjoa;

import com.example.citypa.democtyjoa.beans.ProviderUserBean;
import com.example.citypa.democtyjoa.entitys.Branch;
import com.example.citypa.democtyjoa.entitys.Provider;
import com.example.citypa.democtyjoa.entitys.ProviderUser;
import com.example.citypa.democtyjoa.repos.BranchRepo;
import com.example.citypa.democtyjoa.repos.ProviderRepo;
import com.example.citypa.democtyjoa.repos.ProviderUserRepo;
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
public class ProviderUserRest {
    @Autowired
    private ProviderUserRepo providerUserRepo;
    @Autowired
    private BranchRepo branchRepo;
    @Autowired
    private ProviderRepo provrepo;
    
    @GetMapping("/adduserProv")
    public ProviderUserBean addProvideruser(@RequestParam(value = "bID") String branchid,@RequestParam(value = "pid")String pid,@RequestBody ProviderUserBean providerUserBean ){
      int bid=Integer.parseInt(branchid);
        Branch branch=branchRepo.findById(bid);
        branch.setId(bid);
        int providerid=Integer.parseInt(pid);
        
        Provider provider=provrepo.findById(providerid);
        provider.setId(providerid);

        
ProviderUser providerUser=new ProviderUser();
providerUser.setUsername(providerUserBean.getUsername());
providerUser.setBranch(branch);
providerUser.setPassword(providerUserBean.getPassword());
providerUser.setProvider(provider);
providerUser.setActive(providerUserBean.getActive());
providerUserRepo.save(providerUser);
return providerUserBean;
 }
@PostMapping("/deletepu")
public void deleteprovideruser(@RequestParam(value = "id") String usernid){
    ProviderUser pu=providerUserRepo.findByUsername(usernid);
    System.out.println("g");
providerUserRepo.delete(pu);

}
@PostMapping(value = "/updatepu")
public ProviderUserBean updateProvuderUser(@RequestParam(value = "upId")String puId,@RequestBody ProviderUserBean provideruserbean){
    int id=Integer.parseInt(puId);
    ProviderUser prvUSer=providerUserRepo.findById(id);
    prvUSer.setActive(provideruserbean.getActive());
    prvUSer.setUsername(provideruserbean.getUsername());
    prvUSer.setPassword(provideruserbean.getPassword());
   providerUserRepo.save(prvUSer);
   return provideruserbean;
    
}
@GetMapping("/findprov")
public ProviderUserBean findprvider(@RequestParam(value = "id") String id){
    int pid=Integer.parseInt(id);
    ProviderUser prvuser=providerUserRepo.findById(pid);
    ProviderUserBean provideb=new ProviderUserBean(prvuser.getUsername(), prvuser.getPassword());
            return provideb;
    
}
}
