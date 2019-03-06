import java.util.*;
import java.io.*;

public class USACO {
  public static int bronze(String fileName) throws FileNotFoundException {
    File f = new File(fileName);

    //Get data from the first line of input
    Scanner firstRow = new Scanner(f);
    int rows = Integer.parseInt(firstRow.next());
    int cols = Integer.parseInt(firstRow.next());
    int finalEl = Integer.parseInt(firstRow.next());
    int instructions = Integer.parseInt(firstRow.next());

    System.out.println(rows);
    System.out.println(cols);
    System.out.println(finalEl);
    System.out.println(instructions);

    return 1;
  }

  public static int silver(String fileName) {
    return 1;
  }
}
