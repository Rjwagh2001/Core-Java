# Java OOP Mastery Guide: From Basic to Advanced
*Become a Top 1% Candidate with Real-World Industry Examples*

## Table of Contents
1. [Introduction to OOP](#introduction-to-oop)
2. [Classes and Objects](#classes-and-objects)
3. [Encapsulation](#encapsulation)
4. [Inheritance](#inheritance)
5. [Polymorphism](#polymorphism)
6. [Abstraction](#abstraction)
7. [Advanced OOP Concepts](#advanced-oop-concepts)
8. [Design Patterns](#design-patterns)
9. [Industry Examples](#industry-examples)
10. [Interview Questions](#interview-questions)

---

## Introduction to OOP

Object-Oriented Programming (OOP) is a programming paradigm based on the concept of "objects" which contain data (fields) and code (methods). The four main principles are:

### The Four Pillars of OOP
1. **Encapsulation** - Bundling data and methods together
2. **Inheritance** - Creating new classes based on existing ones
3. **Polymorphism** - One interface, multiple implementations
4. **Abstraction** - Hiding complex implementation details

### Why OOP Matters in Top Companies
- **Google**: Uses OOP for Android development, Chrome browser architecture
- **Amazon**: E-commerce platform, AWS services architecture
- **Microsoft**: .NET framework, Azure cloud services
- **Netflix**: Microservices architecture, recommendation systems
- **Uber**: Real-time location services, payment processing

---

## Classes and Objects

### Basic Class Structure

```java
// Real Example: Netflix User Profile System
public class UserProfile {
    // Instance variables (fields)
    private String userId;
    private String name;
    private String email;
    private int age;
    private String subscriptionType;
    private List<String> watchHistory;
    
    // Constructor
    public UserProfile(String userId, String name, String email, int age) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.age = age;
        this.subscriptionType = "Basic";
        this.watchHistory = new ArrayList<>();
    }
    
    // Methods
    public void addToWatchHistory(String movieTitle) {
        watchHistory.add(movieTitle);
    }
    
    public void upgradeSubscription(String newType) {
        this.subscriptionType = newType;
    }
    
    public List<String> getRecommendations() {
        // Netflix's recommendation algorithm simulation
        return new ArrayList<>();
    }
}
```

### Industry Example: Uber's Driver System

```java
public class Driver {
    private String driverId;
    private String name;
    private String licenseNumber;
    private Location currentLocation;
    private DriverStatus status;
    private Vehicle vehicle;
    private double rating;
    
    public Driver(String driverId, String name, String licenseNumber) {
        this.driverId = driverId;
        this.name = name;
        this.licenseNumber = licenseNumber;
        this.status = DriverStatus.OFFLINE;
        this.rating = 5.0;
    }
    
    public void goOnline() {
        this.status = DriverStatus.AVAILABLE;
        // Notify Uber's dispatch system
    }
    
    public void acceptRide(RideRequest request) {
        this.status = DriverStatus.BUSY;
        // Start navigation to pickup location
    }
}
```

---

## Encapsulation

Encapsulation is the bundling of data and methods that operate on that data within a single unit (class), and restricting access to some components.

### Real Example: Amazon's Payment Processing

```java
public class PaymentProcessor {
    // Private fields - encapsulated data
    private String merchantId;
    private String apiKey;
    private double transactionFee;
    private SecurityManager securityManager;
    
    public PaymentProcessor(String merchantId, String apiKey) {
        this.merchantId = merchantId;
        this.apiKey = apiKey;
        this.transactionFee = 0.029; // 2.9%
        this.securityManager = new SecurityManager();
    }
    
    // Public interface - controlled access
    public PaymentResult processPayment(PaymentRequest request) {
        if (!validateRequest(request)) {
            return PaymentResult.failure("Invalid request");
        }
        
        if (!authenticateTransaction(request)) {
            return PaymentResult.failure("Authentication failed");
        }
        
        return executePayment(request);
    }
    
    // Private methods - implementation details hidden
    private boolean validateRequest(PaymentRequest request) {
        // Complex validation logic
        return request != null && request.getAmount() > 0;
    }
    
    private boolean authenticateTransaction(PaymentRequest request) {
        // Security checks using encrypted keys
        return securityManager.authenticate(request, apiKey);
    }
    
    private PaymentResult executePayment(PaymentRequest request) {
        // Actual payment processing
        double totalAmount = request.getAmount() * (1 + transactionFee);
        // Process with payment gateway
        return PaymentResult.success(totalAmount);
    }
    
    // Getters and setters for controlled access
    public double getTransactionFee() {
        return transactionFee;
    }
    
    // No setter for apiKey - read-only after construction
}
```

### Benefits in Industry
- **Security**: Sensitive data (API keys, passwords) are hidden
- **Maintainability**: Internal changes don't affect external code
- **Validation**: Data integrity through controlled access

---

## Inheritance

Inheritance allows a class to inherit properties and methods from another class.

### Real Example: Google's Android UI Components

```java
// Base class - Android View system
public abstract class View {
    protected int x, y, width, height;
    protected boolean visible;
    protected String id;
    
    public View(String id) {
        this.id = id;
        this.visible = true;
    }
    
    public abstract void draw(Canvas canvas);
    
    public void setVisible(boolean visible) {
        this.visible = visible;
        invalidate(); // Request redraw
    }
    
    protected void invalidate() {
        // Notify system to redraw this view
    }
    
    // Common functionality for all views
    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
        invalidate();
    }
}

// Inherited class - Button
public class Button extends View {
    private String text;
    private Color backgroundColor;
    private OnClickListener clickListener;
    
    public Button(String id, String text) {
        super(id); // Call parent constructor
        this.text = text;
        this.backgroundColor = Color.GRAY;
    }
    
    @Override
    public void draw(Canvas canvas) {
        if (!visible) return;
        
        // Draw button background
        canvas.drawRect(x, y, width, height, backgroundColor);
        // Draw button text
        canvas.drawText(text, x + 10, y + height/2);
    }
    
    public void setText(String text) {
        this.text = text;
        invalidate(); // Inherited method
    }
    
    public void setOnClickListener(OnClickListener listener) {
        this.clickListener = listener;
    }
}

// Another inherited class - ImageView
public class ImageView extends View {
    private Image image;
    private ScaleType scaleType;
    
    public ImageView(String id) {
        super(id);
        this.scaleType = ScaleType.FIT_CENTER;
    }
    
    @Override
    public void draw(Canvas canvas) {
        if (!visible || image == null) return;
        
        // Draw scaled image
        canvas.drawImage(image, x, y, width, height, scaleType);
    }
    
    public void setImage(Image image) {
        this.image = image;
        invalidate(); // Inherited method
    }
}
```

### Real Example: Microsoft's Office Document System

```java
// Base Document class
public abstract class Document {
    protected String title;
    protected String author;
    protected Date createdDate;
    protected Date modifiedDate;
    protected boolean isDirty; // Has unsaved changes
    
    public Document(String title, String author) {
        this.title = title;
        this.author = author;
        this.createdDate = new Date();
        this.modifiedDate = new Date();
        this.isDirty = false;
    }
    
    // Template method pattern
    public final boolean save() {
        if (!validate()) {
            return false;
        }
        
        boolean result = performSave();
        if (result) {
            isDirty = false;
            modifiedDate = new Date();
        }
        return result;
    }
    
    protected abstract boolean validate();
    protected abstract boolean performSave();
    public abstract void print();
    
    // Common functionality
    public void markDirty() {
        this.isDirty = true;
    }
}

// Word Document
public class WordDocument extends Document {
    private List<Paragraph> paragraphs;
    private DocumentStyle style;
    
    public WordDocument(String title, String author) {
        super(title, author);
        this.paragraphs = new ArrayList<>();
        this.style = DocumentStyle.NORMAL;
    }
    
    @Override
    protected boolean validate() {
        // Word-specific validation
        return title != null && !title.trim().isEmpty();
    }
    
    @Override
    protected boolean performSave() {
        // Save as .docx format
        return FileManager.saveAsDocx(this);
    }
    
    @Override
    public void print() {
        // Word-specific printing logic
        PrintManager.printWordDocument(this);
    }
    
    public void addParagraph(String text) {
        paragraphs.add(new Paragraph(text));
        markDirty(); // Inherited method
    }
}

// Excel Document
public class ExcelDocument extends Document {
    private List<Worksheet> worksheets;
    
    public ExcelDocument(String title, String author) {
        super(title, author);
        this.worksheets = new ArrayList<>();
        // Always start with one worksheet
        worksheets.add(new Worksheet("Sheet1"));
    }
    
    @Override
    protected boolean validate() {
        // Excel-specific validation
        return !worksheets.isEmpty();
    }
    
    @Override
    protected boolean performSave() {
        // Save as .xlsx format
        return FileManager.saveAsExcel(this);
    }
    
    @Override
    public void print() {
        // Excel-specific printing logic
        PrintManager.printExcelDocument(this);
    }
    
    public void addWorksheet(String name) {
        worksheets.add(new Worksheet(name));
        markDirty(); // Inherited method
    }
}
```

---

## Polymorphism

Polymorphism allows objects of different types to be treated as instances of the same type through a common interface.

### Types of Polymorphism

#### 1. Compile-time Polymorphism (Method Overloading)

```java
// Real Example: Netflix's Search System
public class SearchService {
    // Method overloading - same name, different parameters
    public List<Content> search(String query) {
        // Basic text search
        return performTextSearch(query);
    }
    
    public List<Content> search(String query, Genre genre) {
        // Search with genre filter
        return performTextSearch(query).stream()
                .filter(content -> content.getGenre() == genre)
                .collect(Collectors.toList());
    }
    
    public List<Content> search(String query, int releaseYear) {
        // Search with year filter
        return performTextSearch(query).stream()
                .filter(content -> content.getReleaseYear() == releaseYear)
                .collect(Collectors.toList());
    }
    
    public List<Content> search(String query, Genre genre, int releaseYear, double minRating) {
        // Advanced search with multiple filters
        return performTextSearch(query).stream()
                .filter(content -> content.getGenre() == genre)
                .filter(content -> content.getReleaseYear() == releaseYear)
                .filter(content -> content.getRating() >= minRating)
                .collect(Collectors.toList());
    }
    
    private List<Content> performTextSearch(String query) {
        // Implementation of text search algorithm
        return ContentDatabase.searchByText(query);
    }
}
```

#### 2. Runtime Polymorphism (Method Overriding)

```java
// Real Example: Amazon's Shipping System
public abstract class ShippingStrategy {
    protected double baseCost;
    
    public abstract double calculateCost(Package pkg);
    public abstract int getEstimatedDays();
    public abstract String getTrackingInfo(String orderId);
    
    // Template method
    public final ShippingResult ship(Package pkg, Address address) {
        double cost = calculateCost(pkg);
        int days = getEstimatedDays();
        String trackingId = generateTrackingId();
        
        return new ShippingResult(cost, days, trackingId);
    }
    
    private String generateTrackingId() {
        return "AMZ" + System.currentTimeMillis();
    }
}

// Standard Shipping
public class StandardShipping extends ShippingStrategy {
    public StandardShipping() {
        this.baseCost = 5.99;
    }
    
    @Override
    public double calculateCost(Package pkg) {
        return baseCost + (pkg.getWeight() * 0.5);
    }
    
    @Override
    public int getEstimatedDays() {
        return 5; // 5-7 business days
    }
    
    @Override
    public String getTrackingInfo(String orderId) {
        return "Your package is being processed at our facility";
    }
}

// Prime Shipping
public class PrimeShipping extends ShippingStrategy {
    public PrimeShipping() {
        this.baseCost = 0.0; // Free for Prime members
    }
    
    @Override
    public double calculateCost(Package pkg) {
        return 0.0; // Free shipping
    }
    
    @Override
    public int getEstimatedDays() {
        return 2; // 2-day delivery
    }
    
    @Override
    public String getTrackingInfo(String orderId) {
        return "Your Prime package is out for delivery";
    }
}

// Express Shipping
public class ExpressShipping extends ShippingStrategy {
    public ExpressShipping() {
        this.baseCost = 24.99;
    }
    
    @Override
    public double calculateCost(Package pkg) {
        return baseCost + (pkg.getWeight() * 2.0);
    }
    
    @Override
    public int getEstimatedDays() {
        return 1; // Next day delivery
    }
    
    @Override
    public String getTrackingInfo(String orderId) {
        return "Your express package is in transit";
    }
}

// Usage in Amazon's Order Processing System
public class OrderProcessor {
    public void processOrder(Order order) {
        ShippingStrategy shipping;
        
        // Polymorphism in action - same interface, different behavior
        if (order.getCustomer().isPrimeMember()) {
            shipping = new PrimeShipping();
        } else if (order.isExpressRequested()) {
            shipping = new ExpressShipping();
        } else {
            shipping = new StandardShipping();
        }
        
        // Same method call, different implementations
        ShippingResult result = shipping.ship(order.getPackage(), order.getAddress());
        order.setShippingResult(result);
    }
}
```

### Real Example: Google's YouTube Video Processing

```java
// Interface for video processing
public interface VideoProcessor {
    void process(VideoFile video);
    String getSupportedFormat();
    VideoQuality[] getSupportedQualities();
}

// Different implementations for different formats
public class MP4Processor implements VideoProcessor {
    @Override
    public void process(VideoFile video) {
        System.out.println("Processing MP4 video with H.264 codec");
        // MP4-specific processing logic
        compressWithH264(video);
        generateThumbnails(video);
        createManifest(video);
    }
    
    @Override
    public String getSupportedFormat() {
        return "MP4";
    }
    
    @Override
    public VideoQuality[] getSupportedQualities() {
        return new VideoQuality[]{VideoQuality.P144, VideoQuality.P360, 
                                 VideoQuality.P720, VideoQuality.P1080, VideoQuality.P4K};
    }
    
    private void compressWithH264(VideoFile video) {
        // H.264 compression algorithm
    }
    
    private void generateThumbnails(VideoFile video) {
        // Generate multiple thumbnail options
    }
    
    private void createManifest(VideoFile video) {
        // Create DASH manifest for adaptive streaming
    }
}

public class WebMProcessor implements VideoProcessor {
    @Override
    public void process(VideoFile video) {
        System.out.println("Processing WebM video with VP9 codec");
        // WebM-specific processing logic
        compressWithVP9(video);
        generateThumbnails(video);
        createManifest(video);
    }
    
    @Override
    public String getSupportedFormat() {
        return "WebM";
    }
    
    @Override
    public VideoQuality[] getSupportedQualities() {
        return new VideoQuality[]{VideoQuality.P360, VideoQuality.P720, 
                                 VideoQuality.P1080, VideoQuality.P1440, VideoQuality.P4K};
    }
    
    private void compressWithVP9(VideoFile video) {
        // VP9 compression algorithm
    }
}

// YouTube's video processing service
public class YouTubeProcessingService {
    private Map<String, VideoProcessor> processors;
    
    public YouTubeProcessingService() {
        processors = new HashMap<>();
        processors.put("MP4", new MP4Processor());
        processors.put("WebM", new WebMProcessor());
        processors.put("MOV", new MOVProcessor());
        processors.put("AVI", new AVIProcessor());
    }
    
    public void processUploadedVideo(VideoFile video) {
        String format = video.getFormat().toUpperCase();
        VideoProcessor processor = processors.get(format);
        
        if (processor != null) {
            // Polymorphism: same method call, different behavior
            processor.process(video);
        } else {
            throw new UnsupportedFormatException("Format " + format + " not supported");
        }
    }
    
    // Process multiple videos with different processors
    public void processBatch(List<VideoFile> videos) {
        for (VideoFile video : videos) {
            processUploadedVideo(video); // Polymorphic behavior
        }
    }
}
```

---

## Abstraction

Abstraction hides complex implementation details and shows only essential features of an object.

### Real Example: Uber's Payment Gateway Abstraction

```java
// Abstract payment gateway
public abstract class PaymentGateway {
    protected String gatewayName;
    protected String apiVersion;
    protected boolean isTestMode;
    
    public PaymentGateway(String gatewayName, String apiVersion) {
        this.gatewayName = gatewayName;
        this.apiVersion = apiVersion;
        this.isTestMode = false;
    }
    
    // Template method - defines the payment flow
    public final PaymentResult processPayment(PaymentRequest request) {
        // Pre-processing validation (common for all gateways)
        if (!validateRequest(request)) {
            return PaymentResult.failure("Invalid payment request");
        }
        
        // Gateway-specific authentication
        if (!authenticate()) {
            return PaymentResult.failure("Authentication failed");
        }
        
        // Gateway-specific payment processing
        PaymentResult result = executePayment(request);
        
        // Post-processing (common for all gateways)
        logTransaction(request, result);
        notifyRider(request, result);
        
        return result;
    }
    
    // Abstract methods - must be implemented by concrete classes
    protected abstract boolean authenticate();
    protected abstract PaymentResult executePayment(PaymentRequest request);
    protected abstract void handleRefund(String transactionId, double amount);
    
    // Concrete methods - common functionality
    private boolean validateRequest(PaymentRequest request) {
        return request != null && 
               request.getAmount() > 0 && 
               request.getPaymentMethod() != null;
    }
    
    private void logTransaction(PaymentRequest request, PaymentResult result) {
        TransactionLogger.log(gatewayName, request, result);
    }
    
    private void notifyRider(PaymentRequest request, PaymentResult result) {
        if (result.isSuccess()) {
            NotificationService.sendPaymentConfirmation(request.getRiderId());
        }
    }
}

// Stripe implementation
public class StripePaymentGateway extends PaymentGateway {
    private StripeAPI stripeAPI;
    private String secretKey;
    
    public StripePaymentGateway(String secretKey) {
        super("Stripe", "v1");
        this.secretKey = secretKey;
        this.stripeAPI = new StripeAPI(secretKey);
    }
    
    @Override
    protected boolean authenticate() {
        try {
            return stripeAPI.validateApiKey(secretKey);
        } catch (StripeException e) {
            return false;
        }
    }
    
    @Override
    protected PaymentResult executePayment(PaymentRequest request) {
        try {
            StripeCharge charge = stripeAPI.createCharge(
                (int)(request.getAmount() * 100), // Convert to cents
                "usd",
                request.getPaymentMethod().getStripeToken(),
                "Uber ride payment"
            );
            
            return PaymentResult.success(charge.getId(), charge.getAmount() / 100.0);
        } catch (StripeException e) {
            return PaymentResult.failure(e.getMessage());
        }
    }
    
    @Override
    protected void handleRefund(String transactionId, double amount) {
        try {
            stripeAPI.createRefund(transactionId, (int)(amount * 100));
        } catch (StripeException e) {
            RefundLogger.logError("Stripe refund failed", e);
        }
    }
}

// PayPal implementation
public class PayPalPaymentGateway extends PaymentGateway {
    private PayPalAPI paypalAPI;
    private String clientId;
    private String clientSecret;
    
    public PayPalPaymentGateway(String clientId, String clientSecret) {
        super("PayPal", "v2");
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.paypalAPI = new PayPalAPI(clientId, clientSecret);
    }
    
    @Override
    protected boolean authenticate() {
        try {
            String accessToken = paypalAPI.getAccessToken(clientId, clientSecret);
            return accessToken != null;
        } catch (PayPalException e) {
            return false;
        }
    }
    
    @Override
    protected PaymentResult executePayment(PaymentRequest request) {
        try {
            PayPalPayment payment = paypalAPI.createPayment(
                request.getAmount(),
                "USD",
                "Uber ride payment",
                request.getPaymentMethod().getPayPalToken()
            );
            
            return PaymentResult.success(payment.getId(), payment.getAmount());
        } catch (PayPalException e) {
            return PaymentResult.failure(e.getMessage());
        }
    }
    
    @Override
    protected void handleRefund(String transactionId, double amount) {
        try {
            paypalAPI.refundPayment(transactionId, amount);
        } catch (PayPalException e) {
            RefundLogger.logError("PayPal refund failed", e);
        }
    }
}

// Uber's payment service using abstraction
public class UberPaymentService {
    private List<PaymentGateway> paymentGateways;
    
    public UberPaymentService() {
        paymentGateways = new ArrayList<>();
        paymentGateways.add(new StripePaymentGateway(System.getenv("STRIPE_SECRET_KEY")));
        paymentGateways.add(new PayPalPaymentGateway(
            System.getenv("PAYPAL_CLIENT_ID"), 
            System.getenv("PAYPAL_CLIENT_SECRET")
        ));
    }
    
    public PaymentResult processRidePayment(RideRequest ride) {
        PaymentRequest request = new PaymentRequest(
            ride.getFare(),
            ride.getPaymentMethod(),
            ride.getRiderId()
        );
        
        // Try primary gateway first, fallback to others
        for (PaymentGateway gateway : paymentGateways) {
            PaymentResult result = gateway.processPayment(request);
            if (result.isSuccess()) {
                return result;
            }
        }
        
        return PaymentResult.failure("All payment gateways failed");
    }
}
```

### Interface vs Abstract Class

```java
// Interface - Contract definition (what to do)
public interface NotificationService {
    void sendNotification(String userId, String message);
    boolean isDelivered(String notificationId);
    void scheduleNotification(String userId, String message, Date scheduledTime);
    
    // Default method (Java 8+)
    default void sendBulkNotification(List<String> userIds, String message) {
        for (String userId : userIds) {
            sendNotification(userId, message);
        }
    }
}

// Abstract class - Partial implementation (how to do it)
public abstract class BaseNotificationService implements NotificationService {
    protected NotificationLogger logger;
    protected UserPreferenceService userPreferences;
    
    public BaseNotificationService() {
        this.logger = new NotificationLogger();
        this.userPreferences = new UserPreferenceService();
    }
    
    // Common implementation
    @Override
    public final void sendNotification(String userId, String message) {
        if (!userPreferences.isNotificationEnabled(userId)) {
            logger.log("Notification blocked for user: " + userId);
            return;
        }
        
        String formattedMessage = formatMessage(message);
        boolean sent = deliverNotification(userId, formattedMessage);
        
        if (sent) {
            logger.logSuccess(userId, message);
        } else {
            logger.logFailure(userId, message);
        }
    }
    
    // Template method
    protected String formatMessage(String message) {
        return "[" + getServiceName() + "] " + message;
    }
    
    // Abstract methods to be implemented by concrete classes
    protected abstract boolean deliverNotification(String userId, String message);
    protected abstract String getServiceName();
}

// Concrete implementation - Google Firebase
public class FirebaseNotificationService extends BaseNotificationService {
    private FirebaseMessaging firebaseMessaging;
    
    public FirebaseNotificationService() {
        super();
        this.firebaseMessaging = FirebaseMessaging.getInstance();
    }
    
    @Override
    protected boolean deliverNotification(String userId, String message) {
        try {
            String fcmToken = userPreferences.getFcmToken(userId);
            Message fcmMessage = Message.builder()
                .setToken(fcmToken)
                .setNotification(Notification.builder()
                    .setBody(message)
                    .build())
                .build();
            
            String response = firebaseMessaging.send(fcmMessage);
            return response != null;
        } catch (Exception e) {
            return false;
        }
    }
    
    @Override
    protected String getServiceName() {
        return "Firebase";
    }
    
    @Override
    public boolean isDelivered(String notificationId) {
        // Firebase-specific delivery check
        return firebaseMessaging.checkDeliveryStatus(notificationId);
    }
    
    @Override
    public void scheduleNotification(String userId, String message, Date scheduledTime) {
        // Firebase doesn't support scheduling, use a scheduler service
        SchedulerService.schedule(() -> {
            sendNotification(userId, message);
        }, scheduledTime);
    }
}

// Another implementation - AWS SNS
public class SNSNotificationService extends BaseNotificationService {
    private AmazonSNS snsClient;
    
    public SNSNotificationService() {
        super();
        this.snsClient = AmazonSNSClientBuilder.defaultClient();
    }
    
    @Override
    protected boolean deliverNotification(String userId, String message) {
        try {
            String phoneNumber = userPreferences.getPhoneNumber(userId);
            PublishRequest request = new PublishRequest()
                .withPhoneNumber(phoneNumber)
                .withMessage(message);
            
            PublishResult result = snsClient.publish(request);
            return result.getMessageId() != null;
        } catch (Exception e) {
            return false;
        }
    }
    
    @Override
    protected String getServiceName() {
        return "AWS SNS";
    }
    
    @Override
    public boolean isDelivered(String notificationId) {
        // SNS-specific delivery check
        return checkSNSDeliveryStatus(notificationId);
    }
    
    @Override
    public void scheduleNotification(String userId, String message, Date scheduledTime) {
        // Use AWS Lambda with CloudWatch Events for scheduling
        ScheduledNotificationLambda.schedule(userId, message, scheduledTime);
    }
    
    private boolean checkSNSDeliveryStatus(String messageId) {
        // Implementation for SNS delivery status check
        return true;
    }
}
```

---

## Advanced OOP Concepts

### 1. Composition vs Inheritance

#### Real Example: Tesla's Car Manufacturing System

```java
// Composition approach - Tesla Model S
public class TeslaModelS {
    // Has-a relationship instead of is-a
    private Engine engine;
    private Battery battery;
    private AutoPilot autoPilot;
    private InfotainmentSystem infotainment;
    private ClimateControl climate;
    
    public TeslaModelS() {
        // Flexible composition - can mix and match components
        this.engine = new ElectricEngine(750); // 750 HP
        this.battery = new LithiumIonBattery(100); // 100 kWh
        this.autoPilot = new AutoPilotV4();
        this.infotainment = new TeslaInfotainmentV11();
        this.climate = new DualZoneClimateControl();
    }
    
    public void drive() {
        engine.start();
        if (autoPilot.isEnabled()) {
            autoPilot.engage();
        }
    }
    
    public void charge() {
        battery.charge();
    }
    
    public void updateSoftware() {
        autoPilot.update();
        infotainment.update();
    }
    
    // Delegation to components
    public double getBatteryPercentage() {
        return battery.getChargePercentage();
    }
    
    public void setTemperature(int temperature) {
        climate.setTargetTemperature(temperature);
    }
}

// Individual components that can be reused
public class ElectricEngine {
    private int horsepower;
    private boolean isRunning;
    private int rpm;
    
    public ElectricEngine(int horsepower) {
        this.horsepower = horsepower;
        this.isRunning = false;
        this.rpm = 0;
    }
    
    public void start() {
        isRunning = true;
        rpm = 1000;
        System.out.println("Electric engine started - " + horsepower + " HP");
    }
    
    public void accelerate(int targetRpm) {
        if (isRunning) {
            this.rpm = Math.min(targetRpm, 15000); // Max RPM for electric motor
        }
    }
    
    public void stop() {
        isRunning = false;
        rpm = 0;
    }
}

public class LithiumIonBattery {
    private double capacity; // kWh
    private double currentCharge;
    private boolean isCharging;
    
    public LithiumIonBattery(double capacity) {
        this.capacity = capacity;
        this.currentCharge = capacity * 0.8; // Start at 80%
        this.isCharging = false;
    }
    
    public void charge() {
        isCharging = true;
        // Simulate charging process
        new Thread(() -> {
            while (currentCharge < capacity && isCharging) {
                currentCharge += 0.1;
                try {
                    Thread.sleep(100); // Simulate charging time
                } catch (InterruptedException e) {
                    break;
                }
            }
            isCharging = false;
        }).start();
    }
    
    public double getChargePercentage() {
        return (currentCharge / capacity) * 100;
    }
    
    public boolean discharge(double amount) {
        if (currentCharge >= amount) {
            currentCharge -= amount;
            return true;
        }
        return false;
    }
}

// Benefits of Composition:
// 1. Can reuse Battery in TeslaModelX, TeslaModel3, etc.
// 2. Can swap AutoPilotV4 with AutoPilotV5 without changing TeslaModelS
// 3. Different Tesla models can have different combinations
public class TeslaModel3 {
    private Engine engine;
    private Battery battery;
    private AutoPilot autoPilot;
    
    public TeslaModel3() {
        // Different configuration for Model 3
        this.engine = new ElectricEngine(480); // Lower HP
        this.battery = new LithiumIonBattery(75); // Smaller battery
        this.autoPilot = new AutoPilotV3(); // Older version
    }
}
```

#### Real Example: Netflix's Content System

```java
// Bad approach - Inheritance hierarchy becomes complex
/*
class Content { }
class Movie extends Content { }
class Series extends Content { }
class Documentary extends Content { }
class MovieDocumentary extends Movie, Documentary { } // Multiple inheritance not allowed!
*/

// Good approach - Composition
public class Content {
    private String id;
    private String title;
    private ContentMetadata metadata;
    private VideoFile videoFile;
    private List<AudioTrack> audioTracks;
    private List<Subtitle> subtitles;
    private ContentRating rating;
    private List<ContentTag> tags;
    
    public Content(String id, String title) {
        this.id = id;
        this.title = title;
        this.audioTracks = new ArrayList<>();
        this.subtitles = new ArrayList<>();
        this.tags = new ArrayList<>();
    }
    
    // Flexible composition
    public void setMetadata(ContentMetadata metadata) {
        this.metadata = metadata;
    }
    
    public void addAudioTrack(AudioTrack track) {
        this.audioTracks.add(track);
    }
    
    public void addSubtitle(Subtitle subtitle) {
        this.subtitles.add(subtitle);
    }
    
    public void addTag(ContentTag tag) {
        this.tags.add(tag);
    }
}

// Flexible components
public class ContentMetadata {
    private String genre;
    private int releaseYear;
    private int duration; // in minutes
    private String director;
    private List<String> cast;
    private String description;
    private boolean isOriginalContent;
    
    // Constructor and methods
}

public class MovieMetadata extends ContentMetadata {
    private String studio;
    private double boxOfficeRevenue;
    private List<String> awards;
    
    public MovieMetadata(String genre, int releaseYear, int duration, String director) {
        super(genre, releaseYear, duration, director);
        this.awards = new ArrayList<>();
    }
}

public class SeriesMetadata extends ContentMetadata {
    private int numberOfSeasons;
    private int numberOfEpisodes;
    private boolean isCompleted;
    private int episodeDuration;
    
    public SeriesMetadata(String genre, int releaseYear, String director) {
        super(genre, releaseYear, 0, director); // Duration calculated from episodes
        this.isCompleted = false;
    }
}

// Netflix content factory using composition
public class NetflixContentFactory {
    public static Content createMovie(String id, String title, MovieMetadata metadata) {
        Content content = new Content(id, title);
        content.setMetadata(metadata);
        content.addTag(new ContentTag("Movie"));
        
        if (metadata.isOriginalContent()) {
            content.addTag(new ContentTag("Netflix Original"));
        }
        
        return content;
    }
    
    public static Content createSeries(String id, String title, SeriesMetadata metadata) {
        Content content = new Content(id, title);
        content.setMetadata(metadata);
        content.addTag(new ContentTag("Series"));
        
        if (metadata.isOriginalContent()) {
            content.addTag(new ContentTag("Netflix Original"));
        }
        
        return content;
    }
    
    public static Content createDocumentary(String id, String title, ContentMetadata metadata) {
        Content content = new Content(id, title);
        content.setMetadata(metadata);
        content.addTag(new ContentTag("Documentary"));
        content.addTag(new ContentTag("Educational"));
        
        return content;
    }
}
```

### 2. SOLID Principles

#### Single Responsibility Principle (SRP)
*A class should have only one reason to change*

```java
// Bad: Multiple responsibilities
class UserService {
    public void createUser(User user) { /* ... */ }
    public void sendEmail(String email, String message) { /* ... */ }
    public void validateUser(User user) { /* ... */ }
    public void saveToDatabase(User user) { /* ... */ }
    public void logActivity(String activity) { /* ... */ }
}

// Good: Single responsibilities
class UserService {
    private EmailService emailService;
    private UserValidator validator;
    private UserRepository repository;
    private ActivityLogger logger;
    
    public UserService() {
        this.emailService = new EmailService();
        this.validator = new UserValidator();
        this.repository = new UserRepository();
        this.logger = new ActivityLogger();
    }
    
    public void createUser(User user) {
        if (validator.isValid(user)) {
            repository.save(user);
            emailService.sendWelcomeEmail(user.getEmail());
            logger.log("User created: " + user.getId());
        }
    }
}

class EmailService {
    public void sendWelcomeEmail(String email) {
        // Email sending logic
    }
    
    public void sendPasswordResetEmail(String email, String resetToken) {
        // Password reset email logic
    }
}

class UserValidator {
    public boolean isValid(User user) {
        return user.getEmail() != null && 
               user.getEmail().contains("@") &&
               user.getName() != null &&
               user.getName().length() > 0;
    }
}
```

#### Open/Closed Principle (OCP)
*Classes should be open for extension, closed for modification*

```java
// Real Example: Spotify's Music Player System
public abstract class MusicPlayer {
    protected String currentTrack;
    protected boolean isPlaying;
    
    // Template method - closed for modification
    public final void playMusic(String track) {
        loadTrack(track);
        startPlayback();
        updateUI();
    }
    
    // Open for extension
    protected abstract void loadTrack(String track);
    protected abstract void startPlayback();
    
    // Common functionality
    protected void updateUI() {
        System.out.println("Now playing: " + currentTrack);
    }
}

// Extension without modifying base class
public class SpotifyPremiumPlayer extends MusicPlayer {
    @Override
    protected void loadTrack(String track) {
        // High quality audio loading
        System.out.println("Loading " + track + " in 320kbps");
        this.currentTrack = track;
    }
    
    @Override
    protected void startPlayback() {
        // Premium features
        System.out.println("Starting premium playback with no ads");
        this.isPlaying = true;
    }
}

public class SpotifyFreePlayer extends MusicPlayer {
    private int playCount = 0;
    
    @Override
    protected void loadTrack(String track) {
        // Standard quality audio loading
        System.out.println("Loading " + track + " in 128kbps");
        this.currentTrack = track;
    }
    
    @Override
    protected void startPlayback() {
        if (playCount % 3 == 0) {
            playAdvertisement();
        }
        System.out.println("Starting free playback");
        this.isPlaying = true;
        playCount++;
    }
    
    private void playAdvertisement() {
        System.out.println("Playing 30-second advertisement...");
    }
}
```

#### Liskov Substitution Principle (LSP)
*Subtypes must be substitutable for their base types*

```java
// Real Example: AWS S3 Storage System
public abstract class CloudStorage {
    protected String bucketName;
    
    public CloudStorage(String bucketName) {
        this.bucketName = bucketName;
    }
    
    // Contract: Should upload file and return true if successful
    public abstract boolean uploadFile(String fileName, byte[] data);
    
    // Contract: Should download file and return data, null if not found
    public abstract byte[] downloadFile(String fileName);
    
    // Contract: Should delete file and return true if successful
    public abstract boolean deleteFile(String fileName);
    
    // Contract: Should return list of all files
    public abstract List<String> listFiles();
}

// Good LSP implementation - maintains contract
public class S3Storage extends CloudStorage {
    private AmazonS3 s3Client;
    
    public S3Storage(String bucketName) {
        super(bucketName);
        this.s3Client = AmazonS3ClientBuilder.defaultClient();
    }
    
    @Override
    public boolean uploadFile(String fileName, byte[] data) {
        try {
            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentLength(data.length);
            
            s3Client.putObject(bucketName, fileName, 
                new ByteArrayInputStream(data), metadata);
            return true;
        } catch (Exception e) {
            return false; // Maintains contract
        }
    }
    
    @Override
    public byte[] downloadFile(String fileName) {
        try {
            S3Object object = s3Client.getObject(bucketName, fileName);
            return object.getObjectContent().readAllBytes();
        } catch (Exception e) {
            return null; // Maintains contract
        }
    }
    
    @Override
    public boolean deleteFile(String fileName) {
        try {
            s3Client.deleteObject(bucketName, fileName);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    @Override
    public List<String> listFiles() {
        try {
            ObjectListing listing = s3Client.listObjects(bucketName);
            return listing.getObjectSummaries()
                .stream()
                .map(S3ObjectSummary::getKey)
                .collect(Collectors.toList());
        } catch (Exception e) {
            return new ArrayList<>(); // Maintains contract
        }
    }
}

// Another implementation that follows LSP
public class GoogleCloudStorage extends CloudStorage {
    private Storage storage;
    
    public GoogleCloudStorage(String bucketName) {
        super(bucketName);
        this.storage = StorageOptions.getDefaultInstance().getService();
    }
    
    @Override
    public boolean uploadFile(String fileName, byte[] data) {
        try {
            BlobId blobId = BlobId.of(bucketName, fileName);
            BlobInfo blobInfo = BlobInfo.newBuilder(blobId).build();
            storage.create(blobInfo, data);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    @Override
    public byte[] downloadFile(String fileName) {
        try {
            BlobId blobId = BlobId.of(bucketName, fileName);
            Blob blob = storage.get(blobId);
            return blob != null ? blob.getContent() : null;
        } catch (Exception e) {
            return null;
        }
    }
    
    @Override
    public boolean deleteFile(String fileName) {
        try {
            BlobId blobId = BlobId.of(bucketName, fileName);
            return storage.delete(blobId);
        } catch (Exception e) {
            return false;
        }
    }
    
    @Override
    public List<String> listFiles() {
        try {
            return StreamSupport.stream(
                storage.list(bucketName).iterateAll().spliterator(), false)
                .map(blob -> blob.getName())
                .collect(Collectors.toList());
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}

// Client code can use any CloudStorage implementation
public class FileManager {
    private CloudStorage storage;
    
    public FileManager(CloudStorage storage) {
        this.storage = storage; // LSP allows substitution
    }
    
    public void backupFiles(Map<String, byte[]> files) {
        for (Map.Entry<String, byte[]> entry : files.entrySet()) {
            boolean success = storage.uploadFile(entry.getKey(), entry.getValue());
            if (success) {
                System.out.println("Backed up: " + entry.getKey());
            }
        }
    }
    
    // Works with any CloudStorage implementation
    public void printAllFiles() {
        List<String> files = storage.listFiles();
        files.forEach(System.out::println);
    }
}
```

#### Interface Segregation Principle (ISP)
*Clients should not be forced to depend on interfaces they don't use*

```java
// Bad: Fat interface
interface WorkerInterface {
    void work();
    void eat();
    void sleep();
    void code();
    void attendMeeting();
    void writeDocumentation();
}

// Robot worker forced to implement unnecessary methods
class RobotWorker implements WorkerInterface {
    @Override
    public void work() { /* can work */ }
    
    @Override
    public void eat() { 
        throw new UnsupportedOperationException("Robots don't eat!"); 
    }
    
    @Override
    public void sleep() { 
        throw new UnsupportedOperationException("Robots don't sleep!"); 
    }
    
    // ... other unnecessary methods
}

// Good: Segregated interfaces
interface Workable {
    void work();
}

interface Eatable {
    void eat();
}

interface Sleepable {
    void sleep();
}

interface Codeable {
    void code();
}

interface Meetingable {
    void attendMeeting();
}

// Real Example: Google's Android Permission System
interface CameraPermission {
    boolean requestCameraAccess();
    void takePicture();
    void recordVideo();
}

interface LocationPermission {
    boolean requestLocationAccess();
    Location getCurrentLocation();
    void startLocationTracking();
}

interface StoragePermission {
    boolean requestStorageAccess();
    void saveFile(String fileName, byte[] data);
    byte[] readFile(String fileName);
}

interface ContactsPermission {
    boolean requestContactsAccess();
    List<Contact> getAllContacts();
    void addContact(Contact contact);
}

// Camera app only implements what it needs
public class CameraApp implements CameraPermission, StoragePermission {
    @Override
    public boolean requestCameraAccess() {
        return PermissionManager.request(Permission.CAMERA);
    }
    
    @Override
    public void takePicture() {
        if (requestCameraAccess()) {
            // Take picture logic
            byte[] imageData = CameraManager.capture();
            saveFile("IMG_" + System.currentTimeMillis() + ".jpg", imageData);
        }
    }
    
    @Override
    public void recordVideo() {
        if (requestCameraAccess()) {
            // Video recording logic
        }
    }
    
    @Override
    public boolean requestStorageAccess() {
        return PermissionManager.request(Permission.STORAGE);
    }
    
    @Override
    public void saveFile(String fileName, byte[] data) {
        if (requestStorageAccess()) {
            FileManager.save(fileName, data);
        }
    }
    
    @Override
    public byte[] readFile(String fileName) {
        if (requestStorageAccess()) {
            return FileManager.read(fileName);
        }
        return null;
    }
}

// Navigation app implements different interfaces
public class NavigationApp implements LocationPermission, ContactsPermission {
    @Override
    public boolean requestLocationAccess() {
        return PermissionManager.request(Permission.LOCATION);
    }
    
    @Override
    public Location getCurrentLocation() {
        if (requestLocationAccess()) {
            return LocationManager.getCurrentLocation();
        }
        return null;
    }
    
    @Override
    public void startLocationTracking() {
        if (requestLocationAccess()) {
            LocationManager.startTracking();
        }
    }
    
    @Override
    public boolean requestContactsAccess() {
        return PermissionManager.request(Permission.CONTACTS);
    }
    
    @Override
    public List<Contact> getAllContacts() {
        if (requestContactsAccess()) {
            return ContactManager.getAllContacts();
        }
        return new ArrayList<>();
    }
    
    @Override
    public void addContact(Contact contact) {
        if (requestContactsAccess()) {
            ContactManager.addContact(contact);
        }
    }
}
```

#### Dependency Inversion Principle (DIP)
*High-level modules should not depend on low-level modules. Both should depend on abstractions*

```java
// Real Example: Netflix's Recommendation Engine

// Bad: High-level class depends on low-level implementation
class BadRecommendationEngine {
    private MySQLUserRepository userRepo; // Direct dependency
    private RedisCache cache; // Direct dependency
    private ElasticsearchService searchService; // Direct dependency
    
    public List<Content> getRecommendations(String userId) {
        User user = userRepo.findById(userId); // Tightly coupled
        List<Content> cached = cache.get("rec_" + userId); // Tightly coupled
        
        if (cached == null) {
            cached = searchService.findSimilar(user.getPreferences()); // Tightly coupled
            cache.set("rec_" + userId, cached);
        }
        
        return cached;
    }
}

// Good: Depend on abstractions
public interface UserRepository {
    User findById(String userId);
    List<User> findSimilarUsers(String userId);
    void updatePreferences(String userId, List<String> preferences);
}

public interface CacheService {
    <T> T get(String key, Class<T> type);
    <T> void set(String key, T value, int ttlSeconds);
    void delete(String key);
}

public interface RecommendationAlgorithm {
    List<Content> generateRecommendations(User user);
    double calculateSimilarity(User user1, User user2);
}

// High-level module depends on abstractions
public class NetflixRecommendationEngine {
    private final UserRepository userRepository;
    private final CacheService cacheService;
    private final RecommendationAlgorithm algorithm;
    
    // Dependency injection through constructor
    public NetflixRecommendationEngine(UserRepository userRepository,
                                     CacheService cacheService,
                                     RecommendationAlgorithm algorithm) {
        this.userRepository = userRepository;
        this.cacheService = cacheService;
        this.algorithm = algorithm;
    }
    
    public List<Content> getPersonalizedRecommendations(String userId) {
        // Check cache first
        List<Content> cached = cacheService.get(
            "recommendations_" + userId, 
            List.class
        );
        
        if (cached != null) {
            return cached;
        }
        
        // Get user and generate recommendations
        User user = userRepository.findById(userId);
        if (user == null) {
            return new ArrayList<>();
        }
        
        List<Content> recommendations = algorithm.generateRecommendations(user);
        
        // Cache for 1 hour
        cacheService.set("recommendations_" + userId, recommendations, 3600);
        
        return recommendations;
    }
    
    public void updateUserPreferences(String userId, String contentId, Rating rating) {
        User user = userRepository.findById(userId);
        user.addRating(contentId, rating);
        
        // Update preferences based on rating
        List<String> updatedPreferences = calculateUpdatedPreferences(user);
        userRepository.updatePreferences(userId, updatedPreferences);
        
        // Invalidate cache
        cacheService.delete("recommendations_" + userId);
    }
    
    private List<String> calculateUpdatedPreferences(User user) {
        // Algorithm to update user preferences based on ratings
        return new ArrayList<>();
    }
}

// Low-level implementations
public class MongoUserRepository implements UserRepository {
    private MongoTemplate mongoTemplate;
    
    @Override
    public User findById(String userId) {
        return mongoTemplate.findById(userId, User.class);
    }
    
    @Override
    public List<User> findSimilarUsers(String userId) {
        // MongoDB-specific query
        return mongoTemplate.find(
            Query.query(Criteria.where("similarTo").is(userId)), 
            User.class
        );
    }
    
    @Override
    public void updatePreferences(String userId, List<String> preferences) {
        Update update = new Update().set("preferences", preferences);
        mongoTemplate.updateFirst(
            Query.query(Criteria.where("id").is(userId)), 
            update, 
            User.class
        );
    }
}

public class RedisCache implements CacheService {
    private RedisTemplate<String, Object> redisTemplate;
    
    @Override
    public <T> T get(String key, Class<T> type) {
        Object value = redisTemplate.opsForValue().get(key);
        return type.cast(value);
    }
    
    @Override
    public <T> void set(String key, T value, int ttlSeconds) {
        redisTemplate.opsForValue().set(key, value, Duration.ofSeconds(ttlSeconds));
    }
    
    @Override
    public void delete(String key) {
        redisTemplate.delete(key);
    }
}

// Machine learning-based recommendation algorithm
public class CollaborativeFilteringAlgorithm implements RecommendationAlgorithm {
    private MLModel model;
    private ContentService contentService;
    
    @Override
    public List<Content> generateRecommendations(User user) {
        // Use ML model to predict user preferences
        double[] userVector = vectorizeUser(user);
        double[] predictions = model.predict(userVector);
        
        // Get top content IDs
        List<String> topContentIds = getTopPredictions(predictions, 20);
        
        // Fetch actual content objects
        return contentService.getContentByIds(topContentIds);
    }
    
    @Override
    public double calculateSimilarity(User user1, User user2) {
        double[] vector1 = vectorizeUser(user1);
        double[] vector2 = vectorizeUser(user2);
        return cosineSimilarity(vector1, vector2);
    }
    
    private double[] vectorizeUser(User user) {
        // Convert user preferences to numerical vector
        return new double[0];
    }
    
    private List<String> getTopPredictions(double[] predictions, int count) {
        // Get indices of top predictions
        return new ArrayList<>();
    }
    
    private double cosineSimilarity(double[] a, double[] b) {
        // Calculate cosine similarity
        return 0.0;
    }
}

// Alternative algorithm implementation
public class ContentBasedAlgorithm implements RecommendationAlgorithm {
    private ContentAnalysisService analysisService;
    
    @Override
    public List<Content> generateRecommendations(User user) {
        // Analyze content user has liked
        List<Content> likedContent = user.getLikedContent();
        List<String> preferredGenres = analysisService.extractGenres(likedContent);
        List<String> preferredActors = analysisService.extractActors(likedContent);
        
        // Find similar content
        return analysisService.findSimilarContent(preferredGenres, preferredActors);
    }
    
    @Override
    public double calculateSimilarity(User user1, User user2) {
        Set<String> prefs1 = new HashSet<>(user1.getPreferences());
        Set<String> prefs2 = new HashSet<>(user2.getPreferences());
        
        // Jaccard similarity
        Set<String> intersection = new HashSet<>(prefs1);
        intersection.retainAll(prefs2);
        
        Set<String> union = new HashSet<>(prefs1);
        union.addAll(prefs2);
        
        return (double) intersection.size() / union.size();
    }
}

// Dependency injection configuration
public class RecommendationEngineFactory {
    public static NetflixRecommendationEngine createEngine(String algorithm) {
        UserRepository userRepo = new MongoUserRepository();
        CacheService cache = new RedisCache();
        
        RecommendationAlgorithm algo;
        if ("collaborative".equals(algorithm)) {
            algo = new CollaborativeFilteringAlgorithm();
        } else {
            algo = new ContentBasedAlgorithm();
        }
        
        return new NetflixRecommendationEngine(userRepo, cache, algo);
    }
}
```

### 3. Inner Classes and Nested Classes

```java
// Real Example: LinkedIn's Connection Manager
public class ConnectionManager {
    private List<Connection> connections;
    private ConnectionStats stats;
    
    public ConnectionManager() {
        this.connections = new ArrayList<>();
        this.stats = new ConnectionStats(); // Non-static inner class
    }
    
    // Non-static inner class - has access to outer class members
    public class ConnectionStats {
        public int getTotalConnections() {
            return connections.size(); // Can access outer class field
        }
        
        public int getConnectionsByLevel(int level) {
            return (int) connections.stream()
                .filter(conn -> conn.getLevel() == level)
                .count();
        }
        
        public double getAverageConnectionsPerMonth() {
            if (connections.isEmpty()) return 0;
            
            // Group by month and calculate average
            Map<String, Long> monthlyConnections = connections.stream()
                .collect(Collectors.groupingBy(
                    conn -> conn.getConnectedDate().toString().substring(0, 7),
                    Collectors.counting()
                ));
            
            return monthlyConnections.values().stream()
                .mapToLong(Long::longValue)
                .average()
                .orElse(0.0);
        }
    }
    
    // Static nested class - doesn't need outer class instance
    public static class ConnectionRequest {
        private String senderId;
        private String receiverId;
        private String message;
        private Date sentDate;
        private RequestStatus status;
        
        public ConnectionRequest(String senderId, String receiverId, String message) {
            this.senderId = senderId;
            this.receiverId = receiverId;
            this.message = message;
            this.sentDate = new Date();
            this.status = RequestStatus.PENDING;
        }
        
        public void accept() {
            this.status = RequestStatus.ACCEPTED;
        }
        
        public void reject() {
            this.status = RequestStatus.REJECTED;
        }
        
        // Getters and setters
        public String getSenderId() { return senderId; }
        public String getReceiverId() { return receiverId; }
        public RequestStatus getStatus() { return status; }
    }
    
    // Method using inner class
    public ConnectionStats getStats() {
        return stats;
    }
    
    // Method using static nested class
    public boolean sendConnectionRequest(String receiverId, String message) {
        String currentUserId = getCurrentUserId();
        ConnectionRequest request = new ConnectionRequest(currentUserId, receiverId, message);
        
        return NotificationService.sendConnectionRequest(request);
    }
    
    // Local class example
    public List<Connection> getMutualConnections(String userId) {
        // Local class - defined inside method
        class MutualConnectionFinder {
            private Set<String> userConnections;
            
            public MutualConnectionFinder(String userId) {
                userConnections = getUserConnections(userId);
            }
            
            public List<Connection> findMutuals() {
                return connections.stream()
                    .filter(conn -> userConnections.contains(conn.getUserId()))
                    .collect(Collectors.toList());
            }
            
            private Set<String> getUserConnections(String userId) {
                return connections.stream()
                    .filter(conn -> conn.getUserId().equals(userId))
                    .map(Connection::getConnectedUserId)
                    .collect(Collectors.toSet());
            }
        }
        
        MutualConnectionFinder finder = new MutualConnectionFinder(userId);
        return finder.findMutuals();
    }
    
    // Anonymous class example - for event handling
    public void setupConnectionListener() {
        ConnectionEventListener listener = new ConnectionEventListener() {
            @Override
            public void onConnectionAdded(Connection connection) {
                System.out.println("New connection: " + connection.getName());
                stats.getTotalConnections(); // Can access outer class through ConnectionManager.this
                
                // Send welcome message
                MessageService.sendWelcomeMessage(connection.getUserId());
            }
            
            @Override
            public void onConnectionRemoved(Connection connection) {
                System.out.println("Connection removed: " + connection.getName());
                
                // Log removal
                ActivityLogger.log("Connection removed: " + connection.getUserId());
            }
        };
        
        ConnectionEventBus.register(listener);
    }
    
    private String getCurrentUserId() {
        return "current-user-id"; // Placeholder
    }
}

// Usage example
public class LinkedInService {
    public void demonstrateInnerClasses() {
        ConnectionManager manager = new ConnectionManager();
        
        // Using non-static inner class
        ConnectionManager.ConnectionStats stats = manager.getStats();
        System.out.println("Total connections: " + stats.getTotalConnections());
        
        // Using static nested class - no outer instance needed
        ConnectionManager.ConnectionRequest request = 
            new ConnectionManager.ConnectionRequest("user1", "user2", "Let's connect!");
        request.accept();
        
        // Setup event listener with anonymous class
        manager.setupConnectionListener();
    }
}

enum RequestStatus {
    PENDING, ACCEPTED, REJECTED, EXPIRED
}

// Supporting classes
class Connection {
    private String userId;
    private String connectedUserId;
    private String name;
    private int level;
    private Date connectedDate;
    
    // Constructor and getters
    public Connection(String userId, String connectedUserId, String name) {
        this.userId = userId;
        this.connectedUserId = connectedUserId;
        this.name = name;
        this.level = 1;
        this.connectedDate = new Date();
    }
    
    public String getUserId() { return userId; }
    public String getConnectedUserId() { return connectedUserId; }
    public String getName() { return name; }
    public int getLevel() { return level; }
    public Date getConnectedDate() { return connectedDate; }
}
```

---

## Design Patterns

### 1. Creational Patterns

#### Singleton Pattern - Netflix Configuration Manager

```java
public class NetflixConfigManager {
    // Thread-safe singleton using enum
    public enum Instance {
        INSTANCE;
        
        private final ConfigManager configManager;
        
        Instance() {
            configManager = new ConfigManager();
        }
        
        public ConfigManager getConfigManager() {
            return configManager;
        }
    }
    
    private static class ConfigManager {
        private Map<String, String> configurations;
        private long lastUpdated;
        
        private ConfigManager() {
            configurations = new ConcurrentHashMap<>();
            loadConfigurations();
        }
        
        private void loadConfigurations() {
            // Load from AWS Systems Manager, Consul, etc.
            configurations.put("max_concurrent_streams", "4");
            configurations.put("video_quality_default", "HD");
            configurations.put("cache_ttl_minutes", "30");
            configurations.put("recommendation_batch_size", "50");
            lastUpdated = System.currentTimeMillis();
        }
        
        public String getConfig(String key) {
            // Auto-refresh every 5 minutes
            if (System.currentTimeMillis() - lastUpdated > 300000) {
                loadConfigurations();
            }
            return configurations.get(key);
        }
        
        public int getIntConfig(String key, int defaultValue) {
            String value = getConfig(key);
            try {
                return value != null ? Integer.parseInt(value) : defaultValue;
            } catch (NumberFormatException e) {
                return defaultValue;
            }
        }
    }
    
    // Usage
    public static ConfigManager getInstance() {
        return Instance.INSTANCE.getConfigManager();
    }
}

// Usage in Netflix services
public class StreamingService {
    public void startStream(String userId, String contentId) {
        ConfigManager config = NetflixConfigManager.getInstance();
        int maxStreams = config.getIntConfig("max_concurrent_streams", 2);
        
        if (getCurrentStreamCount(userId) >= maxStreams) {
            throw new MaxStreamsExceededException();
        }
        
        // Start streaming...
    }
}
```

#### Factory Pattern - Uber Vehicle Factory

```java
// Product hierarchy
public abstract class Vehicle {
    protected String vehicleId;
    protected String licensePlate;
    protected VehicleType type;
    protected Driver driver;
    
    public Vehicle(String vehicleId, String licensePlate) {
        this.vehicleId = vehicleId;
        this.licensePlate = licensePlate;
    }
    
    public abstract double calculateFare(double distance, int duration);
    public abstract boolean canAcceptRide(RideRequest request);
    public abstract int getCapacity();
    
    // Common methods
    public void assignDriver(Driver driver) {
        this.driver = driver;
    }
    
    public String getVehicleId() { return vehicleId; }
    public VehicleType getType() { return type; }
}

// Concrete products
public class UberX extends Vehicle {
    public UberX(String vehicleId, String licensePlate) {
        super(vehicleId, licensePlate);
        this.type = VehicleType.UBERX;
    }
    
    @Override
    public double calculateFare(double distance, int duration) {
        double baseFare = 2.55;
        double perMile = 1.35;
        double perMinute = 0.35;
        return baseFare + (distance * perMile) + (duration * perMinute);
    }
    
    @Override
    public boolean canAcceptRide(RideRequest request) {
        return request.getPassengerCount() <= 4;
    }
    
    @Override
    public int getCapacity() {
        return 4;
    }
}

public class UberXL extends Vehicle {
    public UberXL(String vehicleId, String licensePlate) {
        super(vehicleId, licensePlate);
        this.type = VehicleType.UBERXL;
    }
    
    @Override
    public double calculateFare(double distance, int duration) {
        double baseFare = 3.85;
        double perMile = 2.15;
        double perMinute = 0.55;
        return baseFare + (distance * perMile) + (duration * perMinute);
    }
    
    @Override
    public boolean canAcceptRide(RideRequest request) {
        return request.getPassengerCount() <= 6;
    }
    
    @Override
    public int getCapacity() {
        return 6;
    }
}

public class UberBlack extends Vehicle {
    public UberBlack(String vehicleId, String licensePlate) {
        super(vehicleId, licensePlate);
        this.type = VehicleType.UBERBLACK;
    }
    
    @Override
    public double calculateFare(double distance, int duration) {
        double baseFare = 7.00;
        double perMile = 3.75;
        double perMinute = 0.85;
        return baseFare + (distance * perMile) + (duration * perMinute);
    }
    
    @Override
    public boolean canAcceptRide(RideRequest request) {
        return request.getPassengerCount() <= 4 && request.isPremiumRequested();
    }
    
    @Override
    public int getCapacity() {
        return 4;
    }
}

// Factory interface
public abstract class VehicleFactory {
    public abstract Vehicle createVehicle(String vehicleId, String licensePlate);
    
    // Template method
    public Vehicle registerVehicle(String vehicleId, String licensePlate, Driver driver) {
        Vehicle vehicle = createVehicle(vehicleId, licensePlate);
        vehicle.assignDriver(driver);
        
        // Register with fleet management
        FleetManager.registerVehicle(vehicle);
        
        return vehicle;
    }
}

// Concrete factories
public class UberXFactory extends VehicleFactory {
    @Override
    public Vehicle createVehicle(String vehicleId, String licensePlate) {
        return new UberX(vehicleId, licensePlate);
    }
}

public class UberXLFactory extends VehicleFactory {
    @Override
    public Vehicle createVehicle(String vehicleId, String licensePlate) {
        return new UberXL(vehicleId, licensePlate);
    }
}

public class UberBlackFactory extends VehicleFactory {
    @Override
    public Vehicle createVehicle(String vehicleId, String licensePlate) {
        return new UberBlack(vehicleId, licensePlate);
    }
}

// Factory registry
public class VehicleFactoryRegistry {
    private static Map<VehicleType, VehicleFactory> factories = new HashMap<>();
    
    static {
        factories.put(VehicleType.UBERX, new UberXFactory());
        factories.put(VehicleType.UBERXL, new UberXLFactory());
        factories.put(VehicleType.UBERBLACK, new UberBlackFactory());
    }
    
    public static Vehicle createVehicle(VehicleType type, String vehicleId, 
                                      String licensePlate, Driver driver) {
        VehicleFactory factory = factories.get(type);
        if (factory == null) {
            throw new IllegalArgumentException("Unknown vehicle type: " + type);
        }
        
        return factory.registerVehicle(vehicleId, licensePlate, driver);
    }
}

// Usage in Uber's fleet management system
public class UberFleetService {
    public void onboardNewVehicle(VehicleOnboardingRequest request) {
        Vehicle vehicle = VehicleFactoryRegistry.createVehicle(
            request.getVehicleType(),
            request.getVehicleId(),
            request.getLicensePlate(),
            request.getDriver()
        );
        
        System.out.println("Onboarded new " + vehicle.getType() + 
                          " with capacity " + vehicle.getCapacity());
    }
}
```

#### Builder Pattern - Amazon Product Builder

```java
// Complex product with many optional parameters
public class Product {
    // Required parameters
    private final String productId;
    private final String name;
    private final double price;
    
    // Optional parameters
    private final String description;
    private final String category;
    private final String brand;
    private final List<String> images;
    private final List<String> tags;
    private final Map<String, String> specifications;
    private final double weight;
    private final Dimensions dimensions;
    private final boolean isPrime;
    private final boolean isNewRelease;
    private final boolean isBestSeller;
    private final int stockQuantity;
    private final double rating;
    private final int reviewCount;
    
    // Private constructor - only builder can create
    private Product(ProductBuilder builder) {
        this.productId = builder.productId;
        this.name = builder.name;
        this.price = builder.price;
        this.description = builder.description;
        this.category = builder.category;
        this.brand = builder.brand;
        this.images = builder.images != null ? new ArrayList<>(builder.images) : new ArrayList<>();
        this.tags = builder.tags != null ? new ArrayList<>(builder.tags) : new ArrayList<>();
        this.specifications = builder.specifications != null ? 
            new HashMap<>(builder.specifications) : new HashMap<>();
        this.weight = builder.weight;
        this.dimensions = builder.dimensions;
        this.isPrime = builder.isPrime;
        this.isNewRelease = builder.isNewRelease;
        this.isBestSeller = builder.isBestSeller;
        this.stockQuantity = builder.stockQuantity;
        this.rating = builder.rating;
        this.reviewCount = builder.reviewCount;
    }
    
    // Static nested Builder class
    public static class ProductBuilder {
        // Required parameters
        private final String productId;
        private final String name;
        private final double price;
        
        // Optional parameters with default values
        private String description = "";
        private String category = "General";
        private String brand = "";
        private List<String> images = new ArrayList<>();
        private List<String> tags = new ArrayList<>();
        private Map<String, String> specifications = new HashMap<>();
        private double weight = 0.0;
        private Dimensions dimensions = new Dimensions(0, 0, 0);
        private boolean isPrime = false;
        private boolean isNewRelease = false;
        private boolean isBestSeller = false;
        private int stockQuantity = 0;
        private double rating = 0.0;
        private int reviewCount = 0;
        
        // Constructor with required parameters
        public ProductBuilder(String productId, String name, double price) {
            if (productId == null || productId.trim().isEmpty()) {
                throw new IllegalArgumentException("Product ID cannot be null or empty");
            }
            if (name == null || name.trim().isEmpty()) {
                throw new IllegalArgumentException("Product name cannot be null or empty");
            }
            if (price < 0) {
                throw new IllegalArgumentException("Price cannot be negative");
            }
            
            this.productId = productId;
            this.name = name;
            this.price = price;
        }
        
        public ProductBuilder description(String description) {
            this.description = description != null ? description : "";
            return this;
        }
        
        public ProductBuilder category(String category) {
            this.category = category != null ? category : "General";
            return this;
        }
        
        public ProductBuilder brand(String brand) {
            this.brand = brand != null ? brand : "";
            return this;
        }
        
        public ProductBuilder addImage(String imageUrl) {
            if (imageUrl != null && !imageUrl.trim().isEmpty()) {
                this.images.add(imageUrl);
            }
            return this;
        }
        
        public ProductBuilder images(List<String> images) {
            if (images != null) {
                this.images = new ArrayList<>(images);
            }
            return this;
        }
        
        public ProductBuilder addTag(String tag) {
            if (tag != null && !tag.trim().isEmpty()) {
                this.tags.add(tag);
            }
            return this;
        }
        
        public ProductBuilder tags(List<String> tags) {
            if (tags != null) {
                this.tags = new ArrayList<>(tags);
            }
            return this;
        }
        
        public ProductBuilder addSpecification(String key, String value) {
            if (key != null && value != null) {
                this.specifications.put(key, value);
            }
            return this;
        }
        
        public ProductBuilder specifications(Map<String, String> specifications) {
            if (specifications != null) {
                this.specifications = new HashMap<>(specifications);
            }
            return this;
        }
        
        public ProductBuilder weight(double weight) {
            this.weight = Math.max(0, weight);
            return this;
        }
        
        public ProductBuilder dimensions(double length, double width, double height) {
            this.dimensions = new Dimensions(length, width, height);
            return this;
        }
        
        public ProductBuilder prime(boolean isPrime) {
            this.isPrime = isPrime;
            return this;
        }
        
        public ProductBuilder newRelease(boolean isNewRelease) {
            this.isNewRelease = isNewRelease;
            return this;
        }
        
        public ProductBuilder bestSeller(boolean isBestSeller) {
            this.isBestSeller = isBestSeller;
            return this;
        }
        
        public ProductBuilder stock(int quantity) {
            this.stockQuantity = Math.max(0, quantity);
            return this;
        }
        
        public ProductBuilder rating(double rating, int reviewCount) {
            this.rating = Math.max(0, Math.min(5, rating));
            this.reviewCount = Math.max(0, reviewCount);
            return this;
        }
        
        // Validation before building
        public Product build() {
            validate();
            return new Product(this);
        }
        
        private void validate() {
            if (isPrime && stockQuantity == 0) {
                throw new IllegalStateException("Prime products must be in stock");
            }
            
            if (isBestSeller && rating < 4.0) {
                throw new IllegalStateException("Best sellers must have rating >= 4.0");
            }
            
            if (!images.isEmpty() && images.size() > 10) {
                throw new IllegalStateException("Maximum 10 images allowed");
            }
        }
    }
    
    // Getters
    public String getProductId() { return productId; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public String getDescription() { return description; }
    public String getCategory() { return category; }
    public String getBrand() { return brand; }
    public List<String> getImages() { return new ArrayList<>(images); }
    public List<String> getTags() { return new ArrayList<>(tags); }
    public Map<String, String> getSpecifications() { return new HashMap<>(specifications); }
    public double getWeight() { return weight; }
    public Dimensions getDimensions() { return dimensions; }
    public boolean isPrime() { return isPrime; }
    public boolean isNewRelease() { return isNewRelease; }
    public boolean isBestSeller() { return isBestSeller; }
    public int getStockQuantity() { return stockQuantity; }
    public double getRating() { return rating; }
    public int getReviewCount() { return reviewCount; }
    
    @Override
    public String toString() {
        return "Product{" +
               "id='" + productId + '\'' +
               ", name='" + name + '\'' +
               ", price=" + price +
               ", prime=" + isPrime +
               ", stock=" + stockQuantity +
               '}';
    }
}

// Supporting classes
public class Dimensions {
    private final double length;
    private final double width;
    private final double height;
    
    public Dimensions(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }
    
    // Getters
    public double getLength() { return length; }
    public double getWidth() { return width; }
    public double getHeight() { return height; }
    
    public double getVolume() {
        return length * width * height;
    }
}

// Usage in Amazon's product management system
public class AmazonProductService {
    public void createElectronicsProduct() {
        Product laptop = new Product.ProductBuilder("LAPTOP-001", "MacBook Pro 16", 2399.00)
            .description("Apple MacBook Pro 16-inch with M2 Pro chip")
            .category("Electronics")
            .brand("Apple")
            .addImage("https://images.amazon.com/laptop1.jpg")
            .addImage("https://images.amazon.com/laptop2.jpg")
            .addTag("laptop")
            .addTag("apple")
            .addTag("macbook")
            .addSpecification("Processor", "Apple M2 Pro")
            .addSpecification("RAM", "16GB")
            .addSpecification("Storage", "512GB SSD")
            .addSpecification("Display", "16-inch Liquid Retina XDR")
            .weight(4.7)
            .dimensions(35.57, 24.81, 1.68)
            .prime(true)
            .newRelease(true)
            .stock(50)
            .rating(4.6, 1247)
            .build();
        
        System.out.println("Created product: " + laptop);
        ProductCatalogService.addProduct(laptop);
    }
    
    public void createBookProduct() {
        Product book = new Product.ProductBuilder("BOOK-002", "Clean Code", 42.99)
            .description("A Handbook of Agile Software Craftsmanship")
            .category("Books")
            .brand("Prentice Hall")
            .addImage("https://images.amazon.com/book1.jpg")
            .addTag("programming")
            .addTag("software development")
            .addTag("clean code")
            .addSpecification("Author", "Robert C. Martin")
            .addSpecification("Pages", "464")
            .addSpecification("Language", "English")
            .addSpecification("ISBN", "978-0132350884")
            .weight(0.9)
            .dimensions(23.5, 17.8, 2.3)
            .prime(true)
            .bestSeller(true)
            .stock(100)
            .rating(4.7, 2891)
            .build();
        
        ProductCatalogService.addProduct(book);
    }
    
    // Builder with method chaining for different product types
    public void createBulkProducts() {
        List<Product> products = Arrays.asList(
            // Electronics
            new Product.ProductBuilder("TV-001", "Samsung 55\" Smart TV", 899.99)
                .category("Electronics").brand("Samsung").prime(true).stock(25).build(),
                
            // Clothing
            new Product.ProductBuilder("SHIRT-001", "Nike Dri-FIT T-Shirt", 29.99)
                .category("Clothing").brand("Nike").addTag("athletic").stock(200).build(),
                
            // Home & Kitchen
            new Product.ProductBuilder("COFFEE-001", "Keurig Coffee Maker", 129.99)
                .category("Home & Kitchen").brand("Keurig").prime(true).stock(75).build()
        );
        
        products.forEach(ProductCatalogService::addProduct);
    }
}

// Mock service for demonstration
class ProductCatalogService {
    public static void addProduct(Product product) {
        System.out.println("Added to catalog: " + product.getName());
    }
}
```

### 2. Structural Patterns

#### Adapter Pattern - Google Maps Integration

```java
// Target interface that our application expects
public interface MapService {
    Location getCurrentLocation();
    List<Location> searchPlaces(String query, Location center, double radiusKm);
    Route calculateRoute(Location from, Location to, TravelMode mode);
    double calculateDistance(Location from, Location to);
}

// Third-party Google Maps API (Adaptee)
public class GoogleMapsAPI {
    private String apiKey;
    
    public GoogleMapsAPI(String apiKey) {
        this.apiKey = apiKey;
    }
    
    // Different method signatures and return types
    public GoogleLocation getCurrentGeoLocation() {
        // Google-specific implementation
        return new GoogleLocation(37.7749, -122.4194);
    }
    
    public GooglePlaceResult[] findNearbyPlaces(String searchTerm, 
                                               GoogleLocation center, 
                                               int radiusMeters) {
        // Google Places API call
        GooglePlaceResult[] results = new GooglePlaceResult[3];
        results[0] = new GooglePlaceResult("Starbucks", new GoogleLocation(37.7750, -122.4190));
        results[1] = new GooglePlaceResult("McDonald's", new GoogleLocation(37.7748, -122.4195));
        results[2] = new GooglePlaceResult("Subway", new GoogleLocation(37.7751, -122.4188));
        return results;
    }
    
    public GoogleDirectionsResponse getDirections(GoogleLocation origin,
                                                 GoogleLocation destination,
                                                 GoogleTravelMode mode) {
        // Google Directions API call
        return new GoogleDirectionsResponse(
            new GoogleLocation[]{origin, destination},
            15.2, // distance in km
            18 // duration in minutes
        );
    }
}

// Adapter class
public class GoogleMapsAdapter implements MapService {
    private GoogleMapsAPI googleMapsAPI;
    
    public GoogleMapsAdapter(String apiKey) {
        this.googleMapsAPI = new GoogleMapsAPI(apiKey);
    }
    
    @Override
    public Location getCurrentLocation() {
        GoogleLocation googleLoc = googleMapsAPI.getCurrentGeoLocation();
        // Convert Google's format to our format
        return new Location(googleLoc.getLat(), googleLoc.getLng());
    }
    
    @Override
    public List<Location> searchPlaces(String query, Location center, double radiusKm) {
        // Convert our format to Google's format
        GoogleLocation googleCenter = new GoogleLocation(center.getLatitude(), center.getLongitude());
        int radiusMeters = (int) (radiusKm * 1000);
        
        GooglePlaceResult[] googleResults = googleMapsAPI.findNearbyPlaces(query, googleCenter, radiusMeters);
        
        // Convert Google's results to our format
        return Arrays.stream(googleResults)
            .map(result -> new Location(
                result.getLocation().getLat(),
                result.getLocation().getLng(),
                result.getName()
            ))
            .collect(Collectors.toList());
    }
    
    @Override
    public Route calculateRoute(Location from, Location to, TravelMode mode) {
        GoogleLocation googleFrom = new GoogleLocation(from.getLatitude(), from.getLongitude());
        GoogleLocation googleTo = new GoogleLocation(to.getLatitude(), to.getLongitude());
        GoogleTravelMode googleMode = convertTravelMode(mode);
        
        GoogleDirectionsResponse response = googleMapsAPI.getDirections(googleFrom, googleTo, googleMode);
        
        // Convert response to our format
        List<Location> waypoints = Arrays.stream(response.getWaypoints())
            .map(wp -> new Location(wp.getLat(), wp.getLng()))
            .collect(Collectors.toList());
            
        return new Route(waypoints, response.getDistanceKm(), response.getDurationMinutes());
    }
    
    @Override
    public double calculateDistance(Location from, Location to) {
        Route route = calculateRoute(from, to, TravelMode.DRIVING);
        return route.getDistance();
    }
    
    private GoogleTravelMode convertTravelMode(TravelMode mode) {
        switch (mode) {
            case WALKING: return GoogleTravelMode.WALKING;
            case DRIVING: return GoogleTravelMode.DRIVING;
            case TRANSIT: return GoogleTravelMode.TRANSIT;
            case BICYCLING: return GoogleTravelMode.BICYCLING;
            default: return GoogleTravelMode.DRIVING;
        }
    }
}

// Alternative adapter for Apple Maps
public class AppleMapsAdapter implements MapService {
    private AppleMapsSDK appleMapsSDK;
    
    public AppleMapsAdapter() {
        this.appleMapsSDK = new AppleMapsSDK();
    }
    
    @Override
    public Location getCurrentLocation() {
        AppleCoordinate coord = appleMapsSDK.getUserLocation();
        return new Location(coord.latitude, coord.longitude);
    }
    
    @Override
    public List<Location> searchPlaces(String query, Location center, double radiusKm) {
        AppleCoordinate appleCenter = new AppleCoordinate(center.getLatitude(), center.getLongitude());
        AppleSearchRequest request = new AppleSearchRequest(query, appleCenter, radiusKm);
        
        AppleSearchResult[] results = appleMapsSDK.performSearch(request);
        
        return Arrays.stream(results)
            .map(result -> new Location(
                result.coordinate.latitude,
                result.coordinate.longitude,
                result.name
            ))
            .collect(Collectors.toList());
    }
    
    @Override
    public Route calculateRoute(Location from, Location to, TravelMode mode) {
        AppleCoordinate appleFrom = new AppleCoordinate(from.getLatitude(), from.getLongitude());
        AppleCoordinate appleTo = new AppleCoordinate(to.getLatitude(), to.getLongitude());
        
        AppleRoute appleRoute = appleMapsSDK.calculateRoute(appleFrom, appleTo, convertTravelMode(mode));
        
        List<Location> waypoints = Arrays.stream(appleRoute.coordinates)
            .map(coord -> new Location(coord.latitude, coord.longitude))
            .collect(Collectors.toList());
            
        return new Route(waypoints, appleRoute.distanceKm, appleRoute.estimatedTimeMinutes);
    }
    
    @Override
    public double calculateDistance(Location from, Location to) {
        Route route = calculateRoute(from, to, TravelMode.DRIVING);
        return route.getDistance();
    }
    
    private AppleTravelMode convertTravelMode(TravelMode mode) {
        switch (mode) {
            case WALKING: return AppleTravelMode.WALKING;
            case DRIVING: return AppleTravelMode.AUTOMOBILE;
            case TRANSIT: return AppleTravelMode.TRANSIT;
            default: return AppleTravelMode.AUTOMOBILE;
        }
    }
}

// Usage in Uber/Lyft-like application
public class RideShareService {
    private MapService mapService;
    
    public RideShareService(MapService mapService) {
        this.mapService = mapService; // Can be any implementation
    }
    
    public List<Driver> findNearbyDrivers(Location passengerLocation) {
        // Use adapter to search for nearby drivers
        List<Location> nearbyPlaces = mapService.searchPlaces("drivers", passengerLocation, 5.0);
        
        return nearbyPlaces.stream()
            .map(this::convertToDriver)
            .collect(Collectors.toList());
    }
    
    public RideEstimate calculateRideEstimate(Location pickup, Location destination) {
        Route route = mapService.calculateRoute(pickup, destination, TravelMode.DRIVING);
        
        double baseFare = 2.55;
        double perKmRate = 1.75;
        double perMinuteRate = 0.35;
        
        double fare = baseFare + (route.getDistance() * perKmRate) + (route.getDuration() * perMinuteRate);
        
        return new RideEstimate(route.getDistance(), route.getDuration(), fare);
    }
    
    private Driver convertToDriver(Location location) {
        // Convert location to driver (mock implementation)
        return new Driver("driver-" + location.hashCode(), location);
    }
}

// Client code - can switch between different map providers
public class MapsDemo {
    public void demonstrateAdapter() {
        // Can easily switch between different map services
        MapService googleMaps = new GoogleMapsAdapter("your-google-api-key");
        MapService appleMaps = new AppleMapsAdapter();
        
        RideShareService uberWithGoogle = new RideShareService(googleMaps);
        RideShareService uberWithApple = new RideShareService(appleMaps);
        
        Location currentLocation = new Location(37.7749, -122.4194, "San Francisco");
        
        // Same interface, different implementations
        List<Driver> driversFromGoogle = uberWithGoogle.findNearbyDrivers(currentLocation);
        List<Driver> driversFromApple = uberWithApple.findNearbyDrivers(currentLocation);
        
        System.out.println("Drivers found via Google: " + driversFromGoogle.size());
        System.out.println("Drivers found via Apple: " + driversFromApple.size());
    }
}
```

### 3. Behavioral Patterns

#### Observer Pattern - YouTube Notification System

```java
// Subject interface
public interface YouTubeChannel {
    void subscribe(Subscriber subscriber);
    void unsubscribe(Subscriber subscriber);
    void notifySubscribers(Video video);
}

// Observer interface
public interface Subscriber {
    void onNewVideo(String channelName, Video video);
    void onChannelUpdate(String channelName, String updateType);
    String getSubscriberId();
}

// Concrete Subject
public class YouTubeChannelImpl implements YouTubeChannel {
    private String channelName;
    private String channelId;
    private List<Subscriber> subscribers;
    private List<Video> videos;
    private int subscriberCount;
    private boolean isVerified;
    
    public YouTubeChannelImpl(String channelName, String channelId) {
        this.channelName = channelName;
        this.channelId = channelId;
        this.subscribers = new ArrayList<>();
        this.videos = new ArrayList<>();
        this.subscriberCount = 0;
        this.isVerified = false;
    }
    
    @Override
    public void subscribe(Subscriber subscriber) {
        if (!subscribers.contains(subscriber)) {
            subscribers.add(subscriber);
            subscriberCount++;
            System.out.println(subscriber.getSubscriberId() + " subscribed to " + channelName);
            
            // Send welcome notification
            if (!videos.isEmpty()) {
                Video latestVideo = videos.get(videos.size() - 1);
                subscriber.onNewVideo(channelName, latestVideo);
            }
        }
    }
    
    @Override
    public void unsubscribe(Subscriber subscriber) {
        if (subscribers.remove(subscriber)) {
            subscriberCount--;
            System.out.println(subscriber.getSubscriberId() + " unsubscribed from " + channelName);
        }
    }
    
    @Override
    public void notifySubscribers(Video video) {
        System.out.println("Notifying " + subscribers.size() + " subscribers about new video: " + video.getTitle());
        
        // Notify in batches to avoid overwhelming the system
        int batchSize = 1000;
        for (int i = 0; i < subscribers.size(); i += batchSize) {
            List<Subscriber> batch = subscribers.subList(i, Math.min(i + batchSize, subscribers.size()));
            
            // Async notification to avoid blocking
            CompletableFuture.runAsync(() -> {
                for (Subscriber subscriber : batch) {
                    try {
                        subscriber.onNewVideo(channelName, video);
                    } catch (Exception e) {
                        System.err.println("Failed to notify subscriber: " + subscriber.getSubscriberId());
                    }
                }
            });
        }
    }
    
    public void uploadVideo(Video video) {
        videos.add(video);
        System.out.println("New video uploaded: " + video.getTitle());
        notifySubscribers(video);
        
        // Update channel stats
        if (subscriberCount >= 100000 && !isVerified) {
            isVerified = true;
            notifyChannelUpdate("VERIFICATION");
        }
    }
    
    public void updateChannelInfo(String newChannelName) {
        this.channelName = newChannelName;
        notifyChannelUpdate("NAME_CHANGE");
    }
    
    private void notifyChannelUpdate(String updateType) {
        for (Subscriber subscriber : subscribers) {
            subscriber.onChannelUpdate(channelName, updateType);
        }
    }
    
    // Getters
    public String getChannelName() { return channelName; }
    public int getSubscriberCount() { return subscriberCount; }
    public List<Video> getVideos() { return new ArrayList<>(videos); }
}

// Concrete Observer - Regular User
public class RegularUser implements Subscriber {
    private String userId;
    private String userName;
    private List<String> interests;
    private NotificationPreferences preferences;
    
    public RegularUser(String userId, String userName) {
        this.userId = userId;
        this.userName = userName;
        this.interests = new ArrayList<>();
        this.preferences = new NotificationPreferences();
    }
    
    @Override
    public void onNewVideo(String channelName, Video video) {
        if (!preferences.isNotificationsEnabled()) {
            return;
        }
        
        // Check if user is interested in this type of content
        boolean isInterested = interests.isEmpty() || 
            interests.stream().anyMatch(interest -> video.getTags().contains(interest));
        
        if (isInterested) {
            System.out.println("📱 " + userName + ": New video from " + channelName + " - " + video.getTitle());
            
            // Add to watch later if user preference is set
            if (preferences.isAutoAddToWatchLater()) {
                addToWatchLater(video);
            }
        }
    }
    
    @Override
    public void onChannelUpdate(String channelName, String updateType) {
        if (preferences.isChannelUpdatesEnabled()) {
            switch (updateType) {
                case "VERIFICATION":
                    System.out.println("🎉 " + userName + ": " + channelName + " is now verified!");
                    break;
                case "NAME_CHANGE":
                    System.out.println("📝 " + userName + ": " + channelName + " updated their channel name");
                    break;
            }
        }
    }
    
    @Override
    public String getSubscriberId() {
        return userId;
    }
    
    public void addInterest(String interest) {
        interests.add(interest);
    }
    
    public void updateNotificationPreferences(NotificationPreferences preferences) {
        this.preferences = preferences;
    }
    
    private void addToWatchLater(Video video) {
        System.out.println("➕ Added '" + video.getTitle() + "' to " + userName + "'s Watch Later");
    }
}

// Another Concrete Observer - Content Creator
public class ContentCreator implements Subscriber {
    private String creatorId;
    private String channelName;
    private List<String> competitorChannels;
    private AnalyticsService analytics;
    
    public ContentCreator(String creatorId, String channelName) {
        this.creatorId = creatorId;
        this.channelName = channelName;
        this.competitorChannels = new ArrayList<>();
        this.analytics = new AnalyticsService();
    }
    
    @Override
    public void onNewVideo(String channelName, Video video) {
        if (competitorChannels.contains(channelName)) {
            // Analyze competitor content
            System.out.println("🔍 " + this.channelName + " analyzing competitor video: " + video.getTitle());
            
            ContentAnalysis analysis = analytics.analyzeCompetitorContent(video);
            if (analysis.isPerformingWell()) {
                System.out.println("💡 Trending topic detected: " + String.join(", ", video.getTags()));
                considerCreatingSimilarContent(video);
            }
        } else {
            // Regular subscription notification
            System.out.println("📺 " + this.channelName + " creator: New video from " + channelName);
        }
    }
    
    @Override
    public void onChannelUpdate(String channelName, String updateType) {
        if ("VERIFICATION".equals(updateType) && competitorChannels.contains(channelName)) {
            System.out.println("⚠️ Competitor " + channelName + " got verified - time to step up!");
        }
    }
    
    @Override
    public String getSubscriberId() {
        return creatorId;
    }
    
    public void addCompetitor(String competitorChannel) {
        competitorChannels.add(competitorChannel);
    }
    
    private void considerCreatingSimilarContent(Video video) {
        System.out.println("📝 " + channelName + " adding to content calendar: " + video.getTitle() + " inspired content");
    }
}

// Another Observer - Brand/Marketing Agency
public class BrandAccount implements Subscriber {
    private String brandId;
    private String brandName;
    private List<String> targetKeywords;
    private double sponsorshipBudget;
    
    public BrandAccount(String brandId, String brandName, double sponsorshipBudget) {
        this.brandId = brandId;
        this.brandName = brandName;
        this.sponsorshipBudget = sponsorshipBudget;
        this.targetKeywords = new ArrayList<>();
    }
    
    @Override
    public void onNewVideo(String channelName, Video video) {
        // Check for sponsorship opportunities
        boolean isRelevant = targetKeywords.stream()
            .anyMatch(keyword -> video.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
                               video.getTags().contains(keyword));
        
        if (isRelevant && video.getViewCount() > 100000) {
            System.out.println("💼 " + brandName + ": Potential sponsorship opportunity with " + channelName);
            System.out.println("    Video: " + video.getTitle() + " (" + video.getViewCount() + " views)");
            
            if (shouldReachOut(video)) {
                initiateSponsorship(channelName, video);
            }
        }
    }
    
    @Override
    public void onChannelUpdate(String channelName, String updateType) {
        if ("VERIFICATION".equals(updateType)) {
            System.out.println("⭐ " + brandName + ": " + channelName + " verification increases sponsorship value");
        }
    }
    
    @Override
    public String getSubscriberId() {
        return brandId;
    }
    
    public void addTargetKeyword(String keyword) {
        targetKeywords.add(keyword);
    }
    
    private boolean shouldReachOut(Video video) {
        double estimatedCost = video.getViewCount() * 0.001; // $1 per 1000 views
        return estimatedCost <= sponsorshipBudget;
    }
    
    private void initiateSponsorship(String channelName, Video video) {
        System.out.println("📧 " + brandName + " reaching out to " + channelName + " for sponsorship");
    }
}

// Supporting classes
public class Video {
    private String videoId;
    private String title;
    private String description;
    private List<String> tags;
    private int viewCount;
    private int likeCount;
    private Date uploadDate;
    private int durationSeconds;
    
    public Video(String videoId, String title, String description) {
        this.videoId = videoId;
        this.title = title;
        this.description = description;
        this.tags = new ArrayList<>();
        this.viewCount = 0;
        this.likeCount = 0;
        this.uploadDate = new Date();
    }
    
    public void addTag(String tag) { tags.add(tag); }
    public void incrementViews() { viewCount++; }
    
    // Getters
    public String getVideoId() { return videoId; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public List<String> getTags() { return new ArrayList<>(tags); }
    public int getViewCount() { return viewCount; }
    public int getLikeCount() { return likeCount; }
    public Date getUploadDate() { return uploadDate; }
}

public class NotificationPreferences {
    private boolean notificationsEnabled = true;
    private boolean channelUpdatesEnabled = true;
    private boolean autoAddToWatchLater = false;
    
    // Getters and setters
    public boolean isNotificationsEnabled() { return notificationsEnabled; }
    public void setNotificationsEnabled(boolean enabled) { this.notificationsEnabled = enabled; }
    
    public boolean isChannelUpdatesEnabled() { return channelUpdatesEnabled; }
    public void setChannelUpdatesEnabled(boolean enabled) { this.channelUpdatesEnabled = enabled; }
    
    public boolean isAutoAddToWatchLater() { return autoAddToWatchLater; }
    public void setAutoAddToWatchLater(boolean enabled) { this.autoAddToWatchLater = enabled; }
}

// Mock services
class AnalyticsService {
    public ContentAnalysis analyzeCompetitorContent(Video video) {
        // Simulate content analysis
        boolean isPerformingWell = video.getViewCount() > 50000;
        return new ContentAnalysis(isPerformingWell);
    }
}

class ContentAnalysis {
    private boolean performingWell;
    
    public ContentAnalysis(boolean performingWell) {
        this.performingWell = performingWell;
    }
    
    public boolean isPerformingWell() { return performingWell; }
}

// Usage demonstration
public class YouTubeNotificationDemo {
    public void demonstrateObserverPattern() {
        // Create YouTube channel
        YouTubeChannelImpl techChannel = new YouTubeChannelImpl("TechReviews Pro", "tech-channel-123");
        
        // Create different types of subscribers
        RegularUser alice = new RegularUser("user-001", "Alice");
        alice.addInterest("technology");
        alice.addInterest("reviews");
        
        RegularUser bob = new RegularUser("user-002", "Bob");
        NotificationPreferences bobPrefs = new NotificationPreferences();
        bobPrefs.setAutoAddToWatchLater(true);
        bob.updateNotificationPreferences(bobPrefs);
        
        ContentCreator competitor = new ContentCreator("creator-001", "Tech Insights");
        competitor.addCompetitor("TechReviews Pro");
        
        BrandAccount techBrand = new BrandAccount("brand-001", "TechCorp", 5000.0);
        techBrand.addTargetKeyword("smartphone");
        techBrand.addTargetKeyword("laptop");
        
        // Subscribe all users
        techChannel.subscribe(alice);
        techChannel.subscribe(bob);
        techChannel.subscribe(competitor);
        techChannel.subscribe(techBrand);
        
        System.out.println("=== Initial Subscriptions Complete ===\n");
        
        // Upload new video - all subscribers get notified
        Video newVideo = new Video("vid-001", "iPhone 15 Pro Max Review", "Complete review of the latest iPhone");
        newVideo.addTag("smartphone");
        newVideo.addTag("apple");
        newVideo.addTag("review");
        // Simulate some views for brand interest
        for (int i = 0; i < 150000; i++) newVideo.incrementViews();
        
        techChannel.uploadVideo(newVideo);
        
        System.out.println("\n=== Video Upload Notifications Complete ===\n");
        
        // Channel gets verified - another type of notification
        techChannel.updateChannelInfo("TechReviews Pro ✓");
        
        System.out.println("\n=== Channel Update Notifications Complete ===\n");
        
        // User unsubscribes
        techChannel.unsubscribe(bob);
        
        // Upload another video - Bob won't get notified
        Video anotherVideo = new Video("vid-002", "Best Gaming Laptops 2024", "Top gaming laptops review");
        anotherVideo.addTag("laptop");
        anotherVideo.addTag("gaming");
        techChannel.uploadVideo(anotherVideo);
    }
}
```

#### Strategy Pattern - Netflix Content Recommendation

```java
// Strategy interface
public interface RecommendationStrategy {
    List<Content> recommend(User user, int maxResults);
    String getStrategyName();
    double getConfidenceScore(User user);
}

// Concrete Strategy 1: Collaborative Filtering
public class CollaborativeFilteringStrategy implements RecommendationStrategy {
    private UserSimilarityService similarityService;
    private ContentService contentService;
    
    public CollaborativeFilteringStrategy() {
        this.similarityService = new UserSimilarityService();
        this.contentService = new ContentService();
    }
    
    @Override
    public List<Content> recommend(User user, int maxResults) {
        System.out.println("Using Collaborative Filtering for user: " + user.getName());
        
        // Find similar users
        List<User> similarUsers = similarityService.findSimilarUsers(user, 100);
        
        // Get content liked by similar users that current user hasn't watched
        Map<String, Integer> contentScores = new HashMap<>();
        Set<String> watchedContent = user.getWatchedContentIds();
        
        for (User similarUser : similarUsers) {
            double similarity = similarityService.calculateSimilarity(user, similarUser);
            
            for (Rating rating : similarUser.getRatings()) {
                if (!watchedContent.contains(rating.getContentId()) && rating.getScore() >= 4.0) {
                    int score = (int) (rating.getScore() * similarity * 100);
                    contentScores.merge(rating.getContentId(), score, Integer::sum);
                }
            }
        }
        
        // Sort by score and return top results
        return contentScores.entrySet().stream()
            .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
            .limit(maxResults)
            .map(entry -> contentService.getContent(entry.getKey()))
            .filter(Objects::nonNull)
            .collect(Collectors.toList());
    }
    
    @Override
    public String getStrategyName() {
        return "Collaborative Filtering";
    }
    
    @Override
    public double getConfidenceScore(User user) {
        // Higher confidence for users with many ratings
        int ratingCount = user.getRatings().size();
        return Math.min(1.0, ratingCount / 50.0); // Max confidence at 50+ ratings
    }
}

// Concrete Strategy 2: Content-Based Filtering
public class ContentBasedStrategy implements RecommendationStrategy {
    private ContentAnalysisService analysisService;
    private ContentService contentService;
    
    public ContentBasedStrategy() {
        this.analysisService = new ContentAnalysisService();
        this.contentService = new ContentService();
    }
    
    @Override
    public List<Content> recommend(User user, int maxResults) {
        System.out.println("Using Content-Based Filtering for user: " + user.getName());
        
        // Analyze user's viewing history to build preference profile
        UserPreferenceProfile profile = analysisService.buildUserProfile(user);
        
        // Find content matching user preferences
        List<Content> candidateContent = contentService.getAllContent().stream()
            .filter(content -> !user.getWatchedContentIds().contains(content.getId()))
            .collect(Collectors.toList());
        
        // Score content based on similarity to user profile
        return candidateContent.stream()
            .map(content -> new ContentScore(content, calculateContentScore(content, profile)))
            .sorted(Comparator.comparingDouble(ContentScore::getScore).reversed())
            .limit(maxResults)
            .map(ContentScore::getContent)
            .collect(Collectors.toList());
    }
    
    private double calculateContentScore(Content content, UserPreferenceProfile profile) {
        double score = 0.0;
        
        // Genre preference
        double genreScore = profile.getGenrePreference(content.getGenre());
        score += genreScore * 0.4;
        
        // Actor preference
        for (String actor : content.getActors()) {
            score += profile.getActorPreference(actor) * 0.2;
        }
        
        // Director preference
        score += profile.getDirectorPreference(content.getDirector()) * 0.1;
        
        // Release year preference
        score += profile.getYearPreference(content.getReleaseYear()) * 0.1;
        
        // Rating preference
        score += profile.getRatingPreference(content.getAverageRating()) * 0.2;
        
        return score;
    }
    
    @Override
    public String getStrategyName() {
        return "Content-Based Filtering";
    }
    
    @Override
    public double getConfidenceScore(User user) {
        // Higher confidence for users who have watched diverse content
        Set<String> uniqueGenres = user.getWatchHistory().stream()
            .map(Content::getGenre)
            .collect(Collectors.toSet());
        
        return Math.min(1.0, uniqueGenres.size() / 10.0); // Max confidence at 10+ genres
    }
}

// Concrete Strategy 3: Trending/Popular Content
public class TrendingStrategy implements RecommendationStrategy {
    private TrendingService trendingService;
    private ContentService contentService;
    
    public TrendingStrategy() {
        this.trendingService = new TrendingService();
        this.contentService = new ContentService();
    }
    
    @Override
    public List<Content> recommend(User user, int maxResults) {
        System.out.println("Using Trending Strategy for user: " + user.getName());
        
        // Get trending content filtered by user's age rating and language preferences
        List<String> trendingIds = trendingService.getTrendingContent(
            user.getAgeRating(),
            user.getPreferredLanguages(),
            maxResults * 2 // Get more to filter out watched content
        );
        
        Set<String> watchedContent = user.getWatchedContentIds();
        
        return trendingIds.stream()
            .filter(id -> !watchedContent.contains(id))
            .limit(maxResults)
            .map(contentService::getContent)
            .filter(Objects::nonNull)
            .collect(Collectors.toList());
    }
    
    @Override
    public String getStrategyName() {
        return "Trending Content";
    }
    
    @Override
    public double getConfidenceScore(User user) {
        // Lower confidence - trending is generic, not personalized
        return 0.3;
    }
}

// Concrete Strategy 4: Hybrid Strategy
public class HybridRecommendationStrategy implements RecommendationStrategy {
    private List<RecommendationStrategy> strategies;
    private WeightCalculator weightCalculator;
    
    public HybridRecommendationStrategy() {
        this.strategies = Arrays.asList(
            new CollaborativeFilteringStrategy(),
            new ContentBasedStrategy(),
            new TrendingStrategy()
        );
        this.weightCalculator = new WeightCalculator();
    }
    
    @Override
    public List<Content> recommend(User user, int maxResults) {
        System.out.println("Using Hybrid Strategy for user: " + user.getName());
        
        // Calculate weights for each strategy based on user characteristics
        Map<RecommendationStrategy, Double> weights = weightCalculator.calculateWeights(user, strategies);
        
        // Get recommendations from each strategy
        Map<Content, Double> contentScores = new HashMap<>();
        
        for (RecommendationStrategy strategy : strategies) {
            List<Content> recommendations = strategy.recommend(user, maxResults);
            double weight = weights.get(strategy);
            
            // Weight the recommendations
            for (int i = 0; i < recommendations.size(); i++) {
                Content content = recommendations.get(i);
                double score = (maxResults - i) * weight; // Higher position = higher score
                contentScores.merge(content, score, Double::sum);
            }
        }
        
        // Return top scored content
        return contentScores.entrySet().stream()
            .sorted(Map.Entry.<Content, Double>comparingByValue().reversed())
            .limit(maxResults)
            .map(Map.Entry::getKey)
            .collect(Collectors.toList());
    }
    
    @Override
    public String getStrategyName() {
        return "Hybrid (Collaborative + Content-Based + Trending)";
    }
    
    @Override
    public double getConfidenceScore(User user) {
        // Average confidence of all strategies
        return strategies.stream()
            .mapToDouble(strategy -> strategy.getConfidenceScore(user))
            .average()
            .orElse(0.5);
    }
}

// Context class - Netflix Recommendation Engine
public class NetflixRecommendationEngine {
    private RecommendationStrategy strategy;
    private StrategySelector strategySelector;
    
    public NetflixRecommendationEngine() {
        this.strategySelector = new StrategySelector();
        // Default strategy
        this.strategy = new HybridRecommendationStrategy();
    }
    
    public void setRecommendationStrategy(RecommendationStrategy strategy) {
        this.strategy = strategy;
        System.out.println("Switched to strategy: " + strategy.getStrategyName());
    }
    
    public List<Content> getPersonalizedRecommendations(User user, int maxResults) {
        // Automatically select best strategy for this user
        RecommendationStrategy bestStrategy = strategySelector.selectBestStrategy(user);
        setRecommendationStrategy(bestStrategy);
        
        long startTime = System.currentTimeMillis();
        List<Content> recommendations = strategy.recommend(user, maxResults);
        long endTime = System.currentTimeMillis();
        
        System.out.println("Generated " + recommendations.size() + 
                          " recommendations in " + (endTime - startTime) + "ms");
        System.out.println("Strategy confidence: " + 
                          String.format("%.2f", strategy.getConfidenceScore(user)));
        
        return recommendations;
    }
    
    public RecommendationInsights getRecommendationInsights(User user) {
        return new RecommendationInsights(
            strategy.getStrategyName(),
            strategy.getConfidenceScore(user),
            user.getRatings().size(),
            user.getWatchHistory().size()
        );
    }
}

// Strategy selector to automatically choose best strategy
public class StrategySelector {
    private Map<String, RecommendationStrategy> availableStrategies;
    
    public StrategySelector() {
        availableStrategies = new HashMap<>();
        availableStrategies.put("collaborative", new CollaborativeFilteringStrategy());
        availableStrategies.put("content_based", new ContentBasedStrategy());
        availableStrategies.put("trending", new TrendingStrategy());
        availableStrategies.put("hybrid", new HybridRecommendationStrategy());
    }
    
    public RecommendationStrategy selectBestStrategy(User user) {
        int watchHistorySize = user.getWatchHistory().size();
        int ratingCount = user.getRatings().size();
        
        // New users - use trending content
        if (watchHistorySize < 5) {
            return availableStrategies.get("trending");
        }
        
        // Users with some history but few ratings - use content-based
        if (watchHistorySize >= 5 && ratingCount < 10) {
            return availableStrategies.get("content_based");
        }
        
        // Users with many ratings - use collaborative filtering
        if (ratingCount >= 20) {
            return availableStrategies.get("collaborative");
        }
        
        // Default to hybrid for balanced users
        return availableStrategies.get("hybrid");
    }
}

// Supporting classes
class ContentScore {
    private Content content;
    private double score;
    
    public ContentScore(Content content, double score) {
        this.content = content;
        this.score = score;
    }
    
    public Content getContent() { return content; }
    public double getScore() { return score; }
}

class UserPreferenceProfile {
    private Map<String, Double> genrePreferences;
    private Map<String, Double> actorPreferences;
    private Map<String, Double> directorPreferences;
    private Map<Integer, Double> yearPreferences;
    private Map<Double, Double> ratingPreferences;
    
    public UserPreferenceProfile() {
        this.genrePreferences = new HashMap<>();
        this.actorPreferences = new HashMap<>();
        this.directorPreferences = new HashMap<>();
        this.yearPreferences = new HashMap<>();
        this.ratingPreferences = new HashMap<>();
    }
    
    // Getters with default values
    public double getGenrePreference(String genre) {
        return genrePreferences.getOrDefault(genre, 0.0);
    }
    
    public double getActorPreference(String actor) {
        return actorPreferences.getOrDefault(actor, 0.0);
    }
    
    public double getDirectorPreference(String director) {
        return directorPreferences.getOrDefault(director, 0.0);
    }
    
    public double getYearPreference(int year) {
        return yearPreferences.getOrDefault(year, 0.0);
    }
    
    public double getRatingPreference(double rating) {
        return ratingPreferences.getOrDefault(rating, 0.0);
    }
    
    // Setters
    public void setGenrePreference(String genre, double preference) {
        genrePreferences.put(genre, preference);
    }
    
    public void setActorPreference(String actor, double preference) {
        actorPreferences.put(actor, preference);
    }
    
    public void setDirectorPreference(String director, double preference) {
        directorPreferences.put(director, preference);
    }
}

class RecommendationInsights {
    private String strategyUsed;
    private double confidence;
    private int userRatingCount;
    private int watchHistorySize;
    
    public RecommendationInsights(String strategyUsed, double confidence, 
                                 int userRatingCount, int watchHistorySize) {
        this.strategyUsed = strategyUsed;
        this.confidence = confidence;
        this.userRatingCount = userRatingCount;
        this.watchHistorySize = watchHistorySize;
    }
    
    // Getters
    public String getStrategyUsed() { return strategyUsed; }
    public double getConfidence() { return confidence; }
    public int getUserRatingCount() { return userRatingCount; }
    public int getWatchHistorySize() { return watchHistorySize; }
}

class WeightCalculator {
    public Map<RecommendationStrategy, Double> calculateWeights(User user, 
                                                               List<RecommendationStrategy> strategies) {
        Map<RecommendationStrategy, Double> weights = new HashMap<>();
        double totalConfidence = 0.0;
        
        // Calculate individual confidences
        for (RecommendationStrategy strategy : strategies) {
            double confidence = strategy.getConfidenceScore(user);
            weights.put(strategy, confidence);
            totalConfidence += confidence;
        }
        
        // Normalize weights
        if (totalConfidence > 0) {
            weights.replaceAll((strategy, weight) -> weight / totalConfidence);
        } else {
            // Equal weights if no confidence scores
            double equalWeight = 1.0 / strategies.size();
            weights.replaceAll((strategy, weight) -> equalWeight);
        }
        
        return weights;
    }
}

// Usage demonstration
public class NetflixRecommendationDemo {
    public void demonstrateStrategyPattern() {
        NetflixRecommendationEngine engine = new NetflixRecommendationEngine();
        
        // Create different types of users
        User newUser = createNewUser();
        User regularUser = createRegularUser();
        User powerUser = createPowerUser();
        
        System.out.println("=== Recommendations for Different User Types ===\n");
        
        // New user gets trending content
        demonstrateUserRecommendations(engine, newUser);
        System.out.println();
        
        // Regular user gets content-based recommendations
        demonstrateUserRecommendations(engine, regularUser);
        System.out.println();


-----------------------------------

// Regular user gets content-based recommendations
        demonstrateUserRecommendations(engine, regularUser);
        System.out.println();
        
        // Power user gets hybrid recommendations
        demonstrateUserRecommendations(engine, powerUser);
        System.out.println();
        
        // Manual strategy switching
        System.out.println("=== Manual Strategy Switching ===");
        engine.setRecommendationStrategy(new CollaborativeFilteringStrategy());
        List<Content> collabRecs = engine.getPersonalizedRecommendations(powerUser, 5);
        
        engine.setRecommendationStrategy(new ContentBasedStrategy());
        List<Content> contentRecs = engine.getPersonalizedRecommendations(powerUser, 5);
    }
    
    private void demonstrateUserRecommendations(NetflixRecommendationEngine engine, User user) {
        System.out.println("User: " + user.getName() + " (Watch History: " + 
                          user.getWatchHistory().size() + ", Ratings: " + user.getRatings().size() + ")");
        
        List<Content> recommendations = engine.getPersonalizedRecommendations(user, 5);
        RecommendationInsights insights = engine.getRecommendationInsights(user);
        
        System.out.println("Strategy: " + insights.getStrategyUsed());
        System.out.println("Confidence: " + String.format("%.2f", insights.getConfidence()));
        System.out.println("Recommendations:");
        for (int i = 0; i < recommendations.size(); i++) {
            System.out.println("  " + (i + 1) + ". " + recommendations.get(i).getTitle());
        }
    }
    
    private User createNewUser() {
        User user = new User("new-user-001", "New User");
        user.setAgeRating(AgeRating.TEEN);
        user.addPreferredLanguage("English");
        return user;
    }
    
    private User createRegularUser() {
        User user = new User("regular-user-002", "Regular User");
        user.setAgeRating(AgeRating.ADULT);
        user.addPreferredLanguage("English");
        
        // Add some watch history
        Content content1 = new Content("action-movie-1", "Action Movie", "Action");
        Content content2 = new Content("comedy-movie-1", "Comedy Movie", "Comedy");
        Content content3 = new Content("drama-series-1", "Drama Series", "Drama");
        
        user.addToWatchHistory(content1);
        user.addToWatchHistory(content2);
        user.addToWatchHistory(content3);
        
        // Few ratings
        user.addRating(new Rating("action-movie-1", 4.0));
        user.addRating(new Rating("comedy-movie-1", 5.0));
        
        return user;
    }
    
    private User createPowerUser() {
        User user = new User("power-user-003", "Power User");
        user.setAgeRating(AgeRating.ADULT);
        user.addPreferredLanguage("English");
        
        // Extensive watch history and ratings
        String[] genres = {"Action", "Comedy", "Drama", "Thriller", "Sci-Fi", "Romance"};
        for (int i = 0; i < 30; i++) {
            String genre = genres[i % genres.length];
            Content content = new Content("content-" + i, genre + " Content " + i, genre);
            user.addToWatchHistory(content);
            user.addRating(new Rating("content-" + i, 3.0 + Math.random() * 2)); // Rating 3-5
        }
        
        return user;
    }
}
```

---

## Industry Examples from Top Companies

### Google - Android Activity Lifecycle

```java
// Real example from Android SDK
public abstract class Activity extends ContextThemeWrapper {
    private ActivityState currentState;
    private Bundle savedInstanceState;
    private List<Fragment> fragments;
    
    // Template method pattern - defines the lifecycle
    public final void performCreate(Bundle savedInstanceState) {
        this.savedInstanceState = savedInstanceState;
        currentState = ActivityState.CREATING;
        
        // Restore instance state
        if (savedInstanceState != null) {
            restoreInstanceState(savedInstanceState);
        }
        
        // Call the user's implementation
        onCreate(savedInstanceState);
        currentState = ActivityState.CREATED;
        
        // Initialize fragments
        getFragmentManager().dispatchCreate();
    }
    
    public final void performStart() {
        if (currentState != ActivityState.CREATED) {
            throw new IllegalStateException("Activity must be created before starting");
        }
        
        currentState = ActivityState.STARTING;
        onStart(); // User implementation
        currentState = ActivityState.STARTED;
        
        getFragmentManager().dispatchStart();
    }
    
    public final void performResume() {
        if (currentState != ActivityState.STARTED) {
            throw new IllegalStateException("Activity must be started before resuming");
        }
        
        currentState = ActivityState.RESUMING;
        onResume(); // User implementation
        currentState = ActivityState.RESUMED;
        
        getFragmentManager().dispatchResume();
    }
    
    // Abstract methods - must be implemented by concrete activities
    protected abstract void onCreate(Bundle savedInstanceState);
    
    // Optional overrides with default implementations
    protected void onStart() {
        // Default implementation - can be overridden
    }
    
    protected void onResume() {
        // Default implementation
    }
    
    protected void onPause() {
        // Default implementation
    }
    
    protected void onStop() {
        // Default implementation
    }
    
    protected void onDestroy() {
        // Default implementation
    }
    
    // Concrete methods available to subclasses
    public final void finish() {
        currentState = ActivityState.FINISHING;
        getActivityManager().finishActivity(this);
    }
    
    public void startActivity(Intent intent) {
        getActivityManager().startActivity(intent);
    }
    
    protected final Bundle getSavedInstanceState() {
        return savedInstanceState;
    }
}

// Example concrete Activity implementation
public class MainActivity extends Activity {
    private Button loginButton;
    private EditText usernameField;
    private UserService userService;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // Important!
        
        // Set the layout
        setContentView(R.layout.activity_main);
        
        // Initialize services
        userService = new UserService();
        
        // Find views
        loginButton = findViewById(R.id.loginButton);
        usernameField = findViewById(R.id.usernameField);
        
        // Set up event listeners
        loginButton.setOnClickListener(view -> {
            String username = usernameField.getText().toString();
            if (userService.isValidUsername(username)) {
                Intent intent = new Intent(this, DashboardActivity.class);
                intent.putExtra("username", username);
                startActivity(intent);
            }
        });
        
        System.out.println("MainActivity created");
    }
    
    @Override
    protected void onStart() {
        super.onStart();
        
        // Activity is becoming visible
        System.out.println("MainActivity started - becoming visible");
        
        // Resume any paused animations
        AnimationManager.resumeAnimations();
    }
    
    @Override
    protected void onResume() {
        super.onResume();
        
        // Activity is now visible and interactive
        System.out.println("MainActivity resumed - user can interact");
        
        // Start location updates
        LocationManager.startLocationUpdates();
        
        // Resume background tasks
        BackgroundTaskManager.resume();
    }
    
    @Override
    protected void onPause() {
        super.onPause();
        
        // Activity is losing focus
        System.out.println("MainActivity paused - losing focus");
        
        // Pause location updates to save battery
        LocationManager.pauseLocationUpdates();
        
        // Pause non-critical background tasks
        BackgroundTaskManager.pause();
    }
    
    @Override
    protected void onStop() {
        super.onStop();
        
        // Activity is no longer visible
        System.out.println("MainActivity stopped - no longer visible");
        
        // Save user progress
        userService.saveProgress();
    }
    
    @Override
    protected void onDestroy() {
        super.onDestroy();
        
        // Activity is being destroyed
        System.out.println("MainActivity destroyed - cleaning up");
        
        // Clean up resources
        if (userService != null) {
            userService.cleanup();
        }
        
        // Cancel any pending network requests
        NetworkManager.cancelAllRequests();
    }
}
```

### Amazon - Order Processing System

```java
// Command pattern for order operations
public interface OrderCommand {
    OrderResult execute();
    void undo();
    String getCommandDescription();
}

// Concrete commands
public class CreateOrderCommand implements OrderCommand {
    private OrderService orderService;
    private Order order;
    private String createdOrderId;
    
    public CreateOrderCommand(OrderService orderService, Order order) {
        this.orderService = orderService;
        this.order = order;
    }
    
    @Override
    public OrderResult execute() {
        try {
            // Validate order
            ValidationResult validation = orderService.validateOrder(order);
            if (!validation.isValid()) {
                return OrderResult.failure("Order validation failed: " + validation.getErrors());
            }
            
            // Check inventory
            InventoryResult inventory = orderService.checkInventory(order.getItems());
            if (!inventory.isAvailable()) {
                return OrderResult.failure("Insufficient inventory: " + inventory.getUnavailableItems());
            }
            
            // Calculate pricing
            PricingResult pricing = orderService.calculatePricing(order);
            order.setTotalAmount(pricing.getTotalAmount());
            order.setTaxAmount(pricing.getTaxAmount());
            
            // Create order
            createdOrderId = orderService.createOrder(order);
            
            // Reserve inventory
            orderService.reserveInventory(order.getItems());
            
            // Send confirmation email
            EmailService.sendOrderConfirmation(order.getCustomerEmail(), createdOrderId);
            
            return OrderResult.success("Order created successfully", createdOrderId);
            
        } catch (Exception e) {
            return OrderResult.failure("Order creation failed: " + e.getMessage());
        }
    }
    
    @Override
    public void undo() {
        if (createdOrderId != null) {
            // Release reserved inventory
            orderService.releaseInventory(order.getItems());
            
            // Cancel order
            orderService.cancelOrder(createdOrderId);
            
            // Send cancellation email
            EmailService.sendOrderCancellation(order.getCustomerEmail(), createdOrderId);
        }
    }
    
    @Override
    public String getCommandDescription() {
        return "Create order for customer: " + order.getCustomerEmail();
    }
}

public class ProcessPaymentCommand implements OrderCommand {
    private PaymentService paymentService;
    private String orderId;
    private PaymentRequest paymentRequest;
    private String transactionId;
    
    public ProcessPaymentCommand(PaymentService paymentService, String orderId, PaymentRequest paymentRequest) {
        this.paymentService = paymentService;
        this.orderId = orderId;
        this.paymentRequest = paymentRequest;
    }
    
    @Override
    public OrderResult execute() {
        try {
            // Process payment
            PaymentResult result = paymentService.processPayment(paymentRequest);
            
            if (result.isSuccess()) {
                transactionId = result.getTransactionId();
                
                // Update order status
                OrderService.updateOrderStatus(orderId, OrderStatus.PAID);
                
                // Trigger fulfillment
                FulfillmentService.initiateShipping(orderId);
                
                return OrderResult.success("Payment processed successfully", transactionId);
            } else {
                return OrderResult.failure("Payment failed: " + result.getErrorMessage());
            }
            
        } catch (Exception e) {
            return OrderResult.failure("Payment processing failed: " + e.getMessage());
        }
    }
    
    @Override
    public void undo() {
        if (transactionId != null) {
            // Refund payment
            paymentService.refundPayment(transactionId, paymentRequest.getAmount());
            
            // Update order status
            OrderService.updateOrderStatus(orderId, OrderStatus.PAYMENT_FAILED);
            
            // Cancel fulfillment
            FulfillmentService.cancelShipping(orderId);
        }
    }
    
    @Override
    public String getCommandDescription() {
        return "Process payment for order: " + orderId;
    }
}

public class ShipOrderCommand implements OrderCommand {
    private FulfillmentService fulfillmentService;
    private String orderId;
    private ShippingAddress address;
    private String trackingNumber;
    
    public ShipOrderCommand(FulfillmentService fulfillmentService, String orderId, ShippingAddress address) {
        this.fulfillmentService = fulfillmentService;
        this.orderId = orderId;
        this.address = address;
    }
    
    @Override
    public OrderResult execute() {
        try {
            // Validate shipping address
            if (!AddressValidator.isValid(address)) {
                return OrderResult.failure("Invalid shipping address");
            }
            
            // Pick items from warehouse
            PickingResult picking = fulfillmentService.pickItems(orderId);
            if (!picking.isComplete()) {
                return OrderResult.failure("Item picking failed: " + picking.getMissingItems());
            }
            
            // Package items
            PackagingResult packaging = fulfillmentService.packageItems(orderId, picking.getPickedItems());
            
            // Generate shipping label
            ShippingLabel label = ShippingLabelService.generateLabel(address, packaging.getPackage());
            trackingNumber = label.getTrackingNumber();
            
            // Hand over to carrier
            CarrierResult carrier = CarrierService.schedulePickup(packaging.getPackage(), label);
            
            // Update order status
            OrderService.updateOrderStatus(orderId, OrderStatus.SHIPPED);
            
            // Send shipping notification
            EmailService.sendShippingNotification(
                OrderService.getCustomerEmail(orderId), 
                orderId, 
                trackingNumber
            );
            
            return OrderResult.success("Order shipped successfully", trackingNumber);
            
        } catch (Exception e) {
            return OrderResult.failure("Shipping failed: " + e.getMessage());
        }
    }
    
    @Override
    public void undo() {
        if (trackingNumber != null) {
            // Cancel shipment with carrier
            CarrierService.cancelShipment(trackingNumber);
            
            // Return items to inventory
            fulfillmentService.returnItemsToInventory(orderId);
            
            // Update order status
            OrderService.updateOrderStatus(orderId, OrderStatus.FULFILLMENT_CANCELLED);
            
            // Send cancellation notification
            EmailService.sendShipmentCancellation(
                OrderService.getCustomerEmail(orderId), 
                orderId
            );
        }
    }
    
    @Override
    public String getCommandDescription() {
        return "Ship order: " + orderId + " to " + address.getCity();
    }
}

// Invoker - Order Processing Engine
public class AmazonOrderProcessor {
    private List<OrderCommand> executedCommands;
    private Queue<OrderCommand> pendingCommands;
    
    public AmazonOrderProcessor() {
        this.executedCommands = new ArrayList<>();
        this.pendingCommands = new LinkedList<>();
    }
    
    // Execute command immediately
    public OrderResult executeCommand(OrderCommand command) {
        System.out.println("Executing: " + command.getCommandDescription());
        
        OrderResult result = command.execute();
        
        if (result.isSuccess()) {
            executedCommands.add(command);
            System.out.println("Command executed successfully: " + result.getMessage());
        } else {
            System.err.println("Command failed: " + result.getMessage());
        }
        
        return result;
    }
    
    // Queue command for batch processing
    public void queueCommand(OrderCommand command) {
        pendingCommands.add(command);
        System.out.println("Queued: " + command.getCommandDescription());
    }
    
    // Process all queued commands
    public List<OrderResult> processBatch() {
        List<OrderResult> results = new ArrayList<>();
        
        while (!pendingCommands.isEmpty()) {
            OrderCommand command = pendingCommands.poll();
            OrderResult result = executeCommand(command);
            results.add(result);
            
            // If any command fails, stop processing batch
            if (!result.isSuccess()) {
                System.err.println("Batch processing stopped due to failure");
                break;
            }
        }
        
        return results;
    }
    
    // Undo last command
    public void undoLastCommand() {
        if (!executedCommands.isEmpty()) {
            OrderCommand lastCommand = executedCommands.remove(executedCommands.size() - 1);
            System.out.println("Undoing: " + lastCommand.getCommandDescription());
            lastCommand.undo();
        }
    }
    
    // Undo all commands in reverse order
    public void undoAll() {
        while (!executedCommands.isEmpty()) {
            undoLastCommand();
        }
    }
    
    // Process complete order workflow
    public OrderResult processCompleteOrder(Order order, PaymentRequest payment, ShippingAddress address) {
        // Create command sequence
        CreateOrderCommand createCmd = new CreateOrderCommand(new OrderService(), order);
        
        // Execute create order
        OrderResult createResult = executeCommand(createCmd);
        if (!createResult.isSuccess()) {
            return createResult;
        }
        
        String orderId = createResult.getData();
        
        // Execute payment
        ProcessPaymentCommand paymentCmd = new ProcessPaymentCommand(
            new PaymentService(), orderId, payment);
        OrderResult paymentResult = executeCommand(paymentCmd);
        
        if (!paymentResult.isSuccess()) {
            undoLastCommand(); // Undo order creation
            return paymentResult;
        }
        
        // Execute shipping
        ShipOrderCommand shipCmd = new ShipOrderCommand(
            new FulfillmentService(), orderId, address);
        OrderResult shipResult = executeCommand(shipCmd);
        
        if (!shipResult.isSuccess()) {
            // Undo payment and order creation
            undoLastCommand(); // Undo payment
            undoLastCommand(); // Undo order creation
            return shipResult;
        }
        
        return OrderResult.success("Order processed completely", orderId);
    }
}

// Supporting classes
class OrderResult {
    private boolean success;
    private String message;
    private String data;
    
    private OrderResult(boolean success, String message, String data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }
    
    public static OrderResult success(String message, String data) {
        return new OrderResult(true, message, data);
    }
    
    public static OrderResult failure(String message) {
        return new OrderResult(false, message, null);
    }
    
    public boolean isSuccess() { return success; }
    public String getMessage() { return message; }
    public String getData() { return data; }
}

// Usage demonstration
public class AmazonOrderProcessingDemo {
    public void demonstrateCommandPattern() {
        AmazonOrderProcessor processor = new AmazonOrderProcessor();
        
        // Create sample order
        Order order = new Order("customer@example.com");
        order.addItem(new OrderItem("book-123", "Clean Code", 42.99, 1));
        order.addItem(new OrderItem("laptop-456", "MacBook Pro", 2399.00, 1));
        
        PaymentRequest payment = new PaymentRequest(
            order.getTotalAmount(), 
            "card-token-123"
        );
        
        ShippingAddress address = new ShippingAddress(
            "123 Main St", "Anytown", "CA", "12345"
        );
        
        // Process complete order
        OrderResult result = processor.processCompleteOrder(order, payment, address);
        
        if (result.isSuccess()) {
            System.out.println("Order processed successfully: " + result.getData());
        } else {
            System.err.println("Order processing failed: " + result.getMessage());
        }
        
        // Demonstrate undo functionality
        System.out.println("\n=== Demonstrating Undo ===");
        processor.undoLastCommand(); // Undo shipping
    }
}
```

### Microsoft - Office Document Chain of Responsibility

```java
// Handler interface for document processing
public abstract class DocumentHandler {
    protected DocumentHandler nextHandler;
    
    public void setNextHandler(DocumentHandler nextHandler) {
        this.nextHandler = nextHandler;
    }
    
    public abstract ProcessingResult handleDocument(Document document, ProcessingRequest request);
    
    protected ProcessingResult passToNext(Document document, ProcessingRequest request) {
        if (nextHandler != null) {
            return nextHandler.handleDocument(document, request);
        }
        return ProcessingResult.unhandled("No handler available for request type: " + request.getType());
    }
}

// Concrete handlers
public class VirusScanner extends DocumentHandler {
    private AntiVirusEngine antiVirusEngine;
    
    public VirusScanner() {
        this.antiVirusEngine = new WindowsDefenderEngine();
    }
    
    @Override
    public ProcessingResult handleDocument(Document document, ProcessingRequest request) {
        if (request.getType() == ProcessingType.SECURITY_SCAN) {
            System.out.println("Scanning document for viruses: " + document.getName());
            
            ScanResult scanResult = antiVirusEngine.scanDocument(document);
            
            if (scanResult.isClean()) {
                System.out.println("✅ Document is clean");
                return ProcessingResult.success("Virus scan completed - document is clean");
            } else {
                System.out.println("⚠️ Virus detected: " + scanResult.getThreatName());
                return ProcessingResult.blocked("Document blocked due to virus: " + scanResult.getThreatName());
            }
        }
        
        return passToNext(document, request);
    }
}

public class FormatConverter extends DocumentHandler {
    private Map<String, DocumentConverter> converters;
    
    public FormatConverter() {
        converters = new HashMap<>();
        converters.put("docx_to_pdf", new DocxToPdfConverter());
        converters.put("xlsx_to_csv", new XlsxToCsvConverter());
        converters.put("pptx_to_pdf", new PptxToPdfConverter());
    }
    
    @Override
    public ProcessingResult handleDocument(Document document, ProcessingRequest request) {
        if (request.getType() == ProcessingType.FORMAT_CONVERSION) {
            FormatConversionRequest conversionRequest = (FormatConversionRequest) request;
            String conversionKey = document.getFormat() + "_to_" + conversionRequest.getTargetFormat();
            
            DocumentConverter converter = converters.get(conversionKey);
            
            if (converter != null) {
                System.out.println("Converting " + document.getName() + " from " + 
                                 document.getFormat() + " to " + conversionRequest.getTargetFormat());
                
                try {
                    Document convertedDocument = converter.convert(document);
                    return ProcessingResult.success("Document converted successfully", convertedDocument);
                } catch (ConversionException e) {
                    return ProcessingResult.error("Conversion failed: " + e.getMessage());
                }
            } else {
                System.out.println("No converter available for " + conversionKey);
            }
        }
        
        return passToNext(document, request);
    }
}

public class ContentFilter extends DocumentHandler {
    private List<ContentRule> contentRules;
    
    public ContentFilter() {
        contentRules = Arrays.asList(
            new ProfanityRule(),
            new ConfidentialDataRule(),
            new ComplianceRule()
        );
    }
    
    @Override
    public ProcessingResult handleDocument(Document document, ProcessingRequest request) {
        if (request.getType() == ProcessingType.CONTENT_FILTERING) {
            System.out.println("Filtering content in document: " + document.getName());
            
            String content = document.getContent();
            List<String> violations = new ArrayList<>();
            
            for (ContentRule rule : contentRules) {
                RuleResult result = rule.evaluate(content);
                if (!result.isPassed()) {
                    violations.addAll(result.getViolations());
                }
            }
            
            if (violations.isEmpty()) {
                System.out.println("✅ Content filter passed");
                return ProcessingResult.success("Content filtering passed");
            } else {
                System.out.println("⚠️ Content violations found: " + violations);
                return ProcessingResult.blocked("Content blocked due to violations: " + 
                                               String.join(", ", violations));
            }
        }
        
        return passToNext(document, request);
    }
}

public class VersionController extends DocumentHandler {
    private DocumentVersionRepository versionRepository;
    
    public VersionController() {
        this.versionRepository = new SharePointVersionRepository();
    }
    
    @Override
    public ProcessingResult handleDocument(Document document, ProcessingRequest request) {
        if (request.getType() == ProcessingType.VERSION_CONTROL) {
            VersionControlRequest versionRequest = (VersionControlRequest) request;
            
            System.out.println("Managing version for document: " + document.getName());
            
            switch (versionRequest.getOperation()) {
                case CHECK_IN:
                    return handleCheckIn(document, versionRequest);
                case CHECK_OUT:
                    return handleCheckOut(document, versionRequest);
                case GET_HISTORY:
                    return handleGetHistory(document);
                case MERGE:
                    return handleMerge(document, versionRequest);
                default:
                    break;
            }
        }
        
        return passToNext(document, request);
    }
    
    private ProcessingResult handleCheckIn(Document document, VersionControlRequest request) {
        try {
            DocumentVersion version = versionRepository.checkIn(
                document, 
                request.getUserId(), 
                request.getComments()
            );
            
            System.out.println("✅ Document checked in as version " + version.getVersionNumber());
            return ProcessingResult.success("Document checked in", version);
        } catch (VersionControlException e) {
            return ProcessingResult.error("Check-in failed: " + e.getMessage());
        }
    }
    
    private ProcessingResult handleCheckOut(Document document, VersionControlRequest request) {
        try {
            boolean success = versionRepository.checkOut(document.getId(), request.getUserId());
            
            if (success) {
                System.out.println("✅ Document checked out to " + request.getUserId());
                return ProcessingResult.success("Document checked out");
            } else {
                return ProcessingResult.blocked("Document already checked out by another user");
            }
        } catch (VersionControlException e) {
            return ProcessingResult.error("Check-out failed: " + e.getMessage());
        }
    }
    
    private ProcessingResult handleGetHistory(Document document) {
        List<DocumentVersion> history = versionRepository.getVersionHistory(document.getId());
        System.out.println("Retrieved " + history.size() + " versions");
        return ProcessingResult.success("Version history retrieved", history);
    }
    
    private ProcessingResult handleMerge(Document document, VersionControlRequest request) {
        try {
            Document mergedDocument = versionRepository.mergeVersions(
                document.getId(), 
                request.getSourceVersion(), 
                request.getTargetVersion()
            );
            
            System.out.println("✅ Versions merged successfully");
            return ProcessingResult.success("Versions merged", mergedDocument);
        } catch (MergeConflictException e) {
            return ProcessingResult.error("Merge failed due to conflicts: " + e.getConflicts());
        }
    }
}

public class CollaborationManager extends DocumentHandler {
    private CollaborationService collaborationService;
    
    public CollaborationManager() {
        this.collaborationService = new TeamsCollaborationService();
    }
    
    @Override
    public ProcessingResult handleDocument(Document document, ProcessingRequest request) {
        if (request.getType() == ProcessingType.COLLABORATION) {
            CollaborationRequest collabRequest = (CollaborationRequest) request;
            
            System.out.println("Managing collaboration for document: " + document.getName());
            
            switch (collabRequest.getOperation()) {
                case SHARE:
                    return handleShare(document, collabRequest);
                case GRANT_PERMISSION:
                    return handleGrantPermission(document, collabRequest);
                case REVOKE_PERMISSION:
                    return handleRevokePermission(document, collabRequest);
                case GET_COLLABORATORS:
                    return handleGetCollaborators(document);
                default:
                    break;
            }
        }
        
        return passToNext(document, request);
    }
    
    private ProcessingResult handleShare(Document document, CollaborationRequest request) {
        try {
            ShareResult result = collaborationService.shareDocument(
                document.getId(),
                request.getTargetUsers(),
                request.getPermissionLevel()
            );
            
            System.out.println("✅ Document shared with " + request.getTargetUsers().size() + " users");
            
            // Send notification emails
            NotificationService.sendShareNotifications(document, request.getTargetUsers());
            
            return ProcessingResult.success("Document shared successfully", result.getShareLink());
        } catch (CollaborationException e) {
            return ProcessingResult.error("Sharing failed: " + e.getMessage());
        }
    }
    
    private ProcessingResult handleGrantPermission(Document document, CollaborationRequest request) {
        boolean success = collaborationService.grantPermission(
            document.getId(),
            request.getTargetUserId(),
            request.getPermissionLevel()
        );
        
        if (success) {
            System.out.println("✅ Permission granted to " + request.getTargetUserId());
            return ProcessingResult.success("Permission granted");
        } else {
            return ProcessingResult.error("Failed to grant permission");
        }
    }
    
    private ProcessingResult handleRevokePermission(Document document, CollaborationRequest request) {
        boolean success = collaborationService.revokePermission(
            document.getId(),
            request.getTargetUserId()
        );
        
        if (success) {
            System.out.println("✅ Permission revoked from " + request.getTargetUserId());
            return ProcessingResult.success("Permission revoked");
        } else {
            return ProcessingResult.error("Failed to revoke permission");
        }
    }
    
    private ProcessingResult handleGetCollaborators(Document document) {
        List<Collaborator> collaborators = collaborationService.getCollaborators(document.getId());
        System.out.println("Retrieved " + collaborators.size() + " collaborators");
        return ProcessingResult.success("Collaborators retrieved", collaborators);
    }
}

// Microsoft Office Document Processing Chain
public class OfficeDocumentProcessor {
    private DocumentHandler handlerChain;
    
    public OfficeDocumentProcessor() {
        buildProcessingChain();
    }
    
    private void buildProcessingChain() {
        // Build the chain of responsibility
        VirusScanner virusScanner = new VirusScanner();
        ContentFilter contentFilter = new ContentFilter();
        FormatConverter formatConverter = new FormatConverter();
        VersionController versionController = new VersionController();
        CollaborationManager collaborationManager = new CollaborationManager();
        
        // Set up the chain
        virusScanner.setNextHandler(contentFilter);
        contentFilter.setNextHandler(formatConverter);
        formatConverter.setNextHandler(versionController);
        versionController.setNextHandler(collaborationManager);
        
        this.handlerChain = virusScanner; // Start of chain
    }
    
    public ProcessingResult processDocument(Document document, ProcessingRequest request) {
        System.out.println("Processing document: " + document.getName() + 
                          " with request type: " + request.getType());
        System.out.println("=====================================");
        
        ProcessingResult result = handlerChain.handleDocument(document, request);
        
        System.out.println("=====================================");
        System.out.println("Processing result: " + result.getStatus());
        System.out.println();
        
        return result;
    }
    
    // Process multiple requests for the same document
    public List<ProcessingResult> processDocumentBatch(Document document, List<ProcessingRequest> requests) {
        List<ProcessingResult> results = new ArrayList<>();
        
        for (ProcessingRequest request : requests) {
            ProcessingResult result = processDocument(document, request);
            results.add(result);
            
            // Stop processing if any critical operation fails
            if (result.getStatus() == ProcessingStatus.BLOCKED || 
                result.getStatus() == ProcessingStatus.ERROR) {
                System.err.println("Stopping batch processing due to: " + result.getMessage());
                break;
            }
        }
        
        return results;
    }
}

// Supporting classes and enums
enum ProcessingType {
    SECURITY_SCAN, CONTENT_FILTERING, FORMAT_CONVERSION, VERSION_CONTROL, COLLABORATION
}

enum ProcessingStatus {
    SUCCESS, BLOCKED, ERROR, UNHANDLED
}

class ProcessingResult {
    private ProcessingStatus status;
    private String message;
    private Object data;
    
    private ProcessingResult(ProcessingStatus status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }
    
    public static ProcessingResult success(String message) {
        return new ProcessingResult(ProcessingStatus.SUCCESS, message, null);
    }
    
    public static ProcessingResult success(String message, Object data) {
        return new ProcessingResult(ProcessingStatus.SUCCESS, message, data);
    }
    
    public static ProcessingResult blocked(String message) {
        return new ProcessingResult(ProcessingStatus.BLOCKED, message, null);
    }
    
    public static ProcessingResult error(String message) {
        return new ProcessingResult(ProcessingStatus.ERROR, message, null);
    }
    
    public static ProcessingResult unhandled(String message) {
        return new ProcessingResult(ProcessingStatus.UNHANDLED, message, null);
    }
    
    // Getters
    public ProcessingStatus getStatus() { return status; }
    public String getMessage() { return message; }
    public Object getData() { return data; }
}

// Usage demonstration
public class OfficeDocumentProcessingDemo {
    public void demonstrateChainOfResponsibility() {
        OfficeDocumentProcessor processor = new OfficeDocumentProcessor();
        
        // Create a test document
        Document document = new Document("Project_Proposal.docx", "docx", "This is a sample project proposal document...");
        
        System.out.println("=== Microsoft Office Document Processing Demo ===\n");
        
        // Test different processing requests
        
        // 1. Security scan
        ProcessingRequest securityScan = new ProcessingRequest(ProcessingType.SECURITY_SCAN);
        processor.processDocument(document, securityScan);
        
        // 2. Content filtering
        ProcessingRequest contentFilter = new ProcessingRequest(ProcessingType.CONTENT_FILTERING);
        processor.processDocument(document, contentFilter);
        
        // 3. Format conversion
        FormatConversionRequest conversion = new FormatConversionRequest("pdf");
        processor.processDocument(document, conversion);
        
        // 4. Version control
        VersionControlRequest versionControl = new VersionControlRequest(
            VersionOperation.CHECK_IN, "user123", "Updated project timeline"
        );
        processor.processDocument(document, versionControl);
        
        // 5. Collaboration
        CollaborationRequest collaboration = new CollaborationRequest(
            CollaborationOperation.SHARE,
            Arrays.asList("alice@company.com", "bob@company.com"),
            PermissionLevel.EDIT
        );
        processor.processDocument(document, collaboration);
        
        // 6. Batch processing
        System.out.println("=== Batch Processing ===");
        List<ProcessingRequest> batchRequests = Arrays.asList(
            new ProcessingRequest(ProcessingType.SECURITY_SCAN),
            new ProcessingRequest(ProcessingType.CONTENT_FILTERING),
            new FormatConversionRequest("pdf")
        );
        
        List<ProcessingResult> batchResults = processor.processDocumentBatch(document, batchRequests);
        System.out.println("Batch processing completed with " + batchResults.size() + " results");
    }
}
```

---

## Interview Questions for Top 1% Candidates

### Basic OOP Concepts (Warmup)

#### Q1: Explain the difference between `==` and `.equals()` in Java
**Expected Answer:**
- `==` compares references (memory addresses) for objects, values for primitives
- `.equals()` compares actual content/value of objects
- Must override `.equals()` and `.hashCode()` together
- Example with String pool, custom objects

#### Q2: Why is multiple inheritance not allowed in Java?
**Expected Answer:**
- Diamond problem ambiguity
- Java uses interfaces to achieve multiple inheritance of type
- Composition over inheritance principle
- Example scenarios and workarounds

### Intermediate Questions

#### Q3: Design a thread-safe Singleton with lazy initialization
```java
// Expected implementation using double-checked locking or enum
public enum ConfigurationManager {
    INSTANCE;
    
    private Properties config;
    
    ConfigurationManager() {
        config = loadConfiguration();
    }
    
    public String getProperty(String key) {
        return config.getProperty(key);
    }
    
    private Properties loadConfiguration() {
        // Load from file/database
        return new Properties();
    }
}
```

#### Q4: Implement a generic LRU Cache
```java
public class LRUCache<K, V> {
    private final int capacity;
    private final Map<K, Node> map;
    private final Node head, tail;
    
    private class Node {
        K key;
        V value;
        Node prev, next;
        
        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new Node(null, null);
        this.tail = new Node(null, null);
        head.next = tail;
        tail.prev = head;
    }
    
    public V get(K key) {
        Node node = map.get(key);
        if (node == null) return null;
        
        moveToHead(node);
        return node.value;
    }
    
    public void put(K key, V value) {
        Node node = map.get(key);
        
        if (node != null) {
            node.value = value;
            moveToHead(node);
        } else {
            Node newNode = new Node(key, value);
            
            if (map.size() >= capacity) {
                Node tail = removeTail();
                map.remove(tail.key);
            }
            
            addToHead(newNode);
            map.put(key, newNode);
        }
    }
    
    private void addToHead(Node node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }
    
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    private void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }
    
    private Node removeTail() {
        Node lastNode = tail.prev;
        removeNode(lastNode);
        return lastNode;
    }
}
```

### Advanced Questions

#### Q5: Design a distributed system for real-time notifications (like WhatsApp)
**Expected Discussion Points:**
- WebSocket connections for real-time communication
- Message queues (Apache Kafka, RabbitMQ)
- Database sharding strategies
- Caching layers (Redis)
- Load balancing
- Microservices architecture
- Eventual consistency
- Push notification services

```java
// Sample architecture components
public class NotificationService {
    private MessageQueue messageQueue;
    private ConnectionManager connectionManager;
    private NotificationStorage storage;
    
    public void sendNotification(String userId, Notification notification) {
        // 1. Store notification
        storage.save(notification);
        
        // 2. Check if user is online
        if (connectionManager.isUserOnline(userId)) {
            // Send immediately via WebSocket
            connectionManager.sendToUser(userId, notification);
        } else {
            // Queue for push notification
            messageQueue.publish(new PushNotificationEvent(userId, notification));
        }
        
        // 3. Handle message delivery confirmation
        notification.setStatus(DeliveryStatus.SENT);
        storage.update(notification);
    }
}
```

#### Q6: Implement a custom annotation processor
```java
// Custom annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Cacheable {
    String value() default "";
    int expiry() default 3600; // seconds
}

// Aspect for caching
@Aspect
@Component
public class CacheAspect {
    private CacheManager cacheManager;
    
    @Around("@annotation(cacheable)")
    public Object handleCaching(ProceedingJoinPoint joinPoint, Cacheable cacheable) throws Throwable {
        String cacheKey = generateCacheKey(joinPoint, cacheable.value());
        
        // Try to get from cache
        Object cachedValue = cacheManager.get(cacheKey);
        if (cachedValue != null) {
            return cachedValue;
        }
        
        // Execute method and cache result
        Object result = joinPoint.proceed();
        cacheManager.put(cacheKey, result, cacheable.expiry());
        
        return result;
    }
    
    private String generateCacheKey(ProceedingJoinPoint joinPoint, String prefix) {
        StringBuilder keyBuilder = new StringBuilder();
        
        if (!prefix.isEmpty()) {
            keyBuilder.append(prefix).append(":");
        }
        
        keyBuilder.append(joinPoint.getSignature().getName());
        
        for (Object arg : joinPoint.getArgs()) {
            keyBuilder.append(":").append(arg.hashCode());
        }
        
        return keyBuilder.toString();
    }
}
```

### System Design Questions

#### Q7: Design a URL shortener like bit.ly
**Expected Components:**
```java
// URL shortener service
public class URLShortenerService {
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int BASE = ALPHABET.length();
    
    private URLRepository urlRepository;
    private CacheService cacheService;
    private CounterService counterService;
    
    public String shortenURL(String longURL) {
        // Check if URL already exists
        String existingShortCode = urlRepository.findShortCodeByLongURL(longURL);
        if (existingShortCode != null) {
            return buildShortURL(existingShortCode);
        }
        
        // Generate new short code
        long counter = counterService.getNextCounter();
        String shortCode = encodeToBase62(counter);
        
        // Store mapping
        URLMapping mapping = new URLMapping(shortCode, longURL, new Date());
        urlRepository.save(mapping);
        
        // Cache for quick access
        cacheService.put(shortCode, longURL, 3600); // 1 hour TTL
        
        return buildShortURL(shortCode);
    }
    
    public String expandURL(String shortCode) {
        // Try cache first
        String longURL = cacheService.get(shortCode);
        if (longURL != null) {
            recordAnalytics(shortCode);
            return longURL;
        }
        
        // Fallback to database
        URLMapping mapping = urlRepository.findByShortCode(shortCode);
        if (mapping != null) {
            // Update cache
            cacheService.put(shortCode, mapping.getLongURL(), 3600);
            recordAnalytics(shortCode);
            return mapping.getLongURL();
        }
        
        throw new URLNotFoundException("Short URL not found: " + shortCode);
    }
    
    private String encodeToBase62(long num) {
        StringBuilder encoded = new StringBuilder();
        
        while (num > 0) {
            encoded.append(ALPHABET.charAt((int) (num % BASE)));
            num = num / BASE;
        }
        
        return encoded.reverse().toString();
    }
    
    private String buildShortURL(String shortCode) {
        return "https://myshort.ly/" + shortCode;
    }
    
    private void recordAnalytics(String shortCode) {
        // Async analytics recording
        CompletableFuture.runAsync(() -> {
            AnalyticsService.recordClick(shortCode, new Date());
        });
    }
}
```

### Performance and Optimization

#### Q8: How would you optimize a slow database query in a high-traffic application?

**Expected Approaches:**
1. **Query Analysis:**
   - Use EXPLAIN PLAN to understand execution
   - Identify full table scans, missing indexes
   - Check join conditions and WHERE clauses

2. **Indexing Strategy:**
   ```sql
   -- Composite index for common query patterns
   CREATE INDEX idx_user_activity_date ON user_activities(user_id, activity_date DESC);
   
   -- Partial index for frequently filtered data
   CREATE INDEX idx_active_users ON users(created_date) WHERE status = 'ACTIVE';
   ```

3. **Caching Layers:**
   ```java
   @Service
   public class UserService {
       @Cacheable(value = "users", key = "#userId")
       public User getUserById(String userId) {
           return userRepository.findById(userId);
       }
       
       @Cacheable(value = "userStats", key = "#userId", unless = "#result.lastUpdated < T(System).currentTimeMillis() - 300000")
       public UserStatistics getUserStats(String userId) {
           return statisticsService.calculateStats(userId);
       }
   }
   ```

4. **Database Optimization:**
   - Connection pooling configuration
   - Read replicas for read-heavy workloads
   - Database sharding for horizontal scaling
   - Query result pagination

5. **Application-Level Optimizations:**
   ```java
   // Batch processing to reduce database calls
   public void updateUserPreferences(List<UserPreference> preferences) {
       int batchSize = 100;
       for (int i = 0; i < preferences.size(); i += batchSize) {
           List<UserPreference> batch = preferences.subList(i, 
               Math.min(i + batchSize, preferences.size()));
           userRepository.batchUpdate(batch);
       }
   }
   
   // Async processing for non-critical operations
   @Async
   public void updateUserAnalytics(String userId, UserActivity activity) {
       analyticsService.processActivity(userId, activity);
   }
   ```

### Behavioral and Problem-Solving

#### Q9: You discover a critical bug in production affecting 10% of users. Walk me through your approach.

**Expected Response Structure:**
1. **Immediate Assessment (0-5 minutes)**
   - Assess severity and impact
   - Check monitoring dashboards
   - Identify affected user segments

2. **Incident Response (5-30 minutes)**
   - Alert relevant team members
   - Create incident channel/war room
   - Implement immediate mitigation if possible

3. **Root Cause Analysis (30 minutes - 2 hours)**
   - Reproduce the issue in staging
   - Analyze recent deployments
   - Check error logs and stack traces

4. **Fix Implementation**
   ```java
   // Example: Safe fix with feature flag
   @Service
   public class PaymentService {
       @Value("${feature.new-payment-flow.enabled:false}")
       private boolean newPaymentFlowEnabled;
       
       public PaymentResult processPayment(PaymentRequest request) {
           if (newPaymentFlowEnabled && isEligibleForNewFlow(request)) {
               return processPaymentNewFlow(request);
           } else {
               // Fall back to stable implementation
               return processPaymentLegacy(request);
           }
       }
   }
   ```

5. **Post-Incident Actions**
   - Comprehensive testing
   - Gradual rollout with monitoring
   - Post-mortem documentation
   - Process improvements

### Conclusion

This comprehensive guide covers Java OOP from basic concepts to advanced design patterns used in top tech companies. The examples are drawn from real-world systems at Google, Amazon, Netflix, Microsoft, and other industry leaders.

**Key Takeaways for Top 1% Candidates:**
1. **Master the Fundamentals** - Deep understanding of OOP principles
2. **Apply Design Patterns** - Know when and how to use them appropriately  
3. **Think at Scale** - Consider performance, maintainability, and scalability
4. **Real-World Context** - Understand how concepts apply in production systems
5. **Best Practices** - Follow SOLID principles and industry standards
6. **Problem-Solving** - Approach complex problems systematically
7. **Communication** - Explain technical concepts clearly

**Next Steps:**
- Practice implementing these patterns in your own projects
- Study open-source codebases of major companies
- Participate in system design discussions
- Build portfolio projects demonstrating these concepts
- Stay updated with emerging patterns and best practices

Remember: Being in the top 1% isn't just about knowing syntax—it's about understanding how to architect robust, scalable, and maintainable systems that solve real-world problems.# Java OOP Mastery Guide: From Basic to Advanced
*Become a Top 1% Candidate with Real-World Industry Examples*

## Table of Contents
1. [Introduction to OOP](#introduction-to-oop)
2. [Classes and Objects](#classes-and-objects)
3. [Encapsulation](#encapsulation)
4. [Inheritance](#inheritance)
5. [Polymorphism](#polymorphism)
6. [Abstraction](#abstraction)
7. [Advanced OOP Concepts](#advanced-oop-concepts)
8. [Design Patterns](#design-patterns)
9. [Industry Examples](#industry-examples)
10. [Interview Questions](#interview-questions)

---

## Introduction to OOP

Object-Oriented Programming (OOP) is a programming paradigm based on the concept of "objects" which contain data (fields) and code (methods). The four main principles are:

### The Four Pillars of OOP
1. **Encapsulation** - Bundling data and methods together
2. **Inheritance** - Creating new classes based on existing ones
3. **Polymorphism** - One interface, multiple implementations
4. **Abstraction** - Hiding complex implementation details

### Why OOP Matters in Top Companies
- **Google**: Uses OOP for Android development, Chrome browser architecture
- **Amazon**: E-commerce platform, AWS services architecture
- **Microsoft**: .NET framework, Azure cloud services
- **Netflix**: Microservices architecture, recommendation systems
- **Uber**: Real-time location services, payment processing

---

## Classes and Objects

### Basic Class Structure

```java
// Real Example: Netflix User Profile System
public class UserProfile {
    // Instance variables (fields)
    private String userId;
    private String name;
    private String email;
    private int age;
    private String subscriptionType;
    private List<String> watchHistory;
    
    // Constructor
    public UserProfile(String userId, String name, String email, int age) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.age = age;
        this.subscriptionType = "Basic";
        this.watchHistory = new ArrayList<>();
    }
    
    // Methods
    public void addToWatchHistory(String movieTitle) {
        watchHistory.add(movieTitle);
    }
    
    public void upgradeSubscription(String newType) {
        this.subscriptionType = newType;
    }
    
    public List<String> getRecommendations() {
        // Netflix's recommendation algorithm simulation
        return new ArrayList<>();
    }
}
```

### Industry Example: Uber's Driver System

```java
public class Driver {
    private String driverId;
    private String name;
    private String licenseNumber;
    private Location currentLocation;
    private DriverStatus status;
    private Vehicle vehicle;
    private double rating;
    
    public Driver(String driverId, String name, String licenseNumber) {
        this.driverId = driverId;
        this.name = name;
        this.licenseNumber = licenseNumber;
        this.status = DriverStatus.OFFLINE;
        this.rating = 5.0;
    }
    
    public void goOnline() {
        this.status = DriverStatus.AVAILABLE;
        // Notify Uber's dispatch system
    }
    
    public void acceptRide(RideRequest request) {
        this.status = DriverStatus.BUSY;
        // Start navigation to pickup location
    }
}
```

---

## Encapsulation

Encapsulation is the bundling of data and methods that operate on that data within a single unit (class), and restricting access to some components.

### Real Example: Amazon's Payment Processing

```java
public class PaymentProcessor {
    // Private fields - encapsulated data
    private String merchantId;
    private String apiKey;
    private double transactionFee;
    private SecurityManager securityManager;
    
    public PaymentProcessor(String merchantId, String apiKey) {
        this.merchantId = merchantId;
        this.apiKey = apiKey;
        this.transactionFee = 0.029; // 2.9%
        this.securityManager = new SecurityManager();
    }
    
    // Public interface - controlled access
    public PaymentResult processPayment(PaymentRequest request) {
        if (!validateRequest(request)) {
            return PaymentResult.failure("Invalid request");
        }
        
        if (!authenticateTransaction(request)) {
            return PaymentResult.failure("Authentication failed");
        }
        
        return executePayment(request);
    }
    
    // Private methods - implementation details hidden
    private boolean validateRequest(PaymentRequest request) {
        // Complex validation logic
        return request != null && request.getAmount() > 0;
    }
    
    private boolean authenticateTransaction(PaymentRequest request) {
        // Security checks using encrypted keys
        return securityManager.authenticate(request, apiKey);
    }
    
    private PaymentResult executePayment(PaymentRequest request) {
        // Actual payment processing
        double totalAmount = request.getAmount() * (1 + transactionFee);
        // Process with payment gateway
        return PaymentResult.success(totalAmount);
    }
    
    // Getters and setters for controlled access
    public double getTransactionFee() {
        return transactionFee;
    }
    
    // No setter for apiKey - read-only after construction
}
```

### Benefits in Industry
- **Security**: Sensitive data (API keys, passwords) are hidden
- **Maintainability**: Internal changes don't affect external code
- **Validation**: Data integrity through controlled access

---

## Inheritance

Inheritance allows a class to inherit properties and methods from another class.

### Real Example: Google's Android UI Components

```java
// Base class - Android View system
public abstract class View {
    protected int x, y, width, height;
    protected boolean visible;
    protected String id;
    
    public View(String id) {
        this.id = id;
        this.visible = true;
    }
    
    public abstract void draw(Canvas canvas);
    
    public void setVisible(boolean visible) {
        this.visible = visible;
        invalidate(); // Request redraw
    }
    
    protected void invalidate() {
        // Notify system to redraw this view
    }
    
    // Common functionality for all views
    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
        invalidate();
    }
}

// Inherited class - Button
public class Button extends View {
    private String text;
    private Color backgroundColor;
    private OnClickListener clickListener;
    
    public Button(String id, String text) {
        super(id); // Call parent constructor
        this.text = text;
        this.backgroundColor = Color.GRAY;
    }
    
    @Override
    public void draw(Canvas canvas) {
        if (!visible) return;
        
        // Draw button background
        canvas.drawRect(x, y, width, height, backgroundColor);
        // Draw button text
        canvas.drawText(text, x + 10, y + height/2);
    }
    
    public void setText(String text) {
        this.text = text;
        invalidate(); // Inherited method
    }
    
    public void setOnClickListener(OnClickListener listener) {
        this.clickListener = listener;
    }
}

// Another inherited class - ImageView
public class ImageView extends View {
    private Image image;
    private ScaleType scaleType;
    
    public ImageView(String id) {
        super(id);
        this.scaleType = ScaleType.FIT_CENTER;
    }
    
    @Override
    public void draw(Canvas canvas) {
        if (!visible || image == null) return;
        
        // Draw scaled image
        canvas.drawImage(image, x, y, width, height, scaleType);
    }
    
    public void setImage(Image image) {
        this.image = image;
        invalidate(); // Inherited method
    }
}
```

### Real Example: Microsoft's Office Document System

```java
// Base Document class
public abstract class Document {
    protected String title;
    protected String author;
    protected Date createdDate;
    protected Date modifiedDate;
    protected boolean isDirty; // Has unsaved changes
    
    public Document(String title, String author) {
        this.title = title;
        this.author = author;
        this.createdDate = new Date();
        this.modifiedDate = new Date();
        this.isDirty = false;
    }
    
    // Template method pattern
    public final boolean save() {
        if (!validate()) {
            return false;
        }
        
        boolean result = performSave();
        if (result) {
            isDirty = false;
            modifiedDate = new Date();
        }
        return result;
    }
    
    protected abstract boolean validate();
    protected abstract boolean performSave();
    public abstract void print();
    
    // Common functionality
    public void markDirty() {
        this.isDirty = true;
    }
}

// Word Document
public class WordDocument extends Document {
    private List<Paragraph> paragraphs;
    private DocumentStyle style;
    
    public WordDocument(String title, String author) {
        super(title, author);
        this.paragraphs = new ArrayList<>();
        this.style = DocumentStyle.NORMAL;
    }
    
    @Override
    protected boolean validate() {
        // Word-specific validation
        return title != null && !title.trim().isEmpty();
    }
    
    @Override
    protected boolean performSave() {
        // Save as .docx format
        return FileManager.saveAsDocx(this);
    }
    
    @Override
    public void print() {
        // Word-specific printing logic
        PrintManager.printWordDocument(this);
    }
    
    public void addParagraph(String text) {
        paragraphs.add(new Paragraph(text));
        markDirty(); // Inherited method
    }
}

// Excel Document
public class ExcelDocument extends Document {
    private List<Worksheet> worksheets;
    
    public ExcelDocument(String title, String author) {
        super(title, author);
        this.worksheets = new ArrayList<>();
        // Always start with one worksheet
        worksheets.add(new Worksheet("Sheet1"));
    }
    
    @Override
    protected boolean validate() {
        // Excel-specific validation
        return !worksheets.isEmpty();
    }
    
    @Override
    protected boolean performSave() {
        // Save as .xlsx format
        return FileManager.saveAsExcel(this);
    }
    
    @Override
    public void print() {
        // Excel-specific printing logic
        PrintManager.printExcelDocument(this);
    }
    
    public void addWorksheet(String name) {
        worksheets.add(new Worksheet(name));
        markDirty(); // Inherited method
    }
}
```

---

## Polymorphism

Polymorphism allows objects of different types to be treated as instances of the same type through a common interface.

### Types of Polymorphism

#### 1. Compile-time Polymorphism (Method Overloading)

```java
// Real Example: Netflix's Search System
public class SearchService {
    // Method overloading - same name, different parameters
    public List<Content> search(String query) {
        // Basic text search
        return performTextSearch(query);
    }
    
    public List<Content> search(String query, Genre genre) {
        // Search with genre filter
        return performTextSearch(query).stream()
                .filter(content -> content.getGenre() == genre)
                .collect(Collectors.toList());
    }
    
    public List<Content> search(String query, int releaseYear) {
        // Search with year filter
        return performTextSearch(query).stream()
                .filter(content -> content.getReleaseYear() == releaseYear)
                .collect(Collectors.toList());
    }
    
    public List<Content> search(String query, Genre genre, int releaseYear, double minRating) {
        // Advanced search with multiple filters
        return performTextSearch(query).stream()
                .filter(content -> content.getGenre() == genre)
                .filter(content -> content.getReleaseYear() == releaseYear)
                .filter(content -> content.getRating() >= minRating)
                .collect(Collectors.toList());
    }
    
    private List<Content> performTextSearch(String query) {
        // Implementation of text search algorithm
        return ContentDatabase.searchByText(query);
    }
}
```

#### 2. Runtime Polymorphism (Method Overriding)

```java
// Real Example: Amazon's Shipping System
public abstract class ShippingStrategy {
    protected double baseCost;
    
    public abstract double calculateCost(Package pkg);
    public abstract int getEstimatedDays();
    public abstract String getTrackingInfo(String orderId);
    
    // Template method
    public final ShippingResult ship(Package pkg, Address address) {
        double cost = calculateCost(pkg);
        int days = getEstimatedDays();
        String trackingId = generateTrackingId();
        
        return new ShippingResult(cost, days, trackingId);
    }
    
    private String generateTrackingId() {
        return "AMZ" + System.currentTimeMillis();
    }
}

// Standard Shipping
public class StandardShipping extends ShippingStrategy {
    public StandardShipping() {
        this.baseCost = 5.99;
    }
    
    @Override
    public double calculateCost(Package pkg) {
        return baseCost + (pkg.getWeight() * 0.5);
    }
    
    @Override
    public int getEstimatedDays() {
        return 5; // 5-7 business days
    }
    
    @Override
    public String getTrackingInfo(String orderId) {
        return "Your package is being processed at our facility";
    }
}

// Prime Shipping
public class PrimeShipping extends ShippingStrategy {
    public PrimeShipping() {
        this.baseCost = 0.0; // Free for Prime members
    }
    
    @Override
    public double calculateCost(Package pkg) {
        return 0.0; // Free shipping
    }
    
    @Override
    public int getEstimatedDays() {
        return 2; // 2-day delivery
    }
    
    @Override
    public String getTrackingInfo(String orderId) {
        return "Your Prime package is out for delivery";
    }
}

// Express Shipping
public class ExpressShipping extends ShippingStrategy {
    public ExpressShipping() {
        this.baseCost = 24.99;
    }
    
    @Override
    public double calculateCost(Package pkg) {
        return baseCost + (pkg.getWeight() * 2.0);
    }
    
    @Override
    public int getEstimatedDays() {
        return 1; // Next day delivery
    }
    
    @Override
    public String getTrackingInfo(String orderId) {
        return "Your express package is in transit";
    }
}

// Usage in Amazon's Order Processing System
public class OrderProcessor {
    public void processOrder(Order order) {
        ShippingStrategy shipping;
        
        // Polymorphism in action - same interface, different behavior
        if (order.getCustomer().isPrimeMember()) {
            shipping = new PrimeShipping();
        } else if (order.isExpressRequested()) {
            shipping = new ExpressShipping();
        } else {
            shipping = new StandardShipping();
        }
        
        // Same method call, different implementations
        ShippingResult result = shipping.ship(order.getPackage(), order.getAddress());
        order.setShippingResult(result);
    }
}
```

### Real Example: Google's YouTube Video Processing

```java
// Interface for video processing
public interface VideoProcessor {
    void process(VideoFile video);
    String getSupportedFormat();
    VideoQuality[] getSupportedQualities();
}

// Different implementations for different formats
public class MP4Processor implements VideoProcessor {
    @Override
    public void process(VideoFile video) {
        System.out.println("Processing MP4 video with H.264 codec");
        // MP4-specific processing logic
        compressWithH264(video);
        generateThumbnails(video);
        createManifest(video);
    }
    
    @Override
    public String getSupportedFormat() {
        return "MP4";
    }
    
    @Override
    public VideoQuality[] getSupportedQualities() {
        return new VideoQuality[]{VideoQuality.P144, VideoQuality.P360, 
                                 VideoQuality.P720, VideoQuality.P1080, VideoQuality.P4K};
    }
    
    private void compressWithH264(VideoFile video) {
        // H.264 compression algorithm
    }
    
    private void generateThumbnails(VideoFile video) {
        // Generate multiple thumbnail options
    }
    
    private void createManifest(VideoFile video) {
        // Create DASH manifest for adaptive streaming
    }
}

public class WebMProcessor implements VideoProcessor {
    @Override
    public void process(VideoFile video) {
        System.out.println("Processing WebM video with VP9 codec");
        // WebM-specific processing logic
        compressWithVP9(video);
        generateThumbnails(video);
        createManifest(video);
    }
    
    @Override
    public String getSupportedFormat() {
        return "WebM";
    }
    
    @Override
    public VideoQuality[] getSupportedQualities() {
        return new VideoQuality[]{VideoQuality.P360, VideoQuality.P720, 
                                 VideoQuality.P1080, VideoQuality.P1440, VideoQuality.P4K};
    }
    
    private void compressWithVP9(VideoFile video) {
        // VP9 compression algorithm
    }
}

// YouTube's video processing service
public class YouTubeProcessingService {
    private Map<String, VideoProcessor> processors;
    
    public YouTubeProcessingService() {
        processors = new HashMap<>();
        processors.put("MP4", new MP4Processor());
        processors.put("WebM", new WebMProcessor());
        processors.put("MOV", new MOVProcessor());
        processors.put("AVI", new AVIProcessor());
    }
    
    public void processUploadedVideo(VideoFile video) {
        String format = video.getFormat().toUpperCase();
        VideoProcessor processor = processors.get(format);
        
        if (processor != null) {
            // Polymorphism: same method call, different behavior
            processor.process(video);
        } else {
            throw new UnsupportedFormatException("Format " + format + " not supported");
        }
    }
    
    // Process multiple videos with different processors
    public void processBatch(List<VideoFile> videos) {
        for (VideoFile video : videos) {
            processUploadedVideo(video); // Polymorphic behavior
        }
    }
}
```

---

## Abstraction

Abstraction hides complex implementation details and shows only essential features of an object.

### Real Example: Uber's Payment Gateway Abstraction

```java
// Abstract payment gateway
public abstract class PaymentGateway {
    protected String gatewayName;
    protected String apiVersion;
    protected boolean isTestMode;
    
    public PaymentGateway(String gatewayName, String apiVersion) {
        this.gatewayName = gatewayName;
        this.apiVersion = apiVersion;
        this.isTestMode = false;
    }
    
    // Template method - defines the payment flow
    public final PaymentResult processPayment(PaymentRequest request) {
        // Pre-processing validation (common for all gateways)
        if (!validateRequest(request)) {
            return PaymentResult.failure("Invalid payment request");
        }
        
        // Gateway-specific authentication
        if (!authenticate()) {
            return PaymentResult.failure("Authentication failed");
        }
        
        // Gateway-specific payment processing
        PaymentResult result = executePayment(request);
        
        // Post-processing (common for all gateways)
        logTransaction(request, result);
        notifyRider(request, result);
        
        return result;
    }
    
    // Abstract methods - must be implemented by concrete classes
    protected abstract boolean authenticate();
    protected abstract PaymentResult executePayment(PaymentRequest request);
    protected abstract void handleRefund(String transactionId, double amount);
    
    // Concrete methods - common functionality
    private boolean validateRequest(PaymentRequest request) {
        return request != null && 
               request.getAmount() > 0 && 
               request.getPaymentMethod() != null;
    }
    
    private void logTransaction(PaymentRequest request, PaymentResult result) {
        TransactionLogger.log(gatewayName, request, result);
    }
    
    private void notifyRider(PaymentRequest request, PaymentResult result) {
        if (result.isSuccess()) {
            NotificationService.sendPaymentConfirmation(request.getRiderId());
        }
    }
}

// Stripe implementation
public class StripePaymentGateway extends PaymentGateway {
    private StripeAPI stripeAPI;
    private String secretKey;
    
    public StripePaymentGateway(String secretKey) {
        super("Stripe", "v1");
        this.secretKey = secretKey;
        this.stripeAPI = new StripeAPI(secretKey);
    }
    
    @Override
    protected boolean authenticate() {
        try {
            return stripeAPI.validateApiKey(secretKey);
        } catch (StripeException e) {
            return false;
        }
    }
    
    @Override
    protected PaymentResult executePayment(PaymentRequest request) {
        try {
            StripeCharge charge = stripeAPI.createCharge(
                (int)(request.getAmount() * 100), // Convert to cents
                "usd",
                request.getPaymentMethod().getStripeToken(),
                "Uber ride payment"
            );
            
            return PaymentResult.success(charge.getId(), charge.getAmount() / 100.0);
        } catch (StripeException e) {
            return PaymentResult.failure(e.getMessage());
        }
    }
    
    @Override
    protected void handleRefund(String transactionId, double amount) {
        try {
            stripeAPI.createRefund(transactionId, (int)(amount * 100));
        } catch (StripeException e) {
            RefundLogger.logError("Stripe refund failed", e);
        }
    }
}

// PayPal implementation
public class PayPalPaymentGateway extends PaymentGateway {
    private PayPalAPI paypalAPI;
    private String clientId;
    private String clientSecret;
    
    public PayPalPaymentGateway(String clientId, String clientSecret) {
        super("PayPal", "v2");
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.paypalAPI = new PayPalAPI(clientId, clientSecret);
    }
    
    @Override
    protected boolean authenticate() {
        try {
            String accessToken = paypalAPI.getAccessToken(clientId, clientSecret);
            return accessToken != null;
        } catch (PayPalException e) {
            return false;
        }
    }
    
    @Override
    protected PaymentResult executePayment(PaymentRequest request) {
        try {
            PayPalPayment payment = paypalAPI.createPayment(
                request.getAmount(),
                "USD",
                "Uber ride payment",
                request.getPaymentMethod().getPayPalToken()
            );
            
            return PaymentResult.success(payment.getId(), payment.getAmount());
        } catch (PayPalException e) {
            return PaymentResult.failure(e.getMessage());
        }
    }
    
    @Override
    protected void handleRefund(String transactionId, double amount) {
        try {
            paypalAPI.refundPayment(transactionId, amount);
        } catch (PayPalException e) {
            RefundLogger.logError("PayPal refund failed", e);
        }
    }
}

// Uber's payment service using abstraction
public class UberPaymentService {
    private List<PaymentGateway> paymentGateways;
    
    public UberPaymentService() {
        paymentGateways = new ArrayList<>();
        paymentGateways.add(new StripePaymentGateway(System.getenv("STRIPE_SECRET_KEY")));
        paymentGateways.add(new PayPalPaymentGateway(
            System.getenv("PAYPAL_CLIENT_ID"), 
            System.getenv("PAYPAL_CLIENT_SECRET")
        ));
    }
    
    public PaymentResult processRidePayment(RideRequest ride) {
        PaymentRequest request = new PaymentRequest(
            ride.getFare(),
            ride.getPaymentMethod(),
            ride.getRiderId()
        );
        
        // Try primary gateway first, fallback to others
        for (PaymentGateway gateway : paymentGateways) {
            PaymentResult result = gateway.processPayment(request);
            if (result.isSuccess()) {
                return result;
            }
        }
        
        return PaymentResult.failure("All payment gateways failed");
    }
}
```

### Interface vs Abstract Class

```java
// Interface - Contract definition (what to do)
public interface NotificationService {
    void sendNotification(String userId, String message);
    boolean isDelivered(String notificationId);
    void scheduleNotification(String userId, String message, Date scheduledTime);
    
    // Default method (Java 8+)
    default void sendBulkNotification(List<String> userIds, String message) {
        for (String userId : userIds) {
            sendNotification(userId, message);
        }
    }
}

// Abstract class - Partial implementation (how to do it)
public abstract class BaseNotificationService implements NotificationService {
    protected NotificationLogger logger;
    protected UserPreferenceService userPreferences;
    
    public BaseNotificationService() {
        this.logger = new NotificationLogger();
        this.userPreferences = new UserPreferenceService();
    }
    
    // Common implementation
    @Override
    public final void sendNotification(String userId, String message) {
        if (!userPreferences.isNotificationEnabled(userId)) {
            logger.log("Notification blocked for user: " + userId);
            return;
        }
        
        String formattedMessage = formatMessage(message);
        boolean sent = deliverNotification(userId, formattedMessage);
        
        if (sent) {
            logger.logSuccess(userId, message);
        } else {
            logger.logFailure(userId, message);
        }
    }
    
    // Template method
    protected String formatMessage(String message) {
        return "[" + getServiceName() + "] " + message;
    }
    
    // Abstract methods to be implemented by concrete classes
    protected abstract boolean deliverNotification(String userId, String message);
    protected abstract String getServiceName();
}

// Concrete implementation - Google Firebase
public class FirebaseNotificationService extends BaseNotificationService {
    private FirebaseMessaging firebaseMessaging;
    
    public FirebaseNotificationService() {
        super();
        this.firebaseMessaging = FirebaseMessaging.getInstance();
    }
    
    @Override
    protected boolean deliverNotification(String userId, String message) {
        try {
            String fcmToken = userPreferences.getFcmToken(userId);
            Message fcmMessage = Message.builder()
                .setToken(fcmToken)
                .setNotification(Notification.builder()
                    .setBody(message)
                    .build())
                .build();
            
            String response = firebaseMessaging.send(fcmMessage);
            return response != null;
        } catch (Exception e) {
            return false;
        }
    }
    
    @Override
    protected String getServiceName() {
        return "Firebase";
    }
    
    @Override
    public boolean isDelivered(String notificationId) {
        // Firebase-specific delivery check
        return firebaseMessaging.checkDeliveryStatus(notificationId);
    }
    
    @Override
    public void scheduleNotification(String userId, String message, Date scheduledTime) {
        // Firebase doesn't support scheduling, use a scheduler service
        SchedulerService.schedule(() -> {
            sendNotification(userId, message);
        }, scheduledTime);
    }
}

// Another implementation - AWS SNS
public class SNSNotificationService extends BaseNotificationService {
    private AmazonSNS snsClient;
    
    public SNSNotificationService() {
        super();
        this.snsClient = AmazonSNSClientBuilder.defaultClient();
    }
    
    @Override
    protected boolean deliverNotification(String userId, String message) {
        try {
            String phoneNumber = userPreferences.getPhoneNumber(userId);
            PublishRequest request = new PublishRequest()
                .withPhoneNumber(phoneNumber)
                .withMessage(message);
            
            PublishResult result = snsClient.publish(request);
            return result.getMessageId() != null;
        } catch (Exception e) {
            return false;
        }
    }
    
    @Override
    protected String getServiceName() {
        return "AWS SNS";
    }
    
    @Override
    public boolean isDelivered(String notificationId) {
        // SNS-specific delivery check
        return checkSNSDeliveryStatus(notificationId);
    }
    
    @Override
    public void scheduleNotification(String userId, String message, Date scheduledTime) {
        // Use AWS Lambda with CloudWatch Events for scheduling
        ScheduledNotificationLambda.schedule(userId, message, scheduledTime);
    }
    
    private boolean checkSNSDeliveryStatus(String messageId) {
        // Implementation for SNS delivery status check
        return true;
    }
}
```

---

## Advanced OOP Concepts

### 1. Composition vs Inheritance

#### Real Example: Tesla's Car Manufacturing System

```java
// Composition approach - Tesla Model S
public class TeslaModelS {
    // Has-a relationship instead of is-a
    private Engine engine;
    private Battery battery;
    private AutoPilot autoPilot;
    private InfotainmentSystem infotainment;
    private ClimateControl climate;
    
    public TeslaModelS() {
        // Flexible composition - can mix and match components
        this.engine = new ElectricEngine(750); // 750 HP
        this.battery = new LithiumIonBattery(100); // 100 kWh
        this.autoPilot = new AutoPilotV4();
        this.infotainment = new TeslaInfotainmentV11();
        this.climate = new DualZoneClimateControl();
    }
    
    public void drive() {
        engine.start();
        if (autoPilot.isEnabled()) {
            autoPilot.engage();
        }
    }
    
    public void charge() {
        battery.charge();
    }
    
    public void updateSoftware() {
        autoPilot.update();
        infotainment.update();
    }
    
    // Delegation to components
    public double getBatteryPercentage() {
        return battery.getChargePercentage();
    }
    
    public void setTemperature(int temperature) {
        climate.setTargetTemperature(temperature);
    }
}

// Individual components that can be reused
public class ElectricEngine {
    private int horsepower;
    private boolean isRunning;
    private int rpm;
    
    public ElectricEngine(int horsepower) {
        this.horsepower = horsepower;
        this.isRunning = false;
        this.rpm = 0;
    }
    
    public void start() {
        isRunning = true;
        rpm = 1000;
        System.out.println("Electric engine started - " + horsepower + " HP");
    }
    
    public void accelerate(int targetRpm) {
        if (isRunning) {
            this.rpm = Math.min(targetRpm, 15000); // Max RPM for electric motor
        }
    }
    
    public void stop() {
        isRunning = false;
        rpm = 0;
    }
}

public class LithiumIonBattery {
    private double capacity; // kWh
    private double currentCharge;
    private boolean isCharging;
    
    public LithiumIonBattery(double capacity) {
        this.capacity = capacity;
        this.currentCharge = capacity * 0.8; // Start at 80%
        this.isCharging = false;
    }
    
    public void charge() {
        isCharging = true;
        // Simulate charging process
        new Thread(() -> {
            while (currentCharge < capacity && isCharging) {
                currentCharge += 0.1;
                try {
                    Thread.sleep(100); // Simulate charging time
                } catch (InterruptedException e) {
                    break;
                }
            }
            isCharging = false;
        }).start();
    }
    
    public double getChargePercentage() {
        return (currentCharge / capacity) * 100;
    }
    
    public boolean discharge(double amount) {
        if (currentCharge >= amount) {
            currentCharge -= amount;
            return true;
        }
        return false;
    }
}

// Benefits of Composition:
// 1. Can reuse Battery in TeslaModelX, TeslaModel3, etc.
// 2. Can swap AutoPilotV4 with AutoPilotV5 without changing TeslaModelS
// 3. Different Tesla models can have different combinations
public class TeslaModel3 {
    private Engine engine;
    private Battery battery;
    private AutoPilot autoPilot;
    
    public TeslaModel3() {
        // Different configuration for Model 3
        this.engine = new ElectricEngine(480); // Lower HP
        this.battery = new LithiumIonBattery(75); // Smaller battery
        this.autoPilot = new AutoPilotV3(); // Older version
    }
}
```

#### Real Example: Netflix's Content System

```java
// Bad approach - Inheritance hierarchy becomes complex
/*
class Content { }
class Movie extends Content { }
class Series extends Content { }
class Documentary extends Content { }
class MovieDocumentary extends Movie, Documentary { } // Multiple inheritance not allowed!
*/

// Good approach - Composition
public class Content {
    private String id;
    private String title;
    private ContentMetadata metadata;
    private VideoFile videoFile;
    private List<AudioTrack> audioTracks;
    private List<Subtitle> subtitles;
    private ContentRating rating;
    private List<ContentTag> tags;
    
    public Content(String id, String title) {
        this.id = id;
        this.title = title;
        this.audioTracks = new ArrayList<>();
        this.subtitles = new ArrayList<>();
        this.tags = new ArrayList<>();
    }
    
    // Flexible composition
    public void setMetadata(ContentMetadata metadata) {
        this.metadata = metadata;
    }
    
    public void addAudioTrack(AudioTrack track) {
        this.audioTracks.add(track);
    }
    
    public void addSubtitle(Subtitle subtitle) {
        this.subtitles.add(subtitle);
    }
    
    public void addTag(ContentTag tag) {
        this.tags.add(tag);
    }
}

// Flexible components
public class ContentMetadata {
    private String genre;
    private int releaseYear;
    private int duration; // in minutes
    private String director;
    private List<String> cast;
    private String description;
    private boolean isOriginalContent;
    
    // Constructor and methods
}

public class MovieMetadata extends ContentMetadata {
    private String studio;
    private double boxOfficeRevenue;
    private List<String> awards;
    
    public MovieMetadata(String genre, int releaseYear, int duration, String director) {
        super(genre, releaseYear, duration, director);
        this.awards = new ArrayList<>();
    }
}

public class SeriesMetadata extends ContentMetadata {
    private int numberOfSeasons;
    private int numberOfEpisodes;
    private boolean isCompleted;
    private int episodeDuration;
    
    public SeriesMetadata(String genre, int releaseYear, String director) {
        super(genre, releaseYear, 0, director); // Duration calculated from episodes
        this.isCompleted = false;
    }
}

// Netflix content factory using composition
public class NetflixContentFactory {
    public static Content createMovie(String id, String title, MovieMetadata metadata) {
        Content content = new Content(id, title);
        content.setMetadata(metadata);
        content.addTag(new ContentTag("Movie"));
        
        if (metadata.isOriginalContent()) {
            content.addTag(new ContentTag("Netflix Original"));
        }
        
        return content;
    }
    
    public static Content createSeries(String id, String title, SeriesMetadata metadata) {
        Content content = new Content(id, title);
        content.setMetadata(metadata);
        content.addTag(new ContentTag("Series"));
        
        if (metadata.isOriginalContent()) {
            content.addTag(new ContentTag("Netflix Original"));
        }
        
        return content;
    }
    
    public static Content createDocumentary(String id, String title, ContentMetadata metadata) {
        Content content = new Content(id, title);
        content.setMetadata(metadata);
        content.addTag(new ContentTag("Documentary"));
        content.addTag(new ContentTag("Educational"));
        
        return content;
    }
}
```

### 2. SOLID Principles

#### Single Responsibility Principle (SRP)
*A class should have only one reason to change*

```java
// Bad: Multiple responsibilities
class UserService {
    public void createUser(User user) { /* ... */ }
    public void sendEmail(String email, String message) { /* ... */ }
    public void validateUser(User user) { /* ... */ }
    public void saveToDatabase(User user) { /* ... */ }
    public void logActivity(String activity) { /* ... */ }
}

// Good: Single responsibilities
class UserService {
    private EmailService emailService;
    private UserValidator validator;
    private UserRepository repository;
    private ActivityLogger logger;
    
    public UserService() {
        this.emailService = new EmailService();
        this.validator = new UserValidator();
        this.repository = new UserRepository();
        this.logger = new ActivityLogger();
    }
    
    public void createUser(User user) {
        if (validator.isValid(user)) {
            repository.save(user);
            emailService.sendWelcomeEmail(user.getEmail());
            logger.log("User created: " + user.getId());
        }
    }
}

class EmailService {
    public void sendWelcomeEmail(String email) {
        // Email sending logic
    }
    
    public void sendPasswordResetEmail(String email, String resetToken) {
        // Password reset email logic
    }
}

class UserValidator {
    public boolean isValid(User user) {
        return user.getEmail() != null && 
               user.getEmail().contains("@") &&
               user.getName() != null &&
               user.getName().length() > 0;
    }
}
```

#### Open/Closed Principle (OCP)
*Classes should be open for extension, closed for modification*

```java
// Real Example: Spotify's Music Player System
public abstract class MusicPlayer {
    protected String currentTrack;
    protected boolean isPlaying;
    
    // Template method - closed for modification
    public final void playMusic(String track) {
        loadTrack(track);
        startPlayback();
        updateUI();
    }
    
    // Open for extension
    protected abstract void loadTrack(String track);
    protected abstract void startPlayback();
    
    // Common functionality
    protected void updateUI() {
        System.out.println("Now playing: " + currentTrack);
    }
}

// Extension without modifying base class
public class SpotifyPremiumPlayer extends MusicPlayer {
    @Override
    protected void loadTrack(String track) {
        // High quality audio loading
        System.out.println("Loading " + track + " in 320kbps");
        this.currentTrack = track;
    }
    
    @Override
    protected void startPlayback() {
        // Premium features
        System.out.println("Starting premium playback with no ads");
        this.isPlaying = true;
    }
}

public class SpotifyFreePlayer extends MusicPlayer {
    private int playCount = 0;
    
    @Override
    protected void loadTrack(String track) {
        // Standard quality audio loading
        System.out.println("Loading " + track + " in 128kbps");
        this.currentTrack = track;
    }
    
    @Override
    protected void startPlayback() {
        if (playCount % 3 == 0) {
            playAdvertisement();
        }
        System.out.println("Starting free playback");
        this.isPlaying = true;
        playCount++;
    }
    
    private void playAdvertisement() {
        System.out.println("Playing 30-second advertisement...");
    }
}
```

#### Liskov Substitution Principle (LSP)
*Subtypes must be substitutable for their base types*

```java
// Real Example: AWS S3 Storage System
public abstract class CloudStorage {
    protected String bucketName;
    
    public CloudStorage(String bucketName) {
        this.bucketName = bucketName;
    }
    
    // Contract: Should upload file and return true if successful
    public abstract boolean uploadFile(String fileName, byte[] data);
    
    // Contract: Should download file and return data, null if not found
    public abstract byte[] downloadFile(String fileName);
    
    // Contract: Should delete file and return true if successful
    public abstract boolean deleteFile(String fileName);
    
    // Contract: Should return list of all files
    public abstract List<String> listFiles();
}

// Good LSP implementation - maintains contract
public class S3Storage extends CloudStorage {
    private AmazonS3 s3Client;
    
    public S3Storage(String bucketName) {
        super(bucketName);
        this.s3Client = AmazonS3ClientBuilder.defaultClient();
    }
    
    @Override
    public boolean uploadFile(String fileName, byte[] data) {
        try {
            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentLength(data.length);
            
            s3Client.putObject(bucketName, fileName, 
                new ByteArrayInputStream(data), metadata);
            return true;
        } catch (Exception e) {
            return false; // Maintains contract
        }
    }
    
    @Override
    public byte[] downloadFile(String fileName) {
        try {
            S3Object object = s3Client.getObject(bucketName, fileName);
            return object.getObjectContent().readAllBytes();
        } catch (Exception e) {
            return null; // Maintains contract
        }
    }
    
    @Override
    public boolean deleteFile(String fileName) {
        try {
            s3Client.deleteObject(bucketName, fileName);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    @Override
    public List<String> listFiles() {
        try {
            ObjectListing listing = s3Client.listObjects(bucketName);
            return listing.getObjectSummaries()
                .stream()
                .map(S3ObjectSummary::getKey)
                .collect(Collectors.toList());
        } catch (Exception e) {
            return new ArrayList<>(); // Maintains contract
        }
    }
}

// Another implementation that follows LSP
public class GoogleCloudStorage extends CloudStorage {
    private Storage storage;
    
    public GoogleCloudStorage(String bucketName) {
        super(bucketName);
        this.storage = StorageOptions.getDefaultInstance().getService();
    }
    
    @Override
    public boolean uploadFile(String fileName, byte[] data) {
        try {
            BlobId blobId = BlobId.of(bucketName, fileName);
            BlobInfo blobInfo = BlobInfo.newBuilder(blobId).build();
            storage.create(blobInfo, data);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    @Override
    public byte[] downloadFile(String fileName) {
        try {
            BlobId blobId = BlobId.of(bucketName, fileName);
            Blob blob = storage.get(blobId);
            return blob != null ? blob.getContent() : null;
        } catch (Exception e) {
            return null;
        }
    }
    
    @Override
    public boolean deleteFile(String fileName) {
        try {
            BlobId blobId = BlobId.of(bucketName, fileName);
            return storage.delete(blobId);
        } catch (Exception e) {
            return false;
        }
    }
    
    @Override
    public List<String> listFiles() {
        try {
            return StreamSupport.stream(
                storage.list(bucketName).iterateAll().spliterator(), false)
                .map(blob -> blob.getName())
                .collect(Collectors.toList());
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}

// Client code can use any CloudStorage implementation
public class FileManager {
    private CloudStorage storage;
    
    public FileManager(CloudStorage storage) {
        this.storage = storage; // LSP allows substitution
    }
    
    public void backupFiles(Map<String, byte[]> files) {
        for (Map.Entry<String, byte[]> entry : files.entrySet()) {
            boolean success = storage.uploadFile(entry.getKey(), entry.getValue());
            if (success) {
                System.out.println("Backed up: " + entry.getKey());
            }
        }
    }
    
    // Works with any CloudStorage implementation
    public void printAllFiles() {
        List<String> files = storage.listFiles();
        files.forEach(System.out::println);
    }
}
```

#### Interface Segregation Principle (ISP)
*Clients should not be forced to depend on interfaces they don't use*

```java
// Bad: Fat interface
interface WorkerInterface {
    void work();
    void eat();
    void sleep();
    void code();
    void attendMeeting();
    void writeDocumentation();
}

// Robot worker forced to implement unnecessary methods
class RobotWorker implements WorkerInterface {
    @Override
    public void work() { /* can work */ }
    
    @Override
    public void eat() { 
        throw new UnsupportedOperationException("Robots don't eat!"); 
    }
    
    @Override
    public void sleep() { 
        throw new UnsupportedOperationException("Robots don't sleep!"); 
    }
    
    // ... other unnecessary methods
}

// Good: Segregated interfaces
interface Workable {
    void work();
}

interface Eatable {
    void eat();
}

interface Sleepable {
    void sleep();
}

interface Codeable {
    void code();
}

interface Meetingable {
    void attendMeeting();
}

// Real Example: Google's Android Permission System
interface CameraPermission {
    boolean requestCameraAccess();
    void takePicture();
    void recordVideo();
}

interface LocationPermission {
    boolean requestLocationAccess();
    Location getCurrentLocation();
    void startLocationTracking();
}

interface StoragePermission {
    boolean requestStorageAccess();
    void saveFile(String fileName, byte[] data);
    byte[] readFile(String fileName);
}

interface ContactsPermission {
    boolean requestContactsAccess();
    List<Contact> getAllContacts();
    void addContact(Contact contact);
}

// Camera app only implements what it needs
public class CameraApp implements CameraPermission, StoragePermission {
    @Override
    public boolean requestCameraAccess() {
        return PermissionManager.request(Permission.CAMERA);
    }
    
    @Override
    public void takePicture() {
        if (requestCameraAccess()) {
            // Take picture logic
            byte[] imageData = CameraManager.capture();
            saveFile("IMG_" + System.currentTimeMillis() + ".jpg", imageData);
        }
    }
    
    @Override
    public void recordVideo() {
        if (requestCameraAccess()) {
            // Video recording logic
        }
    }
    
    @Override
    public boolean requestStorageAccess() {
        return PermissionManager.request(Permission.STORAGE);
    }
    
    @Override
    public void saveFile(String fileName, byte[] data) {
        if (requestStorageAccess()) {
            FileManager.save(fileName, data);
        }
    }
    
    @Override
    public byte[] readFile(String fileName) {
        if (requestStorageAccess()) {
            return FileManager.read(fileName);
        }
        return null;
    }
}

// Navigation app implements different interfaces
public class NavigationApp implements LocationPermission, ContactsPermission {
    @Override
    public boolean requestLocationAccess() {
        return PermissionManager.request(Permission.LOCATION);
    }
    
    @Override
    public Location getCurrentLocation() {
        if (requestLocationAccess()) {
            return LocationManager.getCurrentLocation();
        }
        return null;
    }
    
    @Override
    public void startLocationTracking() {
        if (requestLocationAccess()) {
            LocationManager.startTracking();
        }
    }
    
    @Override
    public boolean requestContactsAccess() {
        return PermissionManager.request(Permission.CONTACTS);
    }
    
    @Override
    public List<Contact> getAllContacts() {
        if (requestContactsAccess()) {
            return ContactManager.getAllContacts();
        }
        return new ArrayList<>();
    }
    
    @Override
    public void addContact(Contact contact) {
        if (requestContactsAccess()) {
            ContactManager.addContact(contact);
        }
    }
}
```

#### Dependency Inversion Principle (DIP)
*High-level modules should not depend on low-level modules. Both should depend on abstractions*

```java
// Real Example: Netflix's Recommendation Engine

// Bad: High-level class depends on low-level implementation
class BadRecommendationEngine {
    private MySQLUserRepository userRepo; // Direct dependency
    private RedisCache cache; // Direct dependency
    private ElasticsearchService searchService; // Direct dependency
    
    public List<Content> getRecommendations(String userId) {
        User user = userRepo.findById(userId); // Tightly coupled
        List<Content> cached = cache.get("rec_" + userId); // Tightly coupled
        
        if (cached == null) {
            cached = searchService.findSimilar(user.getPreferences()); // Tightly coupled
            cache.set("rec_" + userId, cached);
        }
        
        return cached;
    }
}

// Good: Depend on abstractions
public interface UserRepository {
    User findById(String userId);
    List<User> findSimilarUsers(String userId);
    void updatePreferences(String userId, List<String> preferences);
}

public interface CacheService {
    <T> T get(String key, Class<T> type);
    <T> void set(String key, T value, int ttlSeconds);
    void delete(String key);
}

public interface RecommendationAlgorithm {
    List<Content> generateRecommendations(User user);
    double calculateSimilarity(User user1, User user2);
}

// High-level module depends on abstractions
public class NetflixRecommendationEngine {
    private final UserRepository userRepository;
    private final CacheService cacheService;
    private final RecommendationAlgorithm algorithm;
    
    // Dependency injection through constructor
    public NetflixRecommendationEngine(UserRepository userRepository,
                                     CacheService cacheService,
                                     RecommendationAlgorithm algorithm) {
        this.userRepository = userRepository;
        this.cacheService = cacheService;
        this.algorithm = algorithm;
    }
    
    public List<Content> getPersonalizedRecommendations(String userId) {
        // Check cache first
        List<Content> cached = cacheService.get(
            "recommendations_" + userId, 
            List.class
        );
        
        if (cached != null) {
            return cached;
        }
        
        // Get user and generate recommendations
        User user = userRepository.findById(userId);
        if (user == null) {
            return new ArrayList<>();
        }
        
        List<Content> recommendations = algorithm.generateRecommendations(user);
        
        // Cache for 1 hour
        cacheService.set("recommendations_" + userId, recommendations, 3600);
        
        return recommendations;
    }
    
    public void updateUserPreferences(String userId, String contentId, Rating rating) {
        User user = userRepository.findById(userId);
        user.addRating(contentId, rating);
        
        // Update preferences based on rating
        List<String> updatedPreferences = calculateUpdatedPreferences(user);
        userRepository.updatePreferences(userId, updatedPreferences);
        
        // Invalidate cache
        cacheService.delete("recommendations_" + userId);
    }
    
    private List<String> calculateUpdatedPreferences(User user) {
        // Algorithm to update user preferences based on ratings
        return new ArrayList<>();
    }
}

// Low-level implementations
public class MongoUserRepository implements UserRepository {
    private MongoTemplate mongoTemplate;
    
    @Override
    public User findById(String userId) {
        return mongoTemplate.findById(userId, User.class);
    }
    
    @Override
    public List<User> findSimilarUsers(String userId) {
        // MongoDB-specific query
        return mongoTemplate.find(
            Query.query(Criteria.where("similarTo").is(userId)), 
            User.class
        );
    }
    
    @Override
    public void updatePreferences(String userId, List<String> preferences) {
        Update update = new Update().set("preferences", preferences);
        mongoTemplate.updateFirst(
            Query.query(Criteria.where("id").is(userId)), 
            update, 
            User.class
        );
    }
}

public class RedisCache implements CacheService {
    private RedisTemplate<String, Object> redisTemplate;
    
    @Override
    public <T> T get(String key, Class<T> type) {
        Object value = redisTemplate.opsForValue().get(key);
        return type.cast(value);
    }
    
    @Override
    public <T> void set(String key, T value, int ttlSeconds) {
        redisTemplate.opsForValue().set(key, value, Duration.ofSeconds(ttlSeconds));
    }
    
    @Override
    public void delete(String key) {
        redisTemplate.delete(key);
    }
}

// Machine learning-based recommendation algorithm
public class CollaborativeFilteringAlgorithm implements RecommendationAlgorithm {
    private MLModel model;
    private ContentService contentService;
    
    @Override
    public List<Content> generateRecommendations(User user) {
        // Use ML model to predict user preferences
        double[] userVector = vectorizeUser(user);
        double[] predictions = model.predict(userVector);
        
        // Get top content IDs
        List<String> topContentIds = getTopPredictions(predictions, 20);
        
        // Fetch actual content objects
        return contentService.getContentByIds(topContentIds);
    }
    
    @Override
    public double calculateSimilarity(User user1, User user2) {
        double[] vector1 = vectorizeUser(user1);
        double[] vector2 = vectorizeUser(user2);
        return cosineSimilarity(vector1, vector2);
    }
    
    private double[] vectorizeUser(User user) {
        // Convert user preferences to numerical vector
        return new double[0];
    }
    
    private List<String> getTopPredictions(double[] predictions, int count) {
        // Get indices of top predictions
        return new ArrayList<>();
    }
    
    private double cosineSimilarity(double[] a, double[] b) {
        // Calculate cosine similarity
        return 0.0;
    }
}

// Alternative algorithm implementation
public class ContentBasedAlgorithm implements RecommendationAlgorithm {
    private ContentAnalysisService analysisService;
    
    @Override
    public List<Content> generateRecommendations(User user) {
        // Analyze content user has liked
        List<Content> likedContent = user.getLikedContent();
        List<String> preferredGenres = analysisService.extractGenres(likedContent);
        List<String> preferredActors = analysisService.extractActors(likedContent);
        
        // Find similar content
        return analysisService.findSimilarContent(preferredGenres, preferredActors);
    }
    
    @Override
    public double calculateSimilarity(User user1, User user2) {
        Set<String> prefs1 = new HashSet<>(user1.getPreferences());
        Set<String> prefs2 = new HashSet<>(user2.getPreferences());
        
        // Jaccard similarity
        Set<String> intersection = new HashSet<>(prefs1);
        intersection.retainAll(prefs2);
        
        Set<String> union = new HashSet<>(prefs1);
        union.addAll(prefs2);
        
        return (double) intersection.size() / union.size();
    }
}

// Dependency injection configuration
public class RecommendationEngineFactory {
    public static NetflixRecommendationEngine createEngine(String algorithm) {
        UserRepository userRepo = new MongoUserRepository();
        CacheService cache = new RedisCache();
        
        RecommendationAlgorithm algo;
        if ("collaborative".equals(algorithm)) {
            algo = new CollaborativeFilteringAlgorithm();
        } else {
            algo = new ContentBasedAlgorithm();
        }
        
        return new NetflixRecommendationEngine(userRepo, cache, algo);
    }
}
```

### 3. Inner Classes and Nested Classes

```java
// Real Example: LinkedIn's Connection Manager
public class ConnectionManager {
    private List<Connection> connections;
    private ConnectionStats stats;
    
    public ConnectionManager() {
        this.connections = new ArrayList<>();
        this.stats = new ConnectionStats(); // Non-static inner class
    }
    
    // Non-static inner class - has access to outer class members
    public class ConnectionStats {
        public int getTotalConnections() {
            return connections.size(); // Can access outer class field
        }
        
        public int getConnectionsByLevel(int level) {
            return (int) connections.stream()
                .filter(conn -> conn.getLevel() == level)
                .count();
        }
        
        public double getAverageConnectionsPerMonth() {
            if (connections.isEmpty()) return 0;
            
            // Group by month and calculate average
            Map<String, Long> monthlyConnections = connections.stream()
                .collect(Collectors.groupingBy(
                    conn -> conn.getConnectedDate().toString().substring(0, 7),
                    Collectors.counting()
                ));
            
            return monthlyConnections.values().stream()
                .mapToLong(Long::longValue)
                .average()
                .orElse(0.0);
        }
    }
    
    // Static nested class - doesn't need outer class instance
    public static class ConnectionRequest {
        private String senderId;
        private String receiverId;
        private String message;
        private Date sentDate;
        private RequestStatus status;
        
        public ConnectionRequest(String senderId, String receiverId, String message) {
            this.senderId = senderId;
            this.receiverId = receiverId;
            this.message = message;
            this.sentDate = new Date();
            this.status = RequestStatus.PENDING;
        }
        
        public void accept() {
            this.status = RequestStatus.ACCEPTED;
        }
        
        public void reject() {
            this.status = RequestStatus.REJECTED;
        }
        
        // Getters and setters
        public String getSenderId() { return senderId; }
        public String getReceiverId() { return receiverId; }
        public RequestStatus getStatus() { return status; }
    }
    
    // Method using inner class
    public ConnectionStats getStats() {
        return stats;
    }
    
    // Method using static nested class
    public boolean sendConnectionRequest(String receiverId, String message) {
        String currentUserId = getCurrentUserId();
        ConnectionRequest request = new ConnectionRequest(currentUserId, receiverId, message);
        
        return NotificationService.sendConnectionRequest(request);
    }
    
    // Local class example
    public List<Connection> getMutualConnections(String userId) {
        // Local class - defined inside method
        class MutualConnectionFinder {
            private Set<String> userConnections;
            
            public MutualConnectionFinder(String userId) {
                userConnections = getUserConnections(userId);
            }
            
            public List<Connection> findMutuals() {
                return connections.stream()
                    .filter(conn -> userConnections.contains(conn.getUserId()))
                    .collect(Collectors.toList());
            }
            
            private Set<String> getUserConnections(String userId) {
                return connections.stream()
                    .filter(conn -> conn.getUserId().equals(userId))
                    .map(Connection::getConnectedUserId)
                    .collect(Collectors.toSet());
            }
        }
        
        MutualConnectionFinder finder = new MutualConnectionFinder(userId);
        return finder.findMutuals();
    }
    
    // Anonymous class example - for event handling
    public void setupConnectionListener() {
        ConnectionEventListener listener = new ConnectionEventListener() {
            @Override
            public void onConnectionAdded(Connection connection) {
                System.out.println("New connection: " + connection.getName());
                stats.getTotalConnections(); // Can access outer class through ConnectionManager.this
                
                // Send welcome message
                MessageService.sendWelcomeMessage(connection.getUserId());
            }
            
            @Override
            public void onConnectionRemoved(Connection connection) {
                System.out.println("Connection removed: " + connection.getName());
                
                // Log removal
                ActivityLogger.log("Connection removed: " + connection.getUserId());
            }
        };
        
        ConnectionEventBus.register(listener);
    }
    
    private String getCurrentUserId() {
        return "current-user-id"; // Placeholder
    }
}

// Usage example
public class LinkedInService {
    public void demonstrateInnerClasses() {
        ConnectionManager manager = new ConnectionManager();
        
        // Using non-static inner class
        ConnectionManager.ConnectionStats stats = manager.getStats();
        System.out.println("Total connections: " + stats.getTotalConnections());
        
        // Using static nested class - no outer instance needed
        ConnectionManager.ConnectionRequest request = 
            new ConnectionManager.ConnectionRequest("user1", "user2", "Let's connect!");
        request.accept();
        
        // Setup event listener with anonymous class
        manager.setupConnectionListener();
    }
}

enum RequestStatus {
    PENDING, ACCEPTED, REJECTED, EXPIRED
}

// Supporting classes
class Connection {
    private String userId;
    private String connectedUserId;
    private String name;
    private int level;
    private Date connectedDate;
    
    // Constructor and getters
    public Connection(String userId, String connectedUserId, String name) {
        this.userId = userId;
        this.connectedUserId = connectedUserId;
        this.name = name;
        this.level = 1;
        this.connectedDate = new Date();
    }
    
    public String getUserId() { return userId; }
    public String getConnectedUserId() { return connectedUserId; }
    public String getName() { return name; }
    public int getLevel() { return level; }
    public Date getConnectedDate() { return connectedDate; }
}
```

---

## Design Patterns

### 1. Creational Patterns

#### Singleton Pattern - Netflix Configuration Manager

```java
public class NetflixConfigManager {
    // Thread-safe singleton using enum
    public enum Instance {
        INSTANCE;
        
        private final ConfigManager configManager;
        
        Instance() {
            configManager = new ConfigManager();
        }
        
        public ConfigManager getConfigManager() {
            return configManager;
        }
    }
    
    private static class ConfigManager {
        private Map<String, String> configurations;
        private long lastUpdated;
        
        private ConfigManager() {
            configurations = new ConcurrentHashMap<>();
            loadConfigurations();
        }
        
        private void loadConfigurations() {
            // Load from AWS Systems Manager, Consul, etc.
            configurations.put("max_concurrent_streams", "4");
            configurations.put("video_quality_default", "HD");
            configurations.put("cache_ttl_minutes", "30");
            configurations.put("recommendation_batch_size", "50");
            lastUpdated = System.currentTimeMillis();
        }
        
        public String getConfig(String key) {
            // Auto-refresh every 5 minutes
            if (System.currentTimeMillis() - lastUpdated > 300000) {
                loadConfigurations();
            }
            return configurations.get(key);
        }
        
        public int getIntConfig(String key, int defaultValue) {
            String value = getConfig(key);
            try {
                return value != null ? Integer.parseInt(value) : defaultValue;
            } catch (NumberFormatException e) {
                return defaultValue;
            }
        }
    }
    
    // Usage
    public static ConfigManager getInstance() {
        return Instance.INSTANCE.getConfigManager();
    }
}

// Usage in Netflix services
public class StreamingService {
    public void startStream(String userId, String contentId) {
        ConfigManager config = NetflixConfigManager.getInstance();
        int maxStreams = config.getIntConfig("max_concurrent_streams", 2);
        
        if (getCurrentStreamCount(userId) >= maxStreams) {
            throw new MaxStreamsExceededException();
        }
        
        // Start streaming...
    }
}
```

#### Factory Pattern - Uber Vehicle Factory

```java
// Product hierarchy
public abstract class Vehicle {
    protected String vehicleId;
    protected String licensePlate;
    protected VehicleType type;
    protected Driver driver;
    
    public Vehicle(String vehicleId, String licensePlate) {
        this.vehicleId = vehicleId;
        this.licensePlate = licensePlate;
    }
    
    public abstract double calculateFare(double distance, int duration);
    public abstract boolean canAcceptRide(RideRequest request);
    public abstract int getCapacity();
    
    // Common methods
    public void assignDriver(Driver driver) {
        this.driver = driver;
    }
    
    public String getVehicleId() { return vehicleId; }
    public VehicleType getType() { return type; }
}

// Concrete products
public class UberX extends Vehicle {
    public UberX(String vehicleId, String licensePlate) {
        super(vehicleId, licensePlate);
        this.type = VehicleType.UBERX;
    }
    
    @Override
    public double calculateFare(double distance, int duration) {
        double baseFare = 2.55;
        double perMile = 1.35;
        double perMinute = 0.35;
        return baseFare + (distance * perMile) + (duration * perMinute);
    }
    
    @Override
    public boolean canAcceptRide(RideRequest request) {
        return request.getPassengerCount() <= 4;
    }
    
    @Override
    public int getCapacity() {
        return 4;
    }
}

public class UberXL extends Vehicle {
    public UberXL(String vehicleId, String licensePlate) {
        super(vehicleId, licensePlate);
        this.type = VehicleType.UBERXL;
    }
    
    @Override
    public double calculateFare(double distance, int duration) {
        double baseFare = 3.85;
        double perMile = 2.15;
        double perMinute = 0.55;
        return baseFare + (distance * perMile) + (duration * perMinute);
    }
    
    @Override
    public boolean canAcceptRide(RideRequest request) {
        return request.getPassengerCount() <= 6;
    }
    
    @Override
    public int getCapacity() {
        return 6;
    }
}

public class UberBlack extends Vehicle {
    public UberBlack(String vehicleId, String licensePlate) {
        super(vehicleId, licensePlate);
        this.type = VehicleType.UBERBLACK;
    }
    
    @Override
    public double calculateFare(double distance, int duration) {
        double baseFare = 7.00;
        double perMile = 3.75;
        double perMinute = 0.85;
        return baseFare + (distance * perMile) + (duration * perMinute);
    }
    
    @Override
    public boolean canAcceptRide(RideRequest request) {
        return request.getPassengerCount() <= 4 && request.isPremiumRequested();
    }
    
    @Override
    public int getCapacity() {
        return 4;
    }
}

// Factory interface
public abstract class VehicleFactory {
    public abstract Vehicle createVehicle(String vehicleId, String licensePlate);
    
    // Template method
    public Vehicle registerVehicle(String vehicleId, String licensePlate, Driver driver) {
        Vehicle vehicle = createVehicle(vehicleId, licensePlate);
        vehicle.assignDriver(driver);
        
        // Register with fleet management
        FleetManager.registerVehicle(vehicle);
        
        return vehicle;
    }
}

// Concrete factories
public class UberXFactory extends VehicleFactory {
    @Override
    public Vehicle createVehicle(String vehicleId, String licensePlate) {
        return new UberX(vehicleId, licensePlate);
    }
}

public class UberXLFactory extends VehicleFactory {
    @Override
    public Vehicle createVehicle(String vehicleId, String licensePlate) {
        return new UberXL(vehicleId, licensePlate);
    }
}

public class UberBlackFactory extends VehicleFactory {
    @Override
    public Vehicle createVehicle(String vehicleId, String licensePlate) {
        return new UberBlack(vehicleId, licensePlate);
    }
}

// Factory registry
public class VehicleFactoryRegistry {
    private static Map<VehicleType, VehicleFactory> factories = new HashMap<>();
    
    static {
        factories.put(VehicleType.UBERX, new UberXFactory());
        factories.put(VehicleType.UBERXL, new UberXLFactory());
        factories.put(VehicleType.UBERBLACK, new UberBlackFactory());
    }
    
    public static Vehicle createVehicle(VehicleType type, String vehicleId, 
                                      String licensePlate, Driver driver) {
        VehicleFactory factory = factories.get(type);
        if (factory == null) {
            throw new IllegalArgumentException("Unknown vehicle type: " + type);
        }
        
        return factory.registerVehicle(vehicleId, licensePlate, driver);
    }
}

// Usage in Uber's fleet management system
public class UberFleetService {
    public void onboardNewVehicle(VehicleOnboardingRequest request) {
        Vehicle vehicle = VehicleFactoryRegistry.createVehicle(
            request.getVehicleType(),
            request.getVehicleId(),
            request.getLicensePlate(),
            request.getDriver()
        );
        
        System.out.println("Onboarded new " + vehicle.getType() + 
                          " with capacity " + vehicle.getCapacity());
    }
}
```

#### Builder Pattern - Amazon Product Builder

```java
// Complex product with many optional parameters
public class Product {
    // Required parameters
    private final String productId;
    private final String name;
    private final double price;
    
    // Optional parameters
    private final String description;
    private final String category;
    private final String brand;
    private final List<String> images;
    private final List<String> tags;
    private final Map<String, String> specifications;
    private final double weight;
    private final Dimensions dimensions;
    private final boolean isPrime;
    private final boolean isNewRelease;
    private final boolean isBestSeller;
    private final int stockQuantity;
    private final double rating;
    private final int reviewCount;
    
    // Private constructor - only builder can create
    private Product(ProductBuilder builder) {
        this.productId = builder.productId;
        this.name = builder.name;
        this.price = builder.price;
        this.description = builder.description;
        this.category = builder.category;
        this.brand = builder.brand;
        this.images = builder.images != null ? new ArrayList<>(builder.images) : new ArrayList<>();
        this.tags = builder.tags != null ? new ArrayList<>(builder.tags) : new ArrayList<>();
        this.specifications = builder.specifications != null ? 
            new HashMap<>(builder.specifications) : new HashMap<>();
        this.weight = builder.weight;
        this.dimensions = builder.dimensions;
        this.isPrime = builder.isPrime;
        this.isNewRelease = builder.isNewRelease;
        this.isBestSeller = builder.isBestSeller;
        this.stockQuantity = builder.stockQuantity;
        this.rating = builder.rating;
        this.reviewCount = builder.reviewCount;
    }
    
    // Static nested Builder class
    public static class ProductBuilder {
        // Required parameters
        private final String productId;
        private final String name;
        private final double price;
        
        // Optional parameters with default values
        private String description = "";
        private String category = "General";
        private String brand = "";
        private List<String> images = new ArrayList<>();
        private List<String> tags = new ArrayList<>();
        private Map<String, String> specifications = new HashMap<>();
        private double weight = 0.0;
        private Dimensions dimensions = new Dimensions(0, 0, 0);
        private boolean isPrime = false;
        private boolean isNewRelease = false;
        private boolean isBestSeller = false;
        private int stockQuantity = 0;
        private double rating = 0.0;
        private int reviewCount = 0;
        
        // Constructor with required parameters
        public ProductBuilder(String productId, String name, double price) {
            if (productId == null || productId.trim().isEmpty()) {
                throw new IllegalArgumentException("Product ID cannot be null or empty");
            }
            if (name == null || name.trim().isEmpty()) {
                throw new IllegalArgumentException("Product name cannot be null or empty");
            }
            if (price < 0) {
                throw new IllegalArgumentException("Price cannot be negative");
            }
            
            this.productId = productId;
            this.name = name;
            this.price = price;
        }
        
        public ProductBuilder description(String description) {
            this.description = description != null ? description : "";
            return this;
        }
        
        public ProductBuilder category(String category) {
            this.category = category != null ? category : "General";
            return this;
        }
        
        public ProductBuilder brand(String brand) {
            this.brand = brand != null ? brand : "";
            return this;
        }
        
        public ProductBuilder addImage(String imageUrl) {
            if (imageUrl != null && !imageUrl.trim().isEmpty()) {
                this.images.add(imageUrl);
            }
            return this;
        }
        
        public ProductBuilder images(List<String> images) {
            if (images != null) {
                this.images = new ArrayList<>(images);
            }
            return this;
        }
        
        public ProductBuilder addTag(String tag) {
            if (tag != null && !tag.trim().isEmpty()) {
                this.tags.add(tag);
            }
            return this;
        }
        
        public ProductBuilder tags(List<String> tags) {
            if (tags != null) {
                this.tags = new ArrayList<>(tags);
            }
            return this;
        }
        
        public ProductBuilder addSpecification(String key, String value) {
            if (key != null && value != null) {
                this.specifications.put(key, value);
            }
            return this;
        }
        
        public ProductBuilder specifications(Map<String, String> specifications) {
            if (specifications != null) {
                this.specifications = new HashMap<>(specifications);
            }
            return this;
        }
        
        public ProductBuilder weight(double weight) {
            this.weight = Math.max(0, weight);
            return this;
        }
        
        public ProductBuilder dimensions(double length, double width, double height) {
            this.dimensions = new Dimensions(length, width, height);
            return this;
        }
        
        public ProductBuilder prime(boolean isPrime) {
            this.isPrime = isPrime;
            return this;
        }
        
        public ProductBuilder newRelease(boolean isNewRelease) {
            this.isNewRelease = isNewRelease;
            return this;
        }
        
        public ProductBuilder bestSeller(boolean isBestSeller) {
            this.isBestSeller = isBestSeller;
            return this;
        }
        
        public ProductBuilder stock(int quantity) {
            this.stockQuantity = Math.max(0, quantity);
            return this;
        }
        
        public ProductBuilder rating(double rating, int reviewCount) {
            this.rating = Math.max(0, Math.min(5, rating));
            this.reviewCount = Math.max(0, reviewCount);
            return this;
        }
        
        // Validation before building
        public Product build() {
            validate();
            return new Product(this);
        }
        
        private void validate() {
            if (isPrime && stockQuantity == 0) {
                throw new IllegalStateException("Prime products must be in stock");
            }
            
            if (isBestSeller && rating < 4.0) {
                throw new IllegalStateException("Best sellers must have rating >= 4.0");
            }
            
            if (!images.isEmpty() && images.size() > 10) {
                throw new IllegalStateException("Maximum 10 images allowed");
            }
        }
    }
    
    // Getters
    public String getProductId() { return productId; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public String getDescription() { return description; }
    public String getCategory() { return category; }
    public String getBrand() { return brand; }
    public List<String> getImages() { return new ArrayList<>(images); }
    public List<String> getTags() { return new ArrayList<>(tags); }
    public Map<String, String> getSpecifications() { return new HashMap<>(specifications); }
    public double getWeight() { return weight; }
    public Dimensions getDimensions() { return dimensions; }
    public boolean isPrime() { return isPrime; }
    public boolean isNewRelease() { return isNewRelease; }
    public boolean isBestSeller() { return isBestSeller; }
    public int getStockQuantity() { return stockQuantity; }
    public double getRating() { return rating; }
    public int getReviewCount() { return reviewCount; }
    
    @Override
    public String toString() {
        return "Product{" +
               "id='" + productId + '\'' +
               ", name='" + name + '\'' +
               ", price=" + price +
               ", prime=" + isPrime +
               ", stock=" + stockQuantity +
               '}';
    }
}

// Supporting classes
public class Dimensions {
    private final double length;
    private final double width;
    private final double height;
    
    public Dimensions(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }
    
    // Getters
    public double getLength() { return length; }
    public double getWidth() { return width; }
    public double getHeight() { return height; }
    
    public double getVolume() {
        return length * width * height;
    }
}

// Usage in Amazon's product management system
public class AmazonProductService {
    public void createElectronicsProduct() {
        Product laptop = new Product.ProductBuilder("LAPTOP-001", "MacBook Pro 16", 2399.00)
            .description("Apple MacBook Pro 16-inch with M2 Pro chip")
            .category("Electronics")
            .brand("Apple")
            .addImage("https://images.amazon.com/laptop1.jpg")
            .addImage("https://images.amazon.com/laptop2.jpg")
            .addTag("laptop")
            .addTag("apple")
            .addTag("macbook")
            .addSpecification("Processor", "Apple M2 Pro")
            .addSpecification("RAM", "16GB")
            .addSpecification("Storage", "512GB SSD")
            .addSpecification("Display", "16-inch Liquid Retina XDR")
            .weight(4.7)
            .dimensions(35.57, 24.81, 1.68)
            .prime(true)
            .newRelease(true)
            .stock(50)
            .rating(4.6, 1247)
            .build();
        
        System.out.println("Created product: " + laptop);
        ProductCatalogService.addProduct(laptop);
    }
    
    public void createBookProduct() {
        Product book = new Product.ProductBuilder("BOOK-002", "Clean Code", 42.99)
            .description("A Handbook of Agile Software Craftsmanship")
            .category("Books")
            .brand("Prentice Hall")
            .addImage("https://images.amazon.com/book1.jpg")
            .addTag("programming")
            .addTag("software development")
            .addTag("clean code")
            .addSpecification("Author", "Robert C. Martin")
            .addSpecification("Pages", "464")
            .addSpecification("Language", "English")
            .addSpecification("ISBN", "978-0132350884")
            .weight(0.9)
            .dimensions(23.5, 17.8, 2.3)
            .prime(true)
            .bestSeller(true)
            .stock(100)
            .rating(4.7, 2891)
            .build();
        
        ProductCatalogService.addProduct(book);
    }
    
    // Builder with method chaining for different product types
    public void createBulkProducts() {
        List<Product> products = Arrays.asList(
            // Electronics
            new Product.ProductBuilder("TV-001", "Samsung 55\" Smart TV", 899.99)
                .category("Electronics").brand("Samsung").prime(true).stock(25).build(),
                
            // Clothing
            new Product.ProductBuilder("SHIRT-001", "Nike Dri-FIT T-Shirt", 29.99)
                .category("Clothing").brand("Nike").addTag("athletic").stock(200).build(),
                
            // Home & Kitchen
            new Product.ProductBuilder("COFFEE-001", "Keurig Coffee Maker", 129.99)
                .category("Home & Kitchen").brand("Keurig").prime(true).stock(75).build()
        );
        
        products.forEach(ProductCatalogService::addProduct);
    }
}

// Mock service for demonstration
class ProductCatalogService {
    public static void addProduct(Product product) {
        System.out.println("Added to catalog: " + product.getName());
    }
}
```

### 2. Structural Patterns

#### Adapter Pattern - Google Maps Integration

```java
// Target interface that our application expects
public interface MapService {
    Location getCurrentLocation();
    List<Location> searchPlaces(String query, Location center, double radiusKm);
    Route calculateRoute(Location from, Location to, TravelMode mode);
    double calculateDistance(Location from, Location to);
}

// Third-party Google Maps API (Adaptee)
public class GoogleMapsAPI {
    private String apiKey;
    
    public GoogleMapsAPI(String apiKey) {
        this.apiKey = apiKey;
    }
    
    // Different method signatures and return types
    public GoogleLocation getCurrentGeoLocation() {
        // Google-specific implementation
        return new GoogleLocation(37.7749, -122.4194);
    }
    
    public GooglePlaceResult[] findNearbyPlaces(String searchTerm, 
                                               GoogleLocation center, 
                                               int radiusMeters) {
        // Google Places API call
        GooglePlaceResult[] results = new GooglePlaceResult[3];
        results[0] = new GooglePlaceResult("Starbucks", new GoogleLocation(37.7750, -122.4190));
        results[1] = new GooglePlaceResult("McDonald's", new GoogleLocation(37.7748, -122.4195));
        results[2] = new GooglePlaceResult("Subway", new GoogleLocation(37.7751, -122.4188));
        return results;
    }
    
    public GoogleDirectionsResponse getDirections(GoogleLocation origin,
                                                 GoogleLocation destination,
                                                 GoogleTravelMode mode) {
        // Google Directions API call
        return new GoogleDirectionsResponse(
            new GoogleLocation[]{origin, destination},
            15.2, // distance in km
            18 // duration in minutes
        );
    }
}

// Adapter class
public class GoogleMapsAdapter implements MapService {
    private GoogleMapsAPI googleMapsAPI;
    
    public GoogleMapsAdapter(String apiKey) {
        this.googleMapsAPI = new GoogleMapsAPI(apiKey);
    }
    
    @Override
    public Location getCurrentLocation() {
        GoogleLocation googleLoc = googleMapsAPI.getCurrentGeoLocation();
        // Convert Google's format to our format
        return new Location(googleLoc.getLat(), googleLoc.getLng());
    }
    
    @Override
    public List<Location> searchPlaces(String query, Location center, double radiusKm) {
        // Convert our format to Google's format
        GoogleLocation googleCenter = new GoogleLocation(center.getLatitude(), center.getLongitude());
        int radiusMeters = (int) (radiusKm * 1000);
        
        GooglePlaceResult[] googleResults = googleMapsAPI.findNearbyPlaces(query, googleCenter, radiusMeters);
        
        // Convert Google's results to our format
        return Arrays.stream(googleResults)
            .map(result -> new Location(
                result.getLocation().getLat(),
                result.getLocation().getLng(),
                result.getName()
            ))
            .collect(Collectors.toList());
    }
    
    @Override
    public Route calculateRoute(Location from, Location to, TravelMode mode) {
        GoogleLocation googleFrom = new GoogleLocation(from.getLatitude(), from.getLongitude());
        GoogleLocation googleTo = new GoogleLocation(to.getLatitude(), to.getLongitude());
        GoogleTravelMode googleMode = convertTravelMode(mode);
        
        GoogleDirectionsResponse response = googleMapsAPI.getDirections(googleFrom, googleTo, googleMode);
        
        // Convert response to our format
        List<Location> waypoints = Arrays.stream(response.getWaypoints())
            .map(wp -> new Location(wp.getLat(), wp.getLng()))
            .collect(Collectors.toList());
            
        return new Route(waypoints, response.getDistanceKm(), response.getDurationMinutes());
    }
    
    @Override
    public double calculateDistance(Location from, Location to) {
        Route route = calculateRoute(from, to, TravelMode.DRIVING);
        return route.getDistance();
    }
    
    private GoogleTravelMode convertTravelMode(TravelMode mode) {
        switch (mode) {
            case WALKING: return GoogleTravelMode.WALKING;
            case DRIVING: return GoogleTravelMode.DRIVING;
            case TRANSIT: return GoogleTravelMode.TRANSIT;
            case BICYCLING: return GoogleTravelMode.BICYCLING;
            default: return GoogleTravelMode.DRIVING;
        }
    }
}

// Alternative adapter for Apple Maps
public class AppleMapsAdapter implements MapService {
    private AppleMapsSDK appleMapsSDK;
    
    public AppleMapsAdapter() {
        this.appleMapsSDK = new AppleMapsSDK();
    }
    
    @Override
    public Location getCurrentLocation() {
        AppleCoordinate coord = appleMapsSDK.getUserLocation();
        return new Location(coord.latitude, coord.longitude);
    }
    
    @Override
    public List<Location> searchPlaces(String query, Location center, double radiusKm) {
        AppleCoordinate appleCenter = new AppleCoordinate(center.getLatitude(), center.getLongitude());
        AppleSearchRequest request = new AppleSearchRequest(query, appleCenter, radiusKm);
        
        AppleSearchResult[] results = appleMapsSDK.performSearch(request);
        
        return Arrays.stream(results)
            .map(result -> new Location(
                result.coordinate.latitude,
                result.coordinate.longitude,
                result.name
            ))
            .collect(Collectors.toList());
    }
    
    @Override
    public Route calculateRoute(Location from, Location to, TravelMode mode) {
        AppleCoordinate appleFrom = new AppleCoordinate(from.getLatitude(), from.getLongitude());
        AppleCoordinate appleTo = new AppleCoordinate(to.getLatitude(), to.getLongitude());
        
        AppleRoute appleRoute = appleMapsSDK.calculateRoute(appleFrom, appleTo, convertTravelMode(mode));
        
        List<Location> waypoints = Arrays.stream(appleRoute.coordinates)
            .map(coord -> new Location(coord.latitude, coord.longitude))
            .collect(Collectors.toList());
            
        return new Route(waypoints, appleRoute.distanceKm, appleRoute.estimatedTimeMinutes);
    }
    
    @Override
    public double calculateDistance(Location from, Location to) {
        Route route = calculateRoute(from, to, TravelMode.DRIVING);
        return route.getDistance();
    }
    
    private AppleTravelMode convertTravelMode(TravelMode mode) {
        switch (mode) {
            case WALKING: return AppleTravelMode.WALKING;
            case DRIVING: return AppleTravelMode.AUTOMOBILE;
            case TRANSIT: return AppleTravelMode.TRANSIT;
            default: return AppleTravelMode.AUTOMOBILE;
        }
    }
}

// Usage in Uber/Lyft-like application
public class RideShareService {
    private MapService mapService;
    
    public RideShareService(MapService mapService) {
        this.mapService = mapService; // Can be any implementation
    }
    
    public List<Driver> findNearbyDrivers(Location passengerLocation) {
        // Use adapter to search for nearby drivers
        List<Location> nearbyPlaces = mapService.searchPlaces("drivers", passengerLocation, 5.0);
        
        return nearbyPlaces.stream()
            .map(this::convertToDriver)
            .collect(Collectors.toList());
    }
    
    public RideEstimate calculateRideEstimate(Location pickup, Location destination) {
        Route route = mapService.calculateRoute(pickup, destination, TravelMode.DRIVING);
        
        double baseFare = 2.55;
        double perKmRate = 1.75;
        double perMinuteRate = 0.35;
        
        double fare = baseFare + (route.getDistance() * perKmRate) + (route.getDuration() * perMinuteRate);
        
        return new RideEstimate(route.getDistance(), route.getDuration(), fare);
    }
    
    private Driver convertToDriver(Location location) {
        // Convert location to driver (mock implementation)
        return new Driver("driver-" + location.hashCode(), location);
    }
}

// Client code - can switch between different map providers
public class MapsDemo {
    public void demonstrateAdapter() {
        // Can easily switch between different map services
        MapService googleMaps = new GoogleMapsAdapter("your-google-api-key");
        MapService appleMaps = new AppleMapsAdapter();
        
        RideShareService uberWithGoogle = new RideShareService(googleMaps);
        RideShareService uberWithApple = new RideShareService(appleMaps);
        
        Location currentLocation = new Location(37.7749, -122.4194, "San Francisco");
        
        // Same interface, different implementations
        List<Driver> driversFromGoogle = uberWithGoogle.findNearbyDrivers(currentLocation);
        List<Driver> driversFromApple = uberWithApple.findNearbyDrivers(currentLocation);
        
        System.out.println("Drivers found via Google: " + driversFromGoogle.size());
        System.out.println("Drivers found via Apple: " + driversFromApple.size());
    }
}
```

### 3. Behavioral Patterns

#### Observer Pattern - YouTube Notification System

```java
// Subject interface
public interface YouTubeChannel {
    void subscribe(Subscriber subscriber);
    void unsubscribe(Subscriber subscriber);
    void notifySubscribers(Video video);
}

// Observer interface
public interface Subscriber {
    void onNewVideo(String channelName, Video video);
    void onChannelUpdate(String channelName, String updateType);
    String getSubscriberId();
}

// Concrete Subject
public class YouTubeChannelImpl implements YouTubeChannel {
    private String channelName;
    private String channelId;
    private List<Subscriber> subscribers;
    private List<Video> videos;
    private int subscriberCount;
    private boolean isVerified;
    
    public YouTubeChannelImpl(String channelName, String channelId) {
        this.channelName = channelName;
        this.channelId = channelId;
        this.subscribers = new ArrayList<>();
        this.videos = new ArrayList<>();
        this.subscriberCount = 0;
        this.isVerified = false;
    }
    
    @Override
    public void subscribe(Subscriber subscriber) {
        if (!subscribers.contains(subscriber)) {
            subscribers.add(subscriber);
            subscriberCount++;
            System.out.println(subscriber.getSubscriberId() + " subscribed to " + channelName);
            
            // Send welcome notification
            if (!videos.isEmpty()) {
                Video latestVideo = videos.get(videos.size() - 1);
                subscriber.onNewVideo(channelName, latestVideo);
            }
        }
    }
    
    @Override
    public void unsubscribe(Subscriber subscriber) {
        if (subscribers.remove(subscriber)) {
            subscriberCount--;
            System.out.println(subscriber.getSubscriberId() + " unsubscribed from " + channelName);
        }
    }
    
    @Override
    public void notifySubscribers(Video video) {
        System.out.println("Notifying " + subscribers.size() + " subscribers about new video: " + video.getTitle());
        
        // Notify in batches to avoid overwhelming the system
        int batchSize = 1000;
        for (int i = 0; i < subscribers.size(); i += batchSize) {
            List<Subscriber> batch = subscribers.subList(i, Math.min(i + batchSize, subscribers.size()));
            
            // Async notification to avoid blocking
            CompletableFuture.runAsync(() -> {
                for (Subscriber subscriber : batch) {
                    try {
                        subscriber.onNewVideo(channelName, video);
                    } catch (Exception e) {
                        System.err.println("Failed to notify subscriber: " + subscriber.getSubscriberId());
                    }
                }
            });
        }
    }
    
    public void uploadVideo(Video video) {
        videos.add(video);
        System.out.println("New video uploaded: " + video.getTitle());
        notifySubscribers(video);
        
        // Update channel stats
        if (subscriberCount >= 100000 && !isVerified) {
            isVerified = true;
            notifyChannelUpdate("VERIFICATION");
        }
    }
    
    public void updateChannelInfo(String newChannelName) {
        this.channelName = newChannelName;
        notifyChannelUpdate("NAME_CHANGE");
    }
    
    private void notifyChannelUpdate(String updateType) {
        for (Subscriber subscriber : subscribers) {
            subscriber.onChannelUpdate(channelName, updateType);
        }
    }
    
    // Getters
    public String getChannelName() { return channelName; }
    public int getSubscriberCount() { return subscriberCount; }
    public List<Video> getVideos() { return new ArrayList<>(videos); }
}

// Concrete Observer - Regular User
public class RegularUser implements Subscriber {
    private String userId;
    private String userName;
    private List<String> interests;
    private NotificationPreferences preferences;
    
    public RegularUser(String userId, String userName) {
        this.userId = userId;
        this.userName = userName;
        this.interests = new ArrayList<>();
        this.preferences = new NotificationPreferences();
    }
    
    @Override
    public void onNewVideo(String channelName, Video video) {
        if (!preferences.isNotificationsEnabled()) {
            return;
        }
        
        // Check if user is interested in this type of content
        boolean isInterested = interests.isEmpty() || 
            interests.stream().anyMatch(interest -> video.getTags().contains(interest));
        
        if (isInterested) {
            System.out.println("📱 " + userName + ": New video from " + channelName + " - " + video.getTitle());
            
            // Add to watch later if user preference is set
            if (preferences.isAutoAddToWatchLater()) {
                addToWatchLater(video);
            }
        }
    }
    
    @Override
    public void onChannelUpdate(String channelName, String updateType) {
        if (preferences.isChannelUpdatesEnabled()) {
            switch (updateType) {
                case "VERIFICATION":
                    System.out.println("🎉 " + userName + ": " + channelName + " is now verified!");
                    break;
                case "NAME_CHANGE":
                    System.out.println("📝 " + userName + ": " + channelName + " updated their channel name");
                    break;
            }
        }
    }
    
    @Override
    public String getSubscriberId() {
        return userId;
    }
    
    public void addInterest(String interest) {
        interests.add(interest);
    }
    
    public void updateNotificationPreferences(NotificationPreferences preferences) {
        this.preferences = preferences;
    }
    
    private void addToWatchLater(Video video) {
        System.out.println("➕ Added '" + video.getTitle() + "' to " + userName + "'s Watch Later");
    }
}

// Another Concrete Observer - Content Creator
public class ContentCreator implements Subscriber {
    private String creatorId;
    private String channelName;
    private List<String> competitorChannels;
    private AnalyticsService analytics;
    
    public ContentCreator(String creatorId, String channelName) {
        this.creatorId = creatorId;
        this.channelName = channelName;
        this.competitorChannels = new ArrayList<>();
        this.analytics = new AnalyticsService();
    }
    
    @Override
    public void onNewVideo(String channelName, Video video) {
        if (competitorChannels.contains(channelName)) {
            // Analyze competitor content
            System.out.println("🔍 " + this.channelName + " analyzing competitor video: " + video.getTitle());
            
            ContentAnalysis analysis = analytics.analyzeCompetitorContent(video);
            if (analysis.isPerformingWell()) {
                System.out.println("💡 Trending topic detected: " + String.join(", ", video.getTags()));
                considerCreatingSimilarContent(video);
            }
        } else {
            // Regular subscription notification
            System.out.println("📺 " + this.channelName + " creator: New video from " + channelName);
        }
    }
    
    @Override
    public void onChannelUpdate(String channelName, String updateType) {
        if ("VERIFICATION".equals(updateType) && competitorChannels.contains(channelName)) {
            System.out.println("⚠️ Competitor " + channelName + " got verified - time to step up!");
        }
    }
    
    @Override
    public String getSubscriberId() {
        return creatorId;
    }
    
    public void addCompetitor(String competitorChannel) {
        competitorChannels.add(competitorChannel);
    }
    
    private void considerCreatingSimilarContent(Video video) {
        System.out.println("📝 " + channelName + " adding to content calendar: " + video.getTitle() + " inspired content");
    }
}

// Another Observer - Brand/Marketing Agency
public class BrandAccount implements Subscriber {
    private String brandId;
    private String brandName;
    private List<String> targetKeywords;
    private double sponsorshipBudget;
    
    public BrandAccount(String brandId, String brandName, double sponsorshipBudget) {
        this.brandId = brandId;
        this.brandName = brandName;
        this.sponsorshipBudget = sponsorshipBudget;
        this.targetKeywords = new ArrayList<>();
    }
    
    @Override
    public void onNewVideo(String channelName, Video video) {
        // Check for sponsorship opportunities
        boolean isRelevant = targetKeywords.stream()
            .anyMatch(keyword -> video.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
                               video.getTags().contains(keyword));
        
        if (isRelevant && video.getViewCount() > 100000) {
            System.out.println("💼 " + brandName + ": Potential sponsorship opportunity with " + channelName);
            System.out.println("    Video: " + video.getTitle() + " (" + video.getViewCount() + " views)");
            
            if (shouldReachOut(video)) {
                initiateSponsorship(channelName, video);
            }
        }
    }
    
    @Override
    public void onChannelUpdate(String channelName, String updateType) {
        if ("VERIFICATION".equals(updateType)) {
            System.out.println("⭐ " + brandName + ": " + channelName + " verification increases sponsorship value");
        }
    }
    
    @Override
    public String getSubscriberId() {
        return brandId;
    }
    
    public void addTargetKeyword(String keyword) {
        targetKeywords.add(keyword);
    }
    
    private boolean shouldReachOut(Video video) {
        double estimatedCost = video.getViewCount() * 0.001; // $1 per 1000 views
        return estimatedCost <= sponsorshipBudget;
    }
    
    private void initiateSponsorship(String channelName, Video video) {
        System.out.println("📧 " + brandName + " reaching out to " + channelName + " for sponsorship");
    }
}

// Supporting classes
public class Video {
    private String videoId;
    private String title;
    private String description;
    private List<String> tags;
    private int viewCount;
    private int likeCount;
    private Date uploadDate;
    private int durationSeconds;
    
    public Video(String videoId, String title, String description) {
        this.videoId = videoId;
        this.title = title;
        this.description = description;
        this.tags = new ArrayList<>();
        this.viewCount = 0;
        this.likeCount = 0;
        this.uploadDate = new Date();
    }
    
    public void addTag(String tag) { tags.add(tag); }
    public void incrementViews() { viewCount++; }
    
    // Getters
    public String getVideoId() { return videoId; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public List<String> getTags() { return new ArrayList<>(tags); }
    public int getViewCount() { return viewCount; }
    public int getLikeCount() { return likeCount; }
    public Date getUploadDate() { return uploadDate; }
}

public class NotificationPreferences {
    private boolean notificationsEnabled = true;
    private boolean channelUpdatesEnabled = true;
    private boolean autoAddToWatchLater = false;
    
    // Getters and setters
    public boolean isNotificationsEnabled() { return notificationsEnabled; }
    public void setNotificationsEnabled(boolean enabled) { this.notificationsEnabled = enabled; }
    
    public boolean isChannelUpdatesEnabled() { return channelUpdatesEnabled; }
    public void setChannelUpdatesEnabled(boolean enabled) { this.channelUpdatesEnabled = enabled; }
    
    public boolean isAutoAddToWatchLater() { return autoAddToWatchLater; }
    public void setAutoAddToWatchLater(boolean enabled) { this.autoAddToWatchLater = enabled; }
}

// Mock services
class AnalyticsService {
    public ContentAnalysis analyzeCompetitorContent(Video video) {
        // Simulate content analysis
        boolean isPerformingWell = video.getViewCount() > 50000;
        return new ContentAnalysis(isPerformingWell);
    }
}

class ContentAnalysis {
    private boolean performingWell;
    
    public ContentAnalysis(boolean performingWell) {
        this.performingWell = performingWell;
    }
    
    public boolean isPerformingWell() { return performingWell; }
}

// Usage demonstration
public class YouTubeNotificationDemo {
    public void demonstrateObserverPattern() {
        // Create YouTube channel
        YouTubeChannelImpl techChannel = new YouTubeChannelImpl("TechReviews Pro", "tech-channel-123");
        
        // Create different types of subscribers
        RegularUser alice = new RegularUser("user-001", "Alice");
        alice.addInterest("technology");
        alice.addInterest("reviews");
        
        RegularUser bob = new RegularUser("user-002", "Bob");
        NotificationPreferences bobPrefs = new NotificationPreferences();
        bobPrefs.setAutoAddToWatchLater(true);
        bob.updateNotificationPreferences(bobPrefs);
        
        ContentCreator competitor = new ContentCreator("creator-001", "Tech Insights");
        competitor.addCompetitor("TechReviews Pro");
        
        BrandAccount techBrand = new BrandAccount("brand-001", "TechCorp", 5000.0);
        techBrand.addTargetKeyword("smartphone");
        techBrand.addTargetKeyword("laptop");
        
        // Subscribe all users
        techChannel.subscribe(alice);
        techChannel.subscribe(bob);
        techChannel.subscribe(competitor);
        techChannel.subscribe(techBrand);
        
        System.out.println("=== Initial Subscriptions Complete ===\n");
        
        // Upload new video - all subscribers get notified
        Video newVideo = new Video("vid-001", "iPhone 15 Pro Max Review", "Complete review of the latest iPhone");
        newVideo.addTag("smartphone");
        newVideo.addTag("apple");
        newVideo.addTag("review");
        // Simulate some views for brand interest
        for (int i = 0; i < 150000; i++) newVideo.incrementViews();
        
        techChannel.uploadVideo(newVideo);
        
        System.out.println("\n=== Video Upload Notifications Complete ===\n");
        
        // Channel gets verified - another type of notification
        techChannel.updateChannelInfo("TechReviews Pro ✓");
        
        System.out.println("\n=== Channel Update Notifications Complete ===\n");
        
        // User unsubscribes
        techChannel.unsubscribe(bob);
        
        // Upload another video - Bob won't get notified
        Video anotherVideo = new Video("vid-002", "Best Gaming Laptops 2024", "Top gaming laptops review");
        anotherVideo.addTag("laptop");
        anotherVideo.addTag("gaming");
        techChannel.uploadVideo(anotherVideo);
    }
}
```

#### Strategy Pattern - Netflix Content Recommendation

```java
// Strategy interface
public interface RecommendationStrategy {
    List<Content> recommend(User user, int maxResults);
    String getStrategyName();
    double getConfidenceScore(User user);
}

// Concrete Strategy 1: Collaborative Filtering
public class CollaborativeFilteringStrategy implements RecommendationStrategy {
    private UserSimilarityService similarityService;
    private ContentService contentService;
    
    public CollaborativeFilteringStrategy() {
        this.similarityService = new UserSimilarityService();
        this.contentService = new ContentService();
    }
    
    @Override
    public List<Content> recommend(User user, int maxResults) {
        System.out.println("Using Collaborative Filtering for user: " + user.getName());
        
        // Find similar users
        List<User> similarUsers = similarityService.findSimilarUsers(user, 100);
        
        // Get content liked by similar users that current user hasn't watched
        Map<String, Integer> contentScores = new HashMap<>();
        Set<String> watchedContent = user.getWatchedContentIds();
        
        for (User similarUser : similarUsers) {
            double similarity = similarityService.calculateSimilarity(user, similarUser);
            
            for (Rating rating : similarUser.getRatings()) {
                if (!watchedContent.contains(rating.getContentId()) && rating.getScore() >= 4.0) {
                    int score = (int) (rating.getScore() * similarity * 100);
                    contentScores.merge(rating.getContentId(), score, Integer::sum);
                }
            }
        }
        
        // Sort by score and return top results
        return contentScores.entrySet().stream()
            .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
            .limit(maxResults)
            .map(entry -> contentService.getContent(entry.getKey()))
            .filter(Objects::nonNull)
            .collect(Collectors.toList());
    }
    
    @Override
    public String getStrategyName() {
        return "Collaborative Filtering";
    }
    
    @Override
    public double getConfidenceScore(User user) {
        // Higher confidence for users with many ratings
        int ratingCount = user.getRatings().size();
        return Math.min(1.0, ratingCount / 50.0); // Max confidence at 50+ ratings
    }
}

// Concrete Strategy 2: Content-Based Filtering
public class ContentBasedStrategy implements RecommendationStrategy {
    private ContentAnalysisService analysisService;
    private ContentService contentService;
    
    public ContentBasedStrategy() {
        this.analysisService = new ContentAnalysisService();
        this.contentService = new ContentService();
    }
    
    @Override
    public List<Content> recommend(User user, int maxResults) {
        System.out.println("Using Content-Based Filtering for user: " + user.getName());
        
        // Analyze user's viewing history to build preference profile
        UserPreferenceProfile profile = analysisService.buildUserProfile(user);
        
        // Find content matching user preferences
        List<Content> candidateContent = contentService.getAllContent().stream()
            .filter(content -> !user.getWatchedContentIds().contains(content.getId()))
            .collect(Collectors.toList());
        
        // Score content based on similarity to user profile
        return candidateContent.stream()
            .map(content -> new ContentScore(content, calculateContentScore(content, profile)))
            .sorted(Comparator.comparingDouble(ContentScore::getScore).reversed())
            .limit(maxResults)
            .map(ContentScore::getContent)
            .collect(Collectors.toList());
    }
    
    private double calculateContentScore(Content content, UserPreferenceProfile profile) {
        double score = 0.0;
        
        // Genre preference
        double genreScore = profile.getGenrePreference(content.getGenre());
        score += genreScore * 0.4;
        
        // Actor preference
        for (String actor : content.getActors()) {
            score += profile.getActorPreference(actor) * 0.2;
        }
        
        // Director preference
        score += profile.getDirectorPreference(content.getDirector()) * 0.1;
        
        // Release year preference
        score += profile.getYearPreference(content.getReleaseYear()) * 0.1;
        
        // Rating preference
        score += profile.getRatingPreference(content.getAverageRating()) * 0.2;
        
        return score;
    }
    
    @Override
    public String getStrategyName() {
        return "Content-Based Filtering";
    }
    
    @Override
    public double getConfidenceScore(User user) {
        // Higher confidence for users who have watched diverse content
        Set<String> uniqueGenres = user.getWatchHistory().stream()
            .map(Content::getGenre)
            .collect(Collectors.toSet());
        
        return Math.min(1.0, uniqueGenres.size() / 10.0); // Max confidence at 10+ genres
    }
}

// Concrete Strategy 3: Trending/Popular Content
public class TrendingStrategy implements RecommendationStrategy {
    private TrendingService trendingService;
    private ContentService contentService;
    
    public TrendingStrategy() {
        this.trendingService = new TrendingService();
        this.contentService = new ContentService();
    }
    
    @Override
    public List<Content> recommend(User user, int maxResults) {
        System.out.println("Using Trending Strategy for user: " + user.getName());
        
        // Get trending content filtered by user's age rating and language preferences
        List<String> trendingIds = trendingService.getTrendingContent(
            user.getAgeRating(),
            user.getPreferredLanguages(),
            maxResults * 2 // Get more to filter out watched content
        );
        
        Set<String> watchedContent = user.getWatchedContentIds();
        
        return trendingIds.stream()
            .filter(id -> !watchedContent.contains(id))
            .limit(maxResults)
            .map(contentService::getContent)
            .filter(Objects::nonNull)
            .collect(Collectors.toList());
    }
    
    @Override
    public String getStrategyName() {
        return "Trending Content";
    }
    
    @Override
    public double getConfidenceScore(User user) {
        // Lower confidence - trending is generic, not personalized
        return 0.3;
    }
}

// Concrete Strategy 4: Hybrid Strategy
public class HybridRecommendationStrategy implements RecommendationStrategy {
    private List<RecommendationStrategy> strategies;
    private WeightCalculator weightCalculator;
    
    public HybridRecommendationStrategy() {
        this.strategies = Arrays.asList(
            new CollaborativeFilteringStrategy(),
            new ContentBasedStrategy(),
            new TrendingStrategy()
        );
        this.weightCalculator = new WeightCalculator();
    }
    
    @Override
    public List<Content> recommend(User user, int maxResults) {
        System.out.println("Using Hybrid Strategy for user: " + user.getName());
        
        // Calculate weights for each strategy based on user characteristics
        Map<RecommendationStrategy, Double> weights = weightCalculator.calculateWeights(user, strategies);
        
        // Get recommendations from each strategy
        Map<Content, Double> contentScores = new HashMap<>();
        
        for (RecommendationStrategy strategy : strategies) {
            List<Content> recommendations = strategy.recommend(user, maxResults);
            double weight = weights.get(strategy);
            
            // Weight the recommendations
            for (int i = 0; i < recommendations.size(); i++) {
                Content content = recommendations.get(i);
                double score = (maxResults - i) * weight; // Higher position = higher score
                contentScores.merge(content, score, Double::sum);
            }
        }
        
        // Return top scored content
        return contentScores.entrySet().stream()
            .sorted(Map.Entry.<Content, Double>comparingByValue().reversed())
            .limit(maxResults)
            .map(Map.Entry::getKey)
            .collect(Collectors.toList());
    }
    
    @Override
    public String getStrategyName() {
        return "Hybrid (Collaborative + Content-Based + Trending)";
    }
    
    @Override
    public double getConfidenceScore(User user) {
        // Average confidence of all strategies
        return strategies.stream()
            .mapToDouble(strategy -> strategy.getConfidenceScore(user))
            .average()
            .orElse(0.5);
    }
}

// Context class - Netflix Recommendation Engine
public class NetflixRecommendationEngine {
    private RecommendationStrategy strategy;
    private StrategySelector strategySelector;
    
    public NetflixRecommendationEngine() {
        this.strategySelector = new StrategySelector();
        // Default strategy
        this.strategy = new HybridRecommendationStrategy();
    }
    
    public void setRecommendationStrategy(RecommendationStrategy strategy) {
        this.strategy = strategy;
        System.out.println("Switched to strategy: " + strategy.getStrategyName());
    }
    
    public List<Content> getPersonalizedRecommendations(User user, int maxResults) {
        // Automatically select best strategy for this user
        RecommendationStrategy bestStrategy = strategySelector.selectBestStrategy(user);
        setRecommendationStrategy(bestStrategy);
        
        long startTime = System.currentTimeMillis();
        List<Content> recommendations = strategy.recommend(user, maxResults);
        long endTime = System.currentTimeMillis();
        
        System.out.println("Generated " + recommendations.size() + 
                          " recommendations in " + (endTime - startTime) + "ms");
        System.out.println("Strategy confidence: " + 
                          String.format("%.2f", strategy.getConfidenceScore(user)));
        
        return recommendations;
    }
    
    public RecommendationInsights getRecommendationInsights(User user) {
        return new RecommendationInsights(
            strategy.getStrategyName(),
            strategy.getConfidenceScore(user),
            user.getRatings().size(),
            user.getWatchHistory().size()
        );
    }
}

// Strategy selector to automatically choose best strategy
public class StrategySelector {
    private Map<String, RecommendationStrategy> availableStrategies;
    
    public StrategySelector() {
        availableStrategies = new HashMap<>();
        availableStrategies.put("collaborative", new CollaborativeFilteringStrategy());
        availableStrategies.put("content_based", new ContentBasedStrategy());
        availableStrategies.put("trending", new TrendingStrategy());
        availableStrategies.put("hybrid", new HybridRecommendationStrategy());
    }
    
    public RecommendationStrategy selectBestStrategy(User user) {
        int watchHistorySize = user.getWatchHistory().size();
        int ratingCount = user.getRatings().size();
        
        // New users - use trending content
        if (watchHistorySize < 5) {
            return availableStrategies.get("trending");
        }
        
        // Users with some history but few ratings - use content-based
        if (watchHistorySize >= 5 && ratingCount < 10) {
            return availableStrategies.get("content_based");
        }
        
        // Users with many ratings - use collaborative filtering
        if (ratingCount >= 20) {
            return availableStrategies.get("collaborative");
        }
        
        // Default to hybrid for balanced users
        return availableStrategies.get("hybrid");
    }
}

// Supporting classes
class ContentScore {
    private Content content;
    private double score;
    
    public ContentScore(Content content, double score) {
        this.content = content;
        this.score = score;
    }
    
    public Content getContent() { return content; }
    public double getScore() { return score; }
}

class UserPreferenceProfile {
    private Map<String, Double> genrePreferences;
    private Map<String, Double> actorPreferences;
    private Map<String, Double> directorPreferences;
    private Map<Integer, Double> yearPreferences;
    private Map<Double, Double> ratingPreferences;
    
    public UserPreferenceProfile() {
        this.genrePreferences = new HashMap<>();
        this.actorPreferences = new HashMap<>();
        this.directorPreferences = new HashMap<>();
        this.yearPreferences = new HashMap<>();
        this.ratingPreferences = new HashMap<>();
    }
    
    // Getters with default values
    public double getGenrePreference(String genre) {
        return genrePreferences.getOrDefault(genre, 0.0);
    }
    
    public double getActorPreference(String actor) {
        return actorPreferences.getOrDefault(actor, 0.0);
    }
    
    public double getDirectorPreference(String director) {
        return directorPreferences.getOrDefault(director, 0.0);
    }
    
    public double getYearPreference(int year) {
        return yearPreferences.getOrDefault(year, 0.0);
    }
    
    public double getRatingPreference(double rating) {
        return ratingPreferences.getOrDefault(rating, 0.0);
    }
    
    // Setters
    public void setGenrePreference(String genre, double preference) {
        genrePreferences.put(genre, preference);
    }
    
    public void setActorPreference(String actor, double preference) {
        actorPreferences.put(actor, preference);
    }
    
    public void setDirectorPreference(String director, double preference) {
        directorPreferences.put(director, preference);
    }
}

class RecommendationInsights {
    private String strategyUsed;
    private double confidence;
    private int userRatingCount;
    private int watchHistorySize;
    
    public RecommendationInsights(String strategyUsed, double confidence, 
                                 int userRatingCount, int watchHistorySize) {
        this.strategyUsed = strategyUsed;
        this.confidence = confidence;
        this.userRatingCount = userRatingCount;
        this.watchHistorySize = watchHistorySize;
    }
    
    // Getters
    public String getStrategyUsed() { return strategyUsed; }
    public double getConfidence() { return confidence; }
    public int getUserRatingCount() { return userRatingCount; }
    public int getWatchHistorySize() { return watchHistorySize; }
}

class WeightCalculator {
    public Map<RecommendationStrategy, Double> calculateWeights(User user, 
                                                               List<RecommendationStrategy> strategies) {
        Map<RecommendationStrategy, Double> weights = new HashMap<>();
        double totalConfidence = 0.0;
        
        // Calculate individual confidences
        for (RecommendationStrategy strategy : strategies) {
            double confidence = strategy.getConfidenceScore(user);
            weights.put(strategy, confidence);
            totalConfidence += confidence;
        }
        
        // Normalize weights
        if (totalConfidence > 0) {
            weights.replaceAll((strategy, weight) -> weight / totalConfidence);
        } else {
            // Equal weights if no confidence scores
            double equalWeight = 1.0 / strategies.size();
            weights.replaceAll((strategy, weight) -> equalWeight);
        }
        
        return weights;
    }
}

// Usage demonstration
public class NetflixRecommendationDemo {
    public void demonstrateStrategyPattern() {
        NetflixRecommendationEngine engine = new NetflixRecommendationEngine();
        
        // Create different types of users
        User newUser = createNewUser();
        User regularUser = createRegularUser();
        User powerUser = createPowerUser();
        
        System.out.println("=== Recommendations for Different User Types ===\n");
        
        // New user gets trending content
        demonstrateUserRecommendations(engine, newUser);
        System.out.println();
        
        // Regular user gets content-based recommendations
        demonstrateUserRecommendations(engine, regularUser);
        System.out.println();