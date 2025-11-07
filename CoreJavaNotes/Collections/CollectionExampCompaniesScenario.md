# Collections Framework - Real Applications in Top Product Companies

## 🏢 TOP 10 PRODUCT COMPANIES & THEIR USE CASES

---

## 1. GOOGLE - Search Engine & YouTube

### Use Case 1: Search Autocomplete System
**Problem**: When user types "jav", suggest "java", "javascript", "java tutorial"

```java
class AutocompleteSystem {
    // Trie node to store search queries
    class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        Map<String, Integer> suggestions = new HashMap<>(); // Query -> Frequency
    }
    
    private TrieNode root = new TrieNode();
    private String currentPrefix = "";
    
    // Load historical search data
    public AutocompleteSystem(String[] sentences, int[] times) {
        for (int i = 0; i < sentences.length; i++) {
            addSentence(sentences[i], times[i]);
        }
    }
    
    private void addSentence(String sentence, int count) {
        TrieNode node = root;
        for (char c : sentence.toCharArray()) {
            node.children.putIfAbsent(c, new TrieNode());
            node = node.children.get(c);
            node.suggestions.put(sentence, node.suggestions.getOrDefault(sentence, 0) + count);
        }
    }
    
    public List<String> input(char c) {
        if (c == '#') {
            addSentence(currentPrefix, 1);
            currentPrefix = "";
            return new ArrayList<>();
        }
        
        currentPrefix += c;
        TrieNode node = root;
        
        // Navigate to current prefix
        for (char ch : currentPrefix.toCharArray()) {
            if (!node.children.containsKey(ch)) {
                return new ArrayList<>();
            }
            node = node.children.get(ch);
        }
        
        // Get top 3 suggestions sorted by frequency
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
            (a, b) -> a.getValue() == b.getValue() ? 
                a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue()
        );
        
        pq.addAll(node.suggestions.entrySet());
        
        List<String> result = new ArrayList<>();
        for (int i = 0; i < 3 && !pq.isEmpty(); i++) {
            result.add(pq.poll().getKey());
        }
        return result;
    }
}

// Usage
String[] queries = {"java tutorial", "java interview", "javascript", "java basics"};
int[] times = {50, 30, 40, 20};
AutocompleteSystem system = new AutocompleteSystem(queries, times);

System.out.println(system.input('j'));    // [java tutorial, javascript, java interview]
System.out.println(system.input('a'));    // [java tutorial, javascript, java interview]
System.out.println(system.input('v'));    // [java tutorial, java interview, java basics]
```

### Use Case 2: YouTube Video Recommendation System
```java
class VideoRecommendation {
    // User -> List of watched videos
    Map<String, Set<String>> userWatchHistory = new HashMap<>();
    
    // Video -> Set of users who watched
    Map<String, Set<String>> videoViewers = new HashMap<>();
    
    // Video -> Category
    Map<String, String> videoCategory = new HashMap<>();
    
    public void watchVideo(String userId, String videoId, String category) {
        userWatchHistory.putIfAbsent(userId, new HashSet<>());
        userWatchHistory.get(userId).add(videoId);
        
        videoViewers.putIfAbsent(videoId, new HashSet<>());
        videoViewers.get(videoId).add(userId);
        
        videoCategory.put(videoId, category);
    }
    
    public List<String> recommendVideos(String userId, int limit) {
        Set<String> watchedVideos = userWatchHistory.getOrDefault(userId, new HashSet<>());
        Map<String, Integer> recommendationScore = new HashMap<>();
        
        // Find similar users (collaborative filtering)
        for (String watchedVideo : watchedVideos) {
            Set<String> similarUsers = videoViewers.get(watchedVideo);
            
            for (String similarUser : similarUsers) {
                if (similarUser.equals(userId)) continue;
                
                Set<String> theirVideos = userWatchHistory.get(similarUser);
                for (String video : theirVideos) {
                    if (!watchedVideos.contains(video)) {
                        recommendationScore.put(video, 
                            recommendationScore.getOrDefault(video, 0) + 1);
                    }
                }
            }
        }
        
        // Sort by score and return top recommendations
        List<Map.Entry<String, Integer>> sortedRecs = new ArrayList<>(recommendationScore.entrySet());
        sortedRecs.sort((a, b) -> b.getValue() - a.getValue());
        
        return sortedRecs.stream()
            .limit(limit)
            .map(Map.Entry::getKey)
            .collect(Collectors.toList());
    }
}

// Usage
VideoRecommendation vr = new VideoRecommendation();
vr.watchVideo("user1", "video1", "tech");
vr.watchVideo("user1", "video2", "tech");
vr.watchVideo("user2", "video1", "tech");
vr.watchVideo("user2", "video3", "tech");

List<String> recommendations = vr.recommendVideos("user1", 5);
System.out.println("Recommended: " + recommendations); // [video3]
```

---

## 2. AMAZON - E-Commerce Platform

### Use Case 1: Shopping Cart System
```java
class ShoppingCart {
    // Product ID -> Product details
    static class Product {
        String id;
        String name;
        double price;
        
        Product(String id, String name, double price) {
            this.id = id;
            this.name = name;
            this.price = price;
        }
    }
    
    // User ID -> Cart (Product ID -> Quantity)
    Map<String, Map<String, Integer>> userCarts = new HashMap<>();
    
    // Product catalog
    Map<String, Product> productCatalog = new HashMap<>();
    
    public void addProduct(Product product) {
        productCatalog.put(product.id, product);
    }
    
    public void addToCart(String userId, String productId, int quantity) {
        userCarts.putIfAbsent(userId, new HashMap<>());
        Map<String, Integer> cart = userCarts.get(userId);
        cart.put(productId, cart.getOrDefault(productId, 0) + quantity);
    }
    
    public void removeFromCart(String userId, String productId) {
        if (userCarts.containsKey(userId)) {
            userCarts.get(userId).remove(productId);
        }
    }
    
    public double getCartTotal(String userId) {
        if (!userCarts.containsKey(userId)) return 0.0;
        
        Map<String, Integer> cart = userCarts.get(userId);
        double total = 0.0;
        
        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            Product product = productCatalog.get(entry.getKey());
            total += product.price * entry.getValue();
        }
        
        return total;
    }
    
    public List<String> getCartItems(String userId) {
        if (!userCarts.containsKey(userId)) return new ArrayList<>();
        
        List<String> items = new ArrayList<>();
        Map<String, Integer> cart = userCarts.get(userId);
        
        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            Product product = productCatalog.get(entry.getKey());
            items.add(product.name + " x" + entry.getValue() + 
                     " = $" + (product.price * entry.getValue()));
        }
        
        return items;
    }
}

// Usage
ShoppingCart cart = new ShoppingCart();
cart.addProduct(new ShoppingCart.Product("p1", "Laptop", 999.99));
cart.addProduct(new ShoppingCart.Product("p2", "Mouse", 29.99));

cart.addToCart("user1", "p1", 1);
cart.addToCart("user1", "p2", 2);

System.out.println("Cart Items: " + cart.getCartItems("user1"));
System.out.println("Total: $" + cart.getCartTotal("user1")); // $1059.97
```

### Use Case 2: Product Inventory Management
```java
class InventorySystem {
    // Product ID -> Stock quantity
    Map<String, Integer> inventory = new HashMap<>();
    
    // Product ID -> List of warehouses having this product
    Map<String, List<String>> productWarehouses = new HashMap<>();
    
    // Warehouse ID -> Set of products
    Map<String, Set<String>> warehouseProducts = new HashMap<>();
    
    // Product orders queue (FIFO)
    Queue<Order> orderQueue = new LinkedList<>();
    
    static class Order {
        String orderId;
        String productId;
        int quantity;
        long timestamp;
        
        Order(String orderId, String productId, int quantity) {
            this.orderId = orderId;
            this.productId = productId;
            this.quantity = quantity;
            this.timestamp = System.currentTimeMillis();
        }
    }
    
    public void addStock(String productId, String warehouseId, int quantity) {
        inventory.put(productId, inventory.getOrDefault(productId, 0) + quantity);
        
        productWarehouses.putIfAbsent(productId, new ArrayList<>());
        if (!productWarehouses.get(productId).contains(warehouseId)) {
            productWarehouses.get(productId).add(warehouseId);
        }
        
        warehouseProducts.putIfAbsent(warehouseId, new HashSet<>());
        warehouseProducts.get(warehouseId).add(productId);
    }
    
    public boolean checkAvailability(String productId, int quantity) {
        return inventory.getOrDefault(productId, 0) >= quantity;
    }
    
    public boolean placeOrder(String orderId, String productId, int quantity) {
        if (!checkAvailability(productId, quantity)) {
            System.out.println("Out of stock!");
            return false;
        }
        
        orderQueue.offer(new Order(orderId, productId, quantity));
        inventory.put(productId, inventory.get(productId) - quantity);
        System.out.println("Order placed: " + orderId);
        return true;
    }
    
    public void processOrders() {
        while (!orderQueue.isEmpty()) {
            Order order = orderQueue.poll();
            System.out.println("Processing order: " + order.orderId + 
                             " for " + order.quantity + " units");
        }
    }
}

// Usage
InventorySystem inv = new InventorySystem();
inv.addStock("laptop", "warehouse1", 100);
inv.addStock("laptop", "warehouse2", 50);

inv.placeOrder("order1", "laptop", 5);
inv.placeOrder("order2", "laptop", 3);
inv.processOrders();
```

---

## 3. NETFLIX - Video Streaming Platform

### Use Case: Continue Watching & Watch History
```java
class NetflixWatchHistory {
    static class Video {
        String videoId;
        String title;
        int totalDuration; // in seconds
        
        Video(String videoId, String title, int totalDuration) {
            this.videoId = videoId;
            this.title = title;
            this.totalDuration = totalDuration;
        }
    }
    
    static class WatchProgress {
        String videoId;
        int watchedDuration;
        long lastWatched;
        
        WatchProgress(String videoId, int watchedDuration) {
            this.videoId = videoId;
            this.watchedDuration = watchedDuration;
            this.lastWatched = System.currentTimeMillis();
        }
    }
    
    // User -> List of watch history (most recent first)
    Map<String, LinkedList<WatchProgress>> watchHistory = new HashMap<>();
    
    // Video catalog
    Map<String, Video> videoCatalog = new HashMap<>();
    
    // User -> Continue watching (LinkedHashMap maintains order)
    Map<String, LinkedHashMap<String, WatchProgress>> continueWatching = new HashMap<>();
    
    public void addVideo(Video video) {
        videoCatalog.put(video.videoId, video);
    }
    
    public void updateWatchProgress(String userId, String videoId, int watchedSeconds) {
        Video video = videoCatalog.get(videoId);
        
        // Update watch history
        watchHistory.putIfAbsent(userId, new LinkedList<>());
        watchHistory.get(userId).addFirst(new WatchProgress(videoId, watchedSeconds));
        
        // Update continue watching if not completed
        if (watchedSeconds < video.totalDuration) {
            continueWatching.putIfAbsent(userId, new LinkedHashMap<>());
            continueWatching.get(userId).put(videoId, 
                new WatchProgress(videoId, watchedSeconds));
        } else {
            // Remove from continue watching if completed
            if (continueWatching.containsKey(userId)) {
                continueWatching.get(userId).remove(videoId);
            }
        }
    }
    
    public List<String> getContinueWatching(String userId) {
        List<String> result = new ArrayList<>();
        if (!continueWatching.containsKey(userId)) return result;
        
        LinkedHashMap<String, WatchProgress> userContinue = continueWatching.get(userId);
        for (String videoId : userContinue.keySet()) {
            Video video = videoCatalog.get(videoId);
            WatchProgress progress = userContinue.get(videoId);
            result.add(video.title + " (" + progress.watchedDuration + 
                      "s / " + video.totalDuration + "s)");
        }
        
        return result;
    }
    
    public List<String> getWatchHistory(String userId, int limit) {
        List<String> result = new ArrayList<>();
        if (!watchHistory.containsKey(userId)) return result;
        
        LinkedList<WatchProgress> history = watchHistory.get(userId);
        int count = 0;
        
        for (WatchProgress progress : history) {
            if (count++ >= limit) break;
            Video video = videoCatalog.get(progress.videoId);
            result.add(video.title);
        }
        
        return result;
    }
}

// Usage
NetflixWatchHistory netflix = new NetflixWatchHistory();
netflix.addVideo(new NetflixWatchHistory.Video("v1", "Stranger Things S1E1", 3000));
netflix.addVideo(new NetflixWatchHistory.Video("v2", "Breaking Bad S1E1", 2700));

netflix.updateWatchProgress("user1", "v1", 1500); // Watched half
netflix.updateWatchProgress("user1", "v2", 2700); // Completed

System.out.println("Continue Watching: " + netflix.getContinueWatching("user1"));
System.out.println("History: " + netflix.getWatchHistory("user1", 10));
```

---

## 4. UBER - Ride Sharing Platform

### Use Case: Nearby Drivers & Ride Matching
```java
class UberRideMatching {
    static class Driver {
        String driverId;
        String name;
        double latitude;
        double longitude;
        boolean available;
        
        Driver(String driverId, String name, double lat, double lon) {
            this.driverId = driverId;
            this.name = name;
            this.latitude = lat;
            this.longitude = lon;
            this.available = true;
        }
    }
    
    static class RideRequest {
        String requestId;
        String userId;
        double pickupLat;
        double pickupLon;
        long timestamp;
        
        RideRequest(String requestId, String userId, double lat, double lon) {
            this.requestId = requestId;
            this.userId = userId;
            this.pickupLat = lat;
            this.pickupLon = lon;
            this.timestamp = System.currentTimeMillis();
        }
    }
    
    // Driver pool
    Map<String, Driver> drivers = new HashMap<>();
    
    // Pending ride requests (priority by timestamp)
    PriorityQueue<RideRequest> pendingRequests = new PriorityQueue<>(
        Comparator.comparingLong(r -> r.timestamp)
    );
    
    // Active rides
    Map<String, String> activeRides = new HashMap<>(); // RequestId -> DriverId
    
    public void registerDriver(Driver driver) {
        drivers.put(driver.driverId, driver);
    }
    
    public void requestRide(RideRequest request) {
        pendingRequests.offer(request);
        System.out.println("Ride requested: " + request.requestId);
        matchRide(request);
    }
    
    private void matchRide(RideRequest request) {
        // Find nearest available driver
        Driver nearestDriver = null;
        double minDistance = Double.MAX_VALUE;
        
        for (Driver driver : drivers.values()) {
            if (!driver.available) continue;
            
            double distance = calculateDistance(
                request.pickupLat, request.pickupLon,
                driver.latitude, driver.longitude
            );
            
            if (distance < minDistance) {
                minDistance = distance;
                nearestDriver = driver;
            }
        }
        
        if (nearestDriver != null && minDistance <= 5.0) { // Within 5 km
            nearestDriver.available = false;
            activeRides.put(request.requestId, nearestDriver.driverId);
            pendingRequests.remove(request);
            
            System.out.println("Ride matched! Driver: " + nearestDriver.name + 
                             ", Distance: " + String.format("%.2f", minDistance) + " km");
        } else {
            System.out.println("No drivers available nearby");
        }
    }
    
    public void completeRide(String requestId) {
        if (activeRides.containsKey(requestId)) {
            String driverId = activeRides.remove(requestId);
            drivers.get(driverId).available = true;
            System.out.println("Ride completed: " + requestId);
        }
    }
    
    private double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        // Simplified distance calculation (Euclidean)
        return Math.sqrt(Math.pow(lat2 - lat1, 2) + Math.pow(lon2 - lon1, 2)) * 111; // ~111 km per degree
    }
    
    public List<String> getNearbyDrivers(double lat, double lon, double radius) {
        List<String> nearby = new ArrayList<>();
        
        for (Driver driver : drivers.values()) {
            if (!driver.available) continue;
            
            double distance = calculateDistance(lat, lon, driver.latitude, driver.longitude);
            if (distance <= radius) {
                nearby.add(driver.name + " (" + String.format("%.2f", distance) + " km)");
            }
        }
        
        return nearby;
    }
}

// Usage
UberRideMatching uber = new UberRideMatching();
uber.registerDriver(new UberRideMatching.Driver("d1", "John", 12.9716, 77.5946));
uber.registerDriver(new UberRideMatching.Driver("d2", "Alice", 12.9750, 77.5960));

uber.requestRide(new UberRideMatching.RideRequest("r1", "user1", 12.9720, 77.5950));

System.out.println("Nearby drivers: " + uber.getNearbyDrivers(12.9720, 77.5950, 2.0));
```

---

## 5. FACEBOOK/META - Social Network

### Use Case: Friend Suggestions & News Feed
```java
class SocialNetwork {
    // User -> Set of friends
    Map<String, Set<String>> friendships = new HashMap<>();
    
    // User -> Posts (chronological order)
    Map<String, LinkedList<Post>> userPosts = new HashMap<>();
    
    // Post likes
    Map<String, Set<String>> postLikes = new HashMap<>();
    
    static class Post {
        String postId;
        String userId;
        String content;
        long timestamp;
        
        Post(String postId, String userId, String content) {
            this.postId = postId;
            this.userId = userId;
            this.content = content;
            this.timestamp = System.currentTimeMillis();
        }
    }
    
    public void addFriend(String user1, String user2) {
        friendships.putIfAbsent(user1, new HashSet<>());
        friendships.putIfAbsent(user2, new HashSet<>());
        friendships.get(user1).add(user2);
        friendships.get(user2).add(user1);
    }
    
    public void createPost(String userId, String postId, String content) {
        userPosts.putIfAbsent(userId, new LinkedList<>());
        userPosts.get(userId).addFirst(new Post(postId, userId, content));
    }
    
    public void likePost(String postId, String userId) {
        postLikes.putIfAbsent(postId, new HashSet<>());
        postLikes.get(postId).add(userId);
    }
    
    // Friend suggestions based on mutual friends
    public List<String> getFriendSuggestions(String userId) {
        Set<String> myFriends = friendships.getOrDefault(userId, new HashSet<>());
        Map<String, Integer> mutualCount = new HashMap<>();
        
        // Count mutual friends
        for (String friend : myFriends) {
            Set<String> friendsOfFriend = friendships.getOrDefault(friend, new HashSet<>());
            
            for (String potential : friendsOfFriend) {
                if (!potential.equals(userId) && !myFriends.contains(potential)) {
                    mutualCount.put(potential, mutualCount.getOrDefault(potential, 0) + 1);
                }
            }
        }
        
        // Sort by mutual friend count
        List<Map.Entry<String, Integer>> suggestions = new ArrayList<>(mutualCount.entrySet());
        suggestions.sort((a, b) -> b.getValue() - a.getValue());
        
        return suggestions.stream()
            .limit(5)
            .map(e -> e.getKey() + " (" + e.getValue() + " mutual friends)")
            .collect(Collectors.toList());
    }
    
    // News feed (posts from friends sorted by timestamp)
    public List<String> getNewsFeed(String userId, int limit) {
        Set<String> myFriends = friendships.getOrDefault(userId, new HashSet<>());
        PriorityQueue<Post> feed = new PriorityQueue<>(
            (a, b) -> Long.compare(b.timestamp, a.timestamp)
        );
        
        // Add my posts
        if (userPosts.containsKey(userId)) {
            feed.addAll(userPosts.get(userId));
        }
        
        // Add friends' posts
        for (String friend : myFriends) {
            if (userPosts.containsKey(friend)) {
                feed.addAll(userPosts.get(friend));
            }
        }
        
        List<String> result = new ArrayList<>();
        for (int i = 0; i < limit && !feed.isEmpty(); i++) {
            Post post = feed.poll();
            int likes = postLikes.getOrDefault(post.postId, new HashSet<>()).size();
            result.add(post.userId + ": " + post.content + " (" + likes + " likes)");
        }
        
        return result;
    }
}

// Usage
SocialNetwork fb = new SocialNetwork();
fb.addFriend("Alice", "Bob");
fb.addFriend("Alice", "Charlie");
fb.addFriend("Bob", "David");

fb.createPost("Alice", "p1", "Hello World!");
fb.createPost("Bob", "p2", "Good morning!");
fb.likePost("p1", "Bob");
fb.likePost("p1", "Charlie");

System.out.println("Friend suggestions for Alice: " + fb.getFriendSuggestions("Alice"));
System.out.println("News feed for Alice: " + fb.getNewsFeed("Alice", 10));
```

---

## 🎯 KEY LEARNINGS FROM PRODUCT COMPANIES

### 1. **HashMap** - Most Used
- User profiles, caching, quick lookups
- O(1) access critical for performance

### 2. **TreeMap/TreeSet** - Sorted Data
- Leaderboards, rankings, sorted results
- Price ranges, time-based queries

### 3. **PriorityQueue** - Priority Systems
- Task scheduling, recommendation scoring
- Nearest driver, top products

### 4. **LinkedHashMap** - Order Matters
- LRU cache, recently viewed items
- Continue watching, browsing history

### 5. **ConcurrentHashMap** - Thread Safety
- High traffic systems
- Multiple users accessing simultaneously

### Practice Strategy:
1. Implement each use case from scratch
2. Understand WHY each collection is chosen
3. Optimize for real-world scale
4. Consider thread safety and performance



# Real-World Collections Usage in Top Product Companies
## Daily Development Scenarios at Google, Amazon, Microsoft, Meta, Netflix

---

## 🎯 SCENARIO 1: RATE LIMITER (Used by Twitter, LinkedIn)

### Problem:
Limit API requests to 100 per user per minute

### Solution:
```java
public class RateLimiter {
    // User ID -> List of request timestamps
    private Map<String, Queue<Long>> userRequests = new ConcurrentHashMap<>();
    private static final int MAX_REQUESTS = 100;
    private static final long TIME_WINDOW = 60000; // 1 minute in ms
    
    public boolean allowRequest(String userId) {
        long currentTime = System.currentTimeMillis();
        
        // Get user's request queue
        Queue<Long> requests = userRequests.computeIfAbsent(
            userId, k -> new LinkedList<>()
        );
        
        // Remove old requests outside time window
        while (!requests.isEmpty() && 
               currentTime - requests.peek() > TIME_WINDOW) {
            requests.poll();
        }
        
        // Check if limit reached
        if (requests.size() >= MAX_REQUESTS) {
            return false; // Rate limit exceeded
        }
        
        // Add current request
        requests.offer(currentTime);
        return true;
    }
}

// Usage
RateLimiter limiter = new RateLimiter();
if (limiter.allowRequest("user123")) {
    // Process request
} else {
    // Return 429 Too Many Requests
}
```

**Why these collections?**
- `ConcurrentHashMap`: Thread-safe for concurrent users
- `LinkedList as Queue`: FIFO for tracking request timestamps
- `computeIfAbsent`: Clean way to initialize new users

---

## 🎯 SCENARIO 2: AUTOCOMPLETE/SEARCH SUGGESTIONS (Used by Google, Amazon)

### Problem:
Implement search autocomplete like Google search box

### Solution:
```java
public class AutocompleteSystem {
    // Word -> Frequency count
    private Map<String, Integer> wordFrequency = new HashMap<>();
    
    // Prefix -> List of matching words
    private Map<String, List<String>> prefixCache = new HashMap<>();
    
    public void addWord(String word) {
        wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
        
        // Update all prefixes
        for (int i = 1; i <= word.length(); i++) {
            String prefix = word.substring(0, i);
            prefixCache.computeIfAbsent(prefix, k -> new ArrayList<>())
                      .add(word);
        }
    }
    
    public List<String> getSuggestions(String prefix, int limit) {
        if (!prefixCache.containsKey(prefix)) {
            return new ArrayList<>();
        }
        
        // Get all matching words and sort by frequency
        return prefixCache.get(prefix).stream()
            .distinct()
            .sorted((w1, w2) -> wordFrequency.get(w2) - wordFrequency.get(w1))
            .limit(limit)
            .collect(Collectors.toList());
    }
}

// Usage at Google Search
AutocompleteSystem autocomplete = new AutocompleteSystem();
autocomplete.addWord("java");
autocomplete.addWord("javascript");
autocomplete.addWord("java");  // Increases frequency

List<String> suggestions = autocomplete.getSuggestions("jav", 3);
// Returns: ["java", "javascript"] - sorted by frequency
```

**Why these collections?**
- `HashMap`: Fast O(1) lookup for word frequency
- `ArrayList`: Store matching words for each prefix
- `Stream API`: Sort and limit suggestions efficiently

---

## 🎯 SCENARIO 3: LRU CACHE (Used by Netflix, YouTube for video caching)

### Problem:
Implement Least Recently Used cache for video thumbnails

### Solution:
```java
public class LRUCache<K, V> {
    private final int capacity;
    private Map<K, V> cache;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        // LinkedHashMap with access order
        this.cache = new LinkedHashMap<K, V>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                return size() > capacity;
            }
        };
    }
    
    public V get(K key) {
        return cache.getOrDefault(key, null);
    }
    
    public void put(K key, V value) {
        cache.put(key, value);
    }
}

// Usage at Netflix for video thumbnails
LRUCache<String, byte[]> thumbnailCache = new LRUCache<>(1000);

// When user views video
String videoId = "video123";
byte[] thumbnail = thumbnailCache.get(videoId);
if (thumbnail == null) {
    // Load from database/storage
    thumbnail = loadThumbnailFromDB(videoId);
    thumbnailCache.put(videoId, thumbnail);
}
```

**Why LinkedHashMap?**
- Maintains access order automatically
- Built-in LRU eviction with `removeEldestEntry`
- O(1) get and put operations

---

## 🎯 SCENARIO 4: SHOPPING CART (Used by Amazon, Flipkart)

### Problem:
Manage shopping cart with product quantities

### Solution:
```java
public class ShoppingCart {
    // Product ID -> Quantity
    private Map<String, Integer> items = new HashMap<>();
    
    // Product ID -> Product details
    private Map<String, Product> productCatalog = new HashMap<>();
    
    static class Product {
        String id;
        String name;
        double price;
        
        Product(String id, String name, double price) {
            this.id = id;
            this.name = name;
            this.price = price;
        }
    }
    
    public void addItem(String productId, int quantity) {
        items.put(productId, items.getOrDefault(productId, 0) + quantity);
    }
    
    public void removeItem(String productId) {
        items.remove(productId);
    }
    
    public void updateQuantity(String productId, int quantity) {
        if (quantity <= 0) {
            items.remove(productId);
        } else {
            items.put(productId, quantity);
        }
    }
    
    public double getTotalPrice() {
        double total = 0;
        for (Map.Entry<String, Integer> entry : items.entrySet()) {
            Product product = productCatalog.get(entry.getKey());
            if (product != null) {
                total += product.price * entry.getValue();
            }
        }
        return total;
    }
    
    public int getTotalItems() {
        return items.values().stream().mapToInt(Integer::intValue).sum();
    }
    
    public List<String> getItemsList() {
        return new ArrayList<>(items.keySet());
    }
}

// Usage at Amazon
ShoppingCart cart = new ShoppingCart();
cart.addItem("laptop-001", 1);
cart.addItem("mouse-002", 2);
cart.updateQuantity("mouse-002", 3);
System.out.println("Total: $" + cart.getTotalPrice());
System.out.println("Items: " + cart.getTotalItems());
```

**Why HashMap?**
- Fast O(1) access to product quantities
- Easy to update quantities
- Efficient iteration for total calculation

---

## 🎯 SCENARIO 5: SOCIAL MEDIA FEED (Used by Facebook, Instagram)

### Problem:
Display posts from friends in chronological order

### Solution:
```java
public class SocialMediaFeed {
    static class Post {
        String postId;
        String userId;
        String content;
        long timestamp;
        int likes;
        
        Post(String postId, String userId, String content) {
            this.postId = postId;
            this.userId = userId;
            this.content = content;
            this.timestamp = System.currentTimeMillis();
            this.likes = 0;
        }
    }
    
    // User -> List of friends
    private Map<String, Set<String>> friendships = new HashMap<>();
    
    // All posts sorted by timestamp
    private TreeSet<Post> allPosts = new TreeSet<>(
        (p1, p2) -> Long.compare(p2.timestamp, p1.timestamp) // Newest first
    );
    
    // Post ID -> Post object
    private Map<String, Post> postsById = new HashMap<>();
    
    public void addFriendship(String user1, String user2) {
        friendships.computeIfAbsent(user1, k -> new HashSet<>()).add(user2);
        friendships.computeIfAbsent(user2, k -> new HashSet<>()).add(user1);
    }
    
    public void createPost(String userId, String content) {
        Post post = new Post(UUID.randomUUID().toString(), userId, content);
        allPosts.add(post);
        postsById.put(post.postId, post);
    }
    
    public List<Post> getFeed(String userId, int limit) {
        Set<String> friends = friendships.getOrDefault(userId, new HashSet<>());
        
        return allPosts.stream()
            .filter(post -> friends.contains(post.userId) || 
                           post.userId.equals(userId))
            .limit(limit)
            .collect(Collectors.toList());
    }
    
    public void likePost(String postId) {
        Post post = postsById.get(postId);
        if (post != null) {
            post.likes++;
        }
    }
}

// Usage at Instagram
SocialMediaFeed feed = new SocialMediaFeed();
feed.addFriendship("alice", "bob");
feed.createPost("bob", "Hello World!");
List<Post> aliceFeed = feed.getFeed("alice", 10);
```

**Why these collections?**
- `HashMap<String, Set<String>>`: Fast friend lookup
- `TreeSet`: Auto-sorted posts by timestamp
- `HashSet`: Quick friend existence check

---

## 🎯 SCENARIO 6: LEADERBOARD/RANKING (Used by Gaming Apps, Competitive Coding)

### Problem:
Maintain top players' scores in real-time

### Solution:
```java
public class Leaderboard {
    static class Player implements Comparable<Player> {
        String name;
        int score;
        long timestamp;
        
        Player(String name, int score) {
            this.name = name;
            this.score = score;
            this.timestamp = System.currentTimeMillis();
        }
        
        @Override
        public int compareTo(Player other) {
            if (this.score != other.score) {
                return other.score - this.score; // Higher score first
            }
            return Long.compare(this.timestamp, other.timestamp); // Earlier timestamp
        }
    }
    
    // Name -> Player object
    private Map<String, Player> players = new HashMap<>();
    
    // Sorted leaderboard
    private TreeSet<Player> leaderboard = new TreeSet<>();
    
    public void updateScore(String playerName, int score) {
        // Remove old entry if exists
        Player oldPlayer = players.get(playerName);
        if (oldPlayer != null) {
            leaderboard.remove(oldPlayer);
        }
        
        // Add new entry
        Player newPlayer = new Player(playerName, score);
        players.put(playerName, newPlayer);
        leaderboard.add(newPlayer);
    }
    
    public List<Player> getTopPlayers(int limit) {
        return leaderboard.stream()
            .limit(limit)
            .collect(Collectors.toList());
    }
    
    public int getRank(String playerName) {
        Player player = players.get(playerName);
        if (player == null) return -1;
        
        int rank = 1;
        for (Player p : leaderboard) {
            if (p.name.equals(playerName)) break;
            rank++;
        }
        return rank;
    }
}

// Usage at LeetCode
Leaderboard board = new Leaderboard();
board.updateScore("alice", 100);
board.updateScore("bob", 150);
board.updateScore("charlie", 120);

List<Player> top3 = board.getTopPlayers(3);
// 1. bob (150), 2. charlie (120), 3. alice (100)
```

**Why these collections?**
- `TreeSet`: Auto-sorted by score
- `HashMap`: Quick player lookup
- `Comparable`: Custom sorting logic

---

## 🎯 SCENARIO 7: NOTIFICATION SYSTEM (Used by WhatsApp, Slack)

### Problem:
Manage unread notifications for users

### Solution:
```java
public class NotificationSystem {
    static class Notification {
        String id;
        String message;
        long timestamp;
        boolean read;
        
        Notification(String message) {
            this.id = UUID.randomUUID().toString();
            this.message = message;
            this.timestamp = System.currentTimeMillis();
            this.read = false;
        }
    }
    
    // User ID -> List of notifications (newest first)
    private Map<String, LinkedList<Notification>> userNotifications = new HashMap<>();
    
    public void sendNotification(String userId, String message) {
        LinkedList<Notification> notifications = 
            userNotifications.computeIfAbsent(userId, k -> new LinkedList<>());
        
        // Add at the beginning (newest first)
        notifications.addFirst(new Notification(message));
        
        // Keep only last 100 notifications
        if (notifications.size() > 100) {
            notifications.removeLast();
        }
    }
    
    public List<Notification> getUnreadNotifications(String userId) {
        return userNotifications.getOrDefault(userId, new LinkedList<>())
            .stream()
            .filter(n -> !n.read)
            .collect(Collectors.toList());
    }
    
    public void markAsRead(String userId, String notificationId) {
        List<Notification> notifications = 
            userNotifications.get(userId);
        
        if (notifications != null) {
            notifications.stream()
                .filter(n -> n.id.equals(notificationId))
                .forEach(n -> n.read = true);
        }
    }
    
    public int getUnreadCount(String userId) {
        return (int) userNotifications.getOrDefault(userId, new LinkedList<>())
            .stream()
            .filter(n -> !n.read)
            .count();
    }
}

// Usage at WhatsApp
NotificationSystem notifSystem = new NotificationSystem();
notifSystem.sendNotification("user123", "New message from Alice");
notifSystem.sendNotification("user123", "Bob liked your status");

int unreadCount = notifSystem.getUnreadCount("user123"); // 2
```

**Why LinkedList?**
- Efficient add/remove at beginning/end
- FIFO for notifications
- Easy to maintain size limit

---

## 🎯 SCENARIO 8: URL SHORTENER (Used by bit.ly, TinyURL)

### Problem:
Convert long URLs to short codes and vice versa

### Solution:
```java
public class URLShortener {
    // Short code -> Original URL
    private Map<String, String> shortToLong = new HashMap<>();
    
    // Original URL -> Short code
    private Map<String, String> longToShort = new HashMap<>();
    
    // Counter for generating unique codes
    private int counter = 1000;
    
    private String encode(int num) {
        String chars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder();
        
        while (num > 0) {
            sb.append(chars.charAt(num % 62));
            num /= 62;
        }
        
        return sb.reverse().toString();
    }
    
    public String shortenURL(String longURL) {
        // Check if already shortened
        if (longToShort.containsKey(longURL)) {
            return longToShort.get(longURL);
        }
        
        // Generate short code
        String shortCode = encode(counter++);
        
        // Store mappings
        shortToLong.put(shortCode, longURL);
        longToShort.put(longURL, shortCode);
        
        return "http://short.url/" + shortCode;
    }
    
    public String expandURL(String shortURL) {
        String shortCode = shortURL.replace("http://short.url/", "");
        return shortToLong.getOrDefault(shortCode, "URL not found");
    }
}

// Usage at bit.ly
URLShortener shortener = new URLShortener();
String shortURL = shortener.shortenURL("https://www.example.com/very/long/url");
String originalURL = shortener.expandURL(shortURL);
```

**Why two HashMaps?**
- Bidirectional lookup in O(1) time
- Prevent duplicate short codes
- Fast encoding and decoding

---

## 🎯 SCENARIO 9: TASK SCHEDULER (Used by Asana, Jira)

### Problem:
Schedule and execute tasks based on priority

### Solution:
```java
public class TaskScheduler {
    static class Task implements Comparable<Task> {
        String name;
        int priority; // 1=Highest, 5=Lowest
        long deadline;
        
        Task(String name, int priority, long deadline) {
            this.name = name;
            this.priority = priority;
            this.deadline = deadline;
        }
        
        @Override
        public int compareTo(Task other) {
            if (this.priority != other.priority) {
                return this.priority - other.priority; // Lower number = higher priority
            }
            return Long.compare(this.deadline, other.deadline); // Earlier deadline
        }
    }
    
    // Priority queue for tasks
    private PriorityQueue<Task> taskQueue = new PriorityQueue<>();
    
    // Completed tasks
    private List<Task> completedTasks = new ArrayList<>();
    
    public void addTask(String name, int priority, long deadline) {
        taskQueue.offer(new Task(name, priority, deadline));
    }
    
    public Task getNextTask() {
        Task task = taskQueue.poll();
        if (task != null) {
            completedTasks.add(task);
        }
        return task;
    }
    
    public List<Task> getPendingTasks() {
        return new ArrayList<>(taskQueue);
    }
    
    public int getPendingCount() {
        return taskQueue.size();
    }
}

// Usage at Jira
TaskScheduler scheduler = new TaskScheduler();
scheduler.addTask("Fix critical bug", 1, System.currentTimeMillis() + 3600000);
scheduler.addTask("Write documentation", 3, System.currentTimeMillis() + 86400000);
scheduler.addTask("Code review", 2, System.currentTimeMillis() + 7200000);

Task nextTask = scheduler.getNextTask(); // Returns "Fix critical bug"
```

**Why PriorityQueue?**
- Automatically sorts by priority
- O(log n) insertion and removal
- Perfect for task scheduling

---

## 🎯 SCENARIO 10: SESSION MANAGEMENT (Used by Netflix, Spotify)

### Problem:
Manage user sessions with expiration

### Solution:
```java
public class SessionManager {
    static class Session {
        String sessionId;
        String userId;
        long createdAt;
        long expiresAt;
        Map<String, Object> data;
        
        Session(String userId, long duration) {
            this.sessionId = UUID.randomUUID().toString();
            this.userId = userId;
            this.createdAt = System.currentTimeMillis();
            this.expiresAt = createdAt + duration;
            this.data = new HashMap<>();
        }
        
        boolean isExpired() {
            return System.currentTimeMillis() > expiresAt;
        }
    }
    
    // Session ID -> Session
    private Map<String, Session> sessions = new ConcurrentHashMap<>();
    
    // User ID -> Session ID
    private Map<String, String> userSessions = new ConcurrentHashMap<>();
    
    public String createSession(String userId, long duration) {
        // Remove old session if exists
        String oldSessionId = userSessions.get(userId);
        if (oldSessionId != null) {
            sessions.remove(oldSessionId);
        }
        
        // Create new session
        Session session = new Session(userId, duration);
        sessions.put(session.sessionId, session);
        userSessions.put(userId, session.sessionId);
        
        return session.sessionId;
    }
    
    public Session getSession(String sessionId) {
        Session session = sessions.get(sessionId);
        if (session != null && session.isExpired()) {
            removeSession(sessionId);
            return null;
        }
        return session;
    }
    
    public void removeSession(String sessionId) {
        Session session = sessions.remove(sessionId);
        if (session != null) {
            userSessions.remove(session.userId);
        }
    }
    
    public void cleanupExpiredSessions() {
        sessions.entrySet().removeIf(entry -> entry.getValue().isExpired());
    }
}

// Usage at Netflix
SessionManager manager = new SessionManager();
String sessionId = manager.createSession("user123", 3600000); // 1 hour
Session session = manager.getSession(sessionId);
```

**Why ConcurrentHashMap?**
- Thread-safe for multiple users
- No need for external synchronization
- Better performance than synchronized HashMap

---

## 📊 SUMMARY: WHICH COLLECTION FOR WHICH SCENARIO

| Scenario | Primary Collection | Why |
|----------|-------------------|-----|
| Rate Limiter | ConcurrentHashMap + Queue | Thread-safety + FIFO |
| Autocomplete | HashMap + ArrayList | Fast lookup + storage |
| LRU Cache | LinkedHashMap | Access order tracking |
| Shopping Cart | HashMap | Fast product lookup |
| Social Feed | TreeSet + HashMap | Auto-sort + quick access |
| Leaderboard | TreeSet + HashMap | Sorted ranking + lookup |
| Notifications | HashMap + LinkedList | User mapping + FIFO |
| URL Shortener | 2 HashMaps | Bidirectional lookup |
| Task Scheduler | PriorityQueue | Priority-based execution |
| Session Management | ConcurrentHashMap | Thread-safe sessions |

**Key Principle**: Choose collection based on:
1. Access pattern (random vs sequential)
2. Ordering requirement (sorted vs unsorted)
3. Uniqueness (duplicates allowed or not)
4. Thread-safety (single vs multi-threaded)
5. Performance needs (time complexity)