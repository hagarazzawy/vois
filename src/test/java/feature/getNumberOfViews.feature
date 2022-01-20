Feature: get number of views for every pattern

  Scenario Outline: get number of views for each pattern
    Given I am a user
    When I send request to colourlovers api
    Then I can get the number of views for each pattern
    And the number of views is greater than <number>
    
    Examples:
    |number|
    |4000	 |

