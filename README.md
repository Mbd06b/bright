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

Security
All supporting infrastructure is geared to be served with validated SSL connections
JWT Token Authentication/Authorization and BCrypt password hashing for client connections

2 Ubuntu 18 LTS Servers
* Gitlab repository https://gitlab.worscipe.com/Mbd06b/bright
* Jenkins for CI/CD pipelines https://ci.worscipe.com
* Taiga, project management platform https://taiga.worscipe.com/project/mbd06b-bright/timeline
* Eclipse Che, IDE for exploring cloud native development https://che-che.code.worscipe.com/dashboard/
* Kubernetes Cluster(microk8s), https://kube.worscipe.com (Graphana, Prometheus, and Eclipse Che)


# Objective
The objective is to enhance learning by building an app with RESTful microservices. 
The app architechture will be able feed any form of client app (Web and Mobile) and should be scalable with container infrastructure.
A focus on microserivces should enable an exploration of different technologies and SecDevOps challenges that might be deployable at any scale. 

# Roadmap
- [ ] Create an HA mysql cluster and S3 storage implementation with Kubernetes
- [ ] Migrate Jenkins(omnibus) to JenkinsX on K8s infrastructure.
- [ ] Implement JWT authorization for athorizing every request within the microservice cluster.
- [ ] Deploy 1.0 on Kubernetes, using a fully automated CI/CD pipeline
