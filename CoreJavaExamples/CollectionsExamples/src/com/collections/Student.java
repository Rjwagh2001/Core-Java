package com.collections;

public class Student {

	private static String name;
	private static int marks;

	Student() {

	}

	Student(String name, int marks) {
		this.name = name;
		this.marks = marks;
	}

	public static String getName() {
		return name;
	}

	public static void setName(String name) {
		Student.name = name;
	}

	public static int getMarks() {
		return marks;
	}

	public static void setMarks(int marks) {
		Student.marks = marks;
	}

}
