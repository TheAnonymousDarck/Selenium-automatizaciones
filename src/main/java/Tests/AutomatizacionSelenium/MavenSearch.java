package Tests.AutomatizacionSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MavenSearch {
    public static void main(String[] args) {
        String webDriverPath = "D:\\Carrera\\11vo semestre\\Medicion de calidad\\projects\\driver\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", webDriverPath);

        WebDriver driver = new ChromeDriver();

        try {
            // Navegar a Maven Central
            driver.get("https://mvnrepository.com/");

            // Buscar el campo de búsqueda e introducir el nombre del paquete
            WebElement searchBox = driver.findElement(By.id("query"));
            searchBox.sendKeys("selenium-java");

            // Hacer clic en el botón de búsqueda
            driver.findElement(By.cssSelector(".search-submit")).click();

            // Esperar y verificar si el paquete aparece en los resultados
            WebElement result = driver.findElement(By.partialLinkText("org.seleniumhq.selenium:selenium-java"));

            if (result.isDisplayed()) {
                System.out.println("El paquete 'selenium-java' fue encontrado.");
            } else {
                System.out.println("El paquete no fue encontrado.");
            }
        } finally {
            // Cerrar el navegador
            driver.quit();
        }
    }
}
