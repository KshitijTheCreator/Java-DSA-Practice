// https://leetcode.com/problems/count-number-of-homogenous-substrings/description/
class Solution {
    public int countHomogenous(String s) {
        int count =0, res =0;
        for(int i=0; i< s.length(); i++){
            if(i>0 && s.charAt(i-1)==s.charAt(i)){
                count++;
            }
            else{
                count =1;
            }
            res = (res+count)%1000000007;
        }
        return res;
    }
}
