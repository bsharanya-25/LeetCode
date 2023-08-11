class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        comb(new ArrayList<>(), nums);
        return res;

    }
    public void comb(List<Integer>current, int[] nums){
        if(current.size()==nums.length){
            res.add(new ArrayList<>(current));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(!current.contains(nums[i])){
                current.add(nums[i]);
                comb(current,nums);
                current.remove(current.size()-1);
            }
        }
    }
}