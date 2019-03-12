import java.util.Arrays;
import java.util.Random;

public class Partition {
  public static int partition(int[] data, int start, int end) {
    Random randgen = new Random();
    int pivotIdx = Math.abs(randgen.nextInt() % (start + 1)) + start;
    int pivot = data[pivotIdx];

    System.out.println(pivotIdx);
    System.out.println(Arrays.toString(data));
    return pivotIdx;
  }
}

//{1, 2, 3, 4, 6, 7, 10, 91, 7, -9, 98421, -195}
