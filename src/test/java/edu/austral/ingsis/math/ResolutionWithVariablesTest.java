package edu.austral.ingsis.math;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import edu.austral.ingsis.math.parser.EvaluationParser;
import edu.austral.ingsis.math.parser.OperationParser;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ResolutionWithVariablesTest {

  /** Case 1 + x where x = 3 */
  @Test
  public void shouldResolveFunction1() {
    final Double result = 4d;
    Function function = OperationParser.parse("1 + x");
    Function evaluatedFunction = EvaluationParser.parse(function, List.of(3d));

    assertThat(evaluatedFunction.execute(), equalTo(result));
  }

  /** Case 12 / div where div = 4 */
  @Test
  public void shouldResolveFunction2() {
    final Double result = 3d;

    Function function = OperationParser.parse("12 / div");
    Function evaluatedFunction = EvaluationParser.parse(function, List.of(4d));

    assertThat(evaluatedFunction.execute(), equalTo(result));
  }

  /** Case (9 / x) * y where x = 3 and y = 4 */
  @Test
  public void shouldResolveFunction3() {
    final Double result = 12d;

    Function function = OperationParser.parse("(9 / x) * y");
    Function evaluatedFunction = EvaluationParser.parse(function, List.of(3d, 4d));

    assertThat(evaluatedFunction.execute(), equalTo(result));
  }

  /** Case (27 / a) ^ b where a = 9 and b = 3 */
  @Test
  public void shouldResolveFunction4() {
    final Double result = 27d;

    Function function = OperationParser.parse("(27 / a) ^ b");
    Function evaluatedFunction = EvaluationParser.parse(function, List.of(9d, 3d));

    assertThat(evaluatedFunction.execute(), equalTo(result));
  }

  /** Case z ^ (1/2) where z = 36 */
  @Test
  public void shouldResolveFunction5() {
    final Double result = 6d;

    Function function = OperationParser.parse("z ^ (1/2)");
    Function evaluatedFunction = EvaluationParser.parse(function, List.of(36d));

    assertThat(evaluatedFunction.execute(), equalTo(result));
  }

  /** Case |value| - 8 where value = 8 */
  @Test
  public void shouldResolveFunction6() {
    final Double result = 0d;

    Function function = OperationParser.parse("|value| - 8");
    Function evaluatedFunction = EvaluationParser.parse(function, List.of(8d));

    assertThat(evaluatedFunction.execute(), equalTo(result));
  }

  /** Case |value| - 8 where value = -8 */
  @Test
  public void shouldResolveFunction7() {
    final Double result = 0d;

    Function function = OperationParser.parse("|value| - 8");
    Function evaluatedFunction = EvaluationParser.parse(function, List.of(-8d));

    assertThat(evaluatedFunction.execute(), equalTo(result));
  }

  /** Case (5 - i) * 8 where i = 2 */
  @Test
  public void shouldResolveFunction8() {
    final Double result = 24d;

    Function function = OperationParser.parse("(5 - i) * 8");
    Function evaluatedFunction = EvaluationParser.parse(function, List.of(2d));

    assertThat(evaluatedFunction.execute(), equalTo(result));
  }
}
