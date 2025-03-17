# Bank Management System App

## Overview
The **Bank Management System App** is a Spring Boot REST API that provides CRUD operations for managing bank accounts. It leverages **Spring Data JPA**, **MySQL**, and **Postman** for API testing.

## Features
- Create a new bank account
- Retrieve account details by account number
- Deposit money into an account
- Withdraw money from an account
- Get all bank accounts
- Close (delete) an account

## Technologies Used
- **Spring Boot** (REST API development)
- **Spring Data JPA** (Database operations)
- **MySQL** (Database)
- **Postman** (API testing)

## Installation & Setup

### Prerequisites
- **Java 17+**
- **Spring Boot 3+**
- **MySQL Database**
- **Maven**

### Steps to Run the Application
1. **Clone the Repository:**
   ```sh
   git clone https://github.com/alwaysday123/BankManagementSystemApp.git
   cd BankManagementSystemApp
   ```

2. **Configure Database:**
   Update `application.properties` in `src/main/resources` with your MySQL credentials:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/bankdb
   spring.datasource.username=root
   spring.datasource.password=your_password
   spring.jpa.hibernate.ddl-auto=update
   ```

3. **Build & Run the Application:**
   ```sh
   mvn spring-boot:run
   ```

## API Endpoints

| HTTP Method | Endpoint                     | Description                 |
|------------|-----------------------------|-----------------------------|
| POST       | `/create`                    | Create a new bank account   |
| GET        | `/getallaccounts`            | Retrieve all accounts       |
| GET        | `/getaccount/{accountNumber}` | Retrieve an account by ID   |
| PUT        | `/deposit/{accountNumber}/{amount}` | Deposit money into an account |
| PUT        | `/withdraw/{accountNumber}/{amount}` | Withdraw money from an account |
| DELETE     | `/close/{accountNumber}`     | Close an account            |

## Example JSON Request

### Create Account (`POST /create`)
```json
{
    "accountNumber": 1001,
    "account_balance": 5000.0
}
```

### Deposit Money (`PUT /deposit/1001/1000`)
**Response:**
```json
{
    "accountNumber": 1001,
    "account_balance": 6000.0
}
```

### Withdraw Money (`PUT /withdraw/1001/500`)
**Response:**
```json
{
    "accountNumber": 1001,
    "account_balance": 5500.0
}
```

### Close Account (`DELETE /close/1001`)
**Response:**
```json
{
    "message": "Account with number 1001 has been closed successfully."
}
```

## Testing with Postman
1. Open **Postman**.
2. Use the given API endpoints to test CRUD operations.
3. Send JSON payloads for `POST` and `PUT` requests.

## License
This project is licensed under the **MIT License**.

---
**Author:** Dayakar | **GitHub:** [your-profile](https://github.com/alwaysdaya123)

