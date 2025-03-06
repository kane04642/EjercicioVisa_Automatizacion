@Update_Pet @Regresion
Feature: Update an exist pet

  @Update_succesfully
  Scenario Outline:Successfully update a pet
    Given Daniel is a user with the necessary permissions
    When Daniel consumes the pet update service "<id>" "<name>" "<id_category>""<name_category>""<id_tag>""<name_tag>""<status>"
    Then Daniel should see the successful update of a new pet
    Examples:
      | id | name |id_category |name_category |id_tag |name_tag |status |
      | 14 |KANE |1 |Cat |0 |String |available |