# Rest API
* We have a platform where psychiatrists can register their patients through a mobile/ web portal. Each psychiatrist belongs to a hospital.

## Tech Stack

* Java
* Spring Framework
* Spring Boot
* Spring Data JPA
* Hibernate
* MySQL
* Lombok

## Modules
1. Hospital Module
2. Psychiatrist Module
3. Patient Module

```

        server.port=8888

        spring.datasource.url=jdbc:mysql://localhost:3306/hospital
        spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
        spring.datasource.username=root
        spring.datasource.password=root

```

# API Root Endpoint

## Hospital module

* Add hospital details (POST Request)

`http://localhost:8888/hospital`

* Get all hospital details (Get Request)

`http://localhost:8888/hospital`

* Get all hospital details by hospital id (Get Request)

`http://localhost:8888/hospital/{hospitalId}`

## Psychiatrist module

* Add Psychiatrist details (POST Request)

`http://localhost:8888/psychiatrist/{hospitalId}`

## Patient module

* Add patients details (POST REQUEST)

`http://localhost:8888/psychiatrist/{psychiatristId}`

