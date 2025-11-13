# LinkedList Practice Problems - Complete Solutions

## Topic 1: LinkedList Creation & Initialization

### Problem 1.1: Basic LinkedList Creation (Basic)

```java
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        
        System.out.println(list.getFirst());
        System.out.println(list.getLast());
        System.out.println(list.size());
    }
}
```

---

### Problem 1.2: Initialize from Array (Medium)

```java
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        
        // Reverse without Collections.reverse()
        LinkedList<Integer> reversed = new LinkedList<>();
        while (!list.isEmpty()) {
            reversed.add(list.removeLast());
        }
        
        for (int i = 0; i < reversed.size(); i++) {
            System.out.print(reversed.get(i));
            if (i < reversed.size() - 1) System.out.print(" ");
        }
        System.out.println();
    }
}
```

---

### Problem 1.3: Create from Multiple Inputs (Advanced)

```java
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        ArrayList<LinkedList<Integer>> lists = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            int d = sc.nextInt();
            LinkedList<Integer> list = new LinkedList<>();
            for (int j = 0; j < d; j++) {
                list.add(sc.nextInt());
            }
            lists.add(list);
        }
        
        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            
            if (x > 0 && x <= lists.size()) {
                LinkedList<Integer> targetList = lists.get(x - 1);
                if (y >= 0 && y < targetList.size()) {
                    System.out.println(targetList.get(y));
                } else {
                    System.out.println("ERROR!");
                }
            } else {
                System.out.println("ERROR!");
            }
        }
    }
}
```

---

## Topic 2: AddFirst & AddLast Operations

### Problem 2.1: Build Queue (Basic)

```java
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        
        LinkedList<Integer> list = new LinkedList<>();
        
        for (int i = 0; i < n; i++) {
            String[] op = sc.nextLine().split(" ");
            int value = Integer.parseInt(op[1]);
            
            if (op[0].equals("ADDFIRST")) {
                list.addFirst(value);
            } else if (op[0].equals("ADDLAST")) {
                list.addLast(value);
            }
        }
        
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            if (i < list.size() - 1) System.out.print(" ");
        }
        System.out.println();
    }
}
```

---

### Problem 2.2: Alternating Insert (Medium)

```java
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        LinkedList<Integer> a = new LinkedList<>();
        LinkedList<Integer> b = new LinkedList<>();
        
        for (int i = 0; i < n; i++) {
            a.add(sc.nextInt());
        }
        for (int i = 0; i < n; i++) {
            b.add(sc.nextInt());
        }
        
        LinkedList<Integer> result = new LinkedList<>();
        
        for (int i = 0; i < n; i++) {
            result.add(a.removeFirst());
            result.add(b.removeLast());
        }
        
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i));
            if (i < result.size() - 1) System.out.print(" ");
        }
        System.out.println();
    }
}
```

---

### Problem 2.3: Priority Queue Simulation (Advanced)

```java
import java.util.*;

public class Solution {
    static class Item {
        int value;
        int priority;
        
        Item(int value, int priority) {
            this.value = value;
            this.priority = priority;
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        
        LinkedList<Item> queue = new LinkedList<>();
        
        for (int i = 0; i < n; i++) {
            String[] op = sc.nextLine().split(" ");
            
            if (op[0].equals("INSERT")) {
                int value = Integer.parseInt(op[1]);
                int priority = Integer.parseInt(op[2]);
                
                // Insert in sorted order by priority
                int pos = 0;
                for (Item item : queue) {
                    if (priority < item.priority) {
                        break;
                    }
                    pos++;
                }
                queue.add(pos, new Item(value, priority));
                
            } else if (op[0].equals("PEEK")) {
                System.out.println(queue.getFirst().value);
                
            } else if (op[0].equals("REMOVE")) {
                Item removed = queue.removeFirst();
                System.out.println("Removed: " + removed.value);
            }
        }
        
        for (int i = 0; i < queue.size(); i++) {
            System.out.print(queue.get(i).value);
            if (i < queue.size() - 1) System.out.print(" ");
        }
        System.out.println();
    }
}
```

---

## Topic 3: RemoveFirst & RemoveLast Operations

### Problem 3.1: Basic Remove Operations (Basic)

```java
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        
        int q = sc.nextInt();
        sc.nextLine();
        
        for (int i = 0; i < q; i++) {
            String op = sc.nextLine();
            
            if (op.equals("REMOVEFIRST")) {
                list.removeFirst();
            } else if (op.equals("REMOVELAST")) {
                list.removeLast();
            } else if (op.equals("PRINT")) {
                for (int j = 0; j < list.size(); j++) {
                    System.out.print(list.get(j));
                    if (j < list.size() - 1) System.out.print(" ");
                }
                System.out.println();
            }
        }
    }
}
```

---

### Problem 3.2: Deque Operations (Medium)

```java
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        
        LinkedList<Integer> deque = new LinkedList<>();
        
        for (int i = 0; i < n; i++) {
            String[] op = sc.nextLine().split(" ");
            
            if (op[0].equals("PUSHFRONT")) {
                deque.addFirst(Integer.parseInt(op[1]));
            } else if (op[0].equals("PUSHBACK")) {
                deque.addLast(Integer.parseInt(op[1]));
            } else if (op[0].equals("POPFRONT")) {
                System.out.println("Removed: " + deque.removeFirst());
            } else if (op[0].equals("POPBACK")) {
                System.out.println("Removed: " + deque.removeLast());
            }
        }
        
        for (int i = 0; i < deque.size(); i++) {
            System.out.print(deque.get(i));
            if (i < deque.size() - 1) System.out.print(" ");
        }
        System.out.println();
    }
}
```

---

### Problem 3.3: Palindrome Checker (Advanced)

```java
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        
        boolean isPalindrome = true;
        int first = -1, last = -1;
        
        while (list.size() > 1) {
            first = list.removeFirst();
            last = list.removeLast();
            
            if (first != last) {
                isPalindrome = false;
                break;
            }
        }
        
        if (isPalindrome) {
            System.out.println("YES");
        } else {
            System.out.println("NO " + first + " " + last);
        }
    }
}
```

---

## Topic 4: GetFirst, GetLast, Peek Operations

### Problem 4.1: Queue Peek Operations (Basic)

```java
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            queue.add(sc.nextInt());
        }
        
        int q = sc.nextInt();
        sc.nextLine();
        
        for (int i = 0; i < q; i++) {
            String query = sc.nextLine();
            
            if (query.equals("PEEKFIRST")) {
                System.out.println(queue.getFirst());
            } else if (query.equals("PEEKLAST")) {
                System.out.println(queue.getLast());
            } else if (query.equals("SIZE")) {
                System.out.println(queue.size());
            }
        }
    }
}
```

---

### Problem 4.2: Sliding Window Maximum (Medium)

```java
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        LinkedList<Integer> window = new LinkedList<>();
        
        for (int i = 0; i < n; i++) {
            window.add(arr[i]);
            
            if (window.size() == k) {
                int max = window.getFirst();
                for (int num : window) {
                    max = Math.max(max, num);
                }
                System.out.print(max);
                if (i < n - 1) System.out.print(" ");
                window.removeFirst();
            }
        }
        System.out.println();
    }
}
```

---

### Problem 4.3: Recent Counter (Advanced)

```java
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        LinkedList<Integer> requests = new LinkedList<>();
        
        for (int i = 0; i < n; i++) {
            int timestamp = sc.nextInt();
            requests.add(timestamp);
            
            // Remove requests older than 3000ms
            while (!requests.isEmpty() && requests.getFirst() < timestamp - 3000) {
                requests.removeFirst();
            }
            
            System.out.println(requests.size());
        }
    }
}
```

---

## Topic 5: Offer and Poll Operations (Queue)

### Problem 5.1: Simple Queue (Basic)

```java
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        
        LinkedList<Integer> queue = new LinkedList<>();
        
        for (int i = 0; i < n; i++) {
            String[] op = sc.nextLine().split(" ");
            
            if (op[0].equals("OFFER")) {
                queue.offer(Integer.parseInt(op[1]));
            } else if (op[0].equals("POLL")) {
                System.out.println(queue.poll());
            }
        }
        
        for (int i = 0; i < queue.size(); i++) {
            System.out.print(queue.get(i));
            if (i < queue.size() - 1) System.out.print(" ");
        }
        System.out.println();
    }
}
```

---

### Problem 5.2: Task Scheduler (Medium)

```java
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        
        LinkedList<String> taskQueue = new LinkedList<>();
        
        for (int i = 0; i < n; i++) {
            String[] op = sc.nextLine().split(" ");
            
            if (op[0].equals("OFFER")) {
                taskQueue.offer(op[1]);
            } else if (op[0].equals("EXECUTE")) {
                if (!taskQueue.isEmpty()) {
                    System.out.println(taskQueue.poll());
                }
            }
        }
        
        for (int i = 0; i < taskQueue.size(); i++) {
            System.out.print(taskQueue.get(i));
            if (i < taskQueue.size() - 1) System.out.print(" ");
        }
        if (!taskQueue.isEmpty()) System.out.println();
    }
}
```

---

### Problem 5.3: Circular Queue (Advanced)

```java
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        sc.nextLine();
        
        LinkedList<Integer> queue = new LinkedList<>();
        
        for (int i = 0; i < n; i++) {
            String[] op = sc.nextLine().split(" ");
            
            if (op[0].equals("OFFER")) {
                int value = Integer.parseInt(op[1]);
                if (queue.size() < k) {
                    queue.offer(value);
                    System.out.println("Added");
                } else {
                    System.out.println("Queue Full");
                }
            } else if (op[0].equals("POLL")) {
                if (!queue.isEmpty()) {
                    System.out.println(queue.poll());
                } else {
                    System.out.println("Queue Empty");
                }
            } else if (op[0].equals("FULL")) {
                System.out.println(queue.size() == k ? "YES" : "NO");
            }
        }
        
        for (int i = 0; i < queue.size(); i++) {
            System.out.print(queue.get(i));
            if (i < queue.size() - 1) System.out.print(" ");
        }
        System.out.println();
    }
}
```

---

## Topic 6: Element and Get Operations

### Problem 6.1: Access Elements (Basic)

```java
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        
        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int index = sc.nextInt();
            System.out.println(list.get(index));
        }
    }
}
```

---

### Problem 6.2: Find Middle Element (Medium)

```java
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        
        int mid = n / 2;
        
        if (n % 2 == 1) {
            System.out.println(list.get(mid));
        } else {
            System.out.println(list.get(mid - 1) + " " + list.get(mid));
        }
    }
}
```

---

### Problem 6.3: Nth Node from End (Advanced)

```java
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        
        // Two pointer technique
        // Move first pointer k steps ahead
        int index = n - k;
        System.out.println(list.get(index));
    }
}
```

---

## Topic 7: Set and IndexOf Operations

### Problem 7.1: Update Elements (Basic)

```java
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        
        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int index = sc.nextInt();
            int value = sc.nextInt();
            list.set(index, value);
        }
        
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            if (i < list.size() - 1) System.out.print(" ");
        }
        System.out.println();
    }
}
```

---

### Problem 7.2: Swap Elements (Medium)

```java
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        
        int x = sc.nextInt();
        int y = sc.nextInt();
        
        int indexX = list.indexOf(x);
        int indexY = list.indexOf(y);
        
        list.set(indexX, y);
        list.set(indexY, x);
        
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            if (i < list.size() - 1) System.out.print(" ");
        }
        System.out.println();
    }
}
```

---

### Problem 7.3: Move Element to Front (Advanced)

```java
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        
        int x = sc.nextInt();
        
        LinkedList<Integer> result = new LinkedList<>();
        LinkedList<Integer> others = new LinkedList<>();
        
        for (int num : list) {
            if (num == x) {
                result.add(num);
            } else {
                others.add(num);
            }
        }
        
        result.addAll(others);
        
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i));
            if (i < result.size() - 1) System.out.print(" ");
        }
        System.out.println();
    }
}
```

---

## Topic 8: Clone and Clear Operations

### Problem 8.1: Clone and Modify (Basic)

```java
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        LinkedList<Integer> original = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            original.add(sc.nextInt());
        }
        
        LinkedList<Integer> clone = (LinkedList<Integer>) original.clone();
        
        // Modify original
        for (int i = 0; i < original.size(); i++) {
            original.set(i, original.get(i) * 2);
        }
        
        // Print modified original
        for (int i = 0; i < original.size(); i++) {
            System.out.print(original.get(i));
            if (i < original.size() - 1) System.out.print(" ");
        }
        System.out.println();
        
        // Print clone
        for (int i = 0; i < clone.size(); i++) {
            System.out.print(clone.get(i));
            if (i < clone.size() - 1) System.out.print(" ");
        }
        System.out.println();
    }
}
```

---

### Problem 8.2: Partial Clear (Medium)

```java
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        
        int l = sc.nextInt();
        int r = sc.nextInt();
        
        // Remove elements from L to R (inclusive)
        for (int i = 0; i <= r - l; i++) {
            list.remove(l);
        }
        
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            if (i < list.size() - 1) System.out.print(" ");
        }
        System.out.println();
    }
}
```

---

### Problem 8.3: Snapshot and Restore (Advanced)

```java
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        
        LinkedList<Integer> list = new LinkedList<>();
        LinkedList<Integer> snapshot = null;
        
        for (int i = 0; i < n; i++) {
            String[] op = sc.nextLine().split(" ");
            
            if (op[0].equals("SNAPSHOT")) {
                snapshot = (LinkedList<Integer>) list.clone();
            } else if (op[0].equals("ADD")) {
                list.add(Integer.parseInt(op[1]));
            } else if (op[0].equals("REMOVE")) {
                if (!list.isEmpty()) {
                    list.removeFirst();
                }
            } else if (op[0].equals("RESTORE")) {
                if (snapshot != null) {
                    list = (LinkedList<Integer>) snapshot.clone();
                }
            }
        }
        
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            if (i < list.size() - 1) System.out.print(" ");
        }
        System.out.println();
    }
}
```

---

## Topic 9: Iterator Operations

### Problem 9.1: Descending Iterator (Basic)

```java
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        
        Iterator<Integer> it = list.descendingIterator();
        boolean first = true;
        
        while (it.hasNext()) {
            if (!first) System.out.print(" ");
            System.out.print(it.next());
            first = false;
        }
        System.out.println();
    }
}
```

---

### Problem 9.2: Remove While Iterating (Medium)

```java
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        
        Iterator<Integer> it = list.iterator();
        int count = 0;
        
        while (it.hasNext()) {
            int num = it.next();
            if (num % 2 == 0) {
                it.remove();
                count++;
            }
        }
        
        System.out.println(count);
        
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            if (i < list.size() - 1) System.out.print(" ");
        }
        System.out.println();
    }
}
```

---

### Problem 9.3: Custom Iterator Pattern (Advanced)

```java
import java.util.*;

public class Solution {
    static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        
        LinkedList<Integer> primes = new LinkedList<>();
        int sumNonPrimes = 0;
        
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            int num = it.next();
            if (isPrime(num)) {
                primes.add(num);
            } else {
                sumNonPrimes += num;
            }
        }
        
        for (int i = 0; i < primes.size(); i++) {
            System.out.print(primes.get(i));
            if (i < primes.size() - 1) System.out.print(" ");
        }
        System.out.println();
        System.out.println(sumNonPrimes);
    }
}
```

---

## Topic 10: Conversion Operations

### Problem 10.1: LinkedList to Array (Basic)

```java
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        
        Integer[] arr = list.toArray(new Integer[0]);
        
        for (int i = 0; i < arr.length; i++) {
            System.out.println(i + ": " + arr[i]);
        }
    }
}
```

---

### Problem 10.2: Array to LinkedList Performance (Medium)

```java
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(arr));
        
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int pos = sc.nextInt();
            int value = sc.nextInt();
            list.add(pos, value);
        }
        
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            if (i < list.size() - 1) System.out.print(" ");
        }
        System.out.println();
    }
}
```

---

### Problem 10.3: Stream Operations (Advanced)

```java
import java.util.*;
import java.util.stream.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        
        List<Integer> result = list.stream()
            .filter(x -> x %