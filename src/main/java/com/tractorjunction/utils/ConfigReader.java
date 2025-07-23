package com.tractorjunction.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private Properties properties;

    public ConfigReader(String environment) {
        properties = new Properties();
        String configFileName = String.format("config_%s.properties", environment.toLowerCase());

        try (InputStream input = getClass().getClassLoader().getResourceAsStream(configFileName)) {
            if (input == null) {
                throw new RuntimeException("Unable to find " + configFileName + " in resources folder");
            }
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load " + configFileName + ": " + e.getMessage(), e);
        }
    }

    public String getProperty(String key) {
        String value = properties.getProperty(key);
        if (value == null) {
            throw new RuntimeException("Property key '" + key + "' not found in config file");
        }
        return value;
    }

    public String getBrowser() {
        return getProperty("browser");
    }
}
