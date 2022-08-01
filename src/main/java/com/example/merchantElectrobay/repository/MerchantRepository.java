package com.example.merchantElectrobay.repository;

import com.example.merchantElectrobay.entity.Merchant;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MerchantRepository extends CrudRepository<Merchant,Integer> {
    @Query(value = "select * from merchant where email_id = ?1", nativeQuery = true)
    List<Merchant> findByEmailId(String email);
}
