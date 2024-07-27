
class Solution {
    private Integer[][] dp;
    public int numDistinct(String s, String t) {
        this.dp = new Integer[s.length()][t.length()];
        return dfs(s.toCharArray(), t.toCharArray(), 0, 0);
    }

    private int dfs(char[] s, char[] t, int i, int j) {
        if (j == t.length) {
            return 1;
        }
        if (s.length - i < t.length - j) {
            return 0;
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }

        int numDistinct = dfs(s, t, i + 1, j);
        if (s[i] == t[j]) {
            numDistinct += dfs(s, t, i + 1, j + 1);
        }
        dp[i][j] = numDistinct;
        return numDistinct;
    }
}