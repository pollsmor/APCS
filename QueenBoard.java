public class QueenBoard {
  private int[][] board;

  public QueenBoard(int size) {
    board = new int[size][size];
  }

  public boolean addQueen(int r, int c) {
    if (board[r][c] != -1) {
      for (int i = 1; i <= board.length - r; ++i) {
        if (r != 0) //top right
          ++board[r - i][c + i];

        if (c + i < board.length) //right
          ++board[r][c + i];

        if (r + i < board.length && c + i < board.length) //bottom right
          ++board[r + i][c + i];

        if (r + i < board.length) //bottom
          ++board[r + i][c];

        if (r != 0) //top
          ++board[r - i][c];

        if (r - i >= 0 && c - i >= 0)
          ++board[r - i][c - i];
      }

      board[r][c] = -1;
      return true;
    }

    return false;
  }

  public boolean removeQueen(int r, int c) {
    if (board[r][c] == -1) {
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
          output += board[i][j] + " ";
      }

      output += '\n';
    }

    return output;
  }

  public int countSolutions() {
    int queensOnBoard = 0;
    for (int i = 0; i < board.length; ++i)
      for (int j = 0; j < board.length; ++j)
        if (board[i][j] == - 1)
          ++queensOnBoard;

    if (queensOnBoard == board.length)
      return 1;

    return 0;
  }
}
