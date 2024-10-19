package Tests.AutomatizacionSelenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class TestDragAndDrop {

    private WebDriver driver;
    private Actions action;
    private String site;
    private Map<String, String> answers;

    @Before
    public void setUp() {
        this.site = "http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html";

        // Configurar el WebDriver y las acciones
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        action = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Diccionario de elementos para el drag and drop
        answers = new HashMap<>();
        answers.put("//*[@id='box1']", "//*[@id='box101']");
        answers.put("//*[@id='box2']", "//*[@id='box102']");
        answers.put("//*[@id='box3']", "//*[@id='box103']");
        answers.put("//*[@id='box4']", "//*[@id='box104']");
        answers.put("//*[@id='box5']", "//*[@id='box105']");
        answers.put("//*[@id='box6']", "//*[@id='box106']");
        answers.put("//*[@id='box7']", "//*[@id='box107']");
    }

    @Test
    public void testDragAndDrop() {
        // Navegar al sitio y maximizar la ventana
        driver.get(site);
        driver.manage().window().maximize();

        // Realizar drag and drop para cada par de elementos
        for (Map.Entry<String, String> entry : answers.entrySet()) {
            WebElement element = driver.findElement(By.xpath(entry.getKey()));
            WebElement target = driver.findElement(By.xpath(entry.getValue()));
            action.dragAndDrop(element, target).perform();
            sleep(); // Pausar 1 segundo entre acciones
        }
    }

    @After
    public void tearDown() {
        // Cerrar el navegador
        if (driver != null) {
            driver.quit();
        }
    }

    // Método auxiliar para hacer una pausa
    private void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.getCause();
        }
    }
}
