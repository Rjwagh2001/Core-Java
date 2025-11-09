package com.collections;

import java.util.ArrayList;
import java.util.Scanner;

public class DSAProblemSolving {

	public void run() {

		System.out.println("Learning codeing Problems");

		/* find maximum element in array */

//		int n;
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Enter the size of array:");
//		n = sc.nextInt();
//
//		ArrayList<Integer> numbers = new ArrayList<Integer>();
//		for (int i = 0; i < n; i++) {
//			numbers.add(sc.nextInt());
//		}
//
//		int maxElement = Collections.max(numbers);
//
//		System.out.println("Max Element is :" + maxElement);

		// time Complexity: O(n)

		// There are another two appraoach 1>sorting and last element and normal max
		// element approach with for loop

		/*
		 * Problem Statement: Given an array, we have to find the largest element in the
		 * array.
		 */

		System.out.println("Learning codeing Problems");

		/* find maximum element in array */
//
//		int n;
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Enter the size of array:");
//		n = sc.nextInt();
//
//		ArrayList<Integer> numbers = new ArrayList<Integer>();
//		for (int i = 0; i < n; i++) {
//			numbers.add(sc.nextInt());
//		}
//
//		int maxElement = Integer.MIN_VALUE;
//		int secondMaxElement = Integer.MIN_VALUE;
//
//		for (int i = 0; i < n; i++) {
//			if (numbers.get(i) > maxElement) {
//				maxElement = numbers.get(i);
//			}
//			System.out.println("MaxElement Max Element is :" + maxElement);
//
//			if (numbers.get(i) > secondMaxElement && numbers.get(i) != maxElement) {
//				secondMaxElement = numbers.get(i);
//			}
//			System.out.println("Second Max Element is :" + secondMaxElement);
//		}
//		System.out.println("final MaxElement Max Element is :" + maxElement);
//
//		System.out.println("final Second Max Element is :" + secondMaxElement);

		// Time complesxity is O(n)

		/*
		 * Problem Statement: Given an array of size n, write a program to check if the
		 * given array is sorted in (ascending / Increasing / Non-decreasing) order or
		 * not. If the array is sorted then return True, Else return False.
		 */

		//
		int n;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of array:");
		n = sc.nextInt();

		ArrayList<Integer> numbers = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			numbers.add(sc.nextInt());
		}

		boolean ascending = true;
		boolean descending = true;

		for (int i = 0; i < n - 1; i++) {

			if (numbers.get(i) > numbers.get(i + 1)) {
				ascending = false;
				break;
			}
		}

		for (int j = 0; j < n - 1; j++) {

			if (numbers.get(j) < numbers.get(j + 1)) {
				descending = false;
				break;
			}
		}

		if (ascending == true || descending == true) {
			System.out.println("Ascednign or desccending");
		}

	}

}
