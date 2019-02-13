public class KnightBoard {
  private int[][] board;
  private int rows;
  private int cols;
  private int row;
  private int col;

  public KnightBoard(int startingRows, int startingCols) {
    if (startingRows <= 0 || startingCols <= 0)
      throw new IllegalArgumentException("It's not a board if it has <= 0 rows or cols.");

    rows = startingRows;
    cols = startingCols;
    board = new int[rows][cols];
  }

  public String toString() {
    if (board[0][0] != 0)
      throw new IllegalStateException("The board must be empty before you're allowed to do this.");

    String output = "";

  }
}
