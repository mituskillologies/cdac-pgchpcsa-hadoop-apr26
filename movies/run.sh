#!/bin/bash

# 1. Validate the number of arguments
if [ "$#" -ne 3 ]; then
    echo "Error: Incorrect number of arguments."
    echo "Usage: ./run.sh <Java file> <HDFS input folder> <HDFS output folder>"
    exit 1
fi

JAVA_FILE=$1
HDFS_INPUT=$2
HDFS_OUTPUT=$3

# Extract the class name by removing the .java extension
CLASS_NAME=$(basename "$JAVA_FILE" .java)

echo "========== Step 1: Compiling $JAVA_FILE =========="
# Compiling the Java file. ".:*" includes local jars (like your Hadoop core library) in the classpath.
javac -cp hadoop-core-1.2.1.jar "$JAVA_FILE"

if [ $? -ne 0 ]; then
    echo "Error: Compilation failed. Please check your Java syntax and libraries."
    exit 1
fi

echo -e "\n========== Step 2: Creating JAR file =========="
# Package the compiled .class files into a JAR
jar -cvf "${CLASS_NAME}.jar" *.class

echo -e "\n========== Step 3: Cleaning HDFS Output Directory =========="
# Hadoop will throw an error if the output directory already exists. This removes it safely.
hadoop fs -rm -r -f "$HDFS_OUTPUT"

echo -e "\n========== Step 4: Running MapReduce Job =========="
# Execute the job on the cluster

hadoop jar "${CLASS_NAME}.jar" "$CLASS_NAME" "$HDFS_INPUT" "$HDFS_OUTPUT"

if [ $? -ne 0 ]; then
    echo "Error: MapReduce job failed during execution."
    exit 1
fi

echo -e "\n========== Step 5: Generated Output =========="
# Fetch and print the results from HDFS to the screen
hadoop fs -cat "$HDFS_OUTPUT/part-r-00000"

echo -e "\nJob completed successfully!"
