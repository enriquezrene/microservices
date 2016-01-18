# microservices

Project with support for spring-data-jpa

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