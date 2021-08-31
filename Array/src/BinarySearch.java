public class BinarySearch {
    class Solution {
        public int search(int[] nums, int target) {
            int index = nums.length / 2;
            return(bSearch(nums, target, 0, nums.length - 1, index));
        }

        private int bSearch(int[] nums, int target, int indexL, int indexR, int indexM) {
            if (nums[indexM] == target) {
                return indexM;
            }

            else if (indexL > indexR) {
                return -1;
            }

            else if (nums[indexM] < target) {
                indexL = indexM + 1;
                indexM = (indexL + indexR) / 2;
            }
            else {
                indexR = indexM - 1;
                indexM = (indexL + indexR) / 2;
            }
            return bSearch(nums, target, indexL, indexR, indexM);
        }
    }

}
