import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Driver {
  public static void main(String[] args) {
    try {
      File text = new File("Maze1.txt");
      Scanner inf = new Scanner(text);
      int rows = 0;
      while (inf.hasNextLine()) {
        ++rows;
        inf.nextLine();
      }
      int cols = inf.nextLine().length();
      char[][] maze = new char[rows][cols];

      //Print out stuff
      while (inf.hasNextLine()) {
        String line = inf.nextLine();
        System.out.println(line);
      }
    }

    catch (FileNotFoundException e) {
      System.out.println("Invalid file specified.");
    }
  }
}
