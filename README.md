# Spring Boot - Entity Relationship

This simple project shows an implementation of a one-to-one relationship between two entity classes in Spring Boot.

### Demonstration: Sample REST Requests
- Request 1. 
```bash
curl -X POST -H "Content-Type:application/json" -d '{"name":"My Library"}' http://localhost:8081/libraries
```
which returns
```json
{"id":1,"name":"My Library"}
```

- Request 2.
```bash
curl -X POST -H "Content-Type:application/json" -d '{"location":"Main Street nr 5"}' http://localhost:8081/addresses
```
which returns 
```json
{"id":2,"location":"Main Street nr 5","library":null}
```

- Request 3.
```bash
curl -i -X PUT http://localhost:8081/libraries/1/address/2
```
which returns
```json
{"id":1,"name":"My Library"}
```

- Request 4.
```bash
curl -X GET http://localhost:8081/addresses/2
```
which returns
```json
{"id":2,"location":"Main Street nr 5","library":{"id":1,"name":"My Library"}}
```
_Note that the value of `"library"` has been updated from `null` to `{"id":1,"name":"My Library"}`._
### Windows CMD
In Windows, you need to escape additional single or double quotes with a backslash; for example:
```bash
curl -X POST -H "Content-Type:application/json" -d "{\"name\":\"My Library\"}" http://localhost:8081/libraries
```
