class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Arrays.sort(nums);
        List<Integer> names = new ArrayList<>();
        int temp = nums[0] + 1;
        
        for (int i = 1; i < nums.length; i++) {
            while (temp < nums[i]) {
                names.add(temp);
                temp++;
            }
            temp = nums[i] + 1;
        }
        return names;
    }
}