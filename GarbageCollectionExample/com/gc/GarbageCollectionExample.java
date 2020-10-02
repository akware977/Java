package com.gc;

class Student {
	String name = "";
	
	public Student() {
	}

	public Student(String name) {
		super();
		this.name = name;
	}

	@Override
	protected void finalize()  {
		//code to release resource
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}

public class GarbageCollectionExample {

	public static void main(String[] args) {
		Student s1 = new Student("Akshay");
		Student s2 = new Student("Snehal");
		
		s1=s2;
		Runtime rc = Runtime.getRuntime();
		System.out.println("Full Memory " + rc.totalMemory()+" bytes");
		System.out.println("Free memory before GC = " +rc.freeMemory()+" bytes");
		System.out.println("Student 1 : " +s1.getName());
		System.out.println("Student 2 : " +s2.getName());
		System.gc();
		System.out.println("Free memory after GC = " +rc.freeMemory()+" bytes");
		System.out.println("Student 1 : " +s1.getName());
		System.out.println("Student 2 : " +s2.getName());
		
		
	}

}
