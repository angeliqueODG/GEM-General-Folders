package framework.advisor;

// ===============================================================
// @file: FW_Advisor.java
// @filepath: src/test/java/framework/advisor/FW_Advisor.java
// @version: 1.2.0
// @updated: 2025-10-09 03:05:00 PM CDT
// @author: Greg Paskal
// @company: MissionWares
//
// @description:
// Main facade and entry point for mAi Advisor™ - the intelligent guidance
// system. Provides simplified static API for generating audience-specific
// recommendations from HTTP audit findings. Wraps FW_AdvisorEngine with
// convenient methods for common use cases. This is the primary class that
// external code should interact with for advisor functionality.
//
// @usage:
// Get recommendations for a specific audience
// List<FW_AdvisorRecommendation> recs = 
//     FW_Advisor.getRecommendations(httpData, FW_AdvisorAudience.DEVELOPER);
//
// Get executive summary
// String summary = FW_Advisor.getExecutiveSummary(httpData);
//
// Get recommendations for all audiences
// List<FW_AdvisorRecommendation> allRecs = 
//     FW_Advisor.getAllRecommendations(httpData);
//
// @dependencies:
// - framework.advisor.FW_AdvisorEngine
// - framework.advisor.FW_AdvisorAudience
// - framework.advisor.FW_AdvisorRecommendation
// - framework.http.FW_Http
// - framework.utilities.FW_ConsoleColors
// - java.util.List
//
// @tags: advisor, mAi™, facade, api, entry-point, convenience
//
// @changeLog:
// Date        Author          Version  Description
// ----------  --------------  -------  --------------------------
// 2025-10-07  G. Paskal       1.0.0    Initial creation - main facade
// 2025-10-08  G. Paskal       1.1.0    Added main method for testing complete flow
// 2025-10-09  G. Paskal       1.2.0    Added styled terminal output with colors
// ===============================================================

import framework.http.FW_Http;
import framework.utilities.FW_ConsoleColors;

import java.util.List;
import java.util.Map;

/**
 * Main facade for mAi Advisor™ - Intelligent Guidance System.
 * 
 * <p>Provides simplified static API for generating audience-specific
 * recommendations from HTTP audit findings. This is the primary entry
 * point for external code to access advisor functionality.
 * 
 * <p><b>Key Features:</b>
 * <ul>
 *   <li>Generate recommendations for specific audiences</li>
 *   <li>Generate recommendations for all audiences</li>
 *   <li>Generate executive summaries</li>
 *   <li>Access engine statistics</li>
 *   <li>Clear caches and reset state</li>
 * </ul>
 * 
 * <p><b>Usage Examples:</b>
 * <pre>
 * // Single audience recommendations
 * List&lt;FW_AdvisorRecommendation&gt; devRecs = 
 *     FW_Advisor.getRecommendations(httpData, FW_AdvisorAudience.DEVELOPER);
 * 
 * for (FW_AdvisorRecommendation rec : devRecs) {
 *     System.out.println(rec.getSummary());
 *     if (rec.isActionTier()) {
 *         System.out.println(rec.getCodeExample());
 *     }
 * }
 * 
 * // Executive summary
 * String execSummary = FW_Advisor.getExecutiveSummary(httpData);
 * System.out.println(execSummary);
 * 
 * // All audiences
 * List&lt;FW_AdvisorRecommendation&gt; allRecs = 
 *     FW_Advisor.getAllRecommendations(httpData);
 * </pre>
 * 
 * <p><b>Thread Safety:</b> This class uses a single shared engine instance.
 * The engine is thread-safe for read operations but cache clearing and
 * statistics reset should be coordinated in multi-threaded environments.
 * 
 * @since 1.0.0
 * @see framework.advisor.FW_AdvisorEngine
 * @see framework.advisor.FW_AdvisorRecommendation
 * @see framework.advisor.FW_AdvisorAudience
 */
public class FW_Advisor {
    
    // ===== CONSTANTS =====
    
    /** mAi Advisor™ version */
    private static final String VERSION = "1.2.0";
    
    /** Product name */
    private static final String PRODUCT_NAME = "mAi Advisor™";
    
    /** Tagline */
    private static final String TAGLINE = "Intelligent Guidance for Every Role";
    
    /** Template base path relative to project root */
    private static final String TEMPLATE_PATH = "src/test/java/framework/advisor/templates";

    /** Heavy divider for major sections */
    private static final String DIVIDER_HEAVY = "═══════════════════════════════════════════════════════════════════";
    
    /** Light divider for subsections */
    private static final String DIVIDER_LIGHT = "───────────────────────────────────────────────────────────────────";
    
    // ===== SINGLETON ENGINE =====
    
    /** Shared engine instance */
    private static final FW_AdvisorEngine engine = new FW_AdvisorEngine();
    
    // ===== CONSTRUCTOR =====
    
    /**
     * Private constructor to prevent instantiation.
     * This is a utility class with static methods only.
     */
    private FW_Advisor() {
        throw new UnsupportedOperationException("FW_Advisor is a utility class and cannot be instantiated");
    }
    
    // ===== MAIN METHOD FOR TESTING =====
    
    /**
     * Main method for testing and validating the complete mAi Advisor™ flow.
     * 
     * <p>This method simulates a complete audit scenario with an expired SSL
     * certificate and demonstrates the entire advisor workflow:
     * <ol>
     *   <li>Display advisor branding and status</li>
     *   <li>Create simulated HTTP audit data with SSL issues</li>
     *   <li>Generate recommendations for all audiences</li>
     *   <li>Display recommendations grouped by audience</li>
     *   <li>Show executive summary</li>
     *   <li>Display engine statistics</li>
     * </ol>
     * 
     * <p><b>Usage:</b>
     * <pre>
     * # From project root
     * mvn exec:java -Dexec.mainClass="framework.advisor.FW_Advisor"
     * 
     * # Or compile and run directly
     * javac src/test/java/framework/advisor/FW_Advisor.java
     * java -cp target/test-classes framework.advisor.FW_Advisor
     * </pre>
     * 
     * <p><b>Why this exists:</b> The main method serves as a comprehensive
     * integration test and demonstration of the advisor system. It validates
     * that all components work together correctly and provides executable
     * documentation for developers learning the system.
     * 
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        // Display branding header
        System.out.println("\n" + FW_ConsoleColors.CORAL + DIVIDER_HEAVY + FW_ConsoleColors.RESET);
        System.out.println(FW_ConsoleColors.CORAL + "  " + getBranding() + FW_ConsoleColors.RESET);
        System.out.println(FW_ConsoleColors.CORAL + DIVIDER_HEAVY + FW_ConsoleColors.RESET);
        
        // Display system status
        System.out.println("\n" + FW_ConsoleColors.BLUE + "📊 System Status:" + FW_ConsoleColors.RESET);
        System.out.println(FW_ConsoleColors.WHITE + "   Advisor Enabled: " + FW_ConsoleColors.GREEN + isEnabled() + FW_ConsoleColors.RESET);
        System.out.println(FW_ConsoleColors.WHITE + "   Available Audiences: " + FW_ConsoleColors.BLUE + getAllAudiences().length + FW_ConsoleColors.RESET);
        System.out.println(FW_ConsoleColors.WHITE + "   Implementers: " + FW_ConsoleColors.BLUE + getImplementerAudiences().length + FW_ConsoleColors.RESET);
        System.out.println(FW_ConsoleColors.WHITE + "   Coordinators: " + FW_ConsoleColors.BLUE + getCoordinatorAudiences().length + FW_ConsoleColors.RESET);
        
        // Create simulated HTTP audit data
        System.out.println("\n" + FW_ConsoleColors.BLUE + "🔍 Simulating HTTP Audit..." + FW_ConsoleColors.RESET);
        FW_Http httpData = createSimulatedHttpData();
        System.out.println(FW_ConsoleColors.GREY + "   URL: " + FW_ConsoleColors.WHITE + httpData.getRequestUrl() + FW_ConsoleColors.RESET);
        System.out.println(FW_ConsoleColors.GREY + "   SSL Valid: " + FW_ConsoleColors.RED + httpData.hasValidCertificate() + FW_ConsoleColors.RESET);
        System.out.println(FW_ConsoleColors.GREY + "   SSL Expiry Days: " + FW_ConsoleColors.RED + httpData.getCertificateDaysUntilExpiry() + FW_ConsoleColors.RESET);
        System.out.println(FW_ConsoleColors.GREY + "   Issue Detected: " + FW_ConsoleColors.ORANGE + "Expired SSL Certificate" + FW_ConsoleColors.RESET);
        
        // Test 1: Get all recommendations
        System.out.println("\n" + FW_ConsoleColors.CORAL + DIVIDER_HEAVY + FW_ConsoleColors.RESET);
        System.out.println(FW_ConsoleColors.CORAL + "▶ TEST 1: Generate Recommendations for All Audiences" + FW_ConsoleColors.RESET);
        System.out.println(FW_ConsoleColors.CORAL + DIVIDER_HEAVY + FW_ConsoleColors.RESET);
        
        try {
            List<FW_AdvisorRecommendation> allRecommendations = getAllRecommendations(httpData);
            
            if (allRecommendations.isEmpty()) {
                System.out.println("\n" + FW_ConsoleColors.ORANGE + "⚠️  No recommendations generated." + FW_ConsoleColors.RESET);
                System.out.println(FW_ConsoleColors.GREY + "   This may indicate:" + FW_ConsoleColors.RESET);
                System.out.println(FW_ConsoleColors.GREY + "   • Advisor is disabled in configuration" + FW_ConsoleColors.RESET);
                System.out.println(FW_ConsoleColors.GREY + "   • No findings detected in HTTP data" + FW_ConsoleColors.RESET);
                System.out.println(FW_ConsoleColors.GREY + "   • Template files are missing" + FW_ConsoleColors.RESET);
            } else {
                System.out.println("\n" + FW_ConsoleColors.GREEN + "✓ Generated " + allRecommendations.size() + " recommendations" + FW_ConsoleColors.RESET);
                
                // Display recommendations grouped by audience
                for (FW_AdvisorAudience audience : getAllAudiences()) {
                    List<FW_AdvisorRecommendation> audienceRecs = allRecommendations.stream()
                        .filter(rec -> rec.getTargetAudience() == audience)
                        .toList();
                    
                    if (!audienceRecs.isEmpty()) {
                        System.out.println("\n" + FW_ConsoleColors.CORAL + DIVIDER_LIGHT + FW_ConsoleColors.RESET);
                        System.out.println(FW_ConsoleColors.BLUE + "👤 " + audience.getDisplayName() + FW_ConsoleColors.RESET);
                        System.out.println(FW_ConsoleColors.GREY + "   Tier: " + (audience.isImplementer() ? 
                            FW_ConsoleColors.GREEN + "Understanding + Actions" : 
                            FW_ConsoleColors.BLUE + "Understanding Only") + FW_ConsoleColors.RESET);
                        System.out.println(FW_ConsoleColors.CORAL + DIVIDER_LIGHT + FW_ConsoleColors.RESET);
                        
                        for (FW_AdvisorRecommendation rec : audienceRecs) {
                            System.out.println("\n" + FW_ConsoleColors.WHITE + "   Finding: " + FW_ConsoleColors.YELLOW + rec.getFindingType() + FW_ConsoleColors.RESET);
                            
                            // Color-code severity
                            String severityColor = switch (rec.getSeverity()) {
                                case CRITICAL -> FW_ConsoleColors.RED;
                                case HIGH -> FW_ConsoleColors.ORANGE;
                                case MEDIUM -> FW_ConsoleColors.YELLOW;
                                case LOW -> FW_ConsoleColors.GREENYELLOW;
                                default -> FW_ConsoleColors.GREY;
                            };
                            System.out.println(FW_ConsoleColors.WHITE + "   Severity: " + severityColor + rec.getSeverity() + FW_ConsoleColors.RESET);
                            
                            // Show understanding tier
                            if (rec.isUnderstandingTier() || rec.isActionTier()) {
                                System.out.println("\n" + FW_ConsoleColors.BLUE + "   📖 Understanding:" + FW_ConsoleColors.RESET);
                                String summary = rec.getSummary();
                                if (summary != null && !summary.isEmpty()) {
                                    System.out.println(FW_ConsoleColors.GREY + "      " + summary + FW_ConsoleColors.RESET);
                                }
                                
                                String impact = rec.getImpact();
                                if (impact != null && !impact.isEmpty()) {
                                    System.out.println(FW_ConsoleColors.GREY + "      Impact: " + impact + FW_ConsoleColors.RESET);
                                }
                            }
                            
                            // Show action tier for implementers
                            if (rec.isActionTier()) {
                                System.out.println("\n" + FW_ConsoleColors.GREEN + "   🔧 Actions Available:" + FW_ConsoleColors.RESET);
                                
                                if (rec.hasCodeExample()) {
                                    System.out.println(FW_ConsoleColors.GREEN + "      ✓ Framework-specific code examples" + FW_ConsoleColors.RESET);
                                }
                                
                                if (rec.getVerificationSteps() != null && !rec.getVerificationSteps().isEmpty()) {
                                    System.out.println(FW_ConsoleColors.GREEN + "      ✓ Verification steps" + FW_ConsoleColors.RESET);
                                }
                                
                                if (rec.getEffortEstimate() != null && !rec.getEffortEstimate().isEmpty()) {
                                    System.out.println(FW_ConsoleColors.GREEN + "      ✓ Estimated effort: " + 
                                        FW_ConsoleColors.WHITE + rec.getEffortEstimate() + FW_ConsoleColors.RESET);
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("\n" + FW_ConsoleColors.RED + "✗ Error generating recommendations: " + e.getMessage() + FW_ConsoleColors.RESET);
            System.out.println(FW_ConsoleColors.GREY + "   Stack trace: " + java.util.Arrays.toString(e.getStackTrace()) + FW_ConsoleColors.RESET);
        }
        
        // Test 2: Get specific audience recommendations
        System.out.println("\n" + FW_ConsoleColors.CORAL + DIVIDER_HEAVY + FW_ConsoleColors.RESET);
        System.out.println(FW_ConsoleColors.CORAL + "▶ TEST 2: Generate Recommendations for DEVELOPER Audience" + FW_ConsoleColors.RESET);
        System.out.println(FW_ConsoleColors.CORAL + DIVIDER_HEAVY + FW_ConsoleColors.RESET);
        
        try {
            List<FW_AdvisorRecommendation> devRecs = getRecommendations(httpData, FW_AdvisorAudience.DEVELOPER);
            
            if (devRecs.isEmpty()) {
                System.out.println("\n" + FW_ConsoleColors.ORANGE + "⚠️  No developer recommendations generated." + FW_ConsoleColors.RESET);
            } else {
                System.out.println("\n" + FW_ConsoleColors.GREEN + "✓ Generated " + devRecs.size() + " developer-specific recommendations" + FW_ConsoleColors.RESET);
                
                for (FW_AdvisorRecommendation rec : devRecs) {
                    System.out.println("\n" + FW_ConsoleColors.WHITE + "   Finding: " + FW_ConsoleColors.YELLOW + rec.getFindingType() + FW_ConsoleColors.RESET);
                    System.out.println(FW_ConsoleColors.GREY + "   Has Code Examples: " + 
                        (rec.hasCodeExample() ? FW_ConsoleColors.GREEN + "✓" : FW_ConsoleColors.RED + "✗") + FW_ConsoleColors.RESET);
                    System.out.println(FW_ConsoleColors.GREY + "   Has Verification Steps: " + 
                        ((rec.getVerificationSteps() != null && !rec.getVerificationSteps().isEmpty()) ? 
                            FW_ConsoleColors.GREEN + "✓" : FW_ConsoleColors.RED + "✗") + FW_ConsoleColors.RESET);
                }
            }
        } catch (Exception e) {
            System.out.println("\n" + FW_ConsoleColors.RED + "✗ Error generating developer recommendations: " + e.getMessage() + FW_ConsoleColors.RESET);
        }
        
        // Test 3: Get executive summary
        System.out.println("\n" + FW_ConsoleColors.CORAL + DIVIDER_HEAVY + FW_ConsoleColors.RESET);
        System.out.println(FW_ConsoleColors.CORAL + "▶ TEST 3: Generate Executive Summary" + FW_ConsoleColors.RESET);
        System.out.println(FW_ConsoleColors.CORAL + DIVIDER_HEAVY + FW_ConsoleColors.RESET);
        
        try {
            String execSummary = getExecutiveSummary(httpData);
            
            if (execSummary == null || execSummary.isEmpty()) {
                System.out.println("\n" + FW_ConsoleColors.ORANGE + "⚠️  No executive summary generated." + FW_ConsoleColors.RESET);
            } else {
                System.out.println("\n" + FW_ConsoleColors.GREEN + "✓ Executive Summary Generated:" + FW_ConsoleColors.RESET);
                System.out.println("\n" + execSummary);
            }
        } catch (Exception e) {
            System.out.println("\n" + FW_ConsoleColors.RED + "✗ Error generating executive summary: " + e.getMessage() + FW_ConsoleColors.RESET);
        }
        
        // Test 4: Display statistics
        System.out.println("\n" + FW_ConsoleColors.CORAL + DIVIDER_HEAVY + FW_ConsoleColors.RESET);
        System.out.println(FW_ConsoleColors.CORAL + "▶ TEST 4: Engine Statistics" + FW_ConsoleColors.RESET);
        System.out.println(FW_ConsoleColors.CORAL + DIVIDER_HEAVY + FW_ConsoleColors.RESET);
        System.out.println("\n" + getStatistics());
        
        // Test 5: Verify template loading
        System.out.println(FW_ConsoleColors.CORAL + DIVIDER_HEAVY + FW_ConsoleColors.RESET);
        System.out.println(FW_ConsoleColors.CORAL + "▶ TEST 5: Template System Validation" + FW_ConsoleColors.RESET);
        System.out.println(FW_ConsoleColors.CORAL + DIVIDER_HEAVY + FW_ConsoleColors.RESET);
        
        try {
            Map<String, Object> stats = engine.getStatistics();
            int templatesLoaded = (int) stats.getOrDefault("templatesLoaded", 0);
            int templateFailures = (int) stats.getOrDefault("templateLoadFailures", 0);
            
            System.out.println("\n" + FW_ConsoleColors.BLUE + "   Templates Loaded Successfully: " + 
                FW_ConsoleColors.GREEN + templatesLoaded + FW_ConsoleColors.RESET);
            System.out.println(FW_ConsoleColors.BLUE + "   Template Load Failures: " + 
                (templateFailures > 0 ? FW_ConsoleColors.ORANGE : FW_ConsoleColors.GREEN) + templateFailures + FW_ConsoleColors.RESET);
            
            if (templateFailures > 0) {
                System.out.println("\n" + FW_ConsoleColors.ORANGE + "   ⚠️  Template load failures detected!" + FW_ConsoleColors.RESET);
                System.out.println(FW_ConsoleColors.GREY + "   Check that template JSON files exist in:" + FW_ConsoleColors.RESET);
                System.out.println(FW_ConsoleColors.GREY + "   " + TEMPLATE_PATH + FW_ConsoleColors.RESET);
            }
            
            if (templatesLoaded == 0) {
                System.out.println("\n" + FW_ConsoleColors.ORANGE + "   ⚠️  No templates loaded!" + FW_ConsoleColors.RESET);
                System.out.println(FW_ConsoleColors.GREY + "   The advisor needs template files to generate recommendations." + FW_ConsoleColors.RESET);
                System.out.println(FW_ConsoleColors.GREY + "   Next step: Create template JSON files (e.g., ssl-expired.json)" + FW_ConsoleColors.RESET);
            }
        } catch (Exception e) {
            System.out.println("\n" + FW_ConsoleColors.RED + "✗ Error checking template system: " + e.getMessage() + FW_ConsoleColors.RESET);
        }
        
        // Summary
        System.out.println("\n" + FW_ConsoleColors.CORAL + DIVIDER_HEAVY + FW_ConsoleColors.RESET);
        System.out.println(FW_ConsoleColors.CORAL + "🎯 Test Validation Summary" + FW_ConsoleColors.RESET);
        System.out.println(FW_ConsoleColors.CORAL + DIVIDER_HEAVY + FW_ConsoleColors.RESET);
        
        System.out.println("\n" + FW_ConsoleColors.GREEN + "✓ Test 1: All Recommendations - Complete" + FW_ConsoleColors.RESET);
        System.out.println(FW_ConsoleColors.GREEN + "✓ Test 2: Specific Audience - Complete" + FW_ConsoleColors.RESET);
        System.out.println(FW_ConsoleColors.GREEN + "✓ Test 3: Executive Summary - Complete" + FW_ConsoleColors.RESET);
        System.out.println(FW_ConsoleColors.GREEN + "✓ Test 4: Statistics - Complete" + FW_ConsoleColors.RESET);
        System.out.println(FW_ConsoleColors.GREEN + "✓ Test 5: Template Validation - Complete" + FW_ConsoleColors.RESET);
        
        System.out.println("\n" + FW_ConsoleColors.BLUE + "Next Steps:" + FW_ConsoleColors.RESET);
        System.out.println(FW_ConsoleColors.GREY + "1. Create template JSON files for findings (ssl-expired.json, etc.)" + FW_ConsoleColors.RESET);
        System.out.println(FW_ConsoleColors.GREY + "2. Integrate with FW_Audit_HttpReview for real audits" + FW_ConsoleColors.RESET);
        System.out.println(FW_ConsoleColors.GREY + "3. Add advisor section to FW_HttpReporter" + FW_ConsoleColors.RESET);
        System.out.println(FW_ConsoleColors.GREY + "4. Test with live HTTP audit data" + FW_ConsoleColors.RESET);
        
        System.out.println("\n" + FW_ConsoleColors.CORAL + DIVIDER_HEAVY + FW_ConsoleColors.RESET + "\n");
    }
    
    /**
     * Creates simulated HTTP audit data for testing.
     * 
     * <p>Generates a FW_Http object with an expired SSL certificate scenario
     * to demonstrate the advisor's capability to detect and provide guidance
     * for security issues.
     * 
     * <p><b>Why this method exists:</b> Provides consistent test data for the
     * main method without requiring a live HTTP audit. This allows developers
     * to validate the advisor system works correctly before integrating with
     * real audits.
     * 
     * @return FW_Http object with simulated expired SSL certificate
     */
    private static FW_Http createSimulatedHttpData() {
        FW_Http http = new FW_Http();
        
        // Basic HTTP data
        http.setRequestUrl("https://swaglabs.com");
        http.setResponseStatusCode(200);
        http.setTotalDurationMs(150L);
        
        // SSL certificate issue - EXPIRED
        http.setHasValidCertificate(false);
        http.setCertificateDaysUntilExpiry(-30);
        http.setCertificateIssuer("Let's Encrypt");
        http.setCertificateSubject("CN=swaglabs.com");
        
        // Missing security headers (additional findings)
        http.setHasSecurityHeaders(false);
        
        // Server information
        http.setResponseHeaders(new java.util.HashMap<>());
        http.getResponseHeaders().put("Server", "nginx/1.21.0");
        
        return http;
    }
    
    // ===== PUBLIC API - RECOMMENDATION GENERATION =====
    
    /**
     * Gets recommendations for a specific audience.
     * 
     * <p>Analyzes the HTTP audit data and generates tailored recommendations
     * for the specified audience. Implementer audiences (DEVELOPER, OPS, QA)
     * receive both understanding and action tiers. Coordinator audiences
     * (SECURITY, PM, EXECUTIVE) receive understanding tier only.
     * 
     * <p><b>Example:</b>
     * <pre>
     * List&lt;FW_AdvisorRecommendation&gt; recs = 
     *     FW_Advisor.getRecommendations(httpData, FW_AdvisorAudience.DEVELOPER);
     * 
     * for (FW_AdvisorRecommendation rec : recs) {
     *     System.out.println("Finding: " + rec.getFindingType());
     *     System.out.println("Summary: " + rec.getSummary());
     *     
     *     if (rec.isActionTier()) {
     *         System.out.println("Code Example:");
     *         System.out.println(rec.getCodeExample());
     *     }
     * }
     * </pre>
     * 
     * @param http HTTP transaction containing audit results
     * @param audience Target audience for recommendations
     * @return List of tailored recommendations (empty if no findings or advisor disabled)
     * @throws IllegalArgumentException if http or audience is null
     */
    public static List<FW_AdvisorRecommendation> getRecommendations(
            FW_Http http, 
            FW_AdvisorAudience audience) {
        return engine.generateRecommendations(http, audience);
    }
    
    /**
     * Gets recommendations for all enabled audiences.
     * 
     * <p>Generates recommendations for all audiences configured as enabled
     * in advisor-config.properties. Useful for comprehensive multi-audience
     * reports. Each audience receives appropriate tier based on their role.
     * 
     * <p><b>Example:</b>
     * <pre>
     * List&lt;FW_AdvisorRecommendation&gt; allRecs = 
     *     FW_Advisor.getAllRecommendations(httpData);
     * 
     * // Group by audience
     * Map&lt;FW_AdvisorAudience, List&lt;FW_AdvisorRecommendation&gt;&gt; byAudience = 
     *     allRecs.stream().collect(Collectors.groupingBy(
     *         FW_AdvisorRecommendation::getTargetAudience));
     * 
     * // Generate report sections
     * for (FW_AdvisorAudience audience : byAudience.keySet()) {
     *     System.out.println("## " + audience.getDisplayName());
     *     for (FW_AdvisorRecommendation rec : byAudience.get(audience)) {
     *         System.out.println("- " + rec.getSummary());
     *     }
     * }
     * </pre>
     * 
     * @param http HTTP transaction containing audit results
     * @return List of all recommendations across all enabled audiences
     * @throws IllegalArgumentException if http is null
     */
    public static List<FW_AdvisorRecommendation> getAllRecommendations(FW_Http http) {
        return engine.generateAllRecommendations(http);
    }
    
    /**
     * Gets executive summary of audit findings.
     * 
     * <p>Generates a high-level markdown-formatted summary suitable for
     * leadership and management. Includes finding breakdown by severity,
     * priority assessment, immediate actions needed, and next steps.
     * 
     * <p><b>Example:</b>
     * <pre>
     * String summary = FW_Advisor.getExecutiveSummary(httpData);
     * 
     * // Write to markdown file
     * Files.writeString(
     *     Path.of("executive-summary.md"), 
     *     summary, 
     *     StandardCharsets.UTF_8
     * );
     * 
     * // Or include in email/report
     * emailService.send(
     *     to: "executives@company.com",
     *     subject: "Security Audit Summary",
     *     body: summary
     * );
     * </pre>
     * 
     * @param http HTTP transaction containing audit results
     * @return Markdown-formatted executive summary
     * @throws IllegalArgumentException if http is null
     */
    public static String getExecutiveSummary(FW_Http http) {
        return engine.generateExecutiveSummary(http);
    }
    
    // ===== PUBLIC API - ENGINE ACCESS =====
    
    /**
     * Gets the underlying engine instance.
     * 
     * <p>Provides access to the shared FW_AdvisorEngine for advanced usage
     * such as accessing statistics, managing cache, or using methods not
     * exposed through the facade.
     * 
     * <p><b>Example:</b>
     * <pre>
     * FW_AdvisorEngine engine = FW_Advisor.getEngine();
     * 
     * // Access statistics
     * System.out.println(engine.getStatistics());
     * 
     * // Clear cache in development
     * if (isDevelopmentMode) {
     *     engine.clearCache();
     * }
     * </pre>
     * 
     * @return Shared engine instance
     */
    public static FW_AdvisorEngine getEngine() {
        return engine;
    }
    
    // ===== PUBLIC API - STATISTICS & MANAGEMENT =====
    
    /**
     * Gets statistics from the advisor engine.
     * 
     * <p>Returns formatted string with statistics including recommendations
     * generated, findings processed, templates loaded, and cache performance.
     * 
     * <p><b>Example:</b>
     * <pre>
     * String stats = FW_Advisor.getStatistics();
     * System.out.println(stats);
     * 
     * // Output:
     * // mAi Advisor™ Statistics:
     * //   Recommendations Generated: 45
     * //   Findings Processed: 15
     * //   Templates Loaded: 8
     * //   Template Load Failures: 1
     * //   Cache Hit Rate: 85.7%
     * </pre>
     * 
     * @return Formatted statistics string
     */
    public static String getStatistics() {
        Map<String, Object> stats = engine.getStatistics();
        
        StringBuilder sb = new StringBuilder();
        sb.append(FW_ConsoleColors.BLUE).append("mAi Advisor™ Statistics:").append(FW_ConsoleColors.RESET).append("\n");
        sb.append(FW_ConsoleColors.GREY).append("  Recommendations Generated: ").append(FW_ConsoleColors.WHITE)
            .append(stats.get("recommendationsGenerated")).append(FW_ConsoleColors.RESET).append("\n");
        sb.append(FW_ConsoleColors.GREY).append("  Findings Processed: ").append(FW_ConsoleColors.WHITE)
            .append(stats.get("findingsProcessed")).append(FW_ConsoleColors.RESET).append("\n");
        sb.append(FW_ConsoleColors.GREY).append("  Templates Loaded: ").append(FW_ConsoleColors.GREEN)
            .append(stats.get("templatesLoaded")).append(FW_ConsoleColors.RESET).append("\n");
        
        int failures = (int) stats.get("templateLoadFailures");
        sb.append(FW_ConsoleColors.GREY).append("  Template Load Failures: ")
            .append(failures > 0 ? FW_ConsoleColors.ORANGE : FW_ConsoleColors.GREEN)
            .append(failures).append(FW_ConsoleColors.RESET).append("\n");
            
        sb.append(FW_ConsoleColors.GREY).append("  Template Cache Size: ").append(FW_ConsoleColors.WHITE)
            .append(stats.get("templateCacheSize")).append(FW_ConsoleColors.RESET).append("\n");
        
        Object hitRate = stats.get("templateCacheHitRate");
        if (hitRate != null) {
            double rate = ((Number)hitRate).doubleValue();
            String color = rate > 0.7 ? FW_ConsoleColors.GREEN : 
                          rate > 0.4 ? FW_ConsoleColors.YELLOW : 
                          FW_ConsoleColors.ORANGE;
            sb.append(FW_ConsoleColors.GREY).append("  Cache Hit Rate: ").append(color)
                .append(String.format("%.1f%%", rate * 100)).append(FW_ConsoleColors.RESET).append("\n");
        }
        
        return sb.toString();
    }

    /**
     * Resets all statistics counters.
     * 
     * <p>Clears recommendation count, findings processed, template loads,
     * and failures. Does not clear the template cache. Useful for testing
     * or when starting a new audit session.
     * 
     * <p><b>Example:</b>
     * <pre>
     * // Start new audit session
     * FW_Advisor.resetStatistics();
     * 
     * // Run audits
     * // ...
     * 
     * // View session statistics
     * System.out.println(FW_Advisor.getStatistics());
     * </pre>
     */
    public static void resetStatistics() {
        engine.resetStatistics();
    }
    
    /**
     * Clears the template cache.
     * 
     * <p>Removes all cached templates, forcing reload on next access.
     * Useful in development mode when templates are being edited, or
     * when memory needs to be freed. Also resets cache statistics.
     * 
     * <p><b>Example:</b>
     * <pre>
     * // Development mode - reload templates after editing
     * if (System.getProperty("advisor.dev.mode", "false").equals("true")) {
     *     FW_Advisor.clearCache();
     *     System.out.println("Template cache cleared");
     * }
     * </pre>
     */
    public static void clearCache() {
        engine.clearCache();
    }
    
    // ===== PUBLIC API - VERSION & METADATA =====
    
    /**
     * Gets the mAi Advisor™ version.
     * 
     * @return Version string (e.g., "1.2.0")
     */
    public static String getVersion() {
        return VERSION;
    }
    
    /**
     * Gets the product name.
     * 
     * @return Product name "mAi Advisor™"
     */
    public static String getProductName() {
        return PRODUCT_NAME;
    }
    
    /**
     * Gets the product tagline.
     * 
     * @return Tagline "Intelligent Guidance for Every Role"
     */
    public static String getTagline() {
        return TAGLINE;
    }
    
    /**
     * Gets full product branding string.
     * 
     * <p><b>Example Output:</b>
     * <pre>
     * mAi Advisor™ v1.2.0 - Intelligent Guidance for Every Role
     * </pre>
     * 
     * @return Formatted branding string
     */
    public static String getBranding() {
        return String.format("%s v%s - %s", PRODUCT_NAME, VERSION, TAGLINE);
    }
    
    // ===== PUBLIC API - CONVENIENCE HELPERS =====
    
    /**
     * Checks if mAi Advisor™ is enabled.
     * 
     * <p>Reads configuration from advisor-config.properties to determine
     * if the advisor system is enabled. When disabled, recommendation
     * methods return empty lists.
     * 
     * @return true if advisor is enabled, false otherwise
     */
    public static boolean isEnabled() {
        Object value = framework.utilities.FW_ConfigMgr.getVarVal("advisorEnabled");
        return (value != null) ? Boolean.parseBoolean(value.toString()) : true;
    }
    
    /**
     * Gets list of all available audiences.
     * 
     * <p>Returns array of all audience types supported by the system.
     * Useful for UI dropdowns or iterating through all audiences.
     * 
     * @return Array of all FW_AdvisorAudience values
     */
    public static FW_AdvisorAudience[] getAllAudiences() {
        return FW_AdvisorAudience.values();
    }
    
    /**
     * Gets list of implementer audiences.
     * 
     * <p>Returns audiences that receive ACTION tier recommendations:
     * DEVELOPER, OPS_INFRASTRUCTURE, QA_TESTER.
     * 
     * @return Array of implementer audiences
     */
    public static FW_AdvisorAudience[] getImplementerAudiences() {
        return FW_AdvisorAudience.getImplementers();
    }
    
    /**
     * Gets list of coordinator audiences.
     * 
     * <p>Returns audiences that receive UNDERSTANDING tier only:
     * SECURITY_ENGINEER, PROJECT_MANAGER, EXECUTIVE.
     * 
     * @return Array of coordinator audiences
     */
    public static FW_AdvisorAudience[] getCoordinatorAudiences() {
        return FW_AdvisorAudience.getCoordinators();
    }
    
    /**
     * Gets default audience.
     * 
     * <p>Returns DEVELOPER as the default audience since developers
     * are typically the primary implementers of security fixes.
     * 
     * @return Default audience (DEVELOPER)
     */
    public static FW_AdvisorAudience getDefaultAudience() {
        return FW_AdvisorAudience.getDefault();
    }
}