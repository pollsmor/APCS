import java.util.Random;

public class Partition {
  public static int partition(int[] data, int start, int end) {
    //In range between start and end, inclusive
    Random randgen = new Random();
    int pivotIdx = Math.abs(randgen.nextInt() % (end - start + 1)) + start;

    int pivot = data[pivotIdx];

    int i = start; //don't really want to modify the actual start and end
    int j = end;
    while (i < j) {
      while (data[i] < pivot) ++i; //keep going up until something should be right of the pivot
      while (data[j] > pivot) --j; //keep going down until something should be left of the pivot
      swap(data, i, j); //swap the two indexes from earlier to get them onto the correct side
    }

    return j; //new idx of the pivot
  }

  private static int[] swap(int[] data, int idx, int idx2) {
    int temp = data[idx];
    data[idx] = data[idx2];
    data[idx2] = temp;

    return data;
  }
}
