//https://leetcode.com/problems/minimum-speed-to-arrive-on-time/solutions/
class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int n = dist.length;
        int start = 1;
        int end = 10000000;
        int ans =-1;
        while(start <= end){
            int mid = start + (end-start)/2;
            double currTime =0;
            for(int i=0; i<n-1; i++){
                currTime += Math.ceil((double)dist[i]/mid);
            }
            currTime += (double)dist[n-1]/mid;
            if(currTime <= hour){
                ans =mid;
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return ans;
    }
}
