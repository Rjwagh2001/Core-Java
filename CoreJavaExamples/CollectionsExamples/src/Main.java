import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.TreeSet;
import java.util.Vector;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
	public static void main(String[] args) {
		System.out.printf("Hello and welcome!");

		// Learning learning =new Learning();
		// learning.run();

		/*
		 * Collections have type safe and Non type safe
		 * 
		 * 1)Type safe :In type safe we stroe same type of data ArrayList<Integer>
		 * rollnumbers=new ArrayList<>();
		 * 
		 * 2)UnType Safe: In Untype safe we store different type of data LinkedList
		 * name=new LinkedList();
		 * 
		 */

		/*
		 * =============================================================================
		 * ==== List -> ArrayList ,LinkedList Vector ,Stack
		 * =============================================================================
		 * ======
		 */

		/* First Array List - Type Safe */
		ArrayList<String> names = new ArrayList<>();

		names.add("Rahul");
		names.add("Namdev");
		names.add("Jayshree");
		names.add("Sakshi");
		names.add("Wagh");
		names.add("Shalan");

		System.out.println(names);

		names.remove(0);

		/* Second Array List - UnType Safe */
		LinkedList name = new LinkedList();
		name.add("Amey");
		name.add(12);
		name.add(234.11);
		name.add(true);

		for (int i = 0; i < name.size(); i++) {
			System.out.println(name.get(i));
		}

		/*
		 * Third Type of list is vector(Type safe): Its an thread safe: means we can
		 * modified data data at a same time without loss of data in multethreading and
		 * thats why its an synchronisation
		 */

		Vector<String> names1 = new Vector();
		names1.add("Raj");
		names1.add("Rohan");
		names1.add("Vivek");
		names1.add("Amey");
		names1.add("Amit");

		for (int i = 0; i < names1.size(); i++) {
			System.out.println(names1.get(i));
		}

		/*
		 * Traversing an List
		 */

		/*
		 * first: Array List /LinkedList /Vector But vector have additionaly one is
		 * enumeration
		 */

//		There are several ways to traverse an ArrayList in Java:
//		Traditional for loop: This method uses an index to access elements, providing fine-grained control over iteration, including the ability to iterate backward or skip elements.
//		Java

		ArrayList<String> list = new ArrayList<>();
		list.add("Apple");
		list.add("Banana");
		for (int i = 0; i < list.size(); i++) {
			String element = list.get(i);
			System.out.println(element);
		}
//			Enhanced for loop (for-each loop): This is a simpler and more concise way to iterate when you only need to access the elements and not their indices.
//			Java

		ArrayList<String> list1 = new ArrayList<>();
		list1.add("Apple");
		list1.add("Banana");
		for (String element : list1) {
			System.out.println(element);
		}
//			Iterator: The Iterator interface provides a standard way to traverse collections. It allows you to remove elements during iteration.
//			Java

		ArrayList<String> list2 = new ArrayList<>();
		list2.add("Apple");
		list2.add("Banana");
		Iterator<String> iterator = list2.iterator();
		while (iterator.hasNext()) {
			String element = iterator.next();
			System.out.println(element);
		}
//			ListIterator: Similar to Iterator, but specifically for List implementations. It offers additional functionalities like bidirectional traversal, adding elements, and modifying existing elements during iteration.
//			Java

		ArrayList<String> list3 = new ArrayList<>();
		list3.add("Apple");
		list3.add("Banana");
		ListIterator<String> listIterator = list3.listIterator();
		while (listIterator.hasNext()) {
			String element = listIterator.next();
			System.out.println(element);
		}
		// To traverse backward
		while (listIterator.hasPrevious()) {
			String element = listIterator.previous();
			System.out.println("Backward: " + element);
		}
//			while loop with get() and index: Similar to the traditional for loop, but using a while loop construct.
//			Java

		ArrayList<String> list4 = new ArrayList<>();
		list4.add("Apple");
		list4.add("Banana");
		int i = 0;
		while (i < list4.size()) {
			String element = list4.get(i);
			System.out.println(element);
			i++;
		}
//			Stream.forEach() (Java 8 and later): Leveraging the Java Stream API for a functional approach to iteration.
//			Java

		ArrayList<String> list5 = new ArrayList<>();
		list5.add("Apple");
		list5.add("Banana");
		list5.stream().forEach(element -> System.out.println(element));
//			Iterable.forEach() (Java 8 and later): The Iterable interface (which ArrayList implements) provides a forEach method for consumer-based iteration.
//			Java

		ArrayList<String> list6 = new ArrayList<>();
		list6.add("Apple");
		list6.add("Banana");
		list6.forEach(element -> System.out.println(element));

		/*
		 * for Vector Using Enumeration (Legacy): Specific to Vector (and other legacy
		 * collections), Enumeration provides a basic way to iterate. Java
		 */

		Vector<String> vector = new Vector<>();
		vector.add("Apple");
		vector.add("Banana");
		vector.add("Cherry");

		Enumeration<String> enumeration = vector.elements();
		while (enumeration.hasMoreElements()) {
			System.out.println(enumeration.nextElement());
		}

		// Provide all examples with methods: set ,add ,empty, remove, add ,size ,clear
		// ,addAll,

		/*
		 * =============================================================================
		 * ==== Set -> HashSet,LinkedHashSet SortedTreeSet ->TreeSet
		 * =============================================================================
		 * ======
		 */

		// no indexed base ,duplicate not allowed, order not preserved,
		HashSet<String> namesHash = new HashSet();
		namesHash.add("Rahul");
		namesHash.add("Rahul");
		namesHash.add("Rahul");
		namesHash.add("Rahul");
		// giving as only one name output
		namesHash.stream().forEach(s -> {
			System.out.println(s);
		});

		// sorted bydefault ascending order. ,duplicate not allowed, order not
		// preserved,
		TreeSet<String> namesTree = new TreeSet();
		namesTree.add("Rahul");
		namesTree.add("Ratan");
		namesTree.add("Mom");
		namesTree.add("Mam");

		namesTree.stream().forEach(s -> {
			System.out.println("Printing an treeset elments: " + s);
		});

	}

}
