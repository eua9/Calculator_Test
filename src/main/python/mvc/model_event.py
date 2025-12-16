"""
Used to notify interested objects of changes in the
state of a model
"""


class ModelEvent:
    """
    MANDATORY: Amount value for calculator operations
    """
    def __init__(self, source: object, event_id: int, message: str, amount: int):
        """
        MANDATORY: Constructor to create a ModelEvent
        
        Args:
            source: The object that is the source of the event
            event_id: An integer that identifies the event
            message: A string that describes the event
            amount: The amount value associated with the event
        """
        self._source = source
        self._id = event_id
        self._message = message
        self._amount = amount
    
    def get_source(self) -> object:
        """Get the source object of the event"""
        return self._source
    
    def get_id(self) -> int:
        """Get the event ID"""
        return self._id
    
    def get_action_command(self) -> str:
        """Get the action command/message"""
        return self._message
    
    def get_amount(self) -> int:
        """
        MANDATORY: Get the amount value associated with this event
        
        Returns:
            The amount value
        """
        return self._amount

