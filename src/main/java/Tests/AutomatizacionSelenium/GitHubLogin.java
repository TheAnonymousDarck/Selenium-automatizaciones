package Tests.AutomatizacionSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GitHubLogin {

    public static void main(String[] args) {

        String passwordGH = "------";
        String userGH = "------";

        String webDriverPath = "D:\\Carrera\\11vo semestre\\Medicion de calidad\\projects\\driver\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", webDriverPath);

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.github.com/login");
        driver.manage().window().maximize();

        WebElement user = driver.findElement(By.id("login_field"));
        user.sendKeys(userGH);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.getCause();
        }

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys(passwordGH);


        user.sendKeys(Keys.ENTER);
    }
}
