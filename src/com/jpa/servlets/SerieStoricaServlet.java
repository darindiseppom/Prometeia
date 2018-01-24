
package com.jpa.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jpa.dao.ClienteDao;
import com.jpa.dao.SerieStoricaDao;
import com.jpa.entities.Cliente;
import com.jpa.entities.SeriePk;
import com.jpa.entities.SerieStorica;

@WebServlet(description = "serie", urlPatterns = { "/serie" })
public class SerieStoricaServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private SerieStoricaDao serieDao = new SerieStoricaDao();
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		
		String codice = request.getParameter("titolo");
		String data = request.getParameter("data");
	
		if(codice != null && data == null) {
			List<SerieStorica> serie = serieDao.findByCodice(codice);
			mapper.writeValue(response.getOutputStream(), serie);
		}else if(codice != null && data != null){
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			try {
				Date date = formatter.parse(data);
				SerieStorica serie = serieDao.findById( new SeriePk(codice, date) );
				mapper.writeValue(response.getOutputStream(), serie);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
	}
}