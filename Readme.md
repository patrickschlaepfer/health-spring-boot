# Health Integration Plattform - Springboot Version

This Version is based on spring boot, including hawtio console access.

## Prerequisites

Yes, even this project needs them.

* maven (https://maven.apache.org/)
* Java 1.8
* ActiveMQ (http://activemq.apache.org/)
* git
* Eclipse - I prefer the STS Version (https://spring.io/tools)
* JBoss Wildfly, if you like to run it within a container

ActiveMQ could be exchanged by RabbitMQ...

### Build the project

```
mvn clean install
```

#### How to run?

The project can either be run standalone, so only needs a jre. Or you deploy it into a wildfly container.

### TODO

* Try to include fan-out pattern for the queue using RabbitMQ.


## Add a new module to the project

Change to top level health-spring-boot directory

-DgroupId is always com.schlaepfer.health -DartifactId will be the name of the new module added.

```
mvn archetype:generate -DgroupId=com.schlaepfer.health -DartifactId=health-spring-boot-systemthree -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```

## Docker

First install docker binaries - DockerToolbox for windows

Then start Docker

```
C:\Projects\health-spring-boot\health-spring-boot-systemone>docker-machine env default
SET DOCKER_TLS_VERIFY=1
SET DOCKER_HOST=tcp://192.168.99.100:2376
SET DOCKER_CERT_PATH=C:\Users\patrick.INTERNAL\.docker\machine\machines\default
SET DOCKER_MACHINE_NAME=default
REM Run this command to configure your shell:
REM     @FOR /f "tokens=*" %i IN ('docker-machine env default') DO @%i

C:\Projects\health-spring-boot\health-spring-boot-systemone>@FOR /f "tokens=*" %i IN ('docker-machine env default') DO @%i

C:\Projects\health-spring-boot\health-spring-boot-systemone>docker version
Client:
 Version:      1.11.1
 API version:  1.23
 Go version:   go1.5.4
 Git commit:   5604cbe
 Built:        Tue Apr 26 23:44:17 2016
 OS/Arch:      windows/amd64

Server:
 Version:      1.11.1
 API version:  1.23
 Go version:   go1.5.4
 Git commit:   5604cbe
 Built:        Wed Apr 27 00:34:20 2016
 OS/Arch:      linux/amd64
```

### Login to docker

```
docker login
```

### Build docker image

```
C:\Projects\health-spring-boot\health-spring-boot-systemone>docker build -t pschlae/health-spring-boot-systemone .
```

### Push docker image to repo

```
C:\Projects\health-spring-boot\health-spring-boot-triamed>docker push pschlae/health-spring-boot-systemone:latest
```

## Docker and CoreOS

If you set up already CoreOS with Vagrant (or any provider for CoreOS) then

```
vagrant ssh core-01 -- -A
docker login
docker run pschlae/health-spring-boot-systemone
```

to stop

```
core@core-01 ~ $ docker ps
CONTAINER ID        IMAGE                 COMMAND                  CREATED             STATUS              PORTS               NAMES
16d83f2df844        pschlae/health-spring-boot-systemone   "java -Djava.security"   24 minutes ago      Up 24 minutes                           nostalgic_mietner
core@core-01 ~ $ docker stop nostalgic_mietner
```



