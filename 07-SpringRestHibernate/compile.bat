rd /s /q webapp\WEB-INF\classes
md webapp\WEB-INF\classes
xcopy /s /e /y src webapp\WEB-INF\classes
javac -sourcepath src -d webapp\WEB-INF\classes -classpath src;webapp/WEB-INF/lib/* src\by\intexsoft\vasili\userapp\model\*
javac -sourcepath src -d webapp\WEB-INF\classes -classpath src;webapp/WEB-INF/lib/* src\by\intexsoft\vasili\userapp\config\*
javac -sourcepath src -d webapp\WEB-INF\classes -classpath src;webapp/WEB-INF/lib/* src\by\intexsoft\vasili\userapp\controller\*
javac -sourcepath src -d webapp\WEB-INF\classes -classpath src;webapp/WEB-INF/lib/* src\by\intexsoft\vasili\userapp\repository\*
javac -sourcepath src -d webapp\WEB-INF\classes -classpath src;webapp/WEB-INF/lib/* src\by\intexsoft\vasili\userapp\service\*