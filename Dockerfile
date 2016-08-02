# Ubuntu 14.04
# Oracle Java JDK 1.8.0_45 64 bit
# Maven 3.3.3
# Git 1.9.1
# Nano editor
# Apache Tomcat 8.0.22

# extend
FROM ubuntu:14.04

MAINTAINER Piero Divasto (pdivasto@gmail.com)

# update dpkg repositories
RUN apt-get update

# install wget to download files
RUN apt-get install -y wget

# download maven apache-maven-2.2.1-bin.tar.gz
ENV maven_filename apache-maven-2.2.1-bin.tar.gz
RUN wget --no-verbose -O /tmp/$maven_filename http://archive.apache.org/dist/maven/binaries/apache-maven-2.2.1-bin.tar.gz

# install maven
RUN tar xzf /tmp/$maven_filename -C /opt/
RUN ln -s /opt/apache-maven-2.2.1 /opt/maven
RUN ln -s /opt/maven/bin/mvn /usr/local/bin
RUN rm -f /tmp/$maven_filename
ENV MAVEN_HOME /opt/maven

# install git
RUN apt-get install -y git

# install nano
RUN apt-get install -y nano

ENV java_jdk_filename jdk-8u45-linux-x64.tar.gz
ENV java_version jdk1.8.0_45

# download java JDK 1.8.0_45
RUN wget --no-cookies --header "Cookie: oraclelicense=accept-securebackup-cookie" -O /tmp/$java_jdk_filename http://download.oracle.com/otn-pub/java/jdk/8u45-b14/$java_jdk_filename

# install jdk
RUN mkdir /opt/java-jdk-8 && tar -zxf /tmp/$java_jdk_filename -C /opt/java-jdk-8

# set java environment variable
ENV JAVA_HOME /opt/java-jdk-8/$java_version
ENV PATH $JAVA_HOME/bin:$PATH

# configure symbolic links for the java and javac executables
RUN update-alternatives --install /usr/bin/java java $JAVA_HOME/bin/java 20000 && update-alternatives --install /usr/bin/javac javac $JAVA_HOME/bin/javac 20000

# download tomcat 8
RUN wget --no-verbose -O /tmp/apache-tomcat-8.5.4.tar.gz http://ftp.wayne.edu/apache/tomcat/tomcat-8/v8.5.4/bin/apache-tomcat-8.5.4.tar.gz

# install tomcat 8
RUN tar xzf /tmp/apache-tomcat-8.5.4.tar.gz -C /opt/

ENV CATALINA_HOME /opt/apache-tomcat-8.5.4
ENV PATH $CATALINA_HOME/bin:$PATH

ADD tomcat-users.xml $CATALINA_HOME/conf/

# git clone source code
RUN mkdir -p /tmp/build/
RUN cd /tmp/build/ && git clone https://github.com/lijingpeng/imgsim.git
# RUN cd /tmp/build/imgsim && mvn -q dependency:resolve
RUN cd /tmp/build/imgsim && mvn -q -DskipTests=true package \
    && rm -rf $CATALINA_HOME/webapps/* \
    && mv imgsim-web/target/*.war $CATALINA_HOME/webapps/ROOT.war \
    && cd / && rm -rf /tmp/build

EXPOSE 8080

CMD["catalina.sh","run"]
