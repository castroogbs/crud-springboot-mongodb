<p align="center">
  <a href="https://spring.io/" target="blank"><img src="https://spring.io/images/spring-logo-2022-93b99aee11ba10c57283810ff6f7f500.svg" width="500" alt="Nest Logo" /></a>
</p>

<br>

<p align="center">Basic CRUD made with Spring Boot framework using MongoDB as the database.</p>

<br>

<p align="center">
<a href="https://www.docker.com/" target="_blank"><img src="https://img.shields.io/badge/docker%20build-ok-blue" alt="Docker build" /></a>
<a href="https://www.mongodb.com/" target="_blank"><img src="https://img.shields.io/badge/database-mongodb-green" alt="Database MongoDB" /></a>
</p>


## Installation
You need to have docker installed to run this project.

```bash
$ docker-compose up
```

<br>

## Available Routes
You can test the project routes using one of the options bellow:

<br>

### GET: (All Students)
> http://localhost:8080/api/v1/students/

<br>

### GET: (Find One)
> http://localhost:8080/api/v1/students/{{user-id}}

<br>

### POST: (Create Student)
> http://localhost:8080/api/v1/students/
```json
{
	"firstName": "User",
	"lastName": "User",
	"email": "user@usertest.com",
	"gender": "FEMALE",
	"address": {
		"country": "Brasil",
		"postCode": "São Paulo",
		"city": "009231239"
	},
	"favouriteSubjects": [
		"Computer Science",
		"Maths"
	],
	"totalSpentInBooks": 10,
	"createdAt": "2023-01-10T23:37:41.27"
}
```

<br>

### PUT: (Update Student)
> http://localhost:8080/api/v1/students/
```json
{
	"firstName": "User",
	"lastName": "User",
	"email": "user@usertest.com",
	"gender": "FEMALE",
	"address": {
		"country": "Brasil",
		"postCode": "São Paulo",
		"city": "009231239"
	},
	"favouriteSubjects": [
		"Computer Science",
		"Maths"
	],
	"totalSpentInBooks": 10,
	"createdAt": "2023-01-10T23:37:41.27"
}
```

<br>

### Delete: (Delete Student)
> http://localhost:8080/api/v1/students/{{user-id}}

<br>

## License
This project is under [MIT license](LICENSE).
