/**
 * 34. Search for a Range
 * Given an array of integers sorted in ascending order, find the starting and
 * ending position of a given target value.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * If the target is not found in the array, return [-1, -1].
 *
 * For example,
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3, 4].
 */
public class SearchforARange {
  public int[] searchRange(int[] nums, int target) {
    int[] result = {-1, -1};
    if (nums == null || nums.length == 0) {
      return result;
    }
    result[0] = findFirstOrLast(nums, target, true);
    result[1] = findFirstOrLast(nums, target, false);
    return result;
  }

  private int findFirstOrLast(int[] nums, int target, boolean findFirst) {
    int start = 0;
    int end = nums.length - 1;
    while (start + 1 < end) {
      int mid = start + (end - start) / 2;
      if (findFirst) {
        if (nums[mid] >= target) {
          end = mid;
        } else {
          start = mid;
        }
      } else {
        if (nums[mid] > target) {
          end = mid;
        } else {
          start = mid;
        }
      }

    }

    if (findFirst) {
      if (nums[start] == target) {
        return start;
      } else if (nums[end] == target) {
        return end;
      }
    } else {
      if (nums[end] == target) {
        return end;
      } else if (nums[start] == target) {
        return start;
      }
    }

    return -1;
  }
}
