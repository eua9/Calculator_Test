"""
The TkinterView class is the root class of the view class hierarchy for top level
(tkinter) frames. It allows a controller and a model to be registered and can register
itself with a model as an observer of that model.

It extends the tkinter.Tk class.

It requires the implementation of the model_changed(ModelEvent event) method
in order that it can work with the notification mechanism.
"""
import tkinter as tk
from typing import Optional
from .view import View
from .model_listener import ModelListener
from .model import Model
from .controller import Controller
from .abstract_model import AbstractModel


class TkinterView(tk.Tk, View, ModelListener):
    """
    MANDATORY: Reference to the model this view observes
    """
    def __init__(self, model: Model, controller: Controller):
        tk.Tk.__init__(self)
        self._model: Optional[Model] = None
        self._controller: Optional[Controller] = None
        self.set_model(model)
        self.set_controller(controller)
    
    """
    MANDATORY: Register this view as a listener with the model
    """
    def register_with_model(self) -> None:
        if isinstance(self._model, AbstractModel):
            self._model.add_model_listener(self)
    
    """
    MANDATORY: Get the controller that this view works with
    
    Returns:
        The controller instance
    """
    def get_controller(self) -> Controller:
        return self._controller
    
    """
    MANDATORY: Set the controller that this view works with
    
    Args:
        controller: The controller instance to work with
    """
    def set_controller(self, controller: Controller) -> None:
        self._controller = controller
    
    """
    MANDATORY: Get the model that this view observes
    
    Returns:
        The model instance being observed
    """
    def get_model(self) -> Model:
        return self._model
    
    """
    MANDATORY: Set the model that this view observes and register as listener
    
    Args:
        model: The model instance to observe
    """
    def set_model(self, model: Model) -> None:
        self._model = model
        self.register_with_model()

