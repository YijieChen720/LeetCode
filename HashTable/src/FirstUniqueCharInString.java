public class FirstUniqueCharInString {
    public int firstUniqChar(String s) {
        int[] store = new int[26];
        for (int i = 1; i < s.length() + 1; i++) {
            int tmp = s.charAt(i - 1) - 'a';
            if (store[tmp] == 0) store[tmp] = i;
            else if (store[tmp] > 0) store[tmp] = - 1;
        }

        int res = -1;
        int min = s.length() + 1;

        for (int i = 0; i < 26; i++) {
            if (store[i] != -1 && store[i] != 0 && store[i] < min) {
                min = store[i];
                res = store[i] - 1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String s = "z";
        FirstUniqueCharInString test = new FirstUniqueCharInString();
        System.out.println(test.firstUniqChar(s));
    }
}
