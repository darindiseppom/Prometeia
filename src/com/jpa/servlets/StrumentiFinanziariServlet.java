
package com.jpa.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jpa.dao.StrumentoFinanziarioDao;
import com.jpa.entities.StrumentoFinanziario;

@WebServlet(description = "strumentiFinaziari", urlPatterns = { "/strumenti" })
public class StrumentiFinanziariServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private StrumentoFinanziarioDao strumentiFinanziariDao = new StrumentoFinanziarioDao();
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		
		String codice = request.getParameter("codice");
		if(codice == null) {
			List<StrumentoFinanziario> strumenti = strumentiFinanziariDao.findAll();
			mapper.writeValue(response.getOutputStream(), strumenti);
		}else {
			StrumentoFinanziario strumento = strumentiFinanziariDao.findById(codice);
			mapper.writeValue(response.getOutputStream(), strumento);
		}
	}
}
