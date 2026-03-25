class Solution {
    public boolean isPalindrome(int x) {
        int sign = (x < 0) ? -1 : 1;
        int absValue = Math.abs(x);
        int num = x, result = 0;
        while(num > 0) {
            result = (result * 10) + (num % 10);
            num /= 10;
        }
        return ((sign * result) == x);
    }
}