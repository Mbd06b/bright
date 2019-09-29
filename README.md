# Bright
The Bright App, an app for sourcing the brightest of ideas. 

# Technologies
The app currently contains:
1 Angular5/Node.js client,
1 SpringMVC client, which both consume RESTful APIs.

They are powered by a microservice spring boot network:
Eureka service discovery, config, and gateway servers,
and 3 application microservices users, ideas, and elections. 
and 1 Python/Django service which is a RESTful Api wrapper for the codelucas/Newspaper library https://github.com/codelucas/newspaper. 

# Objective
The objective is to learn by building an app with RESTful microservices to support an agile-like development/learning style. 
The app architechture will be able feed any form of client app (Web and Mobile) and should be scalable with container infrastructure.
A focus on microserivces should enable an exploration of different technologies and DevOps challenges..