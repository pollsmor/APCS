import java.util.Arrays;
import java.util.Random;

public class Partition {
  public static int partition(int[] data, int start, int end) {
    Random randgen = new Random();
    int pivotIdx = Math.abs(randgen.nextInt() % (end - start + 1)) + start;
    int pivot = data[pivotIdx];
    System.out.println(pivotIdx);

    int temp = data[start];
    data[start] = pivot;
    data[pivotIdx] = temp;
    pivotIdx = 0;

    for (int i = start; i <= end; ++i) {
      if (data[i] < pivot) {
        int temp2 = data[start];
        data[start] = data[i];
        data[i] = temp2;
        ++pivotIdx;
      }
    }

    System.out.println(pivotIdx);
    System.out.println(Arrays.toString(data));
    return pivotIdx;
  }
}

//{1, 2, 3, 4, 6, 7, 10, 91, 7, -9, 98421, -195}
