# Midterm Project Bank - Ironhack Santander Bootcamp

## Configuration

To start to use the program you need:

1. Create a two Database named "midterm" and "midterm_test".

2. Run mvn spring-bot:run.

3. http://localhost:8080

## API Routes

| Method | Route        |                    Response                     |
| ------ | --------------- | :---------------------------------------------: |
| POST    | /admin/create/saving      |        Admin create a Saving account         |
| POST    | /admin/create/checking |      Admin create a Checking account      |
| POST   | /admin/create/credit-card       |               Admin create a Credit Card               |
| GET   | /checking/{idAccount}/{idOwner}   |          Return a Checking Account with Id Account and Id Owner parameter          |
| POST    | /checking/{idAccountSender}/{idOwnerSender} | Transfer amount to another account |
| GET   | /credit-card/{idOwner}/{idAccount}   |          Return a Credit Card Account with Id Account and Id Owner parameter          |
| POST    | /credit-card/{idAccountSender}/{idOwnerSender} | Transfer amount to another account |
| GET   | /student/{idAccount}/{idOwner}   |          Return a Student Account with Id Account and Id Owner parameter          |
| POST    | /student/{idAccountSender}/{idOwnerSender} | Transfer amount to another account |
| GET   | /saving/{idAccount}/{idOwner}   |          Return a Saving Account with Id Account and Id Owner parameter          |
| POST    | /saving/{idAccountSender}/{idOwnerSender} | Transfer amount to another account |
| POST   | /third-party/debit/{hashKey}   |     Debit to especific account               |
| POST    | /third-party/credit/{hashKey} | Credit to especific account |

## Tools

Intellij 2020

Spring Boot

MySQL

MongoDB





