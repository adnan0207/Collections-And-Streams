package com.adnan.corejava;

import java.util.ArrayList;
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

		// vector is synchronized

		ArrayList<Integer> list = new ArrayList<Integer>();

		Thread t1 = new Thread(() -> {
			for (int i = 0; i < 1000; i++) {
				list.add(i);
			}
		});

		Thread t2 = new Thread(() -> {
			for (int i = 0; i < 1000; i++) {
				list.add(i);
			}
		});

		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Size of list : " + list.size()); // 1000+1000=2000 list.size() should be 2000
		// but it will not return 2000 as it is not thread save or in other words we can
		// say it is not synchronous/synchronized

		// now using vector

		Vector<Integer> vector = new Vector<Integer>();

		Thread t3 = new Thread(() -> {
			for (int i = 0; i < 1000; i++) {
				vector.add(i);
			}
		});

		Thread t4 = new Thread(() -> {
			for (int i = 0; i < 1000; i++) {
				vector.add(i);
			}
		});

		t3.start();
		t4.start();

		try {
			t3.join();
			t4.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Size of list : " + vector.size()); // 1000+1000=2000 vector.size() should be 2000
		// but it return 2000 as it is thread save or in other words we can say it is
		// synchronous/synchronized

	}

}
