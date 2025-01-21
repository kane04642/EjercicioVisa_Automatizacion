# language: es

@Songs
Característica: Encontrar las canciones

  @Consultar_canciones
  Esquema del escenario: Consultar las canciones por ID
    Dado Daniel es un usuario con los permisos para consultar los recursos
    Cuando Daniel consume el metodo GET "<id>" "<l>"
    Entonces Daniel visualiza respuesta exitosa
    Ejemplos:
      |id|l|
      |1217912247|en-US|