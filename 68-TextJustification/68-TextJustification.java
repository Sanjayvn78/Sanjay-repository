// Last updated: 9/11/2026, 9:53:20 PM
1class Solution {
2     public List<String> fullJustify(String[] words, int maxWidth) {
3        int left = 0; List<String> result = new ArrayList<>();
4        
5        while (left < words.length) {
6            int right = findRight(left, words, maxWidth);
7            result.add(justify(left, right, words, maxWidth));
8            left = right + 1;
9        }
10        
11        return result;
12    }
13    
14    private int findRight(int left, String[] words, int maxWidth) {
15        int right = left;
16        int sum = words[right++].length();
17        
18        while (right < words.length && (sum + 1 + words[right].length()) <= maxWidth)
19            sum += 1 + words[right++].length();
20            
21        return right - 1;
22    }
23    
24    private String justify(int left, int right, String[] words, int maxWidth) {
25        if (right - left == 0) return padResult(words[left], maxWidth);
26        
27        boolean isLastLine = right == words.length - 1;
28        int numSpaces = right - left;
29        int totalSpace = maxWidth - wordsLength(left, right, words);
30        
31        String space = isLastLine ? " " : blank(totalSpace / numSpaces);
32        int remainder = isLastLine ? 0 : totalSpace % numSpaces;
33        
34        StringBuilder result = new StringBuilder();
35        for (int i = left; i <= right; i++)
36            result.append(words[i])
37                .append(space)
38                .append(remainder-- > 0 ? " " : "");
39        
40        return padResult(result.toString().trim(), maxWidth);
41    }
42    
43    private int wordsLength(int left, int right, String[] words) {
44        int wordsLength = 0;
45        for (int i = left; i <= right; i++) wordsLength += words[i].length();
46        return wordsLength;
47    }
48    
49    private String padResult(String result, int maxWidth) {
50        return result + blank(maxWidth - result.length());
51    }
52    
53    private String blank(int length) {
54        return new String(new char[length]).replace('\0', ' ');
55    }
56}