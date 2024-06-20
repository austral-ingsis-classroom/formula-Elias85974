package edu.austral.ingsis.math.value;

import edu.austral.ingsis.math.Function;
import java.util.ArrayList;
import java.util.List;

public class Constant implements Function {
  private final double value;

  public Constant(double value) {
    this.value = value;
  }

  @Override
  public double execute() {
    return value;
  }

  @Override
  public List<String> getVariables() {
    return new ArrayList<>(0);
  }

  @Override
  public String getExpression() {
    return String.valueOf((int) value);
  }

  @Override
  public List<Function> getFunctions() {
    return new ArrayList<>(0);
  }

  @Override
  public Function newFunction(List<Function> functions) {
    return new Constant(value);
  }
}
