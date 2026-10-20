package framework.utilities;

// ===============================================================
// @file: FW_MarkdownUtils.java
// @filepath: src/test/java/framework/utilities/FW_MarkdownUtils.java
// @version: 1.1.0
// @updated: 2025-10-27 09:01:00 PM CDT
// @author: Greg Paskal
// @company: MissionWares
//
// @description:
// Utility class for generating well-formatted Markdown content. Provides a
// comprehensive set of methods for creating headings, tables, code blocks,
// lists, formatting, emojis, and other markdown elements. Designed to be used
// by report generators (FW_HttpReporter, FW_HttpDiagnosticReporter) to
// produce consistent, clean markdown output. All methods return formatted
// strings that can be appended to StringBuilder or String objects. Handles
// edge cases, null safety, and markdown escaping automatically.
//
// @responsibilities:
// - Generate markdown headings (h1, h2, h3, h4)
// - Create formatted tables (headers, rows, dividers)
// - Format code blocks (multi-line and inline)
// - Build lists (bullet and numbered)
// - Apply text formatting (bold, italic, links)
// - Provide status and severity emojis
// - Create dividers and horizontal rules
// - Utility functions (escape, truncate, format bytes/duration)
//
// @dependencies:
// - java.util.List
// - java.util.Map
//
// @methods:
// Headings: h1(), h2(), h3(), h4()
// Tables: tableHeader(), tableAlignment(), tableRow(), tableDivider()
// Code: codeBlock(), inlineCode()
// Lists: bulletList(), numberedList()
// Formatting: bold(), italic(), link()
// Emojis: statusEmoji(), severityEmoji()
// Dividers: horizontalRule(), sectionDivider()
// Utilities: escapeMarkdown(), truncate(), formatBytes(), formatDuration()
//
// @tags: markdown, utility, reporting, formatting, documentation, mAi™
//
// @changeLog:
// Date        Author          Version  Description
// ----------  --------------  -------  --------------------------
// 2025-10-27  G. Paskal       1.0.0    Initial creation - comprehensive markdown utility
// 2025-10-27  G. Paskal       1.1.0    Added tableAlignment() for intuitive table formatting
// ===============================================================

import java.util.List;

/**
 * Utility class for generating well-formatted Markdown content.
 * Provides methods for creating headings, tables, code blocks, lists,
 * formatting, emojis, and other markdown elements.
 */
public class FW_MarkdownUtils {
    
    // ===== HEADING METHODS =====
    
    /**
     * Creates a level 1 heading (# heading).
     * 
     * @param text The heading text
     * @return Formatted h1 heading with newline
     */
    public static String h1(String text) {
        if (text == null || text.isEmpty()) return "";
        return "# " + text + "\n\n";
    }
    
    /**
     * Creates a level 2 heading (## heading).
     * 
     * @param text The heading text
     * @return Formatted h2 heading with newline
     */
    public static String h2(String text) {
        if (text == null || text.isEmpty()) return "";
        return "## " + text + "\n\n";
    }
    
    /**
     * Creates a level 3 heading (### heading).
     * 
     * @param text The heading text
     * @return Formatted h3 heading with newline
     */
    public static String h3(String text) {
        if (text == null || text.isEmpty()) return "";
        return "### " + text + "\n\n";
    }
    
    /**
     * Creates a level 4 heading (#### heading).
     * 
     * @param text The heading text
     * @return Formatted h4 heading with newline
     */
    public static String h4(String text) {
        if (text == null || text.isEmpty()) return "";
        return "#### " + text + "\n\n";
    }
    
    // ===== TABLE METHODS =====
    
    /**
     * Creates a table header row with specified columns.
     * Automatically adds separator row below header.
     * 
     * @param columns The header column names
     * @return Formatted table header with separator
     */
    public static String tableHeader(String... columns) {
        if (columns == null || columns.length == 0) return "";
        
        StringBuilder header = new StringBuilder();
        StringBuilder separator = new StringBuilder();
        
        // Build header row
        header.append("|");
        separator.append("|");
        for (String column : columns) {
            header.append(" ").append(column != null ? column : "").append(" |");
            separator.append("------|");
        }
        
        return header.append("\n").append(separator).append("\n").toString();
    }
    
    /**
     * Creates a table header row with specified columns and custom alignment.
     * 
     * @param columns The header column names
     * @param alignments Alignment for each column ("left", "center", "right")
     * @return Formatted table header with aligned separator
     */
    public static String tableHeader(String[] columns, String[] alignments) {
        if (columns == null || columns.length == 0) return "";
        
        StringBuilder header = new StringBuilder();
        StringBuilder separator = new StringBuilder();
        
        // Build header row
        header.append("|");
        separator.append("|");
        for (int i = 0; i < columns.length; i++) {
            header.append(" ").append(columns[i] != null ? columns[i] : "").append(" |");
            
            // Build separator with alignment
            String alignment = alignments != null && i < alignments.length ? alignments[i] : "left";
            if ("center".equalsIgnoreCase(alignment)) {
                separator.append(":------:");
            } else if ("right".equalsIgnoreCase(alignment)) {
                separator.append("------:");
            } else {
                separator.append("------|");
            }
        }
        
        return header.append("\n").append(separator).append("\n").toString();
    }
    
    /**
     * Creates a table row with specified cell values.
     * 
     * @param cells The cell values for the row
     * @return Formatted table row
     */
    public static String tableRow(String... cells) {
        if (cells == null || cells.length == 0) return "";
        
        StringBuilder row = new StringBuilder("|");
        for (String cell : cells) {
            row.append(" ").append(cell != null ? cell : "").append(" |");
        }
        
        return row.append("\n").toString();
    }
    
    /**
     * Creates a table alignment separator row with specified column alignments.
     * This method provides an intuitive way to add alignment after tableHeader() call.
     * Supports "left", "center", and "right" alignment for each column.
     * 
     * <p>Usage example:
     * <pre>
     * report.append(FW_MarkdownUtils.tableHeader("Name", "Value", "Status"));
     * report.append(FW_MarkdownUtils.tableAlignment("left", "center", "right"));
     * report.append(FW_MarkdownUtils.tableRow("Item1", "100", "✅"));
     * </pre>
     * 
     * @param alignments Column alignment values ("left", "center", "right")
     * @return Formatted alignment separator row
     */
    public static String tableAlignment(String... alignments) {
        if (alignments == null || alignments.length == 0) return "";
        
        StringBuilder separator = new StringBuilder("|");
        for (String alignment : alignments) {
            if (alignment == null) {
                separator.append("------|");
            } else if ("center".equalsIgnoreCase(alignment)) {
                separator.append(":------:|");
            } else if ("right".equalsIgnoreCase(alignment)) {
                separator.append("------:|");
            } else {
                separator.append("------|");
            }
        }
        
        return separator.append("\n").toString();
    }
    
    /**
     * Creates a table divider (horizontal rule within table context).
     * Useful for grouping rows visually.
     * 
     * @param columnCount Number of columns in the table
     * @return Formatted table divider row
     */
    public static String tableDivider(int columnCount) {
        if (columnCount <= 0) return "";
        
        StringBuilder divider = new StringBuilder("|");
        for (int i = 0; i < columnCount; i++) {
            divider.append("------|");
        }
        
        return divider.append("\n").toString();
    }
    
    // ===== CODE BLOCK METHODS =====
    
    /**
     * Creates a code block with optional language syntax highlighting.
     * 
     * @param code The code content
     * @param language The language for syntax highlighting (e.g., "java", "json", "bash")
     * @return Formatted code block
     */
    public static String codeBlock(String code, String language) {
        if (code == null || code.isEmpty()) return "";
        
        StringBuilder block = new StringBuilder();
        block.append("```");
        if (language != null && !language.isEmpty()) {
            block.append(language);
        }
        block.append("\n");
        block.append(code);
        if (!code.endsWith("\n")) {
            block.append("\n");
        }
        block.append("```\n\n");
        
        return block.toString();
    }
    
    /**
     * Creates a code block without language specification.
     * 
     * @param code The code content
     * @return Formatted code block
     */
    public static String codeBlock(String code) {
        return codeBlock(code, null);
    }
    
    /**
     * Creates inline code formatting.
     * 
     * @param code The code text to format
     * @return Text wrapped in backticks
     */
    public static String inlineCode(String code) {
        if (code == null || code.isEmpty()) return "";
        return "`" + code + "`";
    }
    
    // ===== LIST METHODS =====
    
    /**
     * Creates a bullet list from a list of items.
     * 
     * @param items The list items
     * @return Formatted bullet list
     */
    public static String bulletList(List<String> items) {
        if (items == null || items.isEmpty()) return "";
        
        StringBuilder list = new StringBuilder();
        for (String item : items) {
            if (item != null && !item.isEmpty()) {
                list.append("- ").append(item).append("\n");
            }
        }
        list.append("\n");
        
        return list.toString();
    }
    
    /**
     * Creates a bullet list from an array of items.
     * 
     * @param items The list items
     * @return Formatted bullet list
     */
    public static String bulletList(String... items) {
        if (items == null || items.length == 0) return "";
        
        StringBuilder list = new StringBuilder();
        for (String item : items) {
            if (item != null && !item.isEmpty()) {
                list.append("- ").append(item).append("\n");
            }
        }
        list.append("\n");
        
        return list.toString();
    }
    
    /**
     * Creates a numbered list from a list of items.
     * 
     * @param items The list items
     * @return Formatted numbered list
     */
    public static String numberedList(List<String> items) {
        if (items == null || items.isEmpty()) return "";
        
        StringBuilder list = new StringBuilder();
        int number = 1;
        for (String item : items) {
            if (item != null && !item.isEmpty()) {
                list.append(number++).append(". ").append(item).append("\n");
            }
        }
        list.append("\n");
        
        return list.toString();
    }
    
    /**
     * Creates a numbered list from an array of items.
     * 
     * @param items The list items
     * @return Formatted numbered list
     */
    public static String numberedList(String... items) {
        if (items == null || items.length == 0) return "";
        
        StringBuilder list = new StringBuilder();
        int number = 1;
        for (String item : items) {
            if (item != null && !item.isEmpty()) {
                list.append(number++).append(". ").append(item).append("\n");
            }
        }
        list.append("\n");
        
        return list.toString();
    }
    
    // ===== FORMATTING METHODS =====
    
    /**
     * Applies bold formatting to text.
     * 
     * @param text The text to format
     * @return Text wrapped in bold markers
     */
    public static String bold(String text) {
        if (text == null || text.isEmpty()) return "";
        return "**" + text + "**";
    }
    
    /**
     * Applies italic formatting to text.
     * 
     * @param text The text to format
     * @return Text wrapped in italic markers
     */
    public static String italic(String text) {
        if (text == null || text.isEmpty()) return "";
        return "*" + text + "*";
    }
    
    /**
     * Creates a markdown link.
     * 
     * @param text The link text
     * @param url The URL
     * @return Formatted markdown link
     */
    public static String link(String text, String url) {
        if (text == null || url == null) return "";
        return "[" + text + "](" + url + ")";
    }
    
    /**
     * Creates a markdown link with title (hover text).
     * 
     * @param text The link text
     * @param url The URL
     * @param title The title/hover text
     * @return Formatted markdown link with title
     */
    public static String link(String text, String url, String title) {
        if (text == null || url == null) return "";
        if (title == null || title.isEmpty()) {
            return link(text, url);
        }
        return "[" + text + "](" + url + " \"" + title + "\")";
    }
    
    // ===== EMOJI METHODS =====
    
    /**
     * Returns an emoji based on HTTP status code.
     * 
     * @param statusCode The HTTP status code
     * @return Appropriate emoji for the status
     */
    public static String statusEmoji(int statusCode) {
        if (statusCode >= 200 && statusCode < 300) return "✅";
        if (statusCode >= 300 && statusCode < 400) return "↩️";
        if (statusCode >= 400 && statusCode < 500) return "🔴";
        if (statusCode >= 500) return "💥";
        return "❓";
    }
    
    /**
     * Returns an emoji based on severity level.
     * 
     * @param severity The severity level (critical, high, medium, low, info)
     * @return Appropriate emoji for the severity
     */
    public static String severityEmoji(String severity) {
        if (severity == null) return "❓";
        
        return switch (severity.toLowerCase()) {
            case "critical" -> "🔴";
            case "high" -> "🟡";
            case "medium" -> "🔵";
            case "low" -> "🟢";
            case "info", "informational" -> "ℹ️";
            default -> "❓";
        };
    }
    
    /**
     * Returns an emoji based on score (0-100).
     * 
     * @param score The score value
     * @return Appropriate emoji for the score
     */
    public static String scoreEmoji(int score) {
        if (score >= 90) return "🏆";
        if (score >= 80) return "✅";
        if (score >= 60) return "🔶";
        if (score >= 40) return "⚠️";
        return "🔴";
    }
    
    /**
     * Returns an emoji based on performance duration.
     * 
     * @param durationMs Duration in milliseconds
     * @return Appropriate emoji for the performance
     */
    public static String performanceEmoji(long durationMs) {
        if (durationMs < 500) return "⚡";
        if (durationMs < 1000) return "✅";
        if (durationMs < 3000) return "🔶";
        return "🐌";
    }
    
    // ===== DIVIDER METHODS =====
    
    /**
     * Creates a horizontal rule (three dashes).
     * 
     * @return Markdown horizontal rule
     */
    public static String horizontalRule() {
        return "---\n\n";
    }
    
    /**
     * Creates a section divider with optional title.
     * 
     * @param title Optional title for the section
     * @return Formatted section divider
     */
    public static String sectionDivider(String title) {
        StringBuilder divider = new StringBuilder();
        divider.append("\n---\n\n");
        if (title != null && !title.isEmpty()) {
            divider.append("## ").append(title).append("\n\n");
        }
        return divider.toString();
    }
    
    /**
     * Creates a section divider without title.
     * 
     * @return Formatted section divider
     */
    public static String sectionDivider() {
        return sectionDivider(null);
    }
    
    // ===== UTILITY METHODS =====
    
    /**
     * Escapes special markdown characters in text.
     * Useful for displaying literal text that might contain markdown syntax.
     * 
     * @param text The text to escape
     * @return Escaped text
     */
    public static String escapeMarkdown(String text) {
        if (text == null || text.isEmpty()) return "";
        
        // Escape special markdown characters
        return text.replace("\\", "\\\\")
                   .replace("`", "\\`")
                   .replace("*", "\\*")
                   .replace("_", "\\_")
                   .replace("{", "\\{")
                   .replace("}", "\\}")
                   .replace("[", "\\[")
                   .replace("]", "\\]")
                   .replace("(", "\\(")
                   .replace(")", "\\)")
                   .replace("#", "\\#")
                   .replace("+", "\\+")
                   .replace("-", "\\-")
                   .replace(".", "\\.")
                   .replace("!", "\\!");
    }
    
    /**
     * Truncates text to a maximum length with ellipsis.
     * 
     * @param text The text to truncate
     * @param maxLength Maximum length (including ellipsis)
     * @return Truncated text
     */
    public static String truncate(String text, int maxLength) {
        if (text == null || text.isEmpty()) return "";
        if (maxLength <= 0) return "";
        if (text.length() <= maxLength) return text;
        
        return text.substring(0, maxLength - 3) + "...";
    }
    
    /**
     * Truncates text to 100 characters with ellipsis.
     * 
     * @param text The text to truncate
     * @return Truncated text
     */
    public static String truncate(String text) {
        return truncate(text, 100);
    }
    
    /**
     * Formats byte size into human-readable format.
     * 
     * @param bytes The byte count
     * @return Formatted size string (e.g., "1.5 KB", "2.3 MB")
     */
    public static String formatBytes(long bytes) {
        if (bytes < 0) return "0 B";
        if (bytes < 1024) return bytes + " B";
        if (bytes < 1024 * 1024) return String.format("%.2f KB", bytes / 1024.0);
        if (bytes < 1024 * 1024 * 1024) return String.format("%.2f MB", bytes / (1024.0 * 1024.0));
        return String.format("%.2f GB", bytes / (1024.0 * 1024.0 * 1024.0));
    }
    
    /**
     * Formats duration in milliseconds into human-readable format.
     * 
     * @param durationMs Duration in milliseconds
     * @return Formatted duration string (e.g., "1.5s", "250ms")
     */
    public static String formatDuration(long durationMs) {
        if (durationMs < 0) return "0ms";
        if (durationMs < 1000) return durationMs + "ms";
        if (durationMs < 60000) return String.format("%.2fs", durationMs / 1000.0);
        if (durationMs < 3600000) {
            long minutes = durationMs / 60000;
            long seconds = (durationMs % 60000) / 1000;
            return minutes + "m " + seconds + "s";
        }
        long hours = durationMs / 3600000;
        long minutes = (durationMs % 3600000) / 60000;
        return hours + "h " + minutes + "m";
    }
    
    /**
     * Formats duration in milliseconds into short format.
     * 
     * @param durationMs Duration in milliseconds
     * @return Formatted duration string (e.g., "1.5s", "250ms")
     */
    public static String formatDurationShort(long durationMs) {
        if (durationMs < 0) return "0ms";
        if (durationMs < 1000) return durationMs + "ms";
        return String.format("%.1fs", durationMs / 1000.0);
    }
    
    /**
     * Creates a blockquote from text.
     * 
     * @param text The text to quote
     * @return Formatted blockquote
     */
    public static String blockquote(String text) {
        if (text == null || text.isEmpty()) return "";
        
        StringBuilder quote = new StringBuilder();
        String[] lines = text.split("\n");
        for (String line : lines) {
            quote.append("> ").append(line).append("\n");
        }
        quote.append("\n");
        
        return quote.toString();
    }
    
    /**
     * Creates a badge-style text (useful for status indicators).
     * 
     * @param text The badge text
     * @param color Optional color hint (not rendered, just for semantics)
     * @return Formatted badge
     */
    public static String badge(String text, String color) {
        if (text == null || text.isEmpty()) return "";
        // Markdown doesn't have native badges, so we use bold with optional emoji
        String emoji = (color == null) ? "" : switch (color.toLowerCase()) {
            case "green", "success" -> "✅ ";
            case "red", "error", "danger" -> "🔴 ";
            case "yellow", "warning" -> "⚠️ ";
            case "blue", "info" -> "ℹ️ ";
            default -> "";
        };
        return emoji + bold(text);
    }
    
    /**
     * Creates a simple badge without color.
     * 
     * @param text The badge text
     * @return Formatted badge
     */
    public static String badge(String text) {
        return badge(text, null);
    }
    
    /**
     * Creates a definition list entry (term and definition).
     * 
     * @param term The term to define
     * @param definition The definition
     * @return Formatted definition
     */
    public static String definition(String term, String definition) {
        if (term == null || definition == null) return "";
        return bold(term) + ": " + definition + "\n\n";
    }
    
    /**
     * Creates a task list checkbox (checked or unchecked).
     * 
     * @param text The task text
     * @param checked Whether the task is checked
     * @return Formatted task list item
     */
    public static String taskListItem(String text, boolean checked) {
        if (text == null || text.isEmpty()) return "";
        return "- [" + (checked ? "x" : " ") + "] " + text + "\n";
    }
}