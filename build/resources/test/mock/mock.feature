Feature: test user service

  Scenario Outline: get user by id
    Given an user with id as "<id>" name as "<name>" age as <age> and mobile as "<mobile>"
    When i get user by id "<id>"
    Then i get response message as
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