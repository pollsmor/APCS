public class recursion {
  private static double percError(double n, double guess) {
    //guess is the square root while n is the square itself, so I have to square the guess
    return Math.abs((guess * guess - n) / n * 100);
  }

  //Helper method
  public static double sqrt(double n, double tolerance) {
    if (n == 0) //hardcoded
      return 0;

    return guess(n, 1, tolerance); //initial guess is 1, can be whatever
  }

  private static double guess(double n, double guess, double tolerance) {
    //Given percent error
    if (percError(n, guess) < tolerance)
      return guess;

    //Newton's method
    return guess(n, (n / guess + guess) / 2, tolerance);
  }

  //Helper method
  public static int fib(int n) {
    //Base case
    if (n <= 1)
      return 0;


  }

  private static int fibRec(int n, int sum) {
    
  }
}
