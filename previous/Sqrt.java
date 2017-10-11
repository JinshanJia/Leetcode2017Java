/**
 * 69. Sqrt(x)
 * Implement int sqrt(int x).
 * Compute and return the square root of x.
 */
public class Sqrt {
  public int mySqrt(int x) {
    int start = 0;
    int end = x;
    while (start + 1 < end) {
      int mid = start + (end - start) / 2;
      double square = Math.pow(mid, 2); // over flow if just multiply!!!
      if (square == x) {
        return mid;
      } else if (square < x) {
        start = mid;
      } else {
        end = mid;
      }
    }
    if (Math.pow(end, 2) <= x) {
      return end;
    }
    return start;
  }
}
