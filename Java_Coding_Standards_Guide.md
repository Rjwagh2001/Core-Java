# Java Coding Standards & Best Practices

This guide covers industry-standard coding conventions, best practices, and patterns used in top product-based companies.

---

## 1. Naming Conventions

### Classes & Interfaces
- Use **PascalCase** (e.g., `CustomerService`, `OrderManager`).
- Interfaces: avoid prefixing with "I" (e.g., `List`, not `IList`).

### Methods & Variables
- Use **camelCase** (e.g., `calculateTotal()`, `orderCount`).

### Constants
- Use **UPPERCASE_WITH_UNDERSCORES** (e.g., `MAX_SIZE`).

### Packages
- Always lowercase, avoid underscores (e.g., `com.amazon.orderservice`).

---

## 2. Code Formatting

- **Indentation:** 4 spaces (never tabs).
- **Line length:** 120 chars max.
- **Braces:** K&R style (same line).

```java
if (condition) {
    // do something
} else {
    // do something else
}
```

- Use blank lines to separate logical blocks.

---

## 3. Comments & Documentation

### Javadoc Standards
- Document public classes, methods, and fields.

```java
/**
 * Calculates order total including tax.
 *
 * @param order the order object
 * @return total amount with tax
 */
public double calculateTotal(Order order) { ... }
```

### Inline Comments
- Use sparingly to explain complex logic.

---

## 4. Object-Oriented Best Practices

- **Encapsulation:** Use private fields with getters/setters.  
- **Immutability:** Prefer `final` fields, no setters.  
- **Inheritance vs Composition:** Favor composition.  
- **SOLID Principles:** Apply single responsibility, open/closed, etc.

---

## 5. Exception Handling

- Prefer specific exceptions over generic `Exception`.  
- Use custom exceptions for business logic.  
- Avoid silent catch blocks.  
- Always clean resources using try-with-resources.

```java
try (BufferedReader br = new BufferedReader(new FileReader("file.txt"))) {
    return br.readLine();
} catch (IOException e) {
    throw new CustomFileException("Error reading file", e);
}
```

---

## 6. Collections & Generics

- Always use interfaces (`List`, `Map`) over implementations.  
- Use generics for type safety: `List<String>` not `List`.  
- Avoid raw types.

```java
List<String> names = new ArrayList<>();
```

---

## 7. Java Streams & Lambdas

- Use streams for readable transformations.  
- Avoid chaining too many operations.  
- Don't sacrifice readability for one-liners.

```java
List<String> result = users.stream()
    .filter(u -> u.isActive())
    .map(User::getName)
    .collect(Collectors.toList());
```

---

## 8. Concurrency Best Practices

- Prefer Executors over raw Threads.  
- Use `synchronized`, `Lock`, or `Atomic` classes.  
- Avoid deadlocks by ordering locks.  

```java
ExecutorService executor = Executors.newFixedThreadPool(10);
executor.submit(() -> processTask());
```

---

## 9. Performance Guidelines

- Use `StringBuilder` for concatenation in loops.  
- Use caching where applicable.  
- Avoid premature optimization—measure before optimizing.

---

## 10. Code Quality & Tools

- Use **SonarQube**, **Checkstyle**, **SpotBugs**.  
- Write unit tests with **JUnit** and **Mockito**.  
- Follow proper logging standards with **SLF4J**.

```java
private static final Logger logger = LoggerFactory.getLogger(MyService.class);
logger.info("Processing order {}", orderId);
```

---

## 11. Security Best Practices

- Validate all inputs.  
- Never hardcode credentials.  
- Use environment variables or secret vaults.  
- Avoid serialization of sensitive objects.

---

## 12. Real-World Example

```java
package com.amazon.orderservice;

public class OrderService {
    private final OrderRepository repository;

    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    /**
     * Places a new order after validation.
     */
    public void placeOrder(Order order) {
        if (order == null || order.getItems().isEmpty()) {
            throw new InvalidOrderException("Order cannot be empty");
        }
        repository.save(order);
    }
}
```

---

# Final Notes
- Follow **consistent coding standards** across teams.  
- Use **code reviews** to enforce practices.  
- Apply **SOLID principles** and write **clean, testable, maintainable** code.

---
