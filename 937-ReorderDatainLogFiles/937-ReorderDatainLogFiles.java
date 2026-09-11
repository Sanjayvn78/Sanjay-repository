// Last updated: 9/11/2026, 10:07:00 PM
1class Solution {
2    public boolean isMonotonic(int[] nums) {
3        boolean isIncreasing = true;
4        boolean isDecreasing = true;
5        for (int i =1; i<nums.length; i++){
6            if (nums[i]>nums[i-1]){
7                isDecreasing = false;
8            }
9            else if (nums[i]<nums[i-1]){
10                isIncreasing = false;
11            }
12            if(!isIncreasing && !isDecreasing){
13                return false;
14            }
15        }
16        return true;
17    }
18}