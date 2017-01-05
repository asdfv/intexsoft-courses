package manyClasses500;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

// Creating many POJO-classes in this package
public class BestClassGenerator {
	
	// Define number of classes to creating
	private static final int NUMBER_OF_CLASSES = 3;

	public static void main(String[] args) {
		
		for (int index = 0; index < NUMBER_OF_CLASSES; index++) {
			String code = codeGenerator(index);
			fileGenerator(index, code);
		}
	}
	
	public static String codeGenerator(int index) {
		
		String code = "package manyClasses500;\n" +
                "\n" +
                "class User" + index + " {\n" +
                "\n" +
                "    String name;\n" +
                "    byte age;\n" +
                "\n" +
                "    public void exist() {\n" +
                "    }\n" +
                "\n" +
                "    // Getters and Setters\n" +
                "    public String getName() {\n" +
                "        return name;\n" +
                "    }\n" +
                "\n" +
                "    public void setName(String name) {\n" +
                "        this.name = name;\n" +
                "    }\n" +
                "\n" +
                "    public byte getAge() {\n" +
                "        return age;\n" +
                "    }\n" +
                "\n" +
                "    public void setAge(byte age) {\n" +
                "        this.age = age;\n" +
                "    }\n" +
                "}";
		return code;
	}
	
	public static void fileGenerator(int index, String code) {
		
		File file = new File("src/manyClasses500/User" + index + ".java");
		
		try {
			if(!file.exists()){
				file.createNewFile();
			}
			PrintWriter out = new PrintWriter(file.getAbsoluteFile());
			try {
				out.print(code);
			} finally {
				out.close();
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
