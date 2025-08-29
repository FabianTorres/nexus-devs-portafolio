@Login @Regression
Feature: Funcionalidad de Login
  Como usuario de la plataforma, quiero poder iniciar sesion
  para acceder a los cursos y gestionar mi cuenta.

  @SmokeTest
  Scenario Outline: Validacion de inicio de sesion con diferentes credenciales
    Given el usuario se encuentra en la pagina de inicio de sesion
    When el usuario ingresa el correo "<email>" y la contrasena "<password>"
    And hace clic en el boton de inicio de sesion
    Then el sistema muestra el resultado "<resultado>"

    Examples:
      | email              | password        | resultado |
      | fabian@gmail.com   | 123456789       | exitoso   |
      | fabian@gmail.com   | pass-incorrecto | fallido   |
      | usuario@qa.com     | Password123     | fallido   |