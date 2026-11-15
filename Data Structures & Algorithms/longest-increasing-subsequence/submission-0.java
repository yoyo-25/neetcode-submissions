class Solution {
    public int solve(int[] nums, int n, int i, int prev, int[][] dp){
        if(i == n) return 0;

        if(dp[i][prev+1] != -1) return dp[i][prev+1];

        int include = 0;
        
        if(prev == -1 || nums[prev] < nums[i]){
            include = 1+solve(nums, n, i+1, i, dp);
        }

        int exclude = solve(nums, n, i+1, prev, dp);

        return dp[i][prev+1] = Math.max(include, exclude);
    }

    public int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];

        for(int i=0; i<nums.length; i++){
            Arrays.fill(dp[i], -1);
        }

        return solve(nums, nums.length, 0, -1, dp);
    }
}
