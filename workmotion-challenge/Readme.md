The tas was completed for MID level.

The folder structure in the project is using DDD as recommended in official Spring Boot docs:

https://docs.spring.io/spring-boot/docs/current/reference/html/using.html#using.structuring-your-code

Steps to execute the project:

> docker build -t workmotion-challenge:1.0 .

> docker run -d -p 8080:8080 -t workmotion-challenge:1.0

The project should be available on http://localhost:8080