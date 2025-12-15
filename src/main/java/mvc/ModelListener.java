package mvc;

/**
 * Interface for objects that want to be notified of ModelEvent changes.
 * This interface follows the Observer pattern to allow loose coupling
 * between models and their observers.
 */
public interface ModelListener {
    /**
     * MANDATORY: Method called when a model changes its state
     * 
     * @param event The ModelEvent containing information about the change
     */
    public void modelChanged(ModelEvent event);
}

