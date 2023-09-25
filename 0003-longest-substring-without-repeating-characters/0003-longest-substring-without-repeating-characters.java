class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        int start = 0; 
        Map<Character, Integer> charIndex = new HashMap<>();

        for (int end = 0; end < n; end++) {
            char currentChar = s.charAt(end);
            if (charIndex.containsKey(currentChar) && charIndex.get(currentChar) >= start) {
                start = charIndex.get(currentChar) + 1;
            }
            charIndex.put(currentChar, end);
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }
}