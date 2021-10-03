FROM gcc:latest
WORKDIR /app/
COPY lex.c ./
RUN gcc lex.c -o lex
RUN chmod +x lex