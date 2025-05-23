# AI-BASED-RECOMMENDATION-SYSTEM

*COMPANY*: CODTECH IT SOLUTIONS

*NAME*: PRIYANSH RATHOD

*INTERN ID*: CT04DL651

*DOMAIN*: JAVA

*DURATION*: 4 WEEKS

*MENTOR*:  NEELA SANTHOSH KUMAR 

*DESCRIPTION*:
This project is an AI-based recommendation system built using Java and Apache Mahout, designed to suggest products or content based on user preferences. The system uses collaborative filtering to analyze user-item interactions and generate personalized recommendations.

-Key Features
User-Based Recommendations: Identifies similar users and recommends items liked by those users.

Customizable Dataset: Works with CSV files containing userId, productId, and preference (rating) data.

Scalable: Can be extended to larger datasets or integrated with databases.

-Tools & Technologies Used

Java (JDK 8)	Core programming language
Apache Mahout (0.9)	Machine learning library for recommendations
Maven	Dependency management
IntelliJ IDEA	IDE for development
SLF4J	Logging framework
Windows Terminal	Running Maven commands

-Challenges Faced & Solutions

1. Dependency Conflicts & Vulnerabilities
Problem:

Maven pulled in outdated dependencies (jersey, xstream, hadoop-core) with known CVEs.

Errors like:

Provides transitive vulnerable dependency: maven:com.sun.jersey:jersey-core:1.8  
CVE-2014-3643 (XXE vulnerability)  
Solution:

Added exclusions in pom.xml to block vulnerable packages.

Used Maven Enforcer Plugin to prevent insecure dependencies.

2. CSV Parsing Errors
Problem:

Mahout’s FileDataModel failed to parse CSV headers, throwing:

NumberFormatException: For input string: "userId"  
Solution:

Removed header row from CSV or used:

java
new FileDataModel(file, false, ","); // Skip headers  
3. Java Version Mismatch
Problem:

Mahout 0.9 was designed for Java 8, but the system had Java 23.

Caused runtime errors.

Solution:

Downgraded to JDK 8 (corretto-1.8.0_452).

4. Missing SLF4J Binding
Problem:

Warning:

SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder"  
Solution:

Added slf4j-simple dependency for logging.

-New Concepts Learned

✅ Transitive Dependencies:

Learned how Maven pulls indirect dependencies and how to exclude risky ones.

✅ Collaborative Filtering:

Understood how Mahout’s UserBasedRecommender works:

Computes user similarity (Pearson correlation).

Finds nearest neighbors.

Recommends items based on similar users' preferences.

✅ Error Handling in ML Systems:

Realized the importance of:

Data validation (CSV formatting).

Logging (SLF4J).

Dependency security (CVE scanning).

✅ Maven Lifecycle:

Used commands like mvn clean install, mvn dependency:tree.

-Final Execution Steps

1. Setting Up
CSV File (sample_data.csv):

1,101,5.0  
1,102,3.0  
2,103,4.0  
(No headers, only numeric values)

Run the Program:

bash
mvn clean install  
mvn exec:java -Dexec.mainClass="ProductRecommender"  
2. Expected Output
Top 3 Recommendations for User 2:  
Product ID: 105 (Score: 4.50)  
Product ID: 106 (Score: 4.00)  
Product ID: 107 (Score: 5.00)  
3. Debugging Tips
If recommendations are empty:

Check if the CSV has enough user-item interactions.

Verify userId and productId exist in the dataset.

-Future Improvements

🔹 Integrate with Databases (MySQL/MongoDB) instead of CSV.
🔹 Deploy as a Web Service (Spring Boot + REST API).
🔹 Upgrade to Mahout 0.14+ for better Hadoop compatibility.

-Conclusion
This project successfully implemented a collaborative filtering recommender system while addressing real-world challenges like dependency management, logging, and data validation. It serves as a foundation for building more advanced recommendation engines.

Lessons Learned:
✔ Always check dependency vulnerabilities.
✔ Validate input data formats before processing.
✔ Use logging for better debugging.

*OUTPUT*:
![Image](https://github.com/user-attachments/assets/156a009a-3655-4be5-aa99-a83422e6c10c)
