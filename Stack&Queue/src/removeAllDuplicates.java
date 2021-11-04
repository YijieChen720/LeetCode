import java.util.Stack;

public class removeAllDuplicates {
    public String removeDuplicates(String s) {
        Stack<Character> ss = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ss.isEmpty() || ss.peek() != ch) {
                ss.push(ch);
            }
            else ss.pop();
        }
        StringBuilder stringB = new StringBuilder();
        Stack<Character> out = new Stack<>();
        while (!ss.isEmpty()) {
            out.push(ss.pop());
        }
        while (!out.isEmpty()) {
            stringB.append(out.pop());
        }
        return stringB.toString();
    }
}
