# Last updated: 9/11/2026, 9:50:15 PM
1class Solution:
2    def firstMissingPositive(self, nums: List[int]) -> int:
3        # Function to swap elements in the array
4        def swap(arr, i, j):
5            arr[i], arr[j] = arr[j], arr[i]
6        
7        n = len(nums)
8        
9        # Place each positive integer i at index i-1 if possible
10        for i in range(n):
11            while 0 < nums[i] <= n and nums[i] != nums[nums[i] - 1]:
12                swap(nums, i, nums[i] - 1)
13        
14        # Find the first missing positive integer
15        for i in range(n):
16            if nums[i] != i + 1:
17                return i + 1
18        
19        # If all positive integers from 1 to n are present, return n + 1
20        return n + 1