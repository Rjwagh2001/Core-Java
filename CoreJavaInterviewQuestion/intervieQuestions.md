# Complete Core Java Interview Preparation Guide

## Learning Flow & Strategy

### Phase 1: Foundation (Week 1-2)
1. **Java Basics & JVM** → **Data Types & Variables** → **Control Flow & Arrays**
2. **OOPs Concepts** → **Access Modifiers** → **Exception Handling**

### Phase 2: Intermediate (Week 3-4)
3. **Strings** → **Collections Framework** → **Generics**
4. **Memory Management** → **File I/O**

### Phase 3: Advanced (Week 5-6)
5. **Multithreading** → **Java 8+ Features** → **Annotations & Reflection**
6. **Design Patterns**

---

## 1. Java Basics & JVM Internals

### Interview Questions:

**Q1: Explain JVM architecture and its components.**
**Answer:**
JVM consists of:
- **Class Loader Subsystem**: Loads, links, and initializes classes
  - Bootstrap ClassLoader (loads rt.jar)
  - Extension ClassLoader (loads ext directory)
  - Application ClassLoader (loads classpath)
- **Runtime Data Areas**:
  - Method Area (Metaspace in Java 8+)
  - Heap (Young + Old generation)
  - Stack (per thread)
  - PC Register, Native Method Stack
- **Execution Engine**: Interpreter + JIT Compiler + GC

**Q2: What's the difference between JDK, JRE, and JVM?**
**Answer:**
- **JVM**: Runtime environment that executes bytecode
- **JRE**: JVM + Libraries + Other files (runtime environment)
- **JDK**: JRE + Development tools (javac, debugger, etc.)

**Q3: How does JIT compiler work?**
**Answer:**
JIT (Just-In-Time) compiler:
- Compiles frequently used bytecode to native machine code
- Uses hotspot detection to identify frequently executed methods
- Applies optimizations like method inlining, loop unrolling
- Stores compiled code in code cache for reuse

**Q4: Explain different types of Garbage Collectors.**
**Answer:**
- **Serial GC**: Single-threaded, suitable for small applications
- **Parallel GC**: Multi-threaded, default for server applications
- **G1GC**: Low-latency collector for large heaps (>4GB)
- **ZGC/Shenandoah**: Ultra-low latency collectors for very large heaps

---

## 2. Data Types, Variables & Operators

### Interview Questions:

**Q5: What's the difference between primitive and wrapper classes?**
**Answer:**
```java
// Primitive: stored in stack, no methods, faster
int x = 10;

// Wrapper: object in heap, has methods, slower
Integer y = 10; // Autoboxing
int z = y;      // Unboxing
```
**Key Points:**
- Primitives: int, char, boolean, byte, short, long, float, double
- Wrappers: Integer, Character, Boolean, etc.
- Autoboxing can cause performance issues in loops

**Q6: What happens in integer overflow?**
**Answer:**
```java
int max = Integer.MAX_VALUE;
int overflow = max + 1; // Results in Integer.MIN_VALUE
// Java wraps around, no exception thrown
```

**Q7: Explain short-circuit evaluation.**
**Answer:**
```java
// && stops if first condition is false
if (obj != null && obj.method()) { }

// || stops if first condition is true  
if (flag || expensiveOperation()) { }
```

---

## 3. Control Flow & Arrays

### Interview Questions:

**Q8: What's new in Java 12+ switch expressions?**
**Answer:**
```java
// Old switch
String result;
switch (day) {
    case MONDAY: result = "Start of work"; break;
    default: result = "Other day";
}

// New switch expression
String result = switch (day) {
    case MONDAY -> "Start of work";
    case FRIDAY -> "TGIF";
    default -> "Other day";
};
```

**Q9: How are jagged arrays created?**
**Answer:**
```java
// Jagged array - arrays of different lengths
int[][] jaggedArray = new int[3][];
jaggedArray[0] = new int[2];
jaggedArray[1] = new int[4];
jaggedArray[2] = new int[3];
```

---

## 4. OOPs in Java (Deep)

### Interview Questions:

**Q10: Explain the difference between method overloading and overriding.**
**Answer:**
**Overloading (Compile-time polymorphism):**
```java
class Calculator {
    int add(int a, int b) { return a + b; }
    double add(double a, double b) { return a + b; }
    int add(int a, int b, int c) { return a + b + c; }
}
```

**Overriding (Runtime polymorphism):**
```java
class Animal {
    void makeSound() { System.out.println("Animal sound"); }
}
class Dog extends Animal {
    @Override
    void makeSound() { System.out.println("Bark"); }
}
```

**Q11: What's the difference between abstract class and interface?**
**Answer:**
| Abstract Class | Interface |
|---|---|
| Can have concrete methods | Only abstract methods (before Java 8) |
| Can have instance variables | Only static final variables |
| Single inheritance | Multiple inheritance |
| Can have constructors | Cannot have constructors |
| Access modifiers allowed | Methods are public by default |

**Q12: Explain equals() and hashCode() contract.**
**Answer:**
```java
public class Employee {
    private int id;
    private String name;
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Employee employee = (Employee) obj;
        return id == employee.id && Objects.equals(name, employee.name);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
```
**Contract Rules:**
1. If `equals()` returns true, `hashCode()` must return same value
2. If `hashCode()` is same, `equals()` may or may not be true
3. Consistent: multiple calls should return same result

**Q13: What's composition vs inheritance?**
**Answer:**
```java
// Inheritance (IS-A relationship)
class Car extends Vehicle { }

// Composition (HAS-A relationship)
class Car {
    private Engine engine;    // Car HAS-A Engine
    private Wheel[] wheels;   // Car HAS-A Wheels
}
```
**Prefer composition over inheritance** for flexibility and loose coupling.

---

## 5. Access Modifiers & Keywords

### Interview Questions:

**Q14: Explain all access modifiers with examples.**
**Answer:**
| Modifier | Same Class | Same Package | Subclass | Different Package |
|---|---|---|---|---|
| private | ✓ | ✗ | ✗ | ✗ |
| default | ✓ | ✓ | ✗ | ✗ |
| protected | ✓ | ✓ | ✓ | ✗ |
| public | ✓ | ✓ | ✓ | ✓ |

**Q15: What's the difference between final, finally, and finalize?**
**Answer:**
- **final**: Keyword for constants, preventing inheritance/override
- **finally**: Block that always executes after try-catch
- **finalize()**: Method called by GC before object destruction (deprecated)

**Q16: Explain volatile keyword.**
**Answer:**
```java
class SharedData {
    private volatile boolean flag = false;
    
    public void setFlag() {
        flag = true; // Immediately visible to all threads
    }
}
```
- Ensures visibility across threads
- Prevents instruction reordering
- No atomicity guarantee for compound operations

---

## 6. Exception Handling

### Interview Questions:

**Q17: What's the difference between checked and unchecked exceptions?**
**Answer:**
```java
// Checked Exception - must handle or declare
try {
    FileReader file = new FileReader("file.txt");
} catch (FileNotFoundException e) {
    e.printStackTrace();
}

// Unchecked Exception - runtime exceptions
int result = 10/0; // ArithmeticException
```

**Q18: Explain try-with-resources.**
**Answer:**
```java
// Automatic resource management
try (FileReader fr = new FileReader("file.txt");
     BufferedReader br = new BufferedReader(fr)) {
    return br.readLine();
} // Resources automatically closed
```

**Q19: What happens if exception occurs in finally block?**
**Answer:**
- Exception in finally block suppresses the original exception
- Use `getSuppressed()` to get original exceptions
- Avoid throwing exceptions from finally block

---

## 7. Strings & String Pool

### Interview Questions:

**Q20: Explain String immutability and String pool.**
**Answer:**
```java
String s1 = "Hello";        // Goes to String pool
String s2 = "Hello";        // Reuses from pool
String s3 = new String("Hello"); // Creates new object in heap

System.out.println(s1 == s2);     // true (same reference)
System.out.println(s1 == s3);     // false (different references)
System.out.println(s1.equals(s3)); // true (same content)

String s4 = s3.intern();    // Moves to pool
System.out.println(s1 == s4);     // true
```

**Q21: StringBuilder vs StringBuffer.**
**Answer:**
| StringBuilder | StringBuffer |
|---|---|
| Not synchronized | Synchronized |
| Faster | Slower |
| Single-threaded use | Multi-threaded use |
| Java 5+ | Java 1.0+ |

---

## 8. Collections Framework

### Interview Questions:

**Q22: Explain the Collections hierarchy.**
**Answer:**
```
Iterable
├── Collection
│   ├── List (ArrayList, LinkedList, Vector)
│   ├── Set (HashSet, LinkedHashSet, TreeSet)
│   └── Queue (PriorityQueue, ArrayDeque)
└── Map (HashMap, TreeMap, LinkedHashMap)
```

**Q23: How does HashMap work internally?**
**Answer:**
```java
// HashMap internal structure (Java 8+)
// Array of Nodes, each node can be:
// 1. Single node
// 2. Linked list (collision handling)
// 3. Red-Black tree (when list size > 8)

public V put(K key, V value) {
    int hash = key.hashCode();
    int index = hash & (capacity - 1);  // Find bucket
    // Handle collision with chaining or tree
}
```

**Key Points:**
- Initial capacity: 16, Load factor: 0.75
- Converts to TreeNode when chain length > 8
- Converts back to LinkedNode when < 6

**Q24: What's the difference between HashMap and ConcurrentHashMap?**
**Answer:**
| HashMap | ConcurrentHashMap |
|---|---|
| Not thread-safe | Thread-safe |
| Allows null keys/values | No null keys/values |
| Fail-fast iterator | Fail-safe iterator |
| Better performance | Segment locking (Java 7), CAS (Java 8+) |

**Q25: Explain Comparable vs Comparator.**
**Answer:**
```java
// Comparable - natural ordering
class Student implements Comparable<Student> {
    @Override
    public int compareTo(Student other) {
        return this.name.compareTo(other.name);
    }
}

// Comparator - custom ordering
Comparator<Student> byAge = (s1, s2) -> s1.age - s2.age;
Collections.sort(students, byAge);
```

**Q26: What are fail-fast and fail-safe iterators?**
**Answer:**
```java
// Fail-fast: throws ConcurrentModificationException
List<String> list = new ArrayList<>();
Iterator<String> it = list.iterator();
list.add("new"); // Modification
it.next(); // Throws exception

// Fail-safe: works on copy, no exception
ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
Iterator<String> it = map.keySet().iterator();
map.put("new", "value"); // No exception
```

---

## 9. Generics

### Interview Questions:

**Q27: What is type erasure in generics?**
**Answer:**
```java
// Compile time
List<String> strings = new ArrayList<String>();

// Runtime (after type erasure)
List strings = new ArrayList();
```
- Generics are compile-time feature
- Type information is erased at runtime
- Ensures backward compatibility

**Q28: Explain bounded types and wildcards.**
**Answer:**
```java
// Bounded types
class NumberContainer<T extends Number> {
    T value;
}

// Wildcards
List<? extends Number> numbers;    // PECS - Producer extends
List<? super Integer> integers;    // PECS - Consumer super

// PECS Principle:
// Producer Extends, Consumer Super
```

---

## 10. Multithreading & Concurrency

### Interview Questions:

**Q29: What's the difference between Runnable and Thread?**
**Answer:**
```java
// Extending Thread
class MyThread extends Thread {
    public void run() { /* implementation */ }
}

// Implementing Runnable (preferred)
class MyRunnable implements Runnable {
    public void run() { /* implementation */ }
}
Thread thread = new Thread(new MyRunnable());
```
**Prefer Runnable:** Allows multiple inheritance, better design

**Q30: Explain thread lifecycle.**
**Answer:**
```
NEW → RUNNABLE → BLOCKED/WAITING/TIMED_WAITING → TERMINATED
```
- **NEW**: Thread created but not started
- **RUNNABLE**: Executing or ready to execute
- **BLOCKED**: Waiting for monitor lock
- **WAITING**: Waiting indefinitely (wait(), join())
- **TIMED_WAITING**: Waiting for specified time (sleep(), wait(timeout))
- **TERMINATED**: Completed execution

**Q31: What's the difference between synchronized method and block?**
**Answer:**
```java
// Synchronized method - locks entire method
public synchronized void method1() { }

// Synchronized block - locks specific section
public void method2() {
    synchronized(this) {
        // critical section
    }
}

// Class level synchronization
synchronized(MyClass.class) { }
```

**Q32: Explain producer-consumer problem.**
**Answer:**
```java
class ProducerConsumer {
    private Queue<Integer> queue = new LinkedList<>();
    private final int CAPACITY = 5;
    
    public void produce() throws InterruptedException {
        int value = 0;
        while (true) {
            synchronized (this) {
                while (queue.size() == CAPACITY) {
                    wait(); // Wait if queue is full
                }
                queue.add(value++);
                notify(); // Notify consumer
            }
        }
    }
    
    public void consume() throws InterruptedException {
        while (true) {
            synchronized (this) {
                while (queue.isEmpty()) {
                    wait(); // Wait if queue is empty
                }
                int value = queue.poll();
                notify(); // Notify producer
            }
        }
    }
}
```

**Q33: What's deadlock and how to prevent it?**
**Answer:**
**Deadlock:** Two or more threads waiting for each other indefinitely
```java
// Deadlock scenario
Thread 1: locks A, waits for B
Thread 2: locks B, waits for A

// Prevention strategies:
// 1. Lock ordering
// 2. Timeout on lock attempts
// 3. Deadlock detection algorithms
```

---

## 11. Java 8+ Functional Features

### Interview Questions:

**Q34: Explain functional interfaces with examples.**
**Answer:**
```java
// Built-in functional interfaces
Predicate<String> isEmpty = String::isEmpty;
Function<String, Integer> length = String::length;
Consumer<String> print = System.out::println;
Supplier<String> supplier = () -> "Hello";

// Custom functional interface
@FunctionalInterface
interface Calculator {
    int calculate(int a, int b);
    
    // Default method allowed
    default void print() { System.out.println("Calculating..."); }
}

Calculator add = (a, b) -> a + b;
Calculator multiply = (a, b) -> a * b;
```

**Q35: Explain method references.**
**Answer:**
```java
// Types of method references
// 1. Static method reference
Function<String, Integer> parseInt = Integer::parseInt;

// 2. Instance method reference
String str = "hello";
Supplier<String> toUpper = str::toUpperCase;

// 3. Instance method reference of arbitrary object
Function<String, String> toUpper2 = String::toUpperCase;

// 4. Constructor reference
Supplier<ArrayList> listSupplier = ArrayList::new;
```

**Q36: Explain Stream API operations.**
**Answer:**
```java
List<String> names = Arrays.asList("John", "Jane", "Jack", "Jill");

// Stream operations
List<String> result = names.stream()
    .filter(name -> name.startsWith("J"))     // Intermediate
    .map(String::toUpperCase)                 // Intermediate
    .sorted()                                 // Intermediate
    .collect(Collectors.toList());            // Terminal

// Key operations:
// Intermediate: filter, map, flatMap, sorted, distinct
// Terminal: collect, forEach, reduce, count, anyMatch
```

**Q37: What's the difference between map() and flatMap()?**
**Answer:**
```java
List<List<String>> nested = Arrays.asList(
    Arrays.asList("a", "b"),
    Arrays.asList("c", "d")
);

// map: Stream<List<String>> -> Stream<Stream<String>>
nested.stream().map(list -> list.stream());

// flatMap: Stream<List<String>> -> Stream<String>
List<String> flattened = nested.stream()
    .flatMap(list -> list.stream())
    .collect(Collectors.toList()); // ["a", "b", "c", "d"]
```

---

## 12. Java Memory Management

### Interview Questions:

**Q38: Explain Java memory structure.**
**Answer:**
```
HEAP MEMORY:
├── Young Generation
│   ├── Eden Space
│   ├── Survivor Space 0 (S0)
│   └── Survivor Space 1 (S1)
└── Old Generation (Tenured Space)

NON-HEAP MEMORY:
├── Method Area (Metaspace in Java 8+)
├── Code Cache
└── Compressed Class Space
```

**Q39: What are different types of references?**
**Answer:**
```java
// Strong Reference (default)
Object obj = new Object(); // GC won't collect

// Weak Reference
WeakReference<Object> weakRef = new WeakReference<>(obj);
obj = null; // Now eligible for GC

// Soft Reference (memory-sensitive)
SoftReference<Object> softRef = new SoftReference<>(obj);

// Phantom Reference (cleanup)
PhantomReference<Object> phantomRef = new PhantomReference<>(obj, queue);
```

**Q40: What causes memory leaks in Java?**
**Answer:**
Common causes:
1. **Unclosed resources** (files, connections)
2. **Static collections** holding references
3. **Inner classes** holding outer class reference
4. **Listeners** not removed
5. **ThreadLocal** not cleaned up

---

## 13. File I/O & NIO

### Interview Questions:

**Q41: What's the difference between IO and NIO?**
**Answer:**
| IO (Java 1.0) | NIO (Java 1.4) | NIO.2 (Java 7) |
|---|---|---|
| Blocking | Non-blocking | Async |
| Stream-oriented | Buffer-oriented | Path-based |
| No selectors | Selectors | File watchers |

```java
// Traditional IO
FileReader reader = new FileReader("file.txt");

// NIO
Path path = Paths.get("file.txt");
List<String> lines = Files.readAllLines(path);

// NIO.2 - Watch service
WatchService watchService = FileSystems.getDefault().newWatchService();
```

**Q42: Explain serialization and its requirements.**
**Answer:**
```java
class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private transient String password; // Not serialized
    
    // No-arg constructor for deserialization
    public Employee() {}
}

// Serialization
ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("emp.ser"));
out.writeObject(employee);

// Deserialization  
ObjectInputStream in = new ObjectInputStream(new FileInputStream("emp.ser"));
Employee emp = (Employee) in.readObject();
```

---

## 14. Java Annotations & Reflection

### Interview Questions:

**Q43: Explain built-in annotations.**
**Answer:**
```java
@Override          // Method overrides parent method
@Deprecated        // Marks as deprecated
@SuppressWarnings("unchecked")  // Suppress compiler warnings
@FunctionalInterface  // Marks as functional interface
@SafeVarargs       // Suppress varargs warnings
```

**Q44: How to create custom annotations?**
**Answer:**
```java
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface LogExecutionTime {
    String value() default "";
}

// Usage
@LogExecutionTime("Database operation")
public void saveData() { }

// Processing with reflection
Method method = obj.getClass().getMethod("saveData");
if (method.isAnnotationPresent(LogExecutionTime.class)) {
    LogExecutionTime annotation = method.getAnnotation(LogExecutionTime.class);
    System.out.println(annotation.value());
}
```

**Q45: Explain Reflection API.**
**Answer:**
```java
Class<?> clazz = Employee.class;

// Get constructors
Constructor<?>[] constructors = clazz.getConstructors();

// Get methods
Method[] methods = clazz.getMethods();
Method method = clazz.getMethod("getName");

// Get fields
Field[] fields = clazz.getDeclaredFields();
Field field = clazz.getDeclaredField("name");
field.setAccessible(true); // Access private fields

// Create instance and invoke
Object obj = clazz.newInstance();
Object result = method.invoke(obj);
```

---

## 15. Design Patterns (Core)

### Interview Questions:

**Q46: Implement thread-safe Singleton.**
**Answer:**
```java
// Double-checked locking
public class Singleton {
    private static volatile Singleton instance;
    
    private Singleton() {}
    
    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}

// Enum Singleton (Best approach)
public enum SingletonEnum {
    INSTANCE;
    
    public void doSomething() {
        // business logic
    }
}
```

**Q47: Explain Factory pattern.**
**Answer:**
```java
interface Shape {
    void draw();
}

class Circle implements Shape {
    public void draw() { System.out.println("Drawing Circle"); }
}

class Rectangle implements Shape {
    public void draw() { System.out.println("Drawing Rectangle"); }
}

class ShapeFactory {
    public static Shape createShape(String type) {
        switch (type.toLowerCase()) {
            case "circle": return new Circle();
            case "rectangle": return new Rectangle();
            default: throw new IllegalArgumentException("Unknown shape");
        }
    }
}
```

**Q48: Implement Observer pattern.**
**Answer:**
```java
interface Observer {
    void update(String message);
}

class Subject {
    private List<Observer> observers = new ArrayList<>();
    
    public void addObserver(Observer observer) {
        observers.add(observer);
    }
    
    public void notifyObservers(String message) {
        observers.forEach(observer -> observer.update(message));
    }
}

class NewsAgency extends Subject {
    public void setNews(String news) {
        notifyObservers(news);
    }
}
```

---

## Top 10 Product-Based Companies Interview Questions

### **Google**
1. Implement LRU Cache using HashMap and Doubly Linked List
2. Design a thread-safe counter without using synchronized
3. Explain ConcurrentHashMap internal implementation
4. Implement custom ArrayList with generic support
5. Producer-Consumer with BlockingQueue

### **Amazon**
1. Implement Singleton with lazy initialization
2. Difference between StringBuilder and StringBuffer with examples
3. How does HashMap handle collisions?
4. Implement custom equals() and hashCode()
5. Exception handling best practices

### **Microsoft**
1. Multithreading: implement thread pool from scratch
2. Design patterns: Factory vs Abstract Factory
3. Java Memory Model and happens-before relationship
4. Stream API: groupBy and partitioning operations
5. Reflection: create object without using new keyword

### **Facebook (Meta)**
1. Custom annotation processing at runtime
2. Weak references and memory leaks prevention
3. Fork-Join framework implementation
4. Functional interfaces and lambda expressions
5. CompletableFuture vs Future

### **Apple**
1. Implement immutable class with builder pattern
2. Deadlock detection and prevention strategies
3. Serialization: writeObject and readObject methods
4. NIO: implement file watcher service
5. Garbage collection tuning parameters

### **Netflix**
1. Reactive programming with CompletableFuture
2. Thread-safe collections comparison
3. JVM tuning for microservices
4. Circuit breaker pattern implementation
5. Memory profiling and optimization

### **Uber**
1. Lock-free data structures using AtomicReference
2. Custom thread pool implementation
3. Event-driven architecture with Observer pattern
4. Time complexity of Collection operations
5. JIT compiler optimizations

### **Spotify**
1. Parallel stream processing limitations
2. Method references vs lambda expressions performance
3. Custom ClassLoader implementation
4. Annotation-based configuration processing
5. Memory-mapped files for large data processing

### **LinkedIn**
1. Implement thread-safe cache with TTL
2. Decorator pattern for logging functionality
3. Volatile vs Atomic variables
4. Custom serialization with versioning
5. Performance implications of boxing/unboxing

### **Twitter**
1. Implement rate limiter using Sliding Window
2. Phantom references for resource cleanup
3. Method overloading resolution at compile time
4. Stack vs Heap memory allocation scenarios
5. Executor service lifecycle management

---

## Additional High-Frequency Questions

### **Core Java Fundamentals**
1. Why is String immutable in Java?
2. Can we override static methods?
3. What happens if we don't override hashCode() when overriding equals()?
4. Difference between final, finally, and finalize
5. Why char array is preferred over String for passwords?

### **Collections Deep Dive**
1. Internal working of TreeMap
2. Why insertion order is maintained in LinkedHashMap?
3. When to use Vector over ArrayList?
4. CopyOnWriteArrayList use cases
5. NavigableSet and NavigableMap features

### **Concurrency Advanced**
1. CountDownLatch vs CyclicBarrier vs Semaphore
2. ForkJoinPool work-stealing algorithm
3. ReadWriteLock scenarios
4. ThreadLocal memory leaks
5. Compare and Swap (CAS) operations

### **JVM and Performance**
1. Method area vs Heap memory
2. When does OutOfMemoryError occur?
3. Difference between stack overflow and heap overflow
4. Escape analysis in JIT compilation
5. G1GC vs ZGC characteristics

### **Modern Java Features**
1. Record classes (Java 14+)
2. Switch expressions pattern matching
3. Text blocks usage
4. var keyword limitations
5. Module system (JPMS) basics

---

## Study Tips for Success

### **Week-wise Plan:**
- **Week 1-2:** Master OOPs, Collections, and Exception Handling
- **Week 3-4:** Deep dive into Multithreading and Concurrency
- **Week 5:** Java 8+ features and Streams
- **Week 6:** Design Patterns and System Design basics

### **Practice Strategy:**
1. **Code daily:** Implement data structures from scratch
2. **Mock interviews:** Practice explaining concepts clearly
3. **Whiteboard coding:** Practice without IDE
4. **Performance analysis:** Understand Big O complexity
5. **Stay updated:** Follow Java release notes

### **Red Flags to Avoid:**
- Don't memorize code; understand concepts
- Practice explaining complex topics simply
- Always discuss trade-offs and alternatives
- Be honest about what you don't know
- Ask clarifying questions before solving problems

This comprehensive guide covers all major Java concepts with interview-focused explanations and real-world examples. Practice these questions regularly and you'll be well-prepared for any Java interview!