package com.jpa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.datalayer.dto.StringDTO;
import com.jpa.m2m.MyM2MFunctionConstants;
import com.jpa.m2m.MyM2MResponseService;
import com.jpa.response.StringResponse;
import com.jpa.service.MyService;


@RestController
@RequestMapping(value = "/rest", produces = MediaType.APPLICATION_JSON_VALUE)
public class MyController {

	@Autowired
	private MyService myService;

	@Autowired
	private MyM2MFunctionConstants function;
	
	@Autowired
	private MyM2MResponseService responseService;

	@RequestMapping(value = "/getSession", method = RequestMethod.GET)
	public ResponseEntity<StringResponse> getSession(@RequestParam(name = "id", required = true) Integer id) {

		String session = myService.getSession(id);
		
		/**
		 * Se ricevo una lista allora uso mapStructTo:
		 * 
		 * List<StringDTO> sessionsDTO = Lists.transform(session, function.stringToDTO);
		 * 
		 */

		StringDTO sessionDTO = responseService.mapStringDTO(session);

		StringResponse response = new StringResponse();
		response.setStringDTO(sessionDTO);

		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
