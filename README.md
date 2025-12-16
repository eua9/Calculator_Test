# MVC Calculator Application

A complete MVC (Model-View-Controller) calculator application built with Python and tkinter, following proper software architecture principles and design patterns.

## Project Structure

```
Calculator_Test/
├── src/
│   └── main/
│       └── python/
│           ├── mvc/           # MVC Framework classes (8 modules)
│           │   ├── __init__.py
│           │   ├── model.py
│           │   ├── controller.py
│           │   ├── view.py
│           │   ├── model_event.py
│           │   ├── model_listener.py
│           │   ├── abstract_model.py
│           │   ├── abstract_controller.py
│           │   └── tkinter_view.py
│           ├── calculator/    # Calculator Application (5 modules)
│           │   ├── __init__.py
│           │   ├── main.py
│           │   ├── calculator_model.py
│           │   ├── calculator_controller.py
│           │   └── calculator_view.py
│           └── main.py        # Entry point
├── requirements.txt           # Python dependencies
└── README.md                  # This file
```

## Requirements

- **Python 3.7** or higher
- **tkinter** (included with Python standard library)

## Running the Application

Run the calculator application directly with Python:

```bash
cd src/main/python
python3 main.py
```

Or from the project root:

```bash
python3 src/main/python/main.py
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
- **Tkinter GUI**: Modern Python tkinter interface with 4x4 button grid
- **Event-Driven**: Button clicks trigger controller operations
- **Type Hints**: Full Python type annotations for better code clarity

## Testing

To add tests, you can use pytest or unittest:

```bash
# Install pytest (optional)
pip install pytest

# Run tests
pytest src/test/python/
```

## Architecture

### MVC Framework (`mvc` package)

The framework provides reusable MVC components:

1. **Abstract Base Classes**: `Model`, `Controller`, `View`, `ModelListener`
2. **Event System**: `ModelEvent` class for notifications
3. **Abstract Classes**: 
   - `AbstractModel` - Implements observer pattern
   - `AbstractController` - Manages model/view references
   - `TkinterView` - Tkinter integration for views

### Calculator Application (`calculator` package)

Application-specific implementations:

1. **CalculatorModel**: Integer arithmetic logic (add/subtract operations)
2. **CalculatorController**: Coordinates between model and view
3. **CalculatorView**: Tkinter GUI with buttons and display
4. **main**: Application entry point

## Usage Example

1. Start the application: `python3 src/main/python/main.py`
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
