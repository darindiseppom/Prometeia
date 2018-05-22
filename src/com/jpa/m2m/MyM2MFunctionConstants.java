package com.jpa.m2m;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jpa.datalayer.dto.StringDTO;

@Component
public class MyM2MFunctionConstants {
	
	@Autowired
	private MyM2MResponseService responseService;	
	
	// FIXME - Cercare di importare Function dalla libreria di google e non dalla util di java
	public final Function<String, StringDTO> stringToDTO = new Function<String, StringDTO>() {
		@Override
		public StringDTO apply(String input) {
			return responseService.mapStringDTO(input);
		}
	};

}
