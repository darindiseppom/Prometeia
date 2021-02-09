package com.darin.test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.darin.test.dao.ClienteDao;
import com.darin.test.entity.Cliente;
import com.darin.test.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
	private ClienteDao dao;

	@Override
	public long count() {
		return dao.count();
	}

	@Override
	public Cliente findById(String ndg) {
		return dao.findById(ndg).orElse(null);
	}
	
	
}
