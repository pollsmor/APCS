import java.util.*;
import java.io.*;

public class Maze {
  private char[][] maze;
  private boolean animate = false; //by default
  private int rows = 0;
  private int cols;
  private int[][] moves = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

  public Maze(String fileName) throws FileNotFoundException {
    File f = new File(fileName);

    //rows in maze
    Scanner rowsChecker = new Scanner(f);
    while (rowsChecker.hasNextLine()) { //count the amount of lines
      ++rows;
      rowsChecker.nextLine();
    }

    //cols in maze
    Scanner colsChecker = new Scanner(f);
    cols = colsChecker.nextLine().length(); //length of one line, which is cols

    //Read everything into char array
    Scanner inf = new Scanner(f);
    maze = new char[rows][cols];
    for (int i = 0; i < rows; ++i) {
      String line = inf.nextLine();
      for (int j = 0; j < cols; ++j) {
        maze[i][j] = line.charAt(j);
      }
    }

    if (!isValidMaze())
      throw new IllegalStateException("Invalid maze. There must only be one E and one S.");
  }

  private void wait(int millis) {
    try {
      Thread.sleep(millis);
    }

    catch (InterruptedException e) {

    }
  }

  public void setAnimate(boolean b) {
    animate = b;
  }

  public void clearTerminal() {
    //erase terminal, go to top left of screen
    System.out.println("\033[2J\033[1;1H");
  }

  private boolean isValidMaze() {
    int eCount = 0;
    int sCount = 0;
    for (int i = 0; i < rows; ++i) {
      for (int j = 0; j < cols; ++j) {
        if (maze[i][j] == 'E')
          ++eCount;

        if (maze[i][j] == 'S')
          ++sCount;
      }
    }

    return eCount == 1 && sCount == 1;
  }

  public String toString() {
    String output = "";

    for (int i = 0; i < rows; ++i) {
      for (int j = 0; j < cols; ++j)
        output += maze[i][j] + " ";

      output += '\n';
    }

    return output;
  }

  private int countAts() {
    int count = 0;
    for (int i = 0; i < rows; ++i) {
      for (int j = 0; j < cols; ++j) {
        if (maze[i][j] == '@')
          ++count;
      }
    }

    return count;
  }

  public int solve() {
    int sRow = 0;
    int sCol = 0;

    //Find S's row and column
    for (int i = 0; i < rows; ++i) {
      for (int j = 0; j < cols; ++j) {
        if (maze[i][j] == 'S') {
          sRow = i;
          sCol = j;
        }
      }
    }

    maze[sRow][sCol] = ' ';

    return solve(sRow, sCol);
  }

  private int solve(int row, int col) {
    if (animate) {
      clearTerminal();
      System.out.println(this);
      wait(20);
    }

    if (maze[row][col] == 'E')
      return countAts();

    if (maze[row][col] != ' ')
      return -1;

    maze[row][col] = '@';

    for (int i = 0; i < moves.length; ++i) {
      return solve(row + moves[i][0], col + moves[i][1]);
    }

    maze[row][col] = '.';

    return -1; //so it compiles
  }
}
