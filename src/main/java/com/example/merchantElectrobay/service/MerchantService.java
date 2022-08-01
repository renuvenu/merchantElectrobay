package com.example.merchantElectrobay.service;

import com.example.merchantElectrobay.entity.Merchant;

import java.util.List;
import java.util.Optional;

public interface MerchantService {
    Optional<Merchant> getMerchant(int id);
    Optional<Merchant> findById(int id);
    Merchant save(Merchant merchant);
    void delete(int id);
    List<Merchant> findByEmailId(String emailId);
    Iterable<Merchant> findAll();

}
