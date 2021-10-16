#docker-compose -f ./services/docker-compose.yml down &&
#docker rmi -f backend-product:latest &&
cd postgres && sh script.sh && cd .. &&
#export DOCKER_BUILDKIT=0 &&
#export COMPOSE_DOCKER_CLI_BUILD=0 &&
cd .. && cd backend-product && sh script.sh && cd .. &&
cd backend-order && sh script.sh && cd .. &&
cd infra && docker-compose -f ./services/docker-compose.yml up -d
