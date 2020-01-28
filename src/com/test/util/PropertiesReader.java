package com.test.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {

	static PropertiesReader propertiesReader;
	static Properties prop;

	private PropertiesReader() {
	}

	public static PropertiesReader getInstance() throws IOException {
		if (propertiesReader == null) {
			prop = new Properties();
			InputStream inputStream = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
			prop.load(inputStream);
			return new PropertiesReader();
		}
		return propertiesReader;
	}

	public String getProperty(String key) {
		return prop.getProperty(key);
	}

	
	public static void main(String[] args) throws IOException {
		String output =  PropertiesReader.getInstance().getProperty(PConstants.URL);
	
	System.out.println(output);
	}
	
	
}
