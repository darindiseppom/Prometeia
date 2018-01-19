package com.jpa.response;

import java.util.Collections;
import java.util.List;

import com.jpa.entities.Cliente;

public class ClientiResponse {
	
	private List<Cliente> list = Collections.emptyList();

	public List<Cliente> getList() {
		return list;
	}

	public void setList(List<Cliente> list) {
		this.list = list;
	}

}
