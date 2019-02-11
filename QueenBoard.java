public class QueenBoard {
  private int[][] board;

  public QueenBoard(int size) {
    board = new int[size][size];
  }

  private boolean addQueen(int r, int c) {
    if (board[r][c] == 0) {
      for (int i = 1; i <= board.length - r; ++i) {
        if (r - i >= 0 && c + i < board.length) //top right
          ++board[r - i][c + i];

        if (c + i < board.length) //right
          ++board[r][c + i];

        if (r + i < board.length && c + i < board.length) //bottom right
          ++board[r + i][c + i];

        if (r + i < board.length) //bottom
          ++board[r + i][c];

        if (r - i >= 0) //top
          ++board[r - i][c];

        if (r - i >= 0 && c - i >= 0) //top left
          ++board[r - i][c - i];

        if (c - i >= 0) //left
          ++board[r][c - i];

        if (r + i < board.length && c - i >= 0) //bottom left
          ++board[r + i][c - i];
      }

      board[r][c] = -1;
      return true;
    }

    return false;
  }

  private boolean removeQueen(int r, int c) {
    if (board[r][c] == -1) {
      for (int i = 1; i <= board.length - r; ++i) {
        if (r - i >= 0 && c + i < board.length) //top right
          --board[r - i][c + i];

        if (c + i < board.length) //right
          --board[r][c + i];

        if (r + i < board.length && c + i < board.length) //bottom right
          --board[r + i][c + i];

        if (r + i < board.length) //bottom
          --board[r + i][c];

        if (r - i >= 0) //top
          --board[r - i][c];

        if (r - i >= 0 && c - i >= 0) //top left
          --board[r - i][c - i];

        if (c - i >= 0) //left
          --board[r][c - i];

        if (r + i < board.length && c - i >= 0) //bottom left
          --board[r + i][c - i];
      }

      board[r][c] = 0;
      return true;
    }

    return false;
  }

  public String toString() {
    String output = "";
    for (int i = 0; i < board.length; ++i) {
      for (int j = 0; j < board[i].length; ++j) {
        if (board[i][j] == -1)
          output += "Q ";

        else
          output += "_ ";
      }

      output += '\n';
    }

    return output;
  }

  public boolean solve() {
    if (!isEmpty())
      throw new IllegalStateException("The board must start with all zeros.");

    return solveRec(0);
  }

  private boolean isEmpty() {
    for (int i = 0; i < board.length; ++i)
      for (int j = 0; j < board.length; ++j)
        if (board[i][j] != 0)
          return false;

    return true;
  }

  private void clearBoard() {
    for (int i = 0; i < board.length; ++i)
      for (int j = 0; j < board.length; ++j)
        board[i][j] = 0;
  }

  public boolean solveRec(int col) {
    if (col >= board.length)
      return true;

    for (int row = 0; row < board.length; ++row) {
      if (addQueen(row, col)) {
        if (solveRec(col + 1))
          return true;

        removeQueen(row, col);
      }
    }

    return false;
  }

  public int countSolutions() {
    if (board.length == 2 || board.length == 3)
      return 0;

    if (!isEmpty())
      throw new IllegalStateException("The board must start with all zeros.");

    return 1;
  }
}
