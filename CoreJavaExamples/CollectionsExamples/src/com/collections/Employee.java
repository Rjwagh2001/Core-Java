package com.collections;

public class Employee {

	public String name;
	public int age;
	public int salary;

	public Employee(String name2, int age2, int salary2) {
		this.name = name2;
		this.age = age2;
		this.salary = salary2;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", salary=" + salary + "]";
	}

}
