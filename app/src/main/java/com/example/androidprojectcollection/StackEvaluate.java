package com.example.androidprojectcollection;

import static android.content.ContentValues.TAG;

import android.util.Log;

import java.text.DecimalFormat;
import java.util.Stack;
public class StackEvaluate {

    public static Stack<Double> numbers; //stack for numbers
    public static Stack<Character> operations; //stack for operations

    //checks level of precendence, true of secondOp is higher or same precedence as, else false
    public static boolean precedenceChecker(char firstOp, char secondOp) {
        if (secondOp == '(' || secondOp == ')')
            return false;
        return (firstOp != '*' && firstOp != '/') || (secondOp != '+' && secondOp != '-');
    }

    public static double smolEvaluate(char op, double b, double a) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0) throw new ArithmeticException("Division by zero is not permitted");
                return a / b;
        }
        return 0;
    }

    public static double preEvaluate(String expression) {

        if(expression.equals(null)){
            System.out.println("Param is null");
            return 0;
        }
        String[] tokens = expression.split("(?=[+\\-*/])|(?<=[+\\-*/])");
        double result = Double.parseDouble(tokens[0]);
        for (int i = 1; i < tokens.length; i += 2) {
            String operator = tokens[i];

            if (i + 1 < tokens.length) {
                double operand = Double.parseDouble(tokens[i + 1]);
                switch (operator) {
                    case "+":
                        result += operand;
                        break;
                    case "-":
                        result -= operand;
                        break;
                    case "*":
                        result *= operand;
                        break;
                    case "/":
                        if (operand == 0) {
                            throw new ArithmeticException("Division by zero");
                        }
                        result /= operand;
                        break;
                }
            } else {
                break;
            }
        }
        DecimalFormat format = new DecimalFormat("#.####");
        return result;
    }

    public static double bigEvaluate(String stringToEvaluate) {

        numbers = new Stack<>(); //stack for numbers
        operations = new Stack<>();

        char[] toks = stringToEvaluate.toCharArray();

        for (int i = 0; i < toks.length; i++) {
            if ((toks[i] >= '0' && toks[i] <= '9') || toks[i] == '.' ) {
                StringBuilder sb = new StringBuilder();
                while (i < toks.length && toks[i] >= '0' && toks[i] <= '9' || toks[i] == '.') {
                    sb.append(toks[i++]);
                }
                Log.d(TAG, "bigEvaluate: "+sb.toString());
                numbers.push(Double.parseDouble(sb.toString()));
                i--;
            }else if (toks[i] == '('){
                operations.push(toks[i]); //REMEMBER push sa operations stack not sa numbers
            }else if (toks[i] == ')') {
                while (operations.peek() != '('){
                    numbers.push(smolEvaluate(operations.pop(), numbers.pop(), numbers.pop()));
                }
                operations.pop();
            }else if (toks[i] == '+' || toks[i] == '-' || toks[i] == '*' || toks[i] == '/') {
                if (i < toks.length - 1 && (toks[i + 1] >= '0' && toks[i + 1] <= '9') || toks[i + 1] == '.') {
                    // Check if the next character is a digit, indicating a complete operation
                    while (!operations.empty() && precedenceChecker(toks[i], operations.peek())) {
                        numbers.push(smolEvaluate(operations.pop(), numbers.pop(), numbers.pop()));
                    }
                    operations.push(toks[i]);
                }
            }
        }

        while (!operations.empty()) numbers.push(smolEvaluate(operations.pop(), numbers.pop(), numbers.pop()));
        return numbers.pop();
    }
}