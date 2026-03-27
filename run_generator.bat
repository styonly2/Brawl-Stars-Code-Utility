@echo off
title Brawl Stars Hunter - Build Tool
chcp 65001 >nul

echo [1/3] Компиляция...
javac -encoding UTF-8 *.java

echo [2/3] Создание манифеста...
echo Main-Class: CodeGenerator > manifest.txt

echo [3/3] Сборка JAR-пакета...
jar cvfm BrawlHunter.jar manifest.txt *.class
del manifest.txt
del *.class

echo -----------------------------------
echo ГОТОВО! Создан файл: BrawlHunter.jar
echo -----------------------------------
pause