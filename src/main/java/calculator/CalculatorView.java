package calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import mvc.*;

/**
 * The CalculatorView class provides the GUI for the calculator application.
 * It extends JFrameView to integrate with the MVC framework and implements
 * the user interface with buttons and display field.
 */
public class CalculatorView extends JFrameView {
    // MANDATORY: Operation constants
    public static final String PLUS = "+";
    public static final String MINUS = "-";
    public static final String CLEAR = "Clr";
    public static final String EQUALS = "=";
    
    // MANDATORY: GUI components
    private JTextField textField = new JTextField();
    private String operation = PLUS;
    
    /**
     * MANDATORY: Constructor that creates the GUI layout
     * 
     * @param model The CalculatorModel instance
     * @param controller The CalculatorController instance
     */
    public CalculatorView(CalculatorModel model, CalculatorController controller) {
        super(model, controller);
        textField.setText("0");
        this.getContentPane().add(textField, BorderLayout.NORTH);
        
        JPanel buttonPanel = new JPanel();
        Handler handler = new Handler();
        
        // Create number buttons
        JButton jButton1 = new JButton("1");
        jButton1.addActionListener(handler);
        JButton jButton2 = new JButton("2");
        jButton2.addActionListener(handler);
        JButton jButton3 = new JButton("3");
        jButton3.addActionListener(handler);
        JButton jButton4 = new JButton("4");
        jButton4.addActionListener(handler);
        JButton jButton5 = new JButton("5");
        jButton5.addActionListener(handler);
        JButton jButton6 = new JButton("6");
        jButton6.addActionListener(handler);
        JButton jButton7 = new JButton("7");
        jButton7.addActionListener(handler);
        JButton jButton8 = new JButton("8");
        jButton8.addActionListener(handler);
        JButton jButton9 = new JButton("9");
        jButton9.addActionListener(handler);
        JButton jButton0 = new JButton("0");
        jButton0.addActionListener(handler);
        
        // Create operation buttons
        JButton minusButton = new JButton(MINUS);
        minusButton.addActionListener(handler);
        JButton plusButton = new JButton(PLUS);
        plusButton.addActionListener(handler);
        JButton clearButton = new JButton(CLEAR);
        clearButton.addActionListener(handler);
        JButton equalsButton = new JButton(EQUALS);
        equalsButton.addActionListener(handler);
        
        // Set layout and add buttons
        buttonPanel.setLayout(new GridLayout(4, 4, 5, 5));
        this.getContentPane().add(buttonPanel, BorderLayout.CENTER);
        
        buttonPanel.add(jButton1, null);
        buttonPanel.add(jButton2, null);
        buttonPanel.add(jButton3, null);
        buttonPanel.add(jButton4, null);
        buttonPanel.add(jButton5, null);
        buttonPanel.add(jButton6, null);
        buttonPanel.add(jButton7, null);
        buttonPanel.add(jButton8, null);
        buttonPanel.add(jButton9, null);
        buttonPanel.add(jButton0, null);
        buttonPanel.add(minusButton, null);
        buttonPanel.add(plusButton, null);
        buttonPanel.add(clearButton, null);
        buttonPanel.add(equalsButton, null);
        
        pack();
    }
    
    /**
     * MANDATORY: Implement ModelListener interface
     * Called when the model changes to update the display
     * 
     * @param event The ModelEvent containing the new value
     */
    public void modelChanged(ModelEvent event) {
        String msg = event.getAmount() + "";
        textField.setText(msg);
    }
    
    /**
     * MANDATORY: Inner class for event handling
     * Handles button clicks and delegates to controller
     */
    class Handler implements ActionListener {
        /**
         * MANDATORY: Handle button click events
         * 
         * @param e The ActionEvent from button click
         */
        public void actionPerformed(ActionEvent e) {
            ((CalculatorController)getController()).operation(e.getActionCommand());
        }
    }
}

