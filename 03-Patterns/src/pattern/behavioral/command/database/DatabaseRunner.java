package pattern.behavioral.command.database;

public class DatabaseRunner {
	
	public static void main(String[] args) {
		Database database = new Database();
		
		ActionService actionService = new ActionService(
				database, 
				new InsertCommand(database), 
				new DeleteCommand(database)
		);
		
		actionService.actionInsert();
		actionService.actionDelete();
		
	}
}
