//https://leetcode.com/problems/minimum-limit-of-balls-in-a-bag/
class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int start =1;
        int max = 0;
        int ans =0;
        for(int i: nums) max = Math.max(max, i);
        int end =max;
        
        while(start <= end){
            int mid = start + (end-start)/2;
            if(condition(nums, maxOperations, mid)){
                end = mid-1;
                ans = mid;
            }
            else{
                start = mid+1;
            }
        }
        return ans;
    }
    private boolean condition(int[] nums, int maxOperations, int mid){
        int operationsRequired = 0;
        for(int i: nums){
            operationsRequired += (i-1)/mid;
        }
        return operationsRequired <= maxOperations;
    }
}
