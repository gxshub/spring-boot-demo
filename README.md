# spring-boot-demo

### REQUEST 1
curl -X POST -H "Content-Type:application/json" -d '{"name":"My Library"}' http://localhost:8080/libraries
#### RETURN
{"id":1,"name":"My Library"}

### REQUEST 2
curl -X POST -H "Content-Type:application/json" -d '{"location":"Main Street nr 5"}' http://localhost:8080/addresses
#### RETURN
{"id":2,"location":"Main Street nr 5","library":null}

### REQUEST 3
curl -i -X PUT http://localhost:8080/libraries/1/address/2
#### RETURN
{"id":1,"name":"My Library"}

### REQUEST 4
curl -X GET http://localhost:8080/addresses/2
#### RETURN
{"id":2,"location":"Main Street nr 5","library":{"id":1,"name":"My Library"}}
