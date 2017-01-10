package task6;

import java.io.File;

public class FolderService {
	
	private static final String PATH = "D://!ForEclipse/";
	
	//Create folder
	public static void createFolder(String folderName) {
		
		File folder = new File(PATH + folderName);
		
		if (!folder.exists()) {
			System.out.println("Creating folder: " + PATH + folderName);
			boolean isCreate = false;
			
			try {
				folder.mkdir();
				isCreate = true;
			} catch (SecurityException secExc) {
				secExc.printStackTrace();
				System.out.println("SecurityException catched");
			}
			if (isCreate) {
				System.out.println("Folder created");
			}
		} else {
			System.out.println("Folder '" + PATH + folderName + "' already exist");
		}
	}
	
	// Delete all folder in PATH
	public static void deleteFolders() {
		
		File path = new File(PATH);
				
		System.out.println("Deleting all folder in " + PATH);
		
		for (File file : path.listFiles()) {
			if(file.isDirectory()){
				try {
					file.delete();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	// Print folder list
	public static void listFolders() {
		
		File path = new File(PATH);
		
		File[] folderList = path.listFiles();
		
		System.out.println("Folders in " + PATH + ":");
		
		for (File file : folderList) {
			if(file.isDirectory()) {
				System.out.println(file.getName());
			}
		}
	}
}
