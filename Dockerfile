FROM openjdk:8
USER root
WORKDIR /home/compile/
COPY ./src/com/miniSysY/P2/* ./src/com/miniSysY/P2/
COPY ./lib/* ./lib/
WORKDIR ./src/
RUN javac -cp .:../lib/* ./com/miniSysY/P2/*.java