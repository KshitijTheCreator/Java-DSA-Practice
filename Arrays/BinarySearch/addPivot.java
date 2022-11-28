//https://leetcode.com/problems/find-the-pivot-integer/
class Solution {
    public int pivotInteger(int n) {
        int ans =-1;
        int start= 1;
        int end = n;
        

        
        while(start <= end){
            int mid = (start + end)/2;
            int sum1 =0;
            int sum2 =0;
            
            for(int i=1; i<=mid; i++){
                sum1+=i;
            }
            for(int i=mid; i<=n; i++){
                sum2 +=i;
            }
            
            if(sum1 == sum2){
                ans = mid;
                break;
            }    
            else if(sum1 < sum2){
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        return ans;
    }
    
}
