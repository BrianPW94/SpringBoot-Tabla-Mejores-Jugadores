@ECHO OFF
SET MAVEN_PROJECTBASEDIR=%~dp0
SET MAVEN_OPTS=-Dmaven.multiModuleProjectDirectory=%MAVEN_PROJECTBASEDIR% %MAVEN_OPTS%
java -jar "%MAVEN_PROJECTBASEDIR%\.mvn\wrapper\maven-wrapper.jar" %*
