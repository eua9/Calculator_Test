package mvc;

/**
 * The Controller interface is the interface which must be implemented by
 * all classes which wish to take the role of a Controller.
 * All controllers must be able to reference a model and a view object.
 * <p>
 * The primary role of a Controller within the MVC is to determine what
 * should happen in response to user input.
 */
public interface Controller {
    /**
     * MANDATORY: Set the model that this controller manages
     * 
     * @param model The model instance to be managed
     */
    void setModel(Model model);
    
    /**
     * MANDATORY: Get the model that this controller manages
     * 
     * @return The model instance being managed
     */
    Model getModel();
    
    /**
     * MANDATORY: Get the view that this controller works with
     * 
     * @return The view instance being controlled
     */
    View getView();
    
    /**
     * MANDATORY: Set the view that this controller works with
     * 
     * @param view The view instance to be controlled
     */
    void setView(View view);
}

