package december;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

//Copy text from file to file
public class Task5 {

	public static String FILE_TO_READ = "D://!ForEclipse/MyReadFile.txt";
	public static String FILE_TO_WRITE = "D://!ForEclipse/MyWriteFile.txt";

	public static void main(String[] args) {
		try {
			ArrayList<String> lines = linesConvertor(fileReader(FILE_TO_READ));
			fileWriter(FILE_TO_WRITE, lines);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void fileWriter(String fileName, ArrayList<String> lines) throws IOException {

		File file = new File(fileName);

		try (PrintWriter writer = new PrintWriter(fileName)) {
			if (!file.exists()) {
				file.createNewFile();
			}
			for (String line : lines) {
				writer.println(line + " - Проверено");
			}
		}
	}

	public static ArrayList<String> fileReader(String fileName) throws IOException {
		ArrayList<String> lines = new ArrayList<String>();
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

			for (String line; (line = br.readLine()) != null;) {
				lines.add(line);
			}
		}
		return lines;
	}

	public static ArrayList<String> linesConvertor(ArrayList<String> lines) {
		for (String line : lines) {
			line = line + " - проверено";
		}
		return lines;
	}
}
