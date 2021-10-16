FROM openjdk:8
WORKDIR /usr/Lab1/
COPY ./src /usr/Lab1/src
COPY ./lib /usr/Lab1/lib
RUN javac -cp ".;..\lib\*" ./src/*.java
# RUN java -cp ".;..\lib\*" com.miniSysY.P1.Main < $input >