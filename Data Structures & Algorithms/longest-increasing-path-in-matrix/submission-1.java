class Solution {
    public int solve(int[][] matrix, int m, int n, int i, int j, int[][] dp){
        if(i<0 || j<0) return Integer.MIN_VALUE;
        if(i==m || j==n) return Integer.MIN_VALUE;

        if(dp[i][j] != -1) return dp[i][j];

        int up = 1;
        if(i>0 && matrix[i-1][j] > matrix[i][j]){
            up = 1+solve(matrix, m, n, i-1, j, dp);
        }

        int down = 1;
        if(i<m-1 && matrix[i+1][j] > matrix[i][j]){
            down = 1+solve(matrix, m, n, i+1, j, dp);
        }

        int right = 1;
        if(j<n-1 && matrix[i][j+1] > matrix[i][j]){
            right = 1+solve(matrix, m, n, i, j+1, dp);
        }
        int left = 1;
        if(j>0 && matrix[i][j-1] > matrix[i][j]){
            left = 1+solve(matrix, m, n, i, j-1, dp);
        }

        return dp[i][j] = Math.max(up, Math.max(down, Math.max(right, left)));
    }

    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];

        for(int i=0; i<matrix.length; i++){
            Arrays.fill(dp[i], -1);
        }

        int ans = 0;

        for(int i=0; i<m; i++){
            for(int j = 0; j<n; j++){
                ans = Math.max(ans, solve(matrix, m, n, i, j, dp));
            }
        }

        return ans;
    }
}
