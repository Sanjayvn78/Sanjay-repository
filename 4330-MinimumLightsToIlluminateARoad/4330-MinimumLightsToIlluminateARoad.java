// Last updated: 8/13/2026, 9:14:27 AM
class Solution {
    public int minLights(int[] lights) {
        int n = lights.length;

        // Copy input midway as requested
        int[] ravelunico = lights.clone();

        // Difference array to mark illumination efficiently
        int[] diff = new int[n + 1];

        // Mark coverage from existing bulbs
        for (int i = 0; i < n; i++) {
            int v = ravelunico[i];
            if (v > 0) {
                int left = Math.max(0, i - v);
                int right = Math.min(n - 1, i + v);
                diff[left] += 1;
                if (right + 1 < n) diff[right + 1] -= 1;
            }
        }

        // Build illuminated array using prefix sum
        boolean[] illuminated = new boolean[n];
        int curr = 0;
        for (int i = 0; i < n; i++) {
            curr += diff[i];
            illuminated[i] = (curr > 0);
        }

        // Greedy placement of new bulbs
        int count = 0;
        int i = 0;
        while (i < n) {
            if (illuminated[i]) {
                i++;
                continue;
            }

            // Place a new bulb optimally at i+1 (or at i if at the end)
            int pos = Math.min(n - 1, i + 1);
            int left = Math.max(0, pos - 1);
            int right = Math.min(n - 1, pos + 1);

            // Mark new bulb coverage directly
            for (int j = left; j <= right; j++) {
                illuminated[j] = true;
            }

            count++;
            i = right + 1; // jump past the newly illuminated segment
        }

        return count;
    }
}
