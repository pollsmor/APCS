import java.util.Arrays;
import java.util.Random;

public class Partition {
  public static int partition(int[] data, int start, int end) {
    int[] leftSide = new int[start];
    int[] toBeSorted = new int[end - start + 1]; //only thing to be sorted, the other two are tacked on at the end of the process
    int[] rightSide = new int[data.length - end - 1];

    //Copy over data into appropriate arrays
    for (int i = 0; i < data.length; ++i) {
      if (i < start)
        leftSide[i] = data[i];

      else if (i >= start && i <= end)
        toBeSorted[i - start] = data[i];

      else
        rightSide[i - end - 1] = data[i];
    }

    Random randgen = new Random();
    int pivotIdx = Math.abs(randgen.nextInt() % (end - start + 1));

    System.out.println(pivotIdx);
    System.out.println(Arrays.toString(toBeSorted));
    return 1;
  }
}

//{1, 2, 3, 4, 6, 7, 10, 91, 7, -9, 98421, -195}
