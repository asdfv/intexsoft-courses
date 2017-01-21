package pattern.behavioral.command.texteditor;

public class DeleteCommand implements Command {
	
	TextEditor textEditor;

	@Override
	public void execute() {
		textEditor.deleteSymbol();
	}

	@Override
	public String toString() {
		return "del";
	}

	public DeleteCommand(TextEditor textEditor) {
		this.textEditor = textEditor;
	}
}
