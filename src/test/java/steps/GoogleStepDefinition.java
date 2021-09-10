package steps;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.openqa.selenium.PageLoadStrategy.EAGER;

public class GoogleStepDefinition {
    private WebDriver driver;
    private static ChromeOptions options = new ChromeOptions();

    @Dado("que el usuario se encuentre en google")
    public void queElUsuarioSeEncuentreEnGoogle() {
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");
        options.addArguments("disable-infobars");
        options.setPageLoadStrategy(EAGER);
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver(options);
        driver.get("http://www.google.com");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @Cuando("busque realice la búsqueda del término {string}")
    public void busqueRealiceLaBúsquedaDelTérmino(String atributo) throws InterruptedException {
        WebElement element = driver.findElement(By.xpath("//input[@title='Buscar']"));
        element.sendKeys(atributo);
        element.sendKeys(Keys.ENTER);
    }

    @Entonces("verá el término en la búsqueda de google {string}")
    public void veráElTérminoEnLaBúsquedaDeGoogle(String atributo) {
        WebElement element = driver.findElement(By.xpath("//div[@id='search']/div/div/div[3]//h3"));
        assertEquals(element.getText().split(" ")[0], atributo);
    }

    @After
    public void cerrarNavegador(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "name");
        }
        driver.quit();
    }

}
