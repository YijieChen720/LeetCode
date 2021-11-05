import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new LinkedList<>();
        int leftIdx, rightIdx;
        int sum;
//        List<Integer> tmp = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] == nums[i-1]) {
                leftIdx = i + 1;
                rightIdx = nums.length - 1;
                while (leftIdx < rightIdx) {
                    sum = nums[i] + nums[leftIdx] + nums[rightIdx];
                    if (sum == 0) {
//                    tmp.add(nums[i]);
//                    tmp.add(nums[leftIdx]);
//                    tmp.add(nums[rightIdx]);
//                    list.add(tmp);
//                    tmp = new LinkedList<>();
                        list.add(Arrays.asList(nums[i], nums[leftIdx], nums[rightIdx]));
                        while (leftIdx < rightIdx && nums[leftIdx] == nums[leftIdx+1]) leftIdx += 1;
                        while (leftIdx < rightIdx && nums[rightIdx] == nums[rightIdx-1]) rightIdx -= 1;
                        leftIdx += 1;
                        rightIdx -= 1;
                    }
                    if (sum < 0) {
                        leftIdx += 1;
                    }
                    if (sum > 0) {
                        rightIdx -= 1;
                    }
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        ThreeSum test = new ThreeSum();
        List<List<Integer>> list = test.threeSum(nums);
    }
}
