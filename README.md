# Starwar Services 
#### Features
- StarWars services endpoints with search using name/type.
- APIs decorated with Swagger doc.
- API Security . Used JWT tokens for endpoints security. Please see [API Security]
- Dockerfile for containerization.
- Offline API behavior for person service.
- OpenAPI support using HATEOAS.
- Deployment using minikube

#### Tech/Tools Used
Starwars APIs used following tools/tech for the implementation:
- [CentOS] - Centos version 7 Linux distribution.
- [SpringBoot] - For RESTful APIs, HATEOAS,Security JWT
- [Intellij IDEA] - IDEA community edition as IDE, source code editor.
- [Mockito] - For test cases.
- [Maven] For creating builds.
- [GitHub] -  For source code version control.
- [GitHub Actions] - For CI/CD pipelining.
- [Docker] - For containerization of APIs using Dockerfile
- [Swagger OAS] - For API documentation
- [Postman] - For validating APIs.

   [SpringBoot]: <https://spring.io/projects/spring-boot>
   [GitHub]: <https://github.com/kuldeepsinghkarki/starwars.git>
   [GitHub Actions]: <https://github.com/kuldeepsinghkarki/starwars/actions>
   [Mockito]: <https://site.mockito.org/>
   [Docker]: <https://hub.docker.com/repository/docker/kuldeepsinghkarki/starwarservices>
   [Intellij IDEA]: <https://www.jetbrains.com/idea/download/>
   [Swagger OAS]: <https://swagger.io/specification/>
   [API Security]:<https://github.com/kuldeepsinghkarki/starwars/blob/master/AuthFlowsSequenceDiag.svg>
   [CentOS]:<https://www.centos.org>
   [Maven]:<https://maven.apache.org/guides/introduction/introduction-to-the-lifecycle.html>
   [Postman]:<https://www.postman.com>


#### Setting Development Environemnt
1. Use any CentOS (or linux based Virtual Machine OS).
2. Install docker,mavev, jdk and git on it.
3. Install Intellij IDEA community edition which will be used as IDE.
4. Create a git repository in github or bitbucket an then clone it your linux machine.
5. Develop REST APIs using Spring BOOT.
6. Secure these APIs by using JWT tokens.
7. Use SpringFox for Swagger Documentation.
8. Used spring hateoas for matching up with OAS standards.

#### CI/CD Pipepline
1. Used GitHub Actions for creating the CI/CD pipeline.
2. For deployment, tried to use integration with Heroku PAAS.
3. Dockefile has been placed inside SWServices module.

#### Deploying Services using locally docker
1. Login to docker hub using your docker login account.
```sh
docker login -u username -p ******
```
2. Pull docker image where TAG number could be latest if not specified or specific docker image tag you require.
```sh
docker pull kuldeepsinghkarki/starwarservices:{TAG}
```
3. Run docker container and map port to 8080.
```sh
docker run -p8080:8080 --name services kuldeepsinghkarki/starwarservices:{TAG}
```
4. Once deployed, navigate to browser with http://localhost:8080/swagger-ui/ to see swagger ui for the services.


#### Deploying Services locally using minikube
1. Set kubectl alias for convenience.
```sh
alias kubectl="minikube kubectl --"
```
alias kubectl="minikube kubectl --"
2. Deploy to minikube
```sh
kubectl create deployment starwarservices --image=kuldeepsinghkarki/starwarservices:latest
```
3. Make service avaiaible.
```sh
kubectl expose deployment starwarservices --type=NodePort --port=8080
```
4. Port forward to 8080 for this service.
```sh
kubectl port-forward service/starwarservices 8080:8080
```
5. Use minikube dashboard commmand for gui.
```sh
minkibe dashboard
```
