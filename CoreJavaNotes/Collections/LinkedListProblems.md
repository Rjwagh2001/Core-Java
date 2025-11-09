# LinkedList Practice Problems - HackerRank Style

## Topic 1: LinkedList Creation & Initialization

### Problem 1.1: Basic LinkedList Creation (Basic)
**Difficulty:** Easy

**Problem Statement:**
Create a LinkedList of N integers (from 1 to N). Print the first element, last element, and size of the list.

**Input Format:**
- First line contains an integer N

**Constraints:**
- 1 ≤ N ≤ 100

**Output Format:**
- Line 1: First element
- Line 2: Last element
- Line 3: Size

**Sample Input:**
```
5
```

**Sample Output:**
```
1
5
5
```

---

### Problem 1.2: Initialize from Array (Medium)
**Difficulty:** Medium

**Problem Statement:**
You are given N integers. Create a LinkedList from them and reverse it without using Collections.reverse(). Print the reversed list.

**Input Format:**
- First line: N
- Second line: N space-separated integers

**Constraints:**
- 1 ≤ N ≤ 1000

**Output Format:**
- Print reversed LinkedList in one line

**Sample Input:**
```
5
1 2 3 4 5
```

**Sample Output:**
```
5 4 3 2 1
```

---

### Problem 1.3: Create from Multiple Inputs (Advanced)
**Difficulty:** Hard

**Problem Statement:**
You need to create N separate LinkedLists. Each LinkedList contains a variable number of elements. After creation, answer Q queries where each query asks for the element at position Y in LinkedList X.

**Input Format:**
- First line: N (number of LinkedLists)
- Next N lines: First integer D (size), followed by D integers
- Next line: Q (queries)
- Next Q lines: Two integers X Y

**Constraints:**
- 1 ≤ N ≤ 1000
- 0 ≤ D ≤ 1000
- 1 ≤ Q ≤ 1000

**Output Format:**
- For each query, print element or "ERROR!"

**Sample Input:**
```
3
4 10 20 30 40
2 50 60
3 70 80 90
3
1 2
2 1
3 3
```

**Sample Output:**
```
30
60
ERROR!
```

---

## Topic 2: AddFirst & AddLast Operations

### Problem 2.1: Build Queue (Basic)
**Difficulty:** Easy

**Problem Statement:**
You are building a queue using LinkedList. Process N operations:
- "ADDFIRST X" - Add X to front
- "ADDLAST X" - Add X to end

Print the final queue.

**Input Format:**
- First line: N
- Next N lines: Operation and value

**Constraints:**
- 1 ≤ N ≤ 100

**Output Format:**
- Print final LinkedList

**Sample Input:**
```
5
ADDLAST 10
ADDLAST 20
ADDFIRST 5
ADDLAST 30
ADDFIRST 1
```

**Sample Output:**
```
1 5 10 20 30
```

---

### Problem 2.2: Alternating Insert (Medium)
**Difficulty:** Medium

**Problem Statement:**
You have two lists A and B of equal size N. Create a new LinkedList by alternately taking elements from front of A and back of B.

**Input Format:**
- First line: N
- Second line: N integers for list A
- Third line: N integers for list B

**Constraints:**
- 1 ≤ N ≤ 1000

**Output Format:**
- Print the merged LinkedList

**Sample Input:**
```
4
1 2 3 4
10 20 30 40
```

**Sample Output:**
```
1 40 2 30 3 20 4 10
```

**Explanation:**
Take from A front: 1, then B back: 40, then A front: 2, then B back: 30...

---

### Problem 2.3: Priority Queue Simulation (Advanced)
**Difficulty:** Hard

**Problem Statement:**
Simulate a priority queue using LinkedList. Process N operations:
- "INSERT X P" - Insert X with priority P (1=highest)
- "REMOVE" - Remove highest priority element
- "PEEK" - Print highest priority element

**Input Format:**
- First line: N
- Next N lines: Operations

**Constraints:**
- 1 ≤ N ≤ 1000
- 1 ≤ P ≤ 10

**Output Format:**
- Print output for PEEK and REMOVE operations
- At end, print remaining queue

**Sample Input:**
```
6
INSERT 10 2
INSERT 20 1
INSERT 30 3
PEEK
REMOVE
PEEK
```

**Sample Output:**
```
20
Removed: 20
10
10 30
```

---

## Topic 3: RemoveFirst & RemoveLast Operations

### Problem 3.1: Basic Remove Operations (Basic)
**Difficulty:** Easy

**Problem Statement:**
You have a LinkedList with N elements. Process Q operations:
- "REMOVEFIRST" - Remove first element
- "REMOVELAST" - Remove last element
- "PRINT" - Print current list

**Input Format:**
- First line: N
- Second line: N integers
- Third line: Q
- Next Q lines: Operations

**Constraints:**
- 1 ≤ N ≤ 100
- 1 ≤ Q ≤ N

**Output Format:**
- Print output for each PRINT operation

**Sample Input:**
```
5
10 20 30 40 50
4
REMOVEFIRST
PRINT
REMOVELAST
PRINT
```

**Sample Output:**
```
20 30 40 50
20 30 40
```

---

### Problem 3.2: Deque Operations (Medium)
**Difficulty:** Medium

**Problem Statement:**
Implement a Deque (Double-ended queue) using LinkedList. Support operations:
- "PUSHFRONT X" - Add to front
- "PUSHBACK X" - Add to back
- "POPFRONT" - Remove from front
- "POPBACK" - Remove from back

**Input Format:**
- First line: N (operations)
- Next N lines: Operations

**Constraints:**
- 1 ≤ N ≤ 1000

**Output Format:**
- For each POP operation, print removed element
- At end, print remaining deque

**Sample Input:**
```
6
PUSHBACK 10
PUSHBACK 20
PUSHFRONT 5
POPFRONT
POPBACK
PUSHBACK 30
```

**Sample Output:**
```
Removed: 5
Removed: 20
10 30
```

---

### Problem 3.3: Palindrome Checker (Advanced)
**Difficulty:** Hard

**Problem Statement:**
Check if a LinkedList is a palindrome by removing elements from both ends and comparing them. Print "YES" if palindrome, else "NO" along with first mismatching pair.

**Input Format:**
- First line: N
- Second line: N integers

**Constraints:**
- 1 ≤ N ≤ 1000

**Output Format:**
- "YES" if palindrome
- "NO X Y" if not (X and Y are mismatching elements)

**Sample Input 1:**
```
5
1 2 3 2 1
```

**Sample Output 1:**
```
YES
```

**Sample Input 2:**
```
4
1 2 3 4
```

**Sample Output 2:**
```
NO 1 4
```

---

## Topic 4: GetFirst, GetLast, Peek Operations

### Problem 4.1: Queue Peek Operations (Basic)
**Difficulty:** Easy

**Problem Statement:**
You have a queue with N elements. Answer Q queries:
- "PEEKFIRST" - Print first element
- "PEEKLAST" - Print last element
- "SIZE" - Print size

**Input Format:**
- First line: N
- Second line: N integers
- Third line: Q
- Next Q lines: Query type

**Constraints:**
- 1 ≤ N ≤ 100
- 1 ≤ Q ≤ 50

**Output Format:**
- Answer for each query

**Sample Input:**
```
5
10 20 30 40 50
3
PEEKFIRST
PEEKLAST
SIZE
```

**Sample Output:**
```
10
50
5
```

---

### Problem 4.2: Sliding Window Maximum (Medium)
**Difficulty:** Medium

**Problem Statement:**
Given N integers and window size K, find maximum in each window using LinkedList operations.

**Input Format:**
- First line: N K
- Second line: N integers

**Constraints:**
- 1 ≤ K ≤ N ≤ 1000

**Output Format:**
- Print maximum for each window

**Sample Input:**
```
7 3
1 3 5 2 4 6 7
```

**Sample Output:**
```
5 5 5 6 7
```

---

### Problem 4.3: Recent Counter (Advanced)
**Difficulty:** Hard

**Problem Statement:**
Implement a RecentCounter that counts recent requests within 3000ms. For each timestamp T, return count of requests in range [T-3000, T].

**Input Format:**
- First line: N (number of requests)
- Second line: N timestamps (sorted)

**Constraints:**
- 1 ≤ N ≤ 10000
- Timestamps are sorted

**Output Format:**
- For each timestamp, print count of recent requests

**Sample Input:**
```
5
1 100 3001 3002 6000
```

**Sample Output:**
```
1
2
3
3
1
```

---

## Topic 5: Offer and Poll Operations (Queue)

### Problem 5.1: Simple Queue (Basic)
**Difficulty:** Easy

**Problem Statement:**
Implement queue operations:
- "OFFER X" - Add X to queue
- "POLL" - Remove and print front element

**Input Format:**
- First line: N
- Next N lines: Operations

**Constraints:**
- 1 ≤ N ≤ 100

**Output Format:**
- For POLL, print removed element
- At end, print remaining queue

**Sample Input:**
```
5
OFFER 10
OFFER 20
POLL
OFFER 30
POLL
```

**Sample Output:**
```
10
20
30
```

---

### Problem 5.2: Task Scheduler (Medium)
**Difficulty:** Medium

**Problem Statement:**
You have tasks with execution time. Process them in order, each taking 1 time unit. After each time unit, print completed task. Tasks are added using OFFER, completed using POLL.

**Input Format:**
- First line: N
- Next N lines: "OFFER taskName" or "EXECUTE"

**Constraints:**
- 1 ≤ N ≤ 1000

**Output Format:**
- For each EXECUTE, print task name

**Sample Input:**
```
7
OFFER Task1
OFFER Task2
OFFER Task3
EXECUTE
EXECUTE
OFFER Task4
EXECUTE
```

**Sample Output:**
```
Task1
Task2
Task3
Task4
```

---

### Problem 5.3: Circular Queue (Advanced)
**Difficulty:** Hard

**Problem Statement:**
Implement circular queue with max size K. Operations:
- "OFFER X" - Add if space available
- "POLL" - Remove front
- "FULL" - Check if full

**Input Format:**
- First line: K (max size) and N (operations)
- Next N lines: Operations

**Constraints:**
- 1 ≤ K ≤ 100
- 1 ≤ N ≤ 1000

**Output Format:**
- For OFFER: "Added" or "Queue Full"
- For POLL: Element or "Queue Empty"
- For FULL: "YES" or "NO"

**Sample Input:**
```
3 7
OFFER 10
OFFER 20
OFFER 30
FULL
OFFER 40
POLL
OFFER 40
```

**Sample Output:**
```
Added
Added
Added
YES
Queue Full
10
Added
20 30 40
```

---

## Topic 6: Element and Get Operations

### Problem 6.1: Access Elements (Basic)
**Difficulty:** Easy

**Problem Statement:**
Given LinkedList with N elements, answer Q queries for element at index I.

**Input Format:**
- First line: N
- Second line: N integers
- Third line: Q
- Next Q lines: Index I

**Constraints:**
- 1 ≤ N ≤ 100
- 0 ≤ I < N

**Output Format:**
- Print element at each index

**Sample Input:**
```
5
10 20 30 40 50
3
0
2
4
```

**Sample Output:**
```
10
30
50
```

---

### Problem 6.2: Find Middle Element (Medium)
**Difficulty:** Medium

**Problem Statement:**
Find middle element of LinkedList. If even length, print both middle elements.

**Input Format:**
- First line: N
- Second line: N integers

**Constraints:**
- 1 ≤ N ≤ 1000

**Output Format:**
- Middle element(s)

**Sample Input 1:**
```
5
10 20 30 40 50
```

**Sample Output 1:**
```
30
```

**Sample Input 2:**
```
6
10 20 30 40 50 60
```

**Sample Output 2:**
```
30 40
```

---

### Problem 6.3: Nth Node from End (Advanced)
**Difficulty:** Hard

**Problem Statement:**
Find Nth node from end without calculating size first. Use two-pointer technique.

**Input Format:**
- First line: N (size) and K (position from end)
- Second line: N integers

**Constraints:**
- 1 ≤ K ≤ N ≤ 1000

**Output Format:**
- Print Kth element from end

**Sample Input:**
```
7 3
10 20 30 40 50 60 70
```

**Sample Output:**
```
50
```

**Explanation:**
3rd from end: [10 20 30 40 **50** 60 70]

---

## Topic 7: Set and IndexOf Operations

### Problem 7.1: Update Elements (Basic)
**Difficulty:** Easy

**Problem Statement:**
Update element at index I with value V for Q queries.

**Input Format:**
- First line: N
- Second line: N integers
- Third line: Q
- Next Q lines: I V

**Constraints:**
- 1 ≤ N ≤ 100

**Output Format:**
- Print final LinkedList

**Sample Input:**
```
5
10 20 30 40 50
2
1 25
3 45
```

**Sample Output:**
```
10 25 30 45 50
```

---

### Problem 7.2: Swap Elements (Medium)
**Difficulty:** Medium

**Problem Statement:**
Find elements X and Y in list and swap their positions.

**Input Format:**
- First line: N
- Second line: N integers
- Third line: X Y

**Constraints:**
- 1 ≤ N ≤ 1000
- X and Y exist in list

**Output Format:**
- Print list after swap

**Sample Input:**
```
5
10 20 30 40 50
20 40
```

**Sample Output:**
```
10 40 30 20 50
```

---

### Problem 7.3: Move Element to Front (Advanced)
**Difficulty:** Hard

**Problem Statement:**
Given a LinkedList and value X, move all occurrences of X to the front while maintaining relative order of other elements.

**Input Format:**
- First line: N
- Second line: N integers
- Third line: X

**Constraints:**
- 1 ≤ N ≤ 1000

**Output Format:**
- Print modified list

**Sample Input:**
```
8
1 2 3 2 4 2 5 6
2
```

**Sample Output:**
```
2 2 2 1 3 4 5 6
```

---

## Topic 8: Clone and Clear Operations

### Problem 8.1: Clone and Modify (Basic)
**Difficulty:** Easy

**Problem Statement:**
Clone a LinkedList, modify original by doubling values. Print both.

**Input Format:**
- First line: N
- Second line: N integers

**Constraints:**
- 1 ≤ N ≤ 100

**Output Format:**
- Line 1: Modified original
- Line 2: Clone

**Sample Input:**
```
4
5 10 15 20
```

**Sample Output:**
```
10 20 30 40
5 10 15 20
```

---

### Problem 8.2: Partial Clear (Medium)
**Difficulty:** Medium

**Problem Statement:**
Given range [L, R], remove all elements in that range.

**Input Format:**
- First line: N
- Second line: N integers
- Third line: L R (0-indexed)

**Constraints:**
- 1 ≤ N ≤ 1000
- 0 ≤ L ≤ R < N

**Output Format:**
- Print list after removal

**Sample Input:**
```
7
10 20 30 40 50 60 70
2 4
```

**Sample Output:**
```
10 20 60 70
```

---

### Problem 8.3: Snapshot and Restore (Advanced)
**Difficulty:** Hard

**Problem Statement:**
Implement snapshot functionality. Operations:
- "SNAPSHOT" - Save current state
- "ADD X" - Add element
- "REMOVE" - Remove first element
- "RESTORE" - Restore to last snapshot

**Input Format:**
- First line: N
- Next N lines: Operations

**Constraints:**
- 1 ≤ N ≤ 1000

**Output Format:**
- Print final state

**Sample Input:**
```
8
ADD 10
ADD 20
SNAPSHOT
ADD 30
ADD 40
REMOVE
RESTORE
```

**Sample Output:**
```
10 20
```

---

## Topic 9: Iterator Operations

### Problem 9.1: Descending Iterator (Basic)
**Difficulty:** Easy

**Problem Statement:**
Print LinkedList in reverse using descendingIterator.

**Input Format:**
- First line: N
- Second line: N integers

**Constraints:**
- 1 ≤ N ≤ 100

**Output Format:**
- Print reversed list

**Sample Input:**
```
5
1 2 3 4 5
```

**Sample Output:**
```
5 4 3 2 1
```

---

### Problem 9.2: Remove While Iterating (Medium)
**Difficulty:** Medium

**Problem Statement:**
Remove all even numbers using iterator.

**Input Format:**
- First line: N
- Second line: N integers

**Constraints:**
- 1 ≤ N ≤ 1000

**Output Format:**
- Line 1: Count removed
- Line 2: Final list

**Sample Input:**
```
6
1 2 3 4 5 6
```

**Sample Output:**
```
3
1 3 5
```

---

### Problem 9.3: Custom Iterator Pattern (Advanced)
**Difficulty:** Hard

**Problem Statement:**
Iterate and print only prime numbers, then print sum of non-primes.

**Input Format:**
- First line: N
- Second line: N integers

**Constraints:**
- 1 ≤ N ≤ 1000
- 1 ≤ elements ≤ 1000

**Output Format:**
- Line 1: Prime numbers
- Line 2: Sum of non-primes

**Sample Input:**
```
6
2 4 5 6 7 9
```

**Sample Output:**
```
2 5 7
19
```

---

## Topic 10: Conversion Operations

### Problem 10.1: LinkedList to Array (Basic)
**Difficulty:** Easy

**Problem Statement:**
Convert LinkedList to array and print array elements with their indices.

**Input Format:**
- First line: N
- Second line: N integers

**Constraints:**
- 1 ≤ N ≤ 100

**Output Format:**
- Each line: Index and Element

**Sample Input:**
```
4
10 20 30 40
```

**Sample Output:**
```
0: 10
1: 20
2: 30
3: 40
```

---

### Problem 10.2: Array to LinkedList Performance (Medium)
**Difficulty:** Medium

**Problem Statement:**
Given array, convert to LinkedList and perform N insertions at random positions. Count operations.

**Input Format:**
- First line: N
- Second line: N integers for initial array
- Third line: M (insertions)
- Next M lines: Position and Value

**Constraints:**
- 1 ≤ N, M ≤ 1000

**Output Format:**
- Final LinkedList

**Sample Input:**
```
5
1 2 3 4 5
3
0 0
3 99
7 100
```

**Sample Output:**
```
0 1 2 3 99 4 5 100
```

---

### Problem 10.3: Stream Operations (Advanced)
**Difficulty:** Hard

**Problem Statement:**
Use stream operations on LinkedList:
1. Filter even numbers
2. Double them
3. Sort in descending order
4. Print

**Input Format:**
- First line: N
- Second line: N integers

**Constraints:**
- 1 ≤ N ≤ 1000

**Output Format:**
- Processed list

**Sample Input:**
```
8
1 2 3 4 5 6 7 8
```

**Sample Output:**
```
16 12 8 4
```

---

## Bonus Challenge Problems

### Problem B.1: Reverse in Groups
**Difficulty:** Hard

**Problem Statement:**
Reverse LinkedList in groups of K.

**Input Format:**
- First line: N K
- Second line: N integers

**Sample Input:**
```
8 3
1 2 3 4 5 6 7 8
```

**Sample Output:**
```
3 2 1 6 5 4 8 7
```

---

### Problem B.2: Detect and Remove Loop
**Difficulty:** Hard

**Problem Statement:**
Given input suggesting a loop structure, detect if loop exists and remove it.

**Input Format:**
- First line: N
- Second line: N integers
- Third line: L (loop start position, -1 for no loop)

**Sample Input:**
```
5
1 2 3 4 5
2
```

**Sample Output:**
```
Loop detected at position 2
Loop removed
1 2 3 4 5
```

---

### Problem B.3: Merge K Sorted LinkedLists
**Difficulty:** Hard

**Problem Statement:**
Merge K sorted LinkedLists into one sorted list.

**Input Format:**
- First line: K
- Next K sections: Size and sorted integers

**Sample Input:**
```
3
3 1 4 7
2 2 5
4 3 6 8 9
```

**Sample Output:**
```
1 2 3 4 5 6 7 8 9
```

---

### Problem B.4: LRU Cache using LinkedList
**Difficulty:** Hard

**Problem Statement:**
Implement LRU cache with capacity K using LinkedList.

**Input Format:**
- First line: K (capacity) and N (operations)
- Next N lines: "PUT key value" or "GET key"

**Sample Input:**
```
2 5
PUT 1 10
PUT 2 20
GET 1
PUT 3 30
GET 2
```

**Sample Output:**
```
10
-1
1->10 3->30
```

---

## Practice Strategy

**Week 1:** Topics 1-3 (Basic operations)
**Week 2:** Topics 4-6 (Intermediate operations)
**Week 3:** Topics 7-10 (Advanced operations)
**Week 4:** Bonus challenges

**Total Problems: 40**
- Basic: 10
- Medium: 15
- Advanced: 11
- Bonus: 4

**Key LinkedList Methods Covered:**
✅ addFirst(), addLast()
✅ removeFirst(), removeLast()
✅ getFirst(), getLast()
✅ peekFirst(), peekLast()
✅ offer(), poll(), peek()
✅ element(), get(), set()
✅ indexOf(), lastIndexOf()
✅ clone(), clear()
✅ iterator(), descendingIterator()
✅ toArray()

Good luck! 🚀