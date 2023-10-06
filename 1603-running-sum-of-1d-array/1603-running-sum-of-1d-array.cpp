class Solution {
public:
    vector<int> runningSum(vector<int>& nums) {
        vector<int> ans;
        for (int a = 0; a < nums.size(); a++) {
            int sum = 0;
            for (int b = 0; b <= a; b++) {
                sum += nums[b];
            }
            ans.push_back(sum);
        }
        return ans;
    }
};