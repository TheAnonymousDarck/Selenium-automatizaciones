package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstTest {
    
    public static void main(String[] args) {
        String webDriverPath = "D:\\Carrera\\11vo semestre\\Medicion de calidad\\projects\\driver\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", webDriverPath);
       

       WebDriver driver = new ChromeDriver();

       driver.get("https://www.google.com");

       driver.manage().window().maximize();
    }

}
