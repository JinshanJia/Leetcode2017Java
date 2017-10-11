/**
 *  34. Search for a Range
 *
 *  Given an array of integers sorted in ascending order, find the starting and
 *  ending position of a given target value.
 *
 *  Your algorithm's runtime complexity must be in the order of O(log n).
 *
 *  If the target is not found in the array, return [-1, -1].
 *
 *  For example,
 *  Given [5, 7, 7, 8, 8, 10] and target value 8,
 *  return [3, 4].
 */

public class SearchForARange34 {
  public int[] searchRange(int[] nums, int target) { 
    int[] result = {-1, -1};
    if (nums == null || nums.length == 0) {
      return result;
    }

    int left, right = 0;

    // Find left
    int start = 0;
    int end = nums.length - 1;
    while (start + 1 < end) {
      int mid = start + (end - start) / 2;
      if (nums[mid] < target) {
        start = mid;
      } else {
        end = mid;
      }
    }

    if (nums[start] == target) {
      left = start;
    } else if (nums[end] == target) {
      left = end;
    } else {
      return result;
    }

    // Find right;
    start = 0;
    end = nums.length - 1;
    while (start + 1 < end) {
      int mid = start + (end - start) / 2;
      if (nums[mid] > target) {
        end = mid;
      } else {
        start = mid;
      }
    }

    if (nums[end] == target) {
      right = end;
    } else if (nums[start] == target) {
      right = start;
    } else {
      return result;
    }
    result[0] = left;
    result[1] = right;
    return result;
  }
}
