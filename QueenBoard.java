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

  //Same as addQueens but backwards
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

  //Wrapper functuion for solveRec
  public boolean solve() {
    if (board[0][0] != 0)
      throw new IllegalStateException("The board must start with all zeros.");

    if (board.length == 2 || board.length == 3)
      return false;

    return solveRec(0);
  }

  private void clearBoard() {
    for (int i = 0; i < board.length; ++i)
      for (int j = 0; j < board.length; ++j)
        board[i][j] = 0;
  }

  public boolean solveRec(int col) {
    //If it reaches the amt. of columns, then there is n amount of queens on the board
    if (col >= board.length)
      return true;

    for (int row = 0; row < board.length; ++row) {
      if (addQueen(row, col)) {
        if (solveRec(col + 1))
          return true;

        removeQueen(row, col); //won't find a solution with previous col + 1, so discard queen at col + 1
      }
    }

    return false; //for the n-queens problem you must have a queen on every column.
                  //if the for loop gets exhausted before returning true it is unsolvable in its current state.
  }

  public int countSolutions() {
    clearBoard();
    
    if (board[0][0] != 0)
      throw new IllegalStateException("The board must start with all zeros.");

    if (board.length == 0 || board.length == 2 || board.length == 3)
      return 0;

    int solutions = cSolutionsRec(0);
    clearBoard();
    return solutions;
  }

  public int cSolutionsRec(int col) {
    //Like solveRec
    if (col >= board.length)
      return 1;

    int count = 0;
    for (int row = 0; row < board.length; ++row) {
      if (addQueen(row, col)) {
        count += cSolutionsRec(col + 1);
        removeQueen(row, col);
      }
    }

    return count;
  }
}
