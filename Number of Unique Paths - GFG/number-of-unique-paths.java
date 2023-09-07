//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
	public static void main (String[] args) {
	    
	    //taking input using Scanner class
		Scanner sc=new Scanner(System.in);
		
		//taking total testcases
		int t=sc.nextInt();
		while(t-->0)
		{
		    //taking dimensions of the matrix
		    int a=sc.nextInt();
		    int b=sc.nextInt();
		    Solution ob = new Solution();
		    //calling method NumberOfPath()
		    System.out.println(ob.NumberOfPath(a,b));
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find total number of unique paths.
    public static int NumberOfPath(int a, int b) 
    {
        //Your code here
        int[][] dp = new int[a][b];

        // Initialize the leftmost column to 1 because there's only one way to reach any cell in the left column.
        for (int i = 0; i < a; i++) {
            dp[i][0] = 1;
        }

        // Initialize the top row to 1 because there's only one way to reach any cell in the top row.
        for (int j = 0; j < b; j++) {
            dp[0][j] = 1;
        }

        // Fill in the DP array using dynamic programming.
        for (int i = 1; i < a; i++) {
            for (int j = 1; j < b; j++) {
                // The number of unique paths to a cell is the sum of the paths from the cell above and the cell to the left.
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        // The value in the bottom-right cell represents the number of unique paths.
        return dp[a - 1][b - 1];
    }
}