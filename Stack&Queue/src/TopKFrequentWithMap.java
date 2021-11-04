import java.util.*;

public class TopKFrequentWithMap {
    Deque<Integer> deque;
    Map<Integer,Integer> map;

    private void enQueue(int x, int k) {
        if (deque.isEmpty()) {
            deque.add(x);
        }
        else {
            if (map.get(deque.getLast()) < map.get(x)) {
                if (deque.size() == k) {
                    deque.removeFirst();
                }
                deque.addLast(x);
            } else if (map.get(deque.peek()) < map.get(x)) {
                if (deque.size() == k) {
                    deque.removeFirst();
                }
                int count = 0;
                while (map.get(deque.peek()) < map.get(x)) {
                    deque.addLast(deque.removeFirst());
                    count++;
                }
                deque.addFirst(x);
                for (int i = 0; i < count; i++) {
                    deque.addFirst(deque.removeLast());
                }
            } else {
                if (deque.size() < k) {
                    deque.addFirst(x);
                }
            }

        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        map = new HashMap<>();
        deque = new ArrayDeque<>();

        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        for (int key : map.keySet()) {
            enQueue(key, k);
        }

        int[] returnArray = new int[k];
        for (int i = 0; i < k; i++) {
            returnArray[i] = deque.removeFirst();
        }

        return returnArray;
    }

    public static void main(String[] args) {
        TopKFrequentWithMap test = new TopKFrequentWithMap();
        int[] nums = {-1,1,4,-4,3,5,4,-2,3,-1};
        int k = 3;
        int[] result = test.topKFrequent(nums, k);
        for (int i = 0; i < k; i++) {
            System.out.println(result[i]);
        }
    }
}
