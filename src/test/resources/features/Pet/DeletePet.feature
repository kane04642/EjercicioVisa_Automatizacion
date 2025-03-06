
@Delete_Pet @Regresion
Feature: Delete an exist pet

  @Delete_succesfully
  Scenario Outline:Successfully delete a pet
    Given Daniel is a user with the necessary permissions
    When Daniel consumes the pet delete service "<idPet>"
    Then Daniel should see the successful update of a new pet
    Examples:
      |idPet|
      |14|