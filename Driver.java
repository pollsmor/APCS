public class Driver {
  public static void main(String[] args) {
    QueenBoard test = new QueenBoard(4);
    System.out.println(test.countSolutions());

    QueenBoard test3 = new QueenBoard(9);
    System.out.println(test3.countSolutions());
  }
}
