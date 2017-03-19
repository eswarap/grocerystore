config:WEBAPP_RUNNER_OPTS="--context-xml grocerystore-1.0.xml"
deploy:war --war app.war --includes grocerystore-1.0.xml
web: java $JAVA_OPTS -jar target/dependency/webapp-runner.jar --port $PORT target/*.war

