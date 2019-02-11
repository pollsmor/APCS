public class Driver {
  public static void main(String[] args) {
    QueenBoard test = new QueenBoard(4);
    test.solve();
    System.out.println(test);

    QueenBoard test2 = new QueenBoard(1);
    test2.solve();
    System.out.println(test2);

    QueenBoard test3 = new QueenBoard(2);
    test3.solve();
    System.out.println(test3);

    QueenBoard test4 = new QueenBoard(3);
    test4.solve();
    System.out.println(test4);
  }
}
