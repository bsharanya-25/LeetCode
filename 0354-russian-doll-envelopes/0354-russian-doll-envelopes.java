class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        if(envelopes == null || n == 0){
            return 0;
        }

        Arrays.sort(envelopes, (a,b) ->{
            if(a[0] != b[0]){
                return a[0] - b[0];
            }else{
                return b[1] - a[1];
            }
        });

        int[] dp = new int[n];
        int len = 0 ;

        for(int[] envelope: envelopes){
            int index = Arrays.binarySearch(dp, 0, len, envelope[1]);
            if(index < 0){
                index =- (index+1);
            }

            dp[index] = envelope[1];
            if(index == len){
                len++;
            }
        }
    return len;
    }
}