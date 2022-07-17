FROM maven:3.8.3-openjdk-11 as build-project
ADD . ./cookRecipe
#COPY .mvn/pom.xml /usr/share/maven/ref/

WORKDIR /cookRecipe
RUN mvn -U clean install

FROM openjdk:11
EXPOSE 8088
EXPOSE 443
EXPOSE 22

COPY --from=build-project ./cookRecipe/target/cookRecipe-*.jar ./cookRecipe.jar

CMD ["java", "-Dspring.profiles.active=dev", "-jar", "cookRecipe.jar"]
