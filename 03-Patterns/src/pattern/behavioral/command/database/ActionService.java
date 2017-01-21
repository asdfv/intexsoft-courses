package pattern.behavioral.command.database;

public class ActionService {
	
	Database database;
	
	private Command insert;
	private Command delete;
	
	public ActionService(Database database, Command insert, Command delete) {
		this.database = database;
		this.insert = insert;
		this.delete = delete;
	}
	
	public void actionInsert() {
		database.insert();
	}
	public void actionDelete() {
		database.delete();
	}
}
