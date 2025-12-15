# MVC Calculator Application

A complete MVC (Model-View-Controller) calculator application built with Java Swing, following proper software architecture principles and design patterns.

## Project Structure

```
Calculator_Test/
├── src/
│   ├── main/java/
│   │   ├── mvc/           # MVC Framework classes (8 classes)
│   │   │   ├── Model.java
│   │   │   ├── Controller.java
│   │   │   ├── View.java
│   │   │   ├── ModelEvent.java
│   │   │   ├── ModelListener.java
│   │   │   ├── AbstractModel.java
│   │   │   ├── AbstractController.java
│   │   │   └── JFrameView.java
│   │   └── calculator/    # Calculator Application (4 classes)
│   │       ├── Main.java
│   │       ├── CalculatorModel.java
│   │       ├── CalculatorController.java
│   │       └── CalculatorView.java
│   └── test/java/         # JUnit Tests
│       ├── calculator/
│       │   ├── CalculatorModelTest.java
│       │   └── CalculatorControllerTest.java
│       └── mvc/
│           ├── AbstractModelTest.java
│           └── ModelEventTest.java
├── build.gradle           # Gradle build configuration
└── gradlew                # Gradle wrapper script
```

## Requirements

- **Java JDK 17** or higher
- **Gradle** (wrapper included, or install Gradle 8.5+)

## Building the Project

### Option 1: Using Gradle Wrapper (Recommended)

```bash
# Build the project
./gradlew build

# Run the application
./gradlew run
# or
./gradlew runCalculator

# Run tests
./gradlew test
```

### Option 2: Using Installed Gradle

If you have Gradle installed on your system:

```bash
# Build the project
gradle build

# Run the application
gradle run

# Run tests
gradle test
```

## Running the Application

After building, you can run the calculator application:

```bash
./gradlew run
```

The calculator GUI will appear with:
- A text field at the top for displaying results
- A 4x4 grid of buttons including:
  - Number buttons (0-9)
  - Operation buttons: `+` (add), `-` (subtract), `=` (equals), `Clr` (clear)

## Features

- **MVC Architecture**: Proper separation of concerns with Model, View, and Controller
- **Observer Pattern**: Model notifies views of state changes
- **Integer Arithmetic**: Supports addition and subtraction operations
- **Swing GUI**: Modern Java Swing interface with 4x4 button grid
- **Event-Driven**: Button clicks trigger controller operations

## Testing

The project includes comprehensive JUnit 5 tests:

- **CalculatorModelTest**: Tests calculator business logic (addition, subtraction, storage, clear)
- **CalculatorControllerTest**: Tests controller operation dispatch
- **AbstractModelTest**: Tests observer pattern implementation
- **ModelEventTest**: Tests event class functionality

Run tests with:
```bash
./gradlew test
```

Test reports will be available in `build/reports/tests/test/index.html`

## Architecture

### MVC Framework (`mvc` package)

The framework provides reusable MVC components:

1. **Interfaces**: `Model`, `Controller`, `View`, `ModelListener`
2. **Event System**: `ModelEvent` extends `ActionEvent` for notifications
3. **Abstract Classes**: 
   - `AbstractModel` - Implements observer pattern
   - `AbstractController` - Manages model/view references
   - `JFrameView` - Swing integration for views

### Calculator Application (`calculator` package)

Application-specific implementations:

1. **CalculatorModel**: Integer arithmetic logic (add/subtract operations)
2. **CalculatorController**: Coordinates between model and view
3. **CalculatorView**: Swing GUI with buttons and display
4. **Main**: Application entry point

## Usage Example

1. Start the application: `./gradlew run`
2. Enter first number by clicking digit buttons
3. Click `+` for addition or `-` for subtraction
4. Enter second number
5. Click `=` to perform calculation
6. Click `Clr` to clear and start over

## Development

This project follows the MVC pattern with:
- **Model**: Business logic and state management
- **View**: User interface and presentation
- **Controller**: Mediates between Model and View

All components communicate through well-defined interfaces, ensuring loose coupling and high cohesion.

## License

This is a test/educational project. 
