package com.collections;

import java.util.ArrayList;

/* PLease refer for below URL for Complete Problem statement:
 * https://github.com/Rjwagh2001/Core-Java/blob/main/CoreJavaNotes/Collections/ArrayListProblems.md
 */

import java.util.Scanner;

public class ArrayListProblemsSolution {

	public void run() {

		// Topic 1: ArrayList Creation & Initialization

		/* Simple List Creation (Basic) */

//		int n;
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Enter the number: ");
//		n = sc.nextInt();
//
//		ArrayList<Integer> numbers = new ArrayList<>();
//		int add = 1;
//		for (int i = 0; i < n; i++) {
//			numbers.add(add);
//			add++;
//		}
//
//		System.out.println("Printing an list:" + numbers);

		/* Problem 1.2: Initialize from Input (Medium) */

//		int n;
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Enter the Number:");
//		n = sc.nextInt();
//
//		ArrayList<Integer> numbers = new ArrayList<Integer>();
//		for (int i = 0; i < n; i++) {
//			numbers.add(sc.nextInt());
//		}
//
//		System.out.println("The list elements are:" + numbers);
//
//		// Remove duplicates using LinkedHashSet (maintains order)
//		ArrayList<Integer> unique = new ArrayList<>(new LinkedHashSet<>(numbers));
//
//		System.out.println("The list elements using LinkedHashSet:" + unique);
//		
//		

		/* Multiple ArrayLists Creation */

//		ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
//
//		Scanner sc = new Scanner(System.in);
//		int n;
//		System.out.println("Enter How much array Required:");
//		n = sc.nextInt();
//
//		for (int i = 1; i <= n; i++) {
//			System.out.println("Enter How much numbers Required in array :" + i);
//			int d = sc.nextInt();
//			ArrayList<Integer> currentList = new ArrayList<>();
//			for (int j = 0; j < d; j++) {
//				currentList.add(sc.nextInt());
//			}
//			lists.add(currentList);
//		}
//
//		System.out.println("Enter number of queries you want: ");
//		int q = sc.nextInt();
//
//		int x, y;
//		for (int i = 0; i < q; i++) {
//
//			System.out.println("Enter number of x and Y you want: ");
//			x = sc.nextInt();
//			y = sc.nextInt();
//
//			int ans;
//
//			try {
//				System.out.println(lists.get(x - 1).get(y - 1));
//			} catch (Exception e) {
//				System.out.println("ERROR!");
//			}
//		}

		/* Add Elements (Basic) */

//		int n;
//		Scanner sc = new Scanner(System.in);
//		n = sc.nextInt();
//
//		ArrayList<Integer> list = new ArrayList<Integer>();
//		for (int i = 0; i < n; i++) {
//			int element = sc.nextInt();
//			list.add(element);
//		}
//
//		for (int i = 0; i < n; i++) {
//			System.out.println(list.get(i));
//		}

		/* Problem 2.2: Insert at Position (Medium) */

//		Scanner sc = new Scanner(System.in);
//		System.out.print("Insert number of array elements !");
//		int n = sc.nextInt();
//
//		ArrayList<Integer> list = new ArrayList<>();
//		for (int i = 0; i < n; i++) {
//			int element = sc.nextInt();
//			list.add(element);
//		}
//
//		System.out.print("Provide queries !");
//		int q = sc.nextInt();
//		for (int i = 0; i < q; i++) {
//			int x = sc.nextInt();
//			int y = sc.nextInt();
//
//			try {
//				list.add(x, y);
//			} catch (Exception e) {
//				System.out.print("Error !");
//			}
//		}
//
//		for (int nums : list) {
//			System.out.print(nums + " ");
//		}

		/* Problem 2.3: Insert and Delete Queries (Advanced) */

//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		ArrayList<Integer> list = new ArrayList<>();
//		for (int i = 0; i < n; i++) {
//			list.add(sc.nextInt());
//		}
//
//		int q = sc.nextInt();
//		for (int i = 0; i < q; i++) {
//			String operation = sc.next();
//			if (operation.equals("Insert")) {
//				int index = sc.nextInt();
//				int value = sc.nextInt();
//				list.add(index, value);
//			} else if (operation.equals("Delete")) {
//				int index = sc.nextInt();
//				list.remove(index);
//			}
//		}
//
//		for (int num : list) {
//			System.out.print(num + " ");
//		}

		/* Problem 3.3: Nested ArrayList Query (Advanced) */

//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//
//		List<List<Integer>> listOfLists = new ArrayList<>();
//
//		for (int i = 0; i < n; i++) {
//			listOfLists.add(new ArrayList<Integer>());
//		}
//
//		for (int i = 0; i < n; i++) {
//			System.out.println("Enter -1 to stop array elements filling: ");
//			int element;
//			while ((element = sc.nextInt()) != -1) {
//				listOfLists.get(i).add(element);
//			}
//		}
//
//		int q = sc.nextInt();
//
//		for (int i = 0; i < q; i++) {
//			int x = sc.nextInt();
//			int y = sc.nextInt();
//
//			try {
//
//				System.out.println(listOfLists.get(x - 1).get(y - 1));
//
//			} catch (Exception e) {
//				System.out.println(e.getStackTrace());
//			}
//		}

		/* Problem 4.1: Update at Index (Basic) */

//		int n;
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Enter the Number:");
//		n = sc.nextInt();
//
//		ArrayList<Integer> numbers = new ArrayList<Integer>();
//		for (int i = 0; i < n; i++) {
//			numbers.add(sc.nextInt());
//		}
//
//		System.out.println("The list elements are:" + numbers);
//
//		int q = sc.nextInt();
//
//		for (int i = 0; i < q; i++) {
//			int x = sc.nextInt();
//			int y = sc.nextInt();
//
//			try {
//				numbers.set(x - 1, y);
//			} catch (Exception e) {
//				System.out.println(e);
//			}
//		}
//		System.out.println("The final list elements are:" + numbers);

		/*
		 * Problem 4.2: Transform Elements (Medium)
		 * 
		 * 
		 * 
		 * 
		 */

//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//
//		ArrayList<Integer> nums = new ArrayList<>();
//		for (int i = 0; i < n; i++) {
//			// adding element at specific end + insert at positon with existing
//			nums.add(sc.nextInt());
//		}
//
//		for (int i = 0; i < nums.size(); i++) {
//
//			if (nums.get(i) % 2 == 0) {
//				//fetch what element you want to fetch
//				nums.set(i, 2 * nums.get(i));
//
//			} else {
//				//modify given position element 
//				nums.set(i, nums.get(i) + 1);
//			}
//		}
//
//		for (int number : nums) {
//			System.out.print(number + " ");
//		}

		/*
		 * 
		 * Problem 4.3: Conditional Bulk Update (Advanced)
		 * 
		 * 
		 * Problem Statement: You have an ArrayList of N integers. You need to update
		 * elements based on multiple conditions:
		 * 
		 * 
		 */

//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//
//		ArrayList<Integer> nums = new ArrayList<>();
//		for (int i = 0; i < n; i++) {
//			// adding element at specific end + insert at positon with existing
//			nums.add(sc.nextInt());
//		}
//
//		for (int i = 0; i < nums.size(); i++) {
//
//			if (nums.get(i) % 3 == 0) {
//				// fetch what element you want to fetch
//				nums.set(i, nums.get(i) / 3);
//
//			} else if (nums.get(i) % 2 == 0) {
//				nums.set(i, 2 * nums.get(i));
//				// modify given position element
//
//			} else {
//				nums.set(i, nums.get(i) + 5);
//
//			}
//		}
//
//		for (int i = 0; i < nums.size(); i++) {
//			if (nums.get(i) > 100) {
//				nums.remove(nums.get(i));
//			}
//			System.out.print(nums.get(i) + " ");
//		}

		/*
		 * 
		 * 
		 * 
		 * Problem 5.1: Remove by Index (Basic) and Element using wrapper class
		 * 
		 * 
		 * 
		 * 
		 * 
		 */

//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//
//		ArrayList<Integer> nums = new ArrayList<>();
//		for (int i = 0; i < n; i++) {
//			// adding element at specific end + insert at positon with existing
//			nums.add(sc.nextInt());
//		}
//
//		for (int i = 0; i < nums.size(); i++) {
//
//			// direct passing index
//
//			if (nums.get(i) > 100) {
//				// passing index as int
//				nums.remove(nums.get(i));
//			} else if ((nums.get(i) == 50)) {
//				// passing an element directly
//				nums.remove(Integer.valueOf(50));
//			} else {
//				System.out.print(nums.get(i) + " ");
//			}
//
//		}

		/*
		 * 
		 * 
		 * Problem 5.2: Remove All Occurrences (Medium)
		 * 
		 * 
		 * 
		 * Problem Statement: You are given an ArrayList of N integers and a value X.
		 * Remove all occurrences of X from the list. Print the final list and count of
		 * elements removed.
		 * 
		 * 
		 */

//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//
//		ArrayList<Integer> numsadd = new ArrayList<>();
//
//		ArrayList<Integer> nums = new ArrayList<>();
//		for (int i = 0; i < n; i++) {
//			// adding element at specific end + insert at positon with existing
//			nums.add(sc.nextInt());
//		}
//
//		int value = sc.nextInt();
//
//		int count = 0;
//		for (int i = 0; i < n - 1; i++) {
//
//			// use Iterator beacuse size is decreasing every time
////			if (nums.get(i) == value) {
////				count++;
////				nums.remove(Integer.valueOf(value));
////			}
//
//		}
//
//		
//		//Using Iterator we can remove
//		Iterator<Integer> it = nums.iterator();
//
//		while (it.hasNext()) {
//			if (it.next() == value) {
//				count++;
//				it.remove();
//			}
//		}
//		
//		//using an removeIf and removeAll also 
//		long count1 = nums.stream().filter(num -> num == value).count();
//		nums.removeIf(num -> num == value);
//
////		 // Create a list containing only the value to remove
////        List<Integer> singleValueList = new ArrayList<>();
////        singleValueList.add(value);
////
////        // Use removeAll to remove all occurrences of 'valueToRemove'
////        numbers1.removeAll(singleValueList);
//        
//		System.out.println(count);
//
//		for (int number : nums) {
//			System.out.print(number + " ");
//		}
//
//		if (nums.size() == 0) {
//			System.out.println("Empty");
//		}

		/*
		 * 
		 * 
		 * Problem 5.3: Conditional Remove (Advanced)
		 * 
		 * 
		 * 
		 * 
		 * 
		 */

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		ArrayList<Integer> numsadd = new ArrayList<>();

		ArrayList<Integer> nums = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			// adding element at specific end + insert at positon with existing
			nums.add(sc.nextInt());
		}

		// for specific position value
		int value = sc.nextInt();
		int first = nums.getFirst();
		int last = nums.getLast();
		int getbyid = nums.get(value);

		System.out.println(first + " " + last + " " + getbyid);

	}

}
