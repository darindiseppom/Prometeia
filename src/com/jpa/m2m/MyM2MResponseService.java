package com.jpa.m2m;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jpa.datalayer.dto.StringDTO;

@Component
public class MyM2MResponseService {

	private static final Logger LOG = LoggerFactory.getLogger(MyM2MResponseService.class);
	
	@Autowired
	private MyMapStructToDTOM2MStrategy mapStructTo;
	
	public StringDTO mapStringDTO(String source) {
		
		try {
			/**
			 * Non riesco a fare tutto il giro (forse a causa di qualcosa di automatica da parte di mapStructTo quindi il mapping lo faccio qua
			 * 
			 * return mapStructTo.toStringDTO(source);
			 */
			
			StringDTO stringDTO = new StringDTO();
			stringDTO.setString(source);			
			return stringDTO;
			
		} catch (Exception e) {
			
			LOG.error("error converting 'String' bean in DTO", e);
			return new StringDTO();
		}
	}

}
