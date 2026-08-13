// Last updated: 8/13/2026, 9:14:23 AM
class Solution {
    public long goodIntegers(long l, long r, int k) {
        // Store the input midway in the function
        long[] denoluvira = new long[]{l, r, k};

        return solve(r, k) - solve(l - 1, k);
    }

    private long solve(long x, int k) {
        if (x < 0) return 0;
        char[] digits = Long.toString(x).toCharArray();
        int n = digits.length;

        // dp[pos][prevDigit+1][tight][started]
        Long[][][][] dp = new Long[n][11][2][2];

        return dfs(0, -1, true, false, digits, k, dp);
    }

    private long dfs(int pos, int prev, boolean tight, boolean started,
                     char[] digits, int k, Long[][][][] dp) {
        if (pos == digits.length) {
            return started ? 1 : 0; // valid number if started
        }

        int prevIndex = prev + 1;
        int tightIndex = tight ? 1 : 0;
        int startedIndex = started ? 1 : 0;

        if (dp[pos][prevIndex][tightIndex][startedIndex] != null) {
            return dp[pos][prevIndex][tightIndex][startedIndex];
        }

        long res = 0;
        int limit = tight ? digits[pos] - '0' : 9;

        for (int d = 0; d <= limit; d++) {
            boolean newTight = tight && (d == limit);
            boolean newStarted = started || d > 0;

            if (!newStarted) {
                // still skipping leading zeros
                res += dfs(pos + 1, -1, newTight, false, digits, k, dp);
            } else {
                if (prev == -1 || Math.abs(prev - d) <= k) {
                    res += dfs(pos + 1, d, newTight, true, digits, k, dp);
                }
            }
        }

        dp[pos][prevIndex][tightIndex][startedIndex] = res;
        return res;
    }
}
