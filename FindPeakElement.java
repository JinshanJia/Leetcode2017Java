/**
 * 162. Find Peak Element
 * A peak element is an element that is greater than its neighbors.
 * Given an input array where num[i] ≠ num[i+1], find a peak element and return
 * its index.
 *
 * The array may contain multiple peaks, in that case return the index to any
 * one of the peaks is fine.
 * You may imagine that num[-1] = num[n] = -∞.
 * For example, in array [1, 2, 3, 1], 3 is a peak element and your function
 * should return the index number 2.
 */
public class FindPeakElement {
  public int findPeakElement(int[] nums) {
    if (nums == null || nums.length == 0) {
      return -1;
    }
    int start  = 0;
    int end = nums.length - 1;
    while (start + 1 < end) {
      int mid = start + (end - start) / 2;
      boolean biggerThanLeft = isBiggerThanLeft(nums, mid);
      boolean biggerThanRight = isBiggerThanRight(nums, mid);
      if (biggerThanLeft && biggerThanRight) {
        return mid;
      }
      if (biggerThanLeft) {
        start = mid;
      } else {
        end = mid;
      }
    }

    return nums[start] > nums[end] ? start : end;
  }

  private boolean isBiggerThanLeft(int[] nums, int index) {
    if (index < 0) {
      return false;
    }
    if (index == 0) {
      return true;
    }
    return nums[index] > nums[index - 1];
  }

  private boolean isBiggerThanRight(int[] nums, int index) {
    if (index > nums.length - 1) {
      return false;
    }
    if (index == nums.length - 1) {
      return true;
    }
    return nums[index] > nums[index + 1];
  }
}
