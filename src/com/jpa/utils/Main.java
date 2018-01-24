package com.jpa.utils;
import java.util.List;
import com.jpa.dao.SaldoDao;
import com.jpa.entities.Saldo;

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