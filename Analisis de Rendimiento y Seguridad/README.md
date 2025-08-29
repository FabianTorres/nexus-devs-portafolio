# Pruebas Automatizadas de APIs REST: Proyecto MediPlus

Este repositorio contiene el proyecto final para el portafolio 6 y 7. El objetivo es realizar una validación funcional y de rendimiento completa sobre una API REST simulada para la plataforma de salud digital "MediPlus".

## Integrantes

Andrés Urrea
Fabián Torres
Francisco Figueroa

## 🎯 Objetivos

* **Validación Funcional**: Asegurar el correcto funcionamiento de todas las operaciones CRUD (GET, POST, PUT, DELETE) de la API.
* **Pruebas de Seguridad**: Validar los mecanismos de autenticación y autorización de la API.
* **Pruebas de Rendimiento**: Evaluar el comportamiento del sistema bajo diferentes niveles de carga, midiendo métricas clave como tiempo de respuesta, throughput y tasa de error.
* **Análisis y Recomendaciones**: Analizar los resultados de las pruebas para generar hallazgos y proponer recomendaciones de mejora.

## 🛠️ Tecnologías Utilizadas

* **Java**: Lenguaje de programación base.
* **Maven**: Herramienta para la gestión de dependencias y construcción del proyecto.
* **REST Assured**: Librería de Java para la automatización de pruebas funcionales de APIs REST.
* **JUnit 5**: Framework para la ejecución de los tests en Java.
* **Apache JMeter**: Herramienta para la ejecución de pruebas de rendimiento y carga.

## 🚀 Cómo Empezar

### Prerrequisitos

* Tener instalado **Java JDK 8** o superior.
* Tener instalado **Maven**.
* Tener instalado **Apache JMeter**.

### Instalación

1.  Clonar este repositorio en tu máquina local:
    ```sh
    git clone https://github.com/FabianTorres/portafolio-6-7.git
    ```
2.  Navegar al directorio del proyecto y ejecutar el siguiente comando para descargar todas las dependencias de Maven:
    ```sh
    mvn clean install
    ```

## ⚙️ Estructura del Proyecto

El proyecto sigue la estructura estándar de Maven:
├── src
│   └── test
│       └── java
│           └── cl
│               └── cursos
│                   ├── FunctionalTests.java  # Pruebas funcionales CRUD y negativas
│                   └── SecurityTests.java    # Pruebas de autenticación y seguridad
├── pom.xml                                   # Dependencias y configuración de Maven
└── README.md

## ▶️ Cómo Ejecutar las Pruebas

### Pruebas Funcionales y de Seguridad (REST Assured)

Para ejecutar la suite completa de pruebas funcionales y de seguridad, utiliza el siguiente comando de Maven desde la raíz del proyecto:
```sh
mvn test

Maven ejecutará automáticamente todas las clases de prueba y mostrará los resultados en la consola.

### Pruebas de Rendimiento (JMeter)

En la entrega también se incluye el **informe del protafolio** y los **resultados de las ejecuciones de las pruebas de carga** ordenados en carpetas según los escenarios del proyecto

##Ejemplo de ejecución de las pruebas de rendimiento
```
jmeter -n -t "C:\ruta\al\proyecto\jmeter_plans\Escenario_Combinado_10_usuarios.jmx" -l "C:\ruta\al\proyecto\resultados\Combinado\10_Usuarios\resultados.jtl" -e -o "C:\ruta\al\proyecto\resultados\Combinado\10_Usuarios\reporte_html"

En el informe esta detallado los resultados, los análisis y las recomendaciones.
