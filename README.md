# The great bucket list (BE)
A Java/Spring backend for The Great Bucket List application.

## How to start

Prerequisite:
- Java 17
- Create a local DB env file as `database.env`, with the following config:
```
POSTGRES_USER=postgres
POSTGRES_PASSWORD=postgres
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
export SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/tgbl
export SPRING_DATASOURCE_USERNAME=postgres
export SPRING_DATASOURCE_PASSWORD=postgres
./mvnw spring-boot:run
````

- Visiting `localhost:8080` to verify if the application has been running successfully:
````
Welcome to the great bucket list!
````

## Technology
- Java 17
- Spring Boot
- PostgreSQL
- Flyway (for DB migration)


