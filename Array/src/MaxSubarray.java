public class MaxSubarray {
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int sum = 0;
        int max = nums[0];

        for (int num : nums) {
            sum += num;
            if (sum > max) max = sum;
            if (sum < 0) {
                sum = 0;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        MaxSubarray test = new MaxSubarray();
        int sum = test.maxSubArray(nums);
        System.out.println(sum);
    }
}
