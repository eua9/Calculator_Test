package calculator;

import mvc.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for CalculatorModel class.
 * Tests the business logic for calculator operations including
 * addition, subtraction, storage, and clearing.
 */
public class CalculatorModelTest {
    
    private CalculatorModel model;
    private TestModelListener listener;
    
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
        
        public ModelEvent getLastEvent() {
            return events.isEmpty() ? null : events.get(events.size() - 1);
        }
    }
    
    @BeforeEach
    void setUp() {
        model = new CalculatorModel();
        listener = new TestModelListener();
        model.addModelListener(listener);
    }
    
    @Test
    void testStore() {
        model.store(5);
        
        ModelEvent lastEvent = listener.getLastEvent();
        assertNotNull(lastEvent);
        assertEquals(5, lastEvent.getAmount());
        assertEquals(model, lastEvent.getSource());
    }
    
    @Test
    void testAdd() {
        model.store(10);
        listener.clearEvents();
        model.add();
        
        // add() should not trigger a notification
        assertEquals(0, listener.getEvents().size());
    }
    
    @Test
    void testSubtract() {
        model.store(20);
        listener.clearEvents();
        model.subtract();
        
        // subtract() should not trigger a notification
        assertEquals(0, listener.getEvents().size());
    }
    
    @Test
    void testAdditionOperation() {
        // Store first number
        model.store(5);
        listener.clearEvents();
        
        // Set to addition mode
        model.add();
        
        // Store second number
        model.store(3);
        listener.clearEvents();
        
        // Perform calculation
        model.equals();
        
        ModelEvent lastEvent = listener.getLastEvent();
        assertNotNull(lastEvent);
        assertEquals(8, lastEvent.getAmount()); // 5 + 3 = 8
    }
    
    @Test
    void testSubtractionOperation() {
        // Store first number
        model.store(10);
        listener.clearEvents();
        
        // Set to subtraction mode
        model.subtract();
        
        // Store second number
        model.store(4);
        listener.clearEvents();
        
        // Perform calculation
        model.equals();
        
        ModelEvent lastEvent = listener.getLastEvent();
        assertNotNull(lastEvent);
        assertEquals(6, lastEvent.getAmount()); // 10 - 4 = 6
    }
    
    @Test
    void testClear() {
        model.store(42);
        listener.clearEvents();
        
        model.clear();
        
        ModelEvent lastEvent = listener.getLastEvent();
        assertNotNull(lastEvent);
        assertEquals(0, lastEvent.getAmount());
    }
    
    @Test
    void testMultipleOperations() {
        // First operation: 10 + 5 = 15
        model.store(10);
        model.add();
        model.store(5);
        model.equals();
        
        ModelEvent event1 = listener.getLastEvent();
        assertEquals(15, event1.getAmount());
        listener.clearEvents();
        
        // Second operation: 15 - 3 = 12
        model.subtract();
        model.store(3);
        model.equals();
        
        ModelEvent event2 = listener.getLastEvent();
        assertEquals(12, event2.getAmount());
    }
    
    @Test
    void testNegativeResults() {
        model.store(5);
        model.subtract();
        model.store(10);
        model.equals();
        
        ModelEvent lastEvent = listener.getLastEvent();
        assertEquals(-5, lastEvent.getAmount()); // 5 - 10 = -5
    }
    
    @Test
    void testZeroOperations() {
        model.store(0);
        model.add();
        model.store(0);
        model.equals();
        
        ModelEvent lastEvent = listener.getLastEvent();
        assertEquals(0, lastEvent.getAmount()); // 0 + 0 = 0
    }
}

