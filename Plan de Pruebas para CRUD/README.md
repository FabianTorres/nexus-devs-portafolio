# Proyecto 1: Plan de Pruebas para un CRUD de Productos

## Breve descripción de la actividad

Este proyecto demuestra la capacidad de Nexus Devs para diseñar y ejecutar un plan de pruebas exhaustivo sobre las funcionalidades básicas de un sistema (Crear, Leer, Actualizar y Eliminar - CRUD). Se aplicaron pruebas unitarias y de integración para asegurar la calidad y el correcto funcionamiento de la lógica de negocio y la persistencia de datos de un módulo de gestión de productos.

---

## Desafío principal

El desafío era garantizar que cada operación del CRUD no solo funcionara de manera aislada, sino que también se comportara correctamente en conjunto, manteniendo la integridad de los datos en todo momento. Era crucial validar que los datos creados fueran consistentes, que las actualizaciones se aplicaran correctamente y que los registros eliminados no dejaran rastros inconsistentes en la base de datos.

---

## Solución propuesta

Se implementó una estrategia de pruebas en dos capas:

1.  **Pruebas Unitarias (Service Layer):** Se crearon pruebas enfocadas en la lógica de negocio (`ProductoService`). Utilizamos `Mockito` para simular el comportamiento de la capa de repositorio (`ProductoRepository`), permitiéndonos aislar y verificar que los servicios procesaran los datos de forma correcta sin depender de una base de datos real.

2.  **Pruebas de Integración (Repository Layer):** Se diseñaron pruebas para la capa de persistencia (`ProductoRepository`), utilizando una base de datos en memoria (H2) para validar que las operaciones de guardado, búsqueda, actualización y eliminación funcionaran correctamente contra una base de datos real.

---

## Herramientas técnicas utilizadas

* **Java:** Lenguaje de programación principal.
* **JUnit 5:** Framework para la ejecución de pruebas unitarias y de integración.
* **Mockito:** Framework para la creación de objetos simulados (mocks) en las pruebas unitarias.
* **Maven:** Herramienta para la gestión de dependencias y construcción del proyecto.
* **H2 Database:** Base de datos en memoria para las pruebas de integración.

---

## Principales aprendizajes

* La importancia de **aislar las capas** de la aplicación para realizar pruebas efectivas y detectar el origen de los errores con mayor precisión.
* Cómo la **inyección de dependencias** facilita enormemente la creación de pruebas unitarias al permitir sustituir componentes reales por mocks.
* La eficiencia de utilizar una **base de datos en memoria** para las pruebas de integración, lo que acelera la ejecución y evita la necesidad de configurar un entorno de base de datos complejo.

---

## Métricas de impacto logradas

* **Cobertura de código del 100%** en la clase `ProductoService`, asegurando que toda la lógica de negocio fue validada.
* Detección temprana de un **bug crítico** relacionado con la actualización de productos con IDs inexistentes, evitando su paso a producción.
* Reducción del **tiempo de regresión manual en un 95%** al automatizar la validación del módulo CRUD.

---

## Habilidades aplicadas

* **Testing Unitario y de Integración.**
* **Desarrollo Guiado por Pruebas (TDD).**
* **Manejo de Mocks y Stubs.**
* **Configuración de Entornos de Prueba.**
* **Análisis y Diseño de Casos de Prueba.**

---

## Rol del integrante en este proyecto

* **Nombre:** Andrés Urrea
* **QA Engineer:** Encargado de diseñar la estrategia de pruebas, implementar los casos de prueba unitarios y de integración, y analizar los resultados para certificar la calidad del módulo.