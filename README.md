# 🎬 Gestión de Películas - Spring Boot

Aplicación web desarrollada con Spring Boot para gestionar un catálogo de películas con sus respectivos géneros. Permite realizar operaciones CRUD sobre las tablas `peliculas` y `generos`.

Este proyecto fue realizado como parte del Trabajo Práctico N.º 6 de la materia **Laboratorio de Programación (2025)**.

---

## 📌 Funcionalidades principales

- ✅ Listado de películas con su género asociado
- ✅ Alta, edición y eliminación de películas
- ✅ Gestión de géneros (alta, edición, baja)
- ✅ Validación de formularios
- ✅ Conexión a base de datos MariaDB

---

## 🧱 Estructura del proyecto

El proyecto sigue la arquitectura MVC (Modelo-Vista-Controlador):

| Capa         | Contenido                                                                 |
|--------------|--------------------------------------------------------------------------|
| `modelo`     | Clases `Pelicula` y `Genero`, mapeadas con JPA y validaciones de datos   |
| `repositorio`| Interfaces `PeliculaRepositorio` y `GeneroRepositorio` con Spring Data JPA |
| `controlador`| Lógica de negocio: `PeliculaControlador` y `GeneroControlador`           |
| `templates`  | Vistas Thymeleaf para CRUD de películas y géneros                        |
| `resources`  | Configuración (`application.properties`)                                 |

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

Base de datos: `cine`  
Tablas utilizadas:

### 🎬 peliculas

| Campo         | Tipo     | Longitud | Notas                 |
|---------------|----------|----------|------------------------|
| id            | Numérico | 5        | Autogenerado           |
| titulo        | Texto    | 40       | Obligatorio            |
| director      | Texto    | 30       | Obligatorio            |
| protagonista  | Texto    | 30       | Obligatorio            |
| anio          | Numérico | 4        | Entre 1888 y 2100      |
| genero_id     | FK       | -        | Relación con `generos` |

### 🗂️ generos

| Campo  | Tipo     | Longitud | Notas          |
|--------|----------|----------|----------------|
| id     | Numérico | 5        | Autogenerado   |
| nombre | Texto    | 30       | Obligatorio    |

---

## ⚙️ Configuración (application.properties)

```properties
spring.datasource.url=jdbc:mariadb://localhost:3306/cine
spring.datasource.username=root
spring.datasource.password=

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.thymeleaf.cache=false
