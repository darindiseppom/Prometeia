package com.darin.test.service;

import com.darin.test.entity.Cliente;

public interface ClienteService {

	public long count();
	public Cliente findById(String ndg);
	
}
