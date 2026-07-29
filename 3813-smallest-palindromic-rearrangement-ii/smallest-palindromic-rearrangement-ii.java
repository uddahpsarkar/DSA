class Solution {
    private static final int MAX_K = 1_000_001;

    public String smallestPalindrome(String s, int k) {
        int n = s.length();
        int halfLen = n / 2;

        // 1. Count frequencies of half the characters
        int[] halfFreq = new int[26];
        for (int i = 0; i < n; i++) {
            halfFreq[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            halfFreq[i] /= 2;
        }

        // 2. Check if total permutations < k
        if (countPermutations(halfFreq, halfLen) < k) {
            return "";
        }

        // 3. Build the left half character by character
        StringBuilder leftHalf = new StringBuilder();
        int remainingLen = halfLen;

        for (int i = 0; i < halfLen; i++) {
            for (int c = 0; c < 26; c++) {
                if (halfFreq[c] == 0) continue;

                // Temporarily place character c
                halfFreq[c]--;
                long count = countPermutations(halfFreq, remainingLen - 1);

                if (count >= k) {
                    leftHalf.append((char) ('a' + c));
                    remainingLen--;
                    break; // Fixed character at index i, move to index i+1
                } else {
                    k -= count;
                    halfFreq[c]++; // Backtrack
                }
            }
        }

        // 4. Construct the full palindrome
        StringBuilder result = new StringBuilder(leftHalf);
        if (n % 2 != 0) {
            result.append(s.charAt(halfLen)); // Middle character
        }
        result.append(new StringBuilder(leftHalf).reverse());

        return result.toString();
    }

    // Helper to calculate L! / (f1! * f2! * ... * f26!) capped at MAX_K
    private long countPermutations(int[] freq, int totalLen) {
        long count = 1;
        int currentLen = totalLen;

        for (int f : freq) {
            if (f == 0) continue;
            // Compute combinations C(currentLen, f)
            count = count * nCr(currentLen, f);
            if (count >= MAX_K) return MAX_K;
            currentLen -= f;
        }
        return count;
    }

    private long nCr(int n, int r) {
        if (r > n - r) r = n - r;
        long res = 1;
        for (int i = 1; i <= r; i++) {
            res = res * (n - r + i) / i;
            if (res >= MAX_K) return MAX_K;
        }
        return res;
    }
}