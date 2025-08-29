# Proyecto CRUD con TDD - Portafolio Final

Este repositorio contiene el desarrollo de una aplicación CRUD (Crear, Leer, Actualizar, Eliminar) para gestionar productos, implementada en Java y siguiendo la metodología de Desarrollo Guiado por Pruebas (TDD).

Este proyecto es el entregable final de los Modulos 2 (Testing Ágil) y 3 (TDD en Automatización de Pruebas)

## Tecnologias Utilizadas
* **Lenguaje:** Java 17
* **Gestor de Dependencias:** Maven
* **Framework de Pruebas:** JUnit 5
* **Librería de Mocks:** Mockito
* **Base de Datos para Pruebas:** H2 (en memoria)
* **Cobertura de Código:** JaCoCo

## Como Ejecutar el Proyecto

1.  **Clonar el Repositorio:**
    git clone https://github.com/FabianTorres/crud-portafolio.git

2.  **Importar en Visual Studio Code:**
    * En Visual Studio, ir a Open Folder y seleccionar la carpeta crud-tdd-proyecto

## Cómo Ejecutar las Pruebas y Ver la Cobertura

Para ejecutar todas las pruebas (unitarias y de integración) y generar el reporte de cobertura, se abre una terminal en la raíz del proyecto y ejecuta el siguiente comando Maven:

mvn clean verify

Cualquier duda a fabiantorresd@gmail.com