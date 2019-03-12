import java.util.Arrays;
import java.util.Random;

public class Partition {
  public static int partition(int[] data, int start, int end) {
    Random randgen = new Random();
    int pivotIdx = Math.abs(randgen.nextInt() % (end - start + 1)) + start;
    int pivot = data[pivotIdx];
    int temp = data[start];
    data[start] = pivot;
    data[pivotIdx] = temp;

    for (int i = start + 1; i <= end; ++i) {
      if (data[i] < pivot) {

      }
    }

    System.out.println(pivotIdx);
    System.out.println(Arrays.toString(data));
    return j;
  }

  private static int[] swap(int[] data, int idx, int idx2) {
    int temp = data[idx];
    data[idx] = data[idx2];
    data[idx2] = temp;

    return data;
  }
}

//{1, 2, 3, 4, 6, 7, 10, 91, 7, -9, 98421, -195}
