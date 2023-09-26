class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int[] piles = new int[n]; // To represent the piles of cards
        int len = 0; // Length of the LIS

        for (int num : nums) {
            int left = 0, right = len;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (piles[mid] < num) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            if (left == len) {
                piles[len++] = num; // Create a new pile
            } else {
                piles[left] = num; // Place the card in an existing pile
            }
        }

        return len;
    }
}
