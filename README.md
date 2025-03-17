# Bank Management System App

## 🏦 Overview
This is a **Spring Boot REST API** for performing CRUD operations on bank accounts using **Spring Data JPA**, **MySQL**, and **Postman** for testing.

## 📌 Features
- **Create Account** ✅
- **Get Account Details** 🧐
- **Deposit Money** 💰
- **Withdraw Money** 🏧
- **Close Account** ❌

## 🛠️ Technologies Used
- **Java 17+**
- **Spring Boot 3+**
- **Spring Data JPA**
- **Spring Web**
- **MySQL Database**
- **Postman (for API testing)**
- **Lombok (for cleaner code)**

## 🚀 Setup Instructions

### 1️⃣ Clone the Repository
```sh
git clone https://github.com/alwaysdaya123/BankManagementSystemApp.git
cd BankManagementSystemApp
```

### 2️⃣ Configure MySQL Database
Update `application.properties` in `src/main/resources/`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/bankdb
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### 3️⃣ Build & Run the Application
```sh
mvn spring-boot:run
```

## 🔥 API Endpoints

### 1️⃣ Create Account
**POST** `/accounts/create`
```json
{
    "accountNumber": 1001,
    "accountHolderName": "Dayakar",
    "accountBalance": 5000.0
}
```

### 2️⃣ Get Account Details
**GET** `/accounts/{accountNumber}`

### 3️⃣ Deposit Money
**PUT** `/accounts/deposit/{accountNumber}/{amount}`

### 4️⃣ Withdraw Money
**PUT** `/accounts/withdraw/{accountNumber}/{amount}`

### 5️⃣ Close Account
**DELETE** `/accounts/close/{accountNumber}`

## 🎯 Testing with Postman
1. Open **Postman**.
2. Use the API endpoints listed above.
3. Verify the responses to ensure correctness.

## 📜 License
This project is licensed under the **MIT License**.

---

💡 **Need help?** Feel free to raise an issue in the repository! 🚀

