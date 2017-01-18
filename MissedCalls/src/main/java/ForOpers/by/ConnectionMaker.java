package ForOpers.by;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionMaker {

    private static Connection connection = null;

    public ConnectionMaker() {

        Properties prop = new Properties();
        InputStream inputStream = null;

        try {
            inputStream = new FileInputStream("db.properties");
            prop.load(inputStream);

            connection = DriverManager.getConnection(prop.getProperty("URL"), prop.getProperty("USERNAME"), prop.getProperty("PASSWORD"));

        } catch (FileNotFoundException e) { e.printStackTrace();
        } catch (IOException e) { e.printStackTrace();
        } catch (SQLException e) { e.printStackTrace();
        } finally {
            try { if(inputStream != null) inputStream.close(); } catch (IOException e) { e.printStackTrace(); }
        }

    }

    public Connection getConnection() {
        return connection;
    }
}

