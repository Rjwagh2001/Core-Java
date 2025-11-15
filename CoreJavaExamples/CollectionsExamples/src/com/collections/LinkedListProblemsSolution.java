package com.collections;

public class LinkedListProblemsSolution {

	public void run() throws Exception {

//		LinkedList<Integer> nums = new LinkedList<Integer>();
//		nums.add(1);
//		nums.add(11);
//		nums.add(10);
//		nums.add(12);
//		nums.add(13);
//
//		for (int numb : nums) {
//			System.out.println(numb);
//		}
//
//		System.out.println("----------------------------------- ");
//		Iterator<Integer> itr = nums.iterator();
//
//		while (itr.hasNext()) {
//			int element = itr.next();
//
//			System.out.println(element);
//
//		}
//
//		System.out.println("----------------------------------- ");
//
//		while (!nums.isEmpty()) {
//			System.out.println(nums.pop());
//		}

		/**
		 * 
		 * 
		 * Problem 1.1: Basic LinkedList Creation (Basic) Difficulty: Easy
		 * 
		 * Problem Statement: Create a LinkedList of N integers (from 1 to N). Print the
		 * first element, last element, and size of the list.
		 * 
		 * 
		 * 
		 * 
		 * 
		 */

//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//
//		LinkedList<Integer> list = new LinkedList<>();
//		for (int i = 1; i <= n; i++) {
//			list.add(i);
//		}
//
//		System.out.println(list.getFirst());
//		System.out.println(list.getLast());
//		System.out.println(list.size());

		/**
		 * 
		 * 
		 * 
		 * Problem 1.2: Initialize from Array (Medium) Difficulty: Medium
		 * 
		 * Problem Statement: You are given N integers. Create a LinkedList from them
		 * and reverse it without using Collections.reverse(). Print the reversed list.
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
//		LinkedList<Integer> list = new LinkedList<>();
//		for (int i = 1; i <= n; i++) {
//			list.add(i);
//		}
//
//		ListIterator<Integer> itr = list.listIterator(list.size());
//
//		while (itr.hasPrevious()) {
//			System.out.println(itr.previous() + " ");
//		}

		/**
		 * 
		 * 
		 * Problem 1.3: Create from Multiple Inputs (Advanced) Difficulty: Hard
		 * 
		 * Problem Statement: You need to create N separate LinkedLists. Each LinkedList
		 * contains a variable number of elements. After creation, answer Q queries
		 * where each query asks for the element at position Y in LinkedList X.
		 * 
		 * Input Format:
		 * 
		 * First line: N (number of LinkedLists) Next N lines: First integer D (size),
		 * followed by D integers Next line: Q (queries) Next Q lines: Two integers X Y
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 */

//		Scanner sc = new Scanner(System.in);
//		LinkedList<LinkedList<Integer>> listOfAll = new LinkedList<LinkedList<Integer>>();
//
//		int n = sc.nextInt();
//
//		for (int i = 0; i < n; i++) {
//			int size1 = sc.nextInt();
//			LinkedList<Integer> tempList = new LinkedList<Integer>();
//			for (int j = 0; j < size1; j++) {
//				tempList.add(sc.nextInt());
//			}
//			listOfAll.add(tempList);
//		}
//
//		int q = sc.nextInt();
//		for (int i = 0; i < q; i++) {
//			int x = sc.nextInt();
//			int y = sc.nextInt();
//
//			try {
//
//				System.out.println(listOfAll.get(x - 1).get(y - 1));
//
//			} catch (Exception e) {
//				throw new Exception("Error !!");
//			}
//		}

		/**
		 * 
		 * 
		 * 
		 * 
		 * 
		 * Problem 2.1: Build Queue (Basic) Difficulty: Easy
		 * 
		 * Problem Statement: You are building a queue using LinkedList. Process N
		 * operations:
		 * 
		 * "ADDFIRST X" - Add X to front "ADDLAST X" - Add X to end Print the final
		 * queue.
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
//		LinkedList<Integer> result = new LinkedList<Integer>();
//
//		for (int i = 0; i < n; i++) {
//			String operation = sc.next();
//			int y = sc.nextInt();
//
//			try {
//
//				if (operation == "ADDLAST") {
//					result.addLast(y);
//				} else {
//					result.addFirst(y);
//				}
//
//			} catch (Exception e) {
//				throw new Exception("Error !!");
//			}
//		}
//		
//		
//		
//		//Another solution
////		 for (int i = 0; i < n; i++) {
////	            String[] op = sc.nextLine().split(" ");
////	            int value = Integer.parseInt(op[1]);
////	            
////	            if (op[0].equals("ADDFIRST")) {
////	                list.addFirst(value);
////	            } else if (op[0].equals("ADDLAST")) {
////	                list.addLast(value);
////	            }
////	        }
//
//		for (int numbers : result) {
//			System.out.println(numbers + " ");
//		}

		/**
		 * 
		 * 
		 * 
		 * 
		 * Problem 2.2: Alternating Insert (Medium) Difficulty: Medium
		 * 
		 * Problem Statement: You have two lists A and B of equal size N. Create a new
		 * LinkedList by alternately taking elements from front of A and back of B.
		 * 
		 * Input Format:
		 * 
		 * First line: N Second line: N integers for list A Third line: N integers for
		 * list B
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
//		LinkedList<Integer> listA = new LinkedList<Integer>();
//		LinkedList<Integer> listB = new LinkedList<Integer>();
//
//		for (int i = 0; i < n; i++) {
//			listA.add(sc.nextInt());
//		}
//		for (int i = 0; i < n; i++) {
//			listB.add(sc.nextInt());
//		}
//
//		LinkedList<Integer> result = new LinkedList<Integer>();
//
//		ListIterator<Integer> itr1 = listA.listIterator();
//		ListIterator<Integer> itr2 = listB.listIterator(listB.size());
//
//		while (itr1.hasNext() && itr2.hasPrevious()) {
//
//			int elementA = itr1.next();
//			int elementB = itr2.previous();
//			result.add(elementA);
//			result.add(elementB);
//			itr1.remove();
//			itr2.remove();
//		}
//
//		// another way is
//
////		 for (int i = 0; i < n; i++) {
////	        result.add(a.removeFirst());
////            result.add(b.removeLast());
////          }
//
//		for (int numbers : result) {
//			System.out.print(numbers + " ");
//		}

		/*
		 * 
		 * 
		 * 
		 * Topic 3: RemoveFirst & RemoveLast Operations Problem 3.1: Basic Remove
		 * Operations (Basic) Difficulty: Easy
		 * 
		 * Problem Statement: You have a LinkedList with N elements. Process Q
		 * operations:
		 * 
		 * "REMOVEFIRST" - Remove first element "REMOVELAST" - Remove last element
		 * "PRINT" - Print current list
		 * 
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
//		LinkedList<Integer> list = new LinkedList<Integer>();
//
//		for (int i = 0; i < n; i++) {
//			list.add(sc.nextInt());
//		}
//
//		int q = sc.nextInt();
//		for (int i = 0; i < q; i++) {
//			String operation = sc.next();
//
//			if (operation.equals("REMOVEFIRST")) {
//				list.removeFirst();
//			} else if (operation.equals("REMOVELAST")) {
//				list.removeLast();
//			} else {
//				for (int nums : list) {
//					System.out.print(nums);
//				}
//			}
//		}

		// Convert o(n^2) -> o(n)
//		
//		Scanner sc = new Scanner(System.in);
//
//		int n = sc.nextInt();
//		LinkedList<Integer> list = new LinkedList<>();
//
//		for (int i = 0; i < n; i++) {
//		    list.add(sc.nextInt());
//		}
//
//		int q = sc.nextInt();
//		String op;
//
//		for (int i = 0; i < q; i++) {
//		    op = sc.next();
//
//		    switch (op) {
//		        case "REMOVEFIRST":
//		            if (!list.isEmpty()) list.removeFirst();
//		            break;
//
//		        case "REMOVELAST":
//		            if (!list.isEmpty()) list.removeLast();
//		            break;
//
//		        case "PRINT":
//		            for (int x : list) System.out.print(x + " ");
//		            System.out.println();
//		            break;
//		    }
//		}

		/*
		 * 
		 * 
		 * 
		 * 
		 * Problem 3.2: Deque Operations (Medium) Difficulty: Medium
		 * 
		 * Problem Statement: Implement a Deque (Double-ended queue) using LinkedList.
		 * Support operations:
		 * 
		 * "PUSHFRONT X" - Add to front "PUSHBACK X" - Add to back "POPFRONT" - Remove
		 * from front "POPBACK" - Remove from back
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
//		LinkedList<Integer> list = new LinkedList<Integer>();
//		for (int i = 0; i < n; i++) {
//			list.add(sc.nextInt());
//		}
//
//		int q = sc.nextInt();
//		for (int i = 0; i < q; i++) {
//			String[] op1 = sc.nextLine().split(" ");
//			String op = op1[0];
//			String element = op1[1];
//
//			switch (op) {
//			case ("PUSHFRONT X"):
//				break;
//			}
//		}

		// solve at last

//		/**
//		 * 
//		 * 
//		 * 
//		 * Problem 2.3: Priority Queue Simulation (Advanced) Difficulty: Hard
//		 * 
//		 * Problem Statement: Simulate a priority queue using LinkedList. Process N
//		 * operations:
//		 * 
//		 * "INSERT X P" - Insert X with priority P (1=highest) "REMOVE" - Remove highest
//		 * priority element "PEEK" - Print highest priority element
//		 * 
//		 * 
//		 * 
//		 * 
//		 * 
//		 * 
//		 */

//
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		sc.nextLine();
//
//		LinkedList ans = new LinkedList();
//		for (int i = 0; i < n; i++) {
//			String[] str = sc.nextLine().split(" ");
//
//			String operation = str[0];
//			String element1 = str[1];
//			int element = Integer.parseInt(element1);
//			String index1 = str[2];
//			int index = Integer.parseInt(index1);
//
//			if (operation.equals("INSERTXP")) {
//				ans.add(index, element);
//			} else if (operation.equals("PEEK")) {
//				System.out.println(ans.getFirst());
//
//			} else {
//				System.out.println(ans.removeFirst());
//			}
//		}
	}
}
