package pattern.behavioral.command.texteditor;

import java.util.LinkedList;

public class TextEditorService {
	LinkedList<Command> queue  = new LinkedList<>();
	LinkedList<Command> trash = new LinkedList<>();
	TextEditor textEditor;
	Command addCommand;
	Command deleteCommand;
	
	public TextEditorService(TextEditor textEditor, Command addCommand, Command deleteCommand) {
		this.textEditor = textEditor;
		this.addCommand = addCommand;
		this.deleteCommand = deleteCommand;
	}
	
	public void call(String actionType) {
		switch (actionType) {
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
