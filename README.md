# Hibernate-REST-Demo
This project demonstrates the use of Hibernate in a Spring Boot application to create database tables and persist data to a Postgres database via REST endpoints.

I want to create a simple book database to show how REST can be used to read from and write to a database in real time on a running Tomcat server. To make it as simple as possible, there will just be one table with no relationships to other tables. The book table will be represented by this Book class (see my <a href="https://github.com/jordan-p-jones/Hibernate-Demo">first Hibernate project</a> for a more detailed explanation of table setup annotations):

![image](https://github.com/jordan-p-jones/Hibernate-REST-Demo/assets/20289004/af06fdd4-5750-4530-a614-5c7cd090b4b9)

Next, I create the BookRepository interface to define possible data access methods on Book, and I get all standard CRUD operations for free by extending JpaRepository:

![image](https://github.com/jordan-p-jones/Hibernate-REST-Demo/assets/20289004/8cd53a8d-c2c9-498b-b7d8-16e50c9804a8)

Finally, I create the BookController class to define the REST endpoints for interacting with the book table. It contains a reference to my BookRepository for data access, and using @Autowired sets it up with Spring's dependency injection abilities, so it does not need a setter or getter method, or even any XML configuration.

![image](https://github.com/jordan-p-jones/Hibernate-REST-Demo/assets/20289004/48c9cc4e-aaf7-4c28-bcd7-266a0b71bd87)

The first time I run the application, it will create the book database table with no records. I can validate that the table exists in pgAdmin:

![image](https://github.com/jordan-p-jones/Hibernate-REST-Demo/assets/20289004/b78b537a-b71d-4825-9541-1f3f8f6f36aa)

To run further tests, I will use Postman to call the REST endpoints. First, I will create a new book via a POST request to /books/create and providing JSON for the book values in the body of the request:

![image](https://github.com/jordan-p-jones/Hibernate-REST-Demo/assets/20289004/4fbde4e5-62f7-4222-82cf-7f59961fe4cf)

![image](https://github.com/jordan-p-jones/Hibernate-REST-Demo/assets/20289004/01019338-24e1-4d60-b938-2064f26994c6)

Once I send the request, I can send a GET request to /books and validate the contents of the table:

![image](https://github.com/jordan-p-jones/Hibernate-REST-Demo/assets/20289004/87e6e5c4-c647-40f4-af57-08f657346e06)

![image](https://github.com/jordan-p-jones/Hibernate-REST-Demo/assets/20289004/ca5fb1fc-7d33-431a-ae50-99539e3e88d1)

I can update the fields of a book by sending a POST request to /books/update and providing the book values in the body, including the ID of the book to update:

![image](https://github.com/jordan-p-jones/Hibernate-REST-Demo/assets/20289004/50802501-54fe-4746-901f-62a176c22af4)

![image](https://github.com/jordan-p-jones/Hibernate-REST-Demo/assets/20289004/06bb92ab-ad3c-448a-992d-96d6949bc503)

You can see that the record has been updated in the database with the new edition and year:

![image](https://github.com/jordan-p-jones/Hibernate-REST-Demo/assets/20289004/5f0551f9-84c0-4650-a790-220ae10ffc09)

Another thing I can do is create a second book, and then call my custom data access method to get all books by a given author via a GET request to books/author/{author} and providing the author name in the URL:

![image](https://github.com/jordan-p-jones/Hibernate-REST-Demo/assets/20289004/e84b9fb8-aaf8-42c2-b860-df7021e93fa1)

![image](https://github.com/jordan-p-jones/Hibernate-REST-Demo/assets/20289004/c9af200d-14e7-4fe1-8716-2c41a2001eb3)

This is very cool because I did not have to define how to query the book table by author. <a href="https://docs.spring.io/spring-data/jpa/reference/repositories/query-methods-details.html">Spring Data JPA</a> automatically implements the method based on its name, and all I have to do is define the interface.

Finally, I can delete all records in the book table with a DELETE request to books/deleteAll:

![image](https://github.com/jordan-p-jones/Hibernate-REST-Demo/assets/20289004/34899dc5-3fc9-4492-802f-3c103961e89b)

![image](https://github.com/jordan-p-jones/Hibernate-REST-Demo/assets/20289004/a7bfd5cd-3c8b-4a44-bb24-a1427e0b964c)
