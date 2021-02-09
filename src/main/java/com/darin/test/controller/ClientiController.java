package com.darin.test.controller;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.darin.test.entity.Cliente;
import com.darin.test.model.dto.ClienteDTO;
import com.darin.test.model.m2m.MapStructToDTOM2MStrategy;
import com.darin.test.response.ClientiResponse;
import com.darin.test.service.ClienteService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/rest", produces = MediaType.APPLICATION_JSON_VALUE)
public class ClientiController {

	@Autowired
	private ClienteService clienteService;

	@GetMapping(value = "/clienti/{ndg}")
	protected ResponseEntity<ClientiResponse> getClienti(@PathVariable("ndg") String ndg) {

		ClientiResponse response = new ClientiResponse();

		Cliente cliente = clienteService.findById(ndg);
		if (cliente == null) {
			log.warn("{} not found", ndg);
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		ClienteDTO clienteDTO = MapStructToDTOM2MStrategy.INSTANCE.toClienteDTO(cliente);

		response.setList(Arrays.asList(clienteDTO));
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
