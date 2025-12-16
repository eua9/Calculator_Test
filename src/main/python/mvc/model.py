"""
This interface must be implemented by all classes that wish to play the Model
role within the MVC framework.

The only method specified by the interface is the notifyChanged() method.
"""
from abc import ABC, abstractmethod


class Model(ABC):
    """
    MANDATORY: Method called by model implementations to notify 
    interested observers of state changes.
    
    Args:
        event: ModelEvent containing change information
    """
    @abstractmethod
    def notify_changed(self, event: 'ModelEvent') -> None:
        pass

