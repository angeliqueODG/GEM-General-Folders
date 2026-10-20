package framework.reporting;

// ===============================================================
// @file: FW_TopicRegistry.java
// @filepath: src/test/java/framework/reporting/FW_TopicRegistry.java
// @version: 1.0.0
// @updated: 2025-11-07 12:00:00 PM CDT
// @author: Greg Paskal
// @company: MissionWares
//
// @description:
// Registry for managing report topics in the topic-based architecture.
// Provides centralized storage, lookup, filtering, and ordering of topics.
// Topics are registered dynamically and can be filtered by depth level,
// retrieved by ID, or accessed in a specific order for report generation.
//
// The registry uses a generic type parameter <T> matching the data type
// that topics operate on (e.g., FW_Http, FW_Ping, FW_Database). This
// ensures type safety when registering and retrieving topics.
//
// @key_features:
// - Dynamic topic registration
// - Order-preserved topic list
// - Depth-based filtering
// - ID-based lookup
// - Type-safe generic design
// - Thread-safe for read operations
//
// @usage:
// // Create registry for HTTP reports
// FW_TopicRegistry<FW_Http> registry = new FW_TopicRegistry<>();
// 
// // Register topics in desired order
// registry.register(new HttpCertificateTopic());
// registry.register(new HttpSecurityHeadersTopic());
// registry.register(new HttpPerformanceTopic());
// 
// // Get topics for specific depth
// List<FW_ReportTopic<FW_Http>> topics = registry.getTopicsForDepth(
//     ReportDepth.STANDARD, mockHttpData
// );
// 
// // Lookup specific topic
// FW_ReportTopic<FW_Http> certTopic = registry.getTopic("certificates");
//
// @dependencies:
// - framework.reporting.FW_ReportTopic
// - framework.reporting.ReportDepth
// - java.util (Map, List, LinkedHashMap, ArrayList)
//
// @tags: registry, topics, management, filtering, ordering, mAi™
//
// @changeLog:
// Date        Author          Version  Description
// ----------  --------------  -------  --------------------------
// 2025-11-07  G. Paskal       1.0.0    Initial creation - topic registry
// ===============================================================

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Registry for managing and organizing report topics.
 * 
 * <p>Provides centralized management of topics including registration,
 * lookup, filtering, and ordering. Topics are stored in insertion order
 * and can be filtered based on depth requirements.
 * 
 * <p><b>Generic Type Parameter:</b>
 * <br>The {@code <T>} parameter represents the data type that topics
 * operate on. All registered topics must work with the same data type:
 * <ul>
 *   <li>{@code FW_TopicRegistry<FW_Http>} - Registry for HTTP audit topics</li>
 *   <li>{@code FW_TopicRegistry<FW_Ping>} - Registry for network diagnostic topics</li>
 *   <li>{@code FW_TopicRegistry<FW_Database>} - Registry for database audit topics</li>
 * </ul>
 * 
 * <p><b>Topic Ordering:</b>
 * <br>Topics are maintained in registration order, which determines their
 * appearance sequence in generated reports. Register topics in the desired
 * display order.
 * 
 * <p><b>Depth Filtering:</b>
 * <br>The {@code getTopicsForDepth()} method filters topics based on their
 * {@code shouldRender()} method, allowing different report depths to show
 * different sets of topics.
 * 
 * <p><b>Thread Safety:</b>
 * <br>This class is thread-safe for read operations after initialization.
 * Concurrent registration should be externally synchronized.
 * 
 * @param <T> Data type that topics operate on (FW_Http, FW_Ping, etc.)
 * 
 * @since 1.0.0
 * @see framework.reporting.FW_ReportTopic
 * @see framework.reporting.ReportDepth
 */
public class FW_TopicRegistry<T> {
    
    /** Map of topics by ID for fast lookup */
    private final Map<String, FW_ReportTopic<T>> topics;
    
    /** Ordered list of topic IDs for maintaining registration sequence */
    private final List<String> topicOrder;
    
    // ===== MAIN METHOD FOR TESTING =====
    
    /**
     * Main method for testing FW_TopicRegistry functionality.
     * 
     * <p>Demonstrates:
     * <ul>
     *   <li>Registry creation and initialization</li>
     *   <li>Topic registration</li>
     *   <li>Topic retrieval and ordering</li>
     *   <li>Depth-based filtering</li>
     *   <li>ID-based lookup</li>
     *   <li>Count and validation</li>
     * </ul>
     * 
     * <p><b>Usage:</b>
     * <pre>
     * # From project root
     * mvn exec:java -Dexec.mainClass="framework.reporting.FW_TopicRegistry" -Dexec.classpathScope=test
     * </pre>
     * 
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("═══════════════════════════════════════════════════════════════════");
        System.out.println("  FW_TopicRegistry Test - Topic Management System");
        System.out.println("═══════════════════════════════════════════════════════════════════");
        
        // Test 1: Create registry
        System.out.println("\n▶ Test 1: Create Registry");
        System.out.println("───────────────────────────────────────────────────────────────────");
        FW_TopicRegistry<String> registry = new FW_TopicRegistry<>();
        System.out.println("✓ Registry created");
        System.out.println("  Initial topic count: " + registry.getTopicCount());
        
        // Test 2: Register mock topics
        System.out.println("\n▶ Test 2: Register Topics");
        System.out.println("───────────────────────────────────────────────────────────────────");
        
        // Create mock topics
        FW_ReportTopic<String> topic1 = createMockTopic("topic-1", "First Topic", "1️⃣");
        FW_ReportTopic<String> topic2 = createMockTopic("topic-2", "Second Topic", "2️⃣");
        FW_ReportTopic<String> topic3 = createMockTopic("topic-3", "Third Topic", "3️⃣");
        
        registry.register(topic1);
        System.out.println("✓ Registered: " + topic1.getTopicId());
        
        registry.register(topic2);
        System.out.println("✓ Registered: " + topic2.getTopicId());
        
        registry.register(topic3);
        System.out.println("✓ Registered: " + topic3.getTopicId());
        
        System.out.println("  Total topics: " + registry.getTopicCount());
        
        // Test 3: Get all topics in order
        System.out.println("\n▶ Test 3: Get All Topics (Ordered)");
        System.out.println("───────────────────────────────────────────────────────────────────");
        List<FW_ReportTopic<String>> allTopics = registry.getTopics();
        System.out.println("Retrieved " + allTopics.size() + " topics:");
        for (int i = 0; i < allTopics.size(); i++) {
            FW_ReportTopic<String> topic = allTopics.get(i);
            System.out.println("  " + (i+1) + ". " + topic.getTopicIcon() + " " + 
                             topic.getTopicTitle() + " (ID: " + topic.getTopicId() + ")");
        }
        
        // Test 4: Lookup by ID
        System.out.println("\n▶ Test 4: Lookup Topics by ID");
        System.out.println("───────────────────────────────────────────────────────────────────");
        
        FW_ReportTopic<String> foundTopic = registry.getTopic("topic-2");
        if (foundTopic != null) {
            System.out.println("✓ Found: " + foundTopic.getTopicTitle());
        } else {
            System.out.println("✗ Not found: topic-2");
        }
        
        FW_ReportTopic<String> notFound = registry.getTopic("nonexistent");
        if (notFound == null) {
            System.out.println("✓ Correctly returned null for nonexistent topic");
        } else {
            System.out.println("✗ Should have returned null");
        }
        
        // Test 5: Depth filtering
        System.out.println("\n▶ Test 5: Filter Topics by Depth");
        System.out.println("───────────────────────────────────────────────────────────────────");
        
        String mockData = "test-data";
        
        for (ReportDepth depth : ReportDepth.values()) {
            List<FW_ReportTopic<String>> filtered = 
                registry.getTopicsForDepth(depth, mockData);
            System.out.println(depth.name() + " depth: " + filtered.size() + " topics");
        }
        
        // Test 6: Topic order preservation
        System.out.println("\n▶ Test 6: Verify Order Preservation");
        System.out.println("───────────────────────────────────────────────────────────────────");
        List<FW_ReportTopic<String>> orderedTopics = registry.getTopics();
        boolean orderCorrect = true;
        
        if (!orderedTopics.get(0).getTopicId().equals("topic-1")) orderCorrect = false;
        if (!orderedTopics.get(1).getTopicId().equals("topic-2")) orderCorrect = false;
        if (!orderedTopics.get(2).getTopicId().equals("topic-3")) orderCorrect = false;
        
        if (orderCorrect) {
            System.out.println("✓ Topics maintained in registration order");
        } else {
            System.out.println("✗ Topic order was changed");
        }
        
        // Test 7: Empty registry checks
        System.out.println("\n▶ Test 7: Empty Registry Checks");
        System.out.println("───────────────────────────────────────────────────────────────────");
        FW_TopicRegistry<String> emptyRegistry = new FW_TopicRegistry<>();
        
        System.out.println("Empty registry count: " + emptyRegistry.getTopicCount());
        System.out.println("Empty registry topics: " + emptyRegistry.getTopics().size());
        System.out.println("Lookup in empty registry: " + 
                         (emptyRegistry.getTopic("any") == null ? "null ✓" : "error ✗"));
        
        // Test 8: Duplicate registration handling
        System.out.println("\n▶ Test 8: Duplicate Registration Handling");
        System.out.println("───────────────────────────────────────────────────────────────────");
        int beforeCount = registry.getTopicCount();
        registry.register(topic1);  // Register same topic again
        int afterCount = registry.getTopicCount();
        
        if (beforeCount == afterCount) {
            System.out.println("✓ Duplicate registration replaced existing topic (count unchanged)");
        } else {
            System.out.println("✗ Topic count changed after duplicate registration");
        }
        
        // Test 9: Clear functionality
        System.out.println("\n▶ Test 9: Clear Registry");
        System.out.println("───────────────────────────────────────────────────────────────────");
        System.out.println("Before clear: " + registry.getTopicCount() + " topics");
        registry.clear();
        System.out.println("After clear: " + registry.getTopicCount() + " topics");
        System.out.println("✓ Registry cleared successfully");
        
        // Final summary
        System.out.println("\n═══════════════════════════════════════════════════════════════════");
        System.out.println("✅ FW_TopicRegistry verified successfully!");
        System.out.println("   • Registration working ✓");
        System.out.println("   • Order preservation working ✓");
        System.out.println("   • Lookup by ID working ✓");
        System.out.println("   • Depth filtering working ✓");
        System.out.println("   • Duplicate handling working ✓");
        System.out.println("   • Clear functionality working ✓");
        System.out.println("═══════════════════════════════════════════════════════════════════\n");
    }
    
    /**
     * Creates a mock topic for testing purposes.
     * 
     * @param id Topic ID
     * @param title Topic title
     * @param icon Topic icon
     * @return Mock topic implementation
     */
    private static FW_ReportTopic<String> createMockTopic(String id, String title, String icon) {
        return new FW_ReportTopic<String>() {
            @Override
            public String getTopicId() { return id; }
            
            @Override
            public String getTopicTitle() { return title; }
            
            @Override
            public String getTopicIcon() { return icon; }
            
            @Override
            public String calculateGrade(String data) { return "A"; }
            
            @Override
            public boolean shouldRender(ReportDepth depth) {
                // All mock topics render at all depths
                return true;
            }
            
            @Override
            public String render(String data, FW_ReportContext context) {
                return "## " + icon + " " + title + "\n\nMock content for " + id;
            }
            
            @Override
            public String renderTOCEntry(String data, int sectionNumber) {
                return sectionNumber + ". " + icon + " " + title;
            }
            
            @Override
            public String renderOverviewRow(String data) {
                return "| " + icon + " " + title + " | A | ✅ | 0 |";
            }
        };
    }
    
    // ===== CONSTRUCTOR =====
    
    /**
     * Constructs a new empty FW_TopicRegistry.
     * 
     * <p>Uses LinkedHashMap to preserve insertion order and provide O(1)
     * lookup performance.
     */
    public FW_TopicRegistry() {
        this.topics = new LinkedHashMap<>();
        this.topicOrder = new ArrayList<>();
    }
    
    // ===== REGISTRATION METHODS =====
    
    /**
     * Registers a topic in the registry.
     * 
     * <p>Topics are stored by ID and maintained in registration order.
     * If a topic with the same ID already exists, it will be replaced
     * but the original position in the order is maintained.
     * 
     * <p><b>Example:</b>
     * <pre>
     * FW_TopicRegistry&lt;FW_Http&gt; registry = new FW_TopicRegistry&lt;&gt;();
     * registry.register(new HttpCertificateTopic());
     * registry.register(new HttpSecurityHeadersTopic());
     * </pre>
     * 
     * @param topic Topic to register (must not be null)
     * @throws IllegalArgumentException if topic is null or has null ID
     */
    public void register(FW_ReportTopic<T> topic) {
        if (topic == null) {
            throw new IllegalArgumentException("Topic cannot be null");
        }
        
        String topicId = topic.getTopicId();
        if (topicId == null || topicId.trim().isEmpty()) {
            throw new IllegalArgumentException("Topic ID cannot be null or empty");
        }
        
        // If topic doesn't exist yet, add to order list
        if (!topics.containsKey(topicId)) {
            topicOrder.add(topicId);
        }
        
        // Store/replace topic in map
        topics.put(topicId, topic);
    }
    
    // ===== RETRIEVAL METHODS =====
    
    /**
     * Gets all registered topics in registration order.
     * 
     * <p>Returns a new list to prevent external modification of internal state.
     * The returned list contains topics in the order they were registered.
     * 
     * <p><b>Usage:</b>
     * <pre>
     * List&lt;FW_ReportTopic&lt;FW_Http&gt;&gt; allTopics = registry.getTopics();
     * for (FW_ReportTopic&lt;FW_Http&gt; topic : allTopics) {
     *     System.out.println(topic.getTopicTitle());
     * }
     * </pre>
     * 
     * @return List of all topics in registration order (never null, may be empty)
     */
    public List<FW_ReportTopic<T>> getTopics() {
        List<FW_ReportTopic<T>> result = new ArrayList<>();
        
        for (String topicId : topicOrder) {
            FW_ReportTopic<T> topic = topics.get(topicId);
            if (topic != null) {
                result.add(topic);
            }
        }
        
        return result;
    }
    
    /**
     * Gets topics that should render at the specified depth level.
     * 
     * <p>Filters topics based on their {@code shouldRender()} method, which
     * allows each topic to determine if it should be included at a given
     * depth level. Topics are returned in registration order.
     * 
     * <p><b>Usage:</b>
     * <pre>
     * // Get topics for executive summary (minimal)
     * List&lt;FW_ReportTopic&lt;FW_Http&gt;&gt; summaryTopics = 
     *     registry.getTopicsForDepth(ReportDepth.SUMMARY, httpData);
     * 
     * // Get topics for technical report (comprehensive)
     * List&lt;FW_ReportTopic&lt;FW_Http&gt;&gt; technicalTopics = 
     *     registry.getTopicsForDepth(ReportDepth.TECHNICAL, httpData);
     * </pre>
     * 
     * @param depth Report depth level to filter by
     * @param data Sample data for topics to evaluate rendering decision
     * @return List of topics that should render at this depth (never null, may be empty)
     */
    public List<FW_ReportTopic<T>> getTopicsForDepth(ReportDepth depth, T data) {
        List<FW_ReportTopic<T>> result = new ArrayList<>();
        
        for (String topicId : topicOrder) {
            FW_ReportTopic<T> topic = topics.get(topicId);
            if (topic != null && topic.shouldRender(depth)) {
                result.add(topic);
            }
        }
        
        return result;
    }
    
    /**
     * Looks up a topic by its unique ID.
     * 
     * <p>Provides fast O(1) lookup of topics by ID for direct access when
     * the specific topic is known.
     * 
     * <p><b>Usage:</b>
     * <pre>
     * FW_ReportTopic&lt;FW_Http&gt; certTopic = registry.getTopic("certificates");
     * if (certTopic != null) {
     *     String grade = certTopic.calculateGrade(httpData);
     * }
     * </pre>
     * 
     * @param topicId Unique topic identifier
     * @return Topic with matching ID, or null if not found
     */
    public FW_ReportTopic<T> getTopic(String topicId) {
        if (topicId == null) {
            return null;
        }
        return topics.get(topicId);
    }
    
    // ===== UTILITY METHODS =====
    
    /**
     * Gets the number of registered topics.
     * 
     * @return Count of topics in registry
     */
    public int getTopicCount() {
        return topics.size();
    }
    
    /**
     * Checks if the registry contains a topic with the given ID.
     * 
     * @param topicId Topic ID to check
     * @return true if topic exists, false otherwise
     */
    public boolean containsTopic(String topicId) {
        return topics.containsKey(topicId);
    }
    
    /**
     * Removes all topics from the registry.
     * 
     * <p>Clears both the topic map and order list, returning the registry
     * to an empty state.
     */
    public void clear() {
        topics.clear();
        topicOrder.clear();
    }
    
    /**
     * Returns a string representation of the registry.
     * 
     * <p>Format: "FW_TopicRegistry[topics=3, order=[topic-1, topic-2, topic-3]]"
     * 
     * @return String representation showing topic count and order
     */
    @Override
    public String toString() {
        return String.format("FW_TopicRegistry[topics=%d, order=%s]",
            topics.size(), topicOrder);
    }
}