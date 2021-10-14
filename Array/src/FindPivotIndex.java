public class FindPivotIndex {
    public int pivotIndex(int[] nums) {
//        int leftSum = 0;
//        int rightSum = 0;
//        int leftIdx = 0;
//        int rightIdx = nums.length - 1;
//        while (leftIdx < rightIdx) {
//            if (leftSum <= rightSum) {
//                leftSum += nums[leftIdx];
//                leftIdx += 1;
//            } else {
//                rightSum += nums[rightIdx];
//                rightIdx -= 1;
//            }
//        }

        int leftSum = 0;
        int rightSum;
        int idx = 0;
        int totalSum = 0;

        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
        }

        for (idx = 0; idx < nums.length; idx++) {
            rightSum = totalSum - leftSum - nums[idx];
            if (rightSum == leftSum) {
                return idx;
            }
            leftSum += nums[idx];
        }
        return -1;
    }
}
