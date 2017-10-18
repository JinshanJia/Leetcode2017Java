/**
 *  153. Find Minimum in Rotated Sorted Array
 *  Suppose an array sorted in ascending order is rotated at some pivot unknown
 *  to you beforehand.
 *
 *  (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 *
 *  Find the minimum element.
 *
 *  You may assume no duplicate exists in the array.
 */
class FindMinimumInRotatedSortedArray153 {
  public int findMin(int[] nums) {
    if (nums == null || nums.length == 0) {
      throw new IllegalArgumentException("invalid");
    }
    // Not rotated.
    if (nums[0] < nums[nums.length - 1]) {
      return nums[0];
    }
    int start = 0;
    int end = nums.length - 1;
    while (start + 1 < end) {
      int mid = start + (end - start) / 2;
      if (nums[mid] < nums[start]) {
        end = mid;
      } else {
        start = mid;
      }
    }
    return nums[end];
  }
}
