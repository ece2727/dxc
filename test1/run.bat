@REM Required java declare location of java
set JAVA_HOME=C:\Program Files\Java\jdk-17.0.2

cd .\frontend
start cmd /c npm start
cd ..


cd .\backend
start cmd /c mvnw spring-boot:run

exit