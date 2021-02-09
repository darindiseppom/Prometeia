package com.darin.test.response;

import java.util.Collections;
import java.util.List;

import com.darin.test.model.dto.ClienteDTO;

import lombok.Data;

@Data
public class ClientiResponse {
	
	private List<ClienteDTO> list = Collections.emptyList();

}
