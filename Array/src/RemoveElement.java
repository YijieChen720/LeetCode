public class RemoveElement {
    public class Solution1 {

        public int removeElement(int[] nums, int val) {
            int countRest;
            int countVal = replaceToEnd(nums,nums.length - 1, val);
            countRest = nums.length - countVal;
            return countRest;
        }

        private void sSwitch(int[] nums, int index1, int index2) {
            int temp = nums[index1];
            nums[index1] = nums[index2];
            nums[index2] = temp;
        }

        private int replaceToEnd(int[] nums, int l, int val) {
            int countVal = 0;
            while (l >= 0) {
                for (int i = l; i >= 0; i -= 1) {
                    if (nums[i] == val) {
                        sSwitch(nums, i, l);
                        countVal = countVal + 1;
                        break;
                    }
                }
                l = l - 1;
            }
            return countVal;
        }
    }

    public class Solution2 {

        public int removeElement(int[] nums, int val) {
            int m = 0;

            for (int i = 0; i < nums.length; i += 1) {

                if (nums[i] != val) {
                    nums[m] = nums[i];
                    m += 1;
                }

            }

            return m;
        }
    }

}
