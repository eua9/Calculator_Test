package mvc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for AbstractModel class.
 * Tests the observer pattern implementation.
 */
public class AbstractModelTest {
    
    private TestModel model;
    private TestModelListener listener1;
    private TestModelListener listener2;
    
    /**
     * Concrete implementation of AbstractModel for testing
     */
    private static class TestModel extends AbstractModel {
        private int value = 0;
        
        public void setValue(int value) {
            this.value = value;
            ModelEvent event = new ModelEvent(this, 1, "value changed", value);
            notifyChanged(event);
        }
        
        public int getValue() {
            return value;
        }
    }
    
    /**
     * Test helper class to capture model events
     */
    private static class TestModelListener implements ModelListener {
        private List<ModelEvent> events = new ArrayList<>();
        
        @Override
        public void modelChanged(ModelEvent event) {
            events.add(event);
        }
        
        public List<ModelEvent> getEvents() {
            return events;
        }
        
        public void clearEvents() {
            events.clear();
        }
        
        public int getEventCount() {
            return events.size();
        }
    }
    
    @BeforeEach
    void setUp() {
        model = new TestModel();
        listener1 = new TestModelListener();
        listener2 = new TestModelListener();
    }
    
    @Test
    void testAddModelListener() {
        model.addModelListener(listener1);
        model.setValue(5);
        
        assertEquals(1, listener1.getEventCount());
        assertEquals(5, listener1.getEvents().get(0).getAmount());
    }
    
    @Test
    void testMultipleListeners() {
        model.addModelListener(listener1);
        model.addModelListener(listener2);
        model.setValue(10);
        
        assertEquals(1, listener1.getEventCount());
        assertEquals(1, listener2.getEventCount());
        assertEquals(10, listener1.getEvents().get(0).getAmount());
        assertEquals(10, listener2.getEvents().get(0).getAmount());
    }
    
    @Test
    void testRemoveModelListener() {
        model.addModelListener(listener1);
        model.addModelListener(listener2);
        
        model.setValue(5);
        assertEquals(1, listener1.getEventCount());
        assertEquals(1, listener2.getEventCount());
        
        model.removeModelListener(listener1);
        model.setValue(10);
        
        // listener1 should still have 1 event
        assertEquals(1, listener1.getEventCount());
        // listener2 should have 2 events
        assertEquals(2, listener2.getEventCount());
    }
    
    @Test
    void testNotifyChanged() {
        model.addModelListener(listener1);
        model.setValue(42);
        
        ModelEvent event = listener1.getEvents().get(0);
        assertNotNull(event);
        assertEquals(model, event.getSource());
        assertEquals(42, event.getAmount());
        assertEquals(1, event.getID());
        assertEquals("value changed", event.getActionCommand());
    }
    
    @Test
    void testNoListeners() {
        // Should not throw exception when no listeners
        model.setValue(100);
        assertEquals(0, listener1.getEventCount());
    }
}

