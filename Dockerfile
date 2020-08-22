# start from a Node.js 10 (LTS) Image
FROM clojure:openjdk-8-lein

# create working directlry
WORKDIR /usr/src/app

# copy package files, get libraries, build uberjar
COPY src ./
COPY project.clj ./
RUN lein uberjar

# copy
COPY . .

# run
COPY target/uberjar/pure-west-0.1.0-SNAPSHOT-standalone.jar pure-west.jar
ENTRYPOINT ["java", "-jar", "pure-west.jar"]
