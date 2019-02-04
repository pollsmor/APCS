import java.util.List;
import java.util.ArrayList;

public class AllWords {
  public static List<String> makeAllWords(int k, int maxLetter) {
    List<String> output = new ArrayList<String>();
    allWordsRec(k, "", output);
    return output;
  }

  private static void allWordsRec(int k, String word, List<String> list) {
    if (k == 0)
      return;

    if (!word.equals(""))
      list.add(word);

    for (int i = 97; i <= 97 + k; ++i)
      allWordsRec(k - 1, word + (char)i, list);
  }
}
