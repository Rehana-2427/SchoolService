# SchoolService

This is a microservice example  without uisng eureka server instead of eureka server here i am uisng RESTTEMPLATE to connect two springboot projects . 

Microservice : 
  Microservices is an architectural style where a large application is built as a collection of small, independent services, each responsible for a specific business functionality.

Key Features:
Each service is independently deployable

Each has its own database

Services communicate over HTTP (usually REST APIs)

Can be written in different programming languages

❓ Why Use Microservices?
Scalability	- You can scale only the part that needs it (e.g., scale Job Service only)
Maintainability -	Small, focused codebases are easier to manage
Flexibility -	Each team can work on different services independently
Faster - deployment	You can deploy one service without affecting others

Without Eureka server

Build multiple Spring Boot microservices

Connect them using RestTemplate or WebClient

Use manual URLs like http://localhost:8081/...

This is completely valid for:

Small projects

Local development

Simple microservices communication


for inter service communication we have 4 ways 
-> RESTTEMPLATE
-> WebClient
-> EUreka server
-> Consul 


In that here RESTTEMPLATE we are using here 

✅ What is RestTemplate in Spring?
RestTemplate is a synchronous HTTP client provided by Spring Framework to perform HTTP requests and interact with RESTful web services. 
It simplifies communication with HTTP servers and enforces RESTful principles.

🔧 Why do we use RestTemplate?
We use RestTemplate to:

Consume REST APIs (GET, POST, PUT, DELETE, etc.)

Send/Receive data in various formats like JSON, XML, etc.

Handle serialization/deserialization between Java objects and HTTP request/response bodies.

Integrate with other microservices in a Spring Boot application.

GET	Fetching data	getForObject(), getForEntity()
POS -> Sending new data => postForObject(), postForEntity()
PUT	-> Updating existing data => put()
DELETE -> Removing data	=> delete()
Exchange ->	Advanced usage with full control => exchange()

Note 
RestTemplate is deprecated in Spring 6 / Spring Boot 3.

It is replaced by WebClient (asynchronous & reactive), but RestTemplate is still widely used in many existing Spring Boot applications


❌ Cons of Using RestTemplate
1. Synchronous (Blocking) Only
RestTemplate is blocking, meaning it waits for the response before continuing.

This is inefficient for high-concurrency or reactive applications.

Cannot scale well in microservices with many downstream calls.

2. Deprecated for Modern Use
Spring officially recommends WebClient (from Spring WebFlux) for new projects.

RestTemplate is in maintenance mode, meaning no new features or major improvements will be made.

📌 From the Spring Docs:

"As of Spring 5, RestTemplate is in maintenance mode and we recommend using the WebClient class..."

3. No Built-in Support for Reactive Streams
Doesn't support reactive types like Mono or Flux.

Not suitable for event-driven or reactive architectures.

4. Verbose for Complex Configurations
Custom headers, authentication, and timeout handling are more verbose compared to WebClient.

No fluent chaining like WebClient offers.

5. No Built-in Retry or Circuit Breaker Support
Needs extra libraries (e.g., Resilience4j) and custom configuration to handle retries, timeouts, and fallbacks.

✅ When Is RestTemplate Still OK to Use?
In simple synchronous apps (like small internal tools or scripts)

If you’re maintaining legacy Spring Boot applications

When using with Spring MVC, not WebFlux


If you do not annotate the RestTemplate bean with @LoadBalanced:

Service name resolution won't work.

You'll get an error like:
UnknownHostException: student-service

You'll be limited to hardcoded full URLs, like: restTemplate.getForObject("http://localhost:8081/api/v1/students", Student[].class);

 What is Load Balancing?
Load balancing distributes incoming network traffic across multiple instances of a service to:

Improve performance

Increase availability

Ensure fault tolerance

In microservices, it’s often needed when one service calls another, and there are multiple instances of that target service running (e.g., 3 replicas of student-service).

⚙️ Types of Load Balancing in Spring
1. Client-Side Load Balancing ✅
Handled by the caller (e.g., your service).

Picks an instance from a list (like from Eureka).

Uses libraries like Spring Cloud LoadBalancer or older Ribbon (now deprecated).

2. Server-Side Load Balancing
Handled by a reverse proxy like:

NGINX

AWS Load Balancer

HAProxy

Caller doesn't choose the instance—just hits the load balancer's IP.

🔧 How to Enable Load Balancing in RestTemplate : @LoadBalanced need to add in springboot config 
@Bean
@LoadBalanced // enables client-side load balancing
public RestTemplate restTemplate() {
    return new RestTemplate();
}
Then, you can use service names instead of URLs:

restTemplate.getForObject("http://student-service/api/v1/students", String.class);

This works if:

You're using Eureka, Consul, or another service registry

You have the Spring Cloud LoadBalancer dependency:

🧩 Maven dependency:

<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-loadbalancer</artifactId>
</dependency>
