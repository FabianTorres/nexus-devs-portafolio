# Proyecto 2: Análisis de Rendimiento y Seguridad

## Breve descripción de la actividad

Este proyecto demuestra la capacidad de Nexus Devs para evaluar aspectos no funcionales críticos de una aplicación. Se ejecutaron pruebas de rendimiento para medir la respuesta del sistema bajo diferentes cargas de usuarios y se realizaron análisis de seguridad para identificar y mitigar vulnerabilidades comunes, asegurando que la aplicación no solo sea funcional, sino también robusta y segura.

---

## Desafío principal

El principal desafío era doble:

1.  **Rendimiento:** Identificar el punto de quiebre de la aplicación, es decir, cuántos usuarios concurrentes podía soportar antes de que los tiempos de respuesta se degradaran significativamente o comenzaran a aparecer errores.
2.  **Seguridad:** Detectar vulnerabilidades de tipo "Inyección de Dependencias" y "Cross-Site Scripting" (XSS), que son dos de las amenazas más comunes y peligrosas para las aplicaciones web.

---

## Solución propuesta

Se abordó el desafío con una estrategia de pruebas no funcionales bien definida:

1.  **Pruebas de Rendimiento:** Utilizando Apache JMeter, se diseñaron planes de prueba para simular escenarios de carga incremental (10, 50 y 100 usuarios concurrentes). Se midieron métricas clave como el tiempo medio de respuesta, el *throughput* (peticiones por segundo) y la tasa de error para evaluar el comportamiento del sistema.

---

## Herramientas técnicas utilizadas

* **Apache JMeter:** Herramienta de código abierto para la ejecución de pruebas de carga y rendimiento.
* **Java/Spring Boot:** Tecnología base de la aplicación bajo prueba.
* **Maven:** Gestión de dependencias del proyecto.

---

## Principales aprendizajes

* La importancia de definir **escenarios de prueba realistas** en JMeter que simulen el comportamiento de usuarios reales para obtener métricas de rendimiento fiables.
* Cómo un pequeño error de configuración en el servidor puede generar un **cuello de botella** que solo es visible bajo condiciones de alta carga.

---

## Métricas de impacto logradas

* Se determinó que la aplicación soporta hasta **85 usuarios concurrentes** antes de que el tiempo de respuesta supere el umbral aceptable de 2 segundos.
* Se identificaron **3 alertas de seguridad de alta prioridad** (2 de XSS y 1 de inyección SQL), que fueron reportadas al equipo de desarrollo para su inmediata corrección.
* La optimización basada en los resultados de las pruebas de carga mejoró el **throughput de la aplicación en un 15%**.

---

## Habilidades aplicadas

* **Pruebas de Rendimiento y Estrés.**
* **Análisis de Vulnerabilidades de Seguridad.**
* **Manejo de Herramientas de Pruebas No Funcionales (JMeter).**
* **Interpretación de Métricas de Rendimiento.**
* **Elaboración de Informes Técnicos.**

---

## Rol del integrante en este proyecto

* **Performance Tester (Fabian Torres):** Responsable de diseñar y ejecutar los planes de prueba de carga con JMeter, realizar el análisis de vulnerabilidades y generar los informes con los hallazgos y recomendaciones para el equipo.