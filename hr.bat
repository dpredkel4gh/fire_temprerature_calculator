call mvn -B -s settings.xml -DskipTests=true clean install
call java -Dspring.profiles.active="local" -jar web/target/dependency/webapp-runner.jar web/target/*.war