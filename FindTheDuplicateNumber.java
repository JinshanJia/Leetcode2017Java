import java.util.Arrays;

/**
 * 287. Find the Duplicate Number
 *
 * Given an array nums containing n + 1 integers where each integer is between 1
 * and n (inclusive), prove that at least one duplicate number must exist.
 * Assume that there is only one duplicate number, find the duplicate one.
 *
 * Note:
 * You must not modify the array (assume the array is read only).
 * You must use only constant, O(1) extra space.
 * Your runtime complexity should be less than O(n2).
 * There is only one duplicate number in the array, but it could be repeated
 * more than once.
 */
public class FindTheDuplicateNumber {
  public int findDuplicate(int[] nums) {
    int start = 1;
    int end = nums.length;
    while (start + 1 < end) {
      int mid = start + (end - start) / 2;
      final int finalStart = start;   // looks ugly...
      long count = Arrays.stream(nums).filter(num -> num < mid && num >= finalStart).count();
      if (count > mid - start) {
        end = mid;
      } else {
        start = mid;
      }
    }
    final int startResult = start;  // Looks ugly...
    long count = Arrays.stream(nums).filter(num -> num == startResult).count();
    return count > 1 ? start : end;
  }
}
