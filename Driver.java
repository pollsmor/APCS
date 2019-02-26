import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Driver {
  public static void main(String[] args) {
    File text = new File("Maze1.txt");
    Scanner inf = new Scanner(text);

    while (inf.hasNextLine()) {
      String line = inf.nextLine();
      System.out.println(line);
    }
  }
}
