//{ Driver Code Starts
//Initial Template for JAVA

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            
            int[] A = new int[N];
            
            for(int i=0 ; i<N ; i++){
                A[i] = Integer.parseInt(S[i]);
            }
            int target = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.findTargetSumWays(A,N, target));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int findTargetSumWays(int[] A , int N, int target) {
        // code here
        // Calculate the sum of all elements in the array
        int sum = 0;
        for(int x : A)
            sum += x;
        if(((sum - target) % 2 != 0) || (target > sum))
            return 0;
        
       
        int s2 = (sum - target)/2;
        int[][] t = new int[N + 1][s2 + 1];
        t[0][0] = 1;
        
        for(int i = 1; i < N + 1; i++) {
            for(int j = 0; j < s2 + 1; j++) {
                if(A[i - 1] <= j)
                    t[i][j] = t[i-1][j] + t[i - 1][j - A[i - 1]];
                else
                    t[i][j] = t[i - 1][j];
            }
        }
        return t[N][s2];
    }
}