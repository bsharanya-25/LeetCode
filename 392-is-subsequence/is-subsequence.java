class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.length()==0){
            return true;
        }
        int t_pointer=0;
        int s_pointer=0;

        while(t_pointer < t.length()){
            if(s.charAt(s_pointer)==t.charAt(t_pointer)){
                s_pointer++; 

                if(s_pointer == s.length()){
                    return true;
                }
            }
            t_pointer++;
        }
    return false;
    }
}