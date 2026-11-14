class Solution {
    public int solve(int[] coins, int i, int amount, int[][] dp){
        if(i<0 || amount<0) return Integer.MAX_VALUE;

        if(dp[i][amount] != -1) return dp[i][amount];

        if(coins[i] > amount) return dp[i][amount] = solve(coins, i-1, amount, dp);
        if(coins[i] == amount) return dp[i][amount] = 1;

        int ignore = solve(coins, i-1, amount, dp);
        int choose = solve(coins, i, amount-coins[i], dp);

        if(choose != Integer.MAX_VALUE){
            choose += 1;
        }

        return dp[i][amount] = Math.min(choose, ignore);
    }

    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;
        
        int[][] dp = new int[coins.length][amount+1];

        for(int i=0; i<coins.length; i++){
            Arrays.fill(dp[i], -1);
        }

        int ans = solve(coins, coins.length-1, amount, dp);

        return  ans == Integer.MAX_VALUE ? -1:ans;
    }
}
