public class KnightBoard {
  private int[][] board;
  private int m_rows;
  private int m_cols;
  private int m_row;
  private int m_col;

  public KnightBoard(int rows, int cols) {
    if (startingRows <= 0 || startingCols <= 0)
      throw new IllegalArgumentException("It's not a board if it has <= 0 rows or cols.");

    m_rows = rows;
    m_cols = cols;
    board = new int[m_rows][m_cols];
  }

  public String toString() {
    if (board[0][0] != 0)
      throw new IllegalStateException("The board must be empty before you're allowed to do this.");

    if (m_row <= 0 || m_row >= m_rows || m_col <= 0 || m_col >= m_cols)
      throw new IllegalArgumentException("You can't go out of bounds.");

    String output = "";

    return output;
  }

  public boolean solve(int startingRow, )
}
