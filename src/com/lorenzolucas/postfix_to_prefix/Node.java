package com.lorenzolucas.postfix_to_prefix;

/**
 * Creates abstract class for operand and operator node classes.
 *
 * @author Lorenzo Lucas
 * @version 1.0
 * @since 2/10/19
 */

public abstract class Node {
    abstract public String infixWalk();
    abstract public String valueOf();
    abstract boolean isLeaf();
    abstract void resetStaticInt();
}

