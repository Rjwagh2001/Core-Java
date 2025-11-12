package com.collections;

import java.util.ArrayList;
import java.util.ListIterator;
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
//		// for specific position value
//		int value = sc.nextInt();
//		int first = nums.getFirst();
//		int last = nums.getLast();
//		int getbyid = nums.get(value);
//
//		System.out.println(first + " " + last + " " + getbyid);
//
//	

		/*
		 * 
		 * 
		 * Problem 6.1: Element Exists (Basic)
		 * 
		 * 
		 * Problem Statement: You are given an ArrayList of N integers and Q queries.
		 * Each query contains a value V. For each query, print "YES" if V exists in the
		 * list, otherwise "NO".
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 */

//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//
//		ArrayList<Integer> nums = new ArrayList<Integer>();
//		for (int i = 0; i < n; i++) {
//			nums.add(sc.nextInt());
//		}
//
//		int q = sc.nextInt();
//		for (int i = 0; i < q; i++) {
//
//			int ele = sc.nextInt();
//
//			if (nums.contains(Integer.valueOf(ele))) {
//				System.out.println("Yes");
//			} else {
//				System.out.println("No");
//			}
//
//		}

		/*
		 * 
		 * 
		 * Problem 6.2: First and Last Position (Medium)
		 * 
		 * 
		 * 
		 * 
		 * 
		 */

//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//
//		ArrayList<Integer> nums = new ArrayList<Integer>();
//		for (int i = 0; i < n; i++) {
//			nums.add(sc.nextInt());
//		}
//
//		int target = sc.nextInt();
//
//		int firstElement = nums.indexOf(target);
//		int lastElement = nums.lastIndexOf(target);
//
//		System.out.println(firstElement + " " + lastElement);

		/*
		 * 
		 * 
		 * Search in Rotated Array (Advanced) class Problem6_3 { public static void
		 * main(String[] args) { Scanner sc = new Scanner(System.in);
		 * 
		 * Check and resolve problem with Binary Search
		 * 
		 * 
		 */

//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//
//		ArrayList<Integer> nums = new ArrayList<Integer>();
//		for (int i = 0; i < n; i++) {
//			nums.add(sc.nextInt());
//		}

		/*
		 * 
		 * Problem 7.1: Basic Sort (Basic)Difficulty: Easy
		 * 
		 * Problem Statement: You are given N integers. Sort them in ascending order and
		 * print. Then sort in descending order and print.
		 * 
		 * 
		 *
		 * 
		 */

//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//
//		ArrayList<Integer> nums = new ArrayList<Integer>();
//		for (int i = 0; i < n; i++) {
//			nums.add(sc.nextInt());
//		}
//
//		Collections.sort(nums);
//		for (int numbers : nums) {
//			System.out.print(numbers);
//		}
//
//		System.out.println();
//		Collections.reverse(nums);
//		for (int numbers : nums) {
//			System.out.print(numbers);
//		}

		/*
		 * Problem 7.2: Sort Students by Marks (Medium) Difficulty: Medium Problem
		 * Statement: You have N students with their names and marks. Sort them by marks
		 * in descending order. If two students have same marks, sort by name in
		 * ascending order.
		 * 
		 * 
		 * 
		 */

//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		ArrayList<Student> students = new ArrayList<>();
//
//		// How multiple student add
//		for (int i = 0; i < n; i++) {
//			String name = sc.next();
//			int marks = sc.nextInt();
//			students.add(new Student(name, marks));
//		}
//
//		Collections.sort(students, (s1, s2) -> {
//			if (s1.getMarks() != s2.getMarks()) {
//				return s2.getMarks() - s1.getMarks(); // Descending by marks
//			}
//			return s1.getName().compareTo(s2.getName()); // Ascending by name
//		});
//
//		for (Student s : students) {
//			System.out.println(s.getName() + " " + s.getMarks());
//		}
//	}

		/*
		 * 
		 * 
		 * Problem 7.3: Multi-criteria Sorting (Advanced) Difficulty: Hard Problem
		 * Statement: You have N employees with Name, Age, and Salary. Sort them by: Age
		 * (ascending) If age same, by Salary (descending) If salary also same, by Name
		 * (ascending)
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 */

//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//
//		ArrayList<Employee> employee = new ArrayList<Employee>();
//		for (int i = 0; i < n; i++) {
//			String name = sc.next();
//			int age = sc.nextInt();
//			int salary = sc.nextInt();
//
//			employee.add(new Employee(name, age, salary));
//
//		}
//
//		Collections.sort(employee, (e1, e2) -> {
//
//			if (e1.age != e2.age) {
//				return e2.age - e1.age; // descendin
//			}
//			if (e1.salary != e2.salary) {
//				return e2.salary - e1.salary; // descending
//			}
//			return e1.name.compareTo(e2.name); // ascending
//		});
//
//		System.out.println(employee);

		/*
		 * 
		 * Problem B.1: Merge Two Sorted Lists Difficulty: MediumProblem Statement: You
		 * are given two sorted ArrayLists. Merge them into one sorted ArrayList without
		 * using Collections.sort().
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 */

//
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		ArrayList<Integer> list1 = new ArrayList<>();
//		for (int i = 0; i < n; i++) {
//			list1.add(sc.nextInt());
//		}
//
//		int m = sc.nextInt();
//		ArrayList<Integer> list2 = new ArrayList<>();
//		for (int i = 0; i < m; i++) {
//			list2.add(sc.nextInt());
//		}
//
//		ArrayList<Integer> merged = new ArrayList<>();
//		int i = 0, j = 0;
//
//		while (i < list1.size() && j < list2.size()) {
//			if (list1.get(i) <= list2.get(j)) {
//				merged.add(list1.get(i));
//				i++;
//			} else {
//				merged.add(list2.get(j));
//				j++;
//			}
//		}
//
//		while (i < list1.size()) {
//			merged.add(list1.get(i));
//			i++;
//		}
//
//		while (j < list2.size()) {
//			merged.add(list2.get(j));
//			j++;
//		}
//
//		for (int num : merged) {
//			System.out.print(num + " ");
//		}

		/*
		 * 
		 * 
		 * 
		 * Problem B.2: Remove Duplicates and Sort Difficulty: Medium
		 * 
		 * Problem Statement: Given N integers (possibly duplicates), remove duplicates
		 * and sort in ascending order. Then print the K-th smallest unique element.
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 */

//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//
//		ArrayList<Integer> list1 = new ArrayList<>();
//		for (int i = 0; i < n; i++) {
//			list1.add(sc.nextInt());
//		}
//
//		Collections.sort(list1);
//		LinkedHashSet<Integer> unique = new LinkedHashSet<Integer>(list1);
//
//		for (int numbers : unique) {
//			System.out.println(numbers + " ");
//		}

		/*
		 * 
		 * Problem B.3: Sliding Window Maximum Difficulty: Hard Problem Statement: Given
		 * an ArrayList of N integers and window size K, find the maximum element in
		 * each sliding window of size K.
		 * 
		 * 
		 * 
		 * 
		 * 
		 */

//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//
//		ArrayList<Integer> nums = new ArrayList<Integer>();
//		for (int i = 0; i < n; i++) {
//			nums.add(sc.nextInt());
//		}
//
//		ArrayList<Integer> result = new ArrayList<Integer>();
//
//		for (int i = 0; i < n - 2; i++) {
//			System.out.print(i + " ");
//
//			int max = nums.get(i);
//			for (int j = i; j < i + 3; j++) {
//				System.out.print(nums.get(j) + " ");
//
//				if (max < nums.get(j)) {
//					max = nums.get(j);
//				}
//
//			}
//			System.out.println();
//			result.add(max);
//		}
//
//		for (int numbers : result) {
//			System.out.print(numbers + " ");
//		}

		/*
		 * 
		 * Problem 8.1: SubList Operations (Basic) Problem Statement: You are given an
		 * ArrayList of N integers and Q queries. Each query contains two indices START
		 * and END. For each query, extract and print the sublist from START (inclusive)
		 * to END (exclusive).
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 */

//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//
//		ArrayList<Integer> nums = new ArrayList<Integer>();
//		for (int i = 0; i < n; i++) {
//			nums.add(sc.nextInt());
//		}
//
//		int q = sc.nextInt();
//		for (int i = 0; i < q; i++) {
//			int x = sc.nextInt();
//			int y = sc.nextInt();
//
//			System.out.println(nums.subList(x - 1, y));
//		}
//		

		/*
		 * 
		 * 
		 * Problem 8.2: Clear and isEmpty Check (Basic) Difficulty: Easy Problem
		 * Statement: You are given N integers to add to an ArrayList. After adding,
		 * perform Q operations: "SIZE" - print current size "EMPTY" - print "YES" if
		 * empty, "NO" otherwise "CLEAR" - clear all elements
		 * 
		 * 
		 * 
		 * 
		 * 
		 */

//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//
//		ArrayList<Integer> nums = new ArrayList<Integer>();
//		for (int i = 0; i < n; i++) {
//			nums.add(sc.nextInt());
//		}
//
//		int q = sc.nextInt();
//		for (int i = 0; i < q; i++) {
//			String operation = sc.next();
//			if (operation.equals("SIZE")) {
//				System.out.println(nums.size());
//			} else if (operation.equals("EMPTY")) {
//				if (nums.isEmpty()) {
//					System.out.println("YES");
//				} else {
//					System.out.println("NO");
//				}
//			} else if (operation.equals("CLEAR")) {
//				nums.clear();
//				System.out.println(nums);
//			} else {
//				System.out.println("Provide correct Option");
//			}
//		}

		/*
		 * 
		 * 
		 * Problem 8.3: AddAll and RemoveAll (Medium)
		 * 
		 * Problem Statement: You have two ArrayLists A and B. Perform these operations:
		 * 
		 * Add all elements of B to A Print merged list Remove all elements from A that
		 * exist in B Print final list
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 */

//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//
//		ArrayList<Integer> numsA = new ArrayList<>();
//		for (int i = 0; i < n; i++) {
//			numsA.add(sc.nextInt());
//		}
//
//		int m = sc.nextInt();
//
//		ArrayList<Integer> numsB = new ArrayList<>();
//		for (int i = 0; i < m; i++) {
//			numsB.add(sc.nextInt());
//		}
//
//		// adding all elements of b to a
//		numsA.addAll(numsB);
//
//		for (int numbers : numsA) {
//			System.out.print(numbers + " ");
//		}
//
//		System.out.println(" ");
//
//		numsA.removeAll(numsB);
//
//		for (int numbers : numsA) {
//			System.out.print(numbers + " ");
//		}

		/*
		 * 
		 * 
		 * Problem 8.4: RetainAll Operation (Medium) Difficulty: Medium
		 * 
		 * Problem Statement: You have two ArrayLists A and B. Keep only those elements
		 * in A that are present in B (intersection). Print the result. Input Format:
		 * First line: N Second line: N integers for list A Third line: M Fourth line: M
		 * integers for list B
		 * 
		 * 
		 * 
		 * 
		 * 
		 */

//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//
//		ArrayList<Integer> numsA = new ArrayList<>();
//		for (int i = 0; i < n; i++) {
//			numsA.add(sc.nextInt());
//		}
//
//		int m = sc.nextInt();
//
//		ArrayList<Integer> numsB = new ArrayList<>();
//		for (int i = 0; i < m; i++) {
//			numsB.add(sc.nextInt());
//		}
//
//		ArrayList<Integer> result = new ArrayList<>();
//
//		// approach first o(n^2)
////		for (int number : numsA) {
////			for (int element : numsB) {
////				if (element == number) {
////					result.add(number);
////				}
////			}
////		}
//
//		// second using methods o(n)
////		Iterator<Integer> it = numsA.iterator();
////		while (it.hasNext()) {
////			int element = it.next();
////			if (!numsB.contains(element)) {
////				it.remove(); // safe — uses Iterator.remove()
////			}
////		}
////
////		for (int number : numsA) {
////			System.out.print(number + " ");
////		}
//
//		numsA.retainAll(numsB);
//		for (int number : numsA) {
//			System.out.print(number + " ");
//		}

		/*
		 * 
		 * 
		 * Problem 8.5: Clone ArrayList (Medium) Difficulty: Medium
		 * 
		 * Problem Statement: You are given an ArrayList of N integers. Create a clone
		 * of it, modify the original by doubling all values, then print both lists to
		 * verify they are independent.
		 * 
		 * 
		 * 
		 * 
		 * 
		 */

//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		ArrayList<Integer> original = new ArrayList<>();
//		for (int i = 0; i < n; i++) {
//			original.add(sc.nextInt());
//		}
//
//		// Clone
//		ArrayList<Integer> cloned = new ArrayList<>(original);
//
//		// Modify original
//		for (int i = 0; i < original.size(); i++) {
//			original.set(i, original.get(i) * 2);
//		}
//
//		// Print both
//		for (int num : original) {
//			System.out.print(num + " ");
//		}
//		System.out.println();
//
//		for (int num : cloned) {
//			System.out.print(num + " ");
//		}

		/*
		 * 
		 * Problem 8.6: ToArray Conversion (Basic) Difficulty: Easy
		 * 
		 * Problem Statement: You are given N integers in an ArrayList. Convert it to an
		 * array and print:
		 * 
		 * Array elements Array length Middle element of array
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 */

//		Scanner sc = new Scanner(System.in);
//
//		int n = sc.nextInt();
//
//		ArrayList<Integer> list = new ArrayList<>();
//		for (int i = 0; i < n; i++) {
//			list.add(sc.nextInt());
//		}
//
//		Integer[] array = list.toArray(new Integer[0]);
//
//		// Print array
//		for (int num : array) {
//			System.out.print(num + " ");
//		}
//		System.out.println();
//
//		// Print length
//		System.out.println(array.length);
//
//		// Print middle element
//		System.out.println(array[array.length / 2]);

		/*
		 * 
		 * 
		 * 
		 * Problem 8.8: Equals and Compare Lists (Medium) Difficulty: Medium
		 * 
		 * Problem Statement: You are given two ArrayLists A and B. Check if they are:
		 * 
		 * Equal (same elements in same order) Same size Contain same elements (ignoring
		 * order)
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 */

//		Scanner sc = new Scanner(System.in);
//
//		int n = sc.nextInt();
//		ArrayList<Integer> listA = new ArrayList<>();
//		for (int i = 0; i < n; i++) {
//			listA.add(sc.nextInt());
//		}
//
//		int m = sc.nextInt();
//		ArrayList<Integer> listB = new ArrayList<>();
//		for (int i = 0; i < m; i++) {
//			listB.add(sc.nextInt());
//		}
//
//		// Equal check
//		System.out.println(listA.equals(listB) ? "EQUAL" : "NOT EQUAL");
//
//		// Size check
//		System.out.println(n == m ? "SAME SIZE" : "DIFFERENT SIZE");
//
//		// → because every element of listB exists in listA.
//		// Order doesn’t matter, duplicates are ignored for this check.
//		System.out
//				.println(listA.containsAll(listB) && listB.containsAll(listA) ? "SAME ELEMENTS" : "Different ELEMENTS");
//
//		// so asolve above duplicate not order matter use hashset
//
//		HashSet<Integer> set1 = new HashSet<>(listA);
//		HashSet<Integer> set2 = new HashSet<>(listB);
//		System.out.println(set1.equals(set2) ? "SAME ELEMENTS" : "Different ELEMENTS");

		/*
		 * 
		 * 
		 * 
		 * Problem 8.9: ForEach and Iterator (Advanced) Difficulty: Hard
		 * 
		 * Problem Statement: You are given N integers in an ArrayList. Remove all
		 * elements divisible by K using iterator, then print:
		 * 
		 * Elements removed Remaining elements Sum of remaining elements using forEach
		 * 
		 * 
		 * 
		 * 
		 * 
		 */

//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		int k = sc.nextInt();
//
//		ArrayList<Integer> list = new ArrayList<>();
//		for (int i = 0; i < n; i++) {
//			list.add(sc.nextInt());
//		}
//
//		int count = 0;
//		Iterator<Integer> itr = list.iterator();
//		while (itr.hasNext()) {
//			int num = itr.next();
//			if (num % k == 0) {
//				itr.remove();
//				count++;
//			}
//		}
//
//		System.out.println(count);
//
//		for (int num : list) {
//			System.out.print(num + " ");
//		}
//		System.out.println();
//
//		// Sum using forEach
//		int sum = 0;
//		for (int num : list) {
//			sum += num;
//		}
//		System.out.println(sum);

		/*
		 * 
		 * 
		 * 
		 * Problem 8.10: ListIterator Bidirectional (Advanced) Difficulty: Hard
		 * 
		 * Problem Statement: You are given an ArrayList of N integers. Using
		 * ListIterator:
		 * 
		 * Print elements forward Print elements backward Print elements at even indices
		 * only
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 */

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			list.add(sc.nextInt());
		}

		// Forward
		ListIterator<Integer> itr = list.listIterator();
		while (itr.hasNext()) {
			System.out.print(itr.next() + " ");
		}
		System.out.println();

		// Backward
		while (itr.hasPrevious()) {
			System.out.print(itr.previous() + " ");
		}
		System.out.println();

		// Even indices
		for (int i = 0; i < list.size(); i += 2) {
			System.out.print(list.get(i) + " ");
		}
	}

}
