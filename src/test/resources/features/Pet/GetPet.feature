# language: es

@Pets @Regresion
Característica: Administrar CRUD del recurso de mascotas (Pets)

  @Consulta_Exitosa
  Esquema del escenario: Consultar mascota de forma exitosa
    Dado Daniel es un usuario con los permisos para consultar los recursos
    Cuando Daniel consulta la mascota por ID "<IdPet>"
    Entonces Daniel visualiza respuesta exitosa
    Ejemplos:
      |IdPet|
      | 11 |

  @Consulta_ID_no_existente
  Esquema del escenario: Consultar mascota con Id no existente
    Dado Daniel es un usuario con los permisos para consultar los recursos
    Cuando Daniel consulta la mascota por ID "<IdPet>"
    Entonces Daniel visualiza respuesta no encontrado
    Ejemplos:
      |IdPet|
      | 33 |


