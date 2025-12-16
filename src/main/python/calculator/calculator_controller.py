"""
The CalculatorController class handles user input and coordinates between
the CalculatorModel and CalculatorView. It extends AbstractController
to provide MVC framework integration.
"""
from mvc import AbstractController
from .calculator_model import CalculatorModel
from .calculator_view import CalculatorView


class CalculatorController(AbstractController):
    """
    MANDATORY: Constructor that initializes the MVC components
    Creates the model and view, and makes the view visible
    """
    def __init__(self):
        super().__init__()
        model = CalculatorModel()
        self.set_model(model)
        view = CalculatorView(model, self)
        self.set_view(view)
        view.mainloop()
    
    """
    MANDATORY: Handle user operations from the view
    
    Args:
        option: The operation string ("+", "-", "*", "=", "Clr", or digit)
    """
    def operation(self, option: str) -> None:
        model = self.get_model()
        if not isinstance(model, CalculatorModel):
            return
        
        if option == CalculatorView.MINUS:
            model.subtract()
        elif option == CalculatorView.PLUS:
            model.add()
        elif option == CalculatorView.MULTIPLY:
            model.multiply()
        elif option == CalculatorView.CLEAR:
            model.clear()
        elif option == CalculatorView.EQUALS:
            model.equals()
        else:
            try:
                value = int(option)
                model.store(value)
            except ValueError:
                pass  # Invalid input, ignore

