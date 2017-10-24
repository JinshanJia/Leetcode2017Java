/**
 * 162. Find Peak Element
 *
 * A peak element is an element that is greater than its neighbors.
 *
 * Given an input array where num[i] ≠ num[i+1], find a peak element and return
 * its index.
 *
 * The array may contain multiple peaks, in that case return the index to any 
 * one of the peaks is fine.
 *
 * You may imagine that num[-1] = num[n] = -∞.
 *
 * For example, in array [1, 2, 3, 1], 3 is a peak element and your function 
 * should return the index number 2.
 */
class FindPeakElement162 {
  public int findPeakElement(int[] nums) {
    if (nums == null || nums.length == 0) {
      return -1;
    }
    int start = 0;
    int end = nums.length - 1;
    while (start + 1 < end) {
      int mid = start + (end - start) / 2;
      if (nums[mid] > getLeftNumber(nums, mid)
          && nums[mid] > getRightNumber(nums, mid)) {
        return mid;
      } else if (nums[mid] < getLeftNumber(nums, mid)) {
        end = mid;
      } else {
        start = mid;
      }
    }
    return nums[start] > nums[end] ? start : end;
  }
  
  private static int getLeftNumber(int[] nums, int index) {
    if (index <= 0) {
      return Integer.MIN_VALUE;
    } else {
      return nums[index - 1];
    }
  }

  private static int getRightNumber(int[] nums, int index) {
    if (index >= nums.length - 1) {
      return Integer.MIN_VALUE;
    } else {
      return nums[index + 1];
    }
  }
}
