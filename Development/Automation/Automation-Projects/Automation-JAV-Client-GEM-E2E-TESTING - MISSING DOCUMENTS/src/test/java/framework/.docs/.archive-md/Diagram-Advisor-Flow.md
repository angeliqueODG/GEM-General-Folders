# Automation Framework - mAi Advisor™ Flow Diagram

<!-- ===============================================================
@file: Diagram-Advisor-Flow.md
@filepath: src/test/java/framework/.docs/Diagram-Advisor-Flow.md
@version: 1.0.0
@updated: 2025-10-30 01:15:00 PM CDT
@author: Greg Paskal
@company: MissionWares

@description:
Visual documentation of the mAi Advisor™ recommendation generation flow.
Shows the complete end-to-end process from HTTP audit execution through
finding detection, template matching, framework detection, and multi-audience
recommendation generation. Includes sequence diagrams for component interactions
and flowcharts for template selection logic.

@dependencies:
- Mermaid diagram rendering support
- framework.advisor.* (advisor components)
- framework.audits.FW_Audit_HttpReview
- framework.http.FW_HttpExecutor

@tags: diagrams, mAi-advisor, flow, sequence, recommendations, mAi™

@changeLog:
Date        Author          Version  Description
----------  --------------  -------  --------------------------
2025-10-30  G. Paskal       1.0.0    Initial advisor flow diagrams
=============================================================== -->

<!-- Navigation - Begin -->
[Home](Home.md) | [Overview](Doc-Overview.md) | [Setup](Doc-Setup.md) | [Test](Doc-Test-Development.md) | [Diagrams](Diagrams.md) | [API Docs](../../../../../target/site/index.html)
<!-- Navigation - End -->

---

# mAi Advisor™ Recommendation Flow

## Introduction

This document visualizes the complete flow of the mAi Advisor™ intelligent guidance system, from HTTP audit execution through multi-audience recommendation generation. Understanding this flow helps developers, QA engineers, and framework maintainers see how audit findings are transformed into actionable, role-specific guidance.

**Key Process Steps:**
1. HTTP audit execution and finding detection
2. Template matching based on finding type
3. Framework auto-detection from HTTP headers
4. Two-tier recommendation generation (Understanding + Action)
5. Multi-audience content customization
6. Report integration and delivery

---

## Complete Recommendation Generation Flow

This sequence diagram shows the end-to-end process from test execution to report delivery:

```mermaid
sequenceDiagram
    participant Test as Test Suite
    participant AM as FW_AuditManager
    participant HttpEx as FW_HttpExecutor
    participant Audit as FW_Audit_HttpReview
    participant Advisor as FW_Advisor
    participant Engine as FW_AdvisorEngine
    participant Loader as FW_AdvisorTemplateLoader
    participant Reporter as Report Generators
    
    Test->>AM: performHttpAudit(url)
    AM->>HttpEx: execute(url)
    HttpEx->>HttpEx: Capture HTTP transaction
    HttpEx-->>AM: FW_Http object
    
    AM->>Audit: runAuditHttpReview(http)
    
    rect rgb(220, 240, 255)
        Note over Audit: 7-Phase Analysis
        Audit->>Audit: 1. Network & Geolocation
        Audit->>Audit: 2. TLS & Certificate
        Audit->>Audit: 3. Security Headers
        Audit->>Audit: 4. Cookie Security
        Audit->>Audit: 5. Redirect Chain
        Audit->>Audit: 6. Performance
        Audit->>Audit: 7. Compliance
    end
    
    Audit->>Audit: Collect findings list
    Note over Audit: Findings: HSTS_MISSING,<br/>CSP_MISSING, INSECURE_COOKIE
    
    rect rgb(255, 245, 220)
        Note over Audit,Engine: mAi Advisor™ Integration
        Audit->>Advisor: Generate recommendations
        Advisor->>Engine: generateRecommendations(http, audience)
        
        loop For each finding
            Engine->>Loader: loadTemplate(findingType)
            Loader->>Loader: Check cache
            alt Template cached
                Loader-->>Engine: Return cached template
            else Not cached
                Loader->>Loader: Read JSON from filesystem
                Loader->>Loader: Parse & validate
                Loader->>Loader: Store in cache
                Loader-->>Engine: Return template
            end
            
            Engine->>Engine: detectFramework(httpHeaders)
            Note over Engine: Detected: Spring Boot
            
            Engine->>Engine: generateUnderstandingTier(template, audience)
            Note over Engine: Generate for all audiences
            
            alt Audience is implementer
                Engine->>Engine: generateActionTier(template, audience)
                Engine->>Engine: customizeCodeExamples(framework)
                Note over Engine: Include Spring Boot code
            end
            
            Engine->>Engine: Create FW_AdvisorRecommendation
        end
        
        Engine-->>Advisor: List<Recommendation>
        Advisor-->>Audit: Recommendations generated
    end
    
    Audit->>Audit: Populate FW_Http with scores & findings
    Audit-->>AM: FW_Http (enriched with advisor data)
    
    rect rgb(220, 255, 220)
        Note over AM,Reporter: Report Generation
        AM->>Reporter: Generate diagnostic report
        Reporter->>Reporter: Format HTML with findings
        Reporter->>Reporter: Include advisor recommendations
        Reporter->>Reporter: Add code examples per audience
        Reporter-->>AM: HTML + Markdown reports
        
        AM->>Reporter: Generate summary report
        Reporter->>Reporter: Executive summary
        Reporter->>Reporter: Key recommendations
        Reporter-->>AM: Summary report
    end
    
    AM-->>Test: Audit complete with reports
    Test->>Test: Review reports in target/http-reports/
```

---

## Component Interaction Overview

This diagram shows how the main advisor components interact:

```mermaid
graph TB
    subgraph "Layer 6: Audits"
        A[FW_Audit_HttpReview<br/>Security Analysis]
    end
    
    subgraph "Layer 7: Advisor System"
        B[FW_Advisor<br/>Static Facade]
        C[FW_AdvisorEngine<br/>Core Engine]
        D[FW_AdvisorTemplateLoader<br/>Template Manager]
        E[FW_AdvisorAudience<br/>6 Audience Types]
        F[FW_AdvisorRecommendation<br/>Output Model]
    end
    
    subgraph "Templates"
        G[JSON Templates<br/>16 templates]
        H[Security<br/>8 templates]
        I[Performance<br/>3 templates]
        J[Compliance<br/>2 templates]
        K[Infrastructure<br/>3 templates]
    end
    
    subgraph "Reports"
        L[FW_HttpDiagnosticReporter<br/>HTML + Markdown]
        M[FW_HttpReporter<br/>Executive Summary]
    end
    
    A -->|Findings| B
    B -->|Delegate| C
    C -->|Load templates| D
    D -->|Read| G
    G -->|Contains| H
    G -->|Contains| I
    G -->|Contains| J
    G -->|Contains| K
    C -->|Use| E
    C -->|Create| F
    F -->|Include in| L
    F -->|Include in| M
    
    style A fill:#e1f5ff
    style B fill:#fff3e1
    style C fill:#fff3e1
    style D fill:#fff3e1
    style G fill:#ffe1e1
    style L fill:#e1ffe1
    style M fill:#e1ffe1
```

---

## Template Selection Logic

This flowchart shows how findings are matched to templates and processed:

```mermaid
flowchart TD
    Start([HTTP Audit Complete]) --> HasFindings{Findings<br/>detected?}
    
    HasFindings -->|No| NoAdvisor[No advisor<br/>recommendations]
    HasFindings -->|Yes| GetFirstFinding[Get next finding]
    
    GetFirstFinding --> ClassifyFinding[Classify finding<br/>Type, Severity, Category]
    
    ClassifyFinding --> DeterminePath{Finding<br/>type?}
    
    DeterminePath -->|HSTS_MISSING| TemplateHSTS[Load:<br/>security/hsts-missing.json]
    DeterminePath -->|CSP_MISSING| TemplateCSP[Load:<br/>security/csp-missing.json]
    DeterminePath -->|INSECURE_COOKIE| TemplateCookie[Load:<br/>security/insecure-cookies.json]
    DeterminePath -->|SSL_EXPIRED| TemplateSSL[Load:<br/>security/ssl-expired.json]
    DeterminePath -->|Other| TemplateOther[Load:<br/>corresponding template]
    
    TemplateHSTS --> CheckCache{Template<br/>in cache?}
    TemplateCSP --> CheckCache
    TemplateCookie --> CheckCache
    TemplateSSL --> CheckCache
    TemplateOther --> CheckCache
    
    CheckCache -->|Yes| UseCache[Use cached template]
    CheckCache -->|No| LoadFromDisk[Load from filesystem]
    
    LoadFromDisk --> ParseJSON[Parse JSON]
    ParseJSON --> ValidateSchema[Validate against schema]
    ValidateSchema --> AddToCache[Add to cache]
    AddToCache --> UseCache
    
    UseCache --> DetectFramework[Detect framework<br/>from HTTP headers]
    
    DetectFramework --> FrameworkType{Framework?}
    FrameworkType -->|Spring Boot| SetSpring[Framework:<br/>Spring Boot]
    FrameworkType -->|Express| SetExpress[Framework:<br/>Express.js]
    FrameworkType -->|Nginx| SetNginx[Framework:<br/>Nginx]
    FrameworkType -->|Other| SetOther[Framework:<br/>Generic]
    
    SetSpring --> DetermineAudiences[Determine target<br/>audiences]
    SetExpress --> DetermineAudiences
    SetNginx --> DetermineAudiences
    SetOther --> DetermineAudiences
    
    DetermineAudiences --> PrimaryAudience[Primary:<br/>Responsible for fix]
    DetermineAudiences --> SecondaryAudiences[Secondary:<br/>Need awareness]
    
    PrimaryAudience --> GenUnderstanding[Generate<br/>Understanding Tier]
    SecondaryAudiences --> GenUnderstanding
    
    GenUnderstanding --> ForAllAudiences[For ALL 6 audiences:<br/>What, Why, Impact]
    
    ForAllAudiences --> CheckImplementer{Audience is<br/>implementer?}
    
    CheckImplementer -->|Yes<br/>DEV, OPS, QA| GenAction[Generate<br/>Action Tier]
    CheckImplementer -->|No<br/>SEC, PM, EXEC| SkipAction[Skip Action Tier]
    
    GenAction --> CustomizeCode[Customize code<br/>for framework]
    CustomizeCode --> AddEffort[Add effort<br/>estimates]
    AddEffort --> AddTests[Add testing<br/>guidance]
    AddTests --> CreateRec[Create<br/>FW_AdvisorRecommendation]
    
    SkipAction --> CreateRec
    
    CreateRec --> MoreFindings{More<br/>findings?}
    MoreFindings -->|Yes| GetFirstFinding
    MoreFindings -->|No| ReturnRecs[Return List of<br/>Recommendations]
    
    ReturnRecs --> End([Recommendations<br/>Ready])
    
    NoAdvisor --> End
    
    style Start fill:#e1f5ff
    style End fill:#e1ffe1
    style CheckCache fill:#fff3e1
    style DetectFramework fill:#ffe1ff
    style DetermineAudiences fill:#ffe1e1
    style GenUnderstanding fill:#e1ffe1
    style GenAction fill:#e1ffe1
```

---

## Multi-Audience Generation Process

This diagram shows how a single finding generates recommendations for all 6 audiences:

```mermaid
flowchart LR
    Finding[HTTP Finding:<br/>HSTS_MISSING] --> Template[Template:<br/>hsts-missing.json]
    
    Template --> T1[Understanding Tier<br/>Content for all]
    Template --> T2[Action Tier<br/>Content for implementers]
    
    T1 --> A1[DEVELOPER<br/>Understanding]
    T1 --> A2[OPS_INFRASTRUCTURE<br/>Understanding]
    T1 --> A3[QA_TESTER<br/>Understanding]
    T1 --> A4[SECURITY_ENGINEER<br/>Understanding]
    T1 --> A5[PROJECT_MANAGER<br/>Understanding]
    T1 --> A6[EXECUTIVE<br/>Understanding]
    
    T2 --> B1[DEVELOPER<br/>+ Action Tier<br/>+ Code Examples]
    T2 --> B2[OPS_INFRASTRUCTURE<br/>+ Action Tier<br/>+ Nginx Config]
    T2 --> B3[QA_TESTER<br/>+ Action Tier<br/>+ Test Cases]
    
    A1 --> B1
    A2 --> B2
    A3 --> B3
    
    B1 --> R1[Recommendation 1:<br/>Developer]
    B2 --> R2[Recommendation 2:<br/>DevOps]
    B3 --> R3[Recommendation 3:<br/>QA]
    A4 --> R4[Recommendation 4:<br/>Security]
    A5 --> R5[Recommendation 5:<br/>PM]
    A6 --> R6[Recommendation 6:<br/>Executive]
    
    R1 --> Report[6 Recommendations<br/>in Report]
    R2 --> Report
    R3 --> Report
    R4 --> Report
    R5 --> Report
    R6 --> Report
    
    style Finding fill:#ffe1e1
    style Template fill:#fff3e1
    style T1 fill:#e1f5ff
    style T2 fill:#e1ffe1
    style Report fill:#e1ffe1
```

---

## Framework Detection Process

This diagram shows how the advisor detects application frameworks:

```mermaid
flowchart TD
    Start([Analyze HTTP<br/>Headers]) --> CheckServer{Server<br/>header?}
    
    CheckServer -->|Contains 'nginx'| DetectNginx[Framework:<br/>Nginx]
    CheckServer -->|Contains 'Apache'| DetectApache[Framework:<br/>Apache]
    CheckServer -->|Contains 'IIS'| DetectIIS[Framework:<br/>IIS]
    CheckServer -->|Not found| CheckPowered{X-Powered-By<br/>header?}
    
    CheckPowered -->|Express| DetectExpress[Framework:<br/>Express.js]
    CheckPowered -->|PHP| DetectPHP[Framework:<br/>PHP]
    CheckPowered -->|ASP.NET| DetectASPNET[Framework:<br/>ASP.NET]
    CheckPowered -->|Not found| CheckMarkers{Other<br/>markers?}
    
    CheckMarkers -->|X-AspNet-Version| DetectASPNET
    CheckMarkers -->|Django markers| DetectDjango[Framework:<br/>Django]
    CheckMarkers -->|Spring Boot markers| DetectSpring[Framework:<br/>Spring Boot]
    CheckMarkers -->|None| DetectGeneric[Framework:<br/>Generic/Unknown]
    
    DetectNginx --> CustomizeCode[Customize Code<br/>Examples]
    DetectApache --> CustomizeCode
    DetectIIS --> CustomizeCode
    DetectExpress --> CustomizeCode
    DetectPHP --> CustomizeCode
    DetectASPNET --> CustomizeCode
    DetectDjango --> CustomizeCode
    DetectSpring --> CustomizeCode
    DetectGeneric --> CustomizeCode
    
    CustomizeCode --> Example1[Developer:<br/>Framework-specific code]
    CustomizeCode --> Example2[DevOps:<br/>Framework-specific config]
    CustomizeCode --> Example3[QA:<br/>Framework-specific tests]
    
    Example1 --> End([Customized<br/>Recommendations])
    Example2 --> End
    Example3 --> End
    
    style Start fill:#e1f5ff
    style End fill:#e1ffe1
    style CustomizeCode fill:#fff3e1
```

---

## Two-Tier Content Assembly

This diagram shows how Understanding and Action tiers are assembled:

```mermaid
flowchart TD
    Template[JSON Template<br/>Loaded] --> ExtractMeta[Extract Metadata<br/>Finding ID, Type, Severity]
    
    ExtractMeta --> Tier1[TIER 1:<br/>UNDERSTANDING]
    ExtractMeta --> Tier2[TIER 2:<br/>ACTION]
    
    Tier1 --> U1[Extract 'what'<br/>What's wrong?]
    Tier1 --> U2[Extract 'why'<br/>Why it matters?]
    Tier1 --> U3[Extract 'impact'<br/>Business/technical impact]
    Tier1 --> U4[Extract 'businessImpact'<br/>Organizational risk]
    Tier1 --> U5[Extract 'technicalDetails'<br/>Technical specifics]
    Tier1 --> U6[Extract 'riskAssessment'<br/>Risk level & severity]
    
    U1 --> AssembleU[Assemble<br/>Understanding Content]
    U2 --> AssembleU
    U3 --> AssembleU
    U4 --> AssembleU
    U5 --> AssembleU
    U6 --> AssembleU
    
    Tier2 --> A1[Extract 'steps'<br/>Remediation steps]
    Tier2 --> A2[Extract 'codeExamples'<br/>Framework code]
    Tier2 --> A3[Extract 'testingGuidance'<br/>Verification tests]
    Tier2 --> A4[Extract 'effortEstimate'<br/>Time required]
    Tier2 --> A5[Extract 'prerequisites'<br/>Requirements]
    
    A1 --> CheckImpl{Audience is<br/>implementer?}
    A2 --> CheckImpl
    A3 --> CheckImpl
    A4 --> CheckImpl
    A5 --> CheckImpl
    
    CheckImpl -->|Yes| AssembleA[Assemble<br/>Action Content]
    CheckImpl -->|No| SkipA[Skip Action<br/>Content]
    
    AssembleU --> Combine[Combine Tiers]
    AssembleA --> Combine
    SkipA --> Combine
    
    Combine --> Rec[FW_AdvisorRecommendation<br/>Complete]
    
    Rec --> Output{Output<br/>format?}
    Output -->|Developer| DevFormat[Markdown with<br/>code blocks]
    Output -->|DevOps| OpsFormat[Configuration<br/>files]
    Output -->|QA| QAFormat[Test cases<br/>checklist]
    Output -->|Others| GenFormat[Formatted<br/>guidance]
    
    DevFormat --> Report[Include in<br/>Report]
    OpsFormat --> Report
    QAFormat --> Report
    GenFormat --> Report
    
    style Template fill:#fff3e1
    style Tier1 fill:#e1f5ff
    style Tier2 fill:#e1ffe1
    style Rec fill:#ffe1ff
    style Report fill:#e1ffe1
```

---

## Report Integration Flow

This diagram shows how advisor recommendations are integrated into reports:

```mermaid
flowchart LR
    Audit[FW_Audit_HttpReview<br/>Complete] --> Findings[List of Findings]
    Findings --> Advisor[mAi Advisor™<br/>Generate Recommendations]
    
    Advisor --> Recs[List of<br/>Recommendations<br/>per audience]
    
    Recs --> DiagReport[FW_HttpDiagnosticReporter]
    Recs --> SummReport[FW_HttpReporter]
    
    DiagReport --> D1[Section 1:<br/>DNS & Network]
    DiagReport --> D2[Section 2:<br/>TLS & Certificates]
    DiagReport --> D3[Section 3:<br/>Security Headers]
    DiagReport --> D4[Section 4:<br/>Performance]
    DiagReport --> D5[Section 5:<br/>Network Diagnostics]
    DiagReport --> D6[Section 6:<br/>Error Diagnostics]
    DiagReport --> D7[Section 7:<br/>Remediation Guidance<br/>⭐ ADVISOR CONTENT]
    
    D7 --> D7A[By Audience:<br/>Developer]
    D7 --> D7B[By Audience:<br/>DevOps]
    D7 --> D7C[By Audience:<br/>QA]
    D7 --> D7D[By Audience:<br/>Security]
    D7 --> D7E[By Audience:<br/>PM]
    D7 --> D7F[By Audience:<br/>Executive]
    
    SummReport --> S1[Executive Summary]
    SummReport --> S2[Key Findings]
    SummReport --> S3[Recommended Actions<br/>⭐ ADVISOR CONTENT]
    SummReport --> S4[Compliance Status]
    
    D7 --> HTML[diagnostic.html]
    D7 --> MD1[diagnostic.md]
    S3 --> MD2[summary.md]
    
    HTML --> Browser[View in Browser]
    MD1 --> IDE[View in IDE]
    MD2 --> IDE
    
    style Advisor fill:#fff3e1
    style D7 fill:#e1ffe1
    style S3 fill:#e1ffe1
    style HTML fill:#e1f5ff
    style MD1 fill:#e1f5ff
    style MD2 fill:#e1f5ff
```

---

## Summary

The mAi Advisor™ system transforms raw HTTP audit findings into actionable, role-specific guidance through a sophisticated multi-stage process:

1. **Finding Detection** - HTTP audit identifies security, performance, and compliance issues
2. **Template Matching** - Each finding type maps to a pre-built JSON template
3. **Framework Detection** - HTTP headers reveal application technology stack
4. **Content Generation** - Two-tier model creates understanding (all) + action (implementers)
5. **Audience Targeting** - Recommendations customized for 6 different roles
6. **Report Integration** - Guidance embedded in comprehensive diagnostic reports

This intelligent system reduces remediation time by 50%+ by providing exactly the right information to exactly the right person at exactly the right time.

---

## Related Documentation

- [mAi Advisor™ Guide](Doc-mAi-Advisor.md) - Comprehensive advisor documentation
- [HTTP Security Assessment](Doc-HTTP-Assessment.md) - HTTP audit details
- [Architecture Overview](Diagram-Architecture.md) - Framework architecture
- [Diagrams Hub](Diagrams.md) - All framework diagrams
- [API Documentation](../../../../../target/site/index.html) - JavaDocs

---

**Version**: 1.0.0  
**Last Updated**: 2025-10-30 01:15:00 PM CDT  
**Copyright** © 2025 MissionWares. All Rights Reserved.