# Proyecto 3: Pruebas Automatizadas BDD para Login y Registro

## Breve descripción de la actividad

Este proyecto demuestra la habilidad de Nexus Devs para aplicar la metodología de Desarrollo Guiado por Comportamiento (BDD) en la automatización de pruebas funcionales. Se crearon escenarios de prueba para los flujos de "Login" y "Registro" de una aplicación web, utilizando un lenguaje natural (Gherkin) que facilita la comunicación entre los perfiles técnicos y de negocio.

---

## Desafío principal

El desafío era traducir los requisitos funcionales de los flujos de autenticación en escenarios de prueba automatizados que fueran fáciles de entender para cualquier miembro del equipo, independientemente de su perfil técnico. Era fundamental asegurar que las pruebas no solo validaran el "camino feliz", sino también los casos de error, como el uso de credenciales incorrectas, el registro con datos inválidos o el intento de registrar un usuario ya existente.

---

## Solución propuesta

Se implementó un framework de automatización utilizando Cucumber y Selenium WebDriver.

1.  **Definición de Escenarios (Gherkin):** Se escribieron los criterios de aceptación en archivos `.feature` utilizando la sintaxis Gherkin (Given, When, Then). Esto permitió describir el comportamiento esperado de la aplicación desde la perspectiva del usuario.
2.  **Implementación de Steps (Java/Selenium):** Se desarrollaron las clases "Step Definitions" en Java, que enlazan cada paso de los escenarios de Gherkin con acciones concretas de Selenium WebDriver. Estas acciones simulan la interacción del usuario con el navegador, como hacer clic en botones, rellenar formularios y verificar mensajes en pantalla.
3.  **Ejecución y Reporte:** Se configuró un `TestRunner` para ejecutar las pruebas y generar reportes claros que muestran el resultado de cada escenario, facilitando la identificación de fallos.

---

## Herramientas técnicas utilizadas

* **Java:** Lenguaje de programación para la implementación de los steps.
* **Cucumber:** Herramienta para BDD que permite ejecutar archivos de especificación en texto plano.
* **Gherkin:** Lenguaje utilizado para escribir los escenarios de prueba.
* **Selenium WebDriver:** Herramienta para la automatización de la interacción con navegadores web.
* **JUnit 5:** Framework para la ejecución de las pruebas.
* **Maven:** Herramienta para la gestión de dependencias y del ciclo de vida del proyecto.

---

## Principales aprendizajes

* El poder de BDD para **alinear al equipo** de desarrollo, QA y negocio en torno a un entendimiento común de los requisitos.
* La importancia de crear **código de automatización modular y reutilizable** (Page Object Model) para facilitar el mantenimiento de las pruebas a largo plazo.
* Cómo la sintaxis de Gherkin actúa como **documentación viva**, describiendo de forma precisa y actualizada el comportamiento real del sistema.

---

## Métricas de impacto logradas

* **Automatización del 100%** de los casos de prueba definidos para los flujos de Login y Registro.
* **Reducción del 90%** en el tiempo de ejecución de pruebas de regresión manual para estas funcionalidades.
* Se identificaron **2 defectos funcionales** relacionados con la validación de contraseñas que no habían sido detectados en las pruebas manuales.

---

## Habilidades aplicadas

* **Automatización de Pruebas Funcionales.**
* **Desarrollo Guiado por Comportamiento (BDD).**
* **Uso de Selenium WebDriver y Cucumber.**
* **Lenguaje Gherkin.**
* **Análisis de Requisitos Funcionales.**

---

## Rol del integrante en este proyecto

* **Automation QA Engineer (Francisco Figueroa):** Encargado de definir los escenarios de prueba en Gherkin, desarrollar el código de automatización con Selenium y Java, y asegurar la correcta ejecución y reporte de los resultados.