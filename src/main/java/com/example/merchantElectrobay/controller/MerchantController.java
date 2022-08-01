package com.example.merchantElectrobay.controller;

import com.example.merchantElectrobay.dto.MerchantDto;
import com.example.merchantElectrobay.entity.Merchant;
import com.example.merchantElectrobay.service.MerchantService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value ="/merchant")
@CrossOrigin(value = "*")
public class MerchantController {
    @Autowired
    MerchantService merchantService;

    @GetMapping(value = "/{id}")
    public Optional<MerchantDto> findById(@PathVariable("id") Integer id){
        Optional<Merchant> optionalCompany = merchantService.getMerchant(id);
        MerchantDto companyDto=null;
        if(optionalCompany.isPresent()){
            companyDto = new MerchantDto();
            BeanUtils.copyProperties(optionalCompany.get(),companyDto);
        }
        return Optional.ofNullable(companyDto);
    }

    @PostMapping
    public Merchant save(@RequestBody Merchant merchant){
        System.out.println(merchant.getEmailId());
        List<Merchant> u1 = merchantService.findByEmailId(merchant.getEmailId());
        System.out.println(u1);
        if(u1.size() == 0) {
            System.out.println("merchant not exists");
            return merchantService.save(merchant);
        }

        System.out.println("user is there");
        return null;
    }

    @GetMapping(value = "/login/{emailId}")
    public Merchant findByEmailId(@PathVariable("emailId") String emailId){
        System.out.println(emailId);
        List<Merchant> merchantList=merchantService.findByEmailId(emailId);

        if(merchantList.size()==0){
            System.out.println("null working");
            return null;
        }
        System.out.println("data working");
        return merchantList.get(0);
    }

    @GetMapping
    public Iterable<Merchant> findAll(){
        return merchantService.findAll();
    }


    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") int id){
        merchantService.delete(id);
    }
}
