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
      String line = inf.nextLine();
      if (i >= 1 && i <= rows) {
        String[] arr = line.split(" ");
        for (int col = 0; col < cols; ++col) {
          lake[i - 1][col] = Integer.parseInt(arr[col]);
        }
      }

      else if (i > rows && i <= rows + instructionAmt) {
        String[] arr = line.split(" ");
        for (int col = 0; col < 3; ++col) {
          instructions[i - rows - 1][col] = Integer.parseInt(arr[col]);
        }
      }

      ++i;
    }

    for (int j = 0; j < instructions.length; ++j) {
      stomp(instructions[j], lake);
    }

    //Find the actual water levels
    int[][] waterLevel = new int[rows][cols];
    for (int k = 0; k < rows; ++k) {
      for (int m = 0; m < cols; ++m) {
        if (lake[k][m] >= finalEl)
          waterLevel[k][m] = 0;

        else
          waterLevel[k][m] = finalEl - lake[k][m];
      }
    }

    return findTotalWaterDepth(waterLevel) * 72 * 72;
  }

  private static int findTotalWaterDepth(int[][] waterLevel) {
    int rows = waterLevel.length;
    int cols = waterLevel[0].length;
    int depth = 0;

    for (int i = 0; i < rows; ++i) {
      for (int j = 0; j < cols; ++j) {
        depth += waterLevel[i][j];
      }
    }

    return depth;
  }

  private static void stomp(int[] instruction, int[][] lake) {
    int row = instruction[0];
    int col = instruction[1];
    int stompAmt = instruction[2];
    int rows = lake.length;
    int cols = lake[0].length;

    //Find the max height to stomp down
    int maxHeight = findMaxHeight(instruction, lake, rows, cols);
    int heightAfterStomp = maxHeight - stompAmt;

    if (heightAfterStomp < 0) //just in case
      heightAfterStomp = 0;

    if (row - 1 >= 0 && col - 1 >= 0) //top left
      if (lake[row - 1][col - 1] > heightAfterStomp)
        lake[row - 1][col - 1] = heightAfterStomp;

    if (row - 1 >= 0) //top
      if (lake[row - 1][col] > heightAfterStomp)
        lake[row - 1][col] = heightAfterStomp;

    if (row - 1 >= 0 && col + 1 < cols) //top right
      if (lake[row - 1][col + 1] > heightAfterStomp)
        lake[row - 1][col + 1] = heightAfterStomp;

    if (col - 1 >= 0) //left
      if (lake[row][col - 1] > heightAfterStomp)
        lake[row][col - 1] = heightAfterStomp;

    if (lake[row][col] > heightAfterStomp)
      lake[row][col] = heightAfterStomp;

    if (col + 1 < cols) //right
      if (lake[row][col + 1] > heightAfterStomp)
        lake[row][col + 1] = heightAfterStomp;

    if (row + 1 < rows && col - 1 >= 0) //bottom left
      if (lake[row + 1][col - 1] > heightAfterStomp)
        lake[row + 1][col - 1] = heightAfterStomp;

    if (row + 1 < rows) //bottom
      if (lake[row + 1][col] > heightAfterStomp)
        lake[row + 1][col] = heightAfterStomp;

    if (row + 1 < rows && col + 1 < cols) //bottom right
      if (lake[row + 1][col + 1] > heightAfterStomp)
        lake[row + 1][col + 1] = heightAfterStomp;
  }

  //Find the max height to stomp down
  private static int findMaxHeight(int[] instruction, int[][] lake, int rows, int cols) {
    int row = instruction[0];
    int col = instruction[1];
    int stompAmt = instruction[2];

    int maxHeight = 0;
    if (row - 1 >= 0 && col - 1 >= 0) //top left
      if (lake[row - 1][col - 1] > maxHeight)
        maxHeight = lake[row - 1][col - 1];

    if (row - 1 >= 0) //top
      if (lake[row - 1][col] > maxHeight)
        maxHeight = lake[row - 1][col];

    if (row - 1 >= 0 && col + 1 < cols) //top right
      if (lake[row - 1][col + 1] > maxHeight)
        maxHeight = lake[row - 1][col + 1];

    if (col - 1 >= 0) //left
      if (lake[row][col - 1] > maxHeight)
        maxHeight = lake[row][col - 1];

    if (lake[row][col] > maxHeight) //middle
      maxHeight = lake[row][col];

    if (col + 1 < cols) //right
      if (lake[row][col + 1] > maxHeight)
        maxHeight = lake[row][col + 1];

    if (row + 1 < rows && col - 1 >= 0) //bottom left
      if (lake[row + 1][col - 1] > maxHeight)
        maxHeight = lake[row + 1][col - 1];

    if (row + 1 < rows) //bottom
      if (lake[row + 1][col] > maxHeight)
        maxHeight = lake[row + 1][col];

    if (row + 1 < rows && col + 1 < cols) //bottom right
      if (lake[row + 1][col + 1] > maxHeight)
        maxHeight = lake[row + 1][col + 1];

    return maxHeight;
  }

  public static int silver(String fileName) {
    return 1;
  }

  private static String printArr(int[][] arr) {
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
