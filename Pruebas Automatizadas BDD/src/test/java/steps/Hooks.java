package steps;

import java.time.Duration;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

// La clase Hooks extiende de BaseSteps para poder acceder al driver
public class Hooks extends BaseSteps {

    // El hook @Before se ejecuta antes
    @Before
    public void setUp() {
        // Se inicializa el driver y el wait que estan en la clase BaseSteps
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // El hook @After se ejecuta despues de cada escenario.
    @After
    public void tearDown(Scenario scenario) {
        // Se verifica si el escenario fallo.
        if (scenario.isFailed()) {
            // Toma captura
            System.out.println("El escenario ha fallado. Tomando captura de pantalla.");
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            // Se adjunta la captura al reporte de Cucumber
            scenario.attach(screenshot, "image/png", "Captura de escenario fallido");
        }
        

        if(driver != null) {
            driver.quit();
        }
    }
}