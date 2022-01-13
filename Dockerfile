FROM openjdk
USER root
WORKDIR /home/compile/
COPY ./src/com/miniSysY/sc/* ./src/com/miniSysY/sc/
COPY ./lib/* ./lib/
WORKDIR ./src/
RUN javac -cp .:../lib/* ./com/miniSysY/sc/*.java