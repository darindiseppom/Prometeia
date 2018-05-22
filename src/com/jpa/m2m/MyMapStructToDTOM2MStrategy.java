package com.jpa.m2m;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR, componentModel = "spring", uses = { })
public interface MyMapStructToDTOM2MStrategy {

//	StringDTO toStringDTO(String source);
	
}
