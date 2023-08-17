class Solution {
    public List<List<String>> partition(String s) {
        List < List < String >> res = new ArrayList < > ();
        List < String > curr = new ArrayList < > ();
        palindromePartition(0, s, curr, res);
        return res;
    }
    static void palindromePartition(int index, String s, List < String > curr, List < List < String >> res ){
        if(index == s.length()){
            res.add(new ArrayList <> (curr));
            return;
        }
        for(int i= index;i<s.length();i++){
            if(isPalindrome(s,index,i)){
                curr.add(s.substring(index, i + 1));
                palindromePartition(i + 1, s, curr, res);
                curr.remove(curr.size() - 1);
              }  
            }
        }
    public static boolean isPalindrome(String s, int start, int end){
        while(start<=end){
            if(s.charAt(start++)!=s.charAt(end--))
            return false;
        }
        return true;
    }
}