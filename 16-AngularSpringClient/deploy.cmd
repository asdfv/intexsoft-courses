# Change your Tomcat directory below:
set tomcat=d:\apache-tomcat-9.0.0.M17

copy /y build\libs\userapp.war %tomcat%\webapps\
cd /d %tomcat%\bin
startup.bat