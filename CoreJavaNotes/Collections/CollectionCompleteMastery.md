# Java Collections Framework - Complete Mastery Guide
## For Product-Based Companies (Google, Amazon, Microsoft, etc.)

---

## LEVEL 1: FUNDAMENTALS

### Q1. What is Java Collections Framework? Why do we need it?
**Answer:**
- Framework providing architecture to store and manipulate groups of objects
- Before collections: Arrays (fixed size), Vector, Hashtable (legacy)
- Benefits: Dynamic sizing, ready-to-use data structures, algorithms

**Example:**
```java
// Without Collections (Array - Fixed Size)
String[] names = new String[5];
names[0] = "Alice";
// Problem: Size fixed, no built-in methods

// With Collections (ArrayList - Dynamic)
List<String> namesList = new ArrayList<>();
namesList.add("Alice");
namesList.add("Bob");
// Dynamic size, many utility methods
```

### Q2. What is the Collection Hierarchy? Draw it.
**Answer:**
```
Collection (Interface)
├── List (Interface) - Ordered, allows duplicates
│   ├── ArrayList (Class)
│   ├── LinkedList (Class)
│   └── Vector (Class) - Legacy
├── Set (Interface) - No duplicates
│   ├── HashSet (Class)
│   ├── LinkedHashSet (Class)
│   └── SortedSet (Interface)
│       └── TreeSet (Class)
└── Queue (Interface) - FIFO
    ├── PriorityQueue (Class)
    └── Deque (Interface)
        └── ArrayDeque (Class)

Map (Interface) - Separate hierarchy, key-value pairs
├── HashMap (Class)
├── LinkedHashMap (Class)
├── Hashtable (Class) - Legacy
└── SortedMap (Interface)
    └── TreeMap (Class)
```

# Java Collections Framework - Complete Mastery Guide

## Phase 1: Core Fundamentals

### Q1. What is Java Collections Framework?
**Answer:** A unified architecture for representing and manipulating collections of objects.

**Key Components:**
- **Interfaces:** Collection, List, Set, Queue, Map
- **Implementations:** ArrayList, LinkedList, HashSet, TreeSet, HashMap, etc.
- **Algorithms:** Sorting, searching, shuffling

**Why it exists:** Before Java 1.2, we had Vector, Hashtable, Array - no standard way to handle groups of objects.

---

### Q2. Collection Hierarchy - Draw and Explain
```
        Iterable
           |
       Collection
       /    |    \
    List   Set   Queue
           |      |
      SortedSet  Deque

    Map (separate hierarchy)
     |
  SortedMap
```

**Key Points:**
- Map is NOT a Collection (doesn't extend Collection interface)
- All collections except Map store single values
- Map stores key-value pairs

---

### Q3. List vs Set vs Queue vs Map - Core Differences

| Feature | List | Set | Queue | Map |
|---------|------|-----|-------|-----|
| **Duplicates** | Allowed | Not Allowed | Allowed | Keys: No, Values: Yes |
| **Order** | Insertion Order | No order (except TreeSet) | FIFO/Priority | No order (except LinkedHashMap) |
| **Null** | Multiple nulls | One null (TreeSet: none) | Implementation dependent | One null key |
| **Index** | Yes | No | No | No |
| **Use Case** | Ordered data | Unique elements | Process in order | Key-value pairs |

---

## Phase 2: ArrayList Deep Dive

### Q4. How does ArrayList work internally?
**Answer:**
```java
// Internal structure
private transient Object[] elementData;
private int size;
private static final int DEFAULT_CAPACITY = 10;
```

**Key Concepts:**
1. **Dynamic Array:** Resizable array implementation
2. **Initial Capacity:** Default 10
3. **Load Factor:** When 75% full, doubles in size
4. **Growth:** new capacity = (old capacity * 3/2) + 1

**Example:**
```java
ArrayList<Integer> list = new ArrayList<>(); // capacity = 10
// Add 11th element → creates new array of size 15
// Copies all elements to new array
```

### Q5. ArrayList Operations Time Complexity
```java
ArrayList<String> list = new ArrayList<>();

// O(1) - Add at end
list.add("A");

// O(n) - Add at specific index (shifting required)
list.add(0, "B");

// O(1) - Get by index
String item = list.get(0);

// O(n) - Remove (shifting required)
list.remove(0);

// O(n) - Contains/Search
boolean exists = list.contains("A");
```

### Q6. ArrayList vs Array
```java
// Array - Fixed size
String[] arr = new String[5];
arr[0] = "A";
// arr[5] = "F"; // ArrayIndexOutOfBoundsException

// ArrayList - Dynamic
ArrayList<String> list = new ArrayList<>();
list.add("A");
list.add("B");
// Can add unlimited elements
```

**Key Differences:**
- Array: Fixed size, can store primitives
- ArrayList: Dynamic, only objects (uses autoboxing for primitives)

---

## Phase 3: LinkedList Deep Dive

### Q7. How does LinkedList work internally?
**Answer:**
```java
// Node structure
private static class Node<E> {
    E item;
    Node<E> next;
    Node<E> prev;
}

private Node<E> first;
private Node<E> last;
private int size;
```

**Visual:**
```
[A] ⇄ [B] ⇄ [C] ⇄ [D]
 ↑              ↑
first          last
```

### Q8. ArrayList vs LinkedList - When to use what?

**ArrayList - Use When:**
```java
// Frequent random access
for(int i = 0; i < list.size(); i++) {
    System.out.println(list.get(i)); // O(1)
}

// More reads than writes
// Memory efficient (no node overhead)
```

**LinkedList - Use When:**
```java
// Frequent insertions/deletions at beginning/middle
list.addFirst("A");  // O(1)
list.addLast("B");   // O(1)
list.add(5, "C");    // O(n) but no shifting

// Implementing Queue/Deque
Queue<String> queue = new LinkedList<>();
```

**Complexity Comparison:**
| Operation | ArrayList | LinkedList |
|-----------|-----------|------------|
| get(index) | O(1) | O(n) |
| add(element) | O(1)* | O(1) |
| add(index, element) | O(n) | O(n) |
| remove(index) | O(n) | O(n) |
| addFirst/addLast | O(n) | O(1) |

---

## Phase 4: HashSet Deep Dive

### Q9. How does HashSet work internally?
**Answer:**
```java
// HashSet uses HashMap internally
private transient HashMap<E,Object> map;
private static final Object PRESENT = new Object();

public boolean add(E e) {
    return map.put(e, PRESENT) == null;
}
```

**Key Points:**
- Stores elements as keys in HashMap
- Value is dummy object (PRESENT)
- No duplicates because Map keys are unique

### Q10. How does HashSet check for duplicates?
```java
// Process:
// 1. Calculate hashCode()
// 2. Find bucket using: hash % capacity
// 3. Check equals() for elements in same bucket

class Person {
    String name;
    int age;
    
    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return age == person.age && 
               Objects.equals(name, person.name);
    }
}

HashSet<Person> set = new HashSet<>();
set.add(new Person("John", 25));
set.add(new Person("John", 25)); // Duplicate, not added
```

### Q11. HashSet vs TreeSet vs LinkedHashSet

**HashSet:**
```java
Set<String> set = new HashSet<>();
set.add("C");
set.add("A");
set.add("B");
System.out.println(set); // [A, B, C] or [C, B, A] - no order
// Time: O(1), Space: O(n)
```

**LinkedHashSet:**
```java
Set<String> set = new LinkedHashSet<>();
set.add("C");
set.add("A");
set.add("B");
System.out.println(set); // [C, A, B] - insertion order maintained
// Time: O(1), Space: O(n) + overhead for maintaining order
```

**TreeSet:**
```java
Set<String> set = new TreeSet<>();
set.add("C");
set.add("A");
set.add("B");
System.out.println(set); // [A, B, C] - sorted order
// Time: O(log n), Space: O(n)
```

---

## Phase 5: HashMap Deep Dive

### Q12. How does HashMap work internally?
**Answer:**
```java
// Internal structure
static class Node<K,V> {
    final int hash;
    final K key;
    V value;
    Node<K,V> next;
}

transient Node<K,V>[] table; // Array of buckets
static final int DEFAULT_INITIAL_CAPACITY = 16;
static final float DEFAULT_LOAD_FACTOR = 0.75f;
```

**Visual:**
```
Index  Bucket
  0  → [key1,val1] → null
  1  → [key2,val2] → [key3,val3] → null (collision chain)
  2  → null
  3  → [key4,val4] → null
  ...
  15 → [key5,val5] → null
```

### Q13. HashMap put() operation - Step by step
```java
HashMap<String, Integer> map = new HashMap<>();
map.put("John", 25);

// Steps:
// 1. Calculate hashCode of key "John"
int hash = "John".hashCode();

// 2. Calculate bucket index
int index = hash % 16; // 16 is default capacity

// 3. Check if bucket is empty
//    - If empty: add new node
//    - If not empty: check for existing key
//      - If key exists: replace value
//      - If key doesn't exist: add to chain (collision)

// 4. Check load factor
//    - If size > capacity * 0.75
//    - Resize (double capacity) and rehash all entries
```

### Q14. Handle HashMap collisions - Before and After Java 8
**Before Java 8:**
```java
// Used LinkedList for collision handling
Bucket: [Node1] → [Node2] → [Node3]
// Search time in worst case: O(n)
```

**After Java 8:**
```java
// Uses TreeMap when collision exceeds threshold (8 elements)
// LinkedList → Red-Black Tree
// Search time in worst case: O(log n)
```

### Q15. HashMap vs Hashtable vs ConcurrentHashMap

**HashMap:**
```java
Map<String, Integer> map = new HashMap<>();
map.put(null, 1);  // Allowed
map.put("A", null); // Allowed
// Not thread-safe
// Performance: Best
```

**Hashtable:**
```java
Map<String, Integer> map = new Hashtable<>();
// map.put(null, 1);  // NullPointerException
// map.put("A", null); // NullPointerException
// Thread-safe (synchronized methods)
// Performance: Slow (locks entire table)
```

**ConcurrentHashMap:**
```java
Map<String, Integer> map = new ConcurrentHashMap<>();
// map.put(null, 1);  // NullPointerException
map.put("A", 1);    // Allowed
// Thread-safe (segment locking)
// Performance: Better than Hashtable
```

---

## Phase 6: Queue & Deque

### Q16. Queue implementations and use cases
```java
// 1. LinkedList (FIFO)
Queue<String> queue = new LinkedList<>();
queue.offer("A");
queue.offer("B");
System.out.println(queue.poll()); // A

// 2. PriorityQueue (Min Heap by default)
Queue<Integer> pq = new PriorityQueue<>();
pq.offer(5);
pq.offer(1);
pq.offer(3);
System.out.println(pq.poll()); // 1 (smallest)

// 3. ArrayDeque (Double ended queue)
Deque<String> deque = new ArrayDeque<>();
deque.offerFirst("A");
deque.offerLast("B");
System.out.println(deque.pollFirst()); // A
System.out.println(deque.pollLast());  // B
```

### Q17. PriorityQueue - Custom Comparator
```java
// Min Heap (default)
PriorityQueue<Integer> minHeap = new PriorityQueue<>();

// Max Heap (custom comparator)
PriorityQueue<Integer> maxHeap = 
    new PriorityQueue<>((a, b) -> b - a);

// Custom Object
class Task {
    String name;
    int priority;
}

PriorityQueue<Task> taskQueue = new PriorityQueue<>(
    (t1, t2) -> t1.priority - t2.priority
);
```

---

## Phase 7: Important Operations

### Q18. Sorting Collections
```java
// List sorting
List<Integer> list = Arrays.asList(5, 2, 8, 1);
Collections.sort(list); // [1, 2, 5, 8]
list.sort(Comparator.reverseOrder()); // [8, 5, 2, 1]

// Custom object sorting
class Employee {
    String name;
    int salary;
}

List<Employee> employees = new ArrayList<>();
// Sort by salary
employees.sort((e1, e2) -> e1.salary - e2.salary);
// Sort by name
employees.sort(Comparator.comparing(e -> e.name));
```

### Q19. Iterating Collections - Different Ways
```java
List<String> list = Arrays.asList("A", "B", "C");

// 1. For-each loop
for(String s : list) {
    System.out.println(s);
}

// 2. Iterator
Iterator<String> itr = list.iterator();
while(itr.hasNext()) {
    System.out.println(itr.next());
}

// 3. ListIterator (bidirectional)
ListIterator<String> listItr = list.listIterator();
while(listItr.hasNext()) {
    System.out.println(listItr.next());
}

// 4. forEach with Lambda
list.forEach(s -> System.out.println(s));

// 5. Stream API
list.stream().forEach(System.out::println);
```

### Q20. Fail-Fast vs Fail-Safe Iterators
```java
// Fail-Fast (ConcurrentModificationException)
List<String> list = new ArrayList<>(Arrays.asList("A", "B", "C"));
Iterator<String> itr = list.iterator();
while(itr.hasNext()) {
    String s = itr.next();
    list.remove(s); // ConcurrentModificationException
}

// Correct way with Iterator
Iterator<String> itr2 = list.iterator();
while(itr2.hasNext()) {
    itr2.next();
    itr2.remove(); // Safe
}

// Fail-Safe (CopyOnWriteArrayList)
List<String> list2 = new CopyOnWriteArrayList<>(
    Arrays.asList("A", "B", "C"));
for(String s : list2) {
    list2.remove(s); // No exception, works on copy
}
```

---

## Phase 8: Advanced Concepts

### Q21. Comparable vs Comparator
```java
// Comparable - Natural ordering
class Student implements Comparable<Student> {
    String name;
    int marks;
    
    @Override
    public int compareTo(Student other) {
        return this.marks - other.marks; // Sort by marks
    }
}

List<Student> students = new ArrayList<>();
Collections.sort(students); // Uses compareTo

// Comparator - Custom ordering
Comparator<Student> nameComparator = 
    (s1, s2) -> s1.name.compareTo(s2.name);

students.sort(nameComparator); // Sort by name
```

### Q22. Collections utility methods
```java
List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

// Sort
Collections.sort(list);

// Reverse
Collections.reverse(list);

// Shuffle
Collections.shuffle(list);

// Binary Search (requires sorted list)
int index = Collections.binarySearch(list, 3);

// Min/Max
int min = Collections.min(list);
int max = Collections.max(list);

// Frequency
int freq = Collections.frequency(list, 3);

// Unmodifiable
List<Integer> immutable = Collections.unmodifiableList(list);
// immutable.add(6); // UnsupportedOperationException
```

---

## Phase 9: Product-Based Company Questions

### Q23. Find first non-repeating character in string (Amazon)
```java
String findFirstNonRepeating(String s) {
    Map<Character, Integer> map = new LinkedHashMap<>();
    
    for(char c : s.toCharArray()) {
        map.put(c, map.getOrDefault(c, 0) + 1);
    }
    
    for(Map.Entry<Character, Integer> entry : map.entrySet()) {
        if(entry.getValue() == 1) {
            return entry.getKey().toString();
        }
    }
    return "-1";
}
```

### Q24. Group anagrams together (Google)
```java
List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> map = new HashMap<>();
    
    for(String s : strs) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        String key = new String(chars);
        
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(s);
    }
    
    return new ArrayList<>(map.values());
}
// Input: ["eat","tea","tan","ate","nat","bat"]
// Output: [["eat","tea","ate"],["tan","nat"],["bat"]]
```

### Q25. LRU Cache Implementation (Microsoft, Amazon)
```java
class LRUCache {
    private LinkedHashMap<Integer, Integer> map;
    private int capacity;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new LinkedHashMap<>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > capacity;
            }
        };
    }
    
    public int get(int key) {
        return map.getOrDefault(key, -1);
    }
    
    public void put(int key, int value) {
        map.put(key, value);
    }
}
```

---

## Study Path for Top Product Companies

### Week 1: Fundamentals
- Collection hierarchy
- ArrayList, LinkedList internals
- Time complexity analysis

### Week 2: Sets & Maps
- HashSet, TreeSet, LinkedHashSet
- HashMap internals, collision handling
- HashCode and Equals contract

### Week 3: Advanced
- Queue, Deque, PriorityQueue
- Comparable vs Comparator
- Thread-safe collections

### Week 4: Practice
- LeetCode Array/HashMap problems
- HackerRank Collections problems
- Company-specific questions

### Key Resources:
1. Practice 50+ problems on LeetCode (HashMap, Array, Set tags)
2. Understand internal implementations (ArrayList, HashMap, TreeMap)
3. Master time/space complexity
4. Practice coding without IDE


