package Tests.AutomatizacionSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Weather {
    public static void main(String[] args) {

        String url = "https://www.clima.com/mexico/";

        String webDriverPath = "D:\\Carrera\\11vo semestre\\Medicion de calidad\\projects\\driver\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", webDriverPath);

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Navegar a la URL
        driver.get(url);

        // Hacer clic en el enlace de interés
        driver.findElement(By.xpath("//*[@id=\"page\"]/main/div[4]/div[1]/section[1]/div/ul/li[6]/a")).click();
        sleep(2000);

        // Introducir el estado/clima en el campo de búsqueda
        WebElement searchField = driver.findElement(By.xpath("//*[@id=\"term\"]"));
        searchField.sendKeys("guanajuato");
        sleep(5000);

        // Hacer clic en el segundo resultado
        driver.findElement(By.xpath("//*[@id=\"cityTable\"]/div/article/section/ul/li[2]/h2/a")).click();
        sleep(3000);

        // Obtener los datos de clima
        WebElement weatherTable = driver.findElement(By.xpath("//*[@id=\"cityTable\"]/div[1]/ul"));
        String txtColumns = weatherTable.getText();

        // Separar los datos por líneas
        String[] listData = txtColumns.split("\n");
        List<String> todaysWeather = new ArrayList<>();
        for (String line : listData) {
            if (line.contains("Hoy")) {
                break;
            }
            todaysWeather.add(line);
        }

        // Procesar los datos en listas para horas, temperatura y velocidad del viento
        List<String> horas = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        List<String> v_viento = new ArrayList<>();

        for (int i = 1; i < todaysWeather.size(); i += 3) {
            horas.add(todaysWeather.get(i - 1));
            temp.add(todaysWeather.get(i));
            v_viento.add(todaysWeather.get(i + 1));
        }

        for (int i = 0; i < horas.size(); i++) {
            System.out.println(horas.get(i) + "," + temp.get(i) + "," + v_viento.get(i));
        }

        driver.quit();
    }

    private static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.getCause();
        }
    }
}
