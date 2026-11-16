class Solution {
    public int solve(String s, String t, int n, int m, int i, int j, int[][] dp){
        if(i == n){
            return j==m ? 1:0;
        }
        if(j==m) return 1;

        if(dp[i][j] != -1) return dp[i][j];

        int choose = 0;

        if(s.charAt(i) == t.charAt(j)){
            choose = solve(s, t, n, m, i+1, j+1, dp);
        }

        int ignore = solve(s, t, n, m, i+1, j, dp);

        return dp[i][j] = choose+ignore;
    }

    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length()+1][t.length()+1];

        for(int i=0; i<s.length(); i++){
            Arrays.fill(dp[i], -1);
        }

        return solve(s, t, s.length(), t.length(), 0, 0, dp);
    }
}
