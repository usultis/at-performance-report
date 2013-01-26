Acceptance Tests performance report
=====================

Acceptance Tests performance report in Jenkins

To test please do:
under Windows
    set MAVEN_OPTS=-Xmx512m -XX:MaxPermSize=256m
    mvn clean verify
under Linux/Mac/Unix
    export MAVEN_OPTS="-Xmx512m -XX:MaxPermSize=256m"
    mvn clean verify