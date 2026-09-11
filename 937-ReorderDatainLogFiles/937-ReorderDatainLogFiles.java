// Last updated: 9/11/2026, 10:04:32 PM
1class Solution {
2    public int mctFromLeafValues(int[] arr) {
3         Stack<Integer>stack = new Stack<>();
4         stack.push(Integer.MAX_VALUE);
5         int ans = 0;
6         for(int nums:arr){
7            while(stack.peek()<=nums){
8             int top = stack.pop();
9             ans+=top*Math.min(stack.peek(),nums);
10            }
11            stack.push(nums);
12         }
13         while(stack.size()>2){
14            ans+=stack.pop()*stack.peek();
15         }   
16         return ans;
17    }  
18
19}