
package com.jpa.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jpa.dao.ClienteDao;
import com.jpa.entities.Cliente;

@WebServlet(description = "clienti", urlPatterns = { "/clienti" })
public class ClientiServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private ClienteDao clienteDao = new ClienteDao();
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		
		String ndg = request.getParameter("ndg");
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		
		if(ndg == null && nome==null && cognome==null) {
			List<Cliente> clienti = clienteDao.findAll();
			mapper.writeValue(response.getOutputStream(), clienti);
		}else if(ndg != null ){
			Cliente cliente = clienteDao.findById(ndg);		
			mapper.writeValue(response.getOutputStream(), cliente);
		}else if(nome!=null && cognome!=null) {
			List<Cliente> clienti = clienteDao.findAll();
			List<Cliente> resultList = new ArrayList<Cliente>();
			for(Cliente c : clienti) {
				if(c.getNome().startsWith(nome) && c.getCognome().startsWith(cognome))
					resultList.add(c);
			}
			mapper.writeValue(response.getOutputStream(), resultList);
		}else if(nome!=null) {
			List<Cliente> clienti = clienteDao.findAll();
			List<Cliente> resultList = new ArrayList<Cliente>();
			for(Cliente c : clienti) {
				if(c.getNome().startsWith(nome))
					resultList.add(c);
			}
			mapper.writeValue(response.getOutputStream(), resultList);
		}else if(cognome!=null) {
			List<Cliente> clienti = clienteDao.findAll();
			List<Cliente> resultList = new ArrayList<Cliente>();
			for(Cliente c : clienti) {
				if(c.getCognome().startsWith(cognome))
					resultList.add(c);
			}
			mapper.writeValue(response.getOutputStream(), resultList);
		}
	}
}
