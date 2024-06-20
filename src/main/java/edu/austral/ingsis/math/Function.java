package edu.austral.ingsis.math;

import java.util.List;
import java.util.Optional;

public interface Function {
  double execute() throws IllegalCallerException;

  String toString();

  List<String> getVariables();

  String getExpression();

  default Optional<Function> evaluate(double value) {
    return Optional.empty();
  }

  List<Function> getFunctions();

  Function newFunction(List<Function> functions);
}
