// Last updated: 8/13/2026, 9:15:22 AM
class Solution {
    public int findMaxLength(int[] nums) {
        int n=nums.length;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0) nums[i]=-1;
            }
        int sum=0;
        int res=0;
        HashMap<Integer,Integer>map=new HashMap<>();
        map.put(0,-1);
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(map.containsKey(sum))
            res=Math.max(res,i-map.get(sum));
            else
            map.put(sum,i);
        }
        return res;
    }
}