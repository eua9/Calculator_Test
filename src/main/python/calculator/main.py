"""
Main entry point for the Calculator application
This class starts the MVC calculator by creating a CalculatorController
"""
from .calculator_controller import CalculatorController


def main():
    """
    MANDATORY: Main function to start the calculator application
    """
    CalculatorController()


if __name__ == "__main__":
    main()

