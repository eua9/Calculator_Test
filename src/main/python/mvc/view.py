"""
This interface must be implemented by all classes that wish to take the role
of the View within the MVC framework.
The role of a View is the display of information and the capture of
data entered.
"""
from abc import ABC, abstractmethod
from typing import TYPE_CHECKING

if TYPE_CHECKING:
    from .model import Model
    from .controller import Controller


class View(ABC):
    """
    MANDATORY: Get the controller that this view works with
    
    Returns:
        The controller instance managing this view
    """
    @abstractmethod
    def get_controller(self) -> 'Controller':
        pass
    
    """
    MANDATORY: Set the controller that this view works with
    
    Args:
        controller: The controller instance to manage this view
    """
    @abstractmethod
    def set_controller(self, controller: 'Controller') -> None:
        pass
    
    """
    MANDATORY: Get the model that this view observes
    
    Returns:
        The model instance being observed
    """
    @abstractmethod
    def get_model(self) -> 'Model':
        pass
    
    """
    MANDATORY: Set the model that this view observes
    
    Args:
        model: The model instance to be observed
    """
    @abstractmethod
    def set_model(self, model: 'Model') -> None:
        pass

