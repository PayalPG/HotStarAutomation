package utils;

import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadElements {

    Properties properties;
   // FileInputStream fis;

    public ReadElements()  {
        try {
            properties=new Properties();
            File src=new File("E:\\Rogers_Solaris\\Project\\framework\\HotStarAutomation\\src\\main\\java\\utils\\elements.properties");
            FileInputStream fis=new FileInputStream(src);
            properties.load(fis);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public String getProperties(String name) {
        return properties.getProperty(name);
    }

}
