package mvc;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for ModelEvent class.
 * Tests the event class that extends ActionEvent.
 */
public class ModelEventTest {
    
    @Test
    void testModelEventCreation() {
        Object source = new Object();
        int id = 1;
        String message = "test message";
        int amount = 42;
        
        ModelEvent event = new ModelEvent(source, id, message, amount);
        
        assertEquals(source, event.getSource());
        assertEquals(id, event.getID());
        assertEquals(message, event.getActionCommand());
        assertEquals(amount, event.getAmount());
    }
    
    @Test
    void testGetAmount() {
        ModelEvent event = new ModelEvent(this, 1, "", 100);
        assertEquals(100, event.getAmount());
    }
    
    @Test
    void testNegativeAmount() {
        ModelEvent event = new ModelEvent(this, 1, "", -50);
        assertEquals(-50, event.getAmount());
    }
    
    @Test
    void testZeroAmount() {
        ModelEvent event = new ModelEvent(this, 1, "", 0);
        assertEquals(0, event.getAmount());
    }
    
    @Test
    void testDifferentEventIDs() {
        ModelEvent event1 = new ModelEvent(this, 1, "event1", 10);
        ModelEvent event2 = new ModelEvent(this, 2, "event2", 20);
        
        assertEquals(1, event1.getID());
        assertEquals(2, event2.getID());
    }
    
    @Test
    void testActionCommand() {
        ModelEvent event = new ModelEvent(this, 1, "custom message", 5);
        assertEquals("custom message", event.getActionCommand());
    }
    
    @Test
    void testEmptyMessage() {
        ModelEvent event = new ModelEvent(this, 1, "", 7);
        assertEquals("", event.getActionCommand());
    }
}

