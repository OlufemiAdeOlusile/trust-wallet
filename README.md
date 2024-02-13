# Trust Wallet
The trust wallet appium test repo is provided to test the creation
and addition of existing wallets (Scope is limited to multi-coin wallets). It also tests
the management of cryptos on the app (show and remove crypto).
Due to time the tests only cover the positive cases in an end to end manner using cucumber (BDD)
This allows us for easy reusability and multiple permutations of the same tests.

### Running Tests with Gradle
#### 1. build project with gradle build
```shell
./gradlew build
```
#### 2. Manually spin up an appium Server
#### 3. Configure  [defaults.conf](src%2Fmain%2Fresources%2Fconf%2Fdefaults.conf) or override via environment variables
#### 4. Run all tests with the following command
```shell
./gradlew cucumberCli
```

## Framework Structure

### Configuration and Initialization

AppConfig: Located in the com.trustWallet.config package, this class is the heart of the Spring configuration. It declares beans for the AndroidDriver and FluentWait, ensuring they're appropriately managed and accessible throughout the framework. The @ComponentScan annotation is used to automatically detect and register page objects and other components defined within specified packages.

### Core Components

DriverManager: This class is responsible for setting up and returning an instance of AndroidDriver, configured with the desired capabilities for the Appium server. It encapsulates the complexity of driver initialization, including setting up device configurations and app paths.

### Page Objects

The framework employs the Page Object Model, where each page object class represents a screen in the Trust Wallet app. These classes are found under com.trustWallet.page and its subpackages. They contain methods that interact with the UI elements on their respective screens, making the tests more readable and maintainable.

### Context Management
#### For Example 
OnboardingScenario: This component, located in com.trustWallet.context, serves as a container for all page objects related to the onboarding process. It uses Spring's @Autowired annotation to inject the necessary page object dependencies. This class acts as a facade, providing a simplified interface for test scripts to interact with the onboarding flow.

### Utility Classes
WidgetsPopUpsUtility: This utility class provides methods to handle common widgets and pop-ups that appear throughout the app, such as notifications or reset prompts. It's an example of how utility classes can abstract repetitive interactions, making them reusable across different test scenarios.

###Testing Flow
The testing flow typically begins with the CucumberRunnerTest, which orchestrates the execution of Cucumber feature files. The step definition classes under com.trustWallet.steps translate these feature files into actions, utilizing the OnboardingScenario context and other page objects to interact with the app.

### Spring Integration
Spring is utilized primarily for dependency injection, ensuring that each component, like page objects and utility classes, is instantiated and managed by the Spring container. This approach reduces boilerplate code for object creation and allows for more flexible test configurations.

---