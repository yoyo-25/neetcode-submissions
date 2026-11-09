class Solution {
    public int solve(int n, int[] dp){
        if(n<0) return 0;
        if(n==0) return 1;

        if(dp[n] != -1) return dp[n];

        int oneStep = solve(n-1, dp);
        int twoStep = solve(n-2, dp);

        return dp[n] = oneStep+twoStep;
    }

    public int climbStairs(int n) {
        int[] dp = new int[n+1];

        for(int i=0; i<n; i++){
            Arrays.fill(dp, -1);
        }

        return solve(n, dp);
    }
}
