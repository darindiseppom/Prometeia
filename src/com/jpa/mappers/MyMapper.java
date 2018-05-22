package com.jpa.mappers;

import org.apache.ibatis.annotations.Param;

public interface MyMapper {
	
	String selectSession(@Param("id") Integer id);

}
