/**
 * 144. Binary Tree Preorder Traversal
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * For example:
 * Given binary tree [1,null,2,3],
 *
 * 1
 *  \
 *    2
 *  /
 * 3
 *
 * return [1,2,3].
 *
 * Note: Recursive solution is trivial, could you do it iteratively?
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class BinaryTreePreorderTraversal144 {
  public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> result = new LinkedList<Integer>();
    if (root == null) {
      return result;
    }
    Stack<TreeNode> stack = new Stack<TreeNode>();
    stack.push(root);
    while (!stack.empty()) {
      TreeNode currentNode = stack.pop();
      result.add(currentNode.val);
      if (currentNode.right != null) {
        stack.push(currentNode.right);
      }
      if (currentNode.left != null) {
        stack.push(currentNode.left);
      }
    }
    return result;
  }
}

