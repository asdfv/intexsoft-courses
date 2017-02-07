set classes=src\webapp\WEB-INF\classes
set source=src\java
set lib=src\webapp\WEB-INF\lib
set pack=src\java\by\intexsoft\vasili\userapp
set tomcatDir=d:\apache-tomcat-9.0.0.M17
set res=src\resources
xcopy /y %res%\*.* %classes%
javac -sourcepath %source% -d %classes% -classpath %source%;%lib%\* %pack%\model\*
javac -sourcepath %source% -d %classes% -classpath %source%;%lib%\* %pack%\controller\*
javac -sourcepath %source% -d %classes% -classpath %source%;%lib%\* %pack%\repository\*
javac -sourcepath %source% -d %classes% -classpath %source%;%lib%\* %pack%\service\*
javac -sourcepath %source% -d %classes% -classpath %source%;%lib%\* %pack%\service\impl\*
cd src/webapp
jar -cvf ../../userapp.war *
cd ../..
rd /s /q %tomcatDir%\webapps\userapp
rd /s /q %tomcatDir%\work\Catalina\localhost\
copy /y userapp.war %tomcatDir%\webapps
"startup.bat - 9.0M.lnk"