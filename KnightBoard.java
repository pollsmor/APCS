import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class KnightBoard {
  private int[][] board;
  private int m_rows;
  private int m_cols;
  private int[][] outgoingMoves; //for optimization

  public KnightBoard(int rows, int cols) {
    if (rows <= 0 || cols <= 0)
      throw new IllegalArgumentException("It's not a board if it has <= 0 rows or cols.");

    m_rows = rows;
    m_cols = cols;
    board = new int[m_rows][m_cols]; //sets everything to a value of 0

    outgoingMoves = new int[m_rows][m_cols];
    genMoves(); //fill in moves board
  }

  //Generates an array that shows how many outgoing moves there are.
  private void genMoves() {
    for (int row = 0; row < m_rows; ++row) {
      for (int col = 0; col < m_cols; ++col) {
        //8 is for anything > 2 blocks from the edge
        if (row - 2 >= 0 && row + 2 < m_rows && col - 2 >= 0 && col + 2 < m_cols)
          outgoingMoves[row][col] = 8;

        //2 is for the four corners of the board
        else if ((row == 0 && col == 0) || (row == 0 && col == m_cols - 1) || (row == m_rows - 1 && col == 0) || (row == m_rows - 1 && col == m_cols - 1))
          outgoingMoves[row][col] = 2;

        //3 is for the 8 blocks surrounding the 2s
        else if ((row == 1 && col == 0) || (row == 1 && col == m_cols - 1) || (row == m_rows - 2 && col == 0) || (row == m_rows - 2 && col == m_cols - 1) ||
                 (col == 1 && row == 0) || (col == m_cols - 2 && row == 0) || (col == 1 && row == m_rows - 1) || (col == m_cols - 2 && row == m_rows - 1))
          outgoingMoves[row][col] = 3;

        //6 surrounds the 8s
        else if ((row == 1 || row == m_rows - 2) && (col - 2 >= 0 && col + 2 < m_cols))
          outgoingMoves[row][col] = 6;

        else if ((col == 1 || col == m_rows - 2) && (row - 2 >= 0 && row + 2 < m_rows))
          outgoingMoves[row][col] = 6;

        //Couldn't think of an algorithm for 4, leave it for last
        else
          outgoingMoves[row][col] = 4;
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

  public String toStringMoves() { //for debugging
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

    if (!returnVal)
      clearBoard(); //since no solution was found

    return returnVal; //return stuff after changeLast();
  }

  private boolean solveH(int row, int col, int moveNumber) {
    if (board[row][col] != 0) //if a move backtracks, it's not possible
      return false;

    if (moveNumber >= m_rows * m_cols) //Every moveNumber has been reached, done
      return true;

    //This branch won't work since the is invalid
    if (outgoingMoves[row][col] <= 0)
      return false;

    --outgoingMoves[row][col];

    board[row][col] = moveNumber;

    //Make list of possible moves along with how many outgoing moves there are, for optimization
    ArrayList<int[]> moves = new ArrayList<int[]>();
    if (row + 1 < m_rows && col + 2 < m_cols) {
      int[] arr = {1, 2, outgoingMoves[row + 1][col + 2]};
      moves.add(arr);
    }

    if (row + 1 < m_rows && col - 2 >= 0) {
      int[] arr = {1, -2, outgoingMoves[row + 1][col - 2]};
      moves.add(arr);
    }

    if (row - 1 >= 0 && col + 2 < m_cols) {
      int[] arr = {-1, 2, outgoingMoves[row - 1][col + 2]};
      moves.add(arr);
    }

    if (row - 1 >= 0 && col - 2 >= 0) {
      int[] arr = {-1, -2, outgoingMoves[row - 1][col - 2]};
      moves.add(arr);
    }

    if (row + 2 < m_rows && col + 1 < m_cols) {
      int[] arr = {2, 1, outgoingMoves[row + 2][col + 1]};
      moves.add(arr);
    }

    if (row + 2 < m_rows && col - 1 >= 0) {
      int[] arr = {2, -1, outgoingMoves[row + 2][col - 1]};
      moves.add(arr);
    }

    if (row - 2 >= 0 && col + 1 < m_cols) {
      int[] arr = {-2, 1, outgoingMoves[row - 2][col + 1]};
      moves.add(arr);
    }

    if (row - 2 >= 0 && col - 1 >= 0) {
      int[] arr = {-2, -1, outgoingMoves[row - 2][col - 1]};
      moves.add(arr);
    }

    //I had no clue how to do the sorting by amount of outgoing moves by myself. This StackOverflow post helped a good deal: https://stackoverflow.com/questions/9150446/compareto-with-primitives-integer-int
    Collections.sort(moves, new Comparator<int[]>() {
      public int compare(int[] a, int[] b) {
        if (a[2] > b[2])
          return 1;

        return -1;
      }
    });

    for (int i = 0; i < moves.size(); ++i) {
      if (solveH(row + moves.get(i)[0], col + moves.get(i)[1], moveNumber + 1))
        return true;
    }

    board[row][col] = 0; //remove knight and try a new location because the entire 8 directions were tried in the for loop and didn't work

    ++outgoingMoves[row][col]; //add the move back since the solution can't be found on this path
    return false; //no solution on this path
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
