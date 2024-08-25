 # Blogging Platform API

Este proyecto es una API RESTful para una plataforma de blogs personal, desarrollada con Spring Boot. La API permite realizar operaciones CRUD básicas para gestionar publicaciones de blog.

## Objetivos del Proyecto

Este proyecto tiene como objetivo ayudar a comprender y aplicar los siguientes conceptos:

- Crear una API RESTful siguiendo las mejores prácticas y convenciones
- Implementar operaciones CRUD (Crear, Leer, Actualizar y Eliminar)
- Utilizar métodos HTTP comunes (GET, POST, PUT, PATCH, DELETE)
- Manejar códigos de estado y errores en APIs
- Trabajar con bases de datos en el contexto de una API

## Funcionalidades

La API permite a los usuarios realizar las siguientes operaciones:

- Crear una nueva publicación de blog
- Actualizar una publicación de blog existente
- Eliminar una publicación de blog existente
- Obtener una publicación de blog específica
- Obtener todas las publicaciones de blog
- Filtrar publicaciones de blog por un término de búsqueda

## Tecnologías Utilizadas

- Spring Boot v3.3.2
- Spring Web
- Spring Data JPA
- Spring Boot DevTools
- Maven
- PostgreSQL v16

## Configuración del Proyecto

1. Clona este repositorio
2. Asegúrate de tener instalado Java 17 o superior y Maven
3. Configura tu base de datos en src/main/resources/application.properties
4. Ejecuta mvn clean install para instalar las dependencias
5. La API estará disponible en http://localhost:8080