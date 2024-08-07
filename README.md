
# Back-End prueba tecnica con Java SpringBoot

En este repositorio se encuentra la todo el codigo hecho para el back-end de la prueba, se la estructura de carpetas esta compuesta por Repository, Service, Controller y Config.



## API Reference

#### Get all items

```http
  GET /negocio/all?page=1
```

#### Get item by id

```http
  GET /negocio/producto/{id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `string` | **Required**. Id of item to fetch |

#### Get item by name

```http
  GET /negocio/search/{nombre}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `nombre`      | `string` | **Required**. Id of item to fetch |


## Features

- Mostrar todos los productos
- Buscar productos por Id
- Buscar Productos por Nombre
- Registrar Nuevos Productos
- Actualizar Productos existentes
- Eliminar Productos



## Installation

Para ejecutar el api es necesario ajustar en la carpeta main/resources el archivo application.properties el cual contiene lo siguiente 

```bash
    spring.application.name=tallerSpring
    server.port=8081 // el puerto por el cual correra de manera local
    spring.datasource.url= jdbc:mysql://localhost:3306/pruebaTecnica // el puerto y nombre de la base de datos la cual esta corriendo de manera local gracias a XAMPP
    spring.datasource.username=root //usuario de la base de datos
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true
```
    
