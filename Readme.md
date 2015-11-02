# Zookeeper Sandbox with Spring Boot

How to test:

## Compile the code:
```
cd zookeeper-sandbox
mvn package
cd ../zookeeper-sandbox-client
mvn package
```

## Execute multiple server instances. Open multpile consoles and run the code in each one:
```
cd zookeeper-sandbox
java -jar target/zookeeper-sandbox-0.0.1-SNAPSHOT.jar
```

## Open a new console and start the client:
```
cd zookeeper-sandbox-client
java -jar target/zookeeper-sandbox-client-0.0.1-SNAPSHOT.jar
```

## Test the calls. Open a new console and check the port changing:
```
curl http://localhost:8484/results
```

## Stop one of the servers and run the `curl` command again and check the API does not recognize the server was removed.

Spring Cloud Zookeeper issue: https://github.com/spring-cloud/spring-cloud-zookeeper/issues/45
