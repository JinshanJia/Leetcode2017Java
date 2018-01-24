/**
 * 145. Binary Tree Postorder Traversal
 * Given a binary tree, return the postorder traversal of its nodes' values.
 * For example:
 * Given binary tree {1,#,2,3},
 *
 * 1
 *  \
 *   2
 *  /
 * 3
 *
 * return [3,2,1].
 *
 * Note: Recursive solution is trivial, could you do it iteratively?
 *
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

class BinaryTreePostorderTraversal145 {
  public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> result = new LinkedList<Integer>();
    if (root == null) {
      return result;
    }
    Stack<TreeNode> stack = new Stack<TreeNode>();
    TreeNode previousNode = null;
    stack.push(root);
    while (!stack.empty()) {
      TreeNode currentNode = stack.peek();
      // traverse down the tree
      if (previousNode == null 
          || previousNode.left == currentNode 
          || previousNode.right == currentNode) {
        if (currentNode.left != null) {
          stack.push(currentNode.left);
        } else if (currentNode.right != null) {
          stack.push(currentNode.right);
        }
      } else if (currentNode.left == previousNode) { // traverse up from left
        if (currentNode.right != null) {
          stack.push(currentNode.right);
        }
      } else { // traverse up from right
        stack.pop();
        result.add(currentNode.val);
      }
      previousNode = currentNode;
    }
    return result;
  }
}
