package com.mapping.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mapping.jpa.model.Buyer;

@Repository
public interface BuyerDao extends JpaRepository<Buyer, Long>{

}
