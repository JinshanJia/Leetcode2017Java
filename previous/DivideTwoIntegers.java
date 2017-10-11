/**
 * 29. Divide Two Integers
 * Divide two integers without using multiplication, division and mod operator.
 * If it is overflow, return MAX_INT.
 */
public class DivideTwoIntegers {
  public int divide(int dividend, int divisor) {
    if (divisor == 0) {
      return Integer.MAX_VALUE;
    }
    long absDividend = Math.abs((long) dividend);
    long absDivisor = Math.abs((long) divisor);

    boolean smallerThanZero = (dividend < 0) != (divisor < 0);

    if (absDividend < absDivisor) {
      return 0;
    }

    long result = divideHelper(absDividend, absDivisor);
    if (result > Integer.MAX_VALUE && !smallerThanZero) {
      return Integer.MAX_VALUE;
    } else if (result > (long) Integer.MAX_VALUE + 1 && smallerThanZero) {
      return Integer.MIN_VALUE;
    }
    return smallerThanZero ? (((int) result ^ -1) + 1) : (int) result;
  }

  private long divideHelper(long dividend, long divisor) {
    if (dividend < divisor) {
      return 0;
    }

    long multiple = 1;
    long sum = divisor;
    while (sum + sum < dividend) {
      sum += sum;
      multiple += multiple;
    }

    return multiple + divideHelper(dividend - sum, divisor);
  }
}
