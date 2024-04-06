# # install maven
# FROM maven:3.8.3-openjdk-17 as build
# WORKDIR /opt/app
# COPY . /opt/app
# RUN mvn clean package

# # intall jdk 
# FROM openjdk:17-jdk-alpine
# WORKDIR /opt/app
# COPY --from=build /opt/app/target/*.jar /opt/app/app.jar
# ENTRYPOINT [ "java","-jar","app.jar" ]

FROM openjdk:oraclelinux8
WORKDIR /app
COPY .mvn/ .mvn
COPY mvnw pom.xml ./

RUN ./mvnw dependency:go-offline
COPY src ./src

CMD ["./mvnw","spring-boot:run"]