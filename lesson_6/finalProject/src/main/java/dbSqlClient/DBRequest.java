package dbSqlClient;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBRequest {

	private static String user = "root";
	private static String password = "root";
	private static String serverName = "localhost";
	private static String portNumber = "3306";
	private static String configuration = "sys?useSSL=false&serverTimezone=UTC";

	public Connection getConnection() {

		Connection connection = null;
		try {
			String url = "jdbc:mysql://" + serverName + ":" + portNumber + "/" + configuration;
			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			System.out.println("Ошибка соединения: \n" + e.getMessage());
		}
		return connection;
	}

	public String getValueParam(String paramName) {
		Statement statement;
		Connection connection = null;
		ResultSet resultSet;
		String result = null;
		String query = "select " + paramName + " from test_automation.sentmaildata";
		try {
			connection = getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			if (resultSet.next()) {
				result = resultSet.getString(1);
			}
			connection.close();
		} catch (SQLException e) {
			System.out.println("Ошибка загрузки данных из БД: \n" + e.getMessage());
		}
		return result;
	}

}
