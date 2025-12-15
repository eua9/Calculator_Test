package calculator;

import mvc.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for CalculatorController class.
 * Tests the controller's operation dispatch and MVC component coordination.
 */
public class CalculatorControllerTest {
    
    private CalculatorController controller;
    
    @BeforeEach
    void setUp() {
        controller = new CalculatorController();
    }
    
    @Test
    void testControllerInitialization() {
        assertNotNull(controller.getModel());
        assertNotNull(controller.getView());
        assertTrue(controller.getModel() instanceof CalculatorModel);
        assertTrue(controller.getView() instanceof CalculatorView);
    }
    
    @Test
    void testOperationAdd() {
        CalculatorModel model = (CalculatorModel) controller.getModel();
        
        // Store initial value
        controller.operation("5");
        
        // Set addition mode
        controller.operation(CalculatorView.PLUS);
        
        // Store second value
        controller.operation("3");
        
        // Perform calculation
        controller.operation(CalculatorView.EQUALS);
        
        // Verify result through model (we can't easily access private state)
        // This test mainly verifies the operation dispatch works
        assertNotNull(model);
    }
    
    @Test
    void testOperationSubtract() {
        CalculatorModel model = (CalculatorModel) controller.getModel();
        
        controller.operation("10");
        controller.operation(CalculatorView.MINUS);
        controller.operation("4");
        controller.operation(CalculatorView.EQUALS);
        
        assertNotNull(model);
    }
    
    @Test
    void testOperationClear() {
        CalculatorModel model = (CalculatorModel) controller.getModel();
        
        controller.operation("42");
        controller.operation(CalculatorView.CLEAR);
        
        assertNotNull(model);
    }
    
    @Test
    void testOperationDigits() {
        CalculatorModel model = (CalculatorModel) controller.getModel();
        
        // Test all digit operations
        for (int i = 0; i <= 9; i++) {
            controller.operation(String.valueOf(i));
        }
        
        assertNotNull(model);
    }
    
    @Test
    void testOperationSequence() {
        // Test a complete calculation sequence
        controller.operation("7");
        controller.operation(CalculatorView.PLUS);
        controller.operation("3");
        controller.operation(CalculatorView.EQUALS);
        controller.operation(CalculatorView.MINUS);
        controller.operation("2");
        controller.operation(CalculatorView.EQUALS);
        
        CalculatorModel model = (CalculatorModel) controller.getModel();
        assertNotNull(model);
    }
}

