# microservices

Using HTTP Status codes

Adding spring-boot-devtools to automatically restart whenever files on the classpath change. 
If you're using IntelliJ force the build with the option: build-> make project (CTRL+F9)  
<pre>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <optional>true</optional>
        </dependency>
</pre>

Inserting a new manufacturer:

<pre>
POST http://localhost:8080/manufacturers/
HEADERS Content-type:application/json 
{
    "name": "Chevrolet"
}
</pre>

Inserting a new car:

<pre>
POST http://localhost:8080/manufacturers/{manufacturerId}/cars
HEADERS Content-type:application/json 
{
    "model": "BMW 335i",
    "color": "white"
}
</pre>
