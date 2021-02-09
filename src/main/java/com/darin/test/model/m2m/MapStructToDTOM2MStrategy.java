package com.darin.test.model.m2m;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.darin.test.entity.Cliente;
import com.darin.test.model.dto.ClienteDTO;

@Mapper(componentModel = "spring")
public interface MapStructToDTOM2MStrategy {
	
	MapStructToDTOM2MStrategy INSTANCE = Mappers.getMapper( MapStructToDTOM2MStrategy.class );
	
	ClienteDTO toClienteDTO(Cliente source);
	
}
