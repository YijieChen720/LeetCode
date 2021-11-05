import java.util.ArrayDeque;
import java.util.Deque;

public class ReverseWordsInString {
    private Deque<String> parseString(String s) {
        Deque<String> deque = new ArrayDeque<>();
        int state = 0;
        String tmp = "";
        for(int i = 0; i < s.length(); i++) {
            if (state == 0) {
                if (s.charAt(i) != ' ') {
                    state = 1;
                    tmp = "";
                    tmp += s.charAt(i);
                }
            } else {
                if (s.charAt(i) != ' ') {
                    tmp += s.charAt(i);
                } else {
                    deque.add(tmp);
                    state = 0;
                }
            }
        }
        if (s.charAt(s.length()-1) != ' ') {
            deque.add(tmp);
        }
        return deque;
    }

    public String reverseWords(String s) {
        Deque<String> deque = parseString(s);
        StringBuilder returnString = new StringBuilder();
        while (!deque.isEmpty()) {
            returnString.append(deque.removeLast());
            returnString.append(" ");
        }
        returnString.deleteCharAt(returnString.length()-1);
        return returnString.toString();
    }

    public static void main(String[] args) {
        ReverseWordsInString test = new ReverseWordsInString();
        System.out.println(test.reverseWords(args[0]));
    }
}
