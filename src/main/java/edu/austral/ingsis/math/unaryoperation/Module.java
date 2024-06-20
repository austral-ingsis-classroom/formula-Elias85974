package edu.austral.ingsis.math.unaryoperation;

import edu.austral.ingsis.math.Function;
import java.util.List;

public class Module implements Function {
  private final Function function;

  public Module(Function function) {
    this.function = function;
  }

  @Override
  public double execute() {
    return Math.abs(function.execute());
  }

  @Override
  public List<String> getVariables() {
    return function.getVariables();
  }

  @Override
  public String getExpression() {
    return "|" + function.getExpression() + "|";
  }

  @Override
  public List<Function> getFunctions() {
    return List.of(function);
  }

  @Override
  public Function newFunction(List<Function> functions) {
    return new Module(functions.getFirst());
  }
}
