FROM openjdk:8
WORKDIR /usr/Lab1/
COPY ./src/* /usr/Lab1/src/
COPY ./src/com/miniSysY/P1/* /usr/Lab1/src/com/miniSysY/P1/
COPY ./lib/* /usr/Lab1/lib/
RUN ls -R .
RUN javac -cp "/usr/Lab1/src;/usr/Lab1/lib/*" /usr/Lab1/src/com/miniSysY/P1/*.java