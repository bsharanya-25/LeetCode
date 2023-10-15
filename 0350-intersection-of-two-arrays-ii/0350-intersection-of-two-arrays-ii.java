class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> countMap = new HashMap<>();
        ArrayList<Integer> resultList = new ArrayList<>();

        // Count occurrences of elements in the first array
        for (int i : nums1) {
            countMap.put(i, countMap.getOrDefault(i, 0) + 1);
        }

        // Find the intersection in the second array
        for (int j : nums2) {
            if (countMap.containsKey(j) && countMap.get(j) > 0) {
                resultList.add(j);
                countMap.put(j, countMap.get(j) - 1);
            }
        }

        // Convert the result list to an array
        int[] resultArray = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            resultArray[i] = resultList.get(i);
        }

        return resultArray;
    }
}
