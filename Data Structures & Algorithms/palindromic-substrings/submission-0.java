class Solution {
    public boolean solve(String s, int i, int j, Boolean[][] dp){
        if(i>=j) return true;
        
        if(dp[i][j] != null) return dp[i][j];

        if(s.charAt(i) != s.charAt(j)) return dp[i][j] = false;

        return dp[i][j] = solve(s, i+1, j-1, dp);
    }

    public int countSubstrings(String s) {
        int count = 0;
        Boolean[][] dp = new Boolean[s.length()][s.length()];

        for(int i=0; i<s.length(); i++){
            for(int j=i; j<s.length(); j++){
                if(solve(s, i, j, dp)){
                    count++;
                }
            }
        }

        return count;
    }
}
