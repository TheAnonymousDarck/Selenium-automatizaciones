package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public interface SeleniumContract {
    String CHROME_DRIVER_PATH = "D:\\Carrera\\11vo semestre\\Medicion de calidad\\projects\\driver\\chromedriver.exe";
    String scrappingUrl = "";
    WebDriver driver = new ChromeDriver();
}