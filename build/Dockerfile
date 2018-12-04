FROM openjdk:8-jdk-alpine
RUN apk add maven

RUN mkdir /tmp/user_manager/
COPY ./src/user_manager/ /tmp/user_manager/
RUN cd /tmp/user_manager/ && mvn package
CMD cd /tmp/user_manager/ && mvn spring-boot:run

#VOLUME /tmp/user_manager/

#CMD touch /tmp/test.log && tail -f /tmp/test.log
