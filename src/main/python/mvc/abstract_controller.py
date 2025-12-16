"""
The root of the Controller class hierarchy is the AbstractController class.
This class defines all the basic facilities required to implement a
controller. That is, it allows a view and model to be linked to the
controller.

It also provides a set of constructors and set and get methods for views and
models
"""
from typing import Optional
from .controller import Controller
from .model import Model
from .view import View


class AbstractController(Controller):
    """
    MANDATORY: Reference to the view this controller manages
    """
    def __init__(self):
        self._view: Optional[View] = None
        self._model: Optional[Model] = None
    
    """
    MANDATORY: Set the model that this controller manages
    
    Args:
        model: The model instance to be managed
    """
    def set_model(self, model: Model) -> None:
        self._model = model
    
    """
    MANDATORY: Get the model that this controller manages
    
    Returns:
        The model instance being managed
    """
    def get_model(self) -> Model:
        return self._model
    
    """
    MANDATORY: Get the view that this controller works with
    
    Returns:
        The view instance being controlled
    """
    def get_view(self) -> View:
        return self._view
    
    """
    MANDATORY: Set the view that this controller works with
    
    Args:
        view: The view instance to be controlled
    """
    def set_view(self, view: View) -> None:
        self._view = view

