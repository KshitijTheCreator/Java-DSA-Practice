//https://leetcode.com/problems/predict-the-winner/
class Solution {
    Integer[][][] dp;
    public boolean PredictTheWinner(int[] nums) {
        dp = new Integer[20][20][2];
        int total = 0;
        int n = nums.length;
        for(int i: nums) total += i;

        int oneScore = recursive(nums, 0, n-1, 0);
        int twoScore = total - oneScore;

        return oneScore >= twoScore;

    }
    private int recursive(int[] nums, int i, int j, int chance){
        if(i > j) return 0;
        if(dp[i][j][chance] != null) return dp[i][j][chance];

        if(chance == 0){
            return dp[i][j][chance] =Math.max(nums[i] + recursive(nums, i+1, j, 1),
             nums[j] + recursive(nums, i, j-1, 1));
        }
        else{
            return dp[i][j][chance] =Math.min(recursive(nums, i+1, j, 0), recursive(nums, i, j-1, 0));
        }
    }
}
