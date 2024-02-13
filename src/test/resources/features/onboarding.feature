Feature: Validate Create wallet and add existing wallet


  Scenario: Create new MultiCoin wallet with no secret phase or back up
    Given User creates wallet with no secret phase or back up
    And User sets a passcode "2,4,5,6,7,3"
    Then Wallet should be displayed on homepage with name "Main Wallet 1"


  Scenario: Create new MultiCoin wallet with secret phase
    Given User creates wallet with secret phase
    And User sets a passcode "3,3,9,9,7,3"
    Then Wallet should be displayed on homepage with name "Main Wallet 1"


  Scenario: Create new MultiCoin wallet with secret phase and reset app then add existing wallet via secret phase
    Given User creates wallet with secret phase
    And User sets a passcode "3,3,9,9,7,3"
    And Wallet should be displayed on homepage with name "Main Wallet 1"
    When User resets the app
    And User adds existing wallet with secret phase and name "Added Wallet"
    And User sets a passcode "1,1,1,4,4,8"
    Then Wallet should be displayed on homepage with name "Added Wallet"