# CDAC PGCHPCSA: Hadoop Administration (April 2026)

![MITU Skillologies Logo](https://mituskillologies.in/images/logo.png) 

Welcome to the official repository for the **Hadoop Administration** module conducted for the PGCHPCSA (Post Graduate Certificate in High Performance Computing System Administration) batch at CDAC-ACTS, Pune. 

These sessions were delivered by **Tushar B. Kute** in April 2026. True to our training philosophy, the materials reflect a highly hands-on approach (90% practical, 10% theory) focused on real-world implementation.

## 👨‍🏫 Instructor
**Tushar B. Kute**  
*Sr. Data Scientist & Researcher, MITU Research*

## 📚 Resources & Presentations
* **Slide Decks & Theory Materials:** [mitu.co.in/big-data-presentations](http://mitu.co.in/big-data-presentations)

## 📂 Repository Structure

The repository is completely Java-based (100%) and contains the MapReduce and Hadoop administration programs covered during the practical sessions. The file structure is organized as follows:

* 📁 `01 Java Programs/` - Core Java implementations and MapReduce foundational code.
* 📁 `emp/` - MapReduce programs, datasets, and scripts related to employee data analytics.
* 📁 `sales/` - Practical implementations focusing on sales data processing and big data analytics.
* 📁 `temp/` - MapReduce jobs for processing temperature datasets (e.g., finding maximum/minimum temperatures).

## 🛠️ Topics Covered
* Big Data & Big Data Analytics
* Hadoop Administration
* MapReduce Framework
* Java Programming for Hadoop

## 🚀 Getting Started

1. Clone this repository to your Hadoop NameNode or local machine:
   ```bash
   git clone [https://github.com/mituskillologies/cdac-pgchpcsa-hadoop-apr26.git](https://github.com/mituskillologies/cdac-pgchpcsa-hadoop-apr26.git)

    Navigate to the working directory:
    Bash

    cd cdac-pgchpcsa-hadoop-apr26

    Compile the Java files and create JARs to run the MapReduce jobs on your Hadoop cluster:
    Bash

    # Example standard compilation and execution flow
    hadoop com.sun.tools.javac.Main <ProgramName>.java
    jar cf <ProgramName>.jar <ProgramName>*.class
    hadoop jar <ProgramName>.jar <ProgramName> /input_path /output_path

🏢 About the Organization

**MITU Skillologies, Pune
**
Empowering through Practical Education

Connect With Us:

    Website: https://mitu.co.in
    Email: contact@mitu.co.in
