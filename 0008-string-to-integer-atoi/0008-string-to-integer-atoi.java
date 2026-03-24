class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        if(s.length() == 0) return 0;
        int i = 0, n = s.length();
        int sign = 1;
        
        if(s.charAt(0) == '-' || s.charAt(0) == '+') {
            sign = s.charAt(0) == '-' ? -1 : 1;
            i++;
        }

        long result = 0;
        while(i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';

            if(result > (Integer.MAX_VALUE - digit) / 10) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result * 10 + digit;
            i++;
        }
        return (int) (sign * result);
    }
}