## How to run
### 1) using Maven:
    > mvn clean test
### 2) using Jenkins:
Note: Jenkins job is configured to create Cucumber reports. It may be necessary to install Jenkins plugin *Cucumber reports*
* from *src/test/resources/jenkins* copy *TMobileWebTests* folder with *config.xml* file to your jobs directory: *{JENKINS_HOME}/jobs/*
* run *Build with Parameters* and enter the path to the project root directory (*TMobileWebTestsBartoszRoszko*)

## Reports
Cucumber report is stored in *target/reports/cucumber-report.html*