FROM openjdk:8
WORKDIR /usr/Lab1/
COPY ./src/* /usr/Lab1/src
COPY ./lib/* /usr/Lab1/lib
RUN javac -cp "/usr/Lab1/src;/usr/Lab1/lib/*" /usr/Lab1/src/com/miniSysY/P1/*.java