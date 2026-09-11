// Last updated: 9/11/2026, 9:56:41 PM
1class Solution {
2    public int majorityElement(int[] nums) {
3        Arrays.sort(nums);
4        int n = nums.length;
5        return nums[n/2];
6    }
7}