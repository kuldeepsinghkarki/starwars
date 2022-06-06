**Setting Development Environemnt**
1. Use any CentOS (or linux based Virtual Machine OS).
2. Install docker,mavev, JKD and git on it.
3. Install Intellij IDEA community edition which will be used as IDE.
4. Create a git repository in github or bitbucket an then clone it your linux machine.
5. Develop REST APIs using Spring BOOT.
6. Secure these APIs by using JWT tokens.
7. Use SpringFox for Swagger Documentation.

**CI/CD Pipepline**
1. Used GitHub Actions for creating the CI/CD pipeline.
2. For deployment, tried to use integration with Heroku PAAS.
3. Dockefile has been placed inside SWServices module.

**Deploying Services Locally using minikube**
1. minikube alais 
alias kubectl="minikube kubectl --"
2. Deploy to minikube
kubectl create deployment starwarservices --image=kuldeepsinghkarki/starwarservices:latest
3. Make service avaiaible.
kubectl expose deployment starwarservices --type=NodePort --port=8080
4. Port forward to 8080 for this service.
kubectl port-forward service/starwarservices 8080:8080
5. Use **minkibe dashboard** commmand to see minikube dashboard.
