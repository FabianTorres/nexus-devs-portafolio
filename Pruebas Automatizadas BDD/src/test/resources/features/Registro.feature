@Registro @Regression
Feature: Funcionalidad de Registro de Usuario
  Como un nuevo visitante, quiero poder crear una cuenta
  para poder inscribirme en los cursos de la plataforma.

  Scenario: Registro de un nuevo usuario de forma exitosa
    Given un usuario nuevo se encuentra en la pagina de registro
    When ingresa su nombre "Marcos" y su apellido "Perez"
    And ingresa su correo electronico "marcos.perez.test@automation.com"
    And ingresa una contrasena valida
    And acepta los terminos y condiciones
    And hace clic en el boton de registro
    Then el sistema crea la cuenta y lo redirige a la pagina de sus cursos

  @SmokeTest
  Scenario: Registro fallido al usar un correo ya existente
    Given un usuario nuevo se encuentra en la pagina de registro
    When ingresa su nombre "Usuario" y su apellido "Existente"
    And ingresa su correo electronico "test@google.com" que ya esta en uso
    And ingresa una contrasena valida
    And hace clic en el boton de registro
    Then el sistema muestra un mensaje de error indicando que el correo ya existe