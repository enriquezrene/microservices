# microservices

Replacing h2->postgresql

1. Change the dependency

From:
    <dependency>
        <groupId>com.h2database</groupId>
        <artifactId>h2</artifactId>
    </dependency>

To:
    <dependency>
        <groupId>org.postgresql</groupId>
        <artifactId>postgresql</artifactId>
        <version>9.3-1100-jdbc41</version>
    </dependency>


2. Add db configuration inside application.properties file:

spring.datasource.url=jdbc:postgresql://localhost:5432/microservices
spring.datasource.username=postgres
spring.datasource.password=postgres
spring.jpa.hibernate.ddl-auto=create-drop