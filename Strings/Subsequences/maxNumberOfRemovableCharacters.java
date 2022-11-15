[link](https://leetcode.com/problems/maximum-number-of-removable-characters/description/)
class Solution {
    public int maximumRemovals(String s, String p, int[] r) {
        char[] str = s.toCharArray();
        char[] ptr = p.toCharArray();
        
        int start = 0;
        int end =r.length -1;
        
        while(start <= end){
            int mid = start + (end - start)/2;
            for(int i=start; i<= mid; i++){
                //acts as the removal 
                str[r[i]] = '*'; 
            }
            if(isSubsequence(str, ptr)){
                start = mid+1;
            }
            else{
                end = mid -1;
                for(int i=start; i<=mid; i++){
                    // now we again unmark the previously removed indices..
                    // as now we are searching on latter half
                    
                    str[r[i]] = s.charAt(r[i]); 
                }
            }
        }
        return start;
    }
    
    private boolean isSubsequence(char[] s, char[] p){
        int i =0;
        int j =0;
        
        while(i <s.length && j < p.length){
            if(s[i] == p[j]){
                j++;
            }
            i++;
        }
        return j == p.length;
    }
}
