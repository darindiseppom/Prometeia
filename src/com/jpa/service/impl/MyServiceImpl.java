package com.jpa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.datamanagers.MyDataManager;
import com.jpa.service.MyService;


@Service
public class MyServiceImpl implements MyService{
	
	@Autowired
	private MyDataManager myDataManager;

	@Override
	public String getSession(Integer id) {
		return myDataManager.getSession(id);
	}

}
