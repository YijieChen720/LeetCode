import java.util.Stack;

public class ValidParentheses {
    Stack<Character> ss;
    public boolean isValid(String s) {
        ss = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char word = s.charAt(i);
            if (word == '(' || word == '[' || word == '{') {
                ss.push(word);
            } else if (ss.isEmpty()) {
                return false;
            } else if (word == ')' && ss.peek() == '(') {
                ss.pop();
            } else if (word == ']' && ss.peek() == '[') {
                ss.pop();
            } else if (word == '}' && ss.peek() == '{') {
                ss.pop();
            } else {
                return false;
            }
        }
        return ss.isEmpty();
    }
}
