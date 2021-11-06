import java.util.Stack;

public class ValidateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int popIdx = 0;
        for (int j : pushed) {
            stack.push(j);
            while (!stack.isEmpty() && stack.peek() == popped[popIdx]) {
                stack.pop();
                popIdx += 1;
            }
        }
        return stack.isEmpty();
    }
}
