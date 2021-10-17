FROM openjdk:8
WORKDIR /home/compile/
COPY ./src/com/miniSysY/P1/* ./src/com/miniSysY/P1/
COPY ./lib/* ./lib/
WORKDIR ./src/
RUN javac -cp .;../lib/* ./com/miniSysY/P1/*.java