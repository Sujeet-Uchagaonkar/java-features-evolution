package com.evolution.javafeatures.v8.main;

import com.evolution.javafeatures.v8.entity.Employee;
import com.evolution.javafeatures.v8.interfaces.AddFloatInterface;
import com.evolution.javafeatures.v8.interfaces.AddIntInterface;
import com.evolution.javafeatures.v8.interfaces.CheckDuplicateEmpInterface;
import com.evolution.javafeatures.v8.interfaces.EmpAggregateInteface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class LambadaDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// Lambada for simple for each loop 
		List<Integer> intList = new ArrayList<>();
		intList.addAll(Arrays.asList(15, 85, 66, 17, 11, 11));
		intList.forEach((i) -> System.out.println("List of integers: "+i));
		
		
		
		// Lambada for complex object for each loop 
		Employee emp1 = new Employee(1, "abc");
		Employee emp2 = new Employee(1, "xyz");
		List<Employee> empList = new ArrayList<>(Arrays.asList(emp1, emp2));
		empList.forEach(emp -> {
			System.out.println(emp.getEmpId() + " | " + emp.getEmpName());
		});



		// Lambada with functional interface for each loop 
		EmpAggregateInteface empAggregateInteface = (empNm1, empNm2) -> (empNm1 + empNm2);
		System.out.println("Employee Aggregated Names: "
				+ empAggregateInteface.aggregateEmps(emp1.getEmpName(), emp2.getEmpName()));

		CheckDuplicateEmpInterface checkDuplicateEmpInterface = (checkEmp1,
																 checkEmp2) -> ((checkEmp1.getEmpId().equals(checkEmp2.getEmpId()) ? Boolean.TRUE : Boolean.FALSE));
		System.out.println("Are those employees duplicate: " + checkDuplicateEmpInterface.isDuplicateEmp(emp1, emp2));




		// Lambada for each loop with logic
		List<String> empWithAstartName = new ArrayList<>();
		empList.forEach(emp -> {
			if(emp.getEmpName().startsWith("a"))
			empWithAstartName.add(emp.getEmpName());
		});
		System.out.println("Employees having name starts with a : "+empWithAstartName);
		
		
		
		// Lambada with functional interface for each loop 
		AddIntInterface ad1 = (a, b) -> (a + b);
		AddIntInterface ad2 = (a, b) -> (a - b);
		System.out.println("add1 interface result: " + ad1.addInt(15, 23));
		System.out.println("add2 interface result: " + ad2.addInt(15, 23));

		AddFloatInterface addFloatInterface = (f1, f2) -> (f1 + f2);
		System.out.println("addFloatInterface result: " + addFloatInterface.addFlaot(1.5f, 23.8f));
	}

}
