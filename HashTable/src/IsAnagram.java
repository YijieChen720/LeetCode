import java.util.HashMap;
import java.util.Map;

public class IsAnagram {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) {
            return false;
        }

        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> mapS = new HashMap<>();
        Map<Character, Integer> mapT = new HashMap<>();

        for (int i = 0; i < s.length(); ++i) {
            if (mapS.get(s.charAt(i)) == null) {
                mapS.put(s.charAt(i), 1);
                continue;
            }
            mapS.put(s.charAt(i), mapS.get(s.charAt(i)) + 1);
        }

        for (int i = 0; i < t.length(); ++i) {
            if (mapT.get(t.charAt(i)) == null) {
                mapT.put(t.charAt(i), 1);
                continue;
            }
            mapT.put(t.charAt(i), mapT.get(t.charAt(i)) + 1);
        }

        return mapS.equals(mapT);
    }

    public boolean isAnagramArray(String s, String t) {
        if (s == null || t == null) {
            return false;
        }

        if (s.length() != t.length()) {
            return false;
        }

        int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            alphabet[s.charAt(i) - 'a'] += 1;
        }

        for (int i = 0; i < t.length(); ++i) {
            alphabet[t.charAt(i) - 'a'] -= 1;
            if (alphabet[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
