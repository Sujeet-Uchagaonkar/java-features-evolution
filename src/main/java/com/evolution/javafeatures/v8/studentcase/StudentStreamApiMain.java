package com.evolution.javafeatures.v8.studentcase;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudentStreamApiMain {

	public static void main(String[] args) {

		Student student1 = new Student("Jayesh", 20, new Address("1234"),
				Arrays.asList(new MobileNumber("1233"), new MobileNumber("1234")));

		Student student2 = new Student("Khyati", 20, new Address("1235"),
				Arrays.asList(new MobileNumber("1111"), new MobileNumber("3333"), new MobileNumber("1233")));

		Student student3 = new Student("Jason", 20, new Address("1236"),
				Arrays.asList(new MobileNumber("3333"), new MobileNumber("4444")));

		 List<Student> students = Arrays.asList(student1, student2, student3);
		
		 
		 
		 
		 //Get student with exact match name "jayesh"
		 System.out.println("Get student with exact match name jayesh: ");
		 students.stream().filter(s -> s.getName().equals("Jayesh")).forEach(System.out::println);
		 
		 
		 //Get student with matching address "1235"
		 System.out.println("----------------------------------------");
		 System.out.println("Get student with matching address 1235: ");
		 students.stream().filter(s -> s.getAddress().equals("1235")).forEach(s -> System.out.println(s.toString()));
		 
		 
		 //Get all student having mobile numbers 3333
		 System.out.println("----------------------------------------");
		 System.out.println("Get all student having mobile numbers 3333: ");
		 List<Student> stud3333 = students.stream().filter(s -> s.getMobileNumbers().stream().anyMatch(m -> m.getNumber().equals("3333"))).collect(Collectors.toList());
		 stud3333.stream().map(s -> s.getName()).collect(Collectors.toList()).forEach(System.out::println);;
		 

		//Get all student having mobile number 1233 and 1234
		 System.out.println("----------------------------------------");
		 System.out.println("Get all student having mobile number 1233 and 1234: ");
		 students.stream().filter(s -> s.getMobileNumbers().stream().anyMatch(m -> m.getNumber().equals("1233") || m.getNumber().equals("1234"))).collect(Collectors.toList()).
		 forEach(System.out::println);
		 
		 
		//Create a List<Student> from the List<TempStudent>
		 TempStudent tmpStud1 = new TempStudent(
		            "Jayesh1",
		            201,
		            new Address("12341"),
		            Arrays.asList(new MobileNumber("12331"), new MobileNumber("12341")));
		 
		        TempStudent tmpStud2 = new TempStudent(
		            "Khyati1",
		            202,
		            new Address("12351"),
		            Arrays.asList(new MobileNumber("11111"), new MobileNumber("33331"), new MobileNumber("12331")));
		 
		        List<TempStudent> tmpStudents = Arrays.asList(tmpStud1, tmpStud2);
		 System.out.println("----------------------------------------");
		 System.out.println("Create a List<Student> from the List<TempStudent>: ");
		 tmpStudents.stream().map(tmpStudent -> new Student(tmpStudent.name, tmpStudent.age, tmpStudent.address, tmpStudent.mobileNumbers))
		 .collect(Collectors.toList()).forEach(stud -> System.out.println(stud));;
		 
		 
		 
		 
		//Convert List<Student> to List<String> of student name
		 System.out.println("----------------------------------------");
		 System.out.println("Convert List<Student> to List<String> of student name: ");
		 students.stream().map(s -> s.getName()).collect(Collectors.toList()).forEach(System.out::println);
		 
		 
		 
		//Convert List<students> to String
		 System.out.println("----------------------------------------");
		 System.out.println("Convert List<students> to String: ");
		 String studentNames = students.stream().map(Student::getName).collect(Collectors.joining(",", "[", "]"));
		 System.out.println(studentNames);
		 
		 
		//Change the case of List<String> to upper
		 System.out.println("----------------------------------------");
		 System.out.println("Change the case of List<String> to upper: ");
		 students.stream().map(Student::getName).map(String::toUpperCase).collect(Collectors.toList()).forEach(s -> System.out.println(s));
		 
		 
		//Change the case of List<String> to lower
		 System.out.println("----------------------------------------");
		 System.out.println("Change the case of List<String> to lower: ");
		 students.stream().map(s -> s.getName()).map(s -> s.toLowerCase()).collect(Collectors.toList()).forEach(s -> System.out.println(s));
		 
		 
		 //Sort List<String>
		 System.out.println("----------------------------------------");
		 System.out.println("Sort List<String>: ");
		 students.stream().map(s -> s.getName()).collect(Collectors.toList()).stream().sorted().forEach(s -> System.out.println(s));
		 
		 
		 //Conditionally apply Filter condition, say if flag is enabled then.
		 Stream<Student> studentsWithNameStartJ = students.stream().filter(s ->s.getName().startsWith("J"));
		 System.out.println("----------------------------------------");
		 System.out.println("Student names list before sorting: ");
		 studentsWithNameStartJ.map(s -> s.getName()).collect(Collectors.toList()).forEach(s -> System.out.println(s));
		 System.out.println("Student names list after sorting: ");
		/* studentsWithNameStartJ.sorted(Comparator.comparing(Student::getName)).map(s -> s.getName()).collect(Collectors.toList()).
				 forEach(s -> System.out.println(s));*/
		 
		 
	}

}
