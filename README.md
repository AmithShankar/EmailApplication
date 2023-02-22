<h1 align="left">Email Application</h1>

<p align="left">Based on Scenario: A IT Support Administrator Specialist who is charged with the task of creating email accounts for new hires.
Our application does the following:</p>
 
```
Generate an email with the following syntax: firstname.lastname@department.ttg.com
Determine the department (sales, development, accounting), if none leave blank.
Generate a random String for a password.
Have set methods to change the password, set the mailbox capacity, and define an alternateemail address.
Have get methods to display the name, email, and mailbox capacity.
```

Requirements & Installation
---------------------------
**Minimum Requirements:**
1. jdk 1.8 or above
2. Eclipse neon 3 or above
3. MySQL Workbench 8.0 CE
4. MySQL Connector J 8.0.32.jar

**Installation:**

1. Install JDK.
2. Install Eclipse
3. We used MySQL database in this project. We have to install  MySQL Workbench. In our case we created a database with `email` and `email` as their username and password respectively for MySQL. (If you want to change the username & password then open `EmailApp.java` file and change username or  password according to your MySQL database username and password).
4. Open Eclipse and create a Java Project or your desired name, Inside the Project create a package called `emailapp`, if in case you would want to change the package name you can do so and change their name in `Email.java` and `EmailApp.java`.
5. Import both `Email.java` and `EmailApp.java` inside the package you created.
6. Add *mysql-connector-j-8.0.32.jar* in Libraries if not added before.

## Built With

- Java
- MySQL

## Future Updates

- [ ] User Interface
- [x] Architecture

## Author

**Amith Shankar**

- [Profile](https://github.com/AmithShankar "Amith Shankar")
- [Email](mailto:amithshankarkm2@gmail.com?subject=Hi "Hi!")
- [Website](https://amithshankarkm.in.net/ "Welcome")

## 🤝 Support

Contributions, issues, and feature requests are welcome!

Give a ⭐️ if you like this project!
