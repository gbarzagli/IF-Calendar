# IF Calendar
This project is for Web Development classes. 

It is developed in Java using VRaptor 4 framework with HTML5, CSS3 and its dependencies are managed by Gradle.

### TO RUN THE PROJECT
Open MySQL and copy-paste the code below: (only on the first run)
```sql
create database calendar;
use calendar;
create table teste(id int auto_increment primary key, `value` int not null);
```

Open terminal inside the project folder and type the code below:
```sh
./gradlew clean tomcatRun
```

Finally, open the following link:

http://localhost:8080/if-calendar/

### HOW TO PUSH A CHANGE
1. Create your own branch to commit your changes.
2. Push the branch to github.
3. Create a pull request and add Gabriel as reviewer.
