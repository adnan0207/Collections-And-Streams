package com.adnan.corejava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
	
	public static void main(String[] args) {
		
		List<Integer> numbers = new ArrayList<Integer>();
		numbers.add(2);
		numbers.add(1);
		numbers.add(3);

		// now i want to sort them using my custom logic -- we need to use comparator
		
		// default natural sorting order - ascending order
		numbers.sort(null);
		System.out.println(numbers);
		
		// my custom logic for sorting
		numbers.sort(new MyComparator());
		System.out.println(numbers);
		
		// we know lambda expressions then why make other class to implement the method as Comparator interface is a functional interface
		numbers.sort((a, b) -> b-a);
		System.out.println(numbers);

		
		List<String> words = Arrays.asList("banana", "apple", "date");
		
		// default natural sorting order - dictionary order
		words.sort(null);
		System.out.println(words);

		// sort according to length of the words
		words.sort(new StringLengthComparator());
		System.out.println(words);
		
		// same here we can use lambda expression also for our logic
		words.sort((a, b) -> a.length() - b.length());
		System.out.println(words);
		
		
		List<Student> studentList = new ArrayList<Student>();
		studentList.add(new Student("Priyen", 3.5));
		studentList.add(new Student("Jay", 3.7));
		studentList.add(new Student("Adnan", 3.5));
		studentList.add(new Student("Anuj", 3.9));
		
//		studentList.sort(null);		// exception aayegi
		// kyu aayegi exception kyuki upar apan keh rhe hai null, lekin student ko pata hi nahi hai default natural sorting order kya hai
		// isse pehle apan jo bhi use kr rhe the String int wagera sab inbuilt classes thi
		// yeh classes Comparable ko implement krti hai jiske andar ek method hota hai compareTo 
		
		// abhi ke liye Comparable ko maaro goli kyuki apne ko aata nhi lekin comparator toh aata hai
		
		// i want ki jiske zyada gpa hai woh pehle aaye
		
		studentList.sort((a, b) -> {
			if(b.getGpa() - a.getGpa() > 0) {
				return 1;
			}else if(b.getGpa() - a.getGpa() < 0) {
				return -1;
			}else {
				return 0;
			}
		});
		
		System.out.println(studentList);

		studentList.sort((a, b) -> {
			if(b.getGpa() - a.getGpa() > 0) {
				return 1;
			}else if(b.getGpa() - a.getGpa() < 0) {
				return -1;
			}else {
				return a.getName().compareTo(b.getName());
			}
		});
		
		System.out.println(studentList);

		
		Comparator<Student> compartor = Comparator.comparing(Student::getGpa);
		studentList.sort(compartor);
		System.out.println(studentList);
		
		Comparator<Student> compartor2 = Comparator.comparing(Student::getGpa).reversed();
		studentList.sort(compartor2);
		System.out.println(studentList);
		
		Comparator<Student> compartor3 = Comparator.comparing(Student::getGpa).reversed().thenComparing(Student::getName);
		studentList.sort(compartor3);
		System.out.println(studentList);
		
	}

}
