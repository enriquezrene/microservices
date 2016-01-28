# microservices

Adding flyway support

1. Add flyway dependency:

    <dependency>
        <groupId>org.flywaydb</groupId>
        <artifactId>flyway-core</artifactId>
    </dependency>

2. Create a script file with the sintax inside the directory src/main/resources/db/migration with the sintax:
V1__script_information.sql
like: 
src/main/resources/db/migration/V1__create_table_model.sql