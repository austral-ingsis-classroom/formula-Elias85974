package edu.austral.ingsis.math.binaryoperation;

import edu.austral.ingsis.math.Function;
import edu.austral.ingsis.math.unaryoperation.Module;
import edu.austral.ingsis.math.value.Constant;
import edu.austral.ingsis.math.value.Variable;
import java.util.ArrayList;
import java.util.List;

public class Product implements Function {
  private final Function left;
  private final Function right;

  public Product(Function left, Function right) {
    this.left = left;
    this.right = right;
  }

  @Override
  public double execute() {
    return left.execute() * right.execute();
  }

  @Override
  public List<String> getVariables() {
    List<String> variables = new ArrayList<>(left.getVariables());
    variables.addAll(right.getVariables());
    return variables;
  }

  @Override
  public String getExpression() {
    String leftExpression = left.getExpression();
    String rightExpression = right.getExpression();
    if (!(left instanceof Constant || left instanceof Variable || left instanceof Module)) {
      leftExpression = "(" + leftExpression + ")";
    }
    return leftExpression + " * " + rightExpression;
  }

  @Override
  public List<Function> getFunctions() {
    return List.of(left, right);
  }

  @Override
  public Function newFunction(List<Function> functions) {
    return new Product(functions.get(0), functions.get(1));
  }
}
