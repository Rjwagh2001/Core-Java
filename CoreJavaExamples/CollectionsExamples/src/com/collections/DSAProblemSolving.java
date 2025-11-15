package com.collections;

public class DSAProblemSolving {

	public void run() {

		// System.out.println("Learning codeing Problems");

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

		// System.out.println("Learning codeing Problems");

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
//		boolean ascending = true;
//		boolean descending = true;
//
//		for (int i = 0; i < n - 1; i++) {
//
//			if (numbers.get(i) > numbers.get(i + 1)) {
//				ascending = false;
//				break;
//			}
//		}
//
//		for (int j = 0; j < n - 1; j++) {
//
//			if (numbers.get(j) < numbers.get(j + 1)) {
//				descending = false;
//				break;
//			}
//		}
//
//		if (ascending == true || descending == true) {
//			System.out.println("Ascednign or desccending");
//		}

		/*
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 */

//		Scanner sc = new Scanner(System.in);
//		int k = sc.nextInt();
//		int arr[] = { 1, 2, 3, 5, 10, 1 };
//		int maxCount = Integer.MIN_VALUE;
//		for (int i = 0; i < arr.length; i++) {
//
//			int sumofAll = arr[i];
//			int count = 1;
//			System.out.print("the outer row is " + i + " " + sumofAll);
//
//			for (int j = i + 1; j < arr.length; j++) {
//				sumofAll += arr[j];
//				count++;
//				if (sumofAll == k) {
//					System.out.println("max count is " + count);
//					if (count > maxCount) {
//						maxCount = count;
//					}
//				}
//				System.out.print("the inner row is " + j + " " + sumofAll);
//			}
//			System.out.println();
//
//		}
//		System.out.println("Max count Is :" + maxCount);
//	}

		// Using 0(n) Using two pointer Approach
//		int k = 5;
//		int a[] = { 2, 3, 5 };
//		int n = a.length; // size of the array.
//
//		int left = 0, right = 0; // 2 pointers
//		long sum = a[0];
//		int maxLen = 0;
//		while (right < n) {
//			// if sum > k, reduce the subarray from left
//			// until sum becomes less or equal to k:
//			while (left <= right && sum > k) {
//				sum -= a[left];
//				left++;
//			}
//
//			// if sum = k, update the maxLen i.e. answer:
//			if (sum == k) {
//				maxLen = Math.max(maxLen, right - left + 1);
//			}
//
//			// Move forward thw right pointer:
//			right++;
//			if (right < n)
//				sum += a[right];
//		}
//
//		System.out.println(maxLen);
//	}

//		int[] arr = { 2, 6, 5, 8, 11 };
//		int n = 5;
//		int target = 14;
//		int left = 0, right = n - 1;
//		while (left < right) {
//			int sum = arr[left] + arr[right];
//
//			if (sum == target) {
//				System.out.println("Yes");
//				System.out.println("The left is " + left);
//				System.out.println("The right is:" + right);
//				break;
//			} else if (sum < target)
//				left++;
//			else
//				right--;
//		}

	}
}
