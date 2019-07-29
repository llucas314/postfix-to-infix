
package com.lorenzolucas.postfix_to_prefix;

/**
 * Creates an exception class for stack errors.
 *
 * @author Lorenzo Lucas
 * @version 1.0
 * @since 2/10/19
 */

public class StackException extends Exception{
    public StackException(String message){
        super(message);
    }
}