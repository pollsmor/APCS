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
    int instructionAmt = Integer.parseInt(firstRow.next());

    //Get data for the elevations of the map and the instructions
    int i = 1;
    Scanner inf = new Scanner(f);
    inf.nextLine(); //skip the first line of data since we got it already
    int[][] lake = new int[rows][cols];
    int[][] instructions = new int[instructionAmt][3];

    while (inf.hasNextLine()) {
      if (i >= 1 && i <= rows) {
        String line = inf.nextLine();
        for (int col = 0; col < cols; ++col) {
          lake[i - 1][col] = line.charAt(col);
        }
      }

      else if (i > rows && i <= rows + instructionAmt) {
        String line = inf.nextLine();
        for (int col = 0; col < 3; ++col) {
          instructions[i - rows - 1][col] = line.charAt(col);
        }
      }

      ++i;
    }

    System.out.println(printArr(lake));

    return 1;
  }

  public static int silver(String fileName) {
    return 1;
  }

  public static String printArr(int[][] arr) {
    String output = "";
    for (int i = 0; i < arr.length; ++i) {
      for (int j = 0; j < arr[0].length; ++j) {
        output += arr[i][j] + " ";
      }

      output += '\n';
    }

    return output;
  }
}
