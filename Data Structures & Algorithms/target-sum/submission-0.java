class Solution {
    public int solve(int[] nums, int sum, int total, int target, int i, int[][] dp){
        if(i<0){
            return sum == target ? 1:0;
        }

        if(dp[i][sum+total] != -1) return dp[i][sum+total];
        
        int add = solve(nums, sum+nums[i], total, target, i-1, dp);
        int sub = solve(nums, sum-nums[i], total, target, i-1, dp);

        return dp[i][sum+total] = add+sub;
    }

    public int findTargetSumWays(int[] nums, int target) {
        int total = 0;

        for(int i=0; i<nums.length; i++){
            total+=nums[i];
        }

        int[][] dp = new int[nums.length][(2*total)+1];

        for(int i=0; i<nums.length; i++){
            Arrays.fill(dp[i], -1);
        }

        return solve(nums, 0, total, target, nums.length-1, dp);
    }
}
