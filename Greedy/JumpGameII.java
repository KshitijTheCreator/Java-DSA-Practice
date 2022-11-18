//https://leetcode.com/problems/jump-game-ii/description/
class Solution {
    public int jump(int[] nums) {
        int currMax =0, maxReach =0;
        int jumps =0;
        int n = nums.length;
        for(int i=0; i< n-1;++i){
            maxReach = Math.max(maxReach, i+ nums[i]);
            if(i == currMax){
                jumps++;
                currMax = maxReach;
            }
        }
        return jumps;        
    }
}
