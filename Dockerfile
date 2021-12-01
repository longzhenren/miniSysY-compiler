FROM openjdk:8
USER root
WORKDIR /home/compile/
COPY ./src/com/miniSysY/P3/* ./src/com/miniSysY/P3/
COPY ./lib/* ./lib/
WORKDIR ./src/
RUN javac -cp .:../lib/* ./com/miniSysY/P3/*.java