REM ------------ 1 ------------------
call docker stop authws_dock

REM ------------ 2 ------------------
call docker rm authws_dock

REM ------------ 3 ------------------
rem https://stackoverflow.com/questions/19620342/failed-to-load-main-class-manifest-attribute-while-running-java-jar
call mvn clean package spring-boot:repackage

REM ------------ 4 -----------------
del D:\Temp\application.log

REM ------------ 5 ------------------
call docker build -t authws:latest .

PAUSE

REM ------------ 6 ------------------
REM call docker run -d --name authws_dock -v D:/Temp:/var/log/Application/ -p 8082:8082 authws:latest dev
call docker run -d --name authws_dock -v D:/Temp:/var/log/Application/ -p 8082:8082 authws:latest