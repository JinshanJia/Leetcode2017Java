/**
 * 81. Search in Rotated Sorted Array II
 * Follow up for "Search in Rotated Sorted Array":
 * What if duplicates are allowed?
 * Would this affect the run-time complexity? How and why?
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown
 * to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * Write a function to determine if a given target is in the array.
 * The array may contain duplicates.
 */
public class SearchinRotatedSortedArrayII {
  public boolean search(int[] nums, int target) {
    if (nums == null || nums.length == 0) {
      return false;
    }
    int start = 0;
    int end = nums.length - 1;
    return searchHelper(nums, target, start, end);
  }

  private boolean searchHelper(int[] nums, int target, int start, int end) {
    if (start + 1 >= end) {
      return nums[start] == target || nums[end] == target;
    }
    int mid = start + (end - start) / 2;
    if (nums[mid] == target) {
      return true;
    }

    if (nums[start] == nums[mid] && nums[mid] == nums[end]) {
      return searchHelper(nums, target, start, mid) || searchHelper(nums, target, mid, end);
    }

    if (nums[start] <= nums[mid]) {
      if (nums[start] <= target && target <= nums[mid]) {
        return searchHelper(nums, target, start, mid);
      } else {
        return searchHelper(nums, target, mid, end);
      }
    } else {
      if (nums[mid] <= target && target <= nums[end]) {
        return searchHelper(nums, target, mid, end);
      } else {
        return searchHelper(nums, target, start, mid);
      }
    }
  }
}
