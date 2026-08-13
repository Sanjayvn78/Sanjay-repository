// Last updated: 8/13/2026, 9:15:11 AM
class Solution {
    public boolean checkValidString(String s) {
        int low = 0, high = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                low++;
                high++;
            } else if (ch == ')') {
                low--;
                high--;
            } else { // '*'
                low--;   // treat '*' as ')'
                high++;  // treat '*' as '('
            }

            if (high < 0) {
                return false; // too many ')'
            }

            low = Math.max(low, 0);
        }

        return low == 0;
    }
}