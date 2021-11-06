import java.util.HashMap;
import java.util.Map;

public class FourSumII {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map12 = new HashMap<>();

        int n = nums1.length;
        int sum;

        for (int i : nums1) {
            for (int j : nums2) {
                sum = i + j;
                if (map12.containsKey(sum)) {
                    map12.put(sum, map12.get(sum) + 1);
                }
                else map12.put(sum, 1);
            }
        }

        int count = 0;

        for (int i : nums3) {
            for (int j : nums4) {
                sum = - (i + j);
                if (map12.containsKey(sum)) {
                    count += map12.get(sum);
                }
            }
        }

        return count;
    }
}
