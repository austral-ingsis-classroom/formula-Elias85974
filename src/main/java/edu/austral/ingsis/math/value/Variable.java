package edu.austral.ingsis.math.value;

import edu.austral.ingsis.math.Function;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Variable implements Function {
  private final String variable;

  public Variable(String variable) {
    this.variable = variable;
  }

  @Override
  public double execute() throws IllegalCallerException {
    throw new IllegalCallerException("Cannot execute a variable");
  }

  @Override
  public List<String> getVariables() {
    return List.of(variable);
  }

  @Override
  public String getExpression() {
    return variable;
  }

  @Override
  public Optional<Function> evaluate(double value) {
    return Optional.of(new Constant(value));
  }

  @Override
  public List<Function> getFunctions() {
    return new ArrayList<>(0);
  }

  @Override
  public Function newFunction(List<Function> functions) {
    return new Variable(variable);
  }
}
