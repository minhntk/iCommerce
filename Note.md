Why field injection is harmful
https://www.vojtechruzicka.com/field-dependency-injection-considered-harmful/

Builder pattern
https://blogs.oracle.com/javamagazine/post/exploring-joshua-blochs-builder-design-pattern-in-java


docker rm -f $(docker ps -a -q)
docker volume rm $(docker volume ls -q)

https://www.ibm.com/cloud/architecture/architectures/event-driven-cqrs-pattern/
https://www.ibm.com/cloud/architecture/architectures/event-driven-saga-pattern
https://www.ibm.com/cloud/architecture/architectures/event-driven-deadletter-queue-pattern




minikube start --memory 4078 --cpus 4


kubectl create configmap hostname-config --from-literal=postgres_host=$(kubectl get svc postgres -o jsonpath="{.spec.clusterIP}")

eval $(minikube docker-env)
