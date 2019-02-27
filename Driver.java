import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Driver {
  public static void main(String[] args) {
    try {
      File text = new File("Maze1.txt");
      Scanner inf = new Scanner(text);

      //rows in maze
      int rows = 0;
      while (inf.hasNextLine()) {
        ++rows;
        inf.nextLine();
      }

      //cols in maze
      int cols = inf.nextLine().length();

      char[][] mazeEls = new char[rows][cols];
      for (int i = 0; i < rows; ++i)
        for (int j = 0; j < cols; ++j)
          mazeEls[i][j] = inf.next().charAt(0);

    }

    catch (FileNotFoundException e) {
      System.out.println("Invalid file specified.");
    }
  }
}
