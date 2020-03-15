FROM oracle/graalvm-ce:latest

WORKDIR /opt

RUN yum -y install wget

RUN gu install native-image
RUN alternatives --install /usr/bin/native-image native-image /opt/graalvm-ce-java8-$GRAAL_VERSION/bin/native-image 20000

RUN wget https://raw.githubusercontent.com/technomancy/leiningen/stable/bin/lein \
    && chmod +x /opt/lein
RUN /opt/lein
RUN alternatives --install /usr/bin/lein lein /opt/lein 20000

CMD java -version