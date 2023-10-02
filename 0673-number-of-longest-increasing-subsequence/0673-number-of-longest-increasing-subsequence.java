class Solution {
    public int findNumberOfLIS(int[] nums) {
      int n = nums.length;
        if (n == 0) {
            return 0;
        }

        int[] lengths = new int[n]; // lengths[i] stores the length of LIS ending at nums[i]
        int[] counts = new int[n];  // counts[i] stores the count of LIS ending at nums[i]
        Arrays.fill(lengths, 1);
        Arrays.fill(counts, 1);

        int maxLen = 1;
        int maxCount = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (lengths[i] < lengths[j] + 1) {
                        lengths[i] = lengths[j] + 1;
                        counts[i] = counts[j];
                    } else if (lengths[i] == lengths[j] + 1) {
                        counts[i] += counts[j];
                    }
                }
            }
            maxLen = Math.max(maxLen, lengths[i]);
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            if (lengths[i] == maxLen) {
                result += counts[i];
            }
        }

        return result;
    }
}