
/**
 * 94. Binary Tree Inorder Traversal
 * 
 * Given a binary tree, return the inorder traversal of its nodes' values.
 *
 * For example:
 * Given binary tree [1,null,2,3],
 * 1
 *  \
 *   2
 *  /
 * 3
 *
 * return [1, 3, 2]
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
class BinaryTreeInorderTraversal94 {
  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> result = new LinkedList<Integer>();
    Stack<TreeNode> stack = new Stack<TreeNode>();
    TreeNode currentNode = root;
    while (currentNode != null || !stack.empty()) {
      while (currentNode != null) {
        stack.push(currentNode);
        currentNode = currentNode.left;
      }
      currentNode = stack.pop();
      result.add(currentNode.val);
      currentNode = currentNode.right;
    }
    return result;
  }
}
