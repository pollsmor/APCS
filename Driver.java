public class Driver {
  public static void main(String[] args) {
    QueenBoard test = new QueenBoard(8);
    test.addQueen(4, 3);
    test.removeQueen(4, 3);
    System.out.println(test);

    QueenBoard test2 = new QueenBoard(8);
    test2.addQueen(0, 0);
    test2.removeQueen(1, 1);
    test2.removeQueen(0, 0);
    System.out.println(test2);
  }
}
