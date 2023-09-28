class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        
        for (int num : nums1) {
            set1.add(num);
        }
        
        for (int num : nums2) {
            set2.add(num);
        }
        
        // Initialize result list with 2 empty sublists that we will return
        List<List<Integer>> res = new ArrayList<>();
		res.add(new ArrayList<>());  // Adds the first sublist
        res.add(new ArrayList<>());  // Adds the second sublist

        // just iterate to all elements of set1
		for(int num : set1){    

            // add those elements to first sublist of result list, which are not in set2.
			if(!set2.contains(num)){ 
                res.get(0).add(num); 
            }      
		}
        //same with set2
		for(int num : set2){   
            
			if(!set1.contains(num)){ 
                res.get(1).add(num); 
            }      
		}
		return res;
    }
}