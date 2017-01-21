package pattern.behavioral.command.texteditor;

import java.util.LinkedList;

public class ActionService {
	
	LinkedList<Command> queue;
	LinkedList<Command> trash;
	
	TextEditor textEditor;
	
	private Command addCommand;
	private Command deleteCommand;
	
	public ActionService(TextEditor textEditor, Command addCommand, Command deleteCommand) {
		this.textEditor = textEditor;
		this.addCommand = addCommand;
		this.deleteCommand = deleteCommand;
		this.queue = new LinkedList<>();
		this.trash = new LinkedList<>();
	}
	
	public void addActionToQueue(String action) {
		switch (action) {
		case "add":
			queue.add(addCommand);
			break;
		case "del":
			queue.add(deleteCommand);
			break;
		default:
			System.out.println("Wrong command!");;
		}
	}
	
	public void undo() {
		System.out.println("undo");
		trash.add(queue.pollLast());
	} 
	public void redo() {
		System.out.println("redo");
		queue.add(trash.pollLast());
	} 
	public void runAll() {
		System.out.println("Accept changes:");
		for (Command command : queue) {
			command.execute();
		}
	}
	public void printQueue() {
		System.out.println("\n-------start-------");
		for (Command command : queue) {
			System.out.println(command);
		}
		System.out.println("-------end-------\n");
	}
}
