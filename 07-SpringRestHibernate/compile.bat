rd /s /q webapp\WEB-INF\classes\by\
javac -sourcepath src -d webapp\WEB-INF\classes -classpath src;webapp/WEB-INF/lib/* src\by\intexsoft\vasili\hibernate\model\*
javac -sourcepath src -d webapp\WEB-INF\classes -classpath src;webapp/WEB-INF/lib/* src\by\intexsoft\vasili\hibernate\config\*
javac -sourcepath src -d webapp\WEB-INF\classes -classpath src;webapp/WEB-INF/lib/* src\by\intexsoft\vasili\hibernate\controller\*
javac -sourcepath src -d webapp\WEB-INF\classes -classpath src;webapp/WEB-INF/lib/* src\by\intexsoft\vasili\hibernate\repository\*
javac -sourcepath src -d webapp\WEB-INF\classes -classpath src;webapp/WEB-INF/lib/* src\by\intexsoft\vasili\hibernate\service\*