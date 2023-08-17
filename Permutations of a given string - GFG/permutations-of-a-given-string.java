//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            List<String> ans = obj.find_permutation(S);
            for( int i = 0; i < ans.size(); i++)
            {
                out.print(ans.get(i)+" ");
            }
            out.println();
                        
        }
        out.close();
	}
}


// } Driver Code Ends


class Solution {
     public List<String> find_permutation(String S) {
        Set<String> resultSet = new HashSet<>();
        generateUniquePermutationsHelper(S.toCharArray(), 0, resultSet);
        
        List<String> result = new ArrayList<>(resultSet);
        Collections.sort(result); // Sort the list of unique permutations
        return result;
    }

    private void generateUniquePermutationsHelper(char[] chars, int index, Set<String> resultSet) {
        if (index == chars.length - 1) {
            resultSet.add(new String(chars));
            return;
        }

        for (int i = index; i < chars.length; i++) {
            swap(chars, index, i);
            generateUniquePermutationsHelper(chars, index + 1, resultSet);
            swap(chars, index, i); // backtrack to the original state
        }
    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
