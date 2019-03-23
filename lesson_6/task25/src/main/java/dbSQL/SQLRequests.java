package dbSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLRequests {

	public Connection getConnection() {
		String user = "root";
		String password = "root";
		Connection connection = null;
		try {
			String serverName = "localhost";
			String portNumber = "3306";
			String configuration = "sys?useSSL=false&serverTimezone=UTC";
			String url = "jdbc:mysql://" + serverName + ":" + portNumber + "/" + configuration;
			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			System.out.println("Ошибка соединения: \n" + e.getMessage());
		}
		return connection;
	}

	public String getValueParam(String paramName, String paramId) {
		Statement statement;
		Connection connection = null;
		ResultSet resultSet;
		String result = null;
		String query = "select " + paramName + " from test_automation.sentmaildata where id = " + paramId;
		try {
			connection = getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			System.out.println("From DataBase: ");
			while (resultSet.next()) {
				result = resultSet.getString(1);
				System.out.println(result);
			}
			connection.close();
		} catch (SQLException e) {
			System.out.println("Ошибка загрузки данных из БД: \n" + e.getMessage());
		}
		return result;
	}

}
