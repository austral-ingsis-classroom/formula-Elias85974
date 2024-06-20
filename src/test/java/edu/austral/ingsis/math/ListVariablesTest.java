package edu.austral.ingsis.math;

import static edu.austral.ingsis.math.parser.OperationParser.parse;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.empty;

import org.junit.jupiter.api.Test;

public class ListVariablesTest {

  /** Case 1 + 6 */
  @Test
  public void shouldListVariablesFunction1() {
    String expression = "1 + 6";
    Function function = parse(expression);

    assertThat(function.getVariables(), empty());
  }

  /** Case 12 / div */
  @Test
  public void shouldListVariablesFunction2() {
    String expression = "12 / div";
    Function function = parse(expression);

    assertThat(function.getVariables(), containsInAnyOrder("div"));
  }

  /** Case (9 / x) * y */
  @Test
  public void shouldListVariablesFunction3() {
    String expression = "(9 / x) * y";
    Function function = parse(expression);

    assertThat(function.getVariables(), containsInAnyOrder("x", "y"));
  }

  /** Case (27 / a) ^ b */
  @Test
  public void shouldListVariablesFunction4() {
    String expression = "(27 / a) ^ b";
    Function function = parse(expression);

    assertThat(function.getVariables(), containsInAnyOrder("a", "b"));
  }

  /** Case z ^ (1/2) */
  @Test
  public void shouldListVariablesFunction5() {
    String expression = "z ^ (1/2)";
    Function function = parse(expression);

    assertThat(function.getVariables(), containsInAnyOrder("z"));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldListVariablesFunction6() {
    String expression = "|value| - 8";
    Function function = parse(expression);

    assertThat(function.getVariables(), containsInAnyOrder("value"));
  }

  /** Case (5 - i) * 8 */
  @Test
  public void shouldListVariablesFunction7() {
    String expression = "(5 - i) * 8";
    Function function = parse(expression);

    assertThat(function.getVariables(), containsInAnyOrder("i"));
  }
}
