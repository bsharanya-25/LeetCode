class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        // hashmap approach --> Optimised
        HashMap<Integer,Integer> map = new HashMap<>(); //val : index
        int n = nums.length;
        
        // Find the complement
        for (int i = 0; i < n; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                return new int[]{i, map.get(diff)};
            }
            else{
                map.put(nums[i],i); //if not key found, put it in the table
            }
        }
        return new int[]{}; // No solution found

    }
    }







        // HashTable approach --> Better
        // Map<Integer, Integer> numMap = new HashMap<>();
        // int n = nums.length;
        // // Build the hash table
        // for (int i = 0; i < n; i++) {
        //     numMap.put(nums[i], i); // ele and its index
        // }
        // // Find the complement
        // for (int i = 0; i < n; i++) {
        //     int complement = target - nums[i];
        //     if (numMap.containsKey(complement) && numMap.get(complement) != i) {
        //         return new int[]{i, numMap.get(complement)};
        // return new int[]{}; // No solution found
        //tc: O(n+n) =~ o(n)


        // 2 pointer approach --> Brute force
        // for(int i = 0; i < nums.length; i++){
        //     for(int j = i+1; j < nums.length; j++){
        //         if(nums[i] + nums[j] == target){
        //             return new int[]{i,j}; 
        //         }
        //     }
        // }
        // return new int[]{}; //no sol found
        // tc:O(n*n)
    