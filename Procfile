heroku ps:scale worker=1
web: java $JAVA_OPTS -cp target/classes:target/dependency/* com.github.programmershub.DiscordBot -Dserver.port=$PORT --port $PORT