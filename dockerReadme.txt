docker build -t authws:latest .

docker image ls

#Run
docker run -d --name authws_dock -p 8082:8082 authws:latest


#Run with log
docker run -d --name authws_dock -v D:/Temp:/var/log/Application/ -p 8082:8082 authws:latest dev

docker history authws:latest

#Start, Stop, Restart
docker ps
docker stop authws_dock 
docker ps -a
docker restart authws_dock 

docker rm authws_dock 

#Shell on docker
docker exec -it authws_dock sh