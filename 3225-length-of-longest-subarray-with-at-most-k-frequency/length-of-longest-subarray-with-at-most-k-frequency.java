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
    //     if(nums.length <3){
    //         return k;
    //     }
    //     int[] array = new int[nums.length];
    //   int temp = nums[0];
    //   int ke = 0;

    //     for (int i = 0; i < nums.length; i++) {

    //         boolean present = false;

    //         for (int j = 0; j < ke; j++) {
    //             if (array[j] == nums[i]) {
    //                 present = true;
    //                 break;
    //             }
    //         }

    //         if (!present) {
    //             array[ke] = nums[i];
    //             ke++;
    //         }
           
    //     } 
         
    //     return ke*k;
    }
}