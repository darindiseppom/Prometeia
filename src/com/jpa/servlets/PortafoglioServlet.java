package com.jpa.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jpa.dao.PortafoglioDao;
import com.jpa.dao.SaldoDao;
import com.jpa.entities.Output;
import com.jpa.entities.Saldo;
import com.jpa.entities.StrumentoFinanziario;
import com.jpa.entities.Portafoglio;

@WebServlet(description = "Portafoglio",urlPatterns = { "/portafoglio" })
public class PortafoglioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PortafoglioServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ObjectMapper mapper = new ObjectMapper();
		
		String id = request.getParameter("id");
		StrumentoFinanziario strum = null;
		Double controvalore = 0.0;
		
		if(id!=null) {
			Portafoglio portafoglio = new PortafoglioDao().findById(Integer.parseInt(id));
			if(portafoglio != null) {
				List<Saldo> saldi = new SaldoDao().findByIdPtf(portafoglio.getId());
				for(Saldo s : saldi) {
					strum = s.getSaldopk().getStrumentoFinanziario();
					Collections.sort(strum.getSerieStorica());
					controvalore += s.getQuantita() * strum.getTassoCambio() * strum.getSerieStorica().get(0).getPrezzo();
				}
			}			
			mapper.writeValue(response.getOutputStream(), new Output(portafoglio, controvalore));
		}else {
			ArrayList<Portafoglio> portafogli = new ArrayList<Portafoglio>();
			portafogli = (ArrayList<Portafoglio>) new PortafoglioDao().findAll();
			mapper.writeValue(response.getOutputStream(), portafogli);
		}		
	}
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
