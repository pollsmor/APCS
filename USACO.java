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

    //Obtain the lake and the instructions
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

  //Aggregates all the water depths for easy calculation
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
    int heightAfterStomp = maxHeight - stompAmt; //every plot of land in a 3x3 around the cow will be this height

    if (heightAfterStomp < 0) //Stick with 0 for easier calculations
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

  //Find the max height to stomp down since other cows won't start if the others are higher
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

  //___________________________________________________________________________

  public static int silver(String fileName) throws FileNotFoundException {
    File f = new File(fileName);

    //Get data from the first line of input
    Scanner firstRow = new Scanner(f);
    int rows = Integer.parseInt(firstRow.next());
    int cols = Integer.parseInt(firstRow.next());
    int seconds = Integer.parseInt(firstRow.next());

    //Get data for the layout of the map and the start/end point
    int i = 1;
    Scanner inf = new Scanner(f);
    inf.nextLine(); //skip the first line of data since we got it already
    int[][] map = new int[rows][cols]; //initialize everything to 0
    int r1 = 0;
    int c1 = 0;
    int r2 = 0;
    int c2 = 0;

    //Obtain the map and the start/end coords
    while (inf.hasNextLine()) {
      String line = inf.nextLine();
      if (i == rows + 1) {
        String[] arr = line.split(" ");
        r1 = Integer.parseInt(arr[0]) - 1;
        c1 = Integer.parseInt(arr[1]) - 1;
        r2 = Integer.parseInt(arr[2]) - 1;
        c2 = Integer.parseInt(arr[3]) - 1;
      }

      else {
        for (int j = 0; j < cols; ++j)
          if (line.charAt(j) == '*')
            map[i - 1][j] = -1; //convert trees to -1 for easier manipulation
      }

      ++i;
    }

    //Hardcoded case for if the starting point is the endpoint and you don't move
    if (r1 == r2 && c1 == c2 && seconds == 0)
      return 1;

    map[r1][c1] = 1; //1 way to reach the origin in 0 seconds
    //How many seconds go by
    for (int t = 0; t < seconds; ++t) {
      map = moveOneSecond(map);
    }

    return map[r2][c2]; //return the amount of ways to the endpoint in t seconds
  }

  private static int[][] moveOneSecond(int[][] map) {
    int rows = map.length;
    int cols = map[0].length;
    int[][] newMap = new int[rows][cols]; //will replace the original map 1 second ago
    int[][] moves = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; //down, up, right, left

    for (int row = 0; row < rows; ++row) {
      for (int col = 0; col < cols; ++col) {
        if (map[row][col] == -1) //checks for trees
          newMap[row][col] = -1;

        else {
          //algorithm: the amount of ways to reach a board in t seconds is the sum of the amount of ways to reach its neighbors in t - 1 seconds
          int sumOfNeighbors = 0;
          for (int i = 0; i < moves.length; ++i)
            if (!outOfBounds(map, row + moves[i][0], col + moves[i][1]))
              sumOfNeighbors += map[row + moves[i][0]][col + moves[i][1]];

          newMap[row][col] = sumOfNeighbors;
        }
      }
    }

    return newMap;
  }

  private static boolean outOfBounds(int[][] map, int row, int col) {
    //Last condition checks for trees; that is out of bounds as well
    return row < 0 || row >= map.length || col < 0 || col >= map[0].length || map[row][col] == -1;
  }

  //For debugging, somehow forgot Arrays.deepToString() is a thing
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
