public class Driver {
  public static void main(String[] args) {
    QueenBoard test = new QueenBoard(4);
    System.out.println(test.countSolutions());

    QueenBoard test2 = new QueenBoard(5);
    System.out.println(test2.countSolutions());

    QueenBoard test3 = new QueenBoard(6);
    System.out.println(test3.countSolutions());

    QueenBoard test4 = new QueenBoard(7);
    System.out.println(test4.countSolutions());
  }
}
