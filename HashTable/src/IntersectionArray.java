import java.util.HashSet;
import java.util.Set;

public class IntersectionArray {
    public int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> set1 = new HashSet<>();
        for (int j : nums1) {
            set1.add(j);
        }

        Set<Integer> set2 = new HashSet<>();
        for (int j : nums2) {
            set2.add(j);
        }

        set1.retainAll(set2);

        int[] returnArray = new int[set1.size()];
        int idx = 0;

        for (Integer i : set1) {
            returnArray[idx] = i;
            idx += 1;
        }

        return returnArray;
    }


    public static void main(String[] args) {
        IntersectionArray test = new IntersectionArray();
        int[] i1 = {1};
        int[] i2 = {2};
        int[] a = test.intersection(i1, i2);
        System.out.println(a[0]);
    }
}
