package edu.austral.ingsis.math;

import static edu.austral.ingsis.math.parser.OperationParser.parse;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;

public class PrintTest {

  /** Case 1 + 6 */
  @Test
  public void shouldPrintFunction1() {
    final String expected = "1 + 6";
    Function operation = parse(expected);

    assertThat(operation.getExpression(), equalTo(expected));
  }

  /** Case 12 / 2 */
  @Test
  public void shouldPrintFunction2() {
    final String expected = "12 / 2";
    Function operation = parse(expected);

    assertThat(operation.getExpression(), equalTo(expected));
  }

  /** Case (9 / 2) * 3 */
  @Test
  public void shouldPrintFunction3() {
    final String expected = "(9 / 2) * 3";
    Function operation = parse(expected);

    assertThat(operation.getExpression(), equalTo(expected));
  }

  /** Case (27 / 6) ^ 2 */
  @Test
  public void shouldPrintFunction4() {
    final String expected = "(27 / 6) ^ 2";
    Function operation = parse(expected);

    assertThat(operation.getExpression(), equalTo(expected));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldPrintFunction6() {
    final String expected = "|value| - 8";
    Function operation = parse(expected);

    assertThat(operation.getExpression(), equalTo(expected));
  }

  /** Case (5 - i) * 8 */
  @Test
  public void shouldPrintFunction7() {
    final String expected = "(5 - i) * 8";
    Function operation = parse(expected);

    assertThat(operation.getExpression(), equalTo(expected));
  }
}
