package mvc;

import java.awt.event.ActionEvent;

/**
 * Used to notify interested objects of changes in the
 * state of a model
 */
public class ModelEvent extends ActionEvent {
    /**
     * MANDATORY: Amount value for calculator operations
     */
    private int amount;
    
    /**
     * MANDATORY: Constructor to create a ModelEvent
     * 
     * @param obj The object that is the source of the event
     * @param id An integer that identifies the event
     * @param message A string that describes the event
     * @param amount The amount value associated with the event
     */
    public ModelEvent(Object obj, int id, String message, int amount) {
        super(obj, id, message);
        this.amount = amount;
    }
    
    /**
     * MANDATORY: Get the amount value associated with this event
     * 
     * @return The amount value
     */
    public int getAmount() {
        return amount;
    }
}

