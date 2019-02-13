public class KnightBoard {
  private int[][] board;
  private int rows;
  private int cols;

  public KnightBoard(int startingRows, int startingCols) {
    rows = startingRows;
    cols = startingCols;
    board = new int[rows][cols];
  }
}
