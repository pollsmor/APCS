public class Driver {
  public static void main(String[] args) {

    QueenBoard test6 = new QueenBoard(5);
    test6.solve();
    System.out.println(test6);
    System.out.println("5x5: " + test6.countSolutions());

    QueenBoard test8 = new QueenBoard(5);
  }
}
