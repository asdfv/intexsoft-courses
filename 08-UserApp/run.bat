set classes=src\webapp\WEB-INF\classes
set source=src\java
set lib=src\webapp\WEB-INF\lib
set pack=src\by\intexsoft\vasili\userapp
REM cd src
REM xcopy /y resources\application.properties webapp\WEB-INF\classes\application.properties
REM xcopy /y resources\log4j.properties webapp\WEB-INF\classes\log4j.properties
REM cd ..
javac -sourcepath src -d %classes% -classpath %source%;%lib%\* %pack%\model\*
REM javac -sourcepath src -d %classes% -classpath %source%;%lib%\* %pack%\controller\*
REM javac -sourcepath src -d %classes% -classpath %source%;%lib%\* %pack%\repository\*
REM javac -sourcepath src -d %classes% -classpath %source%;%lib%\* %pack%\service\*
REM cd src/webapp
REM jar -cvf ../../userapp.war *
REM cd ../..
REM rd /s /q d:\apache-tomcat-9.0.0.M17\webapps\userapp
REM rd /s /q d:\apache-tomcat-9.0.0.M17\work\Catalina\localhost\
REM copy /y userapp.war d:\apache-tomcat-9.0.0.M17\webapps
REM "startup.bat - 9.0M.lnk"