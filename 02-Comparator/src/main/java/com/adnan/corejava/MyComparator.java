package com.adnan.corejava;

import java.util.Comparator;

public class MyComparator implements Comparator<Integer> {

	@Override
	public int compare(Integer num1, Integer num2) {
		// if int is -ve -> num1, num2
		// if int is 0 -> num1, num2 are equal
		// if int is -ve -> num2, num1

		return (num2 - num1);
	}

}
