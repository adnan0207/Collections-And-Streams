package com.adnan.corejava;

import java.util.LinkedList;
import java.util.Vector;

public class Main {

	public static void main(String[] args) {

		Vector<Integer> vecOne = new Vector<Integer>();
		System.out.println(vecOne.capacity());

		Vector<Integer> vecTwo = new Vector<Integer>(5); // with custom capacity
		System.out.println(vecTwo.capacity());
		vecTwo.add(1);
		vecTwo.add(1);
		vecTwo.add(1);
		vecTwo.add(1);
		vecTwo.add(1);
		System.out.println(vecTwo.capacity());
		vecTwo.add(1);
		System.out.println(vecTwo.capacity()); // default increment is doubling the capacity

		Vector<Integer> vecThree = new Vector<Integer>(5, 3); // with custom capacity and capacity increment
		System.out.println(vecThree.capacity());
		vecThree.add(1);
		vecThree.add(1);
		vecThree.add(1);
		vecThree.add(1);
		vecThree.add(1);
		System.out.println(vecThree.capacity());
		vecThree.add(1);
		System.out.println(vecThree.capacity());

		LinkedList<String> linkedLi = new LinkedList<String>();
		linkedLi.add("Cat");
		linkedLi.add("Dog");
		linkedLi.add("Mouse");

		System.out.println(linkedLi);

		Vector<String> vector1 = new Vector<String>(linkedLi);
		System.out.println(vector1);

		vector1.clear();

		System.out.println(vector1);
		
	}

}
