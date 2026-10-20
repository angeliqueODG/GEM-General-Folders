# Documentation Assets

This folder contains all images, diagrams, and other media files used in the mAi™ Framework documentation.

---

## Folder Structure

```
_assets/
├── README.md                    ← You are here
├── shared/                      ← Assets used across multiple docs
│   ├── logo.png
│   ├── favicon.ico
│   └── missionwares-badge.svg
├── diagrams/                    ← Architecture and flow diagrams
│   ├── architecture-overview.svg
│   └── data-flow.svg
├── Doc-Setup/                   ← Assets for Doc-Setup.html
│   ├── autotools-terminal.png
│   └── vscode-extensions.png
├── Doc-HTTP-Assessment/         ← Assets for Doc-HTTP-Assessment.html
│   ├── report-executive.png
│   └── severity-legend.png
└── [Doc-Name]/                  ← One folder per document
    └── ...
```

---

## Naming Conventions

### Folder Names

| Type | Convention | Example |
|------|------------|---------|
| Document-specific | Match HTML filename (without extension) | `Doc-Setup/`, `Guide-For-DevOps/` |
| Shared assets | `shared/` | `shared/logo.png` |
| Diagrams | `diagrams/` | `diagrams/architecture.svg` |

### File Names

- **Use lowercase** with hyphens: `autotools-terminal-output.png`
- **Be descriptive**: `vscode-extensions-panel.png` not `img1.png`
- **Include context** when useful: `step-03-maven-install.png`
- **No spaces**: Use hyphens instead

### Image Formats

| Format | Use Case |
|--------|----------|
| `.png` | Screenshots, UI elements, anything with text |
| `.jpg` | Photos, complex images where file size matters |
| `.svg` | Diagrams, icons, logos (scalable, small file size) |
| `.gif` | Simple animations (use sparingly) |

---

## Usage in HTML

### Basic Image

```html
<img src="_assets/Doc-Setup/terminal-output.png" 
     alt="Terminal showing successful Maven build"
     class="doc-image">
```

### Image with Shadow (for screenshots)

```html
<img src="_assets/Doc-Setup/vscode-extensions.png" 
     alt="VSCode extensions panel"
     class="doc-image shadow">
```

### Image with Caption

```html
<figure>
    <img src="_assets/Doc-Setup/project-structure.png" 
         alt="Project folder structure in Finder"
         class="doc-image shadow">
    <figcaption>Recommended project folder structure</figcaption>
</figure>
```

### Centered Small Image

```html
<img src="_assets/shared/logo.png" 
     alt="mAi Framework logo"
     class="doc-image small centered">
```

### Screenshot with Container

```html
<div class="screenshot-container">
    <img src="_assets/Doc-HTTP-Assessment/report-example.png" 
         alt="HTTP Assessment report example">
    <div class="caption">Example security report for www.example.com</div>
</div>
```

### Side-by-Side Images (Gallery)

```html
<div class="image-gallery">
    <figure>
        <img src="_assets/Doc-Setup/step-1.png" alt="Step 1">
        <figcaption>Clone the repository</figcaption>
    </figure>
    <figure>
        <img src="_assets/Doc-Setup/step-2.png" alt="Step 2">
        <figcaption>Run the installer</figcaption>
    </figure>
</div>
```

### Before/After Comparison

```html
<div class="image-compare">
    <figure>
        <span class="label before">Before</span>
        <img src="_assets/Doc-Example/before.png" alt="Before optimization">
    </figure>
    <figure>
        <span class="label after">After</span>
        <img src="_assets/Doc-Example/after.png" alt="After optimization">
    </figure>
</div>
```

---

## Available CSS Classes

| Class | Effect |
|-------|--------|
| `doc-image` | Base styling: max-width 100%, rounded corners, border |
| `shadow` | Adds drop shadow (good for screenshots) |
| `centered` | Centers the image horizontally |
| `small` | Limits to 50% width |
| `medium` | Limits to 75% width |

---

## Best Practices

### Screenshot Guidelines

1. **Crop tightly** - Remove unnecessary empty space
2. **Highlight focus areas** - Use system screenshot tools to add annotations if needed
3. **Consistent sizing** - Try to keep similar screenshots at similar dimensions
4. **Retina-ready** - Capture at 2x resolution when possible (macOS does this by default)

### Alt Text

Always provide meaningful `alt` text:

```html
<!-- ✗ Bad -->
<img src="screenshot.png" alt="screenshot">

<!-- ✓ Good -->
<img src="screenshot.png" alt="Terminal window showing 'mvn clean install' command completing successfully">
```

### File Size

- **Target**: Under 200KB per image
- **Screenshots**: Use PNG, compress with tools like [TinyPNG](https://tinypng.com/)
- **Diagrams**: Prefer SVG when possible (scales perfectly, tiny file size)

---

## Adding New Assets

1. **Create folder** if it doesn't exist: `_assets/Your-Doc-Name/`
2. **Name file** descriptively: `feature-overview-diagram.png`
3. **Add to HTML** using appropriate class
4. **Test** by viewing the page in a browser

---

## Diagram Sources

If you're creating diagrams, consider keeping source files (like `.drawio`, `.sketch`, or `.fig` files) in a separate location or with a `_source` suffix:

```
_assets/diagrams/
├── architecture-overview.svg       ← Published diagram
├── architecture-overview.drawio    ← Source file (optional)
└── data-flow.svg
```

---

**Version**: 1.0.0  
**Last Updated**: 2025-12-01  
© 2025 MissionWares. All Rights Reserved.