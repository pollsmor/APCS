import java.util.ArrayList;

public class Recursion {
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
    //Hardcoded case
    if (n <= 1)
      return n;


    return fibRec(n, 0, 1); //since the first 2 terms of the sequence are 0 and 1
  }

  //store sums in prev2 and prev for easy access
  private static int fibRec(int n, int prev2, int prev) {
    //Base case
    if (n == 0)
      return prev2; //prev2 here is the prev in the bottom statement so I return this

    return fibRec(n - 1, prev, prev2 + prev);
  }

  public static ArrayList<Integer> makeAllSums(int n) {
    ArrayList<Integer> list = new ArrayList<Integer>();

    //Hardcoded case
    if (n == 0) {
      list.add(0);
      return list;
    }

    allSumsRec(list, n, n, 0); //run void recursive function, won't exit it until recursion is done

    //Code to remove dupes. Unfortunately also removes "valid" dupes.
    ArrayList<Integer> listOutput = new ArrayList<Integer>();
    for (int i = 0; i < list.size(); ++i)
      if (!listOutput.contains(list.get(i)))
        listOutput.add(list.get(i));

    return listOutput;
  }

  private static void allSumsRec(ArrayList<Integer> list, int n, int current, int sum) {
    if (current < 0) //Why not == 0? Because I still want the else if statement to be run one last time.
      return;

    else if (current < n) //Why this? Because I don't want to add the initial sum I set in makeAllSums which is 0
      list.add(sum);

    allSumsRec(list, n, current - 1, sum + current);
    allSumsRec(list, n, current - 1, sum);
  }
}
