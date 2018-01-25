/**
 * 110. Balanced Binary Tree
 *
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as a binary tree 
 * in which the depth of the two subtrees of every node never differ by more 
 * than 1.
 */

class BalancedBinaryTree110 {
  public boolean isBalanced(TreeNode root) {
    return helper(root).isBalanced;
  }

  private static BalanceResult helper(TreeNode root) {
    if (root == null) {
      return new BalanceResult(true, 0);
    }
    BalanceResult leftResult = helper(root.left);
    BalanceResult rightResult = helper(root.right);
    if (!leftResult.isBalanced || !rightResult.isBalanced 
        || Math.abs(leftResult.depth - rightResult.depth) > 1) {
      return new BalanceResult(false, -1);
    } else {
      return new BalanceResult(
          true, Math.max(leftResult.depth, rightResult.depth) + 1);
    }
  }

  private static class BalanceResult {
    final boolean isBalanced;
    final int depth;
    BalanceResult(boolean isBalanced, int depth) {
      this.isBalanced = isBalanced;
      this.depth = depth;
    }
  }
}
