package com.adnan.corejava;

import java.util.Arrays;
import java.util.LinkedList;

public class Test {

	public static void main(String[] args) {
		
		LinkedList<Integer> linkList = new LinkedList<Integer>();
		linkList.add(1);
		linkList.add(2);
		linkList.add(3);
		
		System.out.println(linkList.get(1));
		
		linkList.addLast(4);
		linkList.addFirst(0);
		
		System.out.println(linkList);

		System.out.println(linkList.getFirst());
		System.out.println(linkList.getLast());
		
		linkList.removeIf(x -> x%2==0);
		
		System.out.println(linkList);
		
		
		LinkedList<String> animals = new LinkedList<String>(Arrays.asList("cat", "dog", "elephant"));
		LinkedList<String> animalsTwo = new LinkedList<String>(Arrays.asList("dog", "lion"));
		
		System.out.println(animals);

		animals.removeAll(animalsTwo);		// animals me se woh animals remove ho jayengy jo animalsTwo me hongy
		
		System.out.println(animals);
		
	}
	
}
