package mvc;

import javax.swing.*;

/**
 * The JFrameView class is the root class of the view class hierarchy for top level
 * (swing) frames. It allows a controller and a model to be registered and can register
 * itself with a model as an observer of that model.
 * <p>
 * It this extends the JFrame class.
 * <p>
 * It requires the implementation of the <code>modelChanged(ModelEvent event);</code>
 * method in order that it can work with the notification mechanism in Java.
 */
abstract public class JFrameView extends JFrame implements View, ModelListener {
    /**
     * MANDATORY: Reference to the model this view observes
     */
    private Model model;
    
    /**
     * MANDATORY: Reference to the controller this view works with
     */
    private Controller controller;
    
    /**
     * MANDATORY: Constructor that initializes the view with model and controller
     * 
     * @param model The model instance to observe
     * @param controller The controller instance to work with
     */
    public JFrameView(Model model, Controller controller) {
        setModel(model);
        setController(controller);
    }
    
    /**
     * MANDATORY: Register this view as a listener with the model
     */
    public void registerWithModel() {
        ((AbstractModel)model).addModelListener(this);
    }
    
    /**
     * MANDATORY: Get the controller that this view works with
     * 
     * @return The controller instance
     */
    public Controller getController() {
        return controller;
    }
    
    /**
     * MANDATORY: Set the controller that this view works with
     * 
     * @param controller The controller instance to work with
     */
    public void setController(Controller controller) {
        this.controller = controller;
    }
    
    /**
     * MANDATORY: Get the model that this view observes
     * 
     * @return The model instance being observed
     */
    public Model getModel() {
        return model;
    }
    
    /**
     * MANDATORY: Set the model that this view observes and register as listener
     * 
     * @param model The model instance to observe
     */
    public void setModel(Model model) {
        this.model = model;
        registerWithModel();
    }
}

