import java.util.*;
import java.io.*;

public class Maze {
  private char[][] maze;
  private boolean animate = false; //by default
  private int rows = 0;
  private int cols;

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

  public boolean isValidMaze() {
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
}
