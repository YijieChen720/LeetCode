public class SqOfSortedArray {
    class Solution1 {
        public int[] sortedSquares(int[] nums) {
            int[] numsSq = new int[nums.length];

            for (int i = 0; i < nums.length; i += 1) {
                numsSq[i] = nums[i] * nums[i];
            }

            sSort(numsSq);

            return(numsSq);
        }

        private void sSort(int[] nums) {
            int s0 = 0;
            int smallest;

            while (s0 < nums.length) {
                smallest = s0;

                for (int i = s0 + 1; i < nums.length; i ++) {
                    if (nums[i] < nums[smallest]) {
                        smallest = i;
                    }
                }

                sSwap(nums, s0, smallest);
                s0 += 1;
            }

        }

        private void sSwap(int[] nums, int index1, int index2) {
            int temp = nums[index1];
            nums[index1] = nums[index2];
            nums[index2] = temp;
        }
    }

    class Solution2 {
        public int[] sortedSquares(int[] nums) {
            int end = nums.length - 1;
            int begin = 0;
            int[] numsSq = new int[nums.length];
            int endS, beginS;
            int index = nums.length - 1;

            while(begin <= end) {
                endS = nums[end] * nums[end];
                beginS = nums[begin] * nums[begin];
                if (endS > beginS) {
                    numsSq[index] = endS;
                    end = end - 1;
                } else {
                    numsSq[index] = beginS;
                    begin = begin + 1;
                }
                index -= 1;
            }
            return numsSq;

        }
    }
}
