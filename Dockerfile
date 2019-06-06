FROM java:8
ADD target/springbootmongoreactive-0.0.1-SNAPSHOT.jar springbootmongoreactive.jar
EXPOSE 8000
ENTRYPOINT ["java","-jar","springbootmongoreactive.jar"]