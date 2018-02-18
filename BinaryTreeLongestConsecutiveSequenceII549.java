/**
 * 549. Binary Tree Longest Consecutive Sequence II
 * Given a binary tree, you need to find the length of Longest Consecutive 
 * Path in Binary Tree.
 *
 * Especially, this path can be either increasing or decreasing. For example, 
 * [1,2,3,4] and [4,3,2,1] are both considered valid, but the path [1,2,4,3] is
 * not valid. On the other hand, the path can be in the child-Parent-child 
 * order, where not necessarily be parent-child order.
 *
 * Example 1:
 *
 * Input:
 *       1
 *      / \
 *     2   3
 * Output: 2
 * Explanation: The longest consecutive path is [1, 2] or [2, 1].
 *
 * Example 2:
 *
 * Input:
 *       2
 *      / \
 *     1   3
 * Output: 3
 * Explanation: The longest consecutive path is [1, 2, 3] or [3, 2, 1]. 
 *
 * Note: All the values of tree nodes are in the range of [-1e7, 1e7].
 * 
 */
class BinaryTreeLongestConsecutiveSequenceII549 {
  private static class ResultType {
    int maxLength;
    int maxLengthWithCurrentNodeSmallest;
    int maxLengthWithCurrentNodeBiggest;

    ResultType(int maxLength, 
        int maxLengthWithCurrentNodeSmallest,
        int maxLengthWithCurrentNodeBiggest) {
      this.maxLength = maxLength;
      this.maxLengthWithCurrentNodeSmallest = maxLengthWithCurrentNodeSmallest;
      this.maxLengthWithCurrentNodeBiggest = maxLengthWithCurrentNodeBiggest;
    }
  }

  public int longestConsecutive(TreeNode root) {
    return helper(root).maxLength;
  }

  private static ResultType helper(TreeNode root) {
    if (root == null) {
      return new ResultType(0, 0, 0);
    }
    
    ResultType leftResult = helper(root.left);
    ResultType rightResult = helper(root.right);

    // Check result with current node smallest
    int maxLengthWithCurrentNodeSmallestWithLeftChild =
        root.left != null && root.left.val == root.val + 1 ?
        leftResult.maxLengthWithCurrentNodeSmallest + 1 : 1;
    int maxLengthWithCurrentNodeSmallestWithRightChild =
        root.right != null && root.right.val == root.val + 1 ?
        rightResult.maxLengthWithCurrentNodeSmallest + 1 : 1;

    int maxLengthWithCurrentNodeBiggestWithLeftChild =
        root.left != null && root.left.val == root.val - 1 ?
        leftResult.maxLengthWithCurrentNodeBiggest + 1 : 1;
    int maxLengthWithCurrentNodeBiggestWithRightChild =
        root.right != null && root.right.val == root.val - 1 ?
        rightResult.maxLengthWithCurrentNodeBiggest + 1 : 1;

    int maxLength = Math.max(Math.max(
        maxLengthWithCurrentNodeSmallestWithLeftChild
        + maxLengthWithCurrentNodeBiggestWithRightChild - 1, 
        maxLengthWithCurrentNodeSmallestWithRightChild
        + maxLengthWithCurrentNodeBiggestWithLeftChild - 1),
        Math.max(leftResult.maxLength, rightResult.maxLength));

    return new ResultType(
        maxLength,
        Math.max(maxLengthWithCurrentNodeSmallestWithLeftChild,
            maxLengthWithCurrentNodeSmallestWithRightChild),
        Math.max(maxLengthWithCurrentNodeBiggestWithLeftChild,
            maxLengthWithCurrentNodeBiggestWithRightChild));
  }
}
