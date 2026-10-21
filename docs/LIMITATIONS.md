# Submission limitations
- Native Astah: the installed API saved an empty probe, but model editing terminated
  with status 1 before creating usable diagrams. The probe is excluded.
  Editable DOT and viewable PNG/SVG diagrams are included. They are not .astah files.
  Open Astah, recreate the supplied models and save/export in the format accepted
  by the lecturer. The installed version uses .asta; do not rename DOT/ZIP files to .astah.
- Eclipse: project metadata and debugging steps are included; no interactive session
  or screenshots are claimed.
- Java: Oracle JDK 21.0.12.1 compiled all 21 current sources using --release 8.
  Ordinary javac file output failed in this sandbox; the checked-in in-memory
  compiler harness ran the same compiler and test mains successfully.
- Performance: timings vary with JVM, heap, JIT and hardware. No production benchmark
  or intentional machine hang was performed.
- Scope: full commerce features in the requirement diagram are future requirements.
  Only the Lab02/Lab03 programming exercises are implemented.
