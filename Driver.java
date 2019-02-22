public class Driver {
  public static void main(String[] args) {
    KnightBoard test = new KnightBoard(5, 5);

    test.solve(0, 0);

    System.out.println(test);
  }
}
