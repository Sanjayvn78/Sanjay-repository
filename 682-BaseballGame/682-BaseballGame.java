// Last updated: 8/13/2026, 9:15:09 AM
import java.util.*;

class Solution {
    public int calPoints(String[] operations) {
        List<Integer> result = new ArrayList<>();

        for (String op : operations) {
            if (op.equals("+")) {
                int n = result.size();
                result.add(result.get(n - 1) + result.get(n - 2));
            } 
            else if (op.equals("D")) {
                result.add(result.get(result.size() - 1) * 2);
            } 
            else if (op.equals("C")) {
                result.remove(result.size() - 1);
            } 
            else {
                result.add(Integer.parseInt(op));
            }
        }

        int sum = 0;
        for (int score : result) {
            sum += score;
        }

        return sum;
    }
}