package services;
/**
 * @author Antoan Hristov and Patrick Wakil
 * @date 2018-02-19
 * Configuration file for database credentials
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration {

	private Properties properties;

	private static Configuration instance;

	private Configuration() {
		this.properties = new Properties();
		//TODO make the test.properties variable (use a system variable?)
		String confLocation = System.getProperty("app.properties");
		//TODO design a fallback if the system variable is not set
		try (InputStream is = new FileInputStream(new File(confLocation))) {
			properties.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static Configuration getInstance() {
		if (instance == null) {
			instance = new Configuration();
		}
		return instance;

	}

	public String getConfigurationValue(String configurationKey) {
		return properties.getProperty(configurationKey);
	}

}
