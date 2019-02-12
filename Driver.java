public class Driver {
  public static void main(String[] args) {
    QueenBoard test = new QueenBoard(0);
    System.out.println(test.countSolutions());

    QueenBoard test2 = new QueenBoard(1);
    System.out.println(test2.countSolutions());

    QueenBoard test3 = new QueenBoard(2);
    System.out.println(test3.countSolutions());

    QueenBoard test4 = new QueenBoard(3);
    System.out.println(test4.countSolutions());

    QueenBoard test5 = new QueenBoard(4);
    System.out.println(test5.countSolutions());

    QueenBoard test6 = new QueenBoard(5);
    System.out.println(test6.countSolutions());
  }
}
