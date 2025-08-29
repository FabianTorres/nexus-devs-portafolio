# Portafolio M5: Desarrollo Conducido por Comportamiento (BDD)

Este repositorio contiene el proyecto final para el Módulo 5 de Pruebas Automatizadas, sobre implementación de la metodología BDD (Behavior-Driven Development) para la automatización de pruebas de una aplicación web.

## Integrantes

* Andres Urrea
* Fabian Torres
* Francisco Figueroa

---

## Tecnologías Utilizadas

* **Lenguaje:** Java (JDK 11+)
* **Gestor de Dependencias:** Apache Maven
* **Framework BDD:** Cucumber 7
* **Lenguaje de Especificación:** Gherkin
* **Automatización de Navegador:** Selenium WebDriver 4
* **Framework de Pruebas:** JUnit 5
* **Control de Versiones:** Git
* **IDE:** Eclipse
* **Reportes:** Maven Cucumber Reporting

---

## Estructura del Proyecto

El proyecto sigue una estructura estándar de Maven, optimizada para pruebas con Cucumber:

```
portafolio-5/
├── pom.xml                   # Gestiona las dependencias y el ciclo de vida de la construccion.
├── src/
│   └── test/
│       ├── java/
│       │   └── steps/        # Contiene las clases Java que implementan los pasos.
│       │       ├── BaseSteps.java
│       │       ├── Hooks.java
│       │       ├── LoginSteps.java
│       │       ├── RegistroSteps.java # OJO, esta clase, por problemas de las web, aparece y desaparece en los commit
│       │       └── TestRunner.java  # Clase para configurar y ejecutar las pruebas.
│       │
│       └── resources/
│           └── features/     # Contiene los archivos de especificacion en Gherkin.
│               ├── Login.feature
│               └── Registro.feature
│
└── target/                   # Directorio generado por Maven con los resultados.
    └── cucumber-html-reports/
        └── index.html        # Reporte final HTML de la ejecucion.
```

---

## Instrucciones para la Ejecución Local

### Prerrequisitos

* Tener instalado Java JDK 11 o superior.
* Tener instalado Apache Maven.
* Tener instalado Git.
* Tener un navegador web como Google Chrome.

### Pasos de Ejecución

1.  **Clonar el repositorio:**
    ```bash
    git clone https://github.com/FabianTorres/modulo-5
    cd portafolio-5
    ```

2.  **Ejecutar las pruebas y generar el reporte:**
    Abre una terminal en la raíz del proyecto y ejecuta el siguiente comando de Maven:
    ```bash
    mvn clean verify
    ```
    Este comando limpiará el proyecto, compilará el código, ejecutará **todas** las pruebas definidas en los archivos `.feature` y finalmente generará el reporte HTML.

3.  **Visualizar el reporte:**
    Una vez finalizada la ejecución, abre el siguiente archivo en tu navegador web para ver los resultados detallados, incluyendo capturas de pantalla de los escenarios que fallaron:
    `target/cucumber-html-reports/index.html`

---

## Evidencias de Ejecución (Historial de Commits)

El desarrollo del proyecto fue progresivo, siguiendo las 6 lecciones del módulo. Cada commit representa la finalización de una etapa, demostrando la aplicación incremental de los conceptos BDD:

* **`feat(L1)`**: config inicial del proyecto y creacion de features
* **`feat(L2)`**: implementacion de TestRunner y primeros Step
* **`feat(L3)`**: expandir escenarios de login y registro con Gherkin
* **`feat(L4-L6)`**: Se refactoriza login para usar Scenario Outline y se agregan hooks (se elimina registro para mas orden)
* **`feat(L5)`**: añadir y filtrar escenarios mediante tags
* **`feat(L6)`**: centralizar manejo del driver y se añaden screenshots con Hooks
Los commit siguientes tienen el readme y modificacion al registro señalado

---

## Pasos Verificados

Se automatizaron los siguientes flujos funcionales de la aplicación de prueba:

* **Funcionalidad de Login:**
    * Validación de inicio de sesión con credenciales incorrectas.
    * Verificación de la muestra de un mensaje de error adecuado.
* **Funcionalidad de Registro:**
    * Validación de registro con un correo electrónico ya existente.
    * Verificación de la muestra del mensaje de error correspondiente.
    * (El flujo de registro exitoso y login exitoso fallan en la aserción final, ya que se usan datos de prueba en una aplicación pública sin una sesión activa).

---

## Valor de la Metodología BDD en el Proyecto

En este proyecto, la aplicación de BDD fue fundamental. El uso del lenguaje Gherkin nos permitió definir los comportamientos esperados (`Login`, `Registro`) en un formato claro y no técnico. Estos archivos `.feature` actuaron como "documentación viva": cualquier miembro del equipo, sea desarrollador, QA o de negocio, puede leerlos y entender exactamente qué hace y qué se espera del sistema.

Esta claridad eliminó la ambigüedad y facilito el entendimiento del codigo.