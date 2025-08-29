package steps;

import org.openqa.selenium.By;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;

// Se extiende de BaseSteps para usar el driver y wait compartidos
public class LoginSteps extends BaseSteps {

    @Given("el usuario se encuentra en la pagina de inicio de sesion")
    public void abrirPaginaInicioSesion() {
        driver.manage().window().maximize();
        driver.get("https://courses.ultimateqa.com/users/sign_in");
    }

    @When("el usuario ingresa el correo {string} y la contrasena {string}")
    public void ingresaCredenciales(String email, String password) {
        driver.findElement(By.id("user[email]")).sendKeys(email);
        driver.findElement(By.id("user[password]")).sendKeys(password);
    }
    
    @And("hace clic en el boton de inicio de sesion")
    public void clicBotonInicioSesion() {
        driver.findElement(By.cssSelector("button[type='submit']")).click();
    }

    @Then("el sistema muestra el resultado {string}")
    public void sistemaMuestraResultado(String resultado) {
        if (resultado.equalsIgnoreCase("exitoso")) {
            Assertions.assertEquals("https://courses.ultimateqa.com/collections", driver.getCurrentUrl(), "La URL despues del login no es la esperada.");
        } else if (resultado.equalsIgnoreCase("fallido")) {
            By errorLocator = By.cssSelector(".form-error__list-item");
            wait.until(ExpectedConditions.visibilityOfElementLocated(errorLocator));
            boolean isErrorVisible = driver.findElement(errorLocator).isDisplayed();
            Assertions.assertTrue(isErrorVisible, "No se mostro el mensaje de error de credenciales invalidas.");
        }
    }
}