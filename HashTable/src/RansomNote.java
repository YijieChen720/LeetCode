import java.util.HashMap;
import java.util.Map;

public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> mag = new HashMap<>();

        for (int i = 0; i < magazine.length(); i++) {
            if (!mag.containsKey(magazine.charAt(i))) {
                mag.put(magazine.charAt(i),1);
            }
            else {
                mag.put(magazine.charAt(i), mag.get(magazine.charAt(i)) + 1);
            }
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            if (!mag.containsKey(ransomNote.charAt(i)) || mag.get(ransomNote.charAt(i)) == 0) {
                return false;
            }
            mag.put(ransomNote.charAt(i), mag.get(ransomNote.charAt(i)) - 1);
        }

        return true;
    }

    public static void main(String[] args) {
        RansomNote test = new RansomNote();
        String ransomNote = "aa";
        String magazine = "aab";
        test.canConstruct(ransomNote, magazine);
    }
}
