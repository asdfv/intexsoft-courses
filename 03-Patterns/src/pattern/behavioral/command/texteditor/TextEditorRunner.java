package pattern.behavioral.command.texteditor;

public class TextEditorRunner {
	public static void main(String[] args) {

		TextEditor textEditor = new TextEditor();
		
		ActionService actionService = new ActionService(
				textEditor, 
				new AddCommand(textEditor), 
				new DeleteCommand(textEditor)
		);
		
		actionService.addActionToQueue("add");
		actionService.addActionToQueue("add");
		actionService.addActionToQueue("add");
		actionService.addActionToQueue("del");
		actionService.addActionToQueue("add");
		actionService.addActionToQueue("del");
		
		actionService.printQueue();
		
		actionService.undo();
		actionService.undo();
		
		actionService.printQueue();
		
		actionService.redo();
		
		actionService.printQueue();
		
		actionService.runAll();
	}
}
