import java.util.List;
import java.util.ArrayList;

public class AllWords {
  public static List<String> makeAllWords(int k, int maxLetter) {
    List<String> output = new ArrayList<String>();
    allWordsRec(k, "", output, k, maxLetter);
    return output;
  }

  private static void allWordsRec(int k, String word, List<String> list, int original, int maxLetter) {
    if (k == -1)
      return;

    if (!word.equals("") && word.length() == original)
      list.add(word);

    for (int i = 97; i < 97 + maxLetter ; ++i)
      allWordsRec(k - 1, word + (char)i, list, original, maxLetter);
  }
}
