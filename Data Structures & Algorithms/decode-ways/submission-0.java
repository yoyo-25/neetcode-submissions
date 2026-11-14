class Solution {
    public int solve(String s, int i, int n, int[] dp){
        if(i<=n && s.charAt(i) == '0') return dp[i] = 0;
        if(i >= n) return 1;

        if(dp[i] != -1) return dp[i];

        int oneWay = 0;
        int twoWay = 0;

        if(s.charAt(i) != '0') oneWay = solve(s, i+1, n, dp);
        if(i <= n-1 && ((s.charAt(i)-'0')*10) + (s.charAt(i+1)-'0') <= 26) twoWay = solve(s, i+2, n, dp);

        return dp[i] = oneWay+twoWay;
    }

    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[s.length()];

        Arrays.fill(dp, -1);

        return solve(s, 0, n-1, dp);
    }
}
