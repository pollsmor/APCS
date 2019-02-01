public class recursion {
  public static double percError(double n, double guess) {
    //guess is the square root while n is the square itself, so I have to square the guess
    return Math.abs((guess * guess - n) / n * 100);
  }

  //Helper method
  public static double sqrt(double n) {
    if (n == 0) //hardcoded
      return 0;

    return guess(n, 1); //initial guess is 1, can be whatever
  }

  public static double guess(double n, double guess) {
    //Given percent error
    if (percError(n, guess) < 0.001)
      return guess;

    //Newton's method
    return guess(n, (n / guess + guess) / 2);
  }
}
