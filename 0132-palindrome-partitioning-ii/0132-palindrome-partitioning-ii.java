class Solution {
    public int minCut(String s) {
        int n = s.length();

        boolean[][] palindrome = new boolean[n][n];

        for (int len = 1; len <= n; len++) {
            for (int i = 0; i + len <= n; i++) {
                int j = i + len - 1;

                if (len == 1) palindrome[i][j] = true;
                else if (len == 2) palindrome[i][j] = (s.charAt(i) == s.charAt(j));
                else palindrome[i][j] = (s.charAt(i) == s.charAt(j)) && palindrome[i + 1][j - 1];
            }
        }

        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            if (palindrome[0][i]) dp[i] = 0;
            else {
                dp[i] = i;

                for (int j = 1; j <= i; j++) {
                    if (palindrome[j][i]) {
                        dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                    }
                }
            }
        }

        return dp[n - 1];
    }
}