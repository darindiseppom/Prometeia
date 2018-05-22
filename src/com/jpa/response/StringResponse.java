package com.jpa.response;

import java.util.List;

import com.jpa.datalayer.dto.StringDTO;
import com.jpa.datalayer.dto.generic.ResponseRS;

public class StringResponse extends ResponseRS {
	private StringDTO stringDTO;
	private String output;
	private List<String> strings;
	public List<String> getStrings() {
		return strings;
	}

	public void setStrings(List<String> strings) {
		this.strings = strings;
	}

	public String getOutput() {
		return output;
	}

	public void setOutput(String output) {
		this.output = output;
	}

	public StringDTO getStringDTO() {
		return stringDTO;
	}

	public void setStringDTO(StringDTO stringDTO) {
		this.stringDTO = stringDTO;
	}
	
}
