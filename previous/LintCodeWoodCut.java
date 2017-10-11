/**
 * Wood Cut (http://www.lintcode.com/en/problem/wood-cut/#)
 * Given n pieces of wood with length L[i] (integer array). Cut them into small
 * pieces to guarantee you could have equal or more than k pieces with the same
 * length. What is the longest length you can get from the n pieces of wood?
 * Given L & k, return the maximum length of the small pieces.
 *
 * Notice
 * You couldn't cut wood into float length.
 * If you couldn't get >= k pieces, return 0.
 *
 * Example
 * For L=[232, 124, 456], k=7, return 114.
 */
public class LintCodeWoodCut {
  /**
   *@param L: Given n pieces of wood with length L[i]
   *@param k: An integer
   *return: The maximum length of the small pieces.
   */
  public int woodCut(int[] L, int k) {
    // write your code here
    if (L == null || L.length == 0) {
      return 0;
    }
    long length = 0;
    for (int l : L) {
      length += l;    // Max of L should be enough.
    }

    long start = 1;
    long end = length;
    while (start + 1 < end) {
      long mid = start + (end - start) / 2;
      long midPieces = getMaxPieces(L, mid);
      if (midPieces >= k) {
        start = mid;
      } else {
        end = mid;
      }
    }

    if (getMaxPieces(L, end) >= k) {
      return (int) end;
    } else if (getMaxPieces(L, start) >= k) {
      return (int) start;
    }
    return 0;
  }

  private long getMaxPieces(int[] L, long length) {
    long result = 0;
    for (int l : L) {
      result += l / length;
    }
    return result;
  }
}
