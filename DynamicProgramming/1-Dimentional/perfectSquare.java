//https://leetcode.com/problems/perfect-squares/description/
class Solution {
    Integer[] dp;
    public int numSquares(int n) {
        dp = new Integer[n+1];
        return dfs(n);
    }
    private int dfs(int n){
        if(n == 0){
            return 0;
        }
        if(dp[n] != null){
            return dp[n];
        }
        int ans =n;
        for(int i=1; i*i <= n; i++){
            ans = Math.min(ans, 1+dfs(n-i*i));
        }
        return dp[n] =ans;
    }
}
