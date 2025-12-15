package mvc;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Abstract root class of Model hierarchy - provides basic
 * notification behaviour
 */
public abstract class AbstractModel implements Model {
    /**
     * MANDATORY: List of ModelListener objects interested in changes
     */
    private ArrayList listeners = new ArrayList(5);
    
    /**
     * MANDATORY: Method that is called by subclasses of AbstractModel when they want to
     * notify other classes of changes to themselves.
     * 
     * @param event The ModelEvent containing change information
     */
    public void notifyChanged(ModelEvent event) {
        ArrayList list = (ArrayList)listeners.clone();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ModelListener ml = (ModelListener)it.next();
            ml.modelChanged(event);
        }
    }
    
    /**
     * MANDATORY: Add a ModelListener to the list of objects interested in ModelEvents.
     * 
     * @param l The ModelListener to add
     */
    public void addModelListener(ModelListener l) {
        listeners.add(l);
    }
    
    /**
     * MANDATORY: Remove a ModelListener from the list of objects interested in ModelEvents
     * 
     * @param l The ModelListener to remove
     */
    public void removeModelListener(ModelListener l) {
        listeners.remove(l);
    }
}

