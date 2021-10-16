FROM openjdk:8
WORKDIR /usr/Lab1/
COPY ./src/* /usr/Lab1/src/
COPY ./lib/* /usr/Lab1/lib/
RUN ls /usr/Lab1/
RUN ls /usr/Lab1/src
RUN ls /usr/Lab1/lib
RUN ls /usr/Lab1/src/com/miniSysY/P1
RUN javac -cp "/usr/Lab1/src;/usr/Lab1/lib/*" /usr/Lab1/src/com/miniSysY/P1/*.java