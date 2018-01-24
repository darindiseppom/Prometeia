package com.jpa.servlets;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.jpa.dao.ClienteDaoSpring;
import com.jpa.entities.Cliente;
import com.jpa.response.ClientiResponse;

@RestController
@RequestMapping(value= "/rest", produces = MediaType.APPLICATION_JSON_VALUE )
public class ClientiServlet2  {
	
	@Autowired
	private ClienteDaoSpring clienteDao = new ClienteDaoSpring();
	
	@RequestMapping(value = "/clienti/{ndg}", method = RequestMethod.GET)
	protected ResponseEntity<ClientiResponse> getClienti(@PathVariable("ndg") String ndg) {
		ClientiResponse response = new ClientiResponse(); 		
		List<Cliente> clienti = new ArrayList<>();		
		/*if(ndg == null && nome == null && cognome == null) {
			clienti = clienteDao.findAll();
		} else */if(ndg != null ){
			clienti = new ArrayList<>();
			Cliente cliente = clienteDao.findById(ndg);	
			clienti.add(cliente);
		} /*else if(nome!=null && cognome!=null) {
			clienti = clienteDao.findByNomeCognome(nome, cognome);
		} else if(nome!=null) {
			clienti = clienteDao.findByNome(nome);
		} else if(cognome!=null) {
			clienti = clienteDao.findByCognome(cognome);
		}		*/
		response.setList(clienti);
		return new ResponseEntity<>(response, HttpStatus.OK);		
	}
}
