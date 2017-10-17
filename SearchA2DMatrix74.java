/**
 * 74. Search a 2D Matrix
 *
 * Write an efficient algorithm that searches for a value in an m x n 
 * matrix.
 *
 * This matrix has the following properties:
 *
 * - Integers in each row are sorted from left to right.
 * - The first integer of each row is greater than the last integer of the 
 * previous row.
 *
 * Example
 * Consider the following matrix:
 *
 * [
 *   [1, 3, 5, 7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * Given target = 3, return true.
 */

class SearchA2DMatrix74 {
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
      int mid = start + (end -start) / 2;
      int row = getRowIndexFromIndex(mid, matrix[0].length);
      int column = getColumnIndexFromIndex(mid, matrix[0].length);
      if (matrix[row][column] == target) {
        return true;
      } else if (matrix[row][column] > target) {
        end = mid;
      } else {
        start = mid;
      }
    }

    return getNumberFromIndex(start, matrix) == target
      || getNumberFromIndex(end, matrix) == target;
  }

  private int getNumberFromIndex(int index, int[][] matrix) {
    return matrix[getRowIndexFromIndex(index, matrix[0].length)]
      [getColumnIndexFromIndex(index, matrix[0].length)];
  }

  private int getRowIndexFromIndex(int index, int totalColumn) {
    return index / totalColumn;
  }
  
  private int getColumnIndexFromIndex(int index, int totalColumn) {
    return index % totalColumn;
  }
}

