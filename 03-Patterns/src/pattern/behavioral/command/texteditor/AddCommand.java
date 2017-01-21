package pattern.behavioral.command.texteditor;

public class AddCommand implements Command {
	
	TextEditor textEditor;

	@Override
	public void execute() {
		textEditor.addSymbol();
	}
	
	@Override
	public String toString() {
		return "add";
	}
	
	public AddCommand(TextEditor textEditor) {
		this.textEditor = textEditor;
	}
}
