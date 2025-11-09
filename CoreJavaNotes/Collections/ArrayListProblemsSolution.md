// ============================================
// TOPIC 1: ARRAYLIST CREATION & INITIALIZATION
// ============================================

// Problem 1.1: Simple List Creation (Basic)
import java.util.*;

class Problem1_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            list.add(i);
        }
        
        for(int num : list) {
            System.out.print(num + " ");
        }
    }
}

// Problem 1.2: Initialize from Input (Medium)
class Problem1_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        
        // Remove duplicates using LinkedHashSet (maintains order)
        ArrayList<Integer> unique = new ArrayList<>(new LinkedHashSet<>(list));
        
        for(int num : unique) {
            System.out.print(num + " ");
        }
    }
}

// Problem 1.3: Multiple ArrayLists Creation (Advanced)
class Problem1_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        
        for(int i = 0; i < n; i++) {
            int d = sc.nextInt();
            ArrayList<Integer> currentList = new ArrayList<>();
            for(int j = 0; j < d; j++) {
                currentList.add(sc.nextInt());
            }
            lists.add(currentList);
        }
        
        int q = sc.nextInt();
        for(int i = 0; i < q; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            
            try {
                System.out.println(lists.get(x - 1).get(y - 1));
            } catch(Exception e) {
                System.out.println("ERROR!");
            }
        }
    }
}

// ============================================
// TOPIC 2: INSERT OPERATIONS
// ============================================

// Problem 2.1: Add Elements (Basic)
class Problem2_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        
        System.out.println(list.size());
        for(int num : list) {
            System.out.print(num + " ");
        }
    }
}

// Problem 2.2: Insert at Position (Medium)
class Problem2_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        
        int q = sc.nextInt();
        for(int i = 0; i < q; i++) {
            String operation = sc.next();
            if(operation.equals("Insert")) {
                int index = sc.nextInt();
                int value = sc.nextInt();
                list.add(index, value);
            }
        }
        
        for(int num : list) {
            System.out.print(num + " ");
        }
    }
}

// Problem 2.3: Insert and Delete Queries (Advanced)
class Problem2_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        
        int q = sc.nextInt();
        for(int i = 0; i < q; i++) {
            String operation = sc.next();
            if(operation.equals("Insert")) {
                int index = sc.nextInt();
                int value = sc.nextInt();
                list.add(index, value);
            } else if(operation.equals("Delete")) {
                int index = sc.nextInt();
                list.remove(index);
            }
        }
        
        for(int num : list) {
            System.out.print(num + " ");
        }
    }
}

// ============================================
// TOPIC 3: ACCESS OPERATIONS
// ============================================

// Problem 3.1: Access by Index (Basic)
class Problem3_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        
        int q = sc.nextInt();
        for(int i = 0; i < q; i++) {
            int index = sc.nextInt();
            if(index >= 0 && index < list.size()) {
                System.out.println(list.get(index));
            } else {
                System.out.println("Invalid Index");
            }
        }
    }
}

// Problem 3.2: Find All Occurrences (Medium)
class Problem3_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        
        int target = sc.nextInt();
        ArrayList<Integer> indices = new ArrayList<>();
        
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i) == target) {
                indices.add(i);
            }
        }
        
        if(indices.isEmpty()) {
            System.out.println("Not Found");
        } else {
            for(int idx : indices) {
                System.out.print(idx + " ");
            }
        }
    }
}

// Problem 3.3: Nested ArrayList Query (Advanced)
class Problem3_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        ArrayList<ArrayList<Integer>> students = new ArrayList<>();
        
        for(int i = 0; i < n; i++) {
            int m = sc.nextInt();
            ArrayList<Integer> marks = new ArrayList<>();
            for(int j = 0; j < m; j++) {
                marks.add(sc.nextInt());
            }
            students.add(marks);
        }
        
        int q = sc.nextInt();
        for(int i = 0; i < q; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            
            try {
                System.out.println(students.get(x - 1).get(y - 1));
            } catch(Exception e) {
                System.out.println("ERROR!");
            }
        }
    }
}

// ============================================
// TOPIC 4: UPDATE OPERATIONS
// ============================================

// Problem 4.1: Update at Index (Basic)
class Problem4_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        
        int q = sc.nextInt();
        for(int i = 0; i < q; i++) {
            int index = sc.nextInt();
            int value = sc.nextInt();
            list.set(index, value);
        }
        
        for(int num : list) {
            System.out.print(num + " ");
        }
    }
}

// Problem 4.2: Transform Elements (Medium)
class Problem4_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        
        for(int i = 0; i < list.size(); i++) {
            int num = list.get(i);
            if(num % 2 == 0) {
                list.set(i, num * 2);
            } else {
                list.set(i, num + 1);
            }
        }
        
        for(int num : list) {
            System.out.print(num + " ");
        }
    }
}

// Problem 4.3: Conditional Bulk Update (Advanced)
class Problem4_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        
        // Transform elements
        for(int i = 0; i < list.size(); i++) {
            int num = list.get(i);
            if(num % 3 == 0) {
                list.set(i, num / 3);
            } else if(num % 2 == 0) {
                list.set(i, num * 2);
            } else {
                list.set(i, num + 5);
            }
        }
        
        // Remove elements > 100
        list.removeIf(num -> num > 100);
        
        for(int num : list) {
            System.out.print(num + " ");
        }
    }
}

// ============================================
// TOPIC 5: DELETE OPERATIONS
// ============================================

// Problem 5.1: Remove by Index (Basic)
class Problem5_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        
        int q = sc.nextInt();
        for(int i = 0; i < q; i++) {
            int index = sc.nextInt();
            list.remove(index);
        }
        
        for(int num : list) {
            System.out.print(num + " ");
        }
    }
}

// Problem 5.2: Remove All Occurrences (Medium)
class Problem5_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        
        int x = sc.nextInt();
        int count = 0;
        
        while(list.remove(Integer.valueOf(x))) {
            count++;
        }
        
        System.out.println(count);
        if(list.isEmpty()) {
            System.out.println("Empty");
        } else {
            for(int num : list) {
                System.out.print(num + " ");
            }
        }
    }
}

// Problem 5.3: Conditional Remove (Advanced)
class Problem5_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        
        int k = sc.nextInt();
        int min = sc.nextInt();
        
        int initialSize = list.size();
        
        // Remove elements
        list.removeIf(num -> isPrime(num) || num % k == 0 || num < min);
        
        int removedCount = initialSize - list.size();
        
        System.out.println(removedCount);
        if(list.isEmpty()) {
            System.out.println("Empty");
        } else {
            for(int num : list) {
                System.out.print(num + " ");
            }
        }
    }
    
    static boolean isPrime(int n) {
        if(n < 2) return false;
        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0) return false;
        }
        return true;
    }
}

// ============================================
// TOPIC 6: SEARCH OPERATIONS
// ============================================

// Problem 6.1: Element Exists (Basic)
class Problem6_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        
        int q = sc.nextInt();
        for(int i = 0; i < q; i++) {
            int value = sc.nextInt();
            if(list.contains(value)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}

// Problem 6.2: First and Last Position (Medium)
class Problem6_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        
        int target = sc.nextInt();
        
        int first = list.indexOf(target);
        int last = list.lastIndexOf(target);
        
        System.out.println(first + " " + last);
    }
}

// Problem 6.3: Search in Rotated Array (Advanced)
class Problem6_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        
        int target = sc.nextInt();
        int result = searchRotated(list, target);
        
        System.out.println(result);
    }
    
    static int searchRotated(ArrayList<Integer> list, int target) {
        int left = 0, right = list.size() - 1;
        
        while(left <= right) {
            int mid = left + (right - left) / 2;
            
            if(list.get(mid) == target) {
                return mid;
            }
            
            // Check which half is sorted
            if(list.get(left) <= list.get(mid)) {
                // Left half is sorted
                if(target >= list.get(left) && target < list.get(mid)) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                // Right half is sorted
                if(target > list.get(mid) && target <= list.get(right)) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        
        return -1;
    }
}

// ============================================
// TOPIC 7: SORTING OPERATIONS
// ============================================

// Problem 7.1: Basic Sort (Basic)
class Problem7_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        
        // Ascending
        Collections.sort(list);
        for(int num : list) {
            System.out.print(num + " ");
        }
        System.out.println();
        
        // Descending
        Collections.sort(list, Collections.reverseOrder());
        for(int num : list) {
            System.out.print(num + " ");
        }
    }
}

// Problem 7.2: Sort Students by Marks (Medium)
class Student {
    String name;
    int marks;
    
    Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }
}

class Problem7_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        ArrayList<Student> students = new ArrayList<>();
        
        for(int i = 0; i < n; i++) {
            String name = sc.next();
            int marks = sc.nextInt();
            students.add(new Student(name, marks));
        }
        
        Collections.sort(students, (s1, s2) -> {
            if(s1.marks != s2.marks) {
                return s2.marks - s1.marks; // Descending by marks
            }
            return s1.name.compareTo(s2.name); // Ascending by name
        });
        
        for(Student s : students) {
            System.out.println(s.name + " " + s.marks);
        }
    }
}

// Problem 7.3: Multi-criteria Sorting (Advanced)
class Employee {
    String name;
    int age;
    int salary;
    
    Employee(String name, int age, int salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
}

class Problem7_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        ArrayList<Employee> employees = new ArrayList<>();
        
        for(int i = 0; i < n; i++) {
            String name = sc.next();
            int age = sc.nextInt();
            int salary = sc.nextInt();
            employees.add(new Employee(name, age, salary));
        }
        
        Collections.sort(employees, (e1, e2) -> {
            if(e1.age != e2.age) {
                return e1.age - e2.age; // Ascending by age
            }
            if(e1.salary != e2.salary) {
                return e2.salary - e1.salary; // Descending by salary
            }
            return e1.name.compareTo(e2.name); // Ascending by name
        });
        
        for(Employee e : employees) {
            System.out.println(e.name + " " + e.age + " " + e.salary);
        }
    }
}

// ============================================
// TOPIC 8: ADDITIONAL ARRAYLIST METHODS
// ============================================

// Problem 8.1: SubList Operations (Basic)
class Problem8_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        
        int q = sc.nextInt();
        for(int i = 0; i < q; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            
            List<Integer> sublist = list.subList(start, end);
            for(int num : sublist) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

// Problem 8.2: Clear and isEmpty Check (Basic)
class Problem8_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        
        int q = sc.nextInt();
        for(int i = 0; i < q; i++) {
            String operation = sc.next();
            
            if(operation.equals("SIZE")) {
                System.out.println(list.size());
            } else if(operation.equals("EMPTY")) {
                System.out.println(list.isEmpty() ? "YES" : "NO");
            } else if(operation.equals("CLEAR")) {
                list.clear();
            }
        }
    }
}

// Problem 8.3: AddAll and RemoveAll (Medium)
class Problem8_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        ArrayList<Integer> listA = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            listA.add(sc.nextInt());
        }
        
        int m = sc.nextInt();
        ArrayList<Integer> listB = new ArrayList<>();
        for(int i = 0; i < m; i++) {
            listB.add(sc.nextInt());
        }
        
        // AddAll
        listA.addAll(listB);
        for(int num : listA) {
            System.out.print(num + " ");
        }
        System.out.println();
        
        // RemoveAll
        listA.removeAll(listB);
        for(int num : listA) {
            System.out.print(num + " ");
        }
    }
}

// Problem 8.4: RetainAll Operation (Medium)
class Problem8_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        ArrayList<Integer> listA = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            listA.add(sc.nextInt());
        }
        
        int m = sc.nextInt();
        ArrayList<Integer> listB = new ArrayList<>();
        for(int i = 0; i < m; i++) {
            listB.add(sc.nextInt());
        }
        
        listA.retainAll(listB);
        
        for(int num : listA) {
            System.out.print(num + " ");
        }
    }
}

// Problem 8.5: Clone ArrayList (Medium)
class Problem8_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        ArrayList<Integer> original = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            original.add(sc.nextInt());
        }
        
        // Clone
        ArrayList<Integer> cloned = new ArrayList<>(original);
        
        // Modify original
        for(int i = 0; i < original.size(); i++) {
            original.set(i, original.get(i) * 2);
        }
        
        // Print both
        for(int num : original) {
            System.out.print(num + " ");
        }
        System.out.println();
        
        for(int num : cloned) {
            System.out.print(num + " ");
        }
    }
}

// Problem 8.6: ToArray Conversion (Basic)
class Problem8_6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        
        Integer[] array = list.toArray(new Integer[0]);
        
        // Print array
        for(int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
        
        // Print length
        System.out.println(array.length);
        
        // Print middle element
        System.out.println(array[array.length / 2]);
    }
}

// Problem 8.7: EnsureCapacity and TrimToSize (Advanced)
class Problem8_7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        
        int m = sc.nextInt();
        
        // Check capacity (assuming default 10)
        int currentCapacity = 10;
        while(currentCapacity < n) {
            currentCapacity = (currentCapacity * 3) / 2 + 1;
        }
        
        if(n + m > currentCapacity) {
            System.out.println("RESIZE NEEDED");
        } else {
            System.out.println("CAPACITY SUFFICIENT");
        }
        
        // Add M elements
        for(int i = 1; i <= m; i++) {
            list.add(i);
        }
        
        System.out.println(list.size());
    }
}

// Problem 8.8: Equals and Compare Lists (Medium)
class Problem8_8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        ArrayList<Integer> listA = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            listA.add(sc.nextInt());
        }
        
        int m = sc.nextInt();
        ArrayList<Integer> listB = new ArrayList<>();
        for(int i = 0; i < m; i++) {
            listB.add(sc.nextInt());
        }
        
        // Equal check
        System.out.println(listA.equals(listB) ? "EQUAL" : "NOT EQUAL");
        
        // Size check
        System.out.println(n == m ? "SAME SIZE" : "DIFFERENT SIZE");
        
        // Same elements check
        HashSet<Integer> setA = new HashSet<>(listA);
        HashSet<Integer> setB = new HashSet<>(listB);
        System.out.println(setA.equals(setB) ? "SAME ELEMENTS" : "DIFFERENT ELEMENTS");
    }
}

// Problem 8.9: ForEach and Iterator (Advanced)
class Problem8_9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int k = sc.nextInt();
        
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        
        int count = 0;
        Iterator<Integer> itr = list.iterator();
        while(itr.hasNext()) {
            int num = itr.next();
            if(num % k == 0) {
                itr.remove();
                count++;
            }
        }
        
        System.out.println(count);
        
        for(int num : list) {
            System.out.print(num + " ");
        }
        System.out.println();
        
        // Sum using forEach
        int sum = 0;
        for(int num : list) {
            sum += num;
        }
        System.out.println(sum);
    }
}

// Problem 8.10: ListIterator Bidirectional (Advanced)
class Problem8_10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        
        // Forward
        ListIterator<Integer> itr = list.listIterator();
        while(itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }
        System.out.println();
        
        // Backward
        while(itr.hasPrevious()) {
            System.out.print(itr.previous() + " ");
        }
        System.out.println();
        
        // Even indices
        for(int i = 0; i < list.size(); i += 2) {
            System.out.print(list.get(i) + " ");
        }
    }
}

// ============================================
// BONUS CHALLENGE PROBLEMS
// ============================================

// Problem B.1: Merge Two Sorted Lists
class ProblemB_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        ArrayList<Integer> list1 = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            list1.add(sc.nextInt());
        }
        
        int m = sc.nextInt();
        ArrayList<Integer> list2 = new ArrayList<>();
        for(int i = 0; i < m; i++) {
            list2.add(sc.nextInt());
        }
        
        ArrayList<Integer> merged = new ArrayList<>();
        int i = 0, j = 0;
        
        while(i < list1.size() && j < list2.size()) {
            if(list1.get(i) <= list2.get(j)) {
                merged.add(list1.get(i));
                i++;
            } else {
                merged.add(list2.get(j));
                j++;
            }
        }
        
        while(i < list1.size()) {
            merged.add(list1.get(i));
            i++;
        }
        
        while(j < list2.size()) {
            merged.add(list2.get(j));
            j++;
        }
        
        for(int num : merged) {
            System.out.print(num + " ");
        }
    }
}

// Problem B.2: Remove Duplicates and Sort
class ProblemB_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        
        int k = sc.nextInt();
        
        // Remove duplicates
        ArrayList


        