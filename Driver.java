public class Driver {
  public static void main(String[] args) {
    QueenBoard test = new QueenBoard(8);
    test.addQueen(0, 0);
    System.out.println(test);
  }
}
