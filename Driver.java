import java.util.*;
import java.io.*;

public class Driver {
  public static void main(String[] args) {
    if (args.length < 1) {
      System.out.println("Please provide a file.");
      System.exit(0);
    }

    String fileName = args[0];

    try {
      System.out.println(USACO.bronze(fileName));
    }

    catch (FileNotFoundException e) {
      System.out.println("Invalid file provided.");
    }
  }
}
