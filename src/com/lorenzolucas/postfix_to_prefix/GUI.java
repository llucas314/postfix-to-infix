package com.lorenzolucas.postfix_to_prefix;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

/**
 * This program converts a postfix expression to an infix expression and creates a file that outputs a 3-address code.
 *
 * @author Lorenzo Lucas
 * @version 1.0
 * @since 2/10/19
 */
public class GUI extends JFrame {

    //Creates GUI constructor
    public GUI(){
        super("3-Address Generator");
        setSize(350,150);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel mainPanel = new JPanel();
        JPanel inputPanel = new JPanel();
        JPanel buttonPanel = new JPanel();
        JPanel resultPanel = new JPanel();
        // input panel
        inputPanel.setLayout(new GridLayout(1,2));
        JLabel inputLabel = new JLabel("Enter Postfix Expression", JLabel.CENTER);
        inputPanel.add(inputLabel);
        JTextField inputTextField = new JTextField();
        inputTextField.setEditable(true);
        inputPanel.add(inputTextField);
        // button panel
        JButton button = new JButton("Construct Tree");
        buttonPanel.add(button);
        // result panel
        resultPanel.setLayout(new GridLayout(1,2));
        JLabel resultLabel = new JLabel("Infix Expression", JLabel.CENTER);
        resultPanel.add(resultLabel);
        JTextField resultTextField = new JTextField();
        resultTextField.setEditable(false);
        resultPanel.add(resultTextField);
        //main panel
        mainPanel.setLayout(new GridLayout(3,1));
        mainPanel.add(inputPanel);
        mainPanel.add(buttonPanel);
        mainPanel.add(resultPanel);
        add(mainPanel);
        //button action
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userInput = inputTextField.getText();
                ExpressionStack expressionStack = new ExpressionStack();
                String finalResult = null;
                try {
                    System.out.println("3-Address Instructions for " + userInput + "\n");
                    finalResult = expressionStack.evaluate(userInput);
                    System.out.println("\n");
                } catch (InputException | StackException se){
                    JOptionPane.showMessageDialog(null, se.getMessage());
                    System.out.println("3-Address cannot be produced for " + userInput + ".");
                }
                resultTextField.setText(finalResult);
            }
        });

    }
    //main method
    public static void main(String[] args) {
        GUI gui = new GUI();
        gui.setVisible(true);

        //prints to file
        PrintStream printStream = null;
        File file = new File("threeAddressFile.txt");
        try {
            PrintStream console = System.out;
            System.setOut(printStream = new PrintStream(file));
        } catch (IOException ioe){
            JOptionPane.showMessageDialog(null, "An error has occurred " +
                    "during the creation of your file.");
        }
    }
}
