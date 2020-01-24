# Bright
The Bright App, an app for sourcing the brightest of ideas. 

# Technologies
The app currently contains:
1 Angular5/Node.js client,
1 SpringMVC client, which both consume RESTful APIs.

The apps are powered by a microservice spring boot network:
* Eureka service discovery server, a Spring config-server , and a Spring gateway server,
* 3 application microservices; users, ideas, and elections, with persistance enabled with JPA and Hibernate on 3-respective MySQL dabases.
* 1 Python/Django service which is a simple single point RESTful Api wrapper for the codelucas/Newspaper project https://github.com/codelucas/newspaper. 
* API docs are being generated and parsed by Swagger2 and are aggregated and accessed by a proxy-service consisting of a repurposed Netflix Zuul Gateway.

# SecDevOps
2 Ubuntu 18 LTS Servers
Gitlab repository https://gitlab.worscipe.com/Mbd06b/bright
Nexus, Maven Repository and Docker Registry https://save.worscipe.com
Jenkins for CI/CD pipelines https://ci.worscipe.com
Taiga, project management platform https://taiga.worscipe.com/project/mbd06b-bright/timeline
Kubernetes Cluster(microk8s), https://kube.worscipe.com (Graphana, Prometheus, and Eclipse Che)


# Objective
The objective is to learn by building an app with RESTful microservices to support an agile-like development/learning. 
The app architechture will be able feed any form of client app (Web and Mobile) and should be scalable with container infrastructure.
A focus on microserivces should enable an exploration of different technologies and DevOps challenges that might be encountered at any scale. 
