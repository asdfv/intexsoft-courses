package task6;

import java.util.Scanner;

// Type name 'exit' to exit program
public class Main {
	
	public static void main(String[] args) {
		
		boolean exit = false;
		
		while (!exit) {
			
			Scanner in = new Scanner(System.in);
			System.out.print("_________________\nEnter name: ");
			String name = in.nextLine();
			System.out.print("Enter surname: ");
			String surname = in.nextLine();
			
			switch (name + "_" + surname) {
			
			case "exit_":
				exit = true;
				break;
			case "_":
				FolderService.deleteFolders();
				break;
			case "ADMIN_ADMIN":
				FolderService.listFolders();
				break;
			default:
				FolderService.createFolder(name.toUpperCase() + "_" + surname.toUpperCase());
				break;
			}
		}
	}
}
