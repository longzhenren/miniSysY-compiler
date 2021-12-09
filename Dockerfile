FROM openjdk:8
USER root
WORKDIR /home/compile/
COPY ./src/com/miniSysY/P7/* ./src/com/miniSysY/P7/
COPY ./lib/* ./lib/
WORKDIR ./src/
RUN javac -cp .:../lib/* ./com/miniSysY/P7/*.java