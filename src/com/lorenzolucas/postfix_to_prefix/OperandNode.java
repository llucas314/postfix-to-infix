/*
 * File: OperandNode.java
 * Name: Lorenzo Lucas
 * Date: 2/10/2019
 * Purpose: Creates a node class for the integers being evaluated
 */
package com.lorenzolucas.postfix_to_prefix;

/**
 * Defines methods for the operand nodes.
 *
 * @author Lorenzo Lucas
 * @version 1.0
 * @since 2/10/19
 */
public class OperandNode extends Node {
    private int value;

    public OperandNode(int value){
        this.value = value;
    }

    @Override
    public String infixWalk() {
        return String.valueOf(value);
    }

    public String valueOf(){
        return String.valueOf(value);
    }

    public boolean isLeaf(){
        return true;
    }
    public void resetStaticInt() {}
}
