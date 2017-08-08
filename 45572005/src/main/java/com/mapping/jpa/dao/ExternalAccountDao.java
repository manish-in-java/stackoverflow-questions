package com.mapping.jpa.dao;

import com.mapping.jpa.model.ExternalAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExternalAccountDao extends JpaRepository<ExternalAccount, Long>
{
}
