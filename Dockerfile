FROM ubuntu:14.04
MAINTAINER Camilo Varela

RUN apt-get update	&& \
	apt-get install -y software-properties-common

RUN add-apt-repository -y ppa:webupd8team/java	&& \
	apt-get update

RUN echo oracle-java8-installer shared/accepted-oracle-license-v1-1 select true | sudo /usr/bin/debconf-set-selections
RUN apt-get install -y oracle-java8-installer

RUN mkdir rest-service
ADD /target/gs-rest-service-0.1.0.jar /rest-service
ADD entrypoint.sh /rest-service/entrypoint.sh
RUN chmod +x /rest-service/entrypoint.sh

ENTRYPOINT ["/rest-service/entrypoint.sh"]

