import java.util.*;
import java.io.*;

public class Maze {
  private char[][] maze;
  private boolean animate = false; //by default
  private int rows;
  private int cols;

  public Maze(String fileName) throws FileNotFoundException {
    File f = new File(fileName);

    //cols in maze
    Scanner colsChecker = new Scanner(text);
    int cols = colsChecker.nextLine().length(); //length of one line, which is cols

    //rows in maze
    Scanner inf2 = new Scanner(text);
    int rows = 0; //count the amount of lines
    while (inf2.hasNextLine()) {
      ++rows;
      inf2.nextLine();
    }

    //Read everything into char array
    Scanner inf3 = new Scanner(text);
    char[][] mazeEls = new char[rows][cols];
    for (int i = 0; i < rows; ++i) {
      String line = inf3.nextLine();
      for (int j = 0; j < cols; ++j) {
        mazeEls[i][j] = line.charAt(j);
      }

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
