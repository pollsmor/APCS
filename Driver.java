public class Driver {
  public static void main(String[] args) {
    QueenBoard test = new QueenBoard(4);
    test.solve();
    System.out.println(test);
    System.out.println(test.countSolutions());

    QueenBoard test2 = new QueenBoard(0);
    test2.solve();
    System.out.println(test2);
    System.out.println(test2.countSolutions());

    QueenBoard test3 = new QueenBoard(1);
    test3.solve();
    System.out.println(test3);
    System.out.println(test3.countSolutions());

    QueenBoard test4 = new QueenBoard(2);
    test4.solve();
    System.out.println(test4);
    System.out.println(test4.countSolutions());

    QueenBoard test5 = new QueenBoard(3);
    test5.solve();
    System.out.println(test5);
    System.out.println(test5.countSolutions());
  }
}
