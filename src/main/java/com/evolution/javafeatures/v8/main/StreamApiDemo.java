package com.evolution.javafeatures.v8.main;

import com.evolution.javafeatures.v8.entity.Employee;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamApiDemo {

	public static void main(String[] args) {

		
		List<Integer> intList = new ArrayList<>();
		intList.addAll(Arrays.asList(15, 85, 66, 17, 11, 11, -26, -21));
		
		List<Integer> intListGreaterThan50 = intList.stream().filter(i -> i > 50).collect(Collectors.toList());
		System.out.println("Greater than 50 values in list: ");
		intListGreaterThan50.forEach(i -> System.out.println(i));

		List<Integer> intListMinusValues = intList.stream().filter(i -> i < 0).collect(Collectors.toList());
		System.out.println("Negative values in list: ");
		intListMinusValues.forEach(i -> System.out.println(i));
		
		List<Integer> intListPositiveValues = intList.stream().filter(i -> i>=0).collect(Collectors.toList());
		System.out.println("Positive values in list: ");
		intListPositiveValues.forEach(i -> System.out.println(i));
		
		
		Set<Integer> intUniquePositiveValues = new HashSet<>(intListPositiveValues);
		System.out.println("Positive unique values in list: ");
		intUniquePositiveValues.forEach(i -> System.out.println(i));
		
		
		

		Employee emp1 = new Employee(1, "abc");
		Employee emp2 = new Employee(2, "xyz");
		Employee emp3 = new Employee(3, "pqr");
		List<Employee> empList = new ArrayList<>(Arrays.asList(emp1, emp2, emp3));
		

		System.out.print("Employees with name contains y : ");
		empList.stream().filter(e -> e.getEmpName().contains("y")).limit(0).map(e -> e.getEmpName())
				.collect(Collectors.toList()).forEach(System.out::println);
		;

		System.out.print("Employees with emp id greater than 2 : ");
		empList.stream().filter(emp -> emp.getEmpId() > 2).map(e -> e.getEmpId()).collect(Collectors.toList())
				.forEach(System.out::println);


		System.out.print("Employees with emp id greater than 1 with null checks: "+
				empList.stream()
						.filter(Objects :: nonNull)
						.filter(e -> (Objects.nonNull(e.getEmpId()) && e.getEmpId() > 1))
						.map(Employee:: getEmpId)
						.collect(Collectors.toList()));
		
		
		
		System.out.print("Employees with name contains p : ");
		empList.stream().filter(e -> e.getEmpName().contains("p")).map(e -> e.getEmpName()).collect(Collectors.toList())
				.forEach(System.out::println);
		
		System.out.print("Employee id of xyz: ");
		empList.stream().filter(e -> e.getEmpName().equalsIgnoreCase("xyz")).map(e -> e.getEmpId()).forEach(System.out::println);;
		
		
		Map<Integer,String> empMap = new HashMap<>();
		empMap = empList.stream().collect(Collectors.toMap(e -> e.empId, e -> e.empName));
		System.out.print("Employee map values: ");
		empMap.entrySet().forEach(e -> System.out.println(e.getKey()+ " | "+e.getValue()));
		System.out.println("Does Employee map has emp with >2 id: "+empMap.entrySet().stream().anyMatch(e -> e.getKey()>3));
		System.out.println("Max key in emp map: "+Collections.max(empMap.keySet()));
		
		
		
		System.out.print("Sorted employee names : ");
		empList.stream().map(e -> e.getEmpName()).collect(Collectors.toList()).stream().sorted().forEach(System.out::println);
		
		
		
		// Count characters in given string
		String name = "Sujeet";
		Map<Character, Long> charCountMap = new HashMap<>();
		charCountMap = name.chars().mapToObj(ch -> (char) ch).collect(
				Collectors.groupingBy(ch -> ch, Collectors.counting())
		);
		System.out.println("Character counts for given string: ");
		charCountMap.entrySet().forEach(System.out :: println);

		

		// joining method with sorting & compartor
		List<String> subjects = Arrays.asList("Java", "Python", "Go");
		String subjectsJoined = subjects.stream().sorted().collect(Collectors.joining("|"));
		System.out.println("Subjects joining with Pipe: "+subjectsJoined);
		String subjectsJoinedReverse = subjects.stream().sorted(Comparator.reverseOrder()).collect(Collectors.joining("|"));
		System.out.println("Subjects joining with Pipe in revers order : "+subjectsJoinedReverse);


		List<String> strings = Arrays.asList("a", "bb", "ccc", "dd", "eee");
		Map<Integer, List<String>> grouped = strings.stream()
				.collect(Collectors.groupingBy(String::length));
		System.out.println("Group Strings by Length : "+grouped);
		
		Stream.iterate(1, i -> i+1).filter(i -> i%3==0).limit(5).forEach(System.out::println);
		
		Stream.iterate(99, i -> i-1).limit(3).forEach(System.out::println);





		//Find the Sum of All Elements in a List
		List<Integer> numbers = List.of(1, 2, 3, 4, 5);
		int sum = numbers.stream().mapToInt(Integer::intValue).sum();
		System.out.println("Sum: " + sum);

		//Find the Product of All Elements in a List
		int product = numbers.stream().reduce(1, (a, b) -> a * b);
		System.out.println("Product of all elements in list: " + product);

		//Find the Last Element in a List
		int last = numbers.stream().reduce((a, b) -> b).orElse(0);
		System.out.println("Last Element: " + last);

		//Find the Product of All Elements in a List
		int min = numbers.stream().min(Integer::compare).orElse(0);
		System.out.println("Min: " + min);

		//Sort numbers in order
		List<Integer> sortedNumbers = numbers.stream().sorted().collect(Collectors.toList());
		System.out.println("Sorted Numbers: " + sortedNumbers);
		List<Integer> sortedReverseNumbers = numbers.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		System.out.println("Sorted Reverse Numbers: " + sortedNumbers);

		// Find second largest number in list
		System.out.println("Second largest number in list: " + numbers.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().orElse(0));

		//Find the Second-Smallest Element in a List
		System.out.println("Second smallest number in list: " +numbers.stream().sorted(Comparator.naturalOrder()).skip(1).findFirst().orElse(0) );

		//Partition a List of Integers into Even and Odd Numbers
		System.out.println("Partition a List of Integers into Even and Odd Numbers: " +numbers.stream().collect(
			Collectors.partitioningBy(n -> n%2 ==0)));

		//Find the Sum of Digits of a Number
		int number = 12345;
		System.out.println("Sum of number in given number: "+String.valueOf(number).chars().map(Character :: getNumericValue).sum());


		// Find factorial of number
		int num = 5;
		System.out.println("Factorial of given number: "+ IntStream.rangeClosed(1,num).reduce(1, (a,b) -> a*b));
		// NOTE : the difference between range() and rangeClosed() is : in rangeClosed : upper bound is included and in range method it is excluded




		//Group a List of Strings by Their Length
		List<String> words = List.of("apple", "banana", "kiwi", "guava", "orange");
		System.out.println("Group a List of Strings by Their Length: "+
				words.stream().collect(Collectors.groupingBy(s -> s.length()))
		);
		// Count the Occurrences of Each Element in a List
		System.out.println("Group a List of Strings by Their Length: "+
				words.stream().collect(Collectors.groupingBy(w -> w, Collectors.counting()))
		);


		//Count the Occurrences of Each Vowel in a String
		String input = "hello";
		List<Character> vowels = Arrays.asList('a','e','i','o','u');
		Map<Character, Long> map = input.chars().mapToObj(ch -> (char) ch).filter(ch -> vowels.contains(ch)).collect(Collectors.groupingBy(
				ch -> ch, Collectors.counting()
		));
		System.out.println("Count the Occurrences of Each Vowel in a String: "+map);

		//Reverse a String Using Streams
		System.out.println("Reverse a String Using Streams: "+input.chars().mapToObj(ch -> String.valueOf((char) ch)).
				reduce("",(a,b) ->(b+a)));


		//Find the Most Frequent Element in a List
		List<String> fruits = List.of("apple", "banana", "apple", "orange", "banana", "apple");
		System.out.println("Most Frequent Element in a List: "+
				fruits.stream().collect(Collectors.groupingBy(f -> f, Collectors.counting()))
				.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey());

		//Find the Least Frequent Element in a List
		System.out.println("Least Frequent Element in a List: "+
				fruits.stream().collect(Collectors.groupingBy(f -> f, Collectors.counting()))
						.entrySet().stream().min(Map.Entry.comparingByValue()).get().getKey());


		// Find the First Non-Repeated Character in a String
		String temp1 = "hello hi";
		System.out.println("First Non-Repeated Character in a String: "+
				temp1.chars().mapToObj(ch -> (char) ch).
						collect(Collectors.groupingBy(ch -> ch, LinkedHashMap::new, Collectors.counting())) //LinkedHashMap to maintain order as we need first occurance
						.entrySet().stream().filter(e -> e.getValue() == 1).findFirst().get().getKey());

		// Find the First Repeated Character in a String
		String temp2 = "hello";
		System.out.println("First Repeated Character in a String: "+
				temp2.chars().mapToObj(ch -> (char) ch).collect(Collectors.groupingBy(ch -> ch, Collectors.counting()))
						.entrySet().stream().filter(e -> e.getValue() >1).findFirst().get().getKey());



		//Check if a String is a Palindrome
		String palindromeInput = "madam";
		System.out.println("Is given string palindrome? : "+
		IntStream.range(0,palindromeInput.length()/2)
				.allMatch(i -> palindromeInput.charAt(i) == palindromeInput.charAt(palindromeInput.length() -1 -i)));



		//Check if a 2 Strings are anagram or not
		String anagramInput1 = "salt";
		String anagramInput2 = "last";
		System.out.println("Are given strings anagram? : "+
			Arrays.equals(anagramInput1.chars().sorted().toArray(), anagramInput2.chars().sorted().toArray()));


		// Fibonacci Sequence Using Streams : First 15 numbers
		System.out.println("Fibonnaci series woth first 15 numbers: "+
			Stream.iterate(new int[]{0,1}, arr -> new int[]{arr[1], arr[0] + arr[1]}) //: Creates an infinite stream starting with the seed [0, 1]. Each subsequent pair is generated by summing the previous two numbers.
					.limit(15)
					.map(arr -> arr[0]) //map(arr -> arr[0]): Extracts the first element of each pair (the Fibonacci number).
					.collect(Collectors.toList()));


		//Generate random numbers
		System.out.println("10 random numbers between 1 and 100 are: "+
				Stream.generate(() -> new Random().nextInt(100)).limit(10).collect(Collectors.toList()));


		//Flatten a List of Lists into a Single List
		List<List<Integer>> listOfLists = List.of(    List.of(1, 2, 3),    List.of(4, 5, 6),    List.of(7, 8, 9));
		System.out.println("Flattened list: "+
				listOfLists.stream().flatMap(List :: stream).collect(Collectors.toList()));
	}

}