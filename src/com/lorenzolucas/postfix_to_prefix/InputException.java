/*
 * File: InputException.java
 * Name: Lorenzo Lucas
 * Date: 2/10/2019
 * Purpose: Creates an exception class used for invalid tokens
 */
package com.lorenzolucas.postfix_to_prefix;

/**
 * Creates an exception class for user input errors.
 *
 * @author Lorenzo Lucas
 * @version 1.0
 * @since 2/10/19
 */
public class InputException extends Exception {
    public InputException(String exceptionMessage) {
        super(exceptionMessage);}
}
