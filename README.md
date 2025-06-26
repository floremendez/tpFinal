# 🎬 Gestión de Películas - Spring Boot

Aplicación web desarrollada con Spring Boot para gestionar un catálogo de películas y sus géneros. Permite realizar operaciones CRUD completas sobre las tablas `peliculas` y `generos`.

Este proyecto fue realizado como parte del Trabajo Práctico N.º 6 de la materia **Laboratorio de Programación (2025)**.

---

## 📌 Funcionalidades principales

- ✅ Listado de películas con su género
- ✅ Alta, edición y eliminación de películas
- ✅ Gestión de géneros (alta, edición, eliminación)
- ✅ Validaciones en los formularios
- ✅ Visualización de los datos en PhpMyAdmin

---

## 🧱 Estructura del proyecto

El proyecto sigue el patrón MVC (Modelo - Vista - Controlador) y está dividido en capas:

| Capa          | Descripción                                                                 |
|---------------|------------------------------------------------------------------------------|
| `modelo`      | Entidades `Pelicula` y `Genero`, mapeadas con JPA y anotaciones de validación |
| `repositorio` | Interfaces `PeliculaRepositorio` y `GeneroRepositorio` que extienden `JpaRepository` |
| `servicio`    | Lógica de negocio y conexión entre controlador y repositorio (`PeliculaServicio`, `GeneroServicio`) |
| `controlador` | Clases que manejan las rutas y la lógica del usuario (`PeliculaControlador`, `GeneroControlador`) |
| `templates`   | Páginas HTML con Thymeleaf para mostrar formularios, listas, etc.           |
| `resources`   | Configuración en `application.properties` y archivos estáticos si es necesario |

---

## 🛠️ Tecnologías utilizadas

- Java 21
- Spring Boot 3.5.x
- Spring Data JPA
- Thymeleaf
- MariaDB
- Maven

---

## 🗃️ Base de datos

**Nombre de la base:** `cine`  
Tablas incluidas:

### 🎬 Tabla `peliculas`

| Campo         | Tipo     | Longitud | Notas                               |
|---------------|----------|----------|--------------------------------------|
| id            | Numérico | 5        | Clave primaria, autogenerado        |
| titulo        | Texto    | 40       | Obligatorio, con validación         |
| director      | Texto    | 30       | Obligatorio                         |
| protagonista  | Texto    | 30       | Obligatorio                         |
| anio          | Numérico | 4        | Rango entre 1888 y 2100             |
| genero_id     | FK       | -        | Relación con la tabla `generos`     |

### 🗂️ Tabla `generos`

| Campo  | Tipo     | Longitud | Notas          |
|--------|----------|----------|----------------|
| id     | Numérico | 5        | Clave primaria |
| nombre | Texto    | 30       | Obligatorio    |

---

## ⚙️ Configuración

Archivo `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mariadb://localhost:3306/cine
spring.datasource.username=root
spring.datasource.password=

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.thymeleaf.cache=false
