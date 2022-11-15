class Solution {
    public boolean isSubsequence(String s, String t) {
        int j = 0;
        
        for(int i=0;i<t.length();i++){
            if(j < s.length() && t.charAt(i) == s.charAt(j)) j++;
        }
        
        return j == s.length();
    }
}
