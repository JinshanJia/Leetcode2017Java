/**
 * 102. Binary Tree Level Order Traversal
 * 
 * Given a binary tree, return the level order traversal of its nodes' values. 
 * (ie, from left to right, level by level).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *   3
 *  / \
 * 9  20
 *   /  \
 *  15   7
 *
 * return its level order traversal as:
 * [
 *  [3],
 *  [9,20],
 *  [15,7]
 * ]
 */
class BinaryTreeLevelOrderTraversal102 {
  /**
   * Definition for a binary tree node.
   * public class TreeNode {
   *     int val;
   *     TreeNode left;
   *     TreeNode right;
   *     TreeNode(int x) { val = x; }
   * }
   */
  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    Queue<TreeNode> toBeIterated = new LinkedList<>();
    toBeIterated.add(root);
    while(!toBeIterated.isEmpty()) {
      List<Integer> currentLevelResult = new ArrayList<>();
      Queue<TreeNode> currentLevelNodes = toBeIterated;
      toBeIterated = new LinkedList<>();
      while(!currentLevelNodes.isEmpty()) {
        TreeNode currentNode = currentLevelNodes.poll();
        currentLevelResult.add(currentNode.val);
        if (currentNode.left != null) {
          toBeIterated.add(currentNode.left);
        }
        if (currentNode.right != null) {
          toBeIterated.add(currentNode.right);
        }
      }
      result.add(currentLevelResult);
    }
    return result;
  }


  public List<List<Integer>> levelOrderWithDummyNode(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    Queue<TreeNode> toBeIterated = new LinkedList<>();
    List<Integer> currentLevelResult = new ArrayList<>();
    toBeIterated.add(root);
    // Dummy node, to indicate the end of the level.
    toBeIterated.add(null);
    while (!toBeIterated.isEmpty()) {
      TreeNode currentNode = toBeIterated.poll();
      if (currentNode == null) {  // reached end of current level;
        if (currentLevelResult.isEmpty()) {
          break;
        }
        result.add(currentLevelResult);
        currentLevelResult = new ArrayList<>();
        // All next level nodes added, add dummy node.
        toBeIterated.add(null);
      } else {
        currentLevelResult.add(currentNode.val);
        if (currentNode.left != null) {
          toBeIterated.add(currentNode.left);
        }
        if (currentNode.right != null) {
          toBeIterated.add(currentNode.right);
        }
      }
    }
    return result;
  }
}