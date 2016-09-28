package com.tpajay.javahack.mycode.corejava;

import java.util.*;
import com.tpajay.javahack.mycode.Employee;

// ArrayList:  Uses index based Array, can expand and reduce list. Dynamic Array
//             Most used
// LinkedList: Uses Doubled Linked List (doubly linked list) Data Structure
//                 linked records called nodes, each node contains two fields that are
//                 references to previous and next node in the sequence of nodes.
//             Overall faster than an ArrayList
//             Is a sequence of NODES that contains two parts: data(String, object) 
//                 and reference(memory address) to next NODE in the list
//             Beginning of list starts with HEAD, end is null
//             Best Choice of insertion/deletion in middle of list
// ArrayList and LinkedList are NOT synchronized.  To synchronize you must use
// List list = Collections.synchronizedList(new LinkedList(...));
public class LinkedListTest {
	
	public static void main(String args[]){		
		
		LinkedList linkedList = new LinkedList();
		
		Employee emp1 = new Employee("Bob", "Smith", "101 N. Blvd.", "Tampa", "FL", "33602");
		Employee emp2 = new Employee("Susie", "Smith", "101 N. Blvd.", "Tampa", "FL", "33602");
		Employee emp3 = new Employee("Travis", "Barker", "Hollywood Blvd.", "LA", "CA", "23232");
		Employee emp4 = new Employee("Kurt", "Cobain", "Seattles Best.", "Seattle", "WA", "33602");
		
		linkedList.add(emp1); //0
		linkedList.add(emp2); //1
		linkedList.add(emp3); //2
		linkedList.add(emp4); //3
		
		//First, list all LinkedList items
		System.out.println("Starting List:");
		outputList(linkedList);
		
		System.out.println("---------------------------------------------------");
		
		//Display emp2
		Employee p = (Employee)linkedList.get(2);
		System.out.println("Employee at index 2: " + p.getFullname());
		
		System.out.println("---------------------------------------------------");
		
		//Remove emp2 show output
		System.out.println("Removing Employee Travis Barker currently at index 2:");
		linkedList.remove(2);
		outputList(linkedList);
				
		System.out.println("---------------------------------------------------");
		
		System.out.println("Re-adding Employee Travis Barker but to top, index 0:");
		linkedList.addFirst(emp3);
		outputList(linkedList);
		
		System.out.println("---------------------------------------------------");
		
		System.out.println("Adding new Employee Tom Cruise in middle index 2:");
		Employee emp5 = new Employee("Tom", "Cruise", "Church of Scientology", "Clearwater", "FL", "33602");
		linkedList.add(2, emp5);
		outputList(linkedList);
		
		//Employee empTest = (Employee)linkedList.get

	}

	public static void outputList(List linkedlist){
		Employee op = null;
		for(int x=0 ; x < linkedlist.size() ; x++) {
			op = (Employee)linkedlist.get(x);
			System.out.println("Employee at index " + x + " is " + op.getFullname());
		}			
	}
}
