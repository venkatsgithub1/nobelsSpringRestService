package demo.springboot.rest.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DAOProperties {

	private static final String PROPERTIES_FILE = "/dao.properties";
	private static final Properties PROPERTIES;

	static {
		System.out.println("!!!!!!!!!!!!");
		System.out.println(System.getProperty("user.dir"));
		System.out.println("!!!!!!!!!!!!");
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		InputStream properties = null;
		try {
			properties = classLoader.getResource(PROPERTIES_FILE).openStream();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		PROPERTIES = new Properties();
		try {
			if (properties != null) {
				PROPERTIES.load(properties);
			} else {
				throw new RuntimeException("Properties file could not be loaded");
			}
		} catch (IOException e) {
			throw new RuntimeException("Properties file could not be loaded", e);
		}
	}

	public String getProperty(String key) {
		String value = PROPERTIES.getProperty(key);

		if (value == null) {
			throw new RuntimeException("Property is invalid.");
		}

		return value.trim();
	}
}
