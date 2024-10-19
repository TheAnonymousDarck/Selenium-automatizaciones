package Tests.AutomatizacionSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonSearch {
    public static void main(String[] args) {
        String webDriverPath = "D:\\Carrera\\11vo semestre\\Medicion de calidad\\projects\\driver\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", webDriverPath);

        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://www.mercadolibre.com.mx/");

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.getCause();
            }

            WebElement searchBox = driver.findElement(By.className("nav-search-input"));
            searchBox.sendKeys("laptop Dell");

            driver.findElement(By.className("nav-search-btn")).click();

            WebElement result = driver.findElement(By.partialLinkText("Dell Inspiron"));

            if (result.isDisplayed()) {
                System.out.println("El producto 'Dell Inspiron' fue encontrado.");
            } else {
                System.out.println("El producto no fue encontrado.");
            }
        } finally {
            driver.quit();
        }
    }
}
