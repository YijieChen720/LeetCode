public class NonDecreasingArray {
    public boolean checkPossibility(int[] nums) {
        int abnormal = 0;
        for (int i = 1; i < nums.length && abnormal < 2; i++) {
            if (nums[i - 1] > nums[i]) {
                abnormal += 1;
                if (i > 1 && nums[i - 2] > nums[i]) {
                    nums[i] = nums[i - 1];
                }
                else nums[i - 1] = nums[i];
            }
        }

        return abnormal < 2;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1,4,2,3};
        NonDecreasingArray test = new NonDecreasingArray();
        System.out.println(test.checkPossibility(nums));
    }
}
