/**
 * 167. Two Sum II - Input array is sorted
 *
 * Given an array of integers that is already sorted in ascending order, find
 * two numbers such that they add up to a specific target number.
 *
 * The function twoSum should return indices of the two numbers such that they
 * add up to the target, where index1 must be less than index2. Please note that
 * your returned answers (both index1 and index2) are not zero-based.
 *
 * You may assume that each input would have exactly one solution and you may
 * not use the same element twice.
 *
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 */
public class TwoSumIIInputarrayissorted {
  public int[] twoSum(int[] numbers, int target) {
    int[] result = new int[2];
    int left = 0;
    int right = numbers.length - 1;
    while (left < right) {
      long sum = (long) numbers[left] + numbers[right];
      if (sum == target) {
        result[0] = left + 1;
        result[1] = right + 1;
        break;
      } else if (sum > target) {
        right--;
      } else {
        left++;
      }
    }
    return result;
  }

  // Slower, binary search.
  public int[] twoSum2(int[] numbers, int target) {
    int[] result = new int[2];
    for (int i = 0; i < numbers.length - 1; i++) {
      long currentTarget = (long) target - (long) numbers[i];
      if (currentTarget > Integer.MAX_VALUE || currentTarget < Integer.MIN_VALUE) {
        continue;
      }
      int start = i + 1;
      int end = numbers.length - 1;
      while (start + 1 < end) {
        int mid = start + (end - start) / 2;
        if (numbers[mid] == currentTarget) {
          result[0] = i + 1;
          result[1] = mid + 1;
          return result;
        } else if (numbers[mid] < currentTarget) {
          start = mid;
        } else {
          end = mid;
        }
      }
      if (numbers[start] == currentTarget) {
        result[0] = i + 1;
        result[1] = start + 1;
        return result;
      }
      if (numbers[end] == currentTarget) {
        result[0] = i + 1;
        result[1] = end + 1;
        return result;
      }
    }
    return result;
  }
}
