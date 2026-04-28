class Solution {
    public String countAndSay(int n) {
        if (n <= 0) return "";
        String res = "1";

        for (int i = 1; i < n; i++) {
            res = getNext(res);
        }

        return res;
    }

    private String getNext(String s) {
        StringBuilder sb = new StringBuilder();
        int i = 0;

        while(i < s.length()) {
            char currentVal = s.charAt(i);
            int count = 0;

            while(i < s.length() && s.charAt(i) == currentVal) {
                count++;
                i++;
            }

            sb.append(count).append(currentVal);
        }

        return sb.toString();

    }
}