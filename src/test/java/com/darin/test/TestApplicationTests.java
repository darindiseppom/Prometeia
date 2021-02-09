package com.darin.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.darin.test.entity.Cliente;
import com.darin.test.model.dto.ClienteDTO;
import com.darin.test.model.m2m.MapStructToDTOM2MStrategy;

@SpringBootTest
class TestApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Test
	void shouldMapClienteToDto() {
		//given
	    Cliente cliente = new Cliente("NDG", "Nome", "Cognome");
	 
	    //when
	    ClienteDTO clienteDto = MapStructToDTOM2MStrategy.INSTANCE.toClienteDTO(cliente);
	 
	    //then
	    assertThat( clienteDto ).isNotNull();
	    assertThat( clienteDto.getNdg() ).isEqualTo( "NDG" );
	    assertThat( clienteDto.getNome() ).isEqualTo( "Nome" );
	    assertThat( clienteDto.getCognome() ).isEqualTo( "Cognome" );
	}

}
