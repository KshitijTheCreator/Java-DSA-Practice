// https://leetcode.com/problems/find-the-k-beauty-of-a-number/
class Solution {
    public int divisorSubstrings(int num, int k) {
        int ans =0; 
        int start =0;
        String s = num+"";
        for(int i= k-1; i<s.length(); i++){
            String str = s.substring(start, i+1);
            int n = Integer.valueOf(str);
            if(n == 0){
                start++;
                continue;
            }
            if(num % n == 0){
                ans++;
            }
            start++;
        }
        return ans;
    }
}
