/**
 * 257. Binary Tree Paths
 *
 * Given a binary tree, return all root-to-leaf paths.
 *
 * For example, given the following binary tree:
 *
 *       1
 *     /   \
 *    2     3
 *      \
 *        5
 * All root-to-leaf paths are:
 *
 * ["1->2->5", "1->3"]
 */

class BinaryTreePaths257 {
  public List<String> binaryTreePaths(TreeNode root) {
    List<String> result = new LinkedList<String>();
    if (root == null) {
      return result;
    }
    if (root.left == null && root.right == null) {
      result.add(String.valueOf(root.val));
      return result;
    }
    List<String> leftResult = binaryTreePaths(root.left);
    List<String> rightResult = binaryTreePaths(root.right);
    return Stream.concat(leftResult.stream(), rightResult.stream())
        .map(s -> root.val + "->" + s).collect(Collectors.toList());
  }
}
