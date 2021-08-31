public class MinimumSizeSubarraySum {
    class Solution1 {
        public int minSubArrayLen(int target, int[] nums) {
            int length = nums.length + 1;
            int[] sumArray = new int[nums.length];
            int left = 0;
            sumArray[left] = nums[0];
            int lengthTemp;

            for (int right = 0; right < nums.length; right ++) {

                sumArray[right] = nums[right];

                if (arraySum(nums, left, right) >= target) {

                    while (arraySum(nums, left, right) - sumArray[left] >= target) {
                        left += 1;
                    }

                    lengthTemp = right - left + 1;

                    if (lengthTemp < length) {
                        length = lengthTemp;
                    }
                }

            }

            if (length == nums.length + 1) {
                return 0;
            }
            else {
                return length;
            }
        }

        private int arraySum(int num[], int left, int right) {
            int sum = 0;
            for (int i = left; i <= right; i ++) {
                sum += num[i];
            }
            return sum;
        }
    }

    class Solution2 {
        public int minSubArrayLen(int target, int[] nums) {
            int length = nums.length + 1;
            int sum = 0;
            int left = 0;
            int lengthTemp;

            for (int right = 0; right < nums.length; right ++) {

                sum += nums[right];

                while (sum >= target) {
                    lengthTemp = right - left + 1;
                    if (lengthTemp < length) {
                        length = lengthTemp;
                    }
                    sum -= nums[left];
                    left += 1;
                }

            }

            if (length == nums.length + 1) {
                return 0;
            }
            else {
                return length;
            }
        }

    }
}
