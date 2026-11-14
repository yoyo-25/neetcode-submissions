class Solution {
    public boolean solve(String s, int i, HashSet<String> set, Boolean[] dp){
        if(i == s.length()) return true;

        if(dp[i] != null) return dp[i];

        for(int j=i+1; j<=s.length(); j++){
            String sub = s.substring(i, j);

            if(set.contains(sub) && solve(s, j, set, dp)){
                return dp[i] = true;
            }
        }

        return dp[i] = false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        Boolean[] dp = new Boolean[s.length()];

        return solve(s, 0, set, dp);

    }
}
