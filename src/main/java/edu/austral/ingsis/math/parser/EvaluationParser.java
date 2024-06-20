package edu.austral.ingsis.math.parser;

import edu.austral.ingsis.math.Function;
import edu.austral.ingsis.math.value.Variable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EvaluationParser {
  public static Function parse(Function function, List<Double> values) {
    return replaceVariables(function, values.iterator());
  }

  private static Function replaceVariables(Function function, Iterator<Double> iterator) {
    if (function instanceof Variable) {
      return function.evaluate(iterator.next()).orElseThrow();
    } else {
      List<Function> functions = function.getFunctions();
      List<Function> newFunctions = new ArrayList<>();
      for (Function subFunction : functions) {
        newFunctions.add(replaceVariables(subFunction, iterator));
      }
      return function.newFunction(newFunctions);
    }
  }
}
