# AIMS - OOP Lab03
Submission branch: **release/lab03**.

| Directory | Purpose |
| --- | --- |
| AimsProject | Current Lab02 + Lab03 implementation, answers, requirements and design |
| OtherProjects | Packaged Lab01 exercises and Lab03 string/memory exercises |
| Lab01, Lab02 | Preserved earlier snapshots |
| scripts | Repeatable compilation and regression tests |
| docs | Actual test log and remaining submission limitations |

## Run
With JDK 9+ (the scripts target Java 8):
- PowerShell: `./scripts/test.ps1`
- Linux/macOS: `sh scripts/test.sh`
- Sandbox fallback: `java -Xmx128m scripts/CompileAndTest.java .`
- Demo after ordinary compilation: `java -cp build/classes hust.soict.dsai.aims.Aims`

For Eclipse, import AimsProject and OtherProjects as existing projects.
See [Lab03 answers](AimsProject/answers.txt) and [limitations](docs/LIMITATIONS.md).

The title matching rule follows the supplied Lab02: ANY query word contained in
the title, ignoring case. Varargs supports both array and arbitrary-argument calls.
Diagrams include PNG, SVG and editable DOT. Native Astah and Eclipse screenshot
requirements remain manual; no valid native .astah file is claimed.
