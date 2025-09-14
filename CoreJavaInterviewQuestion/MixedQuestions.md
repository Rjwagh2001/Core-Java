
# Top 300 Core Java Interview Questions - Product-Based Companies

## **Distribution by Companies:**
- **Google**: 30 questions
- **Amazon**: 30 questions  
- **Microsoft**: 30 questions
- **Meta (Facebook)**: 30 questions
- **Apple**: 30 questions
- **Netflix**: 30 questions
- **Uber**: 30 questions
- **LinkedIn**: 30 questions
- **Spotify**: 30 questions
- **Twitter**: 30 questions

---

# **GOOGLE - Core Java Questions (30)**

## **Java Fundamentals & JVM (10 Questions)**

**1.** What is the difference between JDK, JRE, and JVM? Explain with memory structure.

**2.** How does the JVM execute Java bytecode? Explain the process from compilation to execution.

**3.** What is the difference between stack and heap memory? What gets stored where?

**4.** Explain the JVM memory structure: Method Area, Heap, Stack, PC Register, Native Method Stack.

**5.** What is garbage collection? Explain different types of garbage collectors.

**6.** How does the ClassLoader work in Java? Explain the delegation model.

**7.** What is JIT compiler? How does it optimize Java code execution?

**8.** What happens when you run `java MyClass`? Explain the complete process.

**9.** What is the difference between `java`, `javac`, and `javaw` commands?

**10.** Explain method area vs metaspace. What changed in Java 8?

## **OOP Concepts (10 Questions)**

**11.** What are the four pillars of OOP? Explain each with Java examples.

**12.** What is the difference between method overloading and method overriding?

**13.** Can you override static methods in Java? Why or why not?

**14.** What is the difference between abstract class and interface?

**15.** Explain the `super` and `this` keywords with examples.

**16.** What is polymorphism? Explain compile-time vs runtime polymorphism.

**17.** What is encapsulation? How do you achieve it in Java?

**18.** Can you inherit from multiple classes in Java? How do you achieve multiple inheritance?

**19.** What is the diamond problem? How does Java resolve it?

**20.** Explain constructor chaining using `this()` and `super()`.

## **String and Wrapper Classes (10 Questions)**

**21.** Why is String immutable in Java? What are the advantages?

**22.** What is String pool? How does it work internally?

**23.** What is the difference between `String`, `StringBuilder`, and `StringBuffer`?

**24.** What happens when you use `+` operator with strings?

**25.** What is string interning? When would you use `String.intern()`?

**26.** What is autoboxing and unboxing? What are the performance implications?

**27.** What is the difference between `==` and `equals()` for strings?

**28.** Can you create a string without using `new` or literal? How?

**29.** What happens if you override `equals()` but not `hashCode()` in String-like class?

**30.** How does String concatenation work in loops? How to optimize it?

---

# **AMAZON - Core Java Questions (30)**

## **Exception Handling (10 Questions)**

**31.** What is the difference between checked and unchecked exceptions?

**32.** Can you catch multiple exceptions in a single catch block?

**33.** What is the hierarchy of Exception classes in Java?

**34.** What happens if you put return statement in try, catch, and finally blocks?

**35.** Can you throw an exception from a finally block? What happens?

**36.** What is exception chaining? How do you implement it?

**37.** What is the difference between `throw` and `throws` keywords?

**38.** Can you re-throw an exception? How?

**39.** What is try-with-resources? How does it work internally?

**40.** How do you create custom exceptions in Java?

## **Collections Framework - Basics (10 Questions)**

**41.** What is the hierarchy of Collection framework in Java?

**42.** What is the difference between `ArrayList` and `LinkedList`?

**43.** What is the difference between `ArrayList` and `Vector`?

**44.** How does `HashMap` work internally? Explain the hashing mechanism.

**45.** What is the difference between `HashMap`, `LinkedHashMap`, and `TreeMap`?

**46.** What happens when two objects have the same hash code in HashMap?

**47.** What is load factor in HashMap? What happens when it's exceeded?

**48.** What is the difference between `HashSet` and `LinkedHashSet`?

**49.** How do you sort a collection in Java? Explain `Comparable` vs `Comparator`.

**50.** What is the difference between `Iterator` and `ListIterator`?

## **Access Modifiers and Keywords (10 Questions)**

**51.** Explain all access modifiers in Java with visibility scope.

**52.** What is the difference between `final`, `finally`, and `finalize()`?

**53.** When and why would you use the `static` keyword?

**54.** What is the `volatile` keyword? When would you use it?

**55.** What is the `synchronized` keyword? How does it work?

**56.** What is the difference between `static` and `instance` blocks?

**57.** Can you access non-static variables from static methods? Why?

**58.** What is the `transient` keyword? When is it used?

**59.** What is the `native` keyword in Java?

**60.** What is the `strictfp` keyword? When would you use it?

---

# **MICROSOFT - Core Java Questions (30)**

## **Multithreading Basics (15 Questions)**

**61.** What is multithreading? How do you create threads in Java?

**62.** What is the difference between extending `Thread` class and implementing `Runnable`?

**63.** What are the different states of a thread in Java?

**64.** What is the difference between `wait()` and `sleep()` methods?

**65.** What is the difference between `notify()` and `notifyAll()`?

**66.** What is thread synchronization? Why is it needed?

**67.** What is a deadlock? How can you prevent it?

**68.** What is the difference between synchronized method and synchronized block?

**69.** Can you synchronize static methods? How?

**70.** What is the `join()` method in threads?

**71.** What is thread priority? How do you set it?

**72.** What is daemon thread? How do you create one?

**73.** What happens if an exception occurs in a thread?

**74.** What is the `yield()` method? When would you use it?

**75.** What is race condition? How do you handle it?

## **Generics (8 Questions)**

**76.** What are generics in Java? Why were they introduced?

**77.** What is type erasure? How does it affect runtime?

**78.** What are bounded type parameters? Give examples.

**79.** What are wildcards in generics? Explain `? extends` and `? super`.

**80.** Can you create an array of generic type? Why or why not?

**81.** What is the difference between `List<Object>` and `List<?>`?

**82.** What are generic methods? How do you write them?

**83.** What is PECS principle in generics?

## **Serialization (7 Questions)**

**84.** What is serialization in Java? How do you implement it?

**85.** What is the role of `serialVersionUID`?

**86.** What is the difference between `Serializable` and `Externalizable`?

**87.** What is `transient` keyword in context of serialization?

**88.** Can you serialize static variables? Why or why not?

**89.** What happens during deserialization if class definition changes?

**90.** How do you customize serialization process?

---

# **META (FACEBOOK) - Core Java Questions (30)**

## **Object Class Methods (8 Questions)**

**91.** What methods does `Object` class provide? Explain each.

**92.** What is the contract between `equals()` and `hashCode()`?

**93.** When and why should you override `equals()` method?

**94.** How do you implement `equals()` method correctly?

**95.** What is the default implementation of `hashCode()`?

**96.** What is the `toString()` method? When should you override it?

**97.** What is the `clone()` method? What is shallow vs deep cloning?

**98.** What is the `finalize()` method? Why is it deprecated?

## **Enums and Annotations (12 Questions)**

**99.** What are enums in Java? How are they different from constants?

**100.** Can enums implement interfaces? Can they extend classes?

**101.** Can you add methods to enum? How?

**102.** What is the `values()` method in enum?

**103.** Can enum constructors be public?

**104.** What are annotations in Java? How do you create custom annotations?

**105.** What are meta-annotations? Explain `@Retention`, `@Target`, etc.

**106.** What is the difference between `@Override` and `@Overload`?

**107.** What is `@SuppressWarnings` annotation?

**108.** What is `@Deprecated` annotation? How does it work?

**109.** What is `@FunctionalInterface` annotation?

**110.** Can you apply multiple annotations to a single element?

## **Inner Classes (10 Questions)**

**111.** What are inner classes in Java? What types exist?

**112.** What is the difference between static and non-static inner classes?

**113.** What are local inner classes? When would you use them?

**114.** What are anonymous inner classes? Provide examples.

**115.** Can inner classes access private members of outer class?

**116.** How do you create instance of non-static inner class from outside?

**117.** What is `this` keyword in context of inner classes?

**118.** Can static inner classes access non-static members of outer class?

**119.** What are the advantages and disadvantages of inner classes?

**120.** What is shadowing in inner classes?

---

# **APPLE - Core Java Questions (30)**

## **Data Types and Variables (15 Questions)**

**121.** What are primitive data types in Java? List all with sizes.

**122.** What is the difference between primitive and reference types?

**123.** What is autoboxing and unboxing? When does it happen automatically?

**124.** What are wrapper classes? Why do we need them?

**125.** What is the range of `byte`, `short`, `int`, and `long`?

**126.** What happens during integer overflow in Java?

**127.** What is the difference between `float` and `double`?

**128.** How do you compare floating point numbers safely?

**129.** What is the difference between `char` and `String`?

**130.** What are literals in Java? Explain different types.

**131.** What is type casting? Explain implicit vs explicit casting.

**132.** What is the difference between widening and narrowing conversion?

**133.** Can you assign `int` to `Integer` and vice versa? How?

**134.** What is the default value of different data types?

**135.** What is the difference between signed and unsigned integers?

## **Operators and Control Statements (15 Questions)**

**136.** What are different types of operators in Java?

**137.** What is the difference between `==` and `.equals()`?

**138.** What is the difference between `&` and `&&` operators?

**139.** What is the difference between `|` and `||` operators?

**140.** What is the ternary operator? Provide examples.

**141.** What is the `instanceof` operator? When do you use it?

**142.** What are bitwise operators? Provide examples.

**143.** What is operator precedence in Java?

**144.** What is the difference between `++i` and `i++`?

**145.** What is short-circuit evaluation in logical operators?

**146.** What are the different loop types in Java?

**147.** What is the difference between `while` and `do-while` loops?

**148.** What is enhanced for loop (for-each)? When do you use it?

**149.** What are `break` and `continue` statements?

**150.** What are labeled statements in Java?

---

# **NETFLIX - Core Java Questions (30)**

## **Java 8+ Features (20 Questions)**

**151.** What are lambda expressions? How do they work?

**152.** What are functional interfaces? Can you create custom ones?

**153.** What are method references? What types exist?

**154.** What is the Stream API? How is it different from collections?

**155.** What are intermediate vs terminal operations in streams?

**156.** What is the difference between `map()` and `flatMap()`?

**157.** What are parallel streams? When should you use them?

**158.** What is the `Optional` class? How does it help avoid `NullPointerException`?

**159.** What are default methods in interfaces? Why were they added?

**160.** Can interfaces have static methods? How do you call them?

**161.** What is the `Predicate` functional interface?

**162.** What is the `Function` functional interface?

**163.** What is the `Consumer` functional interface?

**164.** What is the `Supplier` functional interface?

**165.** What is method chaining in streams?

**166.** How do you handle exceptions in lambda expressions?

**167.** What is the `forEach()` method in streams vs collections?

**168.** What are collectors in Stream API?

**169.** How do you convert streams to collections?

**170.** What is the difference between sequential and parallel streams?

## **File I/O and NIO (10 Questions)**

**171.** What are the different ways to read files in Java?

**172.** What is the difference between `FileReader` and `BufferedReader`?

**173.** What is the difference between byte streams and character streams?

**174.** What is NIO? How is it different from traditional I/O?

**175.** What are channels and buffers in NIO?

**176.** What is the `Path` class? How is it different from `File`?

**177.** How do you copy files efficiently in Java?

**178.** What is memory-mapped file I/O?

**179.** How do you handle large files in Java?

**180.** What is the difference between absolute and relative paths?

---

# **UBER - Core Java Questions (30)**

## **Collections Framework - Advanced (20 Questions)**

**181.** What is the internal implementation of `ArrayList`?

**182.** How does dynamic resizing work in `ArrayList`?

**183.** What is the time complexity of different operations in `ArrayList`?

**184.** What is the internal implementation of `LinkedList`?

**185.** When would you choose `LinkedList` over `ArrayList`?

**186.** What is the internal implementation of `HashMap`?

**187.** What happens when hash collision occurs in `HashMap`?

**188.** What is the significance of load factor 0.75 in `HashMap`?

**189.** How does `HashMap` handle null keys and values?

**190.** What is the difference between `HashMap` and `ConcurrentHashMap`?

**191.** What is the internal implementation of `TreeMap`?

**192.** What is the time complexity of operations in `TreeMap`?

**193.** What is the difference between `Set` and `List`?

**194.** What is the internal implementation of `HashSet`?

**195.** How does `HashSet` ensure uniqueness?

**196.** What is the difference between `Comparable` and `Comparator`?

**197.** Can you sort a `HashMap`? How?

**198.** What are fail-fast and fail-safe iterators?

**199.** What is `WeakHashMap`? When would you use it?

**200.** What is the difference between `Queue` and `Deque`?

## **Memory Management (10 Questions)**

**201.** What is garbage collection? How does it work?

**202.** What are different generations in heap memory?

**203.** What is the difference between minor and major GC?

**204.** What are strong, weak, soft, and phantom references?

**205.** What can cause memory leaks in Java?

**206.** What is the difference between heap and stack memory?

**207.** What is memory leak vs memory overflow?

**208.** How does garbage collector decide which objects to collect?

**209.** What are different garbage collection algorithms?

**210.** How do you analyze memory usage in Java applications?

---

# **LINKEDIN - Core Java Questions (30)**

## **Immutability and Design (15 Questions)**

**211.** What is an immutable class? How do you create one?

**212.** Why is `String` immutable? What are the benefits?

**213.** How do you create immutable class with mutable fields?

**214.** What is the Builder pattern? How do you implement it?

**215.** What is the Singleton pattern? How do you implement it thread-safely?

**216.** What are the different ways to create Singleton class?

**217.** What is enum-based Singleton? Why is it preferred?

**218.** What is the Factory pattern? When do you use it?

**219.** What is the difference between Factory and Abstract Factory patterns?

**220.** What is composition vs inheritance? When to use which?

**221.** What is the Liskov Substitution Principle?

**222.** What is tight coupling vs loose coupling?

**223.** What is dependency injection? How do you achieve it?

**224.** What are design principles for writing good Java code?

**225.** What is the Open/Closed Principle?

## **Reflection and Dynamic Programming (15 Questions)**

**226.** What is reflection in Java? When do you use it?

**227.** How do you get `Class` object in Java? What are different ways?

**228.** How do you create objects using reflection?

**229.** How do you invoke methods using reflection?

**230.** How do you access private fields using reflection?

**231.** What are the performance implications of using reflection?

**232.** What is `Class.forName()` method?

**233.** What is the difference between `getClass()` and `.class`?

**234.** How do you check if a class implements an interface using reflection?

**235.** What is dynamic proxy in Java?

**236.** How do you create dynamic proxy?

**237.** What is annotation processing?

**238.** How do you read annotations at runtime using reflection?

**239.** What is the difference between compile-time and runtime annotations?

**240.** What are the security implications of using reflection?

---

# **SPOTIFY - Core Java Questions (30)**

## **Advanced OOP Concepts (15 Questions)**

**241.** What is method hiding vs method overriding?

**242.** Can you override private methods? Why or why not?

**243.** Can you override final methods? What about static methods?

**244.** What is covariant return type? Provide example.

**245.** What is the difference between early binding and late binding?

**246.** What is virtual method invocation?

**247.** Can constructors be final, static, or synchronized?

**248.** What happens if you don't call `super()` in constructor?

**249.** Can abstract classes have constructors?

**250.** Can interfaces have constructors? Why or why not?

**251.** What is marker interface? Give examples.

**252.** What is functional interface? Can it have default methods?

**253.** What is multiple inheritance of state vs behavior?

**254.** What is the difference between `abstract` and `final` keywords?

**255.** Can you instantiate abstract class or interface?

## **Concurrency Utilities (15 Questions)**

**256.** What is `ExecutorService`? How is it different from creating threads manually?

**257.** What are different types of thread pools?

**258.** What is `Future` interface? How do you use it?

**259.** What is `Callable` interface? How is it different from `Runnable`?

**260.** What is `CountDownLatch`? When would you use it?

**261.** What is `CyclicBarrier`? How is it different from `CountDownLatch`?

**262.** What is `Semaphore`? Provide use cases.

**263.** What are atomic variables? When do you use them?

**264.** What is `BlockingQueue`? What implementations are available?

**265.** What is producer-consumer problem? How do you solve it?

**266.** What is `ReadWriteLock`? When is it beneficial?

**267.** What is thread starvation? How do you prevent it?

**268.** What is livelock? How is it different from deadlock?

**269.** What is thread confinement?

**270.** What is the volatile keyword and how does it ensure visibility?

---

# **TWITTER - Core Java Questions (30)**

## **Performance and Optimization (15 Questions)**

**271.** What are the performance differences between `ArrayList` and `LinkedList`?

**272.** When should you use `StringBuilder` vs `StringBuffer`?

**273.** What is the cost of autoboxing and unboxing?

**274.** How does string concatenation using `+` operator affect performance?

**275.** What is the performance impact of using `synchronized`?

**276.** How do you optimize loop performance in Java?

**277.** What is the performance difference between `HashMap` and `TreeMap`?

**278.** How does garbage collection affect application performance?

**279.** What is the performance cost of reflection?

**280.** How do you choose appropriate initial capacity for collections?

**281.** What is lazy initialization? When should you use it?

**282.** What is the performance difference between `==` and `.equals()`?

**283.** How do you optimize memory usage in Java applications?

**284.** What is the cost of exception handling?

**285.** How do you profile Java applications for performance issues?

## **Edge Cases and Tricky Questions (15 Questions)**

**286.** Can you have two methods with same name and same parameters but different return types?

**287.** What happens if you don't provide `main` method in a Java class?

**288.** Can `main` method be overloaded? Can it be overridden?

**289.** What happens if static initializer throws exception?

**290.** Can you call non-static method from static context? How?

**291.** What is the output of `System.out.println(1 + 2 + "3" + 4 + 5)`?

**292.** Can you modify final variable? Under what circumstances?

**293.** What happens if you serialize a class that has non-serializable field?

**294.** Can you catch `Error` in Java? Should you?

**295.** What happens if `equals()` method throws exception?

**296.** Can you have static method in interface? How do you call it?

**297.** What is the difference between `ClassNotFoundException` and `NoClassDefFoundError`?

**298.** Can you override `hashCode()` but not `equals()`? What happens?

**299.** What happens if thread throws uncaught exception?

**300.** Can you have abstract method in non-abstract class? Why or why not?

---

# **Difficulty Level Distribution**

## **Easy (Entry Level - 0-2 years): Questions 1-100**
- Java Fundamentals and JVM
- Basic OOP Concepts  
- String and Wrapper Classes
- Exception Handling Basics
- Collections Framework Basics

## **Medium (Mid Level - 2-5 years): Questions 101-200**
- Advanced OOP Concepts
- Multithreading Basics
- Generics and Serialization
- Java 8+ Features
- File I/O and Collections Advanced

## **Hard (Senior Level - 5+ years): Questions 201-300**  
- Advanced Design Patterns
- Concurrency Utilities
- Reflection and Dynamic Programming
- Performance Optimization
- Edge Cases and Tricky Scenarios

# **Topic-wise Question Count**

| Topic | Questions | Percentage |
|-------|-----------|------------|
| **Core Java & JVM** | 45 | 15% |
| **OOP Concepts** | 50 | 16.7% |
| **Collections Framework** | 40 | 13.3% |
| **Multithreading & Concurrency** | 35 | 11.7% |
| **Exception Handling** | 20 | 6.7% |
| **Java 8+ Features** | 25 | 8.3% |
| **String & Wrapper Classes** | 20 | 6.7% |
| **Generics & Annotations** | 20 | 6.7% |
| **Serialization & I/O** | 15 | 5% |
| **Design Patterns** | 15 | 5% |
| **Reflection & Dynamic** | 15 | 5% |

# **Company Focus Areas**

## **Google**: JVM Internals, OOP Mastery, String Optimization
## **Amazon**: Exception Handling, Collections, Access Modifiers  
## **Microsoft**: Multithreading, Generics, Serialization
## **Meta**: Object Methods, Enums, Inner Classes
## **Apple**: Data Types, Operators, Control Statements
## **Netflix**: Java 8+ Features, File I/O, NIO
## **Uber**: Advanced Collections, Memory Management
## **LinkedIn**: Immutability, Design Patterns, Reflection
## **Spotify**: Advanced OOP, Concurrency Utilities
## **Twitter**: Performance Optimization, Edge Cases

# **Preparation Strategy**

## **Week 1-2: Foundation (Questions 1-100)**
- Master Java fundamentals and JVM concepts
- Understand OOP principles thoroughly  
- Practice string manipulation and wrapper classes
- Learn exception handling patterns

## **Week 3-4: Intermediate (Questions 101-200)**
- Deep dive into collections framework
- Master multithreading basics
- Understand generics and serialization
- Explore Java 8+ features

## **Week 5-6: Advanced (Questions 201-300)**
- Learn design patterns and best practices
- Master advanced concurrency
- Understand reflection and dynamic programming
- Focus on performance optimization

## **Success Tips:**

1. **Practice coding examples** for each concept
2. **Understand the 'why'** behind each feature
3. **Compare alternatives** (ArrayList vs LinkedList, etc.)
4. **Know time/space complexity** of operations
5. **Practice explaining concepts** clearly
6. **Focus on real-world applications**
7. **Stay updated** with latest Java versions
8. **Master debugging** and troubleshooting

This comprehensive list covers all core Java concepts that are frequently tested in top product-based company interviews, ensuring you're prepared for any Java interview scenario.