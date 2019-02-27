import java.util.*;
import java.io.*;

public class Maze {
  private char[][] maze;
  private int rows;
  private int cols;

  public Maze(char[][] inputMaze) {
    maze = inputMaze;
    rows = maze.length;
    cols = maze[0].length;
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
