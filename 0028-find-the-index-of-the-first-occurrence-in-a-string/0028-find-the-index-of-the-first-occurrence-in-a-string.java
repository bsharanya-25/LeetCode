class Solution {
    public int strStr(String haystack, String needle) {
       if(needle.isEmpty()){
           return -1;
       } 
        int hLen = haystack.length(); //total length of haystack
        int nLen = needle.length();   //total length of needle

        for (int i = 0; i <= hLen-nLen; i++) {     
            if (haystack.substring(i, i + nLen).equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}