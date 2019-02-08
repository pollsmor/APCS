public class Driver {
  public static void main(String[] args) {
    QueenBoard test = new QueenBoard(8);
    test.addQueen(4, 4);
    System.out.println(test);

    QueenBoard test2 = new QueenBoard(8);
    test2.addQueen(0, 0);
    System.out.println(test2);
  }
}
