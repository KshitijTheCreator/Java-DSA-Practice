//https://leetcode.com/problems/minimum-penalty-for-a-shop/
class Solution {
    public int bestClosingTime(String s) {
        char[] arr =s.toCharArray();
        int n = arr.length;
        int[] suffixY = new int[n+1];
        int[] prefixN = new int[n+1];
        
        int countHelper =0;
        for(int i=n-1; i>=0; i--){
            if(arr[i] == 'Y'){
                countHelper++;
            }
            suffixY[i] = countHelper;
        }
        countHelper =0;
        
        for(int i=0; i< n; i++){
            if(arr[i] == 'N'){
                countHelper++;
            }
            prefixN[i+1]=countHelper;
        }
        
        int min = Integer.MAX_VALUE;
        int[] res = new int[n+1];
        for(int i=0; i< n+1; i++){
            res[i] = prefixN[i]+suffixY[i];
            min = Math.min(res[i], min);
        }
        
        int ans =0;
        for(int i=0; i<n+1; i++){
            if(res[i] == min){
                ans=i;
                break;
            }
        }
        return ans;
    }
}
