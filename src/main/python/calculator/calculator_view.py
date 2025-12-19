"""
The CalculatorView class provides the GUI for the calculator application.
It extends TkinterView to integrate with the MVC framework and implements
the user interface with buttons and display field.
"""
import tkinter as tk
from typing import TYPE_CHECKING
from mvc import TkinterView, ModelEvent
from .calculator_model import CalculatorModel

if TYPE_CHECKING:
    from .calculator_controller import CalculatorController


class CalculatorView(TkinterView):
    # MANDATORY: Operation constants
    PLUS = "+"
    MINUS = "-"
    MULTIPLY = "*"
    DIVIDE = "/"
    CLEAR = "Clr"
    EQUALS = "="
    
    # MANDATORY: GUI components
    def __init__(self, model: CalculatorModel, controller: 'CalculatorController'):
        super().__init__(model, controller)
        self._text_field = tk.Entry(self, justify='right', font=('Arial', 16))
        self._operation = self.PLUS
        
        # Set initial text
        self._text_field.insert(0, "0")
        self._text_field.pack(side=tk.TOP, fill=tk.X, padx=5, pady=5)
        
        # Create button frame
        button_frame = tk.Frame(self)
        button_frame.pack(side=tk.TOP, padx=5, pady=5)
        
        # Create buttons in 4x4 grid layout
        # Row 1: 1, 2, 3, 4
        btn1 = tk.Button(button_frame, text="1", width=5, height=2, font=('Arial', 14),
                        command=lambda: self._handle_button_click("1"))
        btn1.grid(row=0, column=0, padx=2, pady=2)
        btn2 = tk.Button(button_frame, text="2", width=5, height=2, font=('Arial', 14),
                        command=lambda: self._handle_button_click("2"))
        btn2.grid(row=0, column=1, padx=2, pady=2)
        btn3 = tk.Button(button_frame, text="3", width=5, height=2, font=('Arial', 14),
                        command=lambda: self._handle_button_click("3"))
        btn3.grid(row=0, column=2, padx=2, pady=2)
        btn4 = tk.Button(button_frame, text="4", width=5, height=2, font=('Arial', 14),
                        command=lambda: self._handle_button_click("4"))
        btn4.grid(row=0, column=3, padx=2, pady=2)
        
        # Row 2: 5, 6, 7, 8
        btn5 = tk.Button(button_frame, text="5", width=5, height=2, font=('Arial', 14),
                        command=lambda: self._handle_button_click("5"))
        btn5.grid(row=1, column=0, padx=2, pady=2)
        btn6 = tk.Button(button_frame, text="6", width=5, height=2, font=('Arial', 14),
                        command=lambda: self._handle_button_click("6"))
        btn6.grid(row=1, column=1, padx=2, pady=2)
        btn7 = tk.Button(button_frame, text="7", width=5, height=2, font=('Arial', 14),
                        command=lambda: self._handle_button_click("7"))
        btn7.grid(row=1, column=2, padx=2, pady=2)
        btn8 = tk.Button(button_frame, text="8", width=5, height=2, font=('Arial', 14),
                        command=lambda: self._handle_button_click("8"))
        btn8.grid(row=1, column=3, padx=2, pady=2)
        
        # Row 3: 9, 0, -, +
        btn9 = tk.Button(button_frame, text="9", width=5, height=2, font=('Arial', 14),
                        command=lambda: self._handle_button_click("9"))
        btn9.grid(row=2, column=0, padx=2, pady=2)
        btn0 = tk.Button(button_frame, text="0", width=5, height=2, font=('Arial', 14),
                        command=lambda: self._handle_button_click("0"))
        btn0.grid(row=2, column=1, padx=2, pady=2)
        btn_minus = tk.Button(button_frame, text=self.MINUS, width=5, height=2, font=('Arial', 14),
                             command=lambda: self._handle_button_click(self.MINUS))
        btn_minus.grid(row=2, column=2, padx=2, pady=2)
        btn_plus = tk.Button(button_frame, text=self.PLUS, width=5, height=2, font=('Arial', 14),
                            command=lambda: self._handle_button_click(self.PLUS))
        btn_plus.grid(row=2, column=3, padx=2, pady=2)
        
        # Row 4: Clr, =, *, /
        btn_clear = tk.Button(button_frame, text=self.CLEAR, width=5, height=2, font=('Arial', 14),
                             command=lambda: self._handle_button_click(self.CLEAR))
        btn_clear.grid(row=3, column=0, padx=2, pady=2)
        btn_equals = tk.Button(button_frame, text=self.EQUALS, width=5, height=2, font=('Arial', 14),
                              command=lambda: self._handle_button_click(self.EQUALS))
        btn_equals.grid(row=3, column=1, padx=2, pady=2)
        btn_multiply = tk.Button(button_frame, text=self.MULTIPLY, width=5, height=2, font=('Arial', 14),
                                command=lambda: self._handle_button_click(self.MULTIPLY))
        btn_multiply.grid(row=3, column=2, padx=2, pady=2)
        btn_divide = tk.Button(button_frame, text=self.DIVIDE, width=5, height=2, font=('Arial', 14),
                              command=lambda: self._handle_button_click(self.DIVIDE))
        btn_divide.grid(row=3, column=3, padx=2, pady=2)
        
        self.title("Calculator")
        self.resizable(False, False)
    
    """
    MANDATORY: Implement ModelListener interface
    Called when the model changes to update the display
    
    Args:
        event: The ModelEvent containing the new value
    """
    def model_changed(self, event: ModelEvent) -> None:
        msg = str(event.get_amount())
        self._text_field.delete(0, tk.END)
        self._text_field.insert(0, msg)
    
    """
    MANDATORY: Handle button click events
    Delegates to controller
    
    Args:
        command: The button command string
    """
    def _handle_button_click(self, command: str) -> None:
        controller = self.get_controller()
        # Import here to avoid circular import
        from .calculator_controller import CalculatorController
        if isinstance(controller, CalculatorController):
            controller.operation(command)

