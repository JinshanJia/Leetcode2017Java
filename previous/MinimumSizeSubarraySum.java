/**
 * 209. Minimum Size Subarray Sum
 * Given an array of n positive integers and a positive integer s, find the
 * minimal length of a contiguous subarray of which the sum ≥ s. If there isn't
 * one, return 0 instead.
 *
 * For example, given the array [2,3,1,2,4,3] and s = 7,
 * the subarray [4,3] has the minimal length under the problem constraint.
 */
public class MinimumSizeSubarraySum {
  public int minSubArrayLen(int s, int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    if (nums.length == 1) {
      return nums[0] >= s ? 0 : 1;
    }
    int i = 0;
    int j = 1;
    int sum = nums[0];
    int result = 0;
    while (i < nums.length) {
      if (sum >= s) {
        result = result == 0 ? j - i : Math.min(result, j - i);
        sum -= nums[i];
        i++;
      } else if (j >= nums.length) {
        break;
      } else {
        sum += nums[j];
        j++;
      }
    }
    return result;
  }
}
