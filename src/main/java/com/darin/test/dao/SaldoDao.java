package com.darin.test.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.darin.test.entity.Saldo;
import com.darin.test.entity.SaldoPk;

@Repository
@Transactional(readOnly = true)
public interface SaldoDao extends JpaRepository<Saldo, SaldoPk> {	

}
