/**
 * 154. Find Minimum in Rotated Sorted Array II
 *
 * Follow up for "Find Minimum in Rotated Sorted Array":
 * What if duplicates are allowed?
 * Would this affect the run-time complexity? How and why?
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown
 * to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * Find the minimum element.
 * The array may contain duplicates.
 */
public class FindMinimuminRotatedSortedArrayII {
  public int findMin(int[] nums) {
    if (nums == null || nums.length == 0) {
      return -1;
    }

    int start = 0;
    int end = nums.length - 1;
    while (start + 1 < end) {
      int mid = start + (end - start) / 2;
      if (nums[end] > nums[mid]) {
        end = mid;
      } else if (nums[end] < nums[mid]) {
        start = mid;
      } else {
        end--;
      }
    }

    return nums[start] < nums[end] ? nums[start] : nums[end];
  }
}
