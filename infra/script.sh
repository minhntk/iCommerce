#docker-compose -f ./services/docker-compose.yml down &&
#docker rmi -f backend-product:latest &&
cd postgres && sh script.sh && cd .. && cd .. &&
sh script.sh &&
#cd backend-core && sh script.sh && cd .. &&
cd backend-discovery && sh script.sh && cd .. &&
cd backend-product && sh script.sh && cd .. &&
cd backend-order && sh script.sh && cd .. &&
cd backend-user && sh script.sh && cd .. &&
cd backend-gateway && sh script.sh && cd .. &&
cd infra && docker-compose -f ./services/docker-compose.yml up -d --scale backend-product=2
#docker service scale backend-order=2 backend-product=2
#--scale backend-order=2
