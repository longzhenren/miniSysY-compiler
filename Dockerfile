FROM openjdk:8
USER root
WORKDIR /home/compile/
COPY ./src/com/miniSysY/P6/* ./src/com/miniSysY/P6/
COPY ./lib/* ./lib/
WORKDIR ./src/
RUN javac -cp .:../lib/* ./com/miniSysY/P6/*.java