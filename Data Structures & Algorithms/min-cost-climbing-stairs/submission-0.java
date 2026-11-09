class Solution {
    public int solve(int[] cost, int i, int n, int[] dp){
        if(i > n) return 0;
        if(i == n) return cost[i];

        if(dp[i] != -1) return dp[i];

        int oneStep = cost[i]+solve(cost, i+1, n, dp);
        int twoStep = cost[i]+solve(cost, i+2, n, dp);

        return dp[i] = Math.min(oneStep, twoStep);
    }

    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];

        Arrays.fill(dp, -1);

        return Math.min(solve(cost, 0, cost.length-1, dp), solve(cost, 1, cost.length-1, dp));
    }
}
