import java.io.*;
import java.util.*;

public class Driver {
  public static void main(String[] args) {
    try {
      File text = new File("Maze1.txt");

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
      }

      Maze maze = new Maze(mazeEls);
      System.out.println(maze);
    }

    catch (FileNotFoundException e) {
      System.out.println("Invalid file specified.");
    }
  }
}
