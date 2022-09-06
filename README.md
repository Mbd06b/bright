
# Bright
The Bright App, an app for sourcing the brightest of ideas. 

⚠️  Hey you, yeah you. 
=====================
This (Bright) ultimately is just a training exercise, and is in no way a product. However the concept of Bright is indicative of the kind of application that instrisically motivates me as a developer/person. If you're here reading this and are interested in pro-social collaborative technology.  Check out the following: 

* Foundations of Humane Technology https://www.humanetech.com/course - This self-paced online course prepares product teams to create technology that treats attention and intention as sacred, protects well-being, and builds our collective capacity to address humanity’s most urgent challenges.  This course put into words what I understood but hadn't as well described. Start here. 

* Loomio https://github.com/loomio/loomio - decision-making tool for collaborative organizations, this is conceptually the closest thing so far to what I had in mind for the Bright App, creating rich meaningful feedbock for social technology. Try it out.
* Kolibri https://github.com/learningequality/kolibri - Kolibri Learning Platform: the offline app for universal education. IMO accessible and meaningful mastery/learning is a core component of any maximally informed society, Kolibri seems to have a mission to do that. 
* Hylo - https://github.com/Hylozoic - A Social coordination app, being developed for a thriving planet. While social seems to be a pain-point in technology, I'm hopeful the developers at Hylo can build something meaningful which could transcend our social morass.  
* Pol.is - https://github.com/compdemocracy/polis -  Polis is an AI powered sentiment gathering platform. More organic than surveys and less effort than focus groups, Polis meets the basic human need to be understood, at scale.
* Holochain - https://github.com/holochain - Scalable framework for P2P distributed apps. For all those projects you wish you could take from centralized web servers but you know can't scale on blockchain.
* (honorable mention) Taiga - https://github.com/kaleidos-ventures/taiga-docker/ - Taiga: The free and open-source project management tool
For cross-functional agile teams to work effectively. Storytelling is another core component any maximally informed system, Structuring stories in such a way that people can align to accomplish something complex is essential. Which is why I have taiga on this list.  https://www.taiga.io
* (honrable mention) Cucumber - https://github.com/cucumber - https://cucumber.io  - Collaboration tooling based on employing Behavior-Driven Development (BDD). Storytelling is another core component any maximally informed system, Structuring stories in such a way that people can align to accomplish something complex is essential. Which is why I have cucumber on this list, the functional lanugage Gerkin for describing User Stories lowers the bar for non-developer stakeholders to contribute meaningfully to the stories that transform technology. 


I am always on the lookout for accessible applications/resources that endevor to embody what I see as the potential for technology to support human thriving, and colloboration at scale. The either the individual success or the convergence of the above constellation of apps are on the shortlist of who I would like to see scaled. 


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
