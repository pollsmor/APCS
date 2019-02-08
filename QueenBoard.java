public class QueenBoard {
  private int[][] board;

  public QueenBoard(int size) {
    board = new int[size][size];
  }

  private boolean addQueen(int r, int c) {
    if (board[r][c] != -1) {
      board[r][c] = -1;
      return true;
    }

    return false;
  }

  private boolean removeQueen(int r, int c) {
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
          output += "_ ";
      }

      output += '\n';
    }

    return output;
  }
}
