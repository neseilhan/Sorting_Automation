package dev.neseilhan.sortingautomation.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
/**
 * Utility class for reading configuration properties.
 *
 * <p>Loads properties from config.properties file
 * located in the resources folder.</p>
 *
 * Provides methods to retrieve:
 * - String values
 * - Integer values
 *
 * @author Nese Ilhan
 * @version 1.0
 */
public class ConfigReader {

    private static final Properties properties = new Properties();

    static {
        try (InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                throw new RuntimeException("config.properties file not found.");
            }
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties", e);
        }
    }

    private ConfigReader() {
    }

    /**
     * Retrieves a property value by key.
     *
     * @param key property key
     * @return property value
     */
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }


    /**
     * Retrieves a property value or returns default if missing.
     *
     * @param key          property key
     * @param defaultValue fallback value
     * @return property value or default
     */
    public static String getProperty(String key, String defaultValue) {
        String value = properties.getProperty(key);
        return value == null || value.trim().isEmpty() ? defaultValue : value.trim();
    }

    /**
     * Retrieves an integer property value.
     *
     * @param key property key
     * @return integer value
     */
    public static int getIntProperty(String key) {
        return Integer.parseInt(properties.getProperty(key));
    }
}