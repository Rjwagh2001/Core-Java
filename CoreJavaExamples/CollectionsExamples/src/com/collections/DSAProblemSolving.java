package com.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

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

		/*
		 * 
		 * 
		 * 
		 * Problem Statement: Given an array consisting of only 0s, 1s, and 2s. Write a
		 * program to in-place sort the array without using inbuilt sort functions. (
		 * Expected: Single pass-O(N) and constant space)
		 * 
		 * 
		 * 
		 */

		// First Approach:
		// sorting is one of Approach
		/*
		 * Time Complexity:O(n*logn) Space Complexity:O(1)
		 */

		// Approach Second:
		// Using count zero,1 nd and 2 and set in placed array

//		Keeping count of values
//
//		Intuition: Since in this case there are only 3 distinct values in the array so it's easy to maintain the count of all, Like the count of 0, 1, and 2. This can be followed by overwriting the array based on the frequency(count) of the values.
//
//		Approach: 
//
//		Take 3 variables to maintain the count of 0, 1 and 2.
//		Travel the array once and increment the corresponding counting variables
//		( let's consider count_0 = a, count_1 = b, count_2 = c )
//
//		In 2nd traversal of array, we will now over write the first ‘a’ indices / positions in array with ’0’, the next ‘b’ with ‘1’ and the remaining ‘c’ with ‘2’.
		/*
		 * Time Complexity:O(n) Space Complexity:O(1)
		 */

		// Using Dutch National Filag Algorithum

		/*
		 * Time Complexity:O(n) Space Complexity:O(1)
		 */

//		ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(2, 0, 2, 1, 1, 0, 1, 1, 1, 1));
//
//		int low = 0;
//		int mid = 0;
//		int high = nums.size() - 1;
//		while (mid <= high) {
//
//			if (nums.get(mid) == 0) {
//				Collections.swap(nums, low, mid);
//				low++;
//				mid++;
//			} else if (nums.get(mid) == 2) {
//				Collections.swap(nums, mid, high);
//				high--;
//			} else {
//				mid++;
//			}
//		}
//
//		for (int numb : nums) {
//			System.out.print(numb);
//		}

		/*
		 * 
		 * Problem Statement: Given an array of N integers, write a program to return an
		 * element that occurs more than N/2 times in the given array. You may consider
		 * that such an element always exists in the array.
		 * 
		 * Examples
		 * 
		 * Example 1: Input Format: N = 3, nums[] = {3,2,3} Result: 3 Explanation: When
		 * we just count the occurrences of each number and compare with half of the
		 * size of the array, you will get 3 for the above solution.
		 * 
		 * Example 2: Input Format: N = 7, nums[] = {2,2,1,1,1,2,2}
		 * 
		 * Result: 2
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

		// Approach first:

		/*
		 * Time Complexity: 0(n*logn) Space Complexity:
		 * 
		 * 
		 */

//		ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(2, 2, 2, 2, 2, 1, 1, 1, 2, 2));
//
//		int max = Integer.MIN_VALUE;
//
//		int n = nums.size();
//
//		Collections.sort(nums);
//
//		for (int numb : nums) {
//			System.out.print(numb + " ");
//		}
//		int count = 1;
//		for (int i = 0; i < n - 1; i++) {
//			if (nums.get(i) == nums.get(i + 1)) {
//				count++;
//				if (count > max) {
//					max = count;
//				}
//			} else {
//				count = 0;
//			}
//
//		}
//		System.out.println(" ");
//		System.out.println(max + 1);

		// Hasmap Appraoch

		/*
		 * Time Complexity: 0(n) Space Complexity :0(n):
		 * 
		 * 
		 */
//		int[] nums = { 2, 2, 1, 1, 1, 2, 2 };
//		int n = nums.length;
//
//		// HashMap to store frequency of each element
//		HashMap<Integer, Integer> map = new HashMap<>();
//
//		for (int num : nums) {
//			map.put(num, map.getOrDefault(num, 0) + 1);
//
//			// Check if this element became majority
//			
//			if (map.get(num) > n / 2) {
//				System.out.println("Majority Element = " + num);
//				return;
//			}
//		}

		/*
		 * Solve Again; Time Complexity: 0(n) Space Complexity :0(1):
		 * 
		 * 
		 */
		// Solve Using Boyer–Moore Majority Vote Algorithm.

		/*
		 * 
		 * 
		 * 
		 * Problem Statement: Given an integer array arr, find the contiguous subarray
		 * (containing at least one number) which has the largest sum and returns its
		 * sum and prints the subarray.
		 * 
		 * Example 1:
		 * 
		 * Input: arr = [-2,1,-3,4,-1,2,1,-5,4]
		 * 
		 * Output: 6
		 * 
		 * Explanation: [4,-1,2,1] has the largest sum = 6.
		 * 
		 * Examples 2:
		 * 
		 * Input: arr = [1]
		 * 
		 * Output: 1
		 * 
		 * Explanation: Array has only one element and which is giving positive sum of
		 * 1.
		 * 
		 * 
		 * 
		 * 
		 */

		// Using two for loop
		/*
		 * Time Complexity:O(n*2) Space Complexity:(1)
		 * 
		 * 
		 */
//		int arr[] = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
//		int n = arr.length;
//		int startLoopIndex = 0;
//		int stopLoopIndex = 0;
//		int max = Integer.MIN_VALUE;
//		for (int i = 0; i < n; i++) {
//			int sum = 0;
//			for (int j = i; j < n; j++) {
//				sum += arr[j];
//
//				if (sum > max) {
//					max = sum;
//					startLoopIndex = i;
//					stopLoopIndex = j;
//				}
//
//			}
//
//		}
//		System.out.println("Starting and stoping loop index:" + startLoopIndex + " " + stopLoopIndex);
//		for (int i = startLoopIndex; i <= stopLoopIndex; i++) {
//			System.out.print(arr[i]);
//		}

		// Using two for loop
		/*
		 * Time Complexity:O(n) Space Complexity:(1)
		 * 
		 * 
		 */

//		int nums[] = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
//		int n = nums.length;
//		int max_so_far = nums[0];
//		int max_ending_here = nums[0];
//
//		for (int i = 1; i < nums.length; i++) {
//			max_ending_here = Math.max(nums[i], max_ending_here + nums[i]);
//			System.out.println(i + " " + max_ending_here);
//			max_so_far = Math.max(max_so_far, max_ending_here);
//		}
//		System.out.println(max_so_far);
//	}

		// solve again:
		// Also solve Using Kadnes Algorithum

		/*
		 * 
		 * 
		 * Problem Statement: You are given an array of prices where prices[i] is the
		 * price of a given stock on an ith day.
		 * 
		 * You want to maximize your profit by choosing a single day to buy one stock
		 * and choosing a different day in the future to sell that stock. Return the
		 * maximum profit you can achieve from this transaction. If you cannot achieve
		 * any profit, return 0.
		 * 
		 * 
		 * 
		 */

//		int arr[] = { 2, 1, 4 };
//		int n = arr.length;
//
//		int finalmax = Integer.MIN_VALUE;
//		int start = 0;
//		int end = n - 1;
//
//		while (start < end) {
//
//			if (arr[start] > arr[end]) {
//				start++;
//			} else {
//				int max = arr[end] - arr[start];
//				finalmax = Math.max(max, finalmax);
//				end--;
//			}
//		}
//
//		System.out.println(finalmax);

		/**
		 * 
		 * 
		 * 
		 * 
		 * Problem Statement: Given an integer array arr, find the contiguous subarray
		 * (containing at least one number) which has the largest sum and returns its
		 * sum and prints the subarray.
		 * 
		 * Examples Example 1:
		 * 
		 * Input: arr = [-2,1,-3,4,-1,2,1,-5,4]
		 * 
		 * Output: 6
		 * 
		 * Explanation: [4,-1,2,1] has the largest sum = 6.
		 * 
		 * Examples 2:
		 * 
		 * Input: arr = [1]
		 * 
		 * Output: 1
		 * 
		 * Explanation: Array has only one element and which is giving positive sum of
		 * 1.
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
		 * 
		 * 
		 */

		// Solve Above Example Again

		/**
		 * 
		 * 
		 * 
		 * Problem Statement: Given an array, print all the elements which are leaders.
		 * A Leader is an element that is greater than all of the elements on its right
		 * side in the array.
		 * 
		 * Examples
		 * 
		 * Example 1:
		 * 
		 * Input: arr = [4, 7, 1, 0] Output: 7 1 0
		 * 
		 * Explanation: Rightmost element is always a leader. 7 and 1 are greater than
		 * the elements in their right side.
		 * 
		 * Example 2:
		 * 
		 * Input: arr = [10, 22, 12, 3,0, 6] Output: 22 12 6
		 * 
		 * Explanation: 6 is a leader. In addition to that, 12 is greater than all the
		 * elements in its right side (3, 0, 6), also 22 is greater than 12, 3, 0, 6.
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 */

//		int arr[] = { 10, 22, 12, 3, 0, 6 };
//		int n = arr.length;
//
//		ArrayList<Integer> ans = new ArrayList<Integer>();
//
//		for (int i = 0; i < n - 1; i++) {
//
//			int temp = arr[i];
//			int max = Integer.MIN_VALUE;
//			for (int j = i + 1; j < n; j++) {
//				if (max < arr[j]) {
//					max = arr[j];
//				}
//
//			}
//
//			System.out.println(max + " " + temp + " ");
//
//			if (temp > max) {
//				ans.add(temp);
//
//			}
//
//		}
//
//		if (n >= 1) {
//			ans.add(arr[n - 1]);
//
//		}
//		System.out.println(ans + " ");

		// second approach

//		for (int i = 0; i < n; i++) {
//		    boolean leader = true;
//
//		    //Checking whether arr[i] is greater than all 
//		    //the elements in its right side
//		    for (int j = i + 1; j < n; j++)
//		      if (arr[j] > arr[i]) {
//		          
//		        // If any element found is greater than current leader
//		        // curr element is not the leader.
//		        leader = false;
//		        break;
//		      }
//
//		    // Push all the leaders in ans array.
//		    if (leader)
//		    ans.add(arr[i]);

		// Optimized way :

//		int arr[] = { 10, 22, 12, 3, 0, 6 };
//		int n = arr.length;
//
//		ArrayList<Integer> ans = new ArrayList<Integer>();
//
//		int max = arr[n - 1];
//
//		ans.add(arr[n - 1]);
//
//		for (int i = n - 2; i >= 0; i--)
//			if (arr[i] > max) {
//				ans.add(arr[i]);
//				max = arr[i];
//			}
//
//		System.out.println(ans + " ");

		/*
		 * 
		 * 
		 * 
		 * Problem Statement: You are given an array of ‘N’ integers. You need to find
		 * the length of the longest sequence which contains the consecutive elements.
		 * 
		 * Examples
		 * 
		 * Example 1:
		 * 
		 * Input: [100, 200, 1, 3, 2, 4]
		 * 
		 * Output: 4
		 * 
		 * Explanation: The longest consecutive subsequence is 1, 2, 3, and 4.
		 * 
		 * Input: [3, 8, 5, 7, 6]
		 * 
		 * Output: 4
		 * 
		 * Explanation: The longest consecutive subsequence is 5, 6, 7, and 8.
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
		 * 
		 */

//		ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(100, 200, 1, 3, 2, 4));
//		int n = arr.size();
//
//		ArrayList<Integer> ans = new ArrayList<Integer>();
//
//		Collections.sort(arr);
//
//		int lastElement = 0;
//		int first = 0;
//
//		for (int i = 0; i < n - 1; i++) {
//
//			if ((arr.get(i + 1) - arr.get(i)) == 1) {
//				lastElement = i + 1;
//			}
//
//			if ((arr.get(i + 1) - arr.get(i)) == 1) {
//				first = i;
//			}
//		}
//
//		System.out.println(first + "  " + lastElement);

		/*
		 * 
		 * 
		 * Problem Statement: Given a matrix, your task is to rotate the matrix 90
		 * degrees clockwise.
		 * 
		 * Note: Rotate matrix 90 degrees anticlockwise
		 * 
		 * Examples Example 1:
		 * 
		 * Input: [[1,2,3],[4,5,6],[7,8,9]]
		 * 
		 * Output: [[7,4,1],[8,5,2],[9,6,3]]
		 * 
		 * Explanation: Rotate the matrix simply by 90 degree clockwise and return the
		 * matrix.
		 * 
		 * Example 2:
		 * 
		 * Input: [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
		 * 
		 * Output:[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
		 * 
		 * Explanation: Rotate the matrix simply by 90 degree clockwise and return the
		 * matrix
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
		 * 
		 * 
		 */

		/**
		 * 
		 * Time Complexity: 0(N*2) Space Complexity:0(N*M)
		 * 
		 */

//		ArrayList<ArrayList<Integer>> nums = new ArrayList<ArrayList<Integer>>();
//		Scanner sc = new Scanner(System.in);
//
//		System.out.print("Enter the number of inner ArrayLists (n): ");
//		int n = sc.nextInt();
//
//		for (int i = 0; i < n; i++) {
//			int sizeOfArray = sc.nextInt();
//			ArrayList<Integer> tempInner = new ArrayList<Integer>();
//
//			for (int j = 0; j < sizeOfArray; j++) {
//				tempInner.add(sc.nextInt());
//			}
//			nums.add(tempInner);
//		}
//
//		// deep copy an ArrayList of ArrayLists
//		ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();
//		for (ArrayList<Integer> innerList : nums) {
//			temp.add(new ArrayList<>(innerList));
//		}
//
//		for (int i = 0; i < temp.size(); i++) {
//			for (int j = 0; j < temp.get(i).size(); j++) {
//				int value = temp.get(n - 1 - j).get(i);
//				nums.get(i).set(j, value);
//			}
//		}
//
//		System.out.println("The original array is: " + nums);
//		System.out.println("The copied array is: " + temp);

		// Using Transpose of Matrix and reverse to get space complexity 0(1) and time
		// as same 0(N*2)

//		// Rotate the matrix by 90° clockwise in-place
//		for (int i = 0; i < n; i++) {
//		    for (int j = i; j < n; j++) {
//		        // Transpose: swap (i,j) with (j,i)
//		        int temp = nums.get(i).get(j);
//		        nums.get(i).set(j, nums.get(j).get(i));
//		        nums.get(j).set(i, temp);
//		    }
//		}
//
//		// Reverse each row
//		for (int i = 0; i < n; i++) {
//		    Collections.reverse(nums.get(i));
//		}

		/*
		 * 
		 * 
		 * 
		 * 
		 * Problem Statement: Given a Matrix, print the given matrix in spiral order.
		 * 
		 * Examples:
		 * 
		 * Example 1: Input: Matrix[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11,
		 * 12 }, { 13, 14, 15, 16 } }
		 * 
		 * Outhput: 1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10. Explanation:
		 * The output of matrix in spiral form.
		 * 
		 * Example 2: Input: Matrix[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }
		 * 
		 * Output: 1, 2, 3, 6, 9, 8, 7, 4, 5. Explanation: The output of matrix in
		 * spiral form.
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

		/**
		 * 
		 * 
		 * Time Complexity : Space Complexity :
		 * 
		 * 
		 */

		/*
		 * 
		 * 
		 * 
		 * 
		 * 
		 * Problem Statement: Given an array of integers and an integer k, return the
		 * total number of subarrays whose sum equals k.
		 * 
		 * A subarray is a contiguous non-empty sequence of elements within an array.
		 * 
		 * Pre-requisite: Longest subarray with given sum
		 * 
		 * Examples
		 * 
		 * Example 1: Input Format: N = 4, array[] = {3, 1, 2, 4}, k = 6 Result: 2
		 * Explanation: The subarrays that sum up to 6 are [3, 1, 2] and [2, 4].
		 * 
		 * Example 2: Input Format: N = 3, array[] = {1,2,3}, k = 3 Result: 2
		 * Explanation: The subarrays that sum up to 3 are [1, 2], and [3].
		 */

		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> nums = new ArrayList<Integer>(Arrays.asList(1, 2, 7, 5, 5, 10, 5, 3, 2, 7, 1));
		int findValue = sc.nextInt();
		int n = nums.size();

		int finalCount = 0;
		int i = 0;
		int j = 0;
		int sum = 0;
		while (j < n) {
			sum += nums.get(j);
			System.out.println("For j is :" + j + " " + sum);
			if (sum == findValue) {
				finalCount++;

				if (nums.get(j + 1) + nums.get(j) < findValue && j != n - 1) {
					sum = nums.get(j);
					j++;
				} else {

					sum = 0;
					j++;
				}

			} else {
				j++;
			}

		}

		System.out.println("final Count is:" + finalCount);

	}
}