Feature: Manage crypto (network)

  Scenario: Create new MultiCoin wallet with no secret phase or back up
    Given User is on homepage with new MultiCoin wallet
    And User navigates to manage crypto page
    When User manages network and returns to home page
      | network         | status    |
      | Bitcoin         | checked   |
      | Ethereum        | unChecked |
      | Polygon         | unChecked |
      | BNB Smart Chain | checked   |
      | Cardano         | checked   |
      | Trust Wallet    | checked   |
    Then User verifies the following cryptos are displayed on home page
      | crypto | displayed |
      | BTC    | true      |
      | BNB    | true      |
      | ADA    | true      |
      | TWT    | true      |
      | ETH    | false     |
      | MATIC  | false     |


