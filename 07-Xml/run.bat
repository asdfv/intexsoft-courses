rd /s /q src\webapp\WEB-INF\classes
md src\webapp\WEB-INF\classes
cd src
xcopy /y resources webapp\WEB-INF\classes\resources
cd ..
javac -sourcepath src -d src\webapp\WEB-INF\classes -classpath src;src/webapp/WEB-INF/lib/* src\by\intexsoft\vasili\userapp\model\*
javac -sourcepath src -d src\webapp\WEB-INF\classes -classpath src;src/webapp/WEB-INF/lib/* src\by\intexsoft\vasili\userapp\controller\*
javac -sourcepath src -d src\webapp\WEB-INF\classes -classpath src;src/webapp/WEB-INF/lib/* src\by\intexsoft\vasili\userapp\repository\*
javac -sourcepath src -d src\webapp\WEB-INF\classes -classpath src;src/webapp/WEB-INF/lib/* src\by\intexsoft\vasili\userapp\service\*
cd src/webapp
jar -cvf ../../userapp.war *
cd ../..
rd /s /q d:\apache-tomcat-9.0.0.M17\webapps\userapp
rd /s /q d:\apache-tomcat-9.0.0.M17\work\Catalina\localhost\
copy /y userapp.war d:\apache-tomcat-9.0.0.M17\webapps
"startup.bat - 9.0M.lnk"