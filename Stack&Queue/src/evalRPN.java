import java.util.Stack;

public class evalRPN {
    public int evalRPNMethod(String[] tokens) {
        Stack<Integer> temp = new Stack<>();
        for (String word : tokens) {
            switch (word) {
                case "+" -> temp.push(temp.pop() + temp.pop());
                case "-" -> temp.push(-temp.pop() + temp.pop());
                case "*" -> temp.push(temp.pop() * temp.pop());
                case "/" -> {
                    int denom = temp.pop();
                    int nume = temp.pop();
                    temp.push(nume / denom);
                }
                default -> temp.push(Integer.parseInt(word));
            }
        }
        return temp.pop();
    }
}
