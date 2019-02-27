public class Maze {
  private char[][] maze;
  private int rows;
  private int cols;

  public Maze(char[][] inputMaze) {
    maze = inputMaze;
    rows = maze.length;
    cols = maze[0].length;
  }
}
