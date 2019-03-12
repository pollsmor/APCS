import java.util.Arrays;

public class Driver {
  public static void main(String[] args) {
    int[] arr = {6, 7, 10, 91, 7, -9, 98421, -195};
    int[] arr2 = {22, 2, 3, 4, 6, 7, 10, 91, 3021, -9, 98421, -195};
    int[] arr3 = {999, 999, 999, 4, 1, 0, 3, 2, 999, 999, 999};

    System.out.println(Partition.partition(arr2, 0, 11));
    System.out.println(Arrays.toString(arr2));
  }
}
