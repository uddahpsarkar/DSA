// class Solution {
//     public int stoneGameV(int[] stoneValue) {
//       int[] destination = Arrays.copyOf(stoneValue, stoneValue.length); 
// 	      int aliceTotalScore = 0; 
	      
// 	      while (destination.length > 1) { 
	           
//         int midpoint = destination.length / 2;
// 	    int[] firstHalf = Arrays.copyOfRange(destination, 0, midpoint);
// 	    int[] secondHalf = Arrays.copyOfRange(destination, midpoint, destination.length);
// 	    int sumFirst = 0;
	     
//         for (int stone : firstHalf) sumFirst += stone;

//         int sumSecond = 0;
//             for (int stone : secondHalf) sumSecond += stone;
//             if (sumFirst < sumSecond) {
//             //System.out.println("Bob throws away second half. Alice scores: " + sumFirst);
//             aliceTotalScore += sumFirst;
//             destination = firstHalf;
                
//             }else if (sumSecond < sumFirst) {
//             //System.out.println("Bob throws away first half. Alice scores: " + sumSecond);
//             aliceTotalScore += sumSecond;
//             destination = secondHalf;
                
//             }else { 
//             //System.out.println("Sums are equal! Alice takes first half and scores: " + sumFirst);
//             aliceTotalScore += sumFirst;
//             destination = firstHalf;
//             }
//         }
        
//         return aliceTotalScore; 
//     }
// }

class Solution {
    int[][] memo;
    int[] prefixSum;

    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        // memo[i][j] will store the max score for subarray from index i to j
        memo = new int[n][n];
        // prefixSum allows us to calculate the sum of any sub-array in O(1) time
        prefixSum = new int[n + 1];
        
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + stoneValue[i];
        }
        
        return solve(stoneValue, 0, n - 1);
    }

    private int solve(int[] stoneValue, int left, int right) {
        // Base case: If there's only 1 stone left, the game ends (score is 0)
        if (left == right) {
            return 0; 
        }
        
        // If we have already calculated the max score for this sub-array, return it
        if (memo[left][right] != 0) {
            return memo[left][right];
        }

        int maxScore = 0;
        
        // Try EVERY possible split point 'i' between the current left and right bounds
        for (int i = left; i < right; i++) {
            
            // Calculate sums using our prefix array
            int leftSum = prefixSum[i + 1] - prefixSum[left];
            int rightSum = prefixSum[right + 1] - prefixSum[i + 1];
            
            // Apply Bob's rules just like you did in your code!
            if (leftSum < rightSum) {
                // Bob throws away right, Alice keeps left
                maxScore = Math.max(maxScore, leftSum + solve(stoneValue, left, i));
            } else if (rightSum < leftSum) {
                // Bob throws away left, Alice keeps right
                maxScore = Math.max(maxScore, rightSum + solve(stoneValue, i + 1, right));
            } else {
                // Sums are equal, Alice decides which one to keep to maximize her score
                maxScore = Math.max(maxScore, Math.max(
                    leftSum + solve(stoneValue, left, i),
                    rightSum + solve(stoneValue, i + 1, right)
                ));
            }
        }
        
        // Save the result so we don't have to calculate this sub-array again
        memo[left][right] = maxScore;
        return maxScore;
    }
}