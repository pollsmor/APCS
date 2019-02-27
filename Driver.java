import java.io.*;
import java.util.*;

public class Driver {
  public static void main(String[] args) {
    try {
      String fileName = "Maze1.txt";
      Maze maze = new Maze(fileName);
      System.out.println(maze);
    }

    catch (FileNotFoundException e) {
      System.out.println("Invalid file specified.");
    }
  }
}
