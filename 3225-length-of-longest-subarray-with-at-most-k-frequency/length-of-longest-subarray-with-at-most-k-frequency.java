class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < nums.length; right++) {
            int num = nums[right];
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
 
            while (countMap.get(num) > k) {
                countMap.put(nums[left], countMap.get(nums[left]) - 1);
                left++;
            }
 
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}