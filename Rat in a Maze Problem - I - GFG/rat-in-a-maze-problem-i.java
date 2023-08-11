//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}

// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
    int [][] wayArr = new int[][]{{1,0},{0,-1},{0,1},{-1,0}}; // D->L->R->U
    String  dir[] = new String[]{"D","L","R","U"};
    public  ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        
        ArrayList<String> ans = new ArrayList<String>();
        int [] loc = new int[]{0,0};
        String way = "";
        int vis[][] = new int[n][n];
        findWay(loc, way, ans, vis, m, n);

        return ans;
    }
    void findWay(int[] loc, String way, ArrayList<String> ans, int[][] vis, int[][]m, int n){
        // base cases
        // If loc indexes are out of bound
        if(loc[0]>=n || loc[0] <0 || loc[1] >=n || loc[1] <0){
            return;
        }
        
        // reached on invalid loc 
        if(m[loc[0]][loc[1]] == 0){
            return;
        }
        
        // If reached destination
        if(loc[0] == n-1 && loc[1] == n-1){
            ans.add(new String(way));
            return;
        }
        
        // if reached a visited
        if(vis[loc[0]][loc[1]] == 1){
            return;
        }
        
        // mark a visit
        vis[loc[0]][loc[1]] = 1;
        
        for(int i = 0; i<4; i++){
            
            loc[0] += wayArr[i][0];
            loc[1] += wayArr[i][1];
            
            way = way+dir[i];
            findWay(loc, way, ans, vis, m, n);
            
            // Backtrack
            way = way.substring(0,way.length()-1);
            loc[0] -= wayArr[i][0];
            loc[1] -= wayArr[i][1];
        }
        // unmark visit
        vis[loc[0]][loc[1]] = 0;
        return;
    }
}