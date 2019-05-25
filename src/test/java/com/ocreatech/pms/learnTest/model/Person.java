package com.ocreatech.pms.learnTest.model;

import lombok.Data;

@Data
public class Person implements Cloneable{
	private String name;
	private String age;
	private Education education;

	public Person() {
	}
	
	public Person(String name, String age, Education education) {
		this.name = name;
		this.age = age;
		this.education =education;
	}

	@Override
	public Person clone() {
		Person p = null;
		try {
			p = (Person) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		p.education = education.clone();
		return p;
	}
}
