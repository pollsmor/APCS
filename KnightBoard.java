public class KnightBoard {
  private int[][] board;
  private int rows;
  private int cols;

  public KnightBoard(int startingRows, int startingCols) {
    if (startingRows <= 0 || startingCols <= 0)
      throw new IllegalArgumentException("It's not a board if it has <= 0 rows or cols.");

    rows = startingRows;
    cols = startingCols;
    board = new int[rows][cols];
  }
}
