package com.evolution.javafeatures.v8.studentcase;

import com.evolution.javafeatures.v8.studentcase.Address;
import com.evolution.javafeatures.v8.studentcase.MobileNumber;

import java.util.List;

public class TempStudent {
	public String name;
	public int age;
	public Address address;
	public List<MobileNumber> mobileNumbers;

	public TempStudent(String name, int age, Address address, List<MobileNumber> mobileNumbers) {
		this.name = name;
		this.age = age;
		this.address = address;
		this.mobileNumbers = mobileNumbers;
	}
}
