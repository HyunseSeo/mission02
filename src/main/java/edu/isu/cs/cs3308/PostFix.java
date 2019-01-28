package edu.isu.cs.cs3308;

import edu.isu.cs.cs3308.structures.impl.LinkedStack;

/**
 * Postfix expression evaluator.
 *
 * @author Isaac Griffith
 */
public class PostFix {


    /**
     * Evaluates the provided postfix expression and returns the answer. If the
     * provided string is null, empty, or only contains whitespace then return
     * 0;
     *
     * @param postfix A string representing an postfix notation expression where
     *                each item is separated by a space.
     * @return value of the postfix express or 0 if the postfix expression is null,
     * empty, or contains only whitespace.
     */

    // create a Linked Stack for put numbers and using if statements to check to calculate data.
    // I did not figure out test No.5

    public static int evalPostFix(String infix) {


        LinkedStack Stack = new LinkedStack<>();
        if (infix == null || infix.trim().isEmpty()) {
            return 0;
        } else {
            String[] test = infix.split(" ");
            for (int i = 0; i < test.length; i++) {

                try {
                    int value = Integer.parseInt(test[i]);
                    Stack.push(value);
                    System.out.println(value);

                } catch (Exception e) {
                    int a = (int) Stack.pop();
                    int b = (int) Stack.pop();

                    if (test[i].equals("+")) {
                        int result = b + a;
                        Stack.push(result);
                    } else if (test[i].equals("-")) {

                        int result = b - a;
                        Stack.push(result);
                    } else if (test[i].equals("*")) {
                        int result = b * a;
                        Stack.push(result);
                    } else if (test[i].equals("/")) {
                        int result = b / a;

                        Stack.push(result);
                    }

                }

            }
            return (int) Stack.pop();
        }
        //throw new UnsupportedOperationException("Not supported yet.");
    }
}





