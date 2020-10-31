FROM openjdk:11-jre-slim
VOLUME /tmp
ADD target/demo-0.0.1-SNAPSHOT.jar demo-0.0.1-SNAPSHOT.jar

ENV spring.datasource.username=root
ENV spring.datasource.password=entrada01
ENV spring.datasource.url=jdbc:mysql://172.20.10.2:3306/Barcampdb


EXPOSE 9000
ENTRYPOINT ["java","-jar","demo-0.0.1-SNAPSHOT.jar"]