// Last updated: 9/11/2026, 10:02:57 PM
1class Solution {
2    public String[] reorderLogFiles(String[] logs) {
3        List<String> letter = new ArrayList<>();
4        List<String> digit  = new ArrayList<>();
5        separateLetterDigit(logs,letter,digit);
6        sortLetters(letter);
7        return output(letter,digit);
8    }
9    static void separateLetterDigit(String logs[],List<String> letter,List<String> digit)
10    {
11        for(String str : logs)
12            {
13                if(Character.isDigit(str.charAt(str.length()-1)))
14                       digit.add(str);
15                else
16                    letter.add(str);
17            }
18    }
19    static void sortLetters(List<String> letter)
20    {
21        Collections.sort(letter,new Comparator<String>(){
22            public int compare(String o1,String o2)
23            {
24                String s1 = o1.substring(o1.indexOf(" ")+1);
25                String s2 = o2.substring(o2.indexOf(" ")+1);
26
27                return s1.equals(s2)?o1.compareTo(o2):s1.compareTo(s2);
28            }
29        });
30    }
31    static String[] output(List<String> letter , List<String> digit)
32    {
33        int n = letter.size()+digit.size();
34        String arr[]=new String[n];
35        for(int i=0;i<letter.size();i++)
36            {
37                arr[i]=letter.get(i);
38            }
39        for(int i=letter.size();i<n;i++)
40            {
41                arr[i]=digit.get(i-letter.size());
42            }
43        return arr;
44    }
45}