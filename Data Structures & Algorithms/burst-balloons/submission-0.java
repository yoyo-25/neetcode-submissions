class Solution {
    public int solve(int[] nums, int i, int j, int[][] dp){
        if(i+1 == j) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        int ans = 0;

        for(int k=i+1; k<j; k++){
            int points = nums[i]*nums[k]*nums[j];

            int left = solve(nums, i, k, dp);
            int right = solve(nums, k, j, dp);

            ans = Math.max(ans, left+right+points);
        }

        return dp[i][j] = ans;
    }

    public int maxCoins(int[] nums) {
        int[] arr = new int[nums.length+2];
        int[][] dp = new int[nums.length+2][nums.length+2];

        arr[0] = 1;
        arr[nums.length+1] = 1;

        for(int i=0; i<nums.length; i++){
            arr[i+1] = nums[i];
        }

        for(int i=0; i<arr.length; i++){
            Arrays.fill(dp[i], -1);
        }

        return solve(arr, 0, nums.length+1, dp);
    }
}
