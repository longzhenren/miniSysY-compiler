FROM openjdk
USER root
WORKDIR /home/compile/
COPY ./src/com/miniSysY/md/* ./src/com/miniSysY/md/
COPY ./lib/* ./lib/
WORKDIR ./src/
RUN javac -cp .:../lib/* ./com/miniSysY/md/*.java