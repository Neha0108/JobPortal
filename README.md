# Job Portal

A full-stack Job Portal application built with **Java Spring Boot** that facilitates seamless interaction between **recruiters** and **candidates**. The platform allows recruiters to post jobs and manage applications, while candidates can search and apply for jobs.

---

## 🚀 Features

- ✅ Role-based login system (Candidate & Recruiter)
- 📝 Recruiters can create, update, and delete job posts
- 🔍 Candidates can browse job listings and apply
- 🛡️ Spring Security authentication and authorization
- 📂 Entity relationships managed using Spring Data JPA
- 🐘 MySQL for persistent data storage

---

## 🛠️ Technologies Used

- **Java 17**
- **Spring Boot**
- **Spring Security**
- **Spring Data JPA**
- **MySQL**
- **Thymeleaf** (if you have frontend pages)
- **Lombok**
- **Maven**

---

## 📁 Project Structure

```bash
JobPortal/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com.jobportal/   # your main packages
│   │   └── resources/
│   │       ├── application.properties
│   │       └── templates/       # Thymeleaf templates
├── pom.xml
├── README.md
└── .gitignore
```

---

## ⚙️ Getting Started

### Prerequisites
- Java 17+
- Maven
- MySQL

### 1. Clone the Repository

```bash
git clone https://github.com/Neha0108/JobPortal.git
cd JobPortal
```

### 2. Configure MySQL

Update your `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/jobportal
spring.datasource.username=your_mysql_username
spring.datasource.password=your_mysql_password
spring.jpa.hibernate.ddl-auto=update
```

### 3. Build and Run the App

```bash
mvn clean install
mvn spring-boot:run
```

The app will be available at `http://localhost:8080`

---

## 👥 User Roles

| Role       | Permissions                            |
|------------|----------------------------------------|
| Candidate  | Register, view jobs, apply for jobs    |
| Recruiter  | Register, post jobs, manage applicants |

---

## 📌 Future Enhancements

- Admin dashboard
- Job recommendations based on skills
- Email notifications

---

## 📝 License

This project is for educational and demonstration purposes.

---

## 🙋‍♀️ Author

**Neha**  
[GitHub Profile](https://github.com/Neha0108)
