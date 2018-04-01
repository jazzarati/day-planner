#!/bin/sh

echo "Cleaning generated files..."
rm planner.jar
rm -rf out

echo "Building..."
mkdir -p out
javac -d out $(find ./src/main/ -name '*.java')
jar cfm planner.jar Manifest.txt -C out .

echo "Cleaning up..."
rm -rf out