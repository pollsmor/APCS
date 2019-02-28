import java.io.*;
import java.util.*;

public class Driver {
  public static void main(String[] args) {
    if (args.length < 1) {
      System.out.println("Please provide a maze file.");
      System.exit(0);
    }

    String fileName = args[0];

    try {
      Maze maze = new Maze(fileName);

      maze.setAnimate(true);
      maze.solve();
      System.out.println(maze);
    }

    catch (FileNotFoundException e) {
      System.out.println("Invalid filename: " + fileName);
    }
  }
}
