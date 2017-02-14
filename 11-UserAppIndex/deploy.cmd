set tomcat=d:\apache-tomcat-9.0.0.M17
rd /s /q %tomcat%\work
copy /y build\libs\userapp.war %tomcat%\webapps\
"startup.bat - 9.0M.lnk"