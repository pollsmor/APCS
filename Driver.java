import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Driver {
  public static void main(String[] args) {
    try {
      File text = new File("Maze1.txt");
      Scanner colsChecker = new Scanner(text);
      //cols in maze
      int cols = colsChecker.nextLine().length();

      //rows in maze
      Scanner inf2 = new Scanner(text);
      int rows = 0;
      while (inf2.hasNextLine()) {
        ++rows;
        inf2.nextLine();
      }

      Scanner inf3 = new Scanner(text);
      char[][] mazeEls = new char[rows][cols];
      for (int i = 0; i < rows; ++i) {
        String line = inf3.nextLine();
        for (int j = 0; j < cols; ++j) {
          char el = line.charAt(j);
          mazeEls[i][j] = el;
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
