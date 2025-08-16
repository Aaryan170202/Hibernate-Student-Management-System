# 🏫 Student Management System (Java + Hibernate)

A Java console application for managing student records using **MySQL** database and **Hibernate ORM**.  
This project follows the **DAO (Data Access Object)** pattern to perform basic CRUD operations.

---

## 📌 Features
- Create a new student  
- Read all students  
- Read student by ID  
- Update student details  
- Delete a student  
- Continuous menu until the user exits  

---

## 🛠️ Tech Stack
- **Java (JDK 17+)**  
- **MySQL (as database)**  
- **Hibernate ORM (7.x)**  
- **Jakarta Persistence API (JPA)**  
- **Maven** (for dependency management)  
- **DAO Pattern**  

---

## 📂 Project Structure
```
com.aaryan
│
├── MainApp.java # Main menu & user interaction
│
├── dao
│ └── StudentDao.java # CRUD logic using Hibernate
│
├── model
│ └── Student.java # Student entity/model
│
└── util
  └── HibernateUtil.java # Hibernate SessionFactory utility
```
---
## 🚀 How to Run

### 1️⃣ Clone the repository
```bash
git clone https://github.com/<your-username>/<repo-name>.git
cd <repo-name>
```

### 2️⃣ Build the program
```bash
mvn clean compile
```

### 3️⃣ Run the program
```bash
mvn exec:java -Dexec.mainClass="com.aaryan.MainApp"
```
---

## 📸 Example Usage
```
===== Student Management =====
1. Create Student
2. Update Student
3. Delete Student
4. Show All Students
5. Show Students by Id
6. Exit
Enter choice: 1
Enter name: Abc
Enter email: abc@xyz.com
Enter course: Hibernate
✅ Student created successfully!
```

---

## 💡 Future Improvements
- Input validation for email & course
- Search students by name or course
- Pagination for large datasets
- Convert to GUI (JavaFX) or web app (Spring Boot)

---

## 📜 License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
