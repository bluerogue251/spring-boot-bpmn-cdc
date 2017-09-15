#!/usr/bin/env bash

docker rm --force --volumes sbbc_dev_db
docker create --name sbbc_dev_db -p 5440:5432 postgres:9.6.3
docker start sbbc_dev_db
sleep 5
createdb -p 5440 -h localhost -U postgres sbbc_db
mvn flyway:migrate