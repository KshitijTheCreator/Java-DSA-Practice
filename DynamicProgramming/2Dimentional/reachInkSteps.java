//https://leetcode.com/contest/weekly-contest-309/problems/number-of-ways-to-reach-a-position-after-exactly-k-steps/
//MEMOIZATION SOLUTION:
class Solution {
    // int mod = 1000000007;
    Integer[][] dp;
    public int numberOfWays(int startPos, int endPos, int k) {
        dp = new Integer[3000][k+1];
        return helper(startPos, endPos, k);
    }
    private int helper(int startPos, int endPos, int k){
        if(startPos == endPos && k==0){
            return 1;
        }
        if(k==0){
            return 0;
        }
        int ans =0;
        if(dp[startPos+1000][k] != null){
            return dp[startPos+1000][k];
        }
        
        int right = helper(startPos+1, endPos, k-1) ;
        int left = helper(startPos-1, endPos, k-1) ;
        
        ans = (left+right)%((int)1e9+7);
        dp[startPos+1000][k] = ans;
        return dp[startPos+1000][k];
    }
}
