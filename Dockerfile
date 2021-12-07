FROM openjdk:8
USER root
WORKDIR /home/compile/
COPY ./src/com/miniSysY/P5/* ./src/com/miniSysY/P5/
COPY ./lib/* ./lib/
WORKDIR ./src/
RUN javac -cp .:../lib/* ./com/miniSysY/P5/*.java