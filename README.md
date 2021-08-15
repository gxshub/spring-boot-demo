# Spring Boot Demo

This simple project shows an implementation of a one-to-one relationship between two entity classes in Spring Boot.

### Demonstration: Sample REST Requests
- Request 1. 
```bash
curl -X POST -H "Content-Type:application/json" -d '{"name":"My Library"}' http://localhost:8080/libraries
```
which returns
```json
{"id":1,"name":"My Library"}
```

- Request 2.
```bash
curl -X POST -H "Content-Type:application/json" -d '{"location":"Main Street nr 5"}' http://localhost:8080/addresses
```
which returns 
```json
{"id":2,"location":"Main Street nr 5","library":null}
```

- Request 3.
```bash
curl -i -X PUT http://localhost:8080/libraries/1/address/2
```
which returns
```json
{"id":1,"name":"My Library"}
```

- Request 4
```bash
curl -X GET http://localhost:8080/addresses/2
```
which returns
```json
{"id":2,"location":"Main Street nr 5","library":{"id":1,"name":"My Library"}}
```
