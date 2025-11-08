# ArrayList Practice Problems - HackerRank Style

## Topic 1: ArrayList Creation & Initialization

### Problem 1.1: Simple List Creation (Basic)
**Difficulty:** Easy

**Problem Statement:**
You are given an integer N. Create an ArrayList and add N integers to it (from 1 to N). Then print all elements in a single line separated by spaces.

**Input Format:**
- First line contains an integer N

**Constraints:**
- 1 ≤ N ≤ 100

**Output Format:**
- Print all elements of the ArrayList in a single line separated by spaces

**Sample Input:**
```
5
```

**Sample Output:**
```
1 2 3 4 5
```

---

### Problem 1.2: Initialize from Input (Medium)
**Difficulty:** Medium

**Problem Statement:**
You are given N integers. Store them in an ArrayList and then remove all duplicate elements while maintaining the order of first occurrence. Print the final ArrayList.

**Input Format:**
- First line contains an integer N
- Second line contains N space-separated integers

**Constraints:**
- 1 ≤ N ≤ 1000
- 0 ≤ elements ≤ 10^6

**Output Format:**
- Print the ArrayList without duplicates in a single line separated by spaces

**Sample Input:**
```
7
1 2 3 2 4 3 5
```

**Sample Output:**
```
1 2 3 4 5
```

**Explanation:**
Elements 2 and 3 appear multiple times. Keep only their first occurrence.

---

### Problem 1.3: Multiple ArrayLists Creation (Advanced)
**Difficulty:** Hard

**Problem Statement:**
You are given N and then N lines follow. Each line starts with an integer D (the number of elements in that line) followed by D space-separated integers. Store each line as a separate ArrayList and store all these ArrayLists in a main ArrayList. After this, you will be given Q queries. Each query contains two integers X and Y. For each query, print the Y-th element of the X-th ArrayList. If the element doesn't exist, print "ERROR!".

**Input Format:**
- First line contains N (number of ArrayLists)
- Next N lines: First integer D, followed by D space-separated integers
- Next line contains Q (number of queries)
- Next Q lines: Two integers X and Y

**Constraints:**
- 1 ≤ N ≤ 20,000
- 0 ≤ D ≤ 50,000
- 1 ≤ Q ≤ 1000
- 1 ≤ X ≤ N
- 1 ≤ Y ≤ D

**Output Format:**
- For each query, print the element or "ERROR!" on a new line

**Sample Input:**
```
5
5 41 77 74 22 44
1 12
4 37 34 36 52
0
3 20 22 33
5
1 3
3 4
3 1
4 3
5 5
```

**Sample Output:**
```
74
52
37
ERROR!
ERROR!
```

---

## Topic 2: Insert Operations

### Problem 2.1: Add Elements (Basic)
**Difficulty:** Easy

**Problem Statement:**
You are given N integers. Add them to an ArrayList one by one. After adding all elements, print the size of the ArrayList and then print all elements.

**Input Format:**
- First line contains N
- Second line contains N space-separated integers

**Constraints:**
- 1 ≤ N ≤ 100

**Output Format:**
- First line: Size of ArrayList
- Second line: All elements separated by spaces

**Sample Input:**
```
5
10 20 30 40 50
```

**Sample Output:**
```
5
10 20 30 40 50
```

---

### Problem 2.2: Insert at Position (Medium)
**Difficulty:** Medium

**Problem Statement:**
You are given an initial ArrayList with N elements. Then you will receive Q queries. Each query has two parts:
- "Insert X Y" - Insert value Y at index X
- Print the final ArrayList after all queries

**Input Format:**
- First line contains N
- Second line contains N space-separated integers
- Third line contains Q (number of insert queries)
- Next Q lines contain: "Insert", then next line contains X and Y

**Constraints:**
- 1 ≤ N ≤ 100
- 1 ≤ Q ≤ 50
- 0 ≤ X ≤ current size of list

**Output Format:**
- Print final ArrayList in a single line

**Sample Input:**
```
5
1 2 3 4 5
3
Insert
2 99
Insert
0 88
Insert
5 77
```

**Sample Output:**
```
88 1 2 99 3 4 5 77
```

---

### Problem 2.3: Insert and Delete Queries (Advanced) ⭐
**Difficulty:** Hard

**Problem Statement:**
You are given a list of N integers. Perform Q queries on the list. Each query is one of the following two types:
1. Insert X Y: Insert integer Y at index X
2. Delete X: Delete the element at index X

After all queries, print the modified list as a single line of space-separated integers.

**Input Format:**
- First line: N (initial number of elements)
- Second line: N space-separated integers
- Third line: Q (number of queries)
- Next 2*Q lines: Each query is described over two lines
  - If first line is "Insert", second line contains X and Y
  - If first line is "Delete", second line contains X

**Constraints:**
- 1 ≤ N ≤ 4000
- 1 ≤ Q ≤ 4000
- Each element is a 32-bit integer

**Output Format:**
- Print updated list as space-separated integers

**Sample Input:**
```
5
12 0 1 78 12
2
Insert
5 23
Delete
0
```

**Sample Output:**
```
0 1 78 12 23
```

**Explanation:**
- Initial list: [12, 0, 1, 78, 12]
- After Insert 5 23: [12, 0, 1, 78, 12, 23]
- After Delete 0: [0, 1, 78, 12, 23]

---

## Topic 3: Access Operations

### Problem 3.1: Access by Index (Basic)
**Difficulty:** Easy

**Problem Statement:**
You are given an ArrayList of N integers and Q queries. Each query contains an index I. For each query, print the element at index I. If index is out of bounds, print "Invalid Index".

**Input Format:**
- First line: N
- Second line: N space-separated integers
- Third line: Q
- Next Q lines: One integer I (index)

**Constraints:**
- 1 ≤ N ≤ 100
- 1 ≤ Q ≤ 50

**Output Format:**
- For each query, print the element or "Invalid Index"

**Sample Input:**
```
5
10 20 30 40 50
3
0
2
5
```

**Sample Output:**
```
10
30
Invalid Index
```

---

### Problem 3.2: Find All Occurrences (Medium)
**Difficulty:** Medium

**Problem Statement:**
You are given an ArrayList of N integers and a target value T. Find all indices where T appears in the list. If T doesn't appear, print "Not Found".

**Input Format:**
- First line: N
- Second line: N space-separated integers
- Third line: T (target value)

**Constraints:**
- 1 ≤ N ≤ 1000
- -10^6 ≤ elements, T ≤ 10^6

**Output Format:**
- If found: Print all indices separated by spaces
- If not found: Print "Not Found"

**Sample Input 1:**
```
7
1 2 3 2 4 2 5
2
```

**Sample Output 1:**
```
1 3 5
```

**Sample Input 2:**
```
5
1 2 3 4 5
10
```

**Sample Output 2:**
```
Not Found
```

---

### Problem 3.3: Nested ArrayList Query (Advanced)
**Difficulty:** Hard

**Problem Statement:**
You are storing student marks in different subjects. Each student has a variable number of subject marks. Given N students and their marks, answer Q queries. Each query asks for the mark in subject Y of student X.

**Input Format:**
- First line: N (number of students)
- Next N lines: First integer M (number of subjects), followed by M integers (marks)
- Next line: Q (number of queries)
- Next Q lines: Two integers X Y (student number and subject number)

**Constraints:**
- 1 ≤ N ≤ 100
- 0 ≤ M ≤ 100
- 1 ≤ Q ≤ 100
- 0 ≤ marks ≤ 100

**Output Format:**
- For each query, print the mark or "ERROR!" if invalid

**Sample Input:**
```
3
4 85 90 78 92
2 88 95
3 70 80 75
4
1 2
2 1
3 3
1 5
```

**Sample Output:**
```
90
88
75
ERROR!
```

---

## Topic 4: Update Operations

### Problem 4.1: Update at Index (Basic)
**Difficulty:** Easy

**Problem Statement:**
You are given an ArrayList of N integers and Q update queries. Each query contains index I and new value V. Update the element at index I with value V. Print the final ArrayList.

**Input Format:**
- First line: N
- Second line: N space-separated integers
- Third line: Q
- Next Q lines: Two integers I and V

**Constraints:**
- 1 ≤ N ≤ 100
- 1 ≤ Q ≤ 50
- 0 ≤ I < N

**Output Format:**
- Print final ArrayList in one line

**Sample Input:**
```
5
1 2 3 4 5
3
0 10
2 30
4 50
```

**Sample Output:**
```
10 2 30 4 50
```

---

### Problem 4.2: Transform Elements (Medium)
**Difficulty:** Medium

**Problem Statement:**
You are given an ArrayList of N integers. Perform the following transformation:
- If element is even, multiply it by 2
- If element is odd, add 1 to it

Print the transformed ArrayList.

**Input Format:**
- First line: N
- Second line: N space-separated integers

**Constraints:**
- 1 ≤ N ≤ 1000
- 1 ≤ elements ≤ 10^6

**Output Format:**
- Print transformed ArrayList in one line

**Sample Input:**
```
6
1 2 3 4 5 6
```

**Sample Output:**
```
2 4 4 8 6 12
```

**Explanation:**
- 1 (odd) → 1+1 = 2
- 2 (even) → 2*2 = 4
- 3 (odd) → 3+1 = 4
- 4 (even) → 4*2 = 8
- 5 (odd) → 5+1 = 6
- 6 (even) → 6*2 = 12

---

### Problem 4.3: Conditional Bulk Update (Advanced)
**Difficulty:** Hard

**Problem Statement:**
You have an ArrayList of N integers. You need to update elements based on multiple conditions:
- If element is divisible by 3, replace with element/3
- Else if element is divisible by 2, replace with element*2
- Else replace with element+5

After transformation, remove all elements that are greater than 100. Print the final list.

**Input Format:**
- First line: N
- Second line: N space-separated integers

**Constraints:**
- 1 ≤ N ≤ 1000
- 1 ≤ elements ≤ 500

**Output Format:**
- Print final ArrayList in one line

**Sample Input:**
```
8
3 4 5 6 9 12 15 7
```

**Sample Output:**
```
1 8 10 2 3 4 5 12
```

---

## Topic 5: Delete Operations

### Problem 5.1: Remove by Index (Basic)
**Difficulty:** Easy

**Problem Statement:**
You are given an ArrayList of N integers and Q indices to remove. Remove elements at given indices one by one (after each removal, indices shift). Print the final ArrayList.

**Input Format:**
- First line: N
- Second line: N space-separated integers
- Third line: Q
- Next Q lines: One integer (index to remove)

**Constraints:**
- 1 ≤ N ≤ 100
- 1 ≤ Q ≤ N
- Valid indices provided

**Output Format:**
- Print final ArrayList in one line

**Sample Input:**
```
5
10 20 30 40 50
2
1
2
```

**Sample Output:**
```
10 30 50
```

**Explanation:**
- Initial: [10, 20, 30, 40, 50]
- Remove index 1: [10, 30, 40, 50]
- Remove index 2: [10, 30, 50]

---

### Problem 5.2: Remove All Occurrences (Medium)
**Difficulty:** Medium

**Problem Statement:**
You are given an ArrayList of N integers and a value X. Remove all occurrences of X from the list. Print the final list and count of elements removed.

**Input Format:**
- First line: N
- Second line: N space-separated integers
- Third line: X (value to remove)

**Constraints:**
- 1 ≤ N ≤ 1000
- -10^6 ≤ elements, X ≤ 10^6

**Output Format:**
- First line: Count of elements removed
- Second line: Final ArrayList (if empty, print "Empty")

**Sample Input:**
```
7
1 2 3 2 4 2 5
2
```

**Sample Output:**
```
3
1 3 4 5
```

---

### Problem 5.3: Conditional Remove (Advanced)
**Difficulty:** Hard

**Problem Statement:**
You have an ArrayList of N integers. Remove elements based on these rules:
- Remove all prime numbers
- Remove all elements divisible by K
- Remove all elements less than MIN

Print the count of removed elements and the final list.

**Input Format:**
- First line: N
- Second line: N space-separated integers
- Third line: K and MIN (two integers)

**Constraints:**
- 1 ≤ N ≤ 1000
- 1 ≤ elements ≤ 1000
- 1 ≤ K, MIN ≤ 100

**Output Format:**
- First line: Count removed
- Second line: Final list (or "Empty")

**Sample Input:**
```
10
2 3 4 5 6 7 8 9 10 11
3 5
```

**Sample Output:**
```
7
4 8 10
```

**Explanation:**
Removed: 2(prime), 3(prime,div by 3), 5(prime,div by 5), 6(div by 3), 7(prime), 9(div by 3), 11(prime)

---

## Topic 6: Search Operations

### Problem 6.1: Element Exists (Basic)
**Difficulty:** Easy

**Problem Statement:**
You are given an ArrayList of N integers and Q queries. Each query contains a value V. For each query, print "YES" if V exists in the list, otherwise "NO".

**Input Format:**
- First line: N
- Second line: N space-separated integers
- Third line: Q
- Next Q lines: One integer V

**Constraints:**
- 1 ≤ N ≤ 1000
- 1 ≤ Q ≤ 100

**Output Format:**
- For each query, print "YES" or "NO"

**Sample Input:**
```
5
10 20 30 40 50
4
20
60
10
35
```

**Sample Output:**
```
YES
NO
YES
NO
```

---

### Problem 6.2: First and Last Position (Medium)
**Difficulty:** Medium

**Problem Statement:**
You are given a sorted ArrayList of N integers and a target value T. Find the first and last position of T in the list. If T doesn't exist, print -1 for both positions.

**Input Format:**
- First line: N
- Second line: N space-separated sorted integers
- Third line: T

**Constraints:**
- 1 ≤ N ≤ 10^5
- Array is sorted in ascending order

**Output Format:**
- Print two integers: first position and last position

**Sample Input:**
```
10
1 2 2 2 3 4 4 5 6 7
2
```

**Sample Output:**
```
1 3
```

---

### Problem 6.3: Search in Rotated Array (Advanced)
**Difficulty:** Hard

**Problem Statement:**
You are given an ArrayList that was originally sorted, then rotated at some pivot. Find if a target value exists and return its index. If not found, return -1.

**Input Format:**
- First line: N
- Second line: N space-separated integers (rotated sorted array)
- Third line: Target value

**Constraints:**
- 1 ≤ N ≤ 10^4
- All elements are unique

**Output Format:**
- Print index of target or -1

**Sample Input 1:**
```
7
4 5 6 7 0 1 2
0
```

**Sample Output 1:**
```
4
```

**Sample Input 2:**
```
7
4 5 6 7 0 1 2
3
```

**Sample Output 2:**
```
-1
```

---

## Topic 7: Sorting Operations

### Problem 7.1: Basic Sort (Basic)
**Difficulty:** Easy

**Problem Statement:**
You are given N integers. Sort them in ascending order and print. Then sort in descending order and print.

**Input Format:**
- First line: N
- Second line: N space-separated integers

**Constraints:**
- 1 ≤ N ≤ 1000

**Output Format:**
- First line: Ascending order
- Second line: Descending order

**Sample Input:**
```
5
5 2 8 1 9
```

**Sample Output:**
```
1 2 5 8 9
9 8 5 2 1
```

---

### Problem 7.2: Sort Students by Marks (Medium)
**Difficulty:** Medium

**Problem Statement:**
You have N students with their names and marks. Sort them by marks in descending order. If two students have same marks, sort by name in ascending order.

**Input Format:**
- First line: N
- Next N lines: Name (string) and Marks (integer)

**Constraints:**
- 1 ≤ N ≤ 1000
- 0 ≤ Marks ≤ 100
- Name contains only alphabets

**Output Format:**
- Print each student's name and marks in sorted order

**Sample Input:**
```
4
Alice 85
Bob 92
Charlie 85
David 78
```

**Sample Output:**
```
Bob 92
Alice 85
Charlie 85
David 78
```

---

### Problem 7.3: Multi-criteria Sorting (Advanced)
**Difficulty:** Hard

**Problem Statement:**
You have N employees with Name, Age, and Salary. Sort them by:
1. Age (ascending)
2. If age same, by Salary (descending)
3. If salary also same, by Name (ascending)

**Input Format:**
- First line: N
- Next N lines: Name Age Salary

**Constraints:**
- 1 ≤ N ≤ 1000
- 20 ≤ Age ≤ 60
- 10000 ≤ Salary ≤ 100000

**Output Format:**
- Print sorted employees

**Sample Input:**
```
5
Alice 30 50000
Bob 25 60000
Charlie 30 55000
David 25 50000
Eve 30 55000
```

**Sample Output:**
```
Bob 25 60000
David 25 50000
Charlie 30 55000
Eve 30 55000
Alice 30 50000
```

---

## Bonus Challenge Problems

### Problem B.1: Merge Two Sorted Lists
**Difficulty:** Medium

**Problem Statement:**
You are given two sorted ArrayLists. Merge them into one sorted ArrayList without using Collections.sort().

**Input Format:**
- First line: N (size of first list)
- Second line: N sorted integers
- Third line: M (size of second list)
- Fourth line: M sorted integers

**Sample Input:**
```
4
1 3 5 7
3
2 4 6
```

**Sample Output:**
```
1 2 3 4 5 6 7
```

---

### Problem B.2: Remove Duplicates and Sort
**Difficulty:** Medium

**Problem Statement:**
Given N integers (possibly duplicates), remove duplicates and sort in ascending order. Then print the K-th smallest unique element.

**Input Format:**
- First line: N
- Second line: N integers
- Third line: K

**Sample Input:**
```
8
5 2 8 2 9 2 3 5
3
```

**Sample Output:**
```
5
```

**Explanation:**
Unique sorted: [2, 3, 5, 8, 9]. 3rd smallest is 5.

---

### Problem B.3: Sliding Window Maximum
**Difficulty:** Hard

**Problem Statement:**
Given an ArrayList of N integers and window size K, find the maximum element in each sliding window of size K.

**Input Format:**
- First line: N and K
- Second line: N integers

**Sample Input:**
```
8 3
1 3 -1 -3 5 3 6 7
```

**Sample Output:**
```
3 3 5 5 6 7
```

---

---

## Topic 8: Additional ArrayList Methods

### Problem 8.1: SubList Operations (Basic)
**Difficulty:** Easy

**Problem Statement:**
You are given an ArrayList of N integers and Q queries. Each query contains two indices START and END. For each query, extract and print the sublist from START (inclusive) to END (exclusive).

**Input Format:**
- First line: N
- Second line: N space-separated integers
- Third line: Q
- Next Q lines: Two integers START and END

**Constraints:**
- 1 ≤ N ≤ 100
- 1 ≤ Q ≤ 20
- 0 ≤ START < END ≤ N

**Output Format:**
- For each query, print the sublist on a new line

**Sample Input:**
```
7
10 20 30 40 50 60 70
3
0 3
2 5
4 7
```

**Sample Output:**
```
10 20 30
30 40 50
50 60 70
```

---

### Problem 8.2: Clear and isEmpty Check (Basic)
**Difficulty:** Easy

**Problem Statement:**
You are given N integers to add to an ArrayList. After adding, perform Q operations:
- "SIZE" - print current size
- "EMPTY" - print "YES" if empty, "NO" otherwise
- "CLEAR" - clear all elements

**Input Format:**
- First line: N
- Second line: N space-separated integers
- Third line: Q
- Next Q lines: Operation type

**Constraints:**
- 1 ≤ N ≤ 100
- 1 ≤ Q ≤ 20

**Output Format:**
- For each operation, print the result

**Sample Input:**
```
5
1 2 3 4 5
4
SIZE
EMPTY
CLEAR
EMPTY
```

**Sample Output:**
```
5
NO
YES
```

---

### Problem 8.3: AddAll and RemoveAll (Medium)
**Difficulty:** Medium

**Problem Statement:**
You have two ArrayLists A and B. Perform these operations:
1. Add all elements of B to A
2. Print merged list
3. Remove all elements from A that exist in B
4. Print final list

**Input Format:**
- First line: N (size of A)
- Second line: N integers
- Third line: M (size of B)
- Fourth line: M integers

**Constraints:**
- 1 ≤ N, M ≤ 1000

**Output Format:**
- First line: After addAll
- Second line: After removeAll

**Sample Input:**
```
5
1 2 3 4 5
3
3 4 6
```

**Sample Output:**
```
1 2 3 4 5 3 4 6
1 2 5
```

---

### Problem 8.4: RetainAll Operation (Medium)
**Difficulty:** Medium

**Problem Statement:**
You have two ArrayLists A and B. Keep only those elements in A that are present in B (intersection). Print the result.

**Input Format:**
- First line: N
- Second line: N integers for list A
- Third line: M
- Fourth line: M integers for list B

**Constraints:**
- 1 ≤ N, M ≤ 1000

**Output Format:**
- Print common elements maintaining order from A

**Sample Input:**
```
6
1 2 3 4 5 6
4
2 4 6 8
```

**Sample Output:**
```
2 4 6
```

---

### Problem 8.5: Clone ArrayList (Medium)
**Difficulty:** Medium

**Problem Statement:**
You are given an ArrayList of N integers. Create a clone of it, modify the original by doubling all values, then print both lists to verify they are independent.

**Input Format:**
- First line: N
- Second line: N integers

**Constraints:**
- 1 ≤ N ≤ 100

**Output Format:**
- First line: Modified original list
- Second line: Cloned list (unchanged)

**Sample Input:**
```
5
1 2 3 4 5
```

**Sample Output:**
```
2 4 6 8 10
1 2 3 4 5
```

---

### Problem 8.6: ToArray Conversion (Basic)
**Difficulty:** Easy

**Problem Statement:**
You are given N integers in an ArrayList. Convert it to an array and print:
1. Array elements
2. Array length
3. Middle element of array

**Input Format:**
- First line: N
- Second line: N integers

**Constraints:**
- 1 ≤ N ≤ 1000 (N is always odd)

**Output Format:**
- Three lines as specified

**Sample Input:**
```
5
10 20 30 40 50
```

**Sample Output:**
```
10 20 30 40 50
5
30
```

---

### Problem 8.7: EnsureCapacity and TrimToSize (Advanced)
**Difficulty:** Hard

**Problem Statement:**
Create an ArrayList and demonstrate capacity management:
1. Add N elements
2. Check if adding M more elements would need resizing (capacity < size + M)
3. Print "RESIZE NEEDED" or "CAPACITY SUFFICIENT"
4. After all additions, print final size

**Input Format:**
- First line: N (initial elements)
- Second line: N integers
- Third line: M (additional elements to check)

**Constraints:**
- 1 ≤ N ≤ 100
- 1 ≤ M ≤ 100
- Initial capacity = 10

**Output Format:**
- Line 1: RESIZE NEEDED or CAPACITY SUFFICIENT
- Line 2: Final size after adding M elements (add values 1 to M)

**Sample Input:**
```
8
1 2 3 4 5 6 7 8
5
```

**Sample Output:**
```
RESIZE NEEDED
13
```

**Explanation:**
Initial capacity 10, size 8. Need to add 5 more (total 13). 10 < 13, so resize needed.

---

### Problem 8.8: Equals and Compare Lists (Medium)
**Difficulty:** Medium

**Problem Statement:**
You are given two ArrayLists A and B. Check if they are:
1. Equal (same elements in same order)
2. Same size
3. Contain same elements (ignoring order)

**Input Format:**
- First line: N
- Second line: N integers for A
- Third line: M
- Fourth line: M integers for B

**Constraints:**
- 1 ≤ N, M ≤ 1000

**Output Format:**
- Line 1: "EQUAL" or "NOT EQUAL"
- Line 2: "SAME SIZE" or "DIFFERENT SIZE"
- Line 3: "SAME ELEMENTS" or "DIFFERENT ELEMENTS"

**Sample Input 1:**
```
4
1 2 3 4
4
1 2 3 4
```

**Sample Output 1:**
```
EQUAL
SAME SIZE
SAME ELEMENTS
```

**Sample Input 2:**
```
4
1 2 3 4
4
4 3 2 1
```

**Sample Output 2:**
```
NOT EQUAL
SAME SIZE
SAME ELEMENTS
```

---

### Problem 8.9: ForEach and Iterator (Advanced)
**Difficulty:** Hard

**Problem Statement:**
You are given N integers in an ArrayList. Remove all elements divisible by K using iterator, then print:
1. Elements removed
2. Remaining elements
3. Sum of remaining elements using forEach

**Input Format:**
- First line: N and K
- Second line: N integers

**Constraints:**
- 1 ≤ N ≤ 1000
- 1 ≤ K ≤ 100

**Output Format:**
- Line 1: Count of removed elements
- Line 2: Remaining elements
- Line 3: Sum of remaining elements

**Sample Input:**
```
8 3
3 5 6 7 9 12 15 20
```

**Sample Output:**
```
4
5 7 20
32
```

**Explanation:**
Removed: 3, 6, 9, 12, 15 (divisible by 3)
Remaining: 5, 7, 20
Sum: 5+7+20 = 32

---

### Problem 8.10: ListIterator Bidirectional (Advanced)
**Difficulty:** Hard

**Problem Statement:**
You are given an ArrayList of N integers. Using ListIterator:
1. Print elements forward
2. Print elements backward
3. Print elements at even indices only

**Input Format:**
- First line: N
- Second line: N integers

**Constraints:**
- 1 ≤ N ≤ 100

**Output Format:**
- Line 1: Forward traversal
- Line 2: Backward traversal
- Line 3: Even indices only (0, 2, 4...)

**Sample Input:**
```
6
10 20 30 40 50 60
```

**Sample Output:**
```
10 20 30 40 50 60
60 50 40 30 20 10
10 30 50
```

---

## Complete ArrayList Methods Coverage

### Methods Covered in Problems:

**Creation & Basic Operations:**
- `ArrayList()` - Problems 1.1, 1.2, 1.3
- `add(element)` - Problems 2.1
- `add(index, element)` - Problems 2.2, 2.3
- `get(index)` - Problems 3.1, 3.2, 3.3

**Modification:**
- `set(index, element)` - Problems 4.1, 4.2, 4.3
- `remove(index)` - Problems 5.1, 2.3
- `remove(Object)` - Problems 5.2
- `clear()` - Problem 8.2

**Search:**
- `contains(element)` - Problems 6.1
- `indexOf(element)` - Problems 6.2
- `lastIndexOf(element)` - Problems 6.2

**Size & Capacity:**
- `size()` - Problems 2.1, 8.2
- `isEmpty()` - Problem 8.2
- `ensureCapacity()` - Problem 8.7
- `trimToSize()` - Problem 8.7

**Bulk Operations:**
- `addAll(collection)` - Problem 8.3
- `removeAll(collection)` - Problem 8.3
- `retainAll(collection)` - Problem 8.4

**Conversion & Comparison:**
- `toArray()` - Problem 8.6
- `equals(Object)` - Problem 8.8
- `clone()` - Problem 8.5

**Advanced:**
- `subList(from, to)` - Problem 8.1
- `iterator()` - Problem 8.9
- `listIterator()` - Problem 8.10
- `forEach()` - Problem 8.9
- `removeIf()` - Problem 5.3
- `replaceAll()` - Problem 4.2

**Collections Utility Methods:**
- `Collections.sort()` - Problems 7.1, 7.2, 7.3
- `Collections.reverse()` - Problem 7.1
- `Collections.min()`, `Collections.max()`
- `Collections.frequency()`
- `Collections.binarySearch()` - Problem 6.3
- `Collections.shuffle()`

---

## Practice Strategy

1. Start with **Basic** problems of each topic
2. Move to **Medium** after solving all Basic
3. Attempt **Advanced** problems last
4. Try **Bonus** challenges for extra practice
5. Time yourself: Basic (10min), Medium (20min), Advanced (30min)

**Total Problems: 35**
- Basic: 10
- Medium: 12
- Advanced: 9
- Bonus: 4

## Complete Method Checklist ✅

✅ Creation: `ArrayList()`, `ArrayList(capacity)`, `ArrayList(collection)`
✅ Add: `add()`, `add(index, element)`, `addAll()`
✅ Access: `get()`, `indexOf()`, `lastIndexOf()`, `contains()`
✅ Update: `set()`, `replaceAll()`
✅ Remove: `remove(index)`, `remove(Object)`, `removeAll()`, `retainAll()`, `removeIf()`, `clear()`
✅ Size: `size()`, `isEmpty()`
✅ Capacity: `ensureCapacity()`, `trimToSize()`
✅ Convert: `toArray()`, `clone()`
✅ Iterate: `iterator()`, `listIterator()`, `forEach()`
✅ Other: `subList()`, `equals()`

**All ArrayList methods covered! No method left behind!** 🎯

Good luck! 🚀