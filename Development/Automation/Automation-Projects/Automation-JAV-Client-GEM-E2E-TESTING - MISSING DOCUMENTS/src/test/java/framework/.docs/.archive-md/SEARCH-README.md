# Documentation Search - Powered by Pagefind

This documentation uses [Pagefind](https://pagefind.app/), a fully static search engine that runs entirely in the browser with no external services.

---

## How It Works

```
┌──────────────────────────────────────────────────────────────────────────────┐
│  1. You edit HTML files                                                       │
├──────────────────────────────────────────────────────────────────────────────┤
│                              ↓                                                │
├──────────────────────────────────────────────────────────────────────────────┤
│  2. Run from project root:                                                    │
│     npx pagefind --site "src/test/java/framework/.docs"                       │
│     (Creates pagefind/ folder with search index)                              │
├──────────────────────────────────────────────────────────────────────────────┤
│                              ↓                                                │
├──────────────────────────────────────────────────────────────────────────────┤
│  3. Search works! (locally or hosted)                                         │
└──────────────────────────────────────────────────────────────────────────────┘
```

---

## Installation (One Time)

### npm / npx (Recommended)

No installation required. Just run with `npx`:

```bash
npx pagefind --site "src/test/java/framework/.docs"
```

Or install globally if preferred:

```bash
npm install -g pagefind
```

### Verify Installation

```bash
npx pagefind --version
```

---

## Building the Search Index

After creating or editing any HTML files, rebuild the search index **from the project root**:

```bash
npx pagefind --site "src/test/java/framework/.docs"
```

**Output:**

```
Running Pagefind v1.4.0 (Extended)
Running from: "/path/to/Automation-JAV-mAi"
Source:       "src/test/java/framework/.docs"
Building search index...
  Indexed 6 pages
  Indexed 545 words

Output: src/test/java/framework/.docs/pagefind/
```

---

## What Gets Indexed

Pagefind automatically indexes content in `<main data-pagefind-body>` tags.

### Indexed

- All text content in `<main>`
- Headings (`<h1>`, `<h2>`, `<h3>`, etc.) — weighted higher in results
- Code blocks
- Table content
- List items

### Not Indexed (by design)

- Navigation sidebar (`data-pagefind-ignore`)
- Footer (`data-pagefind-ignore`)
- Help links (`data-pagefind-ignore`)
- The `_Template.html` file (excluded by default)

---

## Workflow Summary

### Creating a New Page

1. Copy `_Template.html` to `Doc-YourTopic.html`
2. Edit content
3. Add entry to `docs-config.js`
4. Run `npx pagefind --site "src/test/java/framework/.docs"`
5. Test search

### Editing an Existing Page

1. Edit the HTML file
2. Run `npx pagefind --site "src/test/java/framework/.docs"`
3. Done — search index is updated

### Deploying

Upload the entire `.docs/` folder contents including:

- All `.html` files
- `docs-style.css`
- `docs-config.js`
- `docs-nav.js`
- `_assets/` folder
- `pagefind/` folder ← **Required for search**

---

## Advanced Options

### Exclude Specific Content

Add `data-pagefind-ignore` to any element you don't want indexed:

```html
<div data-pagefind-ignore>
    This content won't appear in search results.
</div>
```

### Add Metadata to Search Results

```html
<h1 data-pagefind-meta="title">Page Title</h1>
```

### Custom Weight for Important Content

```html
<p data-pagefind-weight="2">This paragraph ranks higher in results.</p>
```

### Index Specific Sections Only

```html
<article data-pagefind-body>
    Only this article content gets indexed.
</article>
```

---

## Troubleshooting

### Search Input Says "run pagefind to enable"

The `pagefind/` folder doesn't exist. Run from project root:

```bash
npx pagefind --site "src/test/java/framework/.docs"
```

### Search Returns No Results

1. Verify `pagefind/` folder exists in `.docs/`
2. Check that pages have `data-pagefind-body` on `<main>`
3. Rebuild index: `npx pagefind --site "src/test/java/framework/.docs"`

### Search Works Locally But Not on Server

Ensure you uploaded the entire `pagefind/` folder to your server.

### CORS Errors When Running Locally via file://

Some browsers restrict JavaScript loading from `file://` URLs. Solutions:

1. **Use a local server** (recommended):
   ```bash
   # Python 3 - run from .docs folder
   cd src/test/java/framework/.docs
   python -m http.server 8000
   # Then visit http://localhost:8000
   ```

2. **Or use VS Code Live Server extension**

3. **Or open Chrome with flags** (not recommended for daily use):
   ```bash
   open -a "Google Chrome" --args --allow-file-access-from-files
   ```

---

## File Structure

After running Pagefind, your project structure looks like:

```
Automation-JAV-mAi/                    ← Run npx pagefind from here
├── src/test/java/framework/.docs/
│   ├── _assets/                            ← Images, diagrams
│   ├── pagefind/                           ← Generated by Pagefind (DO NOT EDIT)
│   │   ├── pagefind.js
│   │   ├── pagefind-ui.js
│   │   ├── pagefind-ui.css
│   │   ├── pagefind-entry.json
│   │   ├── fragment/
│   │   └── index/
│   ├── docs-style.css                      ← Shared styles
│   ├── docs-config.js                      ← Navigation config
│   ├── docs-nav.js                         ← Sidebar generator
│   ├── _Template.html                      ← Template for new pages
│   ├── Home.html
│   ├── Doc-Setup.html
│   ├── Doc-Overview.html
│   └── ...
└── pom.xml
```

---

## Resources

- [Pagefind Documentation](https://pagefind.app/)
- [Pagefind UI Configuration](https://pagefind.app/docs/ui/)
- [Pagefind Indexing Options](https://pagefind.app/docs/indexing/)
- [Pagefind GitHub](https://github.com/CloudCannon/pagefind)

---

**Version**: 1.0.0  
**Last Updated**: 2025-12-01  
© 2025 MissionWares. All Rights Reserved.