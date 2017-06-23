import java.util.*;
import java.util.stream.IntStream;

/**
 * 392. Is Subsequence
 * Given a string s and a string t, check if s is subsequence of t.
 * You may assume that there is only lower case English letters in both s and t.
 * t is potentially a very long (length ~= 500,000) string, and s is a short
 * string (<=100).
 *
 * A subsequence of a string is a new string which is formed from the original
 * string by deleting some (can be none) of the characters without disturbing
 * the relative positions of the remaining characters. (ie, "ace" is a
 * subsequence of "abcde" while "aec" is not).
 *
 * Example 1:
 * s = "abc", t = "ahbgdc"
 * Return true.
 *
 * Example 2:
 * s = "axc", t = "ahbgdc"
 * Return false.
 *
 * Follow up:
 * If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and you
 * want to check one by one to see if T has its subsequence. In this scenario,
 * how would you change your code?
 */
public class IsSubsequence {
  public boolean isSubsequence(String s, String t) {
    Map<Character, List<Integer>> tMap = new HashMap<>();
    IntStream.range(0, t.length()).forEach(i -> {
      char c = t.charAt(i);
      if (!tMap.containsKey(c)) {
        tMap.put(c, new ArrayList<Integer>());
      }
      tMap.get(c).add(i);
    });

    int previous = 0;
    for (char c : s.toCharArray()) {
      if (!tMap.containsKey(c)) {
        return false;
      }
      List<Integer> list = tMap.get(c);
      int index = Collections.binarySearch(list, previous);
      if (index < 0) {
        index = -1 - index;
      }

      if (index == list.size()) {
        return false;
      }

      previous = list.get(index) + 1;
    }
    return true;
  }

  public boolean isSubsequence1(String s, String t) {
    Map<Character, TreeSet<Integer>> tMap = new HashMap<>();
    IntStream.range(0, t.length()).forEach(i -> {
      char c = t.charAt(i);
      if (tMap.containsKey(c)) {
        tMap.get(c).add(i);
      } else {
        TreeSet<Integer> set = new TreeSet<Integer>();
        set.add(i);
        tMap.put(c, set);
      }
    });

    Integer previousIndex = -1;
    Integer currentIndex = -1;
    for (char c : s.toCharArray()) {
      if (!tMap.containsKey(c)) {
        return false;
      }
      previousIndex = currentIndex;
      currentIndex = tMap.get(c).higher(previousIndex);
      if (currentIndex == null) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    IsSubsequence subsequence = new IsSubsequence();
    String s = "leeeeetcode";
    String tt = "leeetcode";
    System.out.println(tt.length());
    System.out.println(subsequence.isSubsequence(s, tt));
  }
}
