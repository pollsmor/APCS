public class QueenBoard {
  private int[][] board;

  public QueenBoard(int size) {
    board = new int[size][size];
  }

  public boolean addQueen(int r, int c) {
    if (board[r][c] != -1) {
      //Left to right
      for (int i = 0; i < board[r].length; ++i)
        ++board[r][i];

      //Top to bottom
      for (int j = 0; j < board.length; ++j)
        ++board[j][c];

      //Top left to bottom right
      for (int k = 0; k < board.length; ++k) //board.length still works since the diagonal length is also the length/width
          ++board[k][k];


      //Top right to bottom left
      //for (int m = board.length - 1; m >= 0; --m) {
        //++board[m][m];
      //}

      //Set this at the end after all the threatening is done
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
}
