#!/bin/sh
set -eu
cd "$(dirname "$0")/.."
mkdir -p build/classes
find AimsProject/src OtherProjects/src -name '*.java' > build/sources.txt
javac --release 8 -encoding UTF-8 -Xlint:all,-options -d build/classes @build/sources.txt
for test in hust.soict.dsai.test.cart.CartTest hust.soict.dsai.test.store.StoreTest hust.soict.dsai.test.disc.DiscTest hust.soict.dsai.test.disc.TestPassingParameter hust.soict.dsai.garbage.GarbageTest hust.soict.dsai.aims.Aims; do
 java -Xmx128m -cp build/classes "$test"
done
java -Xmx128m -cp build/classes hust.soict.dsai.garbage.ConcatenationInLoops 12000
