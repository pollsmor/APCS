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
