import java.util.List;
import java.util.ArrayList;

public class AllWords {
  public static List<String> makeAllWords(int k, int maxLetter) {
    List<String> output = new ArrayList<String>();
    allWordsRec(k, "", output);
    return output;
  }

  private static void allWordsRec(int k, String word, List<String> list) {

  }
}
