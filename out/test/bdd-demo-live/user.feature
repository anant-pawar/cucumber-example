Feature: test user operation

  @cleanRepository
  Scenario: create user
    When we create user with is as "0479c1e0-2258-4b1b-8e24-2946cb528e2a" name as "anant" age as 29 and mobile as "9008430490" by calling api "/user"
    Then we get response status as "OK"

  @cleanRepository
  Scenario Outline: get user by id
    Given an user with id as "<id>" name as "<name>" age as <age> and mobile as "<mobile>"
    When i get user by calling "/user" api with id "<id>"
    Then i get response status as "OK"
    And response message as
    """
    {
      "id" : "<id>",
      "name" : "<name>",
      "age" : <age>,
      "mobile" : "<mobile>"
    }
    """

    Examples:
      | id                                   | name  | age | mobile     |
      | 0479c1e0-2258-4b1b-8e24-2946cb528e2a | anant | 29  | 9008430490 |
      | 0479c1e0-2258-4b1b-8e24-2946cb528e56 | ajdsf | 27  | 9008430492 |

  @cleanRepository
  Scenario Outline: get user by name
    Given an user with id as "<id>" name as "<name>" age as <age> and mobile as "<mobile>"
    When i get user by calling "/user/name" api with name "<name>"
    Then i get response status as "OK"
    And response message as
    """
    {
      "id" : "<id>",
      "name" : "<name>",
      "age" : <age>,
      "mobile" : "<mobile>"
    }
    """

    Examples:
      | id                                   | name  | age | mobile     |
      | 0479c1e0-2258-4b1b-8e24-2946cb528e2a | anant | 29  | 9008430490 |
      | 0479c1e0-2258-4b1b-8e24-2946cb528e56 | ajdsf | 27  | 9008430492 |
