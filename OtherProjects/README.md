# OtherProjects
Lab01 exercises have been migrated to hust.soict.dsai.lab01.
String/memory exercises live in hust.soict.dsai.garbage.
Compile through ../scripts/test.ps1 or ../scripts/test.sh.
Run for example:
`java -cp build/classes hust.soict.dsai.lab01.TriangleStars`
`java -Xmx128m -cp build/classes hust.soict.dsai.garbage.ConcatenationInLoops 65536`
`java -Xmx128m -cp build/classes hust.soict.dsai.garbage.GarbageCreator sample.bin`
`java -Xmx128m -cp build/classes hust.soict.dsai.garbage.NoGarbage sample.bin`

GarbageCreator is deliberately inefficient. NoGarbage uses chunked input and
StringBuffer. Both map unsigned bytes to characters identically.
ChoosingOption requires a graphical desktop and is compiled but not automatically run.
