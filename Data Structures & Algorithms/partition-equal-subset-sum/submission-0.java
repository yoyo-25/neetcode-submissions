class Solution {
    public boolean solve(int[] nums, int sum, int i, int[][] dp){
        if(sum == 0) return true;
        if(sum < 0 || i < 0) return false;

        if(dp[i][sum] != -1) return dp[i][sum] == 1;
        if(nums[i] > sum) return (dp[i][sum] = (solve(nums, sum, i-1, dp)) ? 1:0) == 1;

        boolean choose = solve(nums, sum-nums[i], i-1, dp);
        boolean ignore = solve(nums, sum, i-1, dp);

        return (dp[i][sum] = (choose || ignore) ? 1:0) == 1;
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;

        for(int i=0; i<nums.length; i++){
            sum += nums[i];
        }

        if(sum % 2 != 0) return false;

        sum = sum/2;

        int[][] dp = new int[nums.length][sum+1];

        for(int i=0; i<nums.length; i++){
            Arrays.fill(dp[i], -1);
        }

        return solve(nums, sum, nums.length-1, dp);
    }
}
