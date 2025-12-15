package calculator;

import mvc.*;

/**
 * The CalculatorModel class implements the business logic for a simple calculator
 * that supports integer addition and subtraction operations.
 * It extends AbstractModel to provide observer pattern functionality.
 */
public class CalculatorModel extends AbstractModel {
    /**
     * MANDATORY: Running total for calculations
     */
    private int total = 0;
    
    /**
     * MANDATORY: Current value being displayed/entered
     */
    private int current = 0;
    
    /**
     * MANDATORY: Current operation state ("add" or "subtract")
     */
    private String state = "add";
    
    /**
     * MANDATORY: Clear the calculator - reset all values to 0
     */
    public void clear() {
        total = 0;
        store(0);
    }
    
    /**
     * MANDATORY: Store a new value and notify observers
     * 
     * @param value The integer value to store
     */
    public void store(int value) {
        current = value;
        ModelEvent me = new ModelEvent(this, 1, "", current);
        notifyChanged(me);
    }
    
    /**
     * MANDATORY: Set the calculator to addition mode
     */
    public void add() {
        state = "add";
        total = current;
    }
    
    /**
     * MANDATORY: Set the calculator to subtraction mode
     */
    public void subtract() {
        state = "subtract";
        total = current;
    }
    
    /**
     * MANDATORY: Perform the calculation based on current state
     */
    public void equals() {
        if (state.equals("add")) {
            total += current;
        } else {
            total -= current;
        }
        current = total;
        // Now notify any interested parties in the new total
        ModelEvent me = new ModelEvent(this, 1, "", total);
        notifyChanged(me);
    }
}

