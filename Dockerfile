FROM openjdk:8
USER root
WORKDIR /home/compile/
COPY ./src/com/miniSysY/P8/* ./src/com/miniSysY/P8/
COPY ./lib/* ./lib/
WORKDIR ./src/
RUN javac -cp .:../lib/* ./com/miniSysY/P8/*.java