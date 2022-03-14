# The great bucket list (BE)
A Java/Spring backend for The Great Bucket List application.

## How to start

Prerequisite:
- Java 16
- Create a local DB env file as `database.env`, with the following config:
```
POSTGRES_USER=<username>
POSTGRES_PASSWORD=<password>
POSTGRES_DB=tgbl
```

---
To run the application:

- Start the local PostgreSQL DB:
````
docker-compose up -d
````

- Then start the server with:
````
POSTGRES_USER=<username> POSTGRES_PASSWORD=<password> ./mvnw spring-boot:run
````

- Visiting `localhost:8080` to verify if the application has been running successfully:
````
Welcome to the great bucket list!
````

## Technology
- Java 16
- Spring Boot
- PostgreSQL


