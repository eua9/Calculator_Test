package calculator;

import mvc.*;

/**
 * The CalculatorController class handles user input and coordinates between
 * the CalculatorModel and CalculatorView. It extends AbstractController
 * to provide MVC framework integration.
 */
public class CalculatorController extends AbstractController {
    
    /**
     * MANDATORY: Constructor that initializes the MVC components
     * Creates the model and view, and makes the view visible
     */
    public CalculatorController() {
        setModel(new CalculatorModel());
        setView(new CalculatorView((CalculatorModel)getModel(), this));
        ((JFrameView)getView()).setVisible(true);
    }
    
    /**
     * MANDATORY: Handle user operations from the view
     * 
     * @param option The operation string ("+", "-", "=", "Clr", or digit)
     */
    public void operation(String option) {
        if (option.equals(CalculatorView.MINUS)) {
            ((CalculatorModel)getModel()).subtract();
        } else if (option.equals(CalculatorView.PLUS)) {
            ((CalculatorModel)getModel()).add();
        } else if (option.equals(CalculatorView.CLEAR)) {
            ((CalculatorModel)getModel()).clear();
        } else if (option.equals(CalculatorView.EQUALS)) {
            ((CalculatorModel)getModel()).equals();
        } else {
            ((CalculatorModel)getModel()).store(Integer.parseInt(option));
        }
    }
}

