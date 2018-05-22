package com.jpa.entities;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table( name = "TEST")
public class TestEntity {

	@Embedded
	private TestUnique1 testUnique1;	

	@Embedded
	private TestUnique2 testUnique2;
	
	@Column( name = "COLUMN3")
	private String label;

	public TestUnique1 getTestUnique1() {
		return testUnique1;
	}

	public void setTestUnique1(TestUnique1 testUnique1) {
		this.testUnique1 = testUnique1;
	}

	public TestUnique2 getTestUnique2() {
		return testUnique2;
	}

	public void setTestUnique2(TestUnique2 testUnique2) {
		this.testUnique2 = testUnique2;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	@Override
	public String toString() {
		return "TestEntity [testUnique1=" + testUnique1 + ", testUnique2=" + testUnique2 + ", label=" + label + "]";
	}
	
	
	
}
