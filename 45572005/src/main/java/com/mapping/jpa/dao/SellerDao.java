package com.mapping.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mapping.jpa.model.Seller;

@Repository
public interface SellerDao extends JpaRepository<Seller, Long>{

}
