package mvc;

/**
 * This interface must be implemented by all class that wish to play the Model
 * role within the MVC framework.
 * <p>
 * The only method specified by the interface is the <code>notifyChanged()
 * </code> method.
 */
public interface Model {
    /**
     * MANDATORY: Method called by model implementations to notify 
     * interested observers of state changes.
     * 
     * @param event ModelEvent containing change information
     */
    void notifyChanged(ModelEvent event);
}

