// Last updated: 8/13/2026, 9:14:53 AM
import java.util.*;

class Solution {
    public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
        Map<Integer, Integer> rowCnt = new HashMap<>();
        Map<Integer, Integer> colCnt = new HashMap<>();
        Map<Integer, Integer> diagCnt = new HashMap<>();
        Map<Integer, Integer> antiDiagCnt = new HashMap<>();
        Set<Long> lampSet = new HashSet<>();

        // Initialize lamps
        for (int[] lamp : lamps) {
            int r = lamp[0], c = lamp[1];
            long code = (long) r * n + c;
            if (lampSet.add(code)) {
                rowCnt.put(r, rowCnt.getOrDefault(r, 0) + 1);
                colCnt.put(c, colCnt.getOrDefault(c, 0) + 1);
                diagCnt.put(r - c, diagCnt.getOrDefault(r - c, 0) + 1);
                antiDiagCnt.put(r + c, antiDiagCnt.getOrDefault(r + c, 0) + 1);
            }
        }

        int[] ans = new int[queries.length];
        for (int k = 0; k < queries.length; k++) {
            int r = queries[k][0], c = queries[k][1];

            // Check if illuminated
            if (rowCnt.getOrDefault(r, 0) > 0 || colCnt.getOrDefault(c, 0) > 0 ||
                diagCnt.getOrDefault(r - c, 0) > 0 || antiDiagCnt.getOrDefault(r + c, 0) > 0) {
                ans[k] = 1;
            } else {
                ans[k] = 0;
            }

            // Turn off 3x3 adjacent lamps
            for (int i = r - 1; i <= r + 1; i++) {
                for (int j = c - 1; j <= c + 1; j++) {
                    if (i < 0 || i >= n || j < 0 || j >= n) continue;
                    long code = (long) i * n + j;
                    if (lampSet.remove(code)) {
                        rowCnt.put(i, rowCnt.get(i) - 1);
                        colCnt.put(j, colCnt.get(j) - 1);
                        diagCnt.put(i - j, diagCnt.get(i - j) - 1);
                        antiDiagCnt.put(i + j, antiDiagCnt.get(i + j) - 1);
                    }
                }
            }
        }
        return ans;
    }
}