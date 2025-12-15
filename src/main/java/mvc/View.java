package mvc;

/**
 * This interface must be implemented by all classes that wish to take the role
 * of the View within the MVC framework.
 * The role of a View is the display of information and the capture of
 * data entered.
 */
public interface View {
    /**
     * MANDATORY: Get the controller that this view works with
     * 
     * @return The controller instance managing this view
     */
    Controller getController();
    
    /**
     * MANDATORY: Set the controller that this view works with
     * 
     * @param controller The controller instance to manage this view
     */
    void setController(Controller controller);
    
    /**
     * MANDATORY: Get the model that this view observes
     * 
     * @return The model instance being observed
     */
    Model getModel();
    
    /**
     * MANDATORY: Set the model that this view observes
     * 
     * @param model The model instance to be observed
     */
    void setModel(Model model);
}

