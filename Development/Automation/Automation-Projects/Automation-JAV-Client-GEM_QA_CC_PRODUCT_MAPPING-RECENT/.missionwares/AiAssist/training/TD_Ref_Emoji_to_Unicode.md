<!-- ===============================================================
@file: TD_Ref_Emoji_to_Unicode.md
@filepath: TD_Ref_Emoji_to_Unicode.md
@version: 1.0.0
@created: 2025-10-30 11:45:00 AM CDT
@updated: 2025-10-30 11:50:00 AM CDT
@author: Greg Paskal & Claude (Anthropic)
@company: MissionWares

@description:
Reference table for emoji-to-unicode mappings used in mAi Automation Framework
documentation. Provides quick lookup for fixing corrupted unicode sequences that
occur during file encoding mismatches. Each emoji includes its unicode code point,
hex representation, corrupted form (when observed), description, and typical usage
context within documentation.

@purpose:
Enable AI assistants and developers to quickly translate between corrupted unicode
sequences and proper emoji characters when creating or fixing documentation files.
Serves as authoritative reference for consistent emoji usage across all framework
documentation.

@tags: emoji, unicode, reference, encoding, documentation, mAiâ„¢
=============================================================== -->

# Emoji to Unicode Reference

**Purpose**: Quick reference for translating corrupted unicode sequences to proper emojis in documentation files.

**Use Case**: When Claude or other AI tools generate corrupted unicode (e.g., `ðŸ"–` instead of 📖), use this table to identify and fix the proper emoji character.

---

## Standard Documentation Emojis

| Emoji | Unicode | Hex Code | Description | Corrupted Form | Usage Context |
|-------|---------|----------|-------------|----------------|---------------|
| 📖 | U+1F4D6 | `\U0001F4D6` | Book | `ðŸ"–` | Documentation, overview, reading |
| 🛠️ | U+1F6E0 | `\U0001F6E0` | Tools (Hammer & Wrench) | `ðŸ› ï¸` | Setup, configuration, tools |
| ✏️ | U+270F | `\U0000270F` | Pencil | `âœï¸` | Writing, development, editing |
| ▶️ | U+25B6 | `\U000025B6` | Play Button | `â–¶ï¸` | Execution, running, start |
| 🎯 | U+1F3AF | `\U0001F3AF` | Target (Bullseye) | `ðŸŽ¯` | Goals, objectives, key items |
| 🗝️ | U+1F5DD | `\U0001F5DD` | Key | `ðŸ—ï¸` | Architecture, core concepts |
| 🧠 | U+1F9E0 | `\U0001F9E0` | Brain | `ðŸ§ ` | Intelligence, AI, smart features |
| 🔒 | U+1F512 | `\U0001F512` | Lock | `ðŸ"'` | Security, authentication, private |
| 🌐 | U+1F310 | `\U0001F310` | Globe with Meridians | `ðŸŒ` | Network, global, web |

---

## Status & Priority Emojis

| Emoji | Unicode | Hex Code | Description | Corrupted Form | Usage Context |
|-------|---------|----------|-------------|----------------|---------------|
| ✅ | U+2705 | `\U00002705` | Check Mark Button | `âœ…` | Completed tasks, success |
| ⚠️ | U+26A0 | `\U000026A0` | Warning | `âš ï¸` | Warnings, cautions, attention |
| ❌ | U+274C | `\U0000274C` | Cross Mark | `âŒ` | Failed, errors, incorrect |
| 🔴 | U+1F534 | `\U0001F534` | Red Circle | `ðŸ"´` | Critical priority, urgent |
| 🟡 | U+1F7E1 | `\U0001F7E1` | Yellow Circle | `ðŸŸ¡` | Medium priority, moderate |
| 🟢 | U+1F7E2 | `\U0001F7E2` | Green Circle | `ðŸŸ¢` | Low priority, optional |
| 🔵 | U+1F535 | `\U0001F535` | Blue Circle | `ðŸ"µ` | Final, informational, complete |

---

## Action & Process Emojis

| Emoji | Unicode | Hex Code | Description | Corrupted Form | Usage Context |
|-------|---------|----------|-------------|----------------|---------------|
| 🚀 | U+1F680 | `\U0001F680` | Rocket | `ðŸš€` | Speed, deployment, launch |
| ⏱️ | U+23F1 | `\U000023F1` | Stopwatch | `âï¸` | Timing, performance, duration |
| 📊 | U+1F4CA | `\U0001F4CA` | Bar Chart | `ðŸ"Š` | Statistics, metrics, analytics |
| 📋 | U+1F4CB | `\U0001F4CB` | Clipboard | `ðŸ"‹` | Tasks, TODO lists, tracking |
| 🏁 | U+1F3C1 | `\U0001F3C1` | Checkered Flag | `ðŸ` | Completion, finish, goal reached |
| 💡 | U+1F4A1 | `\U0001F4A1` | Light Bulb | `ðŸ'¡` | Ideas, tips, insights |
| ⚡ | U+26A1 | `\U000026A1` | High Voltage | `âš¡` | Fast, powerful, quick action |

---

**Note**: Corruption occurs due to UTF-8 encoding mismatches. Always ensure files are created and read with UTF-8 encoding to prevent these issues.

**Version**: 1.0.0  
**Last Updated**: 2025-10-30 11:50:00 AM CDT