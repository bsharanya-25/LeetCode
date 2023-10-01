class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> resultSet = new HashSet<>();

        // Add elements from nums1 to set1
        for (int num : nums1) {
            set1.add(num);
        }

        // Check for intersection while iterating through nums2
        for (int num : nums2) {
            if (set1.contains(num)) {
                resultSet.add(num);
            }
        }

        // Convert the resultSet to an array
        int[] result = new int[resultSet.size()];
        int index = 0;
        for (int num : resultSet) {
            result[index++] = num; //initially index is 0 and after storing current num it increment to 1
        }

        return result;
    }
}