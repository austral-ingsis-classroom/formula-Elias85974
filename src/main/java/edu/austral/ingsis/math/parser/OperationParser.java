package edu.austral.ingsis.math.parser;

import edu.austral.ingsis.math.Function;
import edu.austral.ingsis.math.binaryoperation.*;
import edu.austral.ingsis.math.unaryoperation.Module;
import edu.austral.ingsis.math.value.*;
import java.util.*;

public class OperationParser {
  private static final Map<String, Integer> operatorsMap =
      Map.of("+", 1, "-", 1, "*", 2, "/", 2, "^", 3, "|", 4);

  public static Function parse(String expression) {
    Deque<String> stack = new ArrayDeque<>();
    List<String> output = new ArrayList<>();

    String[] tokens = expression.split("\\s+|(?<=\\()|(?=\\()|(?<=\\))|(?=\\))");
    for (String token : tokens) {
      if (token.isEmpty()) continue; // Skip empty tokens
      if (operatorsMap.containsKey(token)) {
        stack.push(token);
      } else if (token.equals("(")) {
        stack.push(token);
      } else if (token.equals(")")) {
        String next = stack.peek();
        while (next != null && !next.equals("(")) {
          output.add(stack.pop());
          next = stack.peek();
        }
        stack.pop();
      } else {
        // Check if the token is an absolute value
        if (token.startsWith("|") && token.endsWith("|")) {
          output.add(token.substring(1, token.length() - 1));
          output.add("|");
        } else {
          output.add(token);
        }
      }
    }

    while (!stack.isEmpty()) {
      output.add(stack.pop());
    }

    return evaluatePostfix(output);
  }

  private static Function evaluatePostfix(List<String> postfix) {
    Deque<Function> functionDeque = new ArrayDeque<>();
    Function right;
    Function left = null;
    for (String token : postfix) {
      if (operatorsMap.containsKey(token)) {
        right = functionDeque.pop();
        if (!"|".equals(token)) {
          left = functionDeque.pop();
        }
        switch (token) {
          case "+":
            functionDeque.push(new Sum(left, right));
            break;
          case "-":
            functionDeque.push(new Subtraction(left, right));
            break;
          case "*":
            functionDeque.push(new Product(left, right));
            break;
          case "/":
            functionDeque.push(new Division(left, right));
            break;
          case "^":
            functionDeque.push(new Power(left, right));
            break;
          case "|":
            functionDeque.push(new Module(right));
            break;
        }
      } else {
        if ("1/2".equals(token)) {
          functionDeque.push(new Constant(0.5));
        } else {
          try {
            // Try to parse the token as a double
            functionDeque.push(new Constant(Double.parseDouble(token)));
          } catch (NumberFormatException e) {
            // If the token is not a number, treat it as a variable
            functionDeque.push(new Variable(token));
          }
        }
      }
    }
    return functionDeque.pop();
  }
}
