class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int left  = 0;
        int right = letters.length - 1;
        char res = letters[0];

        while(left<=right){
            int mid = left +(right-left)/2;
            if (letters[mid] <= target) {
                left = mid + 1; // Move to the right half
            } else {
                res = letters[mid]; // Update result if current element is greater than target
                right = mid - 1; // Move to the left half
            }
        }
        //Return the correct element using letters[left % letters.length] to handle the case when left is greater than the array length.
        return letters[left % letters.length];
    }
}