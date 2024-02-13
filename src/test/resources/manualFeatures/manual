Scenario: Setting Up a New MultiCoin Wallet
Given the app is launched for the first time
And the "Getting Started" page is displayed
When the user opts for "Getting Started" and selects "Create new wallet"
And decides to skip the secret backup step
And sets up and confirms a passcode
And agrees to begin using the Trust Wallet and responds to the notification prompt
Then the "Main Wallet 1" should appear on the homepage
And the user should be able to view various cryptocurrency addresses by tapping the address icon

Scenario: Importing an Existing Multi-Coin Wallet Using a Secret Phrase
Given the user possesses a MultiCoin wallet
And knows their twelve-word secret phrase
And launches the app for the first time
And is presented with the "Getting Started" page
When the user proceeds with "Getting Started" and selects "Add existing wallet"
And picks the Secret phrase option for a Multi-coin wallet
And inputs the correct secret phrase to import the wallet as "Added Wallet"
And establishes and confirms a passcode
Then the "Added Wallet" should be visible on the homepage
And the user should be able to view various cryptocurrency addresses by tapping the address icon

Scenario: Attempting to Import a Multi-Coin Wallet with an Incorrect Secret Phrase
Given the user owns a MultiCoin wallet
But lacks the correct twelve-word secret phrase
And initiates the app for the first time
And encounters the "Getting Started" page
When the user proceeds with "Getting Started" and opts to "Add existing wallet"
And selects the Secret phrase option for a Multi-coin wallet
And attempts to import a wallet using an incorrect secret phrase as "Added Wallet"
Then the user should receive an error about the incorrect secret phrase
And should only have the option to go back, not forward

Scenario: Importing an Existing Bitcoin Wallet Using a Secret Phrase
Given the user has a Bitcoin wallet
And possesses a secret phrase that could be twelve, eighteen, or twenty-four words long
And opens the app for the first time
And sees the "Getting Started" page
When the user agrees to "Getting Started" and chooses "Add existing wallet"
And selects the Secret phrase option for a Bitcoin wallet
And imports the wallet with the secret phrase naming it "Bitcoin Wallet 1"
And creates and verifies a passcode
Then "Bitcoin Wallet 1" should be showcased on the homepage
And the user should be able to view bitcoin addresses compatible with the bitcoin network by tapping the address icon