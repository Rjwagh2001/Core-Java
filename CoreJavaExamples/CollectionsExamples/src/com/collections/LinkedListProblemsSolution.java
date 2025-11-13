package com.collections;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListProblemsSolution {

	public void run() {

		LinkedList<Integer> nums = new LinkedList<Integer>();
		nums.push(1);
		nums.push(11);
		nums.push(10);
		nums.push(12);
		nums.push(13);

		for (int numb : nums) {
			System.out.println(numb);
		}

		System.out.println("----------------------------------- ");
		Iterator<Integer> itr = nums.iterator();

		while (itr.hasNext()) {
			int element = itr.next();

			System.out.println(element);

		}

		System.out.println("----------------------------------- ");

		while (!nums.isEmpty()) {
			System.out.println(nums.pop());
		}

	}
}
