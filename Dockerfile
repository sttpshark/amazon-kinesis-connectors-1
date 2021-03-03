FROM java:8-alpine

RUN apk add --update ca-certificates && rm -rf /var/cache/apk/* && \
  find /usr/share/ca-certificates/mozilla/ -name "*.crt" -exec keytool -import -trustcacerts \
  -keystore /usr/lib/jvm/java-1.8-openjdk/jre/lib/security/cacerts -storepass changeit -noprompt \
  -file {} -alias {} \; && \
  keytool -list -keystore /usr/lib/jvm/java-1.8-openjdk/jre/lib/security/cacerts --storepass changeit

ENV MAVEN_VERSION 3.5.4
ENV MAVEN_HOME /usr/lib/mvn
ENV PATH $MAVEN_HOME/bin:$PATH

RUN wget http://archive.apache.org/dist/maven/maven-3/$MAVEN_VERSION/binaries/apache-maven-$MAVEN_VERSION-bin.tar.gz && \
  tar -zxvf apache-maven-$MAVEN_VERSION-bin.tar.gz && \
  rm apache-maven-$MAVEN_VERSION-bin.tar.gz && \
  mv apache-maven-$MAVEN_VERSION /usr/lib/mvn

RUN apk update && apk upgrade && \
    apk add --no-cache git openssh

RUN mkdir -p /usr/src/app

WORKDIR /usr/src/app

RUN cd /usr/src/app && git clone https://github.com/sttpshark/amazon-kinesis-connectors-1.git

RUN cd amazon-kinesis-connectors-1/samples && mvn package

ENTRYPOINT [ "/usr/src/app/amazon-kinesis-connectors-1/samples/target/appassembler/bin/dynamodb-sample" ]

