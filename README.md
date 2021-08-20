# elasctic.jobs
Elasticsearch 7 jobs database


mvn clean install

export spring_profiles_active=dopf

nohup java -jar elastic.jobs-0.0.1-SNAPSHOT.jar -Dspring.profiles.active=dopf &
