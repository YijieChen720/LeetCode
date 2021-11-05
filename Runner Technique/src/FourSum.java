import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(nums);
        int left, right, sum;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (j == i + 1 || nums[j] != nums[j - 1]) {
                        left = j + 1;
                        right = nums.length - 1;
                        while (left < right) {
                            sum = nums[i] + nums[j] + nums[left] + nums[right];
                            if (sum == target) {
                                res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                                while (left < right && nums[left] == nums[left + 1]) left++;
                                while (left < right && nums[right] == nums[right - 1]) right--;
                                left++;
                                right--;
                            }
                            else if (sum < target) {
                                left++;
                            }
                            else right--;
                        }
                    }
                }
            }
        }
        return res;
    }
}
