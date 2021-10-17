FROM openjdk:8
USER root
WORKDIR /home/compile/
COPY ./src/com/miniSysY/P1/* ./src/com/miniSysY/P1/
COPY ./lib/* ./lib/
WORKDIR ./src/
RUN javac -cp .:../lib/* ./com/miniSysY/P1/*.java