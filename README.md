# IF Calendar
This project is for Web Development classes. 

It is developed in Java using VRaptor 4 framework with HTML5, CSS3 and its dependencies are managed by Gradle.

### TO RUN THE PROJECT
Your MySQL user need to be **root** with password "**root**" to run!

Then create database named "calendar" inside your MySQL Server:
```sql
create database calendar;
```

Open terminal inside the project folder and type the code below:
```sh
./gradlew clean tomcatRun
```

Finally, open the following link:

http://localhost:8080/if-calendar/

### HOW TO PUSH A CHANGE
1. Run gradlew clean before your commit.
2. Create your own branch to commit your changes.
3. Push the branch to github.
4. Create a pull request and add Gabriel as reviewer.

### TROUBLESHOOT
If there are errors in any file when importing the code into eclipse, run gradlew clean eclipse and refresh the project.
