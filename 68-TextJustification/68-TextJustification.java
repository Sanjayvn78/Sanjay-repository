// Last updated: 9/11/2026, 9:55:44 PM
1class Solution {
2    public int findPeakElement(int[] nums) {
3        int l = 0,
4            r = nums.length-1;
5
6        while(l < r) {
7            int mid = l + (r - l) / 2;
8
9            if(nums[mid] > nums[mid+1]) {
10                r = mid;
11            } else {
12                l = mid + 1;
13            }
14        }
15        return l;
16    }
17}