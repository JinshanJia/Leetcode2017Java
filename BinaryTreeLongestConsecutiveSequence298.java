/**
 * 298. Binary Tree Longest Consecutive Sequence
 * Given a binary tree, find the length of the longest consecutive sequence 
 * path.
 *
 * The path refers to any sequence of nodes from some starting node to any node
 * in the tree along the parent-child connections. The longest consecutive path 
 * need to be from parent to child (cannot be the reverse).
 *
 * For example,
 *
 *
 *   1
 *     \
 *       3
 *      / \
 *     2   4
 *          \
 *           5
 * Longest consecutive sequence path is 3-4-5, so return 3.
 *
 *    2
 *      \
 *        3
 *       / 
 *      2    
 *     / 
 *   1
 * Longest consecutive sequence path is 2-3,not3-2-1, so return 2.
 */

class BinaryTreeLongestConsecutiveSequence298 {
  private static class ResultType {
    // Should use auto value
    int lengthWithCurrentNode = 0;
    int maxLength = 0;
    ResultType(int lengthWithCurrentNode, int maxLength) {
      this.lengthWithCurrentNode = lengthWithCurrentNode;
      this.maxLength = maxLength;  
    }
  }
  public int longestConsecutive(TreeNode root) {
    return helper(root).maxLength;
  }

  private ResultType helper(TreeNode root) {
    if (root == null) {
      return new ResultType(0, 0);
    }
    ResultType leftResult = helper(root.left);
    ResultType rightResult = helper(root.right);
    int leftResultWithCurrentNode = 
        root.left != null && root.val == root.left.val - 1 ?
            leftResult.lengthWithCurrentNode + 1 : 1;
    int rightResultWithCurrentNode =
        root.right != null && root.val == root.right.val - 1 ?
            rightResult.lengthWithCurrentNode + 1 : 1;
    int resultWithCurrentNode = 
        Math.max(leftResultWithCurrentNode, rightResultWithCurrentNode);
    int maxLengthOfChildren = 
        Math.max(leftResult.maxLength, rightResult.maxLength);

    int maxLength =
        Math.max(maxLengthOfChildren, resultWithCurrentNode);
    return new ResultType(resultWithCurrentNode, maxLength);
  }
}
