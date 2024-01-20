/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashtable;

// Java Programs to implement hashtable with
// equals() and hashcode() method

// Importing hashtable and Scanner classes
// from java.util package
import java.util.Hashtable;
import java.util.Scanner;

// Class 1
// Helper class
class Student {
	// Initializing the instance variables
	// of this class
	private int sid;
	private String name;
	private String mobno;

	// Constructor of student class
	// to initialize the variable values
	public Student(int sid, String name, String mobno)
	{

		// Super keyword refers to parent object
		super();

		// This keyword refers to current object
		// in a constructor
		this.sid = sid;
		this.name = name;
		this.mobno = mobno;
	}

	// Method 1
	// getter for Sid
	public int getSid() { return sid; }

	// Method 2
	// setter for Sid
	public void setSid(int sid) { this.sid = sid; }

	// Method 3
	// getter for name
	public String getName() { return name; }

	// Method 4
	// setter for name
	public void setName(String name) { this.name = name; }

	// Method 5
	// getter for mobno
	public String getMobno() { return mobno; }

	// Method 6
	// setter for mobno
	public void setMobno(String mobno)
	{
		this.mobno = mobno;
	}

	// Now, overriding methods
	// Overriding of hashCode
	// @Override
	public int hashCode() { return this.getSid(); }

	// Overriding of equals
	// @Override
	public boolean equals(Object o)
	{
		if (o instanceof Student) {
			return (this.sid) == (((Student)o).sid);
		}
		return false;
	}

	// Overriding of toString() method
	// @Override
	public String toString()
	{
		return "id=" + sid + ", name=" + name
			+ ", mobno=" + mobno;
	}
}

// Class 2
// Main class for hashtableExample
public class GFG {
	// Main driver method
	public static void main(String a[])
	{
		// Initializing the hashtable with
		// key as integer and value as Student object

		// Creating an Hashtable object
		// Declaring object of Integer and String type
		Hashtable<Integer, Student> list
			= new Hashtable<Integer, Student>();
                Student st1 = new Student(101, "Ram", "9876543201");
		// Adding elements to the hashtable
		// Custom inputs
		list.put(101, st1);
               Student st2 = new Student(102, "Shyam", "8907685432");
		list.put(102, st2);
                 System.out.println(st1.hashCode());
                 System.out.println(st2.hashCode());
//		list.put(103,
//				new Student(103, "Mohan", "8907896785"));
//		list.put(104, new Student(104, "Lakshman",
//								"8909006524"));
//		list.put(105,
//				new Student(105, "Raman", "6789054321"));
//
//		// Display message
//		System.out.println("Traversing the hash table");
//
//		// Traversing hashtable using for-each loop
//		for (Student i : list.values()) {
//			System.out.println(i);
//		}
//
//		// New line
//		System.out.println();
//
//		// Display message
//		System.out.println(
//			"Search the student by student id");
//
//		// New line
//		System.out.println();
//
//		// Display message
//		System.out.println("Enter the student id : ");
//
//		// Custom value in a variable is assigned
//		int temp = 104;
//		// Display message
//		System.out.println("104");
//
//		// Traversing hashtable using for-each loop
//		for (Student s : list.values()) {
//			if (s.getSid() == temp) {
//				// If student found, simply print the
//				// student details
//				System.out.println("Student is : " + s);
//
//				// Exit the program
//				System.exit(0);
//			}
//		}
//
//		// If student not found execute the command
//
//		// Print the display message
//		System.out.println("Student not found..");
	}
}
