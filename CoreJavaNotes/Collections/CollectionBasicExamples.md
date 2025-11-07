# Java Collections - Basic Examples for Strong Fundamentals

## 🎯 PART 1: ARRAYLIST - Complete Basics

### Example 1: Creating and Adding Elements
```java
// Creating ArrayList
List<String> fruits = new ArrayList<>();

// Adding elements
fruits.add("Apple");           // [Apple]
fruits.add("Banana");          // [Apple, Banana]
fruits.add("Cherry");          // [Apple, Banana, Cherry]
fruits.add(1, "Mango");        // [Apple, Mango, Banana, Cherry]

System.out.println(fruits);    // [Apple, Mango, Banana, Cherry]
System.out.println(fruits.size()); // 4
```

### Example 2: Accessing and Modifying Elements
```java
List<Integer> numbers = new ArrayList<>();
numbers.add(10);
numbers.add(20);
numbers.add(30);

// Accessing elements
int first = numbers.get(0);        // 10
int last = numbers.get(numbers.size() - 1); // 30

// Modifying elements
numbers.set(1, 25);                // [10, 25, 30]

// Checking if element exists
boolean has20 = numbers.contains(20);  // false
boolean has25 = numbers.contains(25);  // true

System.out.println(numbers);       // [10, 25, 30]
```

### Example 3: Removing Elements
```java
List<String> colors = new ArrayList<>();
colors.add("Red");
colors.add("Green");
colors.add("Blue");
colors.add("Yellow");

// Remove by index
colors.remove(0);              // [Green, Blue, Yellow]

// Remove by object
colors.remove("Blue");         // [Green, Yellow]

// Remove all elements
colors.clear();                // []

System.out.println(colors.isEmpty()); // true
```

### Example 4: Iterating ArrayList
```java
List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

// Method 1: For-each loop
for (String name : names) {
    System.out.println(name);
}

// Method 2: Traditional for loop
for (int i = 0; i < names.size(); i++) {
    System.out.println(names.get(i));
}

// Method 3: Iterator
Iterator<String> iterator = names.iterator();
while (iterator.hasNext()) {
    System.out.println(iterator.next());
}

// Method 4: forEach (Java 8+)
names.forEach(name -> System.out.println(name));

// Method 5: Stream (Java 8+)
names.stream().forEach(System.out::println);
```

### Example 5: ArrayList Operations
```java
List<Integer> nums = new ArrayList<>(Arrays.asList(5, 2, 8, 1, 9));

// Sorting
Collections.sort(nums);            // [1, 2, 5, 8, 9]

// Reverse
Collections.reverse(nums);         // [9, 8, 5, 2, 1]

// Find min and max
int min = Collections.min(nums);   // 1
int max = Collections.max(nums);   // 9

// Frequency
int count = Collections.frequency(nums, 5); // 1

// Convert to array
Integer[] array = nums.toArray(new Integer[0]);
```

---

## 🎯 PART 2: LINKEDLIST - Complete Basics

### Example 1: LinkedList Creation and Operations
```java
LinkedList<String> list = new LinkedList<>();

// Adding elements
list.add("A");                 // [A]
list.add("B");                 // [A, B]
list.addFirst("Z");            // [Z, A, B]
list.addLast("C");             // [Z, A, B, C]

// Accessing elements
String first = list.getFirst(); // Z
String last = list.getLast();   // C

// Removing elements
list.removeFirst();            // [A, B, C]
list.removeLast();             // [A, B]

System.out.println(list);      // [A, B]
```

### Example 2: LinkedList as Queue (FIFO)
```java
Queue<String> queue = new LinkedList<>();

// Adding to queue (enqueue)
queue.offer("First");          // [First]
queue.offer("Second");         // [First, Second]
queue.offer("Third");          // [First, Second, Third]

// Peek (view without removing)
String front = queue.peek();   // First

// Removing from queue (dequeue)
String removed1 = queue.poll(); // First
String removed2 = queue.poll(); // Second

System.out.println(queue);     // [Third]
```

### Example 3: LinkedList as Stack (LIFO)
```java
LinkedList<Integer> stack = new LinkedList<>();

// Push elements
stack.push(1);                 // [1]
stack.push(2);                 // [2, 1]
stack.push(3);                 // [3, 2, 1]

// Peek top element
int top = stack.peek();        // 3

// Pop elements
int pop1 = stack.pop();        // 3, stack: [2, 1]
int pop2 = stack.pop();        // 2, stack: [1]

System.out.println(stack);     // [1]
```

---

## 🎯 PART 3: HASHSET - Complete Basics

### Example 1: Basic HashSet Operations
```java
Set<String> set = new HashSet<>();

// Adding elements
set.add("Apple");              // true
set.add("Banana");             // true
set.add("Apple");              // false (duplicate not added)

System.out.println(set);       // [Apple, Banana] (no duplicates, no order)
System.out.println(set.size()); // 2

// Checking if element exists
boolean hasApple = set.contains("Apple");  // true
boolean hasCherry = set.contains("Cherry"); // false

// Removing element
set.remove("Banana");          // [Apple]
```

### Example 2: Remove Duplicates from List
```java
List<Integer> listWithDuplicates = Arrays.asList(1, 2, 2, 3, 3, 4, 5, 5);

// Convert to Set to remove duplicates
Set<Integer> uniqueSet = new HashSet<>(listWithDuplicates);
System.out.println(uniqueSet); // [1, 2, 3, 4, 5]

// Convert back to List
List<Integer> uniqueList = new ArrayList<>(uniqueSet);
System.out.println(uniqueList); // [1, 2, 3, 4, 5]
```

### Example 3: Set Operations
```java
Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3, 4));
Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 4, 5, 6));

// Union (all elements)
Set<Integer> union = new HashSet<>(set1);
union.addAll(set2);
System.out.println("Union: " + union); // [1, 2, 3, 4, 5, 6]

// Intersection (common elements)
Set<Integer> intersection = new HashSet<>(set1);
intersection.retainAll(set2);
System.out.println("Intersection: " + intersection); // [3, 4]

// Difference (in set1 but not in set2)
Set<Integer> difference = new HashSet<>(set1);
difference.removeAll(set2);
System.out.println("Difference: " + difference); // [1, 2]
```

### Example 4: LinkedHashSet - Maintains Insertion Order
```java
Set<String> linkedSet = new LinkedHashSet<>();
linkedSet.add("C");
linkedSet.add("A");
linkedSet.add("B");

System.out.println(linkedSet); // [C, A, B] (insertion order maintained)
```

### Example 5: TreeSet - Sorted Order
```java
Set<Integer> treeSet = new TreeSet<>();
treeSet.add(5);
treeSet.add(2);
treeSet.add(8);
treeSet.add(1);

System.out.println(treeSet);   // [1, 2, 5, 8] (sorted automatically)

// TreeSet methods
int first = ((TreeSet<Integer>) treeSet).first();  // 1
int last = ((TreeSet<Integer>) treeSet).last();    // 8
```

---

## 🎯 PART 4: HASHMAP - Complete Basics

### Example 1: Basic HashMap Operations
```java
Map<String, Integer> map = new HashMap<>();

// Adding key-value pairs
map.put("Alice", 25);          // {Alice=25}
map.put("Bob", 30);            // {Alice=25, Bob=30}
map.put("Charlie", 35);        // {Alice=25, Bob=30, Charlie=35}

// Getting value by key
int age = map.get("Alice");    // 25
Integer unknown = map.get("David"); // null

// Check if key exists
boolean hasAlice = map.containsKey("Alice"); // true
boolean hasAge25 = map.containsValue(25);    // true

// Get size
System.out.println(map.size()); // 3

// Remove entry
map.remove("Bob");             // {Alice=25, Charlie=35}
```

### Example 2: Updating Values
```java
Map<String, Integer> scores = new HashMap<>();
scores.put("Math", 80);
scores.put("Science", 90);

// Update value
scores.put("Math", 85);        // Overwrites previous value
System.out.println(scores.get("Math")); // 85

// Put if absent (only add if key doesn't exist)
scores.putIfAbsent("English", 75);
scores.putIfAbsent("Math", 100);  // Won't update (key exists)

System.out.println(scores);    // {Math=85, Science=90, English=75}
```

### Example 3: Iterating HashMap
```java
Map<String, Integer> map = new HashMap<>();
map.put("A", 1);
map.put("B", 2);
map.put("C", 3);

// Method 1: Iterate over keys
for (String key : map.keySet()) {
    System.out.println(key + " = " + map.get(key));
}

// Method 2: Iterate over values
for (Integer value : map.values()) {
    System.out.println(value);
}

// Method 3: Iterate over entries (best way)
for (Map.Entry<String, Integer> entry : map.entrySet()) {
    System.out.println(entry.getKey() + " = " + entry.getValue());
}

// Method 4: forEach (Java 8+)
map.forEach((key, value) -> System.out.println(key + " = " + value));
```

### Example 4: Counting Frequency using HashMap
```java
String text = "hello world";
Map<Character, Integer> frequency = new HashMap<>();

for (char c : text.toCharArray()) {
    if (c != ' ') {
        // Method 1: Traditional way
        if (frequency.containsKey(c)) {
            frequency.put(c, frequency.get(c) + 1);
        } else {
            frequency.put(c, 1);
        }
        
        // Method 2: Using getOrDefault (better)
        frequency.put(c, frequency.getOrDefault(c, 0) + 1);
    }
}

System.out.println(frequency); // {d=1, e=1, h=1, l=3, o=2, r=1, w=1}
```

### Example 5: LinkedHashMap - Maintains Insertion Order
```java
Map<String, Integer> linkedMap = new LinkedHashMap<>();
linkedMap.put("C", 3);
linkedMap.put("A", 1);
linkedMap.put("B", 2);

System.out.println(linkedMap); // {C=3, A=1, B=2} (insertion order)
```

### Example 6: TreeMap - Sorted by Keys
```java
Map<String, Integer> treeMap = new TreeMap<>();
treeMap.put("C", 3);
treeMap.put("A", 1);
treeMap.put("B", 2);

System.out.println(treeMap);   // {A=1, B=2, C=3} (sorted by keys)
```

---

## 🎯 PART 5: REAL-WORLD PRACTICAL EXAMPLES

### Example 1: Student Management System
```java
class Student {
    String name;
    int rollNo;
    int marks;
    
    Student(String name, int rollNo, int marks) {
        this.name = name;
        this.rollNo = rollNo;
        this.marks = marks;
    }
}

// Store students
List<Student> students = new ArrayList<>();
students.add(new Student("Alice", 1, 85));
students.add(new Student("Bob", 2, 90));
students.add(new Student("Charlie", 3, 78));

// Find student by roll number
Map<Integer, Student> studentMap = new HashMap<>();
for (Student s : students) {
    studentMap.put(s.rollNo, s);
}

Student student = studentMap.get(2);
System.out.println(student.name); // Bob

// Get unique marks
Set<Integer> uniqueMarks = new HashSet<>();
for (Student s : students) {
    uniqueMarks.add(s.marks);
}
System.out.println(uniqueMarks); // [85, 90, 78]
```

### Example 2: Shopping Cart
```java
// Product name -> Quantity
Map<String, Integer> cart = new HashMap<>();

// Add items
cart.put("Laptop", 1);
cart.put("Mouse", 2);
cart.put("Keyboard", 1);

// Update quantity
cart.put("Mouse", cart.get("Mouse") + 1); // 3 mice

// Remove item
cart.remove("Keyboard");

// Check if item in cart
if (cart.containsKey("Laptop")) {
    System.out.println("Laptop is in cart");
}

// Total items
int totalItems = cart.values().stream().mapToInt(Integer::intValue).sum();
System.out.println("Total items: " + totalItems); // 4
```

### Example 3: Phone Book
```java
Map<String, String> phoneBook = new HashMap<>();

// Add contacts
phoneBook.put("Alice", "123-456-7890");
phoneBook.put("Bob", "234-567-8901");
phoneBook.put("Charlie", "345-678-9012");

// Search contact
String name = "Alice";
if (phoneBook.containsKey(name)) {
    System.out.println(name + ": " + phoneBook.get(name));
}

// Get all contacts
for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
    System.out.println(entry.getKey() + ": " + entry.getValue());
}
```

### Example 4: Word Counter
```java
String sentence = "java is great and java is fun";
String[] words = sentence.split(" ");

Map<String, Integer> wordCount = new HashMap<>();
for (String word : words) {
    wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
}

System.out.println(wordCount); 
// {java=2, is=2, great=1, and=1, fun=1}

// Find most frequent word
String mostFrequent = "";
int maxCount = 0;
for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
    if (entry.getValue() > maxCount) {
        maxCount = entry.getValue();
        mostFrequent = entry.getKey();
    }
}
System.out.println("Most frequent: " + mostFrequent); // java or is
```

### Example 5: Task Manager with Priority
```java
// Using TreeSet for automatic sorting
Set<String> tasks = new TreeSet<>();
tasks.add("3-Low: Clean room");
tasks.add("1-High: Submit assignment");
tasks.add("2-Medium: Buy groceries");

System.out.println("Tasks by priority:");
for (String task : tasks) {
    System.out.println(task);
}
// Output (sorted):
// 1-High: Submit assignment
// 2-Medium: Buy groceries
// 3-Low: Clean room
```

---

## 🎯 PART 6: COMMON OPERATIONS PRACTICE

### Practice 1: Find Duplicates
```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 2, 4, 5, 3, 6);
Set<Integer> seen = new HashSet<>();
Set<Integer> duplicates = new HashSet<>();

for (Integer num : numbers) {
    if (!seen.add(num)) {  // add returns false if element already exists
        duplicates.add(num);
    }
}

System.out.println("Duplicates: " + duplicates); // [2, 3]
```

### Practice 2: Two Sum Problem
```java
int[] nums = {2, 7, 11, 15};
int target = 9;

Map<Integer, Integer> map = new HashMap<>();
for (int i = 0; i < nums.length; i++) {
    int complement = target - nums[i];
    if (map.containsKey(complement)) {
        System.out.println("Indices: " + map.get(complement) + ", " + i);
        // Output: Indices: 0, 1
        break;
    }
    map.put(nums[i], i);
}
```

### Practice 3: Group Elements by Property
```java
List<String> words = Arrays.asList("apple", "banana", "apricot", "berry", "avocado");

// Group by first letter
Map<Character, List<String>> grouped = new HashMap<>();
for (String word : words) {
    char firstLetter = word.charAt(0);
    grouped.computeIfAbsent(firstLetter, k -> new ArrayList<>()).add(word);
}

System.out.println(grouped);
// {a=[apple, apricot, avocado], b=[banana, berry]}
```

### Practice 4: Merge Two Lists Without Duplicates
```java
List<Integer> list1 = Arrays.asList(1, 2, 3, 4);
List<Integer> list2 = Arrays.asList(3, 4, 5, 6);

Set<Integer> merged = new HashSet<>();
merged.addAll(list1);
merged.addAll(list2);

List<Integer> result = new ArrayList<>(merged);
System.out.println(result); // [1, 2, 3, 4, 5, 6]
```

### Practice 5: Check if Two Strings are Anagrams
```java
String s1 = "listen";
String s2 = "silent";

// Using HashMap
Map<Character, Integer> map1 = new HashMap<>();
Map<Character, Integer> map2 = new HashMap<>();

for (char c : s1.toCharArray()) {
    map1.put(c, map1.getOrDefault(c, 0) + 1);
}

for (char c : s2.toCharArray()) {
    map2.put(c, map2.getOrDefault(c, 0) + 1);
}

boolean isAnagram = map1.equals(map2);
System.out.println("Are anagrams: " + isAnagram); // true
```

---

## ✅ KEY TAKEAWAYS

1. **ArrayList**: Use for fast random access, dynamic arrays
2. **LinkedList**: Use for frequent insertions/deletions
3. **HashSet**: Use for unique elements, fast lookups
4. **HashMap**: Use for key-value pairs, fast lookups
5. **TreeSet/TreeMap**: Use when you need sorted order
6. **LinkedHashSet/LinkedHashMap**: Use when order matters

**Practice these examples daily to build strong fundamentals!**