FROM openjdk:11.0.7-jre

ENV APP_HOME /usr/local/spring_elastic_stack
ENV PATH $APP_HOME:$PATH

WORKDIR $APP_HOME

ADD ../target/*.jar ./api.jar

CMD ["java","-jar", "api.jar"]