public class KnightBoard {
  private int[][] board;
  private int m_rows;
  private int m_cols;
  private int[][] outgoingMoves;

  public KnightBoard(int rows, int cols) {
    if (rows <= 0 || cols <= 0)
      throw new IllegalArgumentException("It's not a board if it has <= 0 rows or cols.");

    m_rows = rows;
    m_cols = cols;
    board = new int[m_rows][m_cols]; //sets everything to a value of 0

    outgoingMoves = new int[m_rows][m_cols];
    for (int row = 0; row < m_rows; ++row) {
      for (int col = 0; col < m_cols; ++col) {
        if (row - 2 >= 0 && row + 2 < m_rows && col - 2 >= 0 && col + 2 < m_cols)
          outgoingMoves[row][col] = 8;

        else if ((row == 0 && col == 0) || (row == 0 && col == m_cols - 1) || (row == m_rows - 1 && col == 0) || (row == m_rows - 1 && col == m_cols - 1))
          outgoingMoves[row][col] = 2;
      }
    }
  }

  public String toString() {
    String output = "";

    //Print a bunch of underscores if board is empty/unsolvable
    if (isEmpty()) {
      for (int i = 0; i < m_rows; ++i) {
        for (int j = 0; j < m_cols; ++j)
          output += "_ ";

        output += '\n';
      }

      return output;
    }

    //Prints in a suitable way for small boards
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

  public String toStringMoves() {
    String output = "";

    for (int i = 0; i < m_rows; ++i) {
      for (int j = 0; j < m_cols; ++j)
        output += outgoingMoves[i][j] + " ";

      output += '\n';
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

  //Changes last value to the correct value, used in solve
  private void changeLast() {
    for (int row = 0; row < m_rows; ++row)
      for (int col = 0; col < m_cols; ++col)
        if (board[row][col] == 0)
          board[row][col] = m_rows * m_cols;
  }

  public boolean solve(int startingRow, int startingCol) {
    if (!isEmpty())
      throw new IllegalStateException("The board must be empty before you're allowed to do this.");

    if (startingRow < 0 || startingRow >= m_rows || startingCol < 0 || startingCol >= m_cols)
      throw new IllegalArgumentException("You can't start out of bounds.");

    boolean returnVal = solveH(startingRow, startingCol, 1); //change stuff first
    changeLast();

    return returnVal; //return stuff after changeLast();
  }

  private boolean solveH(int row, int col, int moveNumber) {
    if (row < 0 || row >= m_rows || col < 0 || col >= m_cols) //if a move goes out of bounds, it's not possible
      return false;

    if (board[row][col] != 0) //if a move backtracks, it's not possible
      return false;

    if (moveNumber >= m_rows * m_cols) //Every moveNumber has been reached, done
      return true;

    board[row][col] = moveNumber;

    int[][] moves = { {1, 2}, {1, -2}, {-1, 2}, {-1, -2}, {2, 1}, {2, -1}, {-2, 1}, {-2, -1} };

    for (int i = 0; i < 8; ++i)
      if (solveH(row + moves[i][0], col + moves[i][1], moveNumber + 1))
        return true;

    board[row][col] = 0; //remove knight and try a new location because the entire 8 directions were tried in the for loop and didn't work

    return false;
  }

  private void clearBoard() {
    for (int i = 0; i < m_rows; ++i)
      for (int j = 0; j < m_cols; ++j)
        board[i][j] = 0;
  }

  public int countSolutions(int startingRow, int startingCol) {
    if (!isEmpty())
      throw new IllegalStateException("The board must be empty before you're allowed to do this.");

    if (startingRow < 0 || startingRow >= m_rows || startingCol < 0 || startingCol >= m_cols)
      throw new IllegalArgumentException("You can't start out of bounds.");

    int solutions = cSolutionsH(startingRow, startingCol, 1);
    clearBoard();
    return solutions;
  }

  private int cSolutionsH(int row, int col, int moveNumber) {
    if (row < 0 || row >= m_rows || col < 0 || col >= m_cols) //if a move goes out of bounds, it's not possible
      return 0;

    if (board[row][col] != 0) //if a move backtracks, it's not possible
      return 0;

    if (moveNumber >= m_rows * m_cols) //Every moveNumber has been reached, done
      return 1;

    board[row][col] = moveNumber;

    int[][] moves = { {1, 2}, {1, -2}, {-1, 2}, {-1, -2}, {2, 1}, {2, -1}, {-2, 1}, {-2, -1} };

    int count = 0;
    for (int i = 0; i < 8; ++i)
      count += cSolutionsH(row + moves[i][0], col + moves[i][1], moveNumber + 1);

    board[row][col] = 0; //remove knight and try a new location because the entire 8 directions were tried in the for loop and didn't work

    return count;
  }
}
