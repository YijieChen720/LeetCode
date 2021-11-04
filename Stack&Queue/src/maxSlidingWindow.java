import java.util.ArrayDeque;
import java.util.Deque;

@SuppressWarnings("ConstantConditions")
public class maxSlidingWindow {
    Deque<Integer> queue;

    void inQueue(int x) {
        if (x > queue.peek()) {
            while (!queue.isEmpty()) {
                queue.remove();
            }
            queue.addFirst(x);
        }
        else {
            while (queue.getLast() < x) {
                queue.removeLast();
            }
            queue.addLast(x);
        }
    }

    void enQueue(int x) {
        while (!queue.isEmpty() && queue.getLast()<x) {
            queue.removeLast();
        }
        queue.addLast(x);
    }

    void deQueue(int x) {
        if (x == queue.peek()) {
            queue.remove();
        }
    }

    public int[] maxSlidingWindowMethod(int[] nums, int k) {
        queue = new ArrayDeque<>();

        int[] returnArray = new int[nums.length - k + 1];

        queue.add(nums[0]);
        for (int i = 1; i < k; i++) {
            inQueue(nums[i]);
        }

        for (int i = 0; i < returnArray.length; i++) {
            if (i != 0) {
                deQueue(nums[i-1]);
                enQueue(nums[k-1+i]);
            }
            returnArray[i] = queue.peek();
        }
        return returnArray;
    }
}
