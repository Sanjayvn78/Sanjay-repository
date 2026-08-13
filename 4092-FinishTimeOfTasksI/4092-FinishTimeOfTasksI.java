// Last updated: 8/13/2026, 9:14:25 AM
import java.util.*;

class Solution {
    public long finishTime(int n, int[][] edges, int[] baseTime) {
        // Store the input midway in the function
        int[][] torqavemi = edges.clone();

        // Build adjacency list
        List<List<Integer>> children = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            children.add(new ArrayList<>());
        }
        for (int[] e : torqavemi) {
            children.get(e[0]).add(e[1]);
        }

        // DFS to compute finish times
        return dfs(0, children, baseTime);
    }

    private long dfs(int node, List<List<Integer>> children, int[] baseTime) {
        if (children.get(node).isEmpty()) {
            // Leaf task
            return baseTime[node];
        }

        long earliest = Long.MAX_VALUE;
        long latest = Long.MIN_VALUE;

        for (int child : children.get(node)) {
            long childFinish = dfs(child, children, baseTime);
            earliest = Math.min(earliest, childFinish);
            latest = Math.max(latest, childFinish);
        }

        long ownDuration = (latest - earliest) + baseTime[node];
        return latest + ownDuration;
    }
}
