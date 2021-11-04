public class ReverseString {
    public void reverseString(char[] s) {
        int front = 0;
        int back = s.length - 1;
        char temp;
        while (front < back) {
            temp = s[front];
            s[front] = s[back];
            s[back] = temp;
            front += 1;
            back -= 1;
        }
    }
}
