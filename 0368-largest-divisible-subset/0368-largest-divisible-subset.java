class Solution {
    public static List<Integer> largestDivisibleSubset(int[] nums) {
        int[] len = new int[nums.length]; // the length of largestDivisibleSubset that ends with element i
    int[] prev = new int[nums.length]; // the previous index of element i in the largestDivisibleSubset ends with element i
    
    Arrays.sort(nums);
    
    int max = 0;
    int index = -1;

    for (int i = 0; i < nums.length; i++){
        len[i] = 1;
        prev[i] = -1;
        for (int j = i - 1; j >= 0; j--){
            if (nums[i] % nums[j] == 0 && len[j] + 1 > len[i]){
                len[i] = len[j] + 1;
                prev[i] = j;
            }
        }
        if (len[i] > max){
            max = len[i];
            index = i;
        }
    }
    List<Integer> res = new ArrayList<Integer>();
    while (index != -1){
        res.add(nums[index]);
        index = prev[index];
    }
    return res;
    }
}