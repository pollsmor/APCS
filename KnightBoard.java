public class KnightBoard {
  private int[][] board;
  private int m_rows;
  private int m_cols;
  private int m_row;
  private int m_col;

  public KnightBoard(int rows, int cols) {
    if (rows <= 0 || cols <= 0)
      throw new IllegalArgumentException("It's not a board if it has <= 0 rows or cols.");

    m_rows = rows;
    m_cols = cols;
    board = new int[m_rows][m_cols];
  }

  public String toString() {
    String output = "";

    if (m_rows * m_cols < 10) {
      for (int i = 0; i < m_rows; ++i) {
        for (int j = 0; j < m_cols; ++j)
          output += " " + board[i][j] + " ";

        output += '\n';
      }
    }

    else {
      for (int i = 0; i < m_rows; ++i) {
        for (int j = 0; j < m_cols; ++j) {
          if (board[i][j] < 10)
            output += " " + board[i][j] + " ";


          else
            output += board[i][j] + " ";
        }

        output += '\n';
      }
    }

    return output;
  }

  private boolean isEmpty() {
    for (int i = 0; i < m_rows; ++i)
      for (int j = 0; j < m_cols; ++j)
        if (board[i][j] != 0)
          return false;

    return true;
  }

  public boolean solve(int startingRow, int startingCol) {
    if (!isEmpty())
      throw new IllegalStateException("The board must be empty before you're allowed to do this.");

    if (startingRow < 0 || startingRow >= m_rows || startingCol < 0 || startingCol >= m_cols)
      throw new IllegalArgumentException("You can't start out of bounds.");

    return solveH(startingRow, startingCol, 1);
  }

  private boolean solveH(int row, int col, int moveNumber) {
    if (row < 0 || row >= m_rows || col < 0 || col >= m_cols)
      return false;

    if (board[row][col] != 0)
      return false;

    if (moveNumber >= m_rows * m_cols)
      return true;

    board[row][col] = moveNumber;

    int[][] moves = { {1, 2}, {1, -2}, {-1, 2}, {-1, -2}, {2, 1}, {2, -1}, {-2, 1}, {-2, -1} };

    for (int i = 0; i < 8; ++i)
      if (solveH(row + moves[i][0], col + moves[i][1], moveNumber + 1))
        return true;

      board[row][col] = 0;

    return false;
  }
}
