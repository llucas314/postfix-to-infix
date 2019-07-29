package com.lorenzolucas.postfix_to_prefix;
import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Defines the methods that takes a postfix expression and converts it to an infix expression.
 *
 * @author Lorenzo Lucas
 * @version 1.0
 * @since 2/10/19
 */
public class ExpressionStack {

    private Stack<Node> stack;

    public ExpressionStack(){
        stack = new Stack<>();
    }

    /**
     * Evaluates the postfix expression string and converts it to an infix expression.
     * @param expression the user input postfix expression
     * @return the evaluated infix expression
     * @throws InputException if the postfix expression has syntactical errors
     * @throws StackException if the stack is empty
     */
    public String evaluate(String expression) throws InputException, StackException {
        //tokenize the string containing the expression
        String[] tokens = expression.split("");
        Node evaluation = null;
        String resultOfEvaluation = null;
        //while there are more tokens get the next token
        for (int i = 0; i < tokens.length; i++) {
            OperatorNode operatorNode;
            OperandNode operandNode;
            if (tokens[i].equals(" ")){
                continue;
            } else if (isInteger(tokens[i])){
                operandNode = new OperandNode(Integer.parseInt(tokens[i]));
                stack.push(operandNode);
            } else if ((isOperator(tokens[i]))){
                try {
                    Node rightValue = stack.pop();
                    Node leftValue = stack.pop();
                    operatorNode = new OperatorNode(tokens[i], leftValue, rightValue);
                    stack.push(operatorNode);
                } catch (EmptyStackException e){
                    throw new StackException("There is an error in your syntax!");
                }
            } else {
                throw new StackException("There is an error in your syntax!");
            }
        }
        if (!stack.empty()){
            evaluation = stack.pop();
            if (!stack.empty()){
                throw new StackException("There is an error in your syntax!");
            }
            resultOfEvaluation = evaluation.infixWalk();
            evaluation.valueOf();
            evaluation.resetStaticInt();
        }
        return resultOfEvaluation;
    }
    private boolean isInteger(String numberInput){
        try {
            Integer.parseInt(numberInput);
            return true;
        } catch (NumberFormatException ne){
            return false;
        }
    }
    private boolean isOperator(String operatorInput)throws InputException {
        if (operatorInput.equals("*") || operatorInput.equals("/")
                || operatorInput.equals("+") || operatorInput.equals("-")){
            return true;
        } else {
            throw new InputException("\"" + operatorInput + "\" is an invalid character.\n\n" +
                    "Enter valid characters:\n\n\"0-9\", \"*\", \"/\", \"+\", \"-\"");
        }
    }

}
