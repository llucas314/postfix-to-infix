/*
 * File: OperatorNode.java
 * Name: Lorenzo Lucas
 * Date: 2/10/2019
 * Purpose: Creates a node class for the operators used in the expression
 */
package com.lorenzolucas.postfix_to_prefix;

/**
 * Defines methods for operator class.
 *
 * @author Lorenzo Lucas
 * @version 1.0
 * @since 2/10/19
 */
public class OperatorNode extends Node{
    private Node left;
    private Node right;
    private String parent;
    private static int registerNumber = 0;
    private String register;


    public OperatorNode(String parent, Node left, Node right){
        this.parent = parent;
        this.left = left;
        this.right = right;
    }

    /**
     * Recursively walks through a postfix expression to generate an infix expression.
     * @return parenthesized infix expression
     */
    @Override
    public String infixWalk() {
        String leftValue = left.infixWalk();
        String rightValue = right.infixWalk();
        return "(" + leftValue + parent + rightValue + ")";
    }

    /**
     * Prints out three addresses and creates registers.
     * @return register value
     */

    @Override
    public String valueOf() {
        String leftValueOf = left.valueOf();
        String rightValueOf = right.valueOf();
        if ((left.isLeaf()) && (right.isLeaf())) {
            register = "R" + String.valueOf(registerNumber);
            registerNumber++;
        } else if ((left.isLeaf()) && (!right.isLeaf())) {
            register = rightValueOf;
        } else if ((!left.isLeaf()) && (right.isLeaf())) {
            register = leftValueOf;
        } else if ((!left.isLeaf()) && (!right.isLeaf())){
            register = leftValueOf;
            registerNumber--;
        }
        System.out.println(operatorType(parent) + " " + register + " " + leftValueOf + " " + rightValueOf);
        return register;
    }

    /**
     * Resets the register number for next evaluation that is input to the program.
     */
    public void resetStaticInt() {
        registerNumber = 0;
    }

    /**
     * Tests if node is a leaf or internal.
     * @return true if node is a leaf
     */
    public boolean isLeaf(){
        return false;
    }
    //method converts operation symbols to string
    private String operatorType(String symbol){
        String operation = null;
        switch (symbol){
            case "*" : operation = "Multiply";
                break;
            case "/" : operation = "Divide";
                break;
            case "+" : operation = "Add";
                break;
            case "-" : operation = "Subtract";
                break;
        }
        return operation;
    }
}
