import java.util.Random;

public class Partition {
  public static int partition(int[] data, int start, int end) {
    Random randgen = new Random();
    int pivotIdx = Math.abs(randgen.nextInt() % (end - start + 1)) + start;
    int pivot = data[pivotIdx];
    System.out.println(pivotIdx);

    int i = start;
    int j = end;
    while (i < j) {
      while (data[i] < pivot) ++i;
      while (data[j] > pivot) --j;
      swap(data, i, j);
    }

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
