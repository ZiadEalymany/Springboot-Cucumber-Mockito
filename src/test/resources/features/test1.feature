Feature: the version can be retrieved

  Scenario: client makes call to GET /nameAndVersion
    When the client calls endpoint "/nameAndVersion"
    Then the client receives status code of 200
    And the client receives string of "Application Name is: Test Cucumber, Version is: 1.0"
