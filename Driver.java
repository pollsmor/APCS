public class Driver {
  public static void main(String[] args) {
    QueenBoard test = new QueenBoard(0);
    System.out.println("0x0: " + test.countSolutions());

    QueenBoard test2 = new QueenBoard(1);
    System.out.println("1x1: " + test2.countSolutions());

    QueenBoard test3 = new QueenBoard(2);
    System.out.println("2x2: " + test3.countSolutions());

    QueenBoard test4 = new QueenBoard(3);
    System.out.println("3x3: " + test4.countSolutions());

    QueenBoard test5 = new QueenBoard(4);
    System.out.println("4x4: " + test5.countSolutions());

    QueenBoard test6 = new QueenBoard(5);
    test6.solve();
    System.out.println(test6);
    System.out.println("5x5: " + test6.countSolutions());

    QueenBoard test7 = new QueenBoard(10);
    System.out.println("10x10: " + test7.countSolutions());
  }
}
