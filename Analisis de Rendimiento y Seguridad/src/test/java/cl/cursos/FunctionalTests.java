package cl.cursos;

import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class FunctionalTests {
	
	private final String BASE_URI = "https://reqres.in";
	private final String API_KEY = "reqres-free-v1";


    //Pruebas GET
    @Test
    public void testListarUsuariosRetornoOK() {
        //Se define la URI base para la peticion
        given()
            .baseUri(BASE_URI)
            .header("x-api-key", API_KEY)
        //Se ejecuta la peticion GET al endpoint de listar usuarios
        .when()
            .get("/api/users?page=2")
        //Se realizan las validaciones sobre la respuesta.
        .then()
            //Se valida que el codigo de estado sea 200
            .statusCode(200)
            //Se valida que el campo "page" en la respuesta sea igual a 2
            .body("page", equalTo(2))
            //Se valida que la lista "data" no este vacia
            .body("data", not(empty()));
    }

    @Test
    public void testObtenerUsuarioUnicoRetornoOK() {
        given()
            .baseUri(BASE_URI)
            .header("x-api-key", API_KEY)
        .when()
            .get("/api/users/2")
        .then()
            .statusCode(200)
            //Se valida que el ID del usuario en la respuesta es el correcto.
            .body("data.id", equalTo(2))
            //Se valida que el email del usuario contiene el formato esperado.
            .body("data.email", containsString("@reqres.in"));
    }

    //Pruebas POST
    @Test
    public void testCrearUsuarioRetornoCreado() {
        String requestBody = "{\"name\": \"Fabian\", \"job\": \"Desarrollador\"}";

        given()
            .baseUri(BASE_URI)
            .header("x-api-key", API_KEY)
            .contentType("application/json")
            .body(requestBody)
        .when()
            .post("/api/users")
        .then()
            //Se valida que el codigo de estado sea 201 
            .statusCode(201)
            //Se valida que la respuesta contenga los datos enviados
            .body("name", equalTo("Fabian"))
            .body("job", equalTo("Desarrollador"))
            .body("id", not(emptyOrNullString()));
    }

    // --- Prueba PUT ---
    @Test
    public void testActualizarUsuarioRetornoOK() {
        String requestBody = "{\"name\": \"Fabian\", \"job\": \"Trabajador\"}";

        given()
            .baseUri(BASE_URI)
            .header("x-api-key", API_KEY)
            .contentType("application/json")
            .body(requestBody)
        .when()
            .put("/api/users/2")
        .then()
            .statusCode(200)
            .body("job", equalTo("Trabajador"));
    }

    //Prueba DELETE
    @Test
    public void testEliminarUsuarioRetornoSinContenido() {
        given()
            .baseUri(BASE_URI)
            .header("x-api-key", API_KEY)
        .when()
            .delete("/api/users/2")
        .then()
            //Se valida que el codigo de estado sea 204 
            .statusCode(204);
    }
    
    //Pruebas Negativas
    @Test
    public void testObtenerUsuarioNoEncontrado() {
        //Se prueba un ID de usuario que no existe para verificar el manejo de errores
        given()
            .baseUri(BASE_URI)
            .header("x-api-key", API_KEY)
        .when()
            .get("/api/users/23")
        .then()
            // Se valida que la API responda con 404 
            .statusCode(404);
    }
    
    @Test
    public void testRegistroFallidoSinPassword() {
        //Se prueba un registro sin el campo obligatorio "password"
        String requestBody = "{\"email\": \"pruebamala@gmail.cl\"}";

        given()
            .baseUri(BASE_URI)
            .contentType("application/json")
            .header("x-api-key", API_KEY)
            .body(requestBody)
        .when()
            .post("/api/register")
        .then()
            //Se valida que la API responda con 400 
            .statusCode(400)
            .body("error", equalTo("Missing password"));
    }

}
