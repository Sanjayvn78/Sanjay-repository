// Last updated: 8/13/2026, 9:14:58 AM
class Solution {
    // Finds max turbulent length assuming starting comparison
    // startGreater = true  -> arr[0] > arr[1]
    // startGreater = false -> arr[0] < arr[1]
    private int getMaxLen(int[] nums, boolean startGreater) {
        int maxLen = 1;
        int currLen = 1;
        boolean expectGreater = startGreater;
        for (int i = 0; i < nums.length - 1; i++) {
            // Reset expected relation when starting new subarray based on index
            if (currLen == 1) {
                expectGreater = (i % 2 == 0) ? startGreater : !startGreater;
            }
            if (expectGreater) {
                if (nums[i] > nums[i + 1]) {
                    currLen++;
                    expectGreater = false; // flip sign
                } else {
                    currLen = 1; // restart
                }
            } else {
                if (nums[i] < nums[i + 1]) {
                    currLen++;
                    expectGreater = true; // flip sign
                } else {
                    currLen = 1; // restart
                }
            }
            maxLen = Math.max(maxLen, currLen);
        }
        return maxLen;
    }

    public int maxTurbulenceSize(int[] nums) {
        // Try both starting patterns
        return Math.max(getMaxLen(nums, true), getMaxLen(nums, false));
    }
}