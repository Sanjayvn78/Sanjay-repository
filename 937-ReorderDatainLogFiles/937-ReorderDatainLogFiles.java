// Last updated: 9/11/2026, 10:08:37 PM
1class Solution {
2    public int[][] transpose(int[][] matrix) {
3        int n = matrix.length;
4        int m = matrix[0].length;
5
6       int[][] result = new int[m][n];
7
8        for(int i=0; i<n; i++){
9            for(int j=0; j<m; j++){
10                result[j][i] = matrix[i][j];
11            }
12        }
13        return result;
14    }
15}