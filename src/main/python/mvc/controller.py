"""
The Controller interface is the interface which must be implemented by
all classes which wish to take the role of a Controller.
All controllers must be able to reference a model and a view object.

The primary role of a Controller within the MVC is to determine what
should happen in response to user input.
"""
from abc import ABC, abstractmethod
from typing import TYPE_CHECKING

if TYPE_CHECKING:
    from .model import Model
    from .view import View


class Controller(ABC):
    """
    MANDATORY: Set the model that this controller manages
    
    Args:
        model: The model instance to be managed
    """
    @abstractmethod
    def set_model(self, model: 'Model') -> None:
        pass
    
    """
    MANDATORY: Get the model that this controller manages
    
    Returns:
        The model instance being managed
    """
    @abstractmethod
    def get_model(self) -> 'Model':
        pass
    
    """
    MANDATORY: Get the view that this controller works with
    
    Returns:
        The view instance being controlled
    """
    @abstractmethod
    def get_view(self) -> 'View':
        pass
    
    """
    MANDATORY: Set the view that this controller works with
    
    Args:
        view: The view instance to be controlled
    """
    @abstractmethod
    def set_view(self, view: 'View') -> None:
        pass

