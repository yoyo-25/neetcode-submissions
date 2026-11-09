class Solution {
    public int solve(int[] nums, int n, int i, int[] dp){
        if(i>n) return 0;
        if(i == n) return nums[i];

        if(dp[i] != -1) return dp[i];

        int steal = nums[i]+solve(nums, n, i+2, dp);
        int spare = solve(nums, n, i+1, dp);

        return dp[i] = Math.max(steal, spare);
    }

    public int rob(int[] nums) {
        if(nums.length < 2) return nums[0];

        int[] dp1 = new int[nums.length];
        int[] dp2 = new int[nums.length];

        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);

        int case1 = solve(nums, nums.length-2, 0, dp1);
        int case2 = solve(nums, nums.length-1, 1, dp2);

        return Math.max(case1, case2);
    }
}
