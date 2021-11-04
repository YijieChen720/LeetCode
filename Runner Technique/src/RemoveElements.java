public class RemoveElements {
    public int removeElements(int[] nums, int val) {
        int fast;
        int slow = 0;
        int result = 0;
        for (fast = 0; fast < nums.length; fast += 1) {
            if (val != nums[fast]) {
                nums[slow] = nums[fast];
                slow += 1;
                result += 1;
            }
        }
        return result;
    }
}
