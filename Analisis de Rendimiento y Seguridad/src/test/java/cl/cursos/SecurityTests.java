package cl.cursos;

import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class SecurityTests {
	private final String BASE_URI = "https://reqres.in";
	private final String API_KEY = "reqres-free-v1";

    // --- Pruebas de autenticacion
    @Test
    public void testLoginExitosoRetornaToken() {
        // Esta prueba simula un login exitoso.
        String requestBody = "{\"email\": \"eve.holt@reqres.in\", \"password\": \"cityslicka\"}";

        given()
            .baseUri(BASE_URI)
            .header("x-api-key", API_KEY)
            .contentType("application/json")
            .body(requestBody)
        .when()
            .post("/api/login")
        .then()
            .statusCode(200)
            // Se valida que la respuesta de un login exitoso contenga un token.
            .body("token", not(emptyOrNullString()));
    }
    
    @Test
    public void testLoginFallidoRetornaError() {
        // Esta prueba simula un token invalido mediante un login fallido
        String requestBody = "{\"email\": \"prueba@login.cl\"}";

        given()
            .baseUri(BASE_URI)
            .header("x-api-key", API_KEY)
            .contentType("application/json")
            .body(requestBody)
        .when()
            .post("/api/login")
        .then()
            // Se espera un codigo 400 por una solicitud incorrecta
            .statusCode(400)
            .body("error", equalTo("Missing password"));
    }
    
    @Test
    public void testAccesoSinApiKeyRetornaError() {
    	
    	String requestBody = "{\"name\": \"Fabian\", \"job\": \"Estudiante\"}";
        //Se valida que intentar acceder a un recurso sin la API Key
        given()
            .baseUri(BASE_URI)
            .body(requestBody)
            //No se envia el header "x-api-key"
        .when()
            .post("/api/users")
        .then()
            // Se espera un codigo 401 
            .statusCode(401)
            .body("error", equalTo("Missing API key"));
    }

}
