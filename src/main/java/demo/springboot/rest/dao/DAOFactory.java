package demo.springboot.rest.dao;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class DAOFactory {
	private static String URL = "url";
	private static String DRIVER = "driver";
	private static String USERNAME = "username";
	private static String PASSWORD = "password";

	public static DAOFactory getInstance(String databaseName) {
		if (databaseName == null) {
			throw new RuntimeException("Database name is null");
		}

		// object to get dao properties defined in
		// properties file.
		DAOProperties daoProperties = new DAOProperties();

		// properties that will be used by DriverManagerDAO concrete class to get
		// connection to database.
		String url = daoProperties.getProperty(URL);
		String driver = daoProperties.getProperty(DRIVER);
		String username = daoProperties.getProperty(USERNAME);
		String password = daoProperties.getProperty(PASSWORD);

		// create instance variable of DAOFactory abstract class.
		DAOFactory instance;

		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		// instance gets DriverManagerDAOFactory constructor
		// so it can call getConnection method in that class
		// using variables that were taken from properties
		// file.
		instance = new DriverManagerDAOFactory(url, username, password);

		return instance;
	}

	abstract Connection getConnection() throws SQLException;
}
