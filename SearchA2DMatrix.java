/**
 * 74. Search a 2D Matrix
 * Write an efficient algorithm that searches for a value in an m x n matrix. 
 * This matrix has the following properties:
 *
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the 
 * previous row. For example,
 *
 * Consider the following matrix:
 * [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * Given target = 3, return true.
 */

public class SearchA2DMatrix {
  public boolean searchMatrix(int[][] matrix, int target) {
    if (matrix == null 
      || matrix.length == 0 
      || matrix[0] == null 
      || matrix[0].length == 0) {
      return false;
    }
    
    int start = 0;
    int end = matrix.length * matrix[0].length - 1;
    while (start + 1 < end) {
      int mid = start + (end - start) / 2;
      int midElement = getElement(matrix, mid);
      if (midElement == target) {
        return true;
      } else if (midElement < target) {
        start = mid;
      } else {
        end = mid;
      }
    }
    
    if (getElement(matrix, start) == target) {
      return true;
    }
    if (getElement(matrix, end) == target) {
      return true;
    }
    return false;
  }
  
  private int getElement(int[][] matrix, int index) {
    return matrix[index / matrix[0].length][index % matrix[0].length];
  }
}