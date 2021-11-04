import java.util.LinkedList;
import java.util.Queue;

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
class MyStack {
    Queue<Integer> q1;
    Queue<Integer> q2;

    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(int x) {
        q1.add(x);
    }

    public int pop() {
        int q1Size = q1.size();
        for (int i = 0; i < q1Size-1; i++) {
            q2.add(q1.remove());
        }
        int returnValue = q1.remove();
        int q2Size = q2.size();
        for (int i = 0; i < q2Size; i++) {
            q1.add(q2.remove());
        }
        return returnValue;
    }

    public int top() {
        int q1Size = q1.size();
        for (int i = 0; i < q1Size-1; i++) {
            q2.add(q1.remove());
        }
        int returnValue = q1.peek();
        q2.add(q1.remove());
        int q2Size = q2.size();
        for (int i = 0; i < q2Size; i++) {
            q1.add(q2.remove());
        }
        return returnValue;
    }

    public boolean empty() {
        return q1.isEmpty();
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.top(); // return 2
        myStack.pop(); // return 2
        myStack.empty(); // return False
    }
}

