package com.jpa.utils;

import java.util.Date;
import java.util.List;

import com.jpa.dao.ClienteDao;
import com.jpa.dao.PortafoglioDao;
import com.jpa.dao.SaldoDao;
import com.jpa.dao.SerieStoricaDao;
import com.jpa.dao.StrumentoFinanziarioDao;
import com.jpa.entities.Cliente;
import com.jpa.entities.Portafoglio;
import com.jpa.entities.Saldo;
import com.jpa.entities.SerieStorica;
import com.jpa.entities.StrumentoFinanziario;

public class Main {

	public static void main(String[] args) {


		
		List<Saldo> s = new SaldoDao().findAll();
		
		for (Saldo c : s)
			try {
			System.out.println(c);
			} catch (Exception e) {
				new SaldoDao().delete(c);
			}
		
	}

}