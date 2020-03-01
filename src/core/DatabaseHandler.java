package core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseHandler extends Configs {

    private Connection dbConnection;

    public Connection getDatabaseConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

        Class.forName("com.mysql.cj.jdbc.Driver");

        return dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);
    }

    public void signUpUser(String name, String password) {
        try {
            String insert = "INSERT INTO " + Constants.USERS_TABLE + "(" + Constants.USERS + "," + Constants.PASSWORDS + ")" +
                    "VALUES(?,?)";

            PreparedStatement preparedStatement = getDatabaseConnection().prepareStatement(insert);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, password);

            preparedStatement.execute();
            dbConnection.close();
            System.out.println("user added");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
