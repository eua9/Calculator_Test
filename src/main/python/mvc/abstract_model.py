"""
Abstract root class of Model hierarchy - provides basic
notification behaviour
"""
from typing import List
from .model import Model
from .model_listener import ModelListener
from .model_event import ModelEvent


class AbstractModel(Model):
    """
    MANDATORY: List of ModelListener objects interested in changes
    """
    def __init__(self):
        self._listeners: List[ModelListener] = []
    
    """
    MANDATORY: Method that is called by subclasses of AbstractModel when they want to
    notify other classes of changes to themselves.
    
    Args:
        event: The ModelEvent containing change information
    """
    def notify_changed(self, event: ModelEvent) -> None:
        # Clone list to avoid modification during iteration
        listeners_copy = list(self._listeners)
        for listener in listeners_copy:
            listener.model_changed(event)
    
    """
    MANDATORY: Add a ModelListener to the list of objects interested in ModelEvents.
    
    Args:
        listener: The ModelListener to add
    """
    def add_model_listener(self, listener: ModelListener) -> None:
        self._listeners.append(listener)
    
    """
    MANDATORY: Remove a ModelListener from the list of objects interested in ModelEvents
    
    Args:
        listener: The ModelListener to remove
    """
    def remove_model_listener(self, listener: ModelListener) -> None:
        if listener in self._listeners:
            self._listeners.remove(listener)

