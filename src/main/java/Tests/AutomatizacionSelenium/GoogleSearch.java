package Tests.AutomatizacionSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearch {
    public static void main(String[] args) {
        String webDriverPath = "D:\\Carrera\\11vo semestre\\Medicion de calidad\\projects\\driver\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", webDriverPath);

        WebDriver driver = new ChromeDriver();

        // Navegar a Google
        driver.get("https://www.google.com");

        // Buscar el campo de búsqueda y enviar una consulta
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("automatización con Selenium");
        searchBox.submit();

        // Esperar y verificar si los resultados contienen un enlace
        boolean isLinkPresent = driver.findElement(By.partialLinkText("Selenium")).isDisplayed();

        System.out.println("¿Está presente el enlace de Selenium? " + isLinkPresent);

        // Cerrar el navegador
        driver.quit();
    }
}

