# Sistema de Gestión de Usuarios para Supermercado XYZ

## Descripción
Este proyecto es un sistema de gestión de usuarios para el Supermercado XYZ, desarrollado con Spring Boot. Proporciona una interfaz web para administrar usuarios, incluyendo clientes, proveedores y empleados.

## Características
- Listado de usuarios con filtros y búsqueda
- Estadísticas de usuarios en tiempo real
- Gestión de diferentes roles de usuario (Cliente, Proveedor, Cajero, Administrador)
- Interfaz de usuario intuitiva y responsiva

## Tecnologías Utilizadas
- Java 11
- Spring Boot 2.5.2
- Thymeleaf para plantillas HTML
- Base de datos H2 (en memoria)
- Maven para gestión de dependencias

## Requisitos Previos
- JDK 11 o superior
- IDE IntelliJ que cuenta con maven integrado, los comandos que se deben utilizar son "mvnw" en vez de "mvn"

## Configuración y Ejecución
1. Abrir el proyecto en el IDE IntelliJ

2. Compilar el proyecto:
   ```
   mvnw clean install
   ```

3. Ejecutar la aplicación:
   ```
   mvnw spring-boot:run
   ```

4. Abrir un navegador y visitar `http://localhost:3001/usuarios`

## Estructura del Proyecto
- `src/main/java/com/codecademy/supermercado/controller`: Controladores
- `src/main/java/com/codecademy/supermercado/model`: Modelos de datos
- `src/main/java/com/codecademy/supermercado/repository`: Repositorios para acceso a datos
- `src/main/resources/templates`: Vista - Plantillas Thymeleaf
