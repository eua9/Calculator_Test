package mvc;

/**
 * The root of the Controller class hierarchy is the AbstractController class.
 * This class defines all the basic facilities required to implement a
 * controller. That is, it allows a view and model to be linked to the
 * controller.
 * <p>
 * It also provides a set of constructors and set and get methods for views and
 * models
 */
public abstract class AbstractController implements Controller {
    /**
     * MANDATORY: Reference to the view this controller manages
     */
    private View view;
    
    /**
     * MANDATORY: Reference to the model this controller manages
     */
    private Model model;
    
    /**
     * MANDATORY: Set the model that this controller manages
     * 
     * @param model The model instance to be managed
     */
    public void setModel(Model model) {
        this.model = model;
    }
    
    /**
     * MANDATORY: Get the model that this controller manages
     * 
     * @return The model instance being managed
     */
    public Model getModel() {
        return model;
    }
    
    /**
     * MANDATORY: Get the view that this controller works with
     * 
     * @return The view instance being controlled
     */
    public View getView() {
        return view;
    }
    
    /**
     * MANDATORY: Set the view that this controller works with
     * 
     * @param view The view instance to be controlled
     */
    public void setView(View view) {
        this.view = view;
    }
}

