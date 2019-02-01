public class Driver {
  public static void main(String[] args) {
    System.out.println(recursion.sqrt(1, 0.0001));
    System.out.println(recursion.sqrt(2, 0.0001));
    System.out.println(recursion.sqrt(4, 0.0001));
    System.out.println(recursion.sqrt(10000, 0.00000001));
    System.out.println(recursion.sqrt(900, 0.0001));
    System.out.println(recursion.sqrt(0, 0.0001));

    System.out.println("--------------------");

    System.out.println(recursion.fib(0));
    System.out.println(recursion.fib(1));
    System.out.println(recursion.fib(2));
    System.out.println(recursion.fib(3));
    System.out.println(recursion.fib(4));
    System.out.println(recursion.fib(5));
    System.out.println(recursion.fib(6));
    System.out.println(recursion.fib(46)); //largest number without overflowing int
  }
}
