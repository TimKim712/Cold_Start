# CacheMeasuring

In the realm of computer science, caching is a technique associated with using a hardware or software component to store frequently used instructions, commands, or data so future requests can be made faster. Caches are used heavily in hardware systems to store commonly used instructions by the CPU; rather than having to acess other storage units such as RAM, SSDs, and HDDs, the CPU would retrieve instructions from the cache instead, saving on both computational time and costs. However, they are also implemented in software as well, primarily with backend systems and databases. It has an overall similar functionality as with its usage in hardware; commonly queried entities from a database are stored in the cache, which allows the backend to save time and costs as well since they won't have to make frequent requests from the database. 

This project is a simple Spring Boot REST API that demonstrates how caches can be used in database integrations to optimize retrieval and response times. The objective of this project is to measure the performance improvements resulted by comparing retrieval time between cached and non-cached entities. The tech stack for the project consists of the following:

- Spring Boot (backend and APIs)
- Redis (Cache)
- PostgreSQL (Database)
- Docker (deployment)

## Prerequisites and Local Setup

Ensure that Java 17+, Maven, and Docker are all set up locally. 

1. Start up the local instances for Postgres and Redis with `docker-compose up -d`. Postgres should be on `localhost:5432` and Redis should be on `localhost:6379`.
2. Run the Spring Boot application using `mvn spring-boot:run`. The APIs should be available on `http://localhost:8080`.
3. Create a product using a POST request, such as below. 
```
curl -X POST http://localhost:8080/products \
-H "Content-Type: application/json" \
-d '{"name":"Sample Product","price":49.99}'
```
4. Track the amount of time it takes for a GET request to retrieve the created entity:
```
time curl http://localhost:8080/products/{id}
```
5. Track this time again afterwards using the same request. The retrieval time on subsequent calls should be faster since the first call directly queries from Postgres, while later ones query from Redis. 
