/**
 * 50. Pow(x, n)
 * Implement pow(x, n).
 */
public class PowXn {
  public double myPow(double x, int n) {
    if (n == 0) {
      return 1;
    }

    if (x == 0 || n == 1) {
      return x;
    }
    return n < 0 ? 1. / powHelper(x, Math.abs((long) n)) : powHelper(x, n);
  }

  private double powHelper(double x, long n) {
    if (n == 1) {
      return x;
    }
    double result = x;
    long power = 1;
    while (power * 2 < n) {
      result *= result;
      power += power;
    }
    return result * powHelper(x, n - power);
  }
}
