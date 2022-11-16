// https://leetcode.com/problems/climbing-stairs/submissions/844760856/
//MEMOIZATION 
class Solution {
    Integer[] dp;
    public int climbStairs(int n) {
        dp = new Integer[n+1];
        int ans =0;
        for(int i=1; i<= n; i++){
            ans = ans + helper(i);
        }
        return helper(n);
    }
    private int helper(int n){
        if(n< 0){
            return 0;
        }
        if(n== 0){
            return 1;
        }
        if(dp[n] != null){
            return dp[n];
        }
        int movOneStep = helper(n-1);
        int movTwoStep = helper(n-2);

        return dp[n] = movOneStep + movTwoStep;

    }
}

//TABULATION
class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n +1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
