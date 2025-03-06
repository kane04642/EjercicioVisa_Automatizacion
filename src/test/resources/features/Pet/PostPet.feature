
@Create_Pet @Regresion
Feature: Create a new pet

  @Create_succesfully
    Scenario Outline:Successfully create a new pet
      Given Daniel is a user with the necessary permissions
      When Daniel consumes the pet creation service "<id>" "<name>" "<id_category>""<name_category>""<id_tag>""<name_tag>""<status>"
      Then Daniel should see the successful creation of a new pet
      Examples:
          | id | name |id_category |name_category |id_tag |name_tag |status |
          | 14 |KANE |1 |Cat |0 |String |available |

  @Create_BadRequest
  Scenario Outline:Successfully create a new pet
    Given Daniel is a user with the necessary permissions
    When Daniel consumes the pet creation service "<id>" "<name>" "<id_category>""<name_category>""<id_tag>""<name_tag>""<status>"
    Then Daniel should see the mandatory fields message
    Examples:
      | id | name |id_category |name_category |id_tag |name_tag |status |
      | 1 | |1 |Cat |0 |String |available |