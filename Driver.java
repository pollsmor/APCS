public class Driver {
  public static void main(String[] args) {
    KnightBoard test = new KnightBoard(3, 5);

    test.solve(0, 0);

    System.out.println(test);
  }
}
