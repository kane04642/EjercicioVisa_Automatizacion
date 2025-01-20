# language: es

@Empleados
Característica: Encontrar los paises

  @Consultar_empleados
  Esquema del escenario: Consultar los empleados
    Dado Daniel es un usuario con los permisos para consultar los recursos
    Cuando Daniel consume el metodo GET
    Entonces Daniel visualiza respuesta exitosa