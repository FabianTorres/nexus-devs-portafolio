# Plan de Testing Ágil - Sprint 1: CRUD de Productos

Este documento describe el plan de pruebas para el primer sprint del proyecto, enfocado en implementar las operaciones básicas de un CRUD (Crear, Leer, Actualizar, Eliminar) para la gestión de productos.

---

### 1. Historias de Usuario (Product Backlog del Sprint)

Las siguientes historias de usuario serán abordadas en este sprint:

* **HU-01: Crear Producto**
    * **Como** administrador,
    * **Quiero** registrar un nuevo producto en el sistema (con nombre, precio y cantidad en stock),
    * **Para** mantener mi inventario actualizado.

* **HU-02: Leer Productos**
    * **Como** administrador,
    * **Quiero** poder listar todos los productos existentes,
    * **Para** tener una visión general del inventario.

* **HU-03: Actualizar Producto**
    * **Como** administrador,
    * **Quiero** modificar los datos de un producto existente (precio o stock),
    * **Para** corregir errores o reflejar cambios.

* **HU-04: Eliminar Producto**
    * **Como** administrador,
    * **Quiero** poder eliminar un producto que ya no está a la venta,
    * **Para** limpiar el catálogo de productos obsoletos.

---

### 2. Criterios de Aceptación

Cada funcionalidad deberá cumplir los siguientes criterios para ser considerada completa:

* **Para HU-01 (Crear):**
    * **Dado** que ingreso los datos válidos de un nuevo producto, **cuando** guardo el registro, **entonces** el producto debe ser almacenado exitosamente.
    * **Dado** que intento crear un producto con un nombre vacío o un precio negativo, **cuando** guardo el registro, **entonces** el sistema debe lanzar una excepción de validación.

* **Para HU-02 (Leer):**
    * **Dado** que existen productos en el sistema, **cuando** solicito el listado, **entonces** se deben devolver todos los productos registrados.
    * **Dado** que no hay productos en el sistema, **cuando** solicito el listado, **entonces** se debe devolver una lista vacía.

* **Para HU-03 (Actualizar):**
    * **Dado** que un producto existe, **cuando** modifico su precio, **entonces** el producto debe reflejar el nuevo precio.

* **Para HU-04 (Eliminar):**
    * **Dado** que un producto existe, **cuando** lo elimino, **entonces** ya no debe aparecer en el listado de productos.

---

### 3. Tipos de Pruebas a Realizar

* **Pruebas Unitarias (TDD):** Se usaran **JUnit y Mockito** para validar la logica de negocio de `ProductoService` de forma aislada. Cada metodo público tendrá su propia prueba unitaria. Estas pruebas no tocarán la base de datos real. 
* **Pruebas de Integración:** Se realizarán pruebas para verificar que el `ProductoRepository` puede comunicarse correctamente con la base de datos (crear, leer, actualizar, eliminar registros).
* **Pruebas de Aceptación:** Se realizarán manualmente para verificar que cada Criterio de Aceptación se cumple desde la perspectiva del usuario.

---

### 4. Definición de "Terminado" (Definition of Done)

Una historia de usuario se considerará "Terminada" cuando cumpla con todo lo siguiente:
* El código de la funcionalidad está completo.
* Todas las **pruebas unitarias** asociadas a la funcionalidad pasan correctamente. 
* La **cobertura de código**, medida con JaCoCo, es **igual o superior al 80%**. 
* El código ha sido **refactorizado** aplicando al menos un principio SOLID. 
* La funcionalidad cumple con todos sus **criterios de aceptación**.
* El código está integrado en la rama principal del repositorio Git.

---

### 5. Roles y Responsabilidades (Para este proyecto)

* **Product Owner:** Define las historias de usuario y los criterios de aceptación.
* **Desarrollador:** Implementa la funcionalidad siguiendo el ciclo TDD.
* **Tester (QA):** Crea y ejecuta las pruebas, reporta defectos y valida la "Definición de Terminado"