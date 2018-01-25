/**
 * 114. Flatten Binary Tree to Linked List
 *
 * Given a binary tree, flatten it to a linked list in-place.
 *
 * For example,
 * Given
 *
 *        1
 *       / \
 *      2   5
 *     / \   \
 *    3   4   6
 * The flattened tree should look like:
 *  1
 *   \
 *    2
 *     \
 *      3
 *       \
 *        4
 *         \
 *          5
 *           \
 *            6
 */

class FlattenBinaryTreeToLinkedList {
  public void flatten(TreeNode root) {
    helper(root);
  }

  private static TreeNode helper(TreeNode root) {
    if (root == null) {
      return null;
    }
    if (root.left == null && root.right == null) {
      return root;
    }
    TreeNode leftTail = helper(root.left);
    TreeNode rightTail = helper(root.right);
    TreeNode leftHead = root.left;
    TreeNode rightHead = root.right;
    root.left = null;
    if (leftHead != null) {
      root.right = leftHead;
      leftTail.right = rightHead;
    }
    return rightTail == null ? leftTail : rightTail;
  }
}
