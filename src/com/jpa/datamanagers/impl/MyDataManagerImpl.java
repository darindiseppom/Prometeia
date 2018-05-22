package com.jpa.datamanagers.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jpa.datamanagers.MyDataManager;
import com.jpa.mappers.MyMapper;

@Repository
public class MyDataManagerImpl implements MyDataManager{
	
	@Autowired
	private MyMapper myMapper;

	@Override
	public String getSession(Integer id) {
		return myMapper.selectSession(id);
	}

}
