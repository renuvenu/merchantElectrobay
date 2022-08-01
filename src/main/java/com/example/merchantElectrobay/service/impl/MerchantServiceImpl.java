package com.example.merchantElectrobay.service.impl;

import com.example.merchantElectrobay.entity.Merchant;
import com.example.merchantElectrobay.repository.MerchantRepository;
import com.example.merchantElectrobay.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class MerchantServiceImpl implements MerchantService {

    @Autowired
    MerchantRepository merchantRepository;

    @Override
    public Optional<Merchant> getMerchant(int id) {
        return merchantRepository.findById(id);
    }

    @Override
    public Optional<Merchant> findById(int id) {
        return merchantRepository.findById(id);
    }

    @Override
    public Merchant save(Merchant merchant) {
        return merchantRepository.save(merchant);
    }

    @Override
    public void delete(int id) {
        merchantRepository.deleteById(id);
    }

    @Override
    public List<Merchant> findByEmailId(String emailId) {
        return merchantRepository.findByEmailId(emailId);
    }

    @Override
    public Iterable<Merchant> findAll() {
        return merchantRepository.findAll();
    }
}
