// Last updated: 8/13/2026, 9:14:38 AM
class Solution {
    public int maxFrequencyElements(int[] nums) {
        byte[] freq = new byte[101];
        byte max = 0, res = 0;
        for (int n : nums) {
            byte f = ++freq[n];
            if (f > max) {
                max = f; res = f;
            } else if (f == max) 
                res += f;
        }
        return res;
    }
}
