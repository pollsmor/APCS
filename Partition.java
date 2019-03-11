import java.util.Arrays;

public class Partition {
  public static int partition(int[] data, int start, int end) {
    int[] leftSide = new int[start];
    int[] toBeSorted = new int[end - start + 1];
    int[] rightSide = new int[data.length - end - 1];

    System.out.println(Arrays.toString(leftSide));
    System.out.println(Arrays.toString(toBeSorted));
    System.out.println(Arrays.toString(rightSide));
    return 1;
  }
}

//{6, 7, 10, 91, 7, -9, 98421, -195}
