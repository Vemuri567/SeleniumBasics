package Selenium;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfigProperties {

    public static String fetchProperties(String key) throws IOException {
        FileInputStream fs=new FileInputStream("./src/Config/App.properties");
        Properties prop=new Properties();
        prop.load(fs);
        return (prop.get(key).toString());
    }
}
