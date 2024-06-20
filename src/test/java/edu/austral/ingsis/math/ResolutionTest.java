package edu.austral.ingsis.math;

import static edu.austral.ingsis.math.parser.OperationParser.parse;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;

public class ResolutionTest {

  /** Case 1 + 6 */
  @Test
  public void shouldResolveSimpleFunction1() {
    final Double result = 7d;
    String expression = "1 + 6";
    Function function = parse(expression);

    assertThat(function.execute(), equalTo(result));
  }

  /** Case 12 / 2 */
  @Test
  public void shouldResolveSimpleFunction2() {
    final Double result = 6d;
    String expression = "12 / 2";
    Function function = parse(expression);

    assertThat(function.execute(), equalTo(result));
  }

  /** Case (9 / 2) * 3 */
  @Test
  public void shouldResolveSimpleFunction3() {
    final Double result = 13.5;
    String expression = "(9 / 2) * 3";
    Function function = parse(expression);

    assertThat(function.execute(), equalTo(result));
  }

  /** Case (27 / 6) ^ 2 */
  @Test
  public void shouldResolveSimpleFunction4() {
    final Double result = 20.25;
    String expression = "(27 / 6) ^ 2";
    Function function = parse(expression);

    assertThat(function.execute(), equalTo(result));
  }

  /** Case 36 ^ (1/2) */
  @Test
  public void shouldResolveSimpleFunction5() {
    final Double result = 6d;
    String expression = "36 ^ (1/2)";
    Function function = parse(expression);

    assertThat(function.execute(), equalTo(result));
  }

  /** Case |136| */
  @Test
  public void shouldResolveSimpleFunction6() {
    final Double result = 136d;
    String expression = "|136|";
    Function function = parse(expression);

    assertThat(function.execute(), equalTo(result));
  }

  /** Case |-136| */
  @Test
  public void shouldResolveSimpleFunction7() {
    final Double result = 136d;
    String expression = "|-136|";
    Function function = parse(expression);

    assertThat(function.execute(), equalTo(result));
  }

  /** Case (5 - 5) * 8 */
  @Test
  public void shouldResolveSimpleFunction8() {
    final Double result = 0d;
    String expression = "(5 - 5) * 8";
    Function function = parse(expression);

    assertThat(function.execute(), equalTo(result));
  }
}
