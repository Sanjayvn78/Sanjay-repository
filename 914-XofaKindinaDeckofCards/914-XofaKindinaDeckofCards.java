// Last updated: 9/11/2026, 10:02:16 PM
1class Solution {
2    public boolean hasGroupsSizeX(int[] deck) {
3        
4        HashMap<Integer, Integer> map = new HashMap<>();
5        
6        for(int i=0;i<deck.length;i++){
7            map.put(deck[i], map.getOrDefault(deck[i],0)+1);
8        }
9        
10        int ans=0;
11        
12        for(int key: map.keySet()){
13            
14            ans = gcd(ans, map.get(key));
15        }
16    
17        return ans>=2 ? true : false;
18        
19
20    }
21    
22    public int gcd(int a, int b){
23        if(b==0){
24            return a ;
25        }
26        return gcd(b, a%b);
27    }
28}