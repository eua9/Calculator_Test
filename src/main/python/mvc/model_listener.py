"""
Interface for objects that want to be notified of ModelEvent changes.
This interface follows the Observer pattern to allow loose coupling
between models and their observers.
"""
from abc import ABC, abstractmethod
from typing import TYPE_CHECKING

if TYPE_CHECKING:
    from .model_event import ModelEvent


class ModelListener(ABC):
    """
    MANDATORY: Method called when a model changes its state
    
    Args:
        event: The ModelEvent containing information about the change
    """
    @abstractmethod
    def model_changed(self, event: 'ModelEvent') -> None:
        pass

