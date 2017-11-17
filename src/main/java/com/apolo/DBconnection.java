package com.apolo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class DBconnection {

    private static Properties props;

    private static void loadProperties() {
        props = new Properties();
        try {
            props.load(new FileInputStream("src/main/resources/bundles/db.properties"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getProperties(String key) {
        return props.getProperty(key);
    }
}
