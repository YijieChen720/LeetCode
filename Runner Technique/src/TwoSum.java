import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    // Cannot use two ptr method as return value is index so cannot sort array
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        int residual;
        for (int i = 0; i < nums.length; i++) {
            residual = target - nums[i];
            if (map.containsKey(residual)) {
                res[0] = i;
                res[1] = map.get(residual);
                break;
            }
            map.put(nums[i], i);
        }
        return res;
    }
}
