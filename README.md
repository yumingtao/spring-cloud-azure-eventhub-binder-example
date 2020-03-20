# Spring Cloud Azure EventHub Example
## Introduction
MessageController receive the post messages and send it to EventHub.  
MessageListener consume the messages in EventHub.

## Dependencies
spring-boot 2.2.5.RELEASE
spring-cloud-azure-eventhubs-stream-binder 1.2.2

spring-cloud-starter-sleuth 2.2.2-RELEASE
Note: When add sleuth dependency，will get java.lang.ClassCastException

`
Caused by: java.lang.ClassCastException: java.lang.String cannot be cast to java.util.Map
`

## How ro Test
1. mvn spring-boot:run
2. curl -X POST 'http://localhost:8080/messages?message=Hello%20World'


### Reference Documentation
https://github.com/microsoft/spring-cloud-azure/tree/master/spring-cloud-azure-samples/eventhubs-binder-sample
https://docs.microsoft.com/en-us/azure/java/spring-framework/configure-spring-cloud-stream-binder-java-app-azure-event-hub