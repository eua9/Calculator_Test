"""
The CalculatorModel class implements the business logic for a simple calculator
that supports integer addition, subtraction, and multiplication operations.
It extends AbstractModel to provide observer pattern functionality.
"""
from mvc import AbstractModel, ModelEvent


class CalculatorModel(AbstractModel):
    """
    MANDATORY: Running total for calculations
    """
    def __init__(self):
        super().__init__()
        self._total = 0
        self._current = 0
        self._state = "add"
    
    """
    MANDATORY: Clear the calculator - reset all values to 0
    """
    def clear(self) -> None:
        self._total = 0
        self.store(0)
    
    """
    MANDATORY: Store a new value and notify observers
    
    Args:
        value: The integer value to store
    """
    def store(self, value: int) -> None:
        self._current = value
        event = ModelEvent(self, 1, "", self._current)
        self.notify_changed(event)
    
    """
    MANDATORY: Set the calculator to addition mode
    """
    def add(self) -> None:
        self._state = "add"
        self._total = self._current
    
    """
    MANDATORY: Set the calculator to subtraction mode
    """
    def subtract(self) -> None:
        self._state = "subtract"
        self._total = self._current
    
    """
    MANDATORY: Set the calculator to multiplication mode
    """
    def multiply(self) -> None:
        self._state = "multiply"
        self._total = self._current
    
    """
    MANDATORY: Perform the calculation based on current state
    """
    def equals(self) -> None:
        if self._state == "add":
            self._total += self._current
        elif self._state == "subtract":
            self._total -= self._current
        elif self._state == "multiply":
            self._total *= self._current
        self._current = self._total
        # Now notify any interested parties in the new total
        event = ModelEvent(self, 1, "", self._total)
        self.notify_changed(event)

