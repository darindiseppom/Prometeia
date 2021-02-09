package com.darin.test.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.darin.test.entity.Cliente;

@Repository
@Transactional(readOnly = true) 
public interface ClienteDao extends JpaRepository<Cliente, String> {	

}
