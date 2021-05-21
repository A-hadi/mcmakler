# mcmakler
Installation Guide and Run
1. Clone WebAppTest repository:
link: https://github.com/A-hadi/mcmakler.git

2. Install Java:
- Minimum version required is Java JDK 8
- Download Java and set Java_Home in environment variables
Download link:
https://www.oracle.com/java/technologies/javase-downloads.html

Environment variables:
1- JAVA_HOME
2- bin path
3- JDK path

Windows ex:
JAVA_HOME: C:\Program Files\Java\jdk1.8.0_121
Path: C:\Program Files\Java\jdk1.8.0_121\bin
Path: C:\Program Files\Java\jdk1.8.0_121

Mac ex:
export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.8.0_144.jdk/Contents/Home
export PATH=$JAVA_HOME:$PATH
export PATH=$JAVA_HOME/bin:$PATH

To check that Java installation and environment variables is set correctly go to terminal and run "which java" it should show JAVA_Home path

3. Install Maven:
- Minimum version required is Maven 3.5.0
- Download and install maven and set M_2 in environment variables
Download link:
http://maven.apache.org/download.cgi

Environment variables:
1- M_2
2- bin path
3- maven path

Windows ex:
M_2: C:\Program Files\apache-maven-3.5.0
Path: C:\Program Files\apache-maven-3.5.0\bin
Path: C:\Program Files\apache-maven-3.5.0

Mac ex:
export M_2=/Users/apache-maven-3.5.0
export PATH=$M2:$M_2/bin:$PATH

To check that Java installation and environment variables is set correctly go to terminal and run "mvn --v" it should show M_2 path and JAVA_Home path

4. Install Chromedriver
- Chromedriver version depends on the chrome browser version please refer to the download link and select the Chromedriver version that suits your browser version.

- Download and install Chromedriver and set Chromedriver in environment variables

Environment variables:
1- chromedriver
2- chromedriver path

Download link
https://chromedriver.chromium.org/downloads

Windows ex:
chromedriver: C:\Program Files\chromedriver
Path: C:\Program Files\chromedriver

Mac ex:
export chromedriver=/Users/Documents/chromedriver
export PATH=$chromedriver:$PATH

5. SETUP YOUR ENVIRONMENT
After get latest version of framework, open the file staging.properties in text editor you can find it under the project folder in this path: /mcmakler.auto/envvariables/staging.properties

Note:
The chrome-headless property if true the chrome will run in headless mode the GUI will not appear in case you want to watch the script running set it to "false"
chrome-path is the chrome driver path.


6. Run Tests Open terminal / CMD Go to project directory

. To clean target folder (were all test results stored) run command:
  "mvn clean"
. To run all tests run command:
  "mvn test"
. To run certain  tests run command:
  "mvn -Dtest=Verify* test"
Will run all test classes starts with "Verify"



