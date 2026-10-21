$ErrorActionPreference = 'Stop'
Set-Location (Split-Path $PSScriptRoot -Parent)
New-Item -ItemType Directory -Force build/classes | Out-Null
$sources = @(Get-ChildItem AimsProject/src,OtherProjects/src -Recurse -Filter *.java | ForEach-Object FullName)
javac --release 8 -encoding UTF-8 -Xlint:all,-options -d build/classes $sources
if ($LASTEXITCODE -ne 0) { throw 'Compilation failed' }
$tests = @('hust.soict.dsai.test.cart.CartTest','hust.soict.dsai.test.store.StoreTest','hust.soict.dsai.test.disc.DiscTest','hust.soict.dsai.test.disc.TestPassingParameter','hust.soict.dsai.garbage.GarbageTest','hust.soict.dsai.aims.Aims')
foreach ($test in $tests) {
    java -Xmx128m -cp build/classes $test
    if ($LASTEXITCODE -ne 0) { throw "Failed: $test" }
}
java -Xmx128m -cp build/classes hust.soict.dsai.garbage.ConcatenationInLoops 12000
if ($LASTEXITCODE -ne 0) { throw 'Concatenation failed' }
