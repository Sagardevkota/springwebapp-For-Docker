## springwebapp-For-Docker
# There are three approaches to create docker image

* Using the integrated Spring Boot build-image goal
* Using the jib-maven-plugin from Google
* Using the dockerfile-maven-plugin from Spotify

# 1. Using the integrated Spring Boot build-image goal

So with no further code changes necessary, simply run the command

```diff

mvn spring-boot:build-image

```

On Completion you will see

Successsfully built image 'docker.io/library/springwebappdemo:0.0.1-SNAPSHOT

then simply run

```diff
docker run --tty --publish 8090:8090 springwebappdemo:0.0.1-SNAPSHOT

```
Note:You should have your docker terminal running in background..


# 2. Using the jib-maven-plugin from Google

A benefit is that it does not require Docker to be installed locally* which can be useful for Continuous Integration / build server — the jib-maven-plugin will build and push the image straight to the Docker registry of choice

To build the Docker image, run the command

```diff
mvn compile com.google.cloud.tools:jib-maven-plugin:2.3.0:dockerBuild

```
Once built, we can run our new Docker image. docker run -p 9091:8080 -t demo-application:0.0.1-SNAPSHOT

Note:It doesnt require docker to be installed locally but if you have it installed you can see your docker container running by following command


```diff
docker ps
```
You can use following command to stop docker container


```diff
docker rm -f CONTAINER_ID
```

# 3. Using the dockerfile-maven-plugin from Spotify

we need to have a Dockerfile — for the purpose of demonstration there’s a Dockerfile ready-made in the GitHub repository. Add your Dockerfile into your root directory alongside your pom.xml.

Note:I have included Dockerfile in this repo

we will add some configuration into the pom.xml, specifically repository tag and an argument for the JAR_FILE which you can see we reference in the Dockerfile above


```diff
<plugin>
  <groupId>com.spotify</groupId>
  <artifactId>dockerfile-maven-plugin</artifactId>
  <version>1.4.13</version>
  <executions>
    <execution>
      <id>default</id>
      <goals>
        <goal>build</goal>
        <goal>push</goal>
      </goals>
    </execution>
  </executions>
  <configuration>
    <repository>${project.artifactId}</repository>
    <tag>${project.version}</tag>
    <buildArgs>
      <JAR_FILE>target/${project.build.finalName}.jar</JAR_FILE>
    </buildArgs>
  </configuration>
</plugin>
```

Run the standard command mvn package

Once built, we can run our new Docker image.
```diff
docker run -p 9092:8080 -t demo-application:0.0.1-SNAPSHOT
```

Majority part of article was extracted from source : https://medium.com/swlh/build-a-docker-image-using-maven-and-spring-boot-58147045a400 
