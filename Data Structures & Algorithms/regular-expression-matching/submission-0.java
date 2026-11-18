class Solution {
    public boolean solve(String s, String p, int n, int m, int i, int j, Boolean[][] dp){
        if(j==m){
            return i==n;
        }

        if(dp[i][j] != null) return dp[i][j];

        if(i==n){
            if(j+1 < m && p.charAt(j+1) == '*'){
                return dp[i][j] = solve(s, p, n, m, i, j+2, dp);
            }

            return false;
        }

        boolean match = s.charAt(i) == p.charAt(j) || p.charAt(j) == '.';

        if(j+1 < m && p.charAt(j+1) == '*'){
            boolean skip = solve(s, p, n, m, i, j+2, dp);
            boolean take = match && solve(s, p, n, m, i+1, j, dp);

            return dp[i][j] = take || skip;
        }

        if(match){
            return dp[i][j] = solve(s, p, n, m, i+1, j+1, dp);
        }

        return dp[i][j] = false;
    }

    public boolean isMatch(String s, String p) {
        Boolean[][] dp = new Boolean[s.length()+1][p.length()+1];

        return solve(s, p, s.length(), p.length(), 0, 0, dp);
    }
}
